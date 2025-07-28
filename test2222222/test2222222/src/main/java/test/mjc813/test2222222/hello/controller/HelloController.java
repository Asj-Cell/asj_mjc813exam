package test.mjc813.test2222222.hello.controller;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Controller
public class HelloController  {



    @GetMapping("/")
    public String hello(Model model) {
        LocalDateTime now = LocalDateTime.now();

        model.addAttribute("time", now);
        return "home";
    }


    @GetMapping("/mul")
    public String gugudan(@RequestParam(name = "gugudan")Integer gugudan,  Model model) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            result.add(gugudan+" * " + i + " = " + (gugudan * i));
        }

        model.addAttribute("result", result);
        return "gugudan";
    }

    @GetMapping("/test")
    public String gugudan(Model model) {
        String str = "<button class="+"my-button"+">"+"클릭</button>";
        model.addAttribute("str", str);
        return "test";
    }


}
