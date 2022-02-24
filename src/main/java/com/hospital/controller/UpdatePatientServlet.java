package com.hospital.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.model.PatientDAO;

/**
 * Servlet implementation class UpdatePatientServlet
 */
@WebServlet("/UpdatePatient")
public class UpdatePatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePatientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		try{
			int petid=Integer.parseInt(request.getParameter("PetId"));
		
		String petname=request.getParameter("PetName");
		String petaddr=request.getParameter("PetAdd");
		long petphone=Long.parseLong(request.getParameter("PetNo"));
		PatientDAO pd=new PatientDAO();
		int u=pd.updatePatient(petid, petname,petaddr,petphone);
		PrintWriter out=response.getWriter();
		 if(u>0)
		 {
			 out.print("Patient updated Succesfully!!!");
			 
		 }
		 else
		 {
			 out.print("Patient does not exist");
		 }
		}
		catch(SQLException|ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
	}

}