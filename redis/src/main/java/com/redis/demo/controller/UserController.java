package com.redis.demo.controller;


import com.redis.demo.entity.Muser;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@RestController
@RequestMapping("/redis")
public class UserController {

    @RequestMapping("/getUser")
    @Cacheable(value = "user-key")
    public Muser getUser(){
        Muser muser = new Muser("zhangsan", "zhangsan@email.com", "18");
        return muser;
    }

    @RequestMapping("/uid")
    public String uid (HttpSession session){
        UUID uid = (UUID) session.getAttribute("uid");
        System.out.println("uid = " + uid);
        if (uid == null){
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid",uid);
        return session.getId();
    }
}
