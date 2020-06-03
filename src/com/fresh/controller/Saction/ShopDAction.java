package com.fresh.controller.Saction;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fresh.dao.GoodsDAO;
import com.fresh.dto.GoodsDTO;

public class ShopDAction implements SAction {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		String url = null;
		
		GoodsDAO dao = GoodsDAO.getInstance();
		GoodsDTO dto = dao.selOne(num);
		if (dto != null) {
			url = "/freshshop-master/shop-detail.jsp";
			request.setAttribute("dto", dto);
			System.out.println("이제 샵디테일이 열릴 것이당!!");
		} else {
			url = "/freshshop-master/shop-detail.jsp";
			request.setAttribute("mmm", 1);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}