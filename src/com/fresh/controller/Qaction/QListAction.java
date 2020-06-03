package com.fresh.controller.Qaction;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fresh.dao.QnaDAO;
import com.fresh.dto.QnaDTO;

public class QListAction implements QAction {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int num = Integer.parseInt(request.getParameter("num"));
		//String num= request.getParameter("num");
		//System.out.println("넘버 확인 : "+num);
		//HttpSession session = request.getSession();
		//String id = (String) session.getAttribute("USER");
		String url = null;
		
		
		QnaDAO dao = QnaDAO.getInstance();
		QnaDTO dto = new QnaDTO();
		ArrayList<QnaDTO> list = dao.AllList();
		if (list != null) {
			url = "./freshshop-master/QnA.jsp";
			request.setAttribute("list", list);
			System.out.println("리스트 있음!!!!");
		} else {
			url = "./freshshop-master/QnA.jsp";
			System.out.println("이게 실행이 되야하는데2");
			
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
