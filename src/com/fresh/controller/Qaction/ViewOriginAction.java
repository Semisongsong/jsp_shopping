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

public class ViewOriginAction implements QAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("헬로");
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("USER");
		String num = request.getParameter("num");
		System.out.println(id+ num);
		String url = null;
		
		QnaDAO dao = QnaDAO.getInstance();
		dao.updateReadCount(num);
		int k = dao.chkgrp(num);
		if(k==1) { //답글 있음
			QnaDTO dto =dao.selectOneqnaByNum(num);
			ArrayList<QnaDTO> list = dao.selectByGrp(num);
			System.out.println("확인중임///"+list);
			url = "./freshshop-master/QnAforAnswer2.jsp";
			request.setAttribute("list", list);
			request.setAttribute("dto", dto);
			
		}else {// 답글 없음.
			QnaDTO dto =dao.selectOneqnaByNum(num);
			url = "./freshshop-master/QnAforAnswer2.jsp";
			request.setAttribute("dto", dto);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		}
//		int result = dao.insertqna(dto);
//		if (result == 1) {
//			url = "./QnAServlet?command=list";
//			request.setAttribute("result", 1);
//			System.out.println("이게 실행이 되야하는데1");
//		} else {
//			url = "./freshshop-master/QnAquestion.jsp";
//			request.setAttribute("result", 2);
//			System.out.println("이게 실행이 되야하는데2");
//			
//		}
//		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
//		dispatcher.forward(request, response);
//	}

}