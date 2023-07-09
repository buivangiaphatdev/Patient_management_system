package model;

import java.io.Serializable;

public class Patient implements Serializable{

    private int patientID, age, room_no, bed_no;
    private String patientName, gender, bGroup, phoneNumber, reaOfVisit, doctorName, email, password, address;
    private String dateAdd, role;

    public Patient() {
    }

   

    public Patient(int patientID, int age, int room_no, int bed_no, String patientName, String gender, String bGroup, String phoneNumber, String reaOfVisit, String doctorName, String email, String password, String address, String dateAdd, String role) {
        this.patientID = patientID;
        this.age = age;
        this.room_no = room_no;
        this.bed_no = bed_no;
        this.patientName = patientName;
        this.gender = gender;
        this.bGroup = bGroup;
        this.phoneNumber = phoneNumber;
        this.reaOfVisit = reaOfVisit;
        this.doctorName = doctorName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.dateAdd = dateAdd;
        this.role = role;
    }
      public Patient( int age, int room_no, int bed_no, String patientName, String gender, String bGroup, String phoneNumber, String reaOfVisit, String doctorName, String email, String password, String address, String dateAdd, String role) {
        
        this.age = age;
        this.room_no = room_no;
        this.bed_no = bed_no;
        this.patientName = patientName;
        this.gender = gender;
        this.bGroup = bGroup;
        this.phoneNumber = phoneNumber;
        this.reaOfVisit = reaOfVisit;
        this.doctorName = doctorName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.dateAdd = dateAdd;
        this.role = role;
    }
    
       public Patient(int patientID, int age, int room_no, int bed_no, String patientName, String gender, String bGroup, String phoneNumber, String reaOfVisit, String doctorName, String address, String dateAdd) {
        this.patientID = patientID;
        this.age = age;
        this.room_no = room_no;
        this.bed_no = bed_no;
        this.patientName = patientName;
        this.gender = gender;
        this.bGroup = bGroup;
        this.phoneNumber = phoneNumber;
        this.reaOfVisit = reaOfVisit;
        this.doctorName = doctorName;
        this.address = address;
        this.dateAdd = dateAdd;
    }
    
    public Patient(int patientID, int age, int room_no, int bed_no, String patientName, String gender, String bGroup, String phoneNumber, String reaOfVisit, String doctorName, String email, String address, String dateAdd) {
        this.patientID = patientID;
        this.age = age;
        this.room_no = room_no;
        this.bed_no = bed_no;
        this.patientName = patientName;
        this.gender = gender;
        this.bGroup = bGroup;
        this.phoneNumber = phoneNumber;
        this.reaOfVisit = reaOfVisit;
        this.doctorName = doctorName;
        this.email = email;
        this.address = address;
        this.dateAdd = dateAdd;
    }


    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRoom_no() {
        return room_no;
    }

    public void setRoom_no(int room_no) {
        this.room_no = room_no;
    }

    public int getBed_no() {
        return bed_no;
    }

    public void setBed_no(int bed_no) {
        this.bed_no = bed_no;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getbGroup() {
        return bGroup;
    }

    public void setbGroup(String bGroup) {
        this.bGroup = bGroup;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getReaOfVisit() {
        return reaOfVisit;
    }

    public void setReaOfVisit(String reaOfVisit) {
        this.reaOfVisit = reaOfVisit;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(String dateAdd) {
        this.dateAdd = dateAdd;
    }
    
     public String getRole() {
        return "patient";
    }

    public void setRole(String role) {
        this.role = role;
    }


}
