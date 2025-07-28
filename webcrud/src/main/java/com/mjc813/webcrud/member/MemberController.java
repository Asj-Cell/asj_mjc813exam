package com.mjc813.webcrud.member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/members/list")
    public String list(MemberDto memberDto, Model model) {
        List<MemberDto> arrayList = memberRepository.findAll(memberDto);
//        arrayList.add(new MemberDto("aaa1","bbb1","ccc1","ddd1"));
//        arrayList.add(new MemberDto("aaa2","bbb2","ccc2","ddd2"));
//        arrayList.add(new MemberDto("aaa3","bbb3","ccc3","ddd3"));
//        arrayList.add(new MemberDto("aaa4","bbb4","ccc4","ddd4"));
        model.addAttribute("list", arrayList);
        return "member/members";
    }


}
