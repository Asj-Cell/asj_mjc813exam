package com.mjc813.swimming.swimpool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SwimPoolController {

    @GetMapping("/swimPool/")
    public String member() {
        return "swimpool/swimpools";
    }
}
