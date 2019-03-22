package com.j2ee.homework.homework.tools;

import com.j2ee.homework.homework.HomeworkApplication;
import com.j2ee.homework.homework.entity.ClientUserEntity;
import com.j2ee.homework.homework.service.MailService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.StringWriter;

/**
 * @program: restaurant
 * @Description:
 * @author: Mr.gao
 * @create: 2019-03-22 10:53
 * @email: 630268696@qq.com
 **/
public class EmailTools  {

    @Autowired
    MailService mailService;
    private static EmailTools emailTools = new EmailTools();

    public static EmailTools getInstance(){
        return emailTools;
    }

    private EmailTools(){

    }

    public boolean sendEmailForRegister(String toUser, ClientUserEntity clientUser){
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_0);
        ClassLoader classLoader = HomeworkApplication.class.getClassLoader();
        configuration.setClassLoaderForTemplateLoading(classLoader, "ftl");
        Template template = null;
        StringWriter mail = new StringWriter();
        try {
            template = configuration.getTemplate("mailtemplate.ftl");
            template.process(clientUser, mail);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        //将数据与界面通过代码关联到一起
        //System.out.println(mail.toString());
        mailService.sendHtmlMail(toUser, "欢迎注册仙客来餐饮网站", mail.toString());
        return true;
    }
}
