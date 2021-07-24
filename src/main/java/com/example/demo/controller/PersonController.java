package com.example.demo.controller;
import com.example.demo.Quary.PersonQuery;
import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller//控制跳转
@Slf4j
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/person")
    public String person(Model model, PersonQuery personQuery){
        PageInfo<Person> personPageInfo = personService.listPersonByName(personQuery);
        model.addAttribute("page",personPageInfo);
        return "person";
    }

    @PostMapping("/person")
    public String listPersonByName(Model model,PersonQuery personQuery){
        PageInfo<Person> personPageInfo = personService.listPersonByName(personQuery);
        model.addAttribute("page",personPageInfo);
        return "person";
    }

    @GetMapping("/peopledelete/{id}")
    public String peopledelete(@PathVariable("id") Integer id, RedirectAttributes attributes){
        boolean b = personService.deletePersonById(id);
        if(b){
            attributes.addFlashAttribute("message","删除团员成功");
            return "redirect:/person";
        }else {
            attributes.addFlashAttribute("message","删除团员失败");
            return "redirect:/person";
        }
    }

    @GetMapping("/peopleedit/{id}")
    public String toEditpeople(@PathVariable Integer id,Model model){
        Person person = personService.queryPersonById(id);
        System.out.println(person);
        model.addAttribute("person",person);
        return "editPerson";
    }

    @PostMapping("/peopleedit")
    public String editpeople(Person person,RedirectAttributes attributes){
        PersonQuery personQuery = new PersonQuery();
        Integer id = person.getId();
        log.info("person_id:"+id);
        personQuery.setName(person.getName());
        PageInfo<Person> personPageInfo = personService.listPersonByName(personQuery);
        if(id >0){
//            if(personPageInfo.getSize() == 0){
                boolean b = personService.updatePerson(person);
                if(b){
                    attributes.addFlashAttribute("message"," 更新团员成功");
                    return "redirect:/person";
                }else {
                    attributes.addFlashAttribute("message","更新团员失败");
                    return "redirect:/person";
                }
//            }else {
//                attributes.addFlashAttribute("message","该团员名已存在");
//                return "redirect:/person";
//            }
        }else {
//            if(personPageInfo.getSize() == 0){
                boolean b = personService.addPerson(person);
                if(b){
                    attributes.addFlashAttribute("message"," 新增团员成功");
                    return "redirect:/person";
                }else {
                    attributes.addFlashAttribute("message","新增团员失败");
                    return "redirect:/person";
                }
//            }else {
//                attributes.addFlashAttribute("message","该团员名已存在");
//                return "redirect:/person";
//            }
        }
    }

    @GetMapping("/updatepeople")
    public String toUpdatepeople(Model model){
        Person person = new Person();
        model.addAttribute("person",person);
        return "editPerson";
    }

}
