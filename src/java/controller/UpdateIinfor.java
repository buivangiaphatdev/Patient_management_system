/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Patient;
import model.PatientDAO;

/**
 *
 * @author PC
 */
public class UpdateIinfor extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int patientID = Integer.parseInt(request.getParameter("patientID"));
        String patientName = request.getParameter("patientname");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phone");
        String doctorName = request.getParameter("doctorName");
        String reaOfVisit = request.getParameter("rov");
        int room_no = Integer.parseInt(request.getParameter("roomNo"));
        int bed_no = Integer.parseInt(request.getParameter("bedNo"));
        String gender=request.getParameter("gender");
        int age = Integer.parseInt(request.getParameter("age"));
        String bGroup=request.getParameter("bgroup");
        String address = request.getParameter("add");
        String admit_date = request.getParameter("admit_date");
        String role = "patient";
        Patient up= new Patient(patientID, age, room_no, bed_no, patientName, gender, bGroup, phoneNumber, reaOfVisit, doctorName, email, address, role);
        PatientDAO.update(up);
        request.getRequestDispatcher("logout").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
     
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
