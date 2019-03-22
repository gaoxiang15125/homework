package com.j2ee.homework.homework.service;

import com.j2ee.homework.homework.HomeworkApplication;
import com.j2ee.homework.homework.entity.ClientUserEntity;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.StringWriter;

/**
 * @program: demo
 * @Description:
 * @author: Mr.gao
 * @create: 2019-03-12 12:05
 * @email: 630268696@qq.com
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {

    MailService mailService = new MailService();

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void sendSimpleMail() {
        mailService.sendSimpleMail("630268696@qq.com", "1165979001@qq.com", "测试邮件主题", "测试邮件内容");
    }

    @Test
    public void sendMailWithFile() {
        mailService.sendMailWithFile("630268696@qq.com", "1165979001@qq.com", "测试带文件邮件主题", "测试带文件邮件内容",
                new File("D:\\360Downloads\\春江花月夜.txt"));
    }

    @Test
    public void sendHtmlMail() {
        try {
            Configuration configuration = new Configuration(Configuration.VERSION_2_3_0);
            ClassLoader classLoader = HomeworkApplication.class.getClassLoader();
            configuration.setClassLoaderForTemplateLoading(classLoader, "ftl");
            Template template = configuration.getTemplate("mailtemplate.ftl");
            StringWriter mail = new StringWriter();
            ClientUserEntity clientUser = new ClientUserEntity("奥黛丽·赫本", "女", 10.0,"dasda");
            template.process(clientUser, mail);
            //将数据与界面通过代码关联到一起
            //System.out.println(mail.toString());
            mailService.sendHtmlMail("630268696@qq.com","测试邮件发送html主题", mail.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sendHtmlMailThymeleaf() {
        //你逗我呢，你跟我说这个比直接用模板简单？？我炒类啊
    }
}