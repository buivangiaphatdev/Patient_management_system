/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.admin;

import Utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Patient;
import model.doctor.Doctor;


public class AdminDAO {
     public static Admin adminLogin(String email, String password) throws SQLException {
        Admin admin = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT [NAME] ,[SEX] ,[ADDRESS] ,[PHNO],[DESIG] FROM [dbo].[ADMIN]"
                        + " WHERE email=? and PASSWORD=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, email);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String adminName = rs.getString ("NAME");
                    String sex = rs.getString("SEX");
                    String address = rs.getString("ADDRESS");
                    String phoneNumber = rs.getString("PHNO");
                    String desig  = rs.getString("DESIG");
                    
                    admin = new Admin(adminName, desig, address, phoneNumber, desig, "");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                rs.close();
            }
            if (conn != null) {
                rs.close();
            }
        }
        return admin;
    }
     
    // ===============================================================
        public static Patient adminUpPatient(Patient patient, int id) {
        try ( Connection con = DBUtils.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE [dbo].[PATIENT_INFO]   SET [PNAME] =?,"
                    + "[GENDER] =?,[AGE] =?,[BGROUP] =?,[PHONE] =?,[REA_OF_VISIT] =?,[ROOM_NO] =?,"
                    + "[BED_NO] =?,[DOC_NAME] =?,[DATE_ADD] =?,[EMAIL]=?,[PASSWORD] =?,[ADDRESS] =?, [ROLE]=? WHERE ID=?");
            stmt.setString(1, patient.getPatientName());
            stmt.setString(2, patient.getGender());
            stmt.setInt(3, patient.getAge());
            stmt.setString(4, patient.getbGroup());
            stmt.setString(5, patient.getPhoneNumber());
            stmt.setString(6, patient.getReaOfVisit());
            stmt.setInt(7, patient.getRoom_no());
            stmt.setInt(8, patient.getBed_no());
            stmt.setString(9,patient.getDoctorName());
            stmt.setString(10,patient.getDateAdd());
            stmt.setString(11, patient.getEmail());
            stmt.setString(12, patient.getPassword());
            stmt.setString(13, patient.getAddress());
            stmt.setString(14,"patient");
            stmt.setInt(15,id);
            
            int rc = stmt.executeUpdate();
            con.close();
            return patient;
        } catch (Exception ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Invalid data");
        }
    }
       
         public void deletePatientByID(int id) {
        try {
            String sql = " DELETE FROM [dbo].[PATIENT_INFO] WHERE ID=?";
            
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
         
  
//         public void changePass(String table, String email, String pass){
//             
//             try(Connection con = DBUtils.getConnection()) {
//                 String query ="UPDATE"+table+" SET[PASSWORD] = ? WHERE email= ?";
//                 PreparedStatement stmt = con.prepareStatement(query);
//                 
//                 stmt.setString(1, pass);
//                 stmt.setString(2, email);
//                 stmt.executeUpdate();
//                 con.close();
//             } catch (Exception e) {
//                 throw new RuntimeException("Invalid data");
//             }
//         }
         
          public void ChangePass(String table,String email, String pass) {
        try ( Connection con = DBUtils.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE [dbo]."+table+" SET [PASSWORD] = ? "
                    + "WHERE EMAIL=?");
            stmt.setString(1, pass);
            stmt.setString(2, email);
            stmt.executeUpdate();
            con.close();
        } catch (Exception ex) {
           throw new RuntimeException("Invalid data");
        }
    }
          
             public static Doctor adminUpDoctor(Doctor doctor, int id) {
        try ( Connection con = DBUtils.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE [dbo].[DOCTOR_INFOR]  SET [docName] =?,"
                    + "[email] =?,[password] =?,[address] =?,[phoneNumber] =?,[deptName] =?,"
                    + "[role] =?"
                    + " WHERE doctorID=?");
            stmt.setString(1, doctor.getDocName());
            stmt.setString(2, doctor.getEmail());
            stmt.setString(3, doctor.getPassword());
            stmt.setString(4, doctor.getAddress());
            stmt.setString(5,doctor.getPhoneNumber());
            stmt.setString(6,doctor.getDepartName());
            stmt.setString(7,"doctor");
            stmt.setInt(8,id);
            
            int rc = stmt.executeUpdate();
            con.close();
            return doctor;
        } catch (Exception ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Invalid data");
        }
    }
             
              public void deleteDoctorByID(int id) {
        try {
            String sql = " DELETE FROM [dbo].[DOCTOR_INFOR] WHERE doctorID=?";
            
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
