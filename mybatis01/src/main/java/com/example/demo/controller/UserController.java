package com.example.demo.controller;

import com.example.demo.entity.Muser;
import com.example.demo.server.MUserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Mapper CRUD 接口Demo
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private  MUserServer mUserServer;

    /**
     * 插入一条记录
     * @param muser
     * @return
     */
    @RequestMapping("/insert")
    public  Map insertDemo(Muser muser){
        HashMap<String, Object> map = new HashMap<>();
        int muserList = mUserServer.insert(muser);
        System.out.println("muserList = " + muserList);
        map.put("muserList",muserList);
        return map;
    }

    /**
     * 删除（根据ID 批量删除）
     * @param muserId
     * @return
     */
    @RequestMapping("/delete")
    public  Map deleteBatchIdsDemo(List muserId){
        HashMap<String, Object> map = new HashMap<>();
        int deleteCount = mUserServer.deleteBatchIds(muserId);
        map.put("delete",deleteCount);
        return map;
    }

    /**
     * 查询所有（BaseMapper）
     * @return
     */
    @RequestMapping("/query")
    public  Map eqQuery(){
        HashMap<String, Object> map = new HashMap<>();
        List<Muser> muserList = mUserServer.queryList();
        muserList.forEach(System.out::println);
        map.put("list",muserList);
        return map;
    }

    /**
     * 查询全部 （xml）
     * @return
     */
    @RequestMapping("/xmlQuery")
    public Map xmlQuery(){
        HashMap<String, Object> map = new HashMap<>();
        List<Muser> muserList = mUserServer.xmlQuery();
        muserList.forEach(System.out::println);
        map.put("list",muserList);
        return  map;
    }

}
