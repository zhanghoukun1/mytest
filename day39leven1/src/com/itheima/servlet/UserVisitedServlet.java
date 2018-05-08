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
		//�õ�����ʱ��
		String  time  = new Timestamp(System.currentTimeMillis()).toString();
		//��������Cookie���ֽ�visitedTime��ֵ
		String  value   = CookieUtils.getCookieValue(request, "visitedTime");
		Cookie  userCookie = new  Cookie("visitedTime",time);
		//�ж�value�Ƿ�Ϊ��
		if (value==null) {
			//��Ӧ��ӡ��Ϣ
			out.print("���ã����ǵ�1�η��ʣ���ӭ���ļ��룡��ǰʱ���ǣ�"+time);
			//��Cookie���淢�͸��ͻ���
			
			response.addCookie(userCookie);
		} else {
			response.addCookie(userCookie);
			out.print("���ã���ӭ���ٴη��ʡ��ϴη��ʵ�ʱ���ǣ�"+value+"����ǰ��ʱ���ǣ�"+time);
		}
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	}

}
