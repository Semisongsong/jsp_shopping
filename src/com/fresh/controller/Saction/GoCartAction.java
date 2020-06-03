package com.fresh.controller.Saction;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fresh.dao.CartDAO;
import com.fresh.dto.CartDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class GoCartAction implements SAction {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result = 0;
		CartDAO dao = CartDAO.getInstance();
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("USER");
		int gnum= Integer.parseInt((request.getParameter("num")));
		CartDTO chk = dao.searchdup(id, gnum);
		if(chk != null) {//업데이트문 실행
			CartDTO dto = new CartDTO();
			dto.setId(id);
			dto.setNum(Integer.parseInt((request.getParameter("num"))));
			dto.setName(request.getParameter("name"));
			if (Integer.parseInt(request.getParameter("abcd")) == 1) {
				int last = chk.getAmount()+Integer.parseInt((request.getParameter("amount")));
				dto.setAmount(last);
				System.out.println(last);
			} else {
				int last = chk.getAmount()+Integer.parseInt((request.getParameter("amount")));
				dto.setAmount(last);
				System.out.println(last);
			}
			dto.setPrice(Integer.parseInt((request.getParameter("price"))));
			int ok = dao.updatedup(dto);
			if(ok==1) {
				String url = null;
				url = "./ShoppingServlet?command=shop";
				request.setAttribute("message_ok", 1);
				RequestDispatcher dispatcher = request.getRequestDispatcher(url);
				dispatcher.forward(request, response);
			}else {
				String url = null;
				url = "./ShoppingServlet?command=shop";
				request.setAttribute("message_ok", 2);
				RequestDispatcher dispatcher = request.getRequestDispatcher(url);
				dispatcher.forward(request, response);
			}
		}
		else {
		CartDTO dto = new CartDTO();
		dto.setId(id);
		dto.setNum(Integer.parseInt((request.getParameter("num"))));
		dto.setName(request.getParameter("name"));
		if (Integer.parseInt(request.getParameter("abcd")) == 1) {
			dto.setAmount(Integer.parseInt((request.getParameter("amount"))));
		} else {
			dto.setAmount(Integer.parseInt((request.getParameter("amount"))));
		}
		dto.setPrice(Integer.parseInt((request.getParameter("price"))));
		result = dao.insertcart(dto);

		if (result == 1) { // 성공
			String url = null;
			url = "./ShoppingServlet?command=shop";
			request.setAttribute("message_C", 1);
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		} else {
			String url = null;
			url = "./ShoppingServlet?command=shop";
			request.setAttribute("message_C", 2);
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
		}
	}
}