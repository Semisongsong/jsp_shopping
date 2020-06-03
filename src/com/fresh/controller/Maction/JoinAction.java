package com.fresh.controller.Maction;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fresh.dao.GuestDAO;
import com.fresh.dto.GuestDTO;

public class JoinAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String id = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		String address = request.getParameter("address");
		String call1 = request.getParameter("phone1");
		String call2 = request.getParameter("phone2");
		String call3 = request.getParameter("phone3");
		String call = call1 + call2 + call3;
		System.out.println(call);

		GuestDAO gdao = GuestDAO.getInstance();
		int chkid = gdao.chkid(id);
		if (chkid == 1) {
			url = "./freshshop-master/join.jsp";
			request.setAttribute("message1", 1);
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
			System.out.println("이게 실행이 되야하는데");
			return;
		} else {
			GuestDTO bVo = new GuestDTO();
			bVo.setId(id);
			bVo.setPw(pwd);
			bVo.setName(name);
			bVo.setPhon(call);
			bVo.setAddress(address);
			bVo.setEmail(email);
			int result = gdao.insertGuest(bVo);
			if (result == 1) {
				url = "./freshshop-master/login.jsp";
				request.setAttribute("message_M", 1);
			} else {
				url = "./freshshop-master/join.jsp";
				request.setAttribute("message_M", "2");
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}

	}

}
