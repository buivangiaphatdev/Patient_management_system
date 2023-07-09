package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Appointment;
import model.AppointmentDAO;
import model.Patient;
import model.PatientDAO;
import model.admin.Admin;
import model.admin.AdminDAO;
import model.doctor.Doctor;
import model.doctor.DoctorDAO;

/**
 *
 * @author PC
 */
public class LoginServlet extends HttpServlet {

    private static final String ERROR = "login.jsp";
    private static final String PATIENT_PAGE = "patient_page.jsp";
    private static final String DOCTOR_PAGE = "doctorpaging";
    private static final String ADMIN_PAGE = "paging";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String url = ERROR;
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String role = request.getParameter("userrole");

            Patient patient = PatientDAO.patientLogin(email, password);
            Doctor doctor = DoctorDAO.doctorLogin(email, password);
            Admin admin = AdminDAO.adminLogin(email, password);
            if (patient != null) {
                if (role.equals("patient") && patient.getRole().equals(role)) {
                    request.getSession().setAttribute("PATIENT", patient);
                    url = PATIENT_PAGE;
                    List<Appointment> list = new AppointmentDAO().getAppointment(patient.getPatientID());
                    session.setAttribute("apps", list);
                } else {
                    session.setAttribute("ERROR_MESSAGE", "Your role is not support!");
                }
            } else if (doctor != null) {
                request.getSession().setAttribute("DOCTOR", doctor);
                if (role.equals("doctor") && doctor.getRole().equals(role)) {
                    url = DOCTOR_PAGE;
                } else {
                    session.setAttribute("ERROR_MESSAGE", "Your role is not support!");
                }
            } else if (admin != null) {
                request.getSession().setAttribute("ADMIN", admin);
                if (role.equals("admin") && admin.getDesig().equals(role)) {
                    url = ADMIN_PAGE;
                } else {
                    session.setAttribute("ERROR_MESSAGE", "Your role is not support!");
                }
            } else {
                session.setAttribute("ERROR_MESSAGE", "Incorrect UserID or Password!");
            }

        } catch (Exception e) {
            log("Error at LoginController: " + e.toString());
        } finally {
            response.sendRedirect(url);
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
