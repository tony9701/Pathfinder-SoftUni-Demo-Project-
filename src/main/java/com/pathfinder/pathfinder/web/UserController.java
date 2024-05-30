package com.pathfinder.pathfinder.web;

import com.pathfinder.pathfinder.service.dto.UserRegisterDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    @GetMapping("users/register")
    public String viewRegister(Model model) {
        model.addAttribute("userData", new UserRegisterDTO());

        return "register";
    }

    @PostMapping("users/register")
    public String doRegister(@Valid UserRegisterDTO userData,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userData", userData);

            return "register";
        }



        return "redirect:/users/login";
    }

    @GetMapping("users/login")
    public String userLogin() {

        return "login";
    }
}
