package com.example.demo.server.impl;


import com.example.demo.dao.MUserDao;
import com.example.demo.entity.Muser;
import com.example.demo.server.MUserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class MUserServerImpl implements MUserServer {

    @Resource
    private MUserDao mUserDao;


    /**
     * 插入数据
     *
     * @param muser
     * @return
     */
    @Override
    public int insert(Muser muser) {
        int insert = mUserDao.insert(muser);
        return insert;
    }

    /**
     * 删除数据
     *
     * @param muserId
     * @return
     */
    @Override
    public int deleteBatchIds(List muserId) {
        int ids = mUserDao.deleteBatchIds(muserId);
        return ids;
    }

    /**
     * 查询列表
     *
     * @return
     */
    @Override
    public List<Muser> queryList() {
        List<Muser> muserList = mUserDao.selectList(null);
        return muserList;
    }

    /**
     * 查询全部，xml
     *
     * @return
     */
    @Override
    public List<Muser> xmlQuery() {
        List<Muser> muserList = mUserDao.xmlQuery();
        return muserList;
    }


}
