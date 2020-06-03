package com.fresh.controller.Saction;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fresh.dao.CartDAO;
import com.fresh.dto.CartVDTO;

public class delCartAction implements SAction {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("USER");
		System.out.println(id);
		int num = Integer.parseInt(request.getParameter("num"));
		
		CartDAO cdao = CartDAO.getInstance();
		int list = cdao.delOne(id, num);
		if (list == 1) {// 장바구니 상품 삭제 성공
			url = "./ShoppingServlet?command=mycart";
			request.setAttribute("list", 1);
		} else { // 장바구니 상품 삭제 실패
			url = "./ShoppingServlet?command=mycart";
			request.setAttribute("list", 2);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}