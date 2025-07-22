package com.mjc813.coffeecrud.coffee.controller;

import com.mjc813.coffeecrud.coffee.dto.CoffeeDto;
import com.mjc813.coffeecrud.coffee.service.CoffeeService;
import lombok.extern.slf4j.Slf4j; // Slf4j 어노테이션을 사용하려면 이 임포트가 필요합니다.
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Slf4j
public class CoffeeController {

    private final CoffeeService coffeeService;

    @Autowired
    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @GetMapping("/coffee/addview")
    public String addView(){
        return "coffee/addview";
    }

    @PostMapping("/coffee/insert")
    public String insert(@ModelAttribute CoffeeDto coffeeDto, RedirectAttributes redirectAttributes){
        try{
            coffeeService.insert(coffeeDto);
        } catch (Exception e){
            log.error("커피 정보 추가 중 오류 발생: {}", e.getMessage(), e);
        }
        return "redirect:/coffee/findAll";
    }

    @GetMapping("/coffee/findAll")
    public String findAll(Model model){
        List<CoffeeDto> all = coffeeService.findAll();
        model.addAttribute("list", all);
        return "coffee/list";
    }

    @GetMapping("/coffee/view")
    public String view(Model model, @RequestParam("id") Integer id) {
        try {
            CoffeeDto byId = coffeeService.findById(id);
            model.addAttribute("data", byId);
        } catch (Exception e) {
            log.error("커피 상세 정보 조회 중 오류 발생 (ID: {}): {}", id, e.getMessage(), e);
        }
        return "coffee/view";
    }

    @GetMapping("/coffee/editview/{id}")
    public String editView(Model model, @PathVariable("id") Integer id) {
        try {
            CoffeeDto byId = coffeeService.findById(id);
            if (byId == null) {
                log.warn("ID {}에 해당하는 커피 정보를 찾을 수 없습니다.", id);
                return "redirect:/coffee/findAll";
            }
            model.addAttribute("coffee", byId);
        } catch (Exception e) {
            log.error("커피 정보 수정 폼 로딩 중 오류 발생 (ID: {}): {}", id, e.getMessage(), e);
        }
        return "coffee/editview";
    }

    @PostMapping("/coffee/update")
    public String update(@ModelAttribute CoffeeDto coffeeDto, RedirectAttributes redirectAttributes){
        try {
            coffeeService.update(coffeeDto);
        } catch (Exception e){
            log.error("커피 정보 수정 중 오류 발생: {}", e.getMessage(), e);
        }
        return "redirect:/coffee/view?id=" + coffeeDto.getId();
    }

    @PostMapping("/coffee/delete") //
    public String delete(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes){
        try {

            CoffeeDto coffeeToDelete = new CoffeeDto();
            coffeeToDelete.setId(id);
            coffeeService.delete(coffeeToDelete);
        } catch (Exception e) {
            log.error("커피 정보 삭제 중 오류 발생 (ID: {}): {}", id, e.getMessage(), e);
        }
        return "redirect:/coffee/findAll";
    }
}