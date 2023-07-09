
package model.doctor;


public class Doctor {
    private int docID;
    private String docName, email, password, address, phoneNumber, departName, role;

    public Doctor() {
    }

    public Doctor(int docID, String docName, String email, String password, String address, String phoneNumber, String departName, String role) {
        this.docID = docID;
        this.docName = docName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.departName = departName;
        this.role = role;
    }
    public Doctor(String docName, String email, String password, String address, String phoneNumber, String departName, String role) {

        this.docName = docName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.departName = departName;
        this.role = role;
    }

    public int getDocID() {
        return docID;
    }

    public void setDocID(int docID) {
        this.docID = docID;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public String getRole() {
        return "doctor";
    }

    public void setRole(String role) {
        this.role = role;
    }

    
    
    
}
