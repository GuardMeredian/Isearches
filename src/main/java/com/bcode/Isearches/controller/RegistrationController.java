package com.bcode.Isearches.controller;

import com.bcode.Isearches.domain.Role;
import com.bcode.Isearches.domain.User;
import com.bcode.Isearches.repos.UserRepo;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;
    @GetMapping("/registration")
    public String registration(){
        return  "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model){
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb !=null){
            model.put("message", "User exists!");
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);
        return "redirect:/login";

    }
}
