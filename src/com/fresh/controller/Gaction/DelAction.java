package com.fresh.controller.Gaction;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fresh.dao.GoodsDAO;
import com.fresh.dto.GoodsDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class DelAction implements GoodsAction {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		//String num= request.getParameter("num");
		System.out.println("넘버 확인 : "+num);
		String url = null;

		GoodsDAO dao = GoodsDAO.getInstance();
		int result=dao.delOne(num);
		if (result == 1) {
			url = "./ManagerServlet?command=list";
			request.setAttribute("result", 1);
			
			System.out.println("이게 실행이 되야하는데1");
		} else {
			url = "./ManagerServlet?command=list";
			request.setAttribute("result", 2);
			System.out.println("이게 실행이 되야하는데2");
			
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
