package com.fresh.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fresh.controller.Gaction.GoodsAction;

/**
 * Servlet implementation class ManagerServlet
 */
@WebServlet("/ManagerServlet")
public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String command = request.getParameter("command");
		System.out.println("ManagerServlet에서 요청을 받음을 확인 : " + command);
		if(command.equals("insert")) {
			// 여기를 바꿔주면 다운받는 경로가 바뀜
			// 업로드 파일을 실제 서버의 저장할 디텍토리 위치
			String savePath = "./freshshop-master/upload"; //미리 파일 만들어 놓아야 합니다
			ServletContext context = getServletContext(); //실제 물리적인 디렉토리위치 
			String uploadFilePath = context.getRealPath(savePath);
			request.setAttribute("file", uploadFilePath);
			System.out.println(uploadFilePath + "컨트롤러");
		}else if(command.equals("mod")) {
			String savePath = "./freshshop-master/upload"; //미리 파일 만들어 놓아야 합니다
			ServletContext context = getServletContext(); //실제 물리적인 디렉토리위치 
			String uploadFilePath = context.getRealPath(savePath);
			request.setAttribute("file", uploadFilePath);
			request.setAttribute("nonmakeImg", uploadFilePath);
			System.out.println(uploadFilePath + "컨트롤러");
		}
		ActionFactoryManager af=ActionFactoryManager.getInstance();
		GoodsAction action=af.getAction(command);
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