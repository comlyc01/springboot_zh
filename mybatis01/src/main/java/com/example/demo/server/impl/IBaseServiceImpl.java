package com.example.demo.server.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.IBaseMapper;
import com.example.demo.entity.Muser;
import com.example.demo.server.IBaseService;
import org.springframework.stereotype.Service;

@Service
public class IBaseServiceImpl extends ServiceImpl<IBaseMapper, Muser> implements IBaseService {


}
