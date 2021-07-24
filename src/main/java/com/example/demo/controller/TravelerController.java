package com.example.demo.controller;

import com.example.demo.Quary.TravelerQuary;
import com.example.demo.entity.Traveler;
import com.example.demo.service.TravelerService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TravelerController {

    @Autowired
    private TravelerService travelerService;

    @GetMapping("/")
    public String index(Model model, TravelerQuary travelerQuary){
        PageInfo<Traveler> travelerPageInfo=travelerService.listTravelerByname(travelerQuary);
        model.addAttribute("page",travelerPageInfo);
        return "index";
    }

    @PostMapping("/")
    public String listTravelerByName(Model model,TravelerQuary travelerQuary){
        PageInfo<Traveler> travelerPageInfo=travelerService.listTravelerByname(travelerQuary);
        model.addAttribute("page",travelerPageInfo);
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, RedirectAttributes attributes){
        boolean b=travelerService.deleteTravelerById(id);
        if(b){
            attributes.addFlashAttribute("message","删除活动成功");
            return "redirect:/";
        }else{
            attributes.addFlashAttribute("message","删除活动失败");
            return "redirect:/";
        }
    }

    @GetMapping("/edit/{id}")
    public String toedit(@PathVariable Integer id,Model model){
        model.addAttribute("traveler",travelerService.queryTravelerById(id));
        return "editTraveler";
    }

    @PostMapping("/edit")
    public String edit(Traveler traveler,RedirectAttributes attributes) {
        TravelerQuary travelerQuery = new TravelerQuary();
        Integer id = traveler.getId();
        travelerQuery.setName(traveler.getName());
        PageInfo<Traveler> travelerPageInfo = travelerService.listTravelerByname(travelerQuery);
        if(id !=null){
             if (travelerPageInfo.getSize() == 0) {
                 boolean b = travelerService.updateTraveler(traveler);
                 if (b) {
                     attributes.addFlashAttribute("message", "更新活动成功");
                     return "redirect:/";
                 } else {
                     attributes.addFlashAttribute("message", "更新活动失败");
                     return "redirect:/";
                 }
             }
             else{
                 attributes.addFlashAttribute("message","该活动名已存在");
                 return "redirect:/"+traveler.getId();
             }
         }
        else{
             if (travelerPageInfo.getSize() == 0) {
                 boolean b = travelerService.addTraveler(traveler);
                 if (b) {
                     attributes.addFlashAttribute("message", "新增活动成功");
                     return "redirect:/";
                 } else {
                     attributes.addFlashAttribute("message", "新增活动失败");
                     return "redirect:/";
                 }
             }
             else{
                 attributes.addFlashAttribute("message","该活动名已存在");
                 return "redirect:/";
             }
         }

    }

    @GetMapping("/update")
    public String toUpdate(Model model){
        Traveler traveler=new Traveler();
        model.addAttribute("traveler",traveler);
        return "editTraveler";
    }


}
