package com.fresh.controller.Maction;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fresh.dao.GuestDAO;

public class LogoutAction  implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String url = null;
		HttpSession session = request.getSession();
		//session.getAttribute("USER");
		session.invalidate();
		url = "./freshshop-master/index.jsp";
		request.setAttribute("message_O", "1");
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		


	}
} 


