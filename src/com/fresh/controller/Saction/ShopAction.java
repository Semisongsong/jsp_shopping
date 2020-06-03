package com.fresh.controller.Saction;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fresh.dao.GoodsDAO;
import com.fresh.dto.GoodsDTO;

public class ShopAction implements SAction {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		
		GoodsDAO dao = GoodsDAO.getInstance();
		ArrayList<GoodsDTO> list = dao.selectAll();
		if (list == null) {
			url = "./freshshop-master/shop.jsp";
			request.setAttribute("list", list);
		} else {
			url = "./freshshop-master/shop.jsp";
			request.setAttribute("list", list);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
