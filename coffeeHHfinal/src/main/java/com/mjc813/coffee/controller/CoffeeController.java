package com.mjc813.coffee.controller;

import com.mjc813.coffee.dto.CoffeeDto;
import com.mjc813.coffee.dto.PagingDto;
import com.mjc813.coffee.service.CoffeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/coffee")
@RequiredArgsConstructor
public class CoffeeController {

    private final CoffeeService coffeeService;

    @GetMapping("/add")
    public String addView(Model model
                        , @RequestParam(value = "page", defaultValue = "1") Integer page
                        , @RequestParam(value = "rows", defaultValue = "5") Integer rows){
        model.addAttribute("page", page);
        model.addAttribute("rows", rows);
        return "coffee/add";
    }

    @PostMapping("/insert")
    public String insert(@ModelAttribute CoffeeDto coffeeDto
            , @RequestParam(value = "page", defaultValue = "1") Integer page
            , @RequestParam(value = "rows", defaultValue = "5") Integer rows){
        coffeeService.insert(coffeeDto);
        return "redirect:/coffee/list";
    }

    @GetMapping("/list")
    public String selectAll(Model model
    , @RequestParam(value = "page", defaultValue = "1") Integer page
    , @RequestParam(value = "rows", defaultValue = "5") Integer rows
    , @RequestParam(value = "keyWord", defaultValue = "") String keyWord){

        PagingDto pagingDto = new PagingDto(rows, page, 0, keyWord);
        if(rows < 1 || page < 1){
            pagingDto.setPage(1);
            pagingDto.setRows(5);
        }

        List<Integer> pageNum = new ArrayList<>();
        int totalPage = (int)(Math.ceil((double)coffeeService.count(pagingDto.getKeyWord()) / rows));
        Integer prev = pagingDto.getPage() > 1 ? pagingDto.getPage() - 1 : pagingDto.getPage();
        Integer next = pagingDto.getPage() < totalPage ? pagingDto.getPage() + 1 : totalPage;

        for (int i = 1; i <= totalPage; i++) {
            pageNum.add(i);
        }

        List<CoffeeDto> list = coffeeService.selectAll(pagingDto);

        model.addAttribute("prev", prev);
        model.addAttribute("next", next);
        model.addAttribute("pageNum", pageNum);
        model.addAttribute("pagingDto", pagingDto);
        model.addAttribute("list", list);
        return "coffee/list";
    }

    @GetMapping("/one")
    public String selectById(@RequestParam("id") Long id
    , @ModelAttribute PagingDto pagingDto
    , Model model){
        CoffeeDto coffeeDto = coffeeService.selectById(id);
        model.addAttribute("page", pagingDto.getPage());
        model.addAttribute("rows", pagingDto.getRows());
        model.addAttribute("item", coffeeDto);
        return "coffee/one";
    }

    @GetMapping("/modify")
    public String modify(@RequestParam("id") Long id
    , @ModelAttribute PagingDto pagingDto
    , Model model){
        CoffeeDto coffeeDto = coffeeService.selectById(id);
        model.addAttribute("page", pagingDto.getPage());
        model.addAttribute("rows", pagingDto.getRows());
        model.addAttribute("item", coffeeDto);
        return "coffee/modify";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute CoffeeDto coffeeDto
    , @ModelAttribute PagingDto pagingDto){
        coffeeService.update(coffeeDto);
        return "redirect:/coffee/one?id="+coffeeDto.getId()+"&page="+pagingDto.getPage()+"&rows="+pagingDto.getRows();
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute CoffeeDto coffeeDto
    , @ModelAttribute PagingDto pagingDto){
        coffeeService.delete(coffeeDto.getId());
        return "redirect:/coffee/list?page="+pagingDto.getPage()+"&rows="+pagingDto.getRows();
    }
}
