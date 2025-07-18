package com.mjc813.webcrud.member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    @Autowired
    MemberRepository memberRepository;


    @GetMapping("/member/")
    public String member() {
        return "member/index";
    }

    @GetMapping("/member/add")
    public String memberAdd() {
        return "member/add";
    }


    @PostMapping("/member/insert")
    public String memberInsert(@ModelAttribute MemberDto obj) {

//        System.out.printf("userId = %s\n",obj.getUserId());
//        System.out.printf("passwd = %s\n",obj.getPasswd());
//        System.out.printf("name = %s\n",obj.getName());
//        System.out.printf("nickName = %s\n",obj.getNickName());
        memberRepository.addMember(obj);

        return "redirect:/member/";

    }




}
