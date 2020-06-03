package com.fresh.controller.Gaction;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fresh.dao.GoodsDAO;
import com.fresh.dto.GoodsDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ListAction implements GoodsAction {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		System.out.println("123456");
		GoodsDAO dao = GoodsDAO.getInstance();
		ArrayList<GoodsDTO> list = null;
		list = dao.selectAll();
		if (list != null) {
			url = "./freshshop-master/Manager/Mlist.jsp";
			request.setAttribute("list", list);
			System.out.println("이게 실행이 되야하는데");
		} else {
			url = "./freshshop-master/Manager/Mlist.jsp";
			request.setAttribute("chk", 1);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
