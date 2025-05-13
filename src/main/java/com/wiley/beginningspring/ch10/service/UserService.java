package com.wiley.beginningspring.ch10.service;

import com.wiley.beginningspring.ch10.model.User;
import org.springframework.cache.annotation.Cacheable;

import java.util.HashMap;
import java.util.Map;

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

}
