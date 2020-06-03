package com.fresh.controller.Qaction;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fresh.dao.QnaDAO;
import com.fresh.dto.QnaDTO;

public class MakefloorAction implements QAction {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("USER");
		int num = Integer.parseInt(request.getParameter("originnum"));
		String url = null;
		
		
		QnaDTO dto = new QnaDTO();
		dto.setTitle(request.getParameter("title"));
		dto.setId(id);
		dto.setContents(request.getParameter("contents"));


		QnaDAO dao = QnaDAO.getInstance();
		int r = dao.makefloor(num, dto);
		if (r == 1) {
			url = "./QnAServlet?command=list";
			request.setAttribute("chk_m", 1);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
