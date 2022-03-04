package com.example.mail.pojo;

import lombok.Data;

@Data
public class Message {
    private String messageCode;
    private String messageStatus;
    private String cause;
}
