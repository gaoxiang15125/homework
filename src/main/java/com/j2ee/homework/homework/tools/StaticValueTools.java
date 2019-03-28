package com.j2ee.homework.homework.tools;

/**
 * @program: restaurant
 * @Description:
 * @author: Mr.gao
 * @create: 2019-03-28 09:34
 * @email: 630268696@qq.com
 **/
public class StaticValueTools {

    //0标识正常订单 1标识完成订单 -1 标识已经超时的订单 2 标识正在配送订单
    public final static int normal = 0;
    public final static int finished =1;
    public final static int outTimeed = -1;
    public final static int sending = 2;
    public final static int waitForReady = -2;

}
