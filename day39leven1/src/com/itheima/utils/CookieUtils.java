package com.itheima.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtils {
    //获得请求指定的名字的Cookie对象
	public static String getCookieValue(HttpServletRequest  request,String name){
		//获得请求的Cookie对象
		Cookie  [] cookies   = request.getCookies();
		//先判断一下数组是否为空
	    if (cookies!=null) {
	    	//遍历客户请求段所有cookie对象
	    	for (Cookie cookie : cookies) {
				//判断是否客户是否有这个cooke对象
				if (cookie.getName().equals(name)) {
					return  cookie.getValue();
				} 
			}
		} 
	    
		return null;
		
	}
}
