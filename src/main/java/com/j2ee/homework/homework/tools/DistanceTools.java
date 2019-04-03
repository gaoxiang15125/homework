package com.j2ee.homework.homework.tools;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import springfox.documentation.spring.web.json.Json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
/**
 * @program: homework
 * @Description:
 * @author: Mr.gao
 * @create: 2019-04-02 09:25
 * @email: 630268696@qq.com
 **/
public class DistanceTools {

    public static String myKey = "d9ad474f89f307d1389654ca83ab1205";

    public static double getDistanceBetweenTwoAddress(String start,String end){
//        String start = "浙江省杭州市西湖区";
//        String end = "郑州市金水区";
        String startLonLat = getLonLat(start);
        String endLonLat = getLonLat(end);
        return getDistance(startLonLat,endLonLat);
    }

    private static String getLonLat(String address){
        //返回输入地址address的经纬度信息, 格式是 经度,纬度
        String queryUrl = "http://restapi.amap.com/v3/geocode/geo?key="+myKey+"&address="+address;
        String queryResult = getResponse(queryUrl);  //高德接品返回的是JSON格式的字符串
        System.out.println(queryResult);
        JSONObject jo = JSONObject.parseObject(queryResult);
        JSONArray ja = jo.getJSONArray("geocodes");
        return ja.getJSONObject(0).getString("location");
    }

    private static double getDistance(String startLonLat, String endLonLat){
        //返回起始地startAddr与目的地endAddr之间的距离，单位：米
        String queryUrl = "http://restapi.amap.com/v3/distance?key="+myKey+"&origins="+startLonLat+"&destination="+endLonLat+"&type=1";
        String queryResult = getResponse(queryUrl);
        JSONObject jo = JSONObject.parseObject(queryResult);
        JSONArray ja = jo.getJSONArray("results");
        double result = Double.parseDouble(ja.getJSONObject(0).getString("distance"));
        return result;
    }

    private static String getResponse(String serverUrl){
        //用JAVA发起http请求，并返回json格式的结果
        StringBuffer result = new StringBuffer();
        try {
            URL url = new URL(serverUrl);
            URLConnection conn = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line;
            while((line = in.readLine()) != null){
                result.append(line);
            }
            in.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    static String likekeyStr = "https://restapi.amap.com/v3/assistant/inputtips?key="+myKey+"&keywords=";
    public static JSONArray getRangeKeyWord(String likeKey){
        String finalStr = likekeyStr +likeKey;
        JSONObject jsonObject = JSONObject.parseObject(getResponse(finalStr));
        //System.out.println(jsonObject);
        if(jsonObject.getString("status").equals("1")){
            JSONObject resultJSON = JSONObject.parseObject(getResponse(finalStr));
            //System.out.println(resultJSON);
            JSONArray result = resultJSON.getJSONArray("tips");
            //System.out.println(result.size());
            return result;
        }else{
            return null;
        }

    }

//    public static void main(String[] args){
//        System.out.println(getRangeKeyWord("南京大学"));
//    }
}