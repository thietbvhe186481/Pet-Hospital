/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author LENOVO
 */
public class AboutUs {
    private String aboutId;
    private String address;
    private String phone;
    private String email;
    private String description;

    public AboutUs() {
    }

    public AboutUs(String address, String phone, String email, String description) {
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.description = description;
    }

    public AboutUs(String aboutId, String address, String phone, String email, String description) {
        this.aboutId = aboutId;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.description = description;
    }

    public String getAboutId() {
        return aboutId;
    }

    public void setAboutId(String aboutId) {
        this.aboutId = aboutId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "AboutUs{" + "aboutId=" + aboutId + ", address=" + address + ", phone=" + phone + ", email=" + email + ", description=" + description + '}';
    }
    
    
}
