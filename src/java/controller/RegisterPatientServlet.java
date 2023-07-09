package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Patient;
import model.PatientDAO;

public class RegisterPatientServlet extends HttpServlet {

    private static final String ERROR = "index.html";
    private static final String SUCCESS = "login.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
           
        try {
//            String email = request.getParameter("email");
//            Patient dao=PatientDAO.checkExist(email);
//            if(dao ==null){
            Patient p = (Patient) (request.getSession().getAttribute("patients"));
            if(PatientDAO.getEmailExist(p.getEmail())==true){
                request.getRequestDispatcher("index.html").forward(request, response);
            }else{
                 PatientDAO.createPatient(p);
            request.getRequestDispatcher("login.jsp").forward(request, response);
            }
           
//            }else{
//                response.sendRedirect("register.jsp");
//            }
            
        } catch (Exception e) {
            log("Error at LoginController: " + e.toString());
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
        // request.getRequestDispatcher("login.jsp").forward(request, response);
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
        //Patient p=(Patient)(request.getSession().getAttribute("patients"));
        // PatientDAO.createPatient(p);
        // request.getRequestDispatcher("login.jsp").forward(request, response);
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
