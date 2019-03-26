package com.j2ee.homework.homework.tools;

/**
 * @program: restaurant
 * @Description:
 * @author: Mr.gao
 * @create: 2019-03-26 10:21
 * @email: 630268696@qq.com
 **/
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.regex.*;
public final class RegExpValidator {
    /**
     * @return 如果是符合邮箱格式的字符串,返回<b>true</b>,否则为<b>false</b>
     */
    public static boolean isEmail( String str ) {
        String regex = "\\w+@\\w+(\\.\\w{2,3})*\\.\\w{2,3}";
        return match( regex ,str );
    }
    /**
     * @return 如果是符合网址格式的字符串,返回<b>true</b>,否则为<b>false</b>
     */
    public static boolean isHomepage( String str ){
        String regex = "http://(([a-zA-z0-9]|-){1,}\\.){1,}[a-zA-z0-9]{1,}-*" ;
        return match( regex ,str );
    }
    /**
     * @param regex 正则表达式字符串
     * @param str   要匹配的字符串
     * @return 如果str 符合 regex的正则表达式格式,返回true, 否则返回 false;
     */
    private static boolean match( String regex ,String str ){
        Pattern pattern = Pattern.compile(regex);
        Matcher  matcher = pattern.matcher( str );
        return matcher.matches();
    }

//    public static void main(String[]args){
//        System.out.println(isEmail("646465825@qq.com"));
//        System.out.println(isEmail("55464fsa.cn"));
//    }

}
