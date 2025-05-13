package com.wiley.beginningspring.ch10.service;

import com.wiley.beginningspring.ch10.model.User;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private Map<Integer, User> users = new HashMap<>();
    {
        users.put(1, new User(1, "Kenan", "5554332088", 37));
        users.put(2, new User(2, "Mert", "5552345060", 34));
    }

/*
    @Autowired
    private CacheManager cacheManager;

    @PostConstruct
    public void setup(){
        Cache usersCache = cacheManager.getCache("users");
        for (Integer key: users.keySet()){
            usersCache.put(key, users.get(key));
        }
    }
*/

    @Cacheable(value = "users", condition = "#user.age < 35")
    public User getUser(User user){
        System.out.println("User with id " + user.getId() + " requested");
        return users.get(user.getId());
    }

}
