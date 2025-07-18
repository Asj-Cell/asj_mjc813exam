package com.mjc813.webcrud.member;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    @GetMapping("/member/")
    public String member() {
        return "member/index";
    }

    @GetMapping("/member/add")
    public String memberAdd() {
        return "member/add";

    }




}
