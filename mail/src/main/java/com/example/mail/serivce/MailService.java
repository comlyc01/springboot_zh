package com.example.mail.serivce;

import com.example.mail.pojo.Message;

public interface MailService {
    void sendMessageMail(Message params, String title, String templateName);
}
