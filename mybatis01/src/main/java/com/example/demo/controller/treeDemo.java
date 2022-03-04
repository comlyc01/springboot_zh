package com.example.demo.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class treeDemo {

    public static void main(String[] args) {
        // 构建node列表
        List<TreeNode<String>> nodeList = CollUtil.newArrayList();

        nodeList.add(new TreeNode<>("1", "", "系统管理", 0));
        nodeList.add(new TreeNode<>("11", "1", "用户管理", 2));
        nodeList.add(new TreeNode<>("111", "11", "用户添加", 1));
        nodeList.add(new TreeNode<>("2", "", "店铺管理", 1));
        nodeList.add(new TreeNode<>("21", "2", "商品管理", 2));
        nodeList.add(new TreeNode<>("221", "2", "商品管理2", 2));

        // 0表示最顶层的id是0
        //List<Tree<String>> treeList = TreeUtil.build(nodeList, "");
        //配置
        TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
        // 自定义属性名 都要默认值的
        //treeNodeConfig.setWeightKey("order");
        //treeNodeConfig.setIdKey("rid");
        treeNodeConfig.setWeightKey("level");
        // 最大递归深度
        // treeNodeConfig.setDeep(3);

        //转换器
        List<Tree<String>> treeNodes = TreeUtil.build(nodeList, "", treeNodeConfig,
                (treeNode, tree) -> {
                    tree.setId(treeNode.getId());
                    tree.setParentId(treeNode.getParentId());
                    tree.setWeight(treeNode.getWeight());
                    tree.setName(treeNode.getName());
                });

        String s = JSON.toJSONString(treeNodes);
        System.out.println("treeNodes = " + s);

    }
}
