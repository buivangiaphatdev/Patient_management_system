/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Appointment;
import model.AppointmentDAO;

/**
 *
 * @author PC
 */
public class EditAppointment extends HttpServlet {

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
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("uid"));
        Appointment appointment = (Appointment) new AppointmentDAO().getAppointmentID(id);
        request.setAttribute("appointment", appointment);
        request.getRequestDispatcher("edit_appointment.jsp").forward(request, response);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("appointmentID"));
        int pid = Integer.parseInt(request.getParameter("pID"));
        String name = request.getParameter("patientName");
        String email = request.getParameter("email");
        String address = request.getParameter("add");
        String phone = request.getParameter("phone");
        String rov = request.getParameter("rov");
        String doctor = request.getParameter("doctor");
        String date = request.getParameter("date");
        String time = request.getParameter("time");
       
        
        Appointment appointment = new Appointment();
        
        appointment.setPatientName(name);
        appointment.setEmail(email);
        appointment.setAddress(address);
        appointment.setPhoneNumber(phone);
        appointment.setReaOfVisit(rov);
        appointment.setDoctorName(doctor);
        appointment.setApp_date(date);
        appointment.setApp_time(time);
        appointment.setCreate_time(LocalDateTime.now());
        
        Appointment newAppointment = AppointmentDAO.updateAppointment(appointment, id);
        request.setAttribute("apps", newAppointment);
//request.getRequestDispatcher("patient_appointment.jsp").forward(request, response);
        response.sendRedirect("ListAppointment");
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
