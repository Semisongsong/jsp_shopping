package com.fresh.controller.Qaction;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fresh.dao.QnaDAO;
import com.fresh.dto.QnaDTO;

public class OnlyForManager implements QAction {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("헬로");
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("USER");
		String num = request.getParameter("num");
		System.out.println(num);
		System.out.println(id + num);
		String url=null;
		QnaDAO dao = QnaDAO.getInstance();
		int ori = dao.chkorigin(num);
		if(ori ==1) {
			QnaDTO dto =dao.selectOneqnaByNum(num);
			url = "./freshshop-master/QnAforAnswer.jsp";
			request.setAttribute("dto", dto);
		}else {
			url = "./QnAServlet?command=list";
			request.setAttribute("msg_no", 1);
		}
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
//		QnaDTO dto = new QnaDTO();
//		dto.setTitle(request.getParameter("title"));
//		dto.setId(id);
//		dto.setContents(request.getParameter("contents"));
//
//		String url = null;
//
//		QnaDAO dao = QnaDAO.getInstance();
//		int r = dao.makefloor(num, dto);
//		if (r == 1) {
//			url = "./QnAServlet?command=list";
//			request.setAttribute("chk_m", 1);
//		}
//		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
//		dispatcher.forward(request, response);
//	}
}
