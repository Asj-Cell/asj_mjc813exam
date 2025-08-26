package com.mjc813.swimming.swimpool;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

//    @GetMapping("/swimPool/")
//    public String member(HttpServletResponse response, HttpSession session) {
//        Cookie ck = new Cookie("myCookie","TestValue");
//        ck.setSecure(true);
//        ck.setMaxAge(60 * 3);
//        ck.setPath("/");
//        response.addCookie(ck);
//        return "swimpool/swimpools";
//    }

    @GetMapping("/swimpool/")
    public String swimpoolMenu(HttpServletRequest request
            , HttpServletResponse response
            , HttpSession session
    ) {
        Cookie[] cookies = request.getCookies();
        for ( Cookie cookie : cookies ) {
            System.out.println("read Cookie : " + cookie.getValue());
        }
        HttpSession httpSession = request.getSession();
        System.out.println("read HttpSession getMaxInactiveInterval : " + httpSession.getMaxInactiveInterval());
        System.out.println("read HttpSession : " + httpSession.getAttribute("mysession"));
        System.out.println("read httpSession : " + httpSession.getAttribute("mysession2"));
        System.out.println("read HttpSession : " + session.getAttribute("mysession"));
        System.out.println("read httpSession : " + session.getAttribute("mysession2"));
        return "/swimpool/swimpools";
    }

    @GetMapping("/members")
    public String memberMenu(HttpServletRequest request
            , HttpServletResponse response
            , HttpSession session
    ) {

        return "/swimpool/members";
    }















    @GetMapping("/makecookie")
    public String makecookie(HttpServletRequest request
            , HttpServletResponse response
            , HttpSession session
    ) {
        Cookie ck = new Cookie("mycookie", "Teacher");
        ck.setHttpOnly(true);
        ck.setSecure(true);
        ck.setMaxAge( 60 * 3 * 1 * 1 );
        ck.setPath("/");
        response.addCookie(ck);
        return "redirect:/";
    }

    @GetMapping("/deletecookie")
    public String deletecookie(HttpServletRequest request
            , HttpServletResponse response
            , HttpSession session
    ) {
        Cookie ck = new Cookie("mycookie", "");
        ck.setHttpOnly(true);
        ck.setSecure(true);
        ck.setMaxAge( 0 );
        ck.setPath("/");
        response.addCookie(ck);
        return "redirect:/";
    }

    @GetMapping("/makesession")
    public String makesession(HttpServletRequest request
            , HttpServletResponse response
            , HttpSession session
    ) {
        HttpSession httpSession = request.getSession();
        session.setAttribute("mysession", "Teacher");
        httpSession.setAttribute("mysession2", "Teacher2");
        return "redirect:/";
    }

    @GetMapping("/deletesession")
    public String deletesession(HttpServletRequest request
            , HttpServletResponse response
            , HttpSession session
    ) {
        session.invalidate();
        //HttpSession httpSession = request.getSession();
        //httpSession.invalidate();
        return "redirect:/";
    }
}


