package com.example.sqlinjectionassignment.repository;

import com.example.sqlinjectionassignment.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository {
    User loginUnsafe(String firstName, String password);
    User loginSafe(String firstName, String password);
    User getUnsafeUserById(int id);
    User getSafeUserById(int id);

}
