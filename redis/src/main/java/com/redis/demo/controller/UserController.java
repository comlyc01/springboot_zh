package com.redis.demo.controller;


import com.redis.demo.entity.Muser;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/redis")
public class UserController {

    @RequestMapping("/getUser")
    @Cacheable(value = "user-key")
    public Muser getUser() {
        Muser muser = new Muser("zhangsan", "zhangsan@email.com", "18");
        return muser;
    }

    @RequestMapping("/uid")
    public String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        System.out.println("uid = " + uid);
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }


    @PostMapping("/getSession")
    public Map<String ,String> getSession (HttpSession session) {
        Map<String, String> map = new HashMap<>(2);
        String id = session.getId();
        System.out.println("id = " + id);
        String uid = session.getAttribute("uid").toString();
        System.out.println("uid = " + uid);
        long creationTime = session.getCreationTime();
        long lastAccessedTime = session.getLastAccessedTime();
        System.out.println("lastAccessedTime = " + creationTime+" -- "+lastAccessedTime);

        map.put("id",id);
        map.put("uid",uid);
        map.put("creationTime",String.valueOf(creationTime));
        map.put("lastAccessedTime",String.valueOf(lastAccessedTime));
        return map;
    }

}
