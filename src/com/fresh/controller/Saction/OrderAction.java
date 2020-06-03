package com.fresh.controller.Saction;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fresh.dao.BuyDAO;
import com.fresh.dao.CartDAO;
import com.fresh.dto.BuyDTO;
import com.fresh.dto.CartDTO;

public class OrderAction implements SAction {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		CartDAO dao = CartDAO.getInstance();
		BuyDAO bdao = BuyDAO.getInstance();
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("USER");
		System.out.println(id);
		String[] numlist = request.getParameterValues("chk[]");
		ArrayList<String> list = new ArrayList<>();
		list.add(id);
		for (int i = 0; i < numlist.length; i++) {
			list.add(numlist[i]);
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		ArrayList<CartDTO> clist = dao.selectcart(list);
		ArrayList<BuyDTO> blist = new ArrayList<>();
		for (int i = 0; i < clist.size(); i++) {
			System.out.println(clist.get(i));
			System.out.println("상품이름 : " + clist.get(i).getName());
			BuyDTO bdto = new BuyDTO();
			bdto.setId(id);
			bdto.setProductnum(clist.get(i).getNum());
			bdto.setName(clist.get(i).getName());
			bdto.setAmount(clist.get(i).getAmount());
			bdto.setPrice(clist.get(i).getPrice());
			blist.add(bdto);
		}
		for (int i = 0; i < blist.size(); i++) {
			System.out.println(blist.get(i).getName());
		}
		int ok =bdao.insertbuy(blist);
			if (ok == 1) {
				int chk = dao.delcart(list);
				if(chk==1) {
				url = "./ShoppingServlet?command=mycart";
				request.setAttribute("message_order", 1);
				RequestDispatcher dispatcher = request.getRequestDispatcher(url);
				dispatcher.forward(request, response);
				}
			} else {
				url = null;
				url = "./ShoppingServlet?command=mycart";
				request.setAttribute("message_order", 2);
				RequestDispatcher dispatcher = request.getRequestDispatcher(url);
				dispatcher.forward(request, response);
			}
	}

}
