package com.example.mail.contorller;

import com.example.mail.pojo.Message;
import com.example.mail.serivce.MailService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/mail")
public class MailController {
    @Resource
    private MailService mailService;

    @RequestMapping(value = "/sendMessage", method = RequestMethod.GET)
    public void sendMailMessage() {
        Message message = new Message();
        message.setMessageCode("MissingParameter");
        message.setMessageStatus("Failed");
        message.setCause("缺少参数,请确认");
        mailService.sendMessageMail(message, "测试消息通知", "message.ftl");
    }
}
