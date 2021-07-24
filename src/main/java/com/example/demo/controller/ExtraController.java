package com.example.demo.controller;

import com.example.demo.entity.Extra;
import com.example.demo.service.ExtraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@RestController
public class ExtraController {
    @Autowired
    private ExtraService extraservice;

    @GetMapping("/self")
    public ModelAndView index(){
        ModelAndView m = new ModelAndView("self");
        List<Extra> list = extraservice.listExtra();
        m.addObject("list",list);
        return m;
    }
}
