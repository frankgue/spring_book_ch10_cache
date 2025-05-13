package com.wiley.beginningspring.ch10.service;

import com.wiley.beginningspring.ch10.model.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserService {

    private Map<Integer, User> users = new HashMap<>();
    {
        users.put(1, new User(1, "Kenan"));
        users.put(2, new User(2, "Mert"));
    }


    @Cacheable(value = "users")
    public User getUser(int id){
        System.out.println("User with id " + id + " requested");
        return users.get(id);
    }
    @Cacheable(value = "users", key = "#user.id")
    public User getUser(User user){
        System.out.println("User with id " + user.getId() + " requested");
        return users.get(user.getId());
    }

}
