package model.doctor;

import Utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Appointment;

public class DoctorDAO {

    public static Doctor doctorLogin(String email, String password) throws SQLException {
        Doctor doctor = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT [doctorID] ,[docName] ,[address] ,[phoneNumber] ,[deptName], [role]"
                        + " FROM [dbo].[DOCTOR_INFOR] WHERE email=? AND password=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, email);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    int doctorID = rs.getInt("doctorID");
                    String docName = rs.getString("docName");
                    String address = rs.getString("address");
                    String phoneNumber = rs.getString("phoneNumber");
                    String deptName = rs.getString("deptName");
                    String role = rs.getString("role");

                    doctor = new Doctor(doctorID, docName, email, "", address, phoneNumber, deptName, role);
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
        return doctor;
    }

    public static ArrayList<Doctor> listAllDoctor() {
        ArrayList<Doctor> list = new ArrayList<>();
        try ( Connection con = DBUtils.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("SELECT [doctorID] ,[docName],[email],"
                    + "[password],[address],[phoneNumber] ,[deptName] ,[role] "
                    + "FROM [dbo].[DOCTOR_INFOR]");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int doctorID = rs.getInt("doctorID");
                String docName = rs.getString("docName");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phoneNumber");
                String deptName = rs.getString("deptName");
                String role = rs.getString("role");
                list.add(new Doctor(doctorID, docName, email, password, address, phoneNumber, deptName, role));
            }
            con.close();
            return list;
        } catch (Exception ex) {
            Logger.getLogger(DoctorDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }

    }

    public static Doctor createDoctor(Doctor d) {

        try ( Connection conn = DBUtils.getConnection()) {
            String sql = "INSERT INTO [dbo].[DOCTOR_INFOR] ([docName],[email] ,[password],[address], "
                    + "[phoneNumber],[deptName],[role]) "
                    + "VALUES(?,?,?,?,?,?,?)";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, d.getDocName());
            stm.setString(2, d.getEmail());
            stm.setString(3, d.getPassword());
            stm.setString(4, d.getAddress());
            stm.setString(5, d.getPhoneNumber());
            stm.setString(6, d.getDepartName());
            stm.setString(7, d.getRole());
            stm.executeUpdate();
            conn.close();

            return d;
        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Appointment> getAppointmentDoctor() {
        ArrayList<Appointment> apps = new ArrayList();
        try ( Connection con = DBUtils.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("SELECT DOCTOR_INFOR.doctorID,DOCTOR_INFOR.docName,"
                    + "Appoinment.appointmentID,Appoinment.patientID,Appoinment.patientName,"
                    + "Appoinment.phoneNumber, Appoinment.email, Appoinment.reaOfVisit, Appoinment.app_date,"
                    + "Appoinment.app_time,Appoinment.create_time FROM DOCTOR_INFOR, Appoinment "
                    + "WHERE DOCTOR_INFOR.docName = Appoinment.doctorName");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int docID = rs.getInt(1);
                String doctorName = rs.getString(2);
                int appID = rs.getInt(3);
                int paID = rs.getInt(4);
                String patientName = rs.getString(5);
                String phoneNumber = rs.getString(6);
                String email = rs.getString(7);
                String rov = rs.getString(8);
                String app_date = rs.getString(9);
                String app_time = rs.getString(10);
                String create_time = rs.getString(11);

                apps.add(new Appointment(paID, appID, patientName, doctorName, email, phoneNumber, rov, app_date, app_time, create_time, docID));

            }
            con.close();
            return apps;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public int getTotalAppointment() {
        String query = "Select count(*) from DOCTOR_INFOR, Appoinment "
                + "where DOCTOR_INFOR.doctorID=Appoinment.doctorID";
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

    public ArrayList<Appointment> getPagingApp(int index) {
        String query = "SELECT DOCTOR_INFOR.doctorID,DOCTOR_INFOR.docName,Appoinment.appointmentID,"
                + "Appoinment.patientID,Appoinment.patientName,Appoinment.phoneNumber, Appoinment.email,"
                + " Appoinment.reaOfVisit, Appoinment.app_date,Appoinment.app_time,Appoinment.create_time"
                + " FROM DOCTOR_INFOR, Appoinment WHERE DOCTOR_INFOR.doctorID = Appoinment.doctorID order"
                + " by Appoinment.appointmentID offset ? rows fetch next 5 rows only";
        ArrayList<Appointment> list = new ArrayList<>();
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, (index - 1) * 5);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int docID = rs.getInt(1);
                String docName = rs.getString(2);
                int appID = rs.getInt(3);
                int paID = rs.getInt(4);
                String paName = rs.getString(5);
                String phone = rs.getString(6);
                String email = rs.getString(7);
                String rov = rs.getString(8);
                String app_date = rs.getString(9);
                String app_time = rs.getString(10);
                String create_time = rs.getString(11);

                list.add(new Appointment(paID, appID, paName, docName, email, phone, rov, app_date, app_time, create_time, docID));
            }
            return list;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Appointment> getSearchAppointment(String keyword) {
        String query = "SELECT DOCTOR_INFOR.doctorID ,DOCTOR_INFOR.docName,Appoinment.appointmentID,"
                + "Appoinment.patientID,Appoinment.patientName,Appoinment.phoneNumber, Appoinment.email,"
                + " Appoinment.reaOfVisit, Appoinment.app_date, Appoinment.app_time,Appoinment.create_time"
                + " FROM  Appoinment"
                + " inner join DOCTOR_INFOR "
                + " on  DOCTOR_INFOR.doctorID = Appoinment.doctorID"
                + " WHERE Appoinment.appointmentID like '%" + keyword + "%' OR"
                + " Appoinment.app_date like '%" + keyword + "%'OR "
                + "Appoinment.app_time like '%" + keyword + "%'";
        List<Appointment> list = new ArrayList<>();
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int docID = rs.getInt(1);
                String docName = rs.getString(2);
                int appID = rs.getInt(3);
                int paID = rs.getInt(4);
                String paName = rs.getString(5);
                String phone = rs.getString(6);
                String email = rs.getString(7);
                String rov = rs.getString(8);
                String app_date = rs.getString(9);
                String app_time = rs.getString(10);
                String create_time = rs.getString(11);
                list.add(new Appointment(paID, appID, paName, docName, email, phone, rov, app_date, app_time, create_time, docID));
            }
            return list;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getTotalDoctor() {
        String query = "select count(*) from DOCTOR_INFOR";
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

    public List<Doctor> getDoctorPaging(int index) {
        String query = "SELECT [doctorID],[docName],[email] ,[password],"
                + "[address],[phoneNumber] ,[deptName],[role] "
                + "FROM [dbo].[DOCTOR_INFOR] "
                + "order by doctorID offset ? rows fetch next 5 rows only";
        List<Doctor> list = new ArrayList<>();
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, (index - 1) * 5);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Doctor(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getString(8)));
            }
            return list;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Doctor> getSearchDoctor(String keyword) {
        String query = "SELECT [doctorID],[docName],[email],[password],[address],[phoneNumber],"
                + "[deptName],[role] FROM [dbo].[DOCTOR_INFOR] where [doctorID] like '%" + keyword + "%'"
                + "OR [docName] like '%" + keyword + "%' OR [deptName] like '%" + keyword + "%'";
        List<Doctor> list = new ArrayList<>();
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Doctor(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getString(8)));
            }
            return list;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Doctor getDoctor(int id) {
        Doctor doctor = null;
        try ( Connection con = DBUtils.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("SELECT [doctorID],[docName],[email],[password],"
                    + "[address],[phoneNumber],[deptName],[role] FROM [dbo].[DOCTOR_INFOR] "
                    + "Where doctorID=?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int docID = rs.getInt(1);
                String docName = rs.getString(2);
                String email = rs.getString(3);
                String password = rs.getString(4);
                String address = rs.getString(5);
                String phoneNumber = rs.getString(6);
                String deptName = rs.getString(7);
                String role = rs.getString(8);

                doctor = new Doctor(docID, docName, email, password, address, phoneNumber, deptName, role);
            }
            con.close();
            return doctor;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public int getDoctorAppointment(int id) {
        String query = "SELECT count(*) FROM  Appoinment "
                + "inner join DOCTOR_INFOR  "
                + "on  DOCTOR_INFOR.doctorID = Appoinment.doctorID"
                + " WHERE DOCTOR_INFOR.doctorID=?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
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
    
     public ArrayList<Appointment> getPagingAppDoctor(int index, int id) {
        String query = "SELECT DOCTOR_INFOR.doctorID ,DOCTOR_INFOR.docName,Appoinment.appointmentID,"
                + "Appoinment.patientID,Appoinment.patientName,Appoinment.phoneNumber, "
                + "Appoinment.email,Appoinment.reaOfVisit, Appoinment.app_date, Appoinment.app_time,"
                + "Appoinment.create_time "
                + "FROM  Appoinment "
                + "inner join DOCTOR_INFOR  "
                + "on  DOCTOR_INFOR.doctorID = Appoinment.doctorID "
                + "WHERE DOCTOR_INFOR.doctorID=? "
                + "order by Appoinment.appointmentID "
                + "offset ? rows fetch next 5 rows only";
        ArrayList<Appointment> list = new ArrayList<>();
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1,id);
            ps.setInt(2, (index - 1) * 5);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int docID = rs.getInt(1);
                String docName = rs.getString(2);
                int appID = rs.getInt(3);
                int paID = rs.getInt(4);
                String paName = rs.getString(5);
                String phone = rs.getString(6);
                String email = rs.getString(7);
                String rov = rs.getString(8);
                String app_date = rs.getString(9);
                String app_time = rs.getString(10);
                String create_time = rs.getString(11);

                list.add(new Appointment(paID, appID, paName, docName, email, phone, rov, app_date, app_time, create_time, docID));
            }
            return list;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
     }
    
}
