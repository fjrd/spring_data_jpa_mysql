package com.example.demo.controllers;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getAllUsers(Model model){
        List users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "show_users";
    }

    @PostMapping("/users")
    public String addNewUser(@Valid User user, BindingResult result){
        if (result.hasErrors()) {
            return "add_edit_user";
        }
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("users/new")
    public String showAddUserForm(){
        return "add_edit_user";
    }

    @GetMapping("/users/{id}")
    public String getUserById(@PathVariable long id, Model model){
        List users = new ArrayList();
        users.add(userService.getUserById(id));
        model.addAttribute("users", users);
        return "show_users";
    }

    @PostMapping("/users/{id}")
    public String deleteUserById(@PathVariable long id){
        userService.deleteUserById(id);
        return "redirect:/users";
    }

    @GetMapping("/users/{id}/edit")
    public String showEditUserForm(@PathVariable long id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        return "add_edit_user";
    }


}
