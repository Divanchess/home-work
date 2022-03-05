package com.sbrf.reboot.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @GetMapping("/user")
    public String getMessage(@RequestParam(required = false, defaultValue = "") String name,
                                   Model model) {
        model.addAttribute("name", name);
        return "user";
    }
}
