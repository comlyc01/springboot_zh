package com.example.demo.server;

import com.example.demo.entity.Muser;
import java.util.List;

public interface MUserServer{

    int insert(Muser muser);

    int deleteBatchIds(List muserId);

    List<Muser> queryList();

    List<Muser> xmlQuery();

}
