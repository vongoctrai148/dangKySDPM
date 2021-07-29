package com.doan1.doan1_quanlipm.controllers;

import com.doan1.doan1_quanlipm.entities.Users;
import com.doan1.doan1_quanlipm.forms.LoginForm;
import com.doan1.doan1_quanlipm.services.UserService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.Session;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String getLogin(Model model, HttpSession session){
        Users user = (Users) session.getAttribute("loginUser");
        if (user != null) {
            return "redirect:/SV/capnhatdkpm";
        }
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }
    @PostMapping("/login")
    public String postLogin(Model model, @Valid @ModelAttribute("loginForm") LoginForm loginForm, BindingResult bindingResult
    ,HttpSession session){
        if(bindingResult.hasErrors()) {
            model.addAttribute("error");
            return "redirect:/login";
        }
        String username = loginForm.getUsername();
        String passwords = loginForm.getPasswords();
        if(userService.findUserByUsernameAndPassword(username,passwords) == 1){
            Users user = userService.findUserByUsername(username);
            session.setAttribute("loginUser", user);
            if(("SV").equals(user.getRoles())){
                return "redirect:/SV/capnhatdkpm";
            } else if (("GV").equals(user.getRoles())) {
                return "redirect:/GV/capnhatdkpm";
                } else if (("NQL").equals(user.getRoles())){
                    return "redirect:/NQL/capnhatdkpm";
                    } else if (("ADMIN").equals(user.getRoles())){
                        return "redirect:/NQL/capnhatdkpm";
                        }
        }
        model.addAttribute("message", "Username or password is incorrect!");
        return "login";
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "/login";
    }
}
