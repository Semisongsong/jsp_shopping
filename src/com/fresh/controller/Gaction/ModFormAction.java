package com.fresh.controller.Gaction;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fresh.dao.GoodsDAO;
import com.fresh.dto.GoodsDTO;

public class ModFormAction implements GoodsAction {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		String url = null;
	
		GoodsDAO dao = GoodsDAO.getInstance();
		GoodsDTO dto = null;
		dto = dao.selOne(num);
		if (dto != null) {
			url = "/freshshop-master/Manager/modForm.jsp";
			request.setAttribute("dto", dto);
			System.out.println("이제 수정폼이 열릴 것이당!!");
		} else {
			url = "/freshshop-master/Manager/modForm.jsp";
			request.setAttribute("mmm", 1);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}