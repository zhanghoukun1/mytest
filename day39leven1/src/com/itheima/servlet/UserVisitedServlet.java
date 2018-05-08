package com.itheima.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.utils.CookieUtils;

public class UserVisitedServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//得到当地时间
		String  time  = new Timestamp(System.currentTimeMillis()).toString();
		//获得浏览器Cookie名字叫visitedTime的值
		String  value   = CookieUtils.getCookieValue(request, "visitedTime");
		Cookie  userCookie = new  Cookie("visitedTime",time);
		//判断value是否为空
		if (value==null) {
			//响应打印信息
			out.print("您好，您是第1次访问，欢迎您的加入！当前时间是："+time);
			//把Cookie保存发送给客户端
			
			response.addCookie(userCookie);
		} else {
			response.addCookie(userCookie);
			out.print("您好，欢迎您再次访问。上次访问的时间是："+value+"，当前的时间是："+time);
		}
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	}

}
