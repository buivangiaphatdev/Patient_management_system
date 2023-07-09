/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.doctor;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.admin.AdminDAO;
import model.doctor.Doctor;
import model.doctor.DoctorDAO;

/**
 *
 * @author PC
 */
@WebServlet(name = "updatedoctor", urlPatterns = {"/updatedoctor"})
public class updatedoctor extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet updatedoctor</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet updatedoctor at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
       // processRequest(request, response);
       int pid = Integer.parseInt(request.getParameter("pid"));
        Doctor doctor = (Doctor) new DoctorDAO().getDoctor(pid);
        request.setAttribute("doctor", doctor);
        request.getRequestDispatcher("updateDoctor.jsp").forward(request, response);
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
        //processRequest(request, response);
        int docid = Integer.parseInt(request.getParameter("docID"));
        String name = request.getParameter("docName");
        String email = request.getParameter("email");
        String password=request.getParameter("pass");
        String address = request.getParameter("add");
        String phone = request.getParameter("phone");
        String dept = request.getParameter("dept");
        String role = "doctor";

        Doctor doctorU = new Doctor();
        doctorU.setDocID(docid);
        doctorU.setDocName(name);
        doctorU.setEmail(email);
        doctorU.setPassword(password);
        doctorU.setAddress(address);
        doctorU.setPhoneNumber(phone);
        doctorU.setDepartName(dept);
        doctorU.setRole(role);
        Doctor newDoctor = AdminDAO.adminUpDoctor(doctorU, docid);
        request.setAttribute("doctor", newDoctor);
//request.getRequestDispatcher("patient_appointment.jsp").forward(request, response);
        response.sendRedirect("DoctorPaging");
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
