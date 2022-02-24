package com.hospital.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.model.Patient;
import com.hospital.model.PatientDAO;

/**
 * Servlet implementation class AddPatientServlet
 */
//@WebServlet("/AddPatientServlet")
@WebServlet("/AddPatient")
public class AddPatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPatientServlet() {
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
		int count=0;
		int ptid=Integer.parseInt(request.getParameter("PetId"));
		String ptname=request.getParameter("PetName");
		String ptaddr=request.getParameter("PetAdd");
		//long phno=Long.parseLong(request.getParameter("phno"));
		int phno=Integer.parseInt(request.getParameter("PetNo"));
		Patient patient=new Patient();
		patient.setPatientid(ptid);
		patient.setName(ptname);
		patient.setAddress(ptaddr);
		patient.setPhone(phno);
		
		
		PatientDAO patientDAO=new PatientDAO();
		
		try {
			count= patientDAO.addPatient(patient);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (count>0) 
		{
			request.setAttribute("result","Patient Data saved succesfully !!!");
		}
		else
		{
			request.setAttribute("result","OOPS...!!!Error:Data is not saved");	
		}
		 RequestDispatcher rd=request.getRequestDispatcher("/AddPatient.jsp");
		 rd.forward(request, response);
		
		
	}

}