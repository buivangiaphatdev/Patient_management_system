
package model.admin;


public class Admin {
    private String adminName, gender, address, phoneNumber, desig, password;

    public Admin() {
    }

    public Admin(String adminName, String gender, String address, String phoneNumber, String desig, String password) {
        this.adminName = adminName;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.desig = desig;
        this.password = password;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getDesig() {
        return "admin";
    }

    public void setDesig(String desig) {
        this.desig = desig;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
