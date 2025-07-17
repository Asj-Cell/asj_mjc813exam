package com.example.demo.controller;

import com.example.demo.dto.ContactDto;
import com.example.demo.service.ContactRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    ContactRepository contactRepository;
    private ObjectMapper objectMapper = new ObjectMapper();


    @GetMapping("/add")
    public String addView(){
        return "contact/add";
    }

    @PostMapping("/addconfirm")
    public String addConfirm(@ModelAttribute ContactDto contact){
        System.out.println(contact.getContactFullInfo());
        contactRepository.insert(contact);
        return "redirect:/contact/listAll";
    }

    @GetMapping("/listAll")
    public String listView(Model model, @ModelAttribute ContactDto contact){
        List<ContactDto> contactDto = null;
        try{
            contactDto = contactRepository.selectAll(contact);
        }catch (Exception e){

        }
        model.addAttribute("list", contactDto);
        return "contact/list";
    }

    @GetMapping("/select/{id}")
    public String addViewById(Model model, @PathVariable Long id){
        ContactDto select = contactRepository.select(id);
        model.addAttribute("select", select);
        return "contact/select";
    }

    @GetMapping("/edit/{id}")
    public String editView(@PathVariable Long id, Model model) {
        ContactDto contact = contactRepository.select(id);
        model.addAttribute("contact", contact);
        return "contact/edit";  // 새로 만들 edit.html 뷰
    }

    @PostMapping("/editconfirm")
    public String editConfirm(@ModelAttribute ContactDto contact) {
        contactRepository.update(contact);
        return "redirect:/contact/listAll";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        contactRepository.delete(id);
        return "redirect:/contact/listAll";
    }

}