package com.example.demo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class MsgClient {
    private Date birthday;
    private String clientName;
    private String clientPhone;
    private String createBy;
    private String id;
    private String remark;
    private MsgClientGroup group;
}
