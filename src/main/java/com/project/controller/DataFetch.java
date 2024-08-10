package com.project.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.project.bean.EncapsulatedClass;
import com.project.dao.ExecuteQuery;

/**
 * Servlet implementation class DataFetch
 */
@WebServlet("/DataFetch")
public class DataFetch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataFetch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<EncapsulatedClass> li = ExecuteQuery.DataFetch();
        PrintWriter pw = response.getWriter();
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
        pw.print("<th>Update</th>");
        pw.print("<th>Delete</th>");
        pw.print("</tr>");
        pw.print("</thead>");
        pw.print("<tbody>");
        for (EncapsulatedClass en : li) {
            pw.print("<tr>");
            pw.print("<td>" + en.getId() + "</td>");
            pw.print("<td>" + en.getName() + "</td>");
            pw.print("<td>" + en.getEmail() + "</td>");
            pw.print("<td>" + en.getPassword() + "</td>");
            pw.print("<td><a href='UpdateServlet?id=" + en.getId() + "'>Update</a></td>");
            pw.print("<td><a href='DeleteServlet?id=" + en.getId() + "'>Delete</a></td>");
            pw.print("</tr>");
        }
        pw.print("</tbody>");
        pw.print("</table>");
        pw.print("</div>");
        pw.print("</body>");
        pw.print("</html>");
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
