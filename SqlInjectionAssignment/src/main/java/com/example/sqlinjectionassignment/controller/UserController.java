package com.example.sqlinjectionassignment.controller;

import com.example.sqlinjectionassignment.model.User;
import com.example.sqlinjectionassignment.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/loginunsafe/{firstName}/{password}")
    public User loginUnsafe(@PathVariable("firstName") String firstName,
                            @PathVariable("password") String password){
        return this.userService.loginUnsafe(firstName,password);
    }
    @GetMapping("/getbyidsafe/{firstName}/{password}")
    public User getSafeUserById(@PathVariable("firstName") String firstName,
                                @PathVariable("password") String password){
        return this.userService.loginSafe(firstName,password);
    }

    @GetMapping("/getbyidunsafe/{id}")
    public User getUnsafeUserById(@PathVariable("id") int id){
        return this.userService.getUnsafeUser(id);
    }
}
