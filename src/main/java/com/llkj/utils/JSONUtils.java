package com.llkj.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

//使用的工具包是jackson.jar (是现在框架中用的最频繁的一个转换包，框架中默认已经集成)
public class JSONUtils {
    //方法1：将json-》对象
    /**
     * 获取客户端传递的json类型的请求参数，并且转成JavaBean对象
     * @param request
     * @param tClass
     * @return
     */
    public static Object parseJsonToBean(HttpServletRequest request, Class<? extends Object> tClass) {
        //我们的请求体的数据就在BufferReader里面
        BufferedReader bufferedReader = null;
        try {
            //1. 获取请求参数:如果是普通类型的请求参数"name=value&name=value"那么就使用request.getXXX()
            //如果是json请求体的参数，则需要进行json解析才能获取
            bufferedReader = request.getReader();
            StringBuilder stringBuilder = new StringBuilder();
            String body = "";
            while ((body = bufferedReader.readLine()) != null) {
                stringBuilder.append(body);
            }
            //我们的目标:将json里面的数据封装到JavaBean里面:这就叫json解析
            ObjectMapper objectMapper = new ObjectMapper();
            Object Object = objectMapper.readValue(stringBuilder.toString(), tClass);
            return Object;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e.getMessage());
            }
        }
    }
    //方法2：将对象-》json
    /**
     * 将对象转成json字符串并且响应到客户端
     * @param response
     * @param object
     */
    public static void writeResult(HttpServletResponse response, Object object){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonStr = objectMapper.writeValueAsString(object);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(jsonStr);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
