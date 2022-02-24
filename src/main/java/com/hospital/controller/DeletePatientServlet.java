package com.hospital.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.model.Patient;
import com.hospital.model.PatientDAO;

/**
 * Servlet implementation class DeletePatientServlet
 */
@WebServlet("/DeletePatient")
public class DeletePatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePatientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
		int ID=Integer.parseInt(request.getParameter("t1"));
		PatientDAO pd=new PatientDAO();
	
		int d=pd.deletePatient(ID);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		if(d>0)
		{
		out.println("Patient Deleted Succesfully !!!");
		}
		else
		{
			out.println("Patient does not exist.");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
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