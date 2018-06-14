package kh.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.web.beans.MessageDAO;
import kh.web.beans.MessageDTO;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {	
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		
		String command = requestURI.substring(contextPath.length());
		MessageDAO dao = new MessageDAO();
		if(command.equals("/input.do")) {
			String name = request.getParameter("name");
			String msg = request.getParameter("msg");
			
			int insert_result = dao.insertData(name, msg);
			request.setAttribute("result", insert_result);
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}else if(command.equals("/output.do")) {
			List<MessageDTO> select_result = dao.selectData();
			request.setAttribute("result", select_result);
			RequestDispatcher rd = request.getRequestDispatcher("outputView.jsp");
			rd.forward(request, response);
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
