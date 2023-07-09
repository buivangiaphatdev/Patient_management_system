/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Appointment;
import model.AppointmentDAO;

/**
 *
 * @author PC
 */
public class CreateAppointment extends HttpServlet {

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
        String patientName = request.getParameter("patientName");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phone");
        String doctorName = request.getParameter("doctor");
        String reaOfVisit = request.getParameter("rov");
        String app_date = request.getParameter("date");
        String app_time = request.getParameter("time");
        String address = request.getParameter("add");
        String create_time = String.valueOf(LocalDateTime.now());
        Appointment app = new Appointment(patientID,patientName, doctorName, email, phoneNumber, address, reaOfVisit, app_date, app_time, create_time);
        Appointment appointment = AppointmentDAO.createAppointment(app);

//        HttpSession session = request.getSession();
        if (appointment != null) {
            //List<Appointment> list = (List<Appointment>)session.getAttribute("list");
            if(request.getAttribute("apps")==null){
                List<Appointment> apps = new ArrayList<>();
                apps.add(appointment);
                request.setAttribute("apps", apps);
            }
            else{
                List<Appointment> apps = (List<Appointment>)request.getAttribute("apps");
                apps.add(appointment);
                request.setAttribute("apps", apps);
            }
        }
       response.sendRedirect("ListAppointment");
      
//       request.getRequestDispatcher("patient_appointment.jsp").forward(request, response);
        
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
//         HttpSession session = request.getSession();
//        Appointment appointment = (Appointment) session.getAttribute("app");
//        int id = appointment.getPatientID();
//
//        Appointment ap = AppointmentDAO.getAppointment(id);
//        request.setAttribute("ap", ap);
//        request.getRequestDispatcher("patient_appointment.jsp").forward(request, response);
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
