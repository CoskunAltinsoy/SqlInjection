package com.example.sqlinjectionassignment.repository;

import com.example.sqlinjectionassignment.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User loginUnsafe(String firstName, String password) {
        String jql = "select u from User u where u.firstName ='"+firstName+"' and u.password = '"+password+"'";
        TypedQuery<User> userTypedQuery = entityManager.createQuery(jql, User.class);
        return userTypedQuery.getResultList().get(0);
    }

    @Override
    public User loginSafe(String firstName, String password) {
        String jql = "select u from User u where u.firstName = :firstName and u.password = :password";
        TypedQuery<User> userTypedQuery = entityManager.createQuery(jql, User.class)
                .setParameter("firstName",firstName).setParameter("password",password);
        return userTypedQuery.getResultList().get(0);
    }

    @Override
    public User getUnsafeUserById(int id) {
        String jql = "select u from User u where u.id ='" + id + "'";
        TypedQuery<User> userTypedQuery = entityManager.createQuery(jql, User.class);
        return userTypedQuery.getResultList().get(0);
    }

    @Override
    public User getSafeUserById(int id) {
        String jql = "select u from User u where u.id = :id";
        TypedQuery<User> userTypedQuery = entityManager.createQuery(jql,User.class).setParameter("id",id);
        return userTypedQuery.getResultList().get(0);
    }
}
