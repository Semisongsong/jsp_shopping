package com.fresh.controller.Saction;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fresh.dao.CartDAO;
import com.fresh.dto.CartDTO;

public class UpdateCartAction implements SAction {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		CartDAO dao = CartDAO.getInstance();
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("USER");
		String name = request.getParameter("name");
		System.out.println("상품이름"+name);
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println("번호 확인 : "+num);
		int amount = Integer.parseInt(request.getParameter("amount"));
		System.out.println("번호 확인 : "+amount);
		System.out.println(id);
			CartDTO dto = new CartDTO();
			dto.setId(id);
			dto.setNum(Integer.parseInt((request.getParameter("num"))));
			dto.setName(request.getParameter("name"));
			dto.setAmount(Integer.parseInt((request.getParameter("amount"))));
			dto.setPrice(Integer.parseInt((request.getParameter("price"))));
			int ok = dao.updatedup(dto);
			if (ok == 1) {
				url = null;
				url = "./ShoppingServlet?command=mycart";
				request.setAttribute("message_ok", 1);
				RequestDispatcher dispatcher = request.getRequestDispatcher(url);
				dispatcher.forward(request, response);
			} else {
				url = null;
				url = "./ShoppingServlet?command=mycart";
				request.setAttribute("message_ok", 2);
				RequestDispatcher dispatcher = request.getRequestDispatcher(url);
				dispatcher.forward(request, response);
			}
		}
	
}