package com.fresh.controller.Gaction;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fresh.dao.GoodsDAO;
import com.fresh.dto.GoodsDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ModAction implements GoodsAction {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GoodsDAO dao = GoodsDAO.getInstance();
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		// 여기를 바꿔주면 다운받는 경로가 바뀜
		 String savePath = "./freshshop-master/upload";
		// 최대 업로드 파일 크기 5MB로 제한
		int uploadFileSizeLimit = 5 * 1024 * 1024;
		
		String encType = "UTF-8";
		 //ServletContext context = getServletContext();
		 //String uploadFilePath = context.getRealPath(savePath);
		String uploadFilePath = (String) request.getAttribute("file");
		System.out.println("서버상의 실제 디렉토리 :" + uploadFilePath);
		try {
			MultipartRequest multi = new MultipartRequest(request, // request 객체
					uploadFilePath, // 서버상의 실제 디렉토리
					uploadFileSizeLimit, // 최대 업로드 파일 크기
					encType, // 인코딩 방법
					// 동일한 이름이 존재하면 새로운 이름이 부여됨
					new DefaultFileRenamePolicy());
			// 업로드된 파일의 이름 얻기
			String fileName = multi.getFilesystemName("file");
			if (fileName == null) { 
				System.out.print("원래 파일 업로드");
				fileName = multi.getParameter("nonmakeImg");
			} 
			System.out.println("파일 이름 확인 : "+fileName);
			GoodsDTO dto = new GoodsDTO();
			dto.setNum(Integer.parseInt((multi.getParameter("num"))));
			dto.setName(multi.getParameter("name"));
			String nn = multi.getParameter("name");
			System.out.println("이름 : "+nn);
			dto.setType(multi.getParameter("type"));
			dto.setAmount(Integer.parseInt((multi.getParameter("amount"))));
			dto.setPrice(Integer.parseInt((multi.getParameter("price"))));
			dto.setOrigin(multi.getParameter("origin"));
			dto.setIntroduce(multi.getParameter("introduce"));
			dto.setImage(fileName);
			int result = dao.modOne(dto);
			if(result == 1) {
				String url = null;
				url = "./ManagerServlet?command=list";
				request.setAttribute("result_M", 1);
				RequestDispatcher dispatcher = request.getRequestDispatcher(url);
				dispatcher.forward(request, response);
			}else {
				String url = null;
				url = "./ManagerServlet?command=list";
				request.setAttribute("result_M", 2);
				RequestDispatcher dispatcher = request.getRequestDispatcher(url);
				dispatcher.forward(request, response);
			}
			
		} catch (Exception e) {
			System.out.print("예외 발생 : " + e);
		} 
		// new BoardListAction().execute(request, response);
	}
}

