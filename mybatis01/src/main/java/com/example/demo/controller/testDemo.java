package com.example.demo.controller;

import lombok.var;

import java.io.Console;
import java.io.PrintWriter;
import java.util.*;

public class testDemo {
    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>(Arrays.asList("a", "a", "b", "c"));
        Set<String> stringSet = new HashSet<>(stringList);
        if (stringList.size() == stringSet.size()) {
            System.out.println("没有重复元素");
        } else {
            System.out.println("有重复元素");
        }

    }
}
