package com.mjc813.coffee.controller;

import com.mjc813.coffee.dto.CoffeeDto;
import com.mjc813.coffee.dto.PagingDto;
import com.mjc813.coffee.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/coffee")
public class CoffeeController {
    @Autowired
    CoffeeService coffeeService;

    @GetMapping("/add")
    public String addView(){
        return "coffee/add";
    }

    @PostMapping("/insert")
    public String insert(@ModelAttribute CoffeeDto coffeeDto){
        coffeeService.insert(coffeeDto);
        return "redirect:/coffee/list";
    }

    @GetMapping("/list")
    public String selectAll(Model model
    , @RequestParam(value = "page", defaultValue = "1") Integer page
    , @RequestParam(value = "rows", defaultValue = "5") Integer rows){

        PagingDto pagingDto = new PagingDto(rows, page, 0);

        List<Integer> pageNum = new ArrayList<>();
        int totalPage = (int)(Math.ceil((double)coffeeService.count() / rows));
        Integer prev = page > 1 ? page - 1 : page;
        Integer next = page < totalPage ? page + 1 : totalPage;

        for (int i = 1; i <= totalPage; i++) {
            pageNum.add(i);
        }

        List<CoffeeDto> list = coffeeService.selectAll(pagingDto);

        model.addAttribute("prev", prev);
        model.addAttribute("next", next);
        model.addAttribute("pageNum", pageNum);
        model.addAttribute("rows", rows);
        model.addAttribute("page", page);
        model.addAttribute("list", list);
        return "coffee/list";
    }

    @GetMapping("/one")
    public String selectById(@RequestParam("id") Long id
                            , Model model){
        CoffeeDto coffeeDto = coffeeService.selectById(id);
        model.addAttribute("item", coffeeDto);
        return "coffee/one";
    }

    @GetMapping("/modify")
    public String modify(@RequestParam("id") Long id
                        , Model model){
        CoffeeDto coffeeDto = coffeeService.selectById(id);
        model.addAttribute("item", coffeeDto);
        return "coffee/modify";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute CoffeeDto coffeeDto){
        coffeeService.update(coffeeDto);
        return "redirect:/coffee/one?id="+coffeeDto.getId();
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute CoffeeDto coffeeDto){
        coffeeService.delete(coffeeDto.getId());
        return "redirect:/coffee/list";
    }
}
