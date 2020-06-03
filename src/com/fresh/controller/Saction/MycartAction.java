package com.fresh.controller.Saction;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fresh.dao.CartDAO;
import com.fresh.dao.GoodsDAO;
import com.fresh.dto.CartDTO;
import com.fresh.dto.CartVDTO;
import com.fresh.dto.GoodsDTO;

public class MycartAction implements SAction {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("USER");
		System.out.println(id);
		
		//GoodsDAO dao = GoodsDAO.getInstance();
		CartDAO cdao = CartDAO.getInstance();
		ArrayList<CartVDTO> list = cdao.selectview(id);
		if (list == null) {// 장바구니에 아무것도 없음.
			url = "./freshshop-master/cart.jsp";
			request.setAttribute("list", list);
		} else { // 장바구니에 들어있음.
			url = "./freshshop-master/cart.jsp";
			request.setAttribute("list", list);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}