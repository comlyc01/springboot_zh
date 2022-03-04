package com.redis.demo.controller;

import java.util.*;
import java.util.stream.Collectors;

public class lamdbademo {
    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "a");
        map.put("age", 20);
        HashMap<String, Object> map1 = new HashMap<>();
        map1.put("name", "b");
        map1.put("age", 25);
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("name", "c");
        map2.put("age", 18);
        List<Map<String, Object>> mapList = Arrays.asList(map, map1, map2);
        // 筛选条件
        mapList.stream().filter(map3 -> (Integer) map3.get("age") >= 20).collect(Collectors.toList()).forEach(System.out::println);

        try {
            Thread.sleep(Long.parseLong("1000"));
            System.out.print("");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //年龄增加1
        mapList.stream().map(map3 -> {
            map3.put("age", (Integer) map3.get("age") + 1);
            return map3;
        }).collect(Collectors.toList()).forEach(System.out::println);

        // 判断年龄超过25
        boolean age = mapList.stream().anyMatch(map4 -> (Integer) map4.get("age") > 25);
        System.out.println("age = " + age);


    }
}
