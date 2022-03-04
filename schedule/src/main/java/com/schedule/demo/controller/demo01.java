package com.schedule.demo.controller;

import java.util.*;

public class demo01 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "a1");
        map.put("b", "b1");
        map.put("c", "c1");

        Set<String> strings = map.keySet();
        for (String string : strings) {
            System.out.println("string = " + string);
        }
    }
}
