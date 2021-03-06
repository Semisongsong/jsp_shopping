package com.fresh.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fresh.controller.Qaction.QAction;

/**
 * Servlet implementation class QnAServlet
 */
@WebServlet("/QnAServlet")
public class QnAServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnAServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				String command = request.getParameter("command");
				System.out.println("QnAServlet에서 요청을 받음을 확인 : " + command);
				ActionFactoryQna af=ActionFactoryQna.getInstance();
				QAction action=af.getAction(command);
				if(action != null){
					System.out.println("여기니???");
				action.execute(request, response);
				}
			}

			/**
			 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
			 */
			protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// TODO Auto-generated method stub
				request.setCharacterEncoding("UTF-8");
				doGet(request, response);
			}

		}
