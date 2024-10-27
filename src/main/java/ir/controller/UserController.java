package ir.controller;

import ir.model.entity.Role;
import ir.model.entity.User;
import ir.service.RoleService;
import ir.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
@Slf4j
public class UserController
{
    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String showForm(Model model)
    {
        model.addAttribute("user", new User());
        model.addAttribute("roleList", roleService.findAll());
        model.addAttribute("userList", userService.findAll());
        return "user";
    }

    @PostMapping()
    public String saveUser(User user, @ModelAttribute("roleName")Role.RoleName roleName)
    {
        Role role = roleService.findByRoleName(roleName);
        user.addRole(role);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
        log.info("User Saved...!");
        return "redirect:users";
    }

    @PutMapping()
    public String update(User user)
    {
        userService.update(user);
        log.info("User Updated...!");
        return "redirect:users";
    }

    @GetMapping("/{roleName}")
    public String findByRoleName(Model model, Role.RoleName roleName)
    {
        List<User> userList = userService.findByRoleName(roleName);
        model.addAttribute("userList", userList);
        return "redirect:users";
    }


    @DeleteMapping("/{username}")
    public String delete(@PathVariable("username") String username)
    {
        userService.delete(username);
        log.info("User Deleted...!");
        return "redirect:users";
    }

}