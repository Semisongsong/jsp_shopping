package com.fresh.controller.Qaction;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fresh.dao.QnaDAO;
import com.fresh.dto.QnaDTO;

public class MWriteAction implements QAction {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("USER");
		String url = null;
		
		
		QnaDAO dao = QnaDAO.getInstance();
		QnaDTO dto = new QnaDTO();
		dto.setTitle(request.getParameter("title"));
		dto.setId(id);
		dto.setContents(request.getParameter("contents"));
		int result = dao.insertqna(dto);
		if (result == 1) {
			url = "./QnAServlet?command=list";
			request.setAttribute("result", 1);
			System.out.println("이게 실행이 되야하는데1");
		} else {
			url = "./freshshop-master/QnAquestion.jsp";
			request.setAttribute("result", 2);
			System.out.println("이게 실행이 되야하는데2");
			
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
