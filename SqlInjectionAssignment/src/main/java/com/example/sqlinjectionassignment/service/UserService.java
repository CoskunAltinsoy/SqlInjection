package com.example.sqlinjectionassignment.service;

import com.example.sqlinjectionassignment.model.User;
import com.example.sqlinjectionassignment.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User loginUnsafe(String firstName, String password){
        return this.userRepository.loginUnsafe(firstName,password);
    }
    public User loginSafe(String firstName, String password){
        return this.userRepository.loginSafe(firstName,password);
    }
    public User getSafeUser(int id) {
        return this.userRepository.getSafeUserById(id);
    }
    public User getUnsafeUser(int id) {
        return this.userRepository.getUnsafeUserById(id);
    }
}
