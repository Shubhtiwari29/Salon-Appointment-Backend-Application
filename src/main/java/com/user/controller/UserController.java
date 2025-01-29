package com.user.controller;


import com.user.modal.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/api/users")
    public User getUSer(){
        User user = new User();
            user.setFullName("Ram");
            user.setEmail("ram@knoweverything.com");
            user.setPhone("108");
            user.setRole("customer");
            return user;
    }
}
