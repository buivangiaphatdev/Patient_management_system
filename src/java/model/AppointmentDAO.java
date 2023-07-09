package model;

import Utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppointmentDAO {
    
    public List<Appointment> getAppointment(int patientID) {
        List<Appointment> appointment = new ArrayList<>();
        try ( Connection con = DBUtils.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("SELECT [appointmentID],[patientID],[patientName],"
                    + "[email],[phoneNumber],[doctorName],[reaOfVisit],[app_date],[app_time],"
                    + "[address],[create_time] FROM [dbo].[Appoinment] WHERE patientID=?");
            stmt.setInt(1, patientID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int appointmentID = rs.getInt("appointmentID");
//                int patientR=rs.getInt(2);
                String patientName = rs.getString(3);
                String email = rs.getString(4);
                String phoneNumber = rs.getString(5);
                String doctorName = rs.getString(6);
                String reaOfVisit = rs.getString(7);
                String app_date = rs.getString(8);
                String app_time = rs.getString(9);
                String address = rs.getString(10);
                String create_time = rs.getString(11);
                
                appointment.add(new Appointment(patientID,appointmentID, patientName, doctorName, email, phoneNumber, address, reaOfVisit, app_date, app_time, create_time));
                
            }
            con.close();
            
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return appointment;
    }
    
    public Appointment getAppointmentID(int appointmentID) {
        Appointment apps=null;
        try ( Connection con = DBUtils.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("SELECT [appointmentID],[patientID],[patientName],"
                    + "[email],[phoneNumber],[doctorName],[reaOfVisit],[app_date],[app_time],"
                    + "[address],[create_time] FROM [dbo].[Appoinment] WHERE appointmentID=?");
            stmt.setInt(1, appointmentID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int patientID = rs.getInt("patientID");
//                int patientR=rs.getInt(2);
                String patientName = rs.getString(3);
                String email = rs.getString(4);
                String phoneNumber = rs.getString(5);
                String doctorName = rs.getString(6);
                String reaOfVisit = rs.getString(7);
                String app_date = rs.getString(8);
                String app_time = rs.getString(9);
                String address = rs.getString(10);
                String create_time = rs.getString(11);
                
                apps= new Appointment(patientID,appointmentID,  patientName, doctorName, email, phoneNumber, address, reaOfVisit, app_date, app_time, create_time);
                
            }
            con.close();
            return apps;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        
    }
    
//    public static void main(String[] args) {
//        System.out.println(new AppointmentDAO().getAppointmentID(21));
//    }


    public static Appointment createAppointment(Appointment app) {
        
        try ( Connection conn = DBUtils.getConnection()) {
            String sql = "INSERT INTO [dbo].[Appoinment]([patientID],[patientName],[email],[phoneNumber],"
                    + "[doctorName],[reaOfVisit],[app_date],[app_time],[address],[create_time]) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, app.getPatientID());
            stm.setString(2, app.getPatientName());
            stm.setString(3, app.getEmail());
            stm.setString(4, app.getPhoneNumber());
            stm.setString(5, app.getDoctorName());
            stm.setString(6, app.getReaOfVisit());
            stm.setString(7, app.getApp_date());
            stm.setString(8, app.getApp_time());
            stm.setString(9, app.getAddress());
            stm.setString(10, String.valueOf(app.getCreate_time()));
            
            stm.executeUpdate();
            conn.close();
            
            return app;
        } catch (Exception e) {
            
            throw new RuntimeException(e);
        }
    }
    
    public static Appointment updateAppointment(Appointment app,int id) {
        try ( Connection con = DBUtils.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE [dbo].[Appoinment]  "
                    + " SET [patientName] =?,[email] =?,[phoneNumber] =?,[doctorName] =?,"
                    + "[reaOfVisit] =?,[app_date] =?,[app_time] =?,[address] =?,[create_time] =?"
                    + " WHERE appointmentID=?");
            stmt.setString(1, app.getPatientName());
            stmt.setString(2, app.getEmail());
            stmt.setString(3, app.getPhoneNumber());
            stmt.setString(4, app.getDoctorName());
            stmt.setString(5, app.getReaOfVisit());
            stmt.setString(6, app.getApp_date());
            stmt.setString(7, app.getApp_time());
            stmt.setString(8, app.getAddress());
            stmt.setString(9, String.valueOf(app.getCreate_time()));
            stmt.setInt(10, id);
            int rc = stmt.executeUpdate();
            con.close();
            return app;
        } catch (Exception ex) {
            Logger.getLogger(PatientDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Invalid data");
        }
    }
    
    public void deleteAppointmentByID(int id) {
        try {
            String sql = "DELETE FROM [dbo].[Appoinment]\n"
                    + "      WHERE appointmentID = ?";
            
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AppointmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AppointmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
