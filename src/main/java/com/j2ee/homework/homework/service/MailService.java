package com.j2ee.homework.homework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @program: demo
 * @Description:
 * @author: Mr.gao
 * @create: 2019-03-12 11:46
 * @email: 630268696@qq.com
 **/
@Component
@PropertySource("classpath:test.properties")
public class MailService {

    @Autowired
    JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String fromUser;

    MimeMessage mimeMessage;
    MimeMessageHelper mimeMessageHelper;

    public boolean sendSimpleMail(String toUser, String copyUser, String subject, String content) {
        return sendMailWithFile(toUser, copyUser, subject, content, null);
    }

    public boolean sendMailWithFile(String toUser, String copyUser, String subject, String content, File file) {
        try {
            mimeMessage = javaMailSender.createMimeMessage();
            if (file == null) {
                mimeMessageHelper = new MimeMessageHelper(mimeMessage, false);
            } else {
                mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            }
            mimeMessageHelper.setFrom(fromUser);
            mimeMessageHelper.setTo(toUser);
            mimeMessageHelper.setCc(copyUser);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(content);
            if (file != null) {
                mimeMessageHelper.addAttachment(file.getName(), file);
            }
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void sendHtmlMail(String toUser,String subject, String content) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true);
            mimeMessageHelper.setFrom(fromUser);
            mimeMessageHelper.setTo(toUser);
            mimeMessageHelper.setCc(fromUser);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(content, true);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            System.out.println("发送邮件：content");
            e.printStackTrace();
        }
    }
}
