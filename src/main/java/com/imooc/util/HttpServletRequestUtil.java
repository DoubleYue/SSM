package com.imooc.util;

import javax.servlet.http.HttpServletRequest;

/**
 * Desciption:
 *  将request中的值转为指定类型
 * @author yxl
 * @date 2019/1/8 13:55
 */
public class HttpServletRequestUtil {

    public static Integer getInt(HttpServletRequest request, String key) {
        try {
            return Integer.decode(request.getParameter(key));
        } catch (Exception e) {
            return -1;
        }
    }

    public static Long getLong(HttpServletRequest request, String key) {
        try {
            return Long.valueOf(request.getParameter(key));
        } catch (Exception e) {
            return -1L;
        }
    }
    public static Double getDouble(HttpServletRequest request, String key) {
        try {
            return Double.valueOf(request.getParameter(key));
        } catch (Exception e) {
            return -1d;
        }
    }

    public static Boolean getBoolean(HttpServletRequest request, String key) {
        try {
            return Boolean.valueOf(request.getParameter(key));
        } catch (Exception e) {
            return false;
        }
    }
    public static String getString(HttpServletRequest request, String key) {
        try {
            String result = request.getParameter(key);
            if(result!=null){
                result = result.trim();
            }
            if("".equals(result)){
                return null;
            }
            return result;
        } catch (Exception e) {
            return null;
        }
    }
}