package com.imooc.util;

import com.google.code.kaptcha.Constants;

import javax.servlet.http.HttpServletRequest;

/**
 * Desciption:
 *  检验输入的验证码是否正确
 * @author yxl
 * @date 2019/1/9 16:05
 */
public class CodeUtil {
    public static boolean checkVertifyCode(HttpServletRequest request){
        //获取自动生成的验证码
        String vertifyCodeExpected = (String)request.getSession()
                .getAttribute(Constants.KAPTCHA_SESSION_KEY);
        //用户提交的验证码
        String verifyCodeActual = HttpServletRequestUtil.getString(request,"verifyCodeActual");

        if(verifyCodeActual==null||!verifyCodeActual.equals(vertifyCodeExpected)){
            return false;
        }
        return  true;
    }
}
