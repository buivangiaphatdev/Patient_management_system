package model;

import java.time.LocalDateTime;

public class Appointment {

    private int patientID, appointmentID;
    private String patientName, doctorName, email, phoneNumber, address, reaOfVisit, app_date, app_time;
    private LocalDateTime create_time;
    private int doctorID;

    public Appointment() {
    }

    public Appointment(int patientID, int appointmentID, String patientName, String doctorName, String email, String phoneNumber, String reaOfVisit, String app_date, String app_time, String create_time, int doctorID) {
        this.patientID = patientID;
        this.appointmentID = appointmentID;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.reaOfVisit = reaOfVisit;
        this.app_date = app_date;
        this.app_time = app_time;
        this.create_time = LocalDateTime.now();
        create_time = String.valueOf(this.create_time);
        this.doctorID = doctorID;
    }

    public Appointment(int patientID, int appointmentID, String patientName, String doctorName, String email, String phoneNumber, String address, String reaOfVisit, String app_date, String app_time, String create_time) {
        this.patientID = patientID;
        this.appointmentID = appointmentID;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.reaOfVisit = reaOfVisit;
        this.app_date = app_date;
        this.app_time = app_time;
        this.create_time = LocalDateTime.now();
        create_time = String.valueOf(this.create_time);
    }

    public Appointment(int patientID, String patientName, String doctorName, String email, String phoneNumber, String address, String reaOfVisit, String app_date, String app_time, String create_time) {
        this.patientID = patientID;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.reaOfVisit = reaOfVisit;
        this.app_date = app_date;
        this.app_time = app_time;
        this.create_time = LocalDateTime.now();
        create_time = String.valueOf(this.create_time);
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public int getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getReaOfVisit() {
        return reaOfVisit;
    }

    public void setReaOfVisit(String reaOfVisit) {
        this.reaOfVisit = reaOfVisit;
    }

    public String getApp_date() {
        return app_date;
    }

    public void setApp_date(String app_date) {
        this.app_date = app_date;
    }

    public String getApp_time() {
        return app_time;
    }

    public void setApp_time(String app_time) {
        this.app_time = app_time;
    }

    public LocalDateTime getCreate_time() {
        return create_time;
    }

    public void setCreate_time(LocalDateTime create_time) {
        this.create_time = create_time;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    @Override
    public String toString() {
        return "Appointment{" + "patientID=" + patientID + ", appointmentID=" + appointmentID + ", patientName=" + patientName + ", doctorName=" + doctorName + ", email=" + email + ", phoneNumber=" + phoneNumber + ", address=" + address + ", reaOfVisit=" + reaOfVisit + ", app_date=" + app_date + ", app_time=" + app_time + ", create_time=" + create_time + '}';
    }

}
