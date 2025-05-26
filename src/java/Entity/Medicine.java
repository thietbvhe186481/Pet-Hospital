/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author LENOVO
 */
public class Medicine {
    private String medicineId;
    private String medicineName;
    private int quantity;
    private BigDecimal price;
    private Date expiryDate;

    public Medicine() {
    }

    public Medicine(String medicineName, int quantity, BigDecimal price, Date expiryDate) {
        this.medicineName = medicineName;
        this.quantity = quantity;
        this.price = price;
        this.expiryDate = expiryDate;
    }

    public Medicine(String medicineId, String medicineName, int quantity, BigDecimal price, Date expiryDate) {
        this.medicineId = medicineId;
        this.medicineName = medicineName;
        this.quantity = quantity;
        this.price = price;
        this.expiryDate = expiryDate;
    }

    public String getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "Medicine{" + "medicineId=" + medicineId + ", medicineName=" + medicineName + ", quantity=" + quantity + ", price=" + price + ", expiryDate=" + expiryDate + '}';
    }
    
    
}
