/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

/**
 *
 * @author PC
 */
public class PatientDAO {

    public static Patient patientLogin(String email, String password) throws SQLException {
        Patient patient = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT [ID],[PNAME],[GENDER],[AGE],[BGROUP],[PHONE],[REA_OF_VISIT],[ROOM_NO],[BED_NO],[DOC_NAME],[DATE_ADD],[ADDRESS],[ROLE]"
                        + "FROM [dbo].[PATIENT_INFO] WHERE email=? AND password=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, email);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    int patientID = rs.getInt("ID");
                    String pName = rs.getString("PNAME");
                    String gender = rs.getString("GENDER");
                    int age = rs.getInt("AGE");
                    String bGroup = rs.getString("BGROUP");
                    String phoneNumber = rs.getString("PHONE");
                    String rov = rs.getString("REA_OF_VISIT");
                    int room_no = rs.getInt("ROOM_NO");
                    int bed_no = rs.getInt("BED_NO");
                    String docName = rs.getString("DOC_NAME");
                    String dateAdd = rs.getString("DATE_ADD");
                    String address = rs.getString("ADDRESS");
                    String role = rs.getString("ROLE");
                    patient = new Patient(patientID, age, room_no, bed_no, pName, gender, bGroup, phoneNumber, rov, docName, email, password, address, dateAdd, role);
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
        return patient;
    }

    public Patient getPatient(int id) {
        Patient patient = null;
        try ( Connection con = DBUtils.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("SELECT [ID] ,[PNAME],[GENDER],[AGE],[BGROUP] ,"
                    + "[PHONE],[REA_OF_VISIT],[ROOM_NO],[BED_NO],[DOC_NAME],[DATE_ADD],[EMAIL],[PASSWORD],[ADDRESS]"
                    + "FROM [patientManagement].[dbo].[PATIENT_INFO] WHERE ID=?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int pID = rs.getInt(1);
                String patientName = rs.getString(2);
                String gender = rs.getString(3);
                int age = rs.getInt(4);
                String bGroup = rs.getString(5);
                String phoneNumber = rs.getString(6);
                String reaOfVisit = rs.getString(7);
                int room_no = rs.getInt(8);
                int bed_no = rs.getInt(9);
                String doctorName = rs.getString(10);
                String dateAdd = rs.getString(11);
                String email = rs.getString(12);
                String password = rs.getString(13);
                String address = rs.getString(14);
                patient = new Patient(pID, age, room_no, bed_no, patientName, gender, bGroup, phoneNumber, reaOfVisit, doctorName, email, password, address, dateAdd, "");
            }
            con.close();
            return patient;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

//    public static void main(String[] args) {
//        System.out.println(new PatientDAO().getPatient(100));
//    }
    ///check exist email
    public static boolean getEmailExist(String email) {
        Patient patient = null;
        int count = 0;
        try ( Connection con = DBUtils.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("SELECT [ID] ,[PNAME],[GENDER],[AGE],[BGROUP] ,"
                    + "[PHONE],[REA_OF_VISIT],[ROOM_NO],[BED_NO],[DOC_NAME],[DATE_ADD],[ADDRESS] "
                    + "FROM [patientManagement].[dbo].[PATIENT_INFO] WHERE EMAIL=?");
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt(1);
                String patientName = rs.getString(2);
                int age = rs.getInt(4);
                String gender = rs.getString(3);
                String phoneNumber = rs.getString(6);
                String reaOfVisit = rs.getString(7);
                String bGroup = rs.getString(5);
                String dateAdd = rs.getString(11);
                int room_no = rs.getInt(8);
                int bed_no = rs.getInt(9);
                String doctorName = rs.getString(10);
                String address = rs.getString(12);
                patient = new Patient(id, age, room_no, bed_no, patientName, gender, bGroup, phoneNumber, reaOfVisit, doctorName, "", "", address, dateAdd, "");
                count++;
            }
            con.close();
            if (count == 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    //==========================================================================
    public static ArrayList<Patient> listAll() {
        ArrayList<Patient> list = new ArrayList<>();
        try ( Connection con = DBUtils.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("SELECT [ID] ,[PNAME],[GENDER],[AGE],[BGROUP] ,"
                    + "[PHONE],[REA_OF_VISIT],[ROOM_NO],[BED_NO],[DOC_NAME],[DATE_ADD],[ADDRESS]"
                    + "FROM [patientManagement].[dbo].[PATIENT_INFO]");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int patientID = rs.getInt(1);
                String patientName = rs.getString(2);
                String gender = rs.getString(3);
                int age = rs.getInt(4);
                String bGroup = rs.getString(5);
                String phoneNumber = rs.getString(6);
                String reaOfVisit = rs.getString(7);
                int room_no = rs.getInt(8);
                int bed_no = rs.getInt(9);
                String doctorName = rs.getString(10);
                String dateAdd = rs.getString(11);
                String address = rs.getString(12);
                list.add(new Patient(patientID, age, room_no, bed_no, patientName, gender, bGroup, phoneNumber, reaOfVisit, doctorName, address, dateAdd));
            }
            con.close();
            return list;
        } catch (Exception ex) {
            Logger.getLogger(PatientDAO.class.getName()).log(Level.SEVERE, null, ex);

            throw new RuntimeException(ex);
        }
    }

//===============================================================================
    public static Patient createPatient(Patient p) {
        String room_no = "0";
        String bed_no = "0";
        String doc_Name = "Not Reffered";
        String date_Add = "Not Provided";

        try ( Connection conn = DBUtils.getConnection()) {
            String sql = "INSERT INTO [dbo].[PATIENT_INFO]([PNAME],[GENDER],[AGE],[BGROUP],[PHONE],"
                    + "[REA_OF_VISIT],[ROOM_NO],[BED_NO],[DOC_NAME],[DATE_ADD],[EMAIL],[PASSWORD],"
                    + "[ADDRESS],[ROLE])VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, p.getPatientName());
            stm.setString(2, p.getGender());
            stm.setInt(3, p.getAge());
            stm.setString(4, p.getbGroup());
            stm.setString(5, p.getPhoneNumber());
            stm.setString(6, p.getReaOfVisit());
            stm.setString(7, room_no);
            stm.setString(8, bed_no);
            stm.setString(9, doc_Name);
            stm.setString(10, date_Add);
            stm.setString(11, p.getEmail());
            stm.setString(12, p.getPassword());
            stm.setString(13, p.getAddress());
            stm.setString(14, "patient");
            stm.executeUpdate();
            conn.close();

            return p;
        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }

    //===========================UPDATE================================================
    public static Patient update(Patient p) {
        try ( Connection con = DBUtils.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE [dbo].[PATIENT_INFO]   SET [PNAME] =?,"
                    + "[GENDER] =?,[AGE] =?,[BGROUP] =?,[PHONE] =?,[REA_OF_VISIT] =?,[ROOM_NO] =?,"
                    + "[BED_NO] =?,[DOC_NAME] =?,[DATE_ADD] =?,[EMAIL] =?,[ADDRESS] = ? WHERE	ID=?");
            stmt.setString(1, p.getPatientName());
            stmt.setString(2, p.getGender());
            stmt.setInt(3, p.getAge());
            stmt.setString(4, p.getbGroup());
            stmt.setString(5, p.getPhoneNumber());
            stmt.setString(6, p.getReaOfVisit());
            stmt.setInt(7, p.getRoom_no());
            stmt.setInt(8, p.getBed_no());
            stmt.setString(9, p.getDoctorName());
            stmt.setString(10, p.getDateAdd());
            stmt.setString(11, p.getEmail());
            stmt.setString(12, p.getAddress());
            stmt.setInt(13, p.getPatientID());
            int rc = stmt.executeUpdate();
            con.close();
            return p;
        } catch (Exception ex) {
            Logger.getLogger(PatientDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Invalid data");
        }
    }

    public int getTotalPatient() {
        String query = "select count(*) from PATIENT_INFO";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int total = rs.getInt(1);
                int countPage = 0;
                countPage = total / 5;
                if (total % 5 != 0) {
                    countPage++;
                }
                return countPage;
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;

    }

    public List<Patient> getPaging(int index) {
        String query = "Select [ID] ,[PNAME],[GENDER],[AGE],[BGROUP],[PHONE],[REA_OF_VISIT],[ROOM_NO],[BED_NO],[DOC_NAME],[DATE_ADD],"
                + "[ADDRESS] from PATIENT_INFO order by ID offset ? rows fetch next 5 rows only";
        List<Patient> list = new ArrayList<>();
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, (index - 1) * 5);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Patient(rs.getInt(1),
                        rs.getInt(4),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(10),
                        rs.getString(12),
                        rs.getString(11)));
            }
            return list;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }

    ////// get search///
    public List<Patient> getSearch(String keyword) {
        String query = "Select  [ID] ,[PNAME],[GENDER],[AGE],[BGROUP],[PHONE],[REA_OF_VISIT],[ROOM_NO],"
                + "[BED_NO],[DOC_NAME],[DATE_ADD], [ADDRESS] from PATIENT_INFO where  [ID] like '%" + keyword + "%' OR"
                + " [PNAME]like '%" + keyword + "%' OR [GENDER]like '%" + keyword + "%' OR [AGE]like '%" + keyword + "%' OR [BGROUP]like '%" + keyword + "%' OR "
                + "[REA_OF_VISIT]like '%" + keyword + "%' OR [ROOM_NO]like '%" + keyword + "%' OR [DOC_NAME]like '%" + keyword + "%' OR "
                + "[ADDRESS]like '%" + keyword + "%'";
        List<Patient> list = new ArrayList<>();
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Patient(rs.getInt(1),
                        rs.getInt(4),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(10),
                        rs.getString(12),
                        rs.getString(11)));
            }
            return list;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
    
    public void ChangePass(String table,String email, String pass) {
        try ( Connection con = DBUtils.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE [dbo]."+table+" SET [PASSWORD] = ? "
                    + "WHERE EMAIL=?");
            stmt.setString(1, pass);
            stmt.setString(2, email);
            stmt.executeUpdate();
            con.close();
        } catch (Exception ex) {
            //Logger.getLogger(PatientDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Invalid data");
        }
    }

}
