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
import model.Patient;
import model.PatientDAO;
import model.admin.AdminDAO;

/**
 *
 * @author PC
 */
@WebServlet(name = "DoctorUpdatePatient", urlPatterns = {"/DoctorUpdatePatient"})
public class DoctorUpdatePatient extends HttpServlet {

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
            out.println("<title>Servlet DoctorUpdatePatient</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DoctorUpdatePatient at " + request.getContextPath() + "</h1>");
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
        int pid = Integer.parseInt(request.getParameter("pid"));
        Patient patient = (Patient) new PatientDAO().getPatient(pid);
        request.setAttribute("listP", patient);
        request.getRequestDispatcher("doctor_updatePatient.jsp").forward(request, response);
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
          int pid = Integer.parseInt(request.getParameter("patientID"));
        String name = request.getParameter("patientname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String address = request.getParameter("add");
        String phone = request.getParameter("phone");
        String rov = request.getParameter("rov");
        int roomNo = Integer.parseInt(request.getParameter("roomNo"));
        int bedNo = Integer.parseInt(request.getParameter("bedNo"));
        String doctor = request.getParameter("doctor");
        String gender = request.getParameter("gender");
        String admit_date = request.getParameter("admit_date");
        int age = Integer.parseInt(request.getParameter("age"));
        String bGroup = request.getParameter("bGroup");
        String role = "patient";

        Patient patientU = new Patient();
        patientU.setPatientID(pid);
        patientU.setPatientName(name);
        patientU.setGender(gender);
        patientU.setAge(age);
        patientU.setbGroup(bGroup);
        patientU.setPhoneNumber(phone);
        patientU.setReaOfVisit(rov);
        patientU.setRoom_no(roomNo);
        patientU.setBed_no(bedNo);
        patientU.setDoctorName(doctor);
        patientU.setDateAdd(admit_date);
        patientU.setEmail(email);
        patientU.setPassword(password);
        patientU.setAddress(address);
        patientU.setRole(role);
        Patient newPatient = AdminDAO.adminUpPatient(patientU, pid);
        request.setAttribute("listP", newPatient);
//request.getRequestDispatcher("patient_appointment.jsp").forward(request, response);
        response.sendRedirect("doctorpaging");
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
