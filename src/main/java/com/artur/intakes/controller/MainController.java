package com.artur.intakes.controller;

import com.artur.intakes.model.User;
import com.artur.intakes.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
public class MainController {

    @Autowired
    private UserRepository userRepository;
    // http://localhost:8080/users/addUser
    @PostMapping(path = "/addUser")
    public @ResponseBody
        //>>3.
    String addNewUser(@RequestParam String name, @RequestParam String email) {

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return "new user saved";
    }

//    http://localhost:8080/users/allUsers
    @GetMapping(path = "/allUsers")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}


