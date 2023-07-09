/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.doctor.Doctor;
import model.doctor.DoctorDAO;

/**
 *
 * @author PC
 */
public class CreateDoctor extends HttpServlet {

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
        String docName = request.getParameter("docName");
        String email = request.getParameter("email");
        String password = request.getParameter("pass");
        String phoneNumber = request.getParameter("phone");
        String address = request.getParameter("add");
        String department = request.getParameter("dept");
        String role = "doctor";

        Doctor doc = new Doctor(docName, email, password, address, phoneNumber, department, role);
        Doctor doctor = DoctorDAO.createDoctor(doc);
        HttpSession session = request.getSession();
        if (doctor != null) {
            //List<Appointment> list = (List<Appointment>)session.getAttribute("list");
            if(session.getAttribute("docs")==null){
                List<Doctor> docs = new ArrayList<>();
                docs.add(doctor);
                session.setAttribute("docs", docs);
            }
            else{
                List<Doctor> docs = (List<Doctor>)session.getAttribute("docs");
                docs.add(doctor);
                session.setAttribute("docs", docs);
            }
        }
        response.sendRedirect("DoctorPaging");
         //request.getRequestDispatcher("doctorList.jsp").forward(request, response);
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
