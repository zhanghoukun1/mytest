package com.itheima.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtils {
    //�������ָ�������ֵ�Cookie����
	public static String getCookieValue(HttpServletRequest  request,String name){
		//��������Cookie����
		Cookie  [] cookies   = request.getCookies();
		//���ж�һ�������Ƿ�Ϊ��
	    if (cookies!=null) {
	    	//�����ͻ����������cookie����
	    	for (Cookie cookie : cookies) {
				//�ж��Ƿ�ͻ��Ƿ������cooke����
				if (cookie.getName().equals(name)) {
					return  cookie.getValue();
				} 
			}
		} 
	    
		return null;
		
	}
}
