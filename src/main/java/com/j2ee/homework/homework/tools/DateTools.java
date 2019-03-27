package com.j2ee.homework.homework.tools;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @program: restaurant
 * @Description:
 * @author: Mr.gao
 * @create: 2019-03-27 08:52
 * @email: 630268696@qq.com
 **/
public class DateTools {

    public static DateFormat dateFormatwithSecound = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //此处时间被多次调用时，会发生累计错误，需要进行修改
    public static Calendar c = Calendar.getInstance();

    public static Date changeDateMouth(Date date){
        c.setTime(date);
        c.add(Calendar.MONTH, +1);
        return c.getTime();
    }

    public static void main(String[]args){
        Date date = new Date();
        System.out.println(changeDateMouth(date));
        System.out.println(new Timestamp(date.getTime()));
        System.out.println(new Timestamp(changeDateMouth(date).getTime()));
    }
}
