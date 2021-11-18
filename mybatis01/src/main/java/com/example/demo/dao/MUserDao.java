package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Muser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MUserDao extends BaseMapper<Muser> {
    // 查询全部
    List<Muser> xmlQuery();

}
