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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        
        int id = Integer.parseInt(request.getParameter("id"));
        EncapsulatedClass en = ExecuteQuery.isUpdated(id);
        
        pw.println("<!DOCTYPE html>");
        pw.println("<html lang='en'>");
        pw.println("<head>");
        pw.println("<meta charset='UTF-8'>");
        pw.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        pw.println("<title>Edit Student Information</title>");
        pw.println("<link rel='stylesheet' href='css/update.css'>");
        pw.println("</head>");
        pw.println("<body>");
        pw.println("<div class='content'>");
        pw.println("<h1>Edit Student Information</h1>");
        pw.println("<form action='EditServlet' method=post>");
        pw.println("<input type='hidden' name='id' value='" + en.getId() + "'>");
        pw.println("<label for='name'>Name:</label>");
        pw.println("<input type='text' id='name' name='name' value='" + en.getName() + "' required><br><br>");
        pw.println("<label for='email'>Email:</label>");
        pw.println("<input type='email' id='email' name='email' value='" + en.getEmail() + "' required><br><br>");
        pw.println("<label for='password'>Password:</label>");
        pw.println("<input type='password' id='password' name='password' value='" + en.getPassword() + "' required><br><br>");
        pw.println("<input type='submit' value='Submit'>");
        pw.println("</form>");
        pw.println("</div>");
        pw.println("</body>");
        pw.println("</html>");
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
