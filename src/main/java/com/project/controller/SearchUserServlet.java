package com.project.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.project.bean.EncapsulatedClass;
import com.project.dao.ExecuteQuery;

/**
 * Servlet implementation class SearchUserServlet
 */
@WebServlet("/SearchUserServlet")
public class SearchUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stu
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String name = request.getParameter("name");
		EncapsulatedClass en = ExecuteQuery.isSerched(name);
		 if(en!=null)
		 {
				pw.print("<!DOCTYPE html>");
		        pw.print("<html>");
		        pw.print("<head>");
		        pw.print("<meta charset='UTF-8'>");
		        pw.print("<title>Data Fetch</title>");
		        pw.print("<link rel='stylesheet' type='text/css' href='css/tabular.css'>");
		        pw.print("</head>");
		        pw.print("<body>");
		        pw.print("<div class='container'>");
		        pw.print("<h1>Student Data</h1>");
		        pw.print("<table>");
		        pw.print("<thead>");
		        pw.print("<tr>");
		        pw.print("<th>Id</th>");
		        pw.print("<th>Name</th>");
		        pw.print("<th>Email</th>");
		        pw.print("<th>Password</th>");
		        pw.print("</tr>");
		        pw.print("</thead>");
		        pw.print("<tbody>");
		        pw.print("<tr>");
		        pw.print("<td>" + en.getId() + "</td>");
		        pw.print("<td>" + en.getName() + "</td>");
		        pw.print("<td>" + en.getEmail() + "</td>");
		        pw.print("<td>" + en.getPassword() + "</td>");
		        pw.print("</tr>");
		        pw.print("</tbody>");
		        pw.print("</table>");
		        pw.print("</div>");
		        pw.print("</body>");
		        pw.print("</html>");
		 }
		 else
		 {
			 pw.print("<script>alert(No User Found...!')</script>");
		 }
	    

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
