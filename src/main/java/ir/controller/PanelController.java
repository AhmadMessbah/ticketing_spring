package ir.controller;

import ir.model.entity.Role;
import ir.model.entity.User;
import ir.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Slf4j
@Controller
@RequestMapping("/panel")
public class PanelController {

    private final UserService userService;

    public PanelController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String panel(Model model) {
        return "index";
    }
//    public String redirectToPanel(Model model, Principal principal) {
//
//        System.out.println("panel .....");
//
//        User user = userService.findByUsername(principal.getName());
//        if (user == null) {
//            return "redirect:/users";
//        } else if (user.getRoleSet().stream().anyMatch(role -> role.getName().equals("ADMIN"))) {
//            return "redirect:/admins";
//        } else if (user.getRoleSet().stream().anyMatch(role -> role.getName().equals("CUSTOMER"))) {
//            return "redirect:/customers";
//        }
//        return "index"; //"redirect:/login?error=role_not_found";
//    }

}
