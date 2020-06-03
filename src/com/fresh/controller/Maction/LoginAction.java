package com.fresh.controller.Maction;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fresh.dao.CartDAO;
import com.fresh.dao.GuestDAO;

public class LoginAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String path = request.getContextPath();

		GuestDAO gdao = GuestDAO.getInstance();
		int result = gdao.loginchk(id, pwd);
		if (result == -1) {// 로그인불가능
			url = "./freshshop-master/login.jsp";
			request.setAttribute("message_L", "-1");
		} else if (result == 1) {// 회원 로그인가능
			CartDAO dao = CartDAO.getInstance();
			int r = dao.countcart(id);
			if(r>0) {
				request.setAttribute("countcart", r);
			}
			url = "./freshshop-master/index.jsp";
			request.setAttribute("message_L", "1");
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("USER", id);
		}else if (result == 5) {// 관리자 로그인가능
			url = "./freshshop-master/Manager/index_for_manager.jsp";
			request.setAttribute("message_L", "5");
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("USER", id);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}