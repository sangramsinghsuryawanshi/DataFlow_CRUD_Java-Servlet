package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.project.bean.EncapsulatedClass;
import com.project.dao.ExecuteQuery;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletClient
 */
@WebServlet("/ServletClient")
public class ServletClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		EncapsulatedClass ei = new EncapsulatedClass();
		ei.setId(id);
		ei.setName(name);
		ei.setEmail(email);
		ei.setPassword(password);
		int status = ExecuteQuery.isInsert(ei);
		 if (status != 0) 
		 {
	            pw.print("<script>alert('Data Inserted Successfully...');window.location.replace('Insertion.html');</script>");
	     } 
		 else 
		 {
			 pw.print("<script>alert('Data Not Inserted...!');window.location.replace('Insertion.html');</script>");
	     }
	}

}
