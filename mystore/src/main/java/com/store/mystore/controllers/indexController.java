package com.store.mystore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {
    @RequestMapping("/")
    String index(
            Model model
    ) {
        model.addAttribute("id", 1);
        return "index";

    }
}
