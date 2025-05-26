/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.math.BigDecimal;

/**
 *
 * @author LENOVO
 */
public class InvoiceMedicineDetail {
    private String invoiceMedicineId;
    private String invoiceId;
    private String medicineId;
    private int quantity;
    private BigDecimal unitPrice;

    public InvoiceMedicineDetail(String invoiceMedicineId, String invoiceId, String medicineId, int quantity, BigDecimal unitPrice) {
        this.invoiceMedicineId = invoiceMedicineId;
        this.invoiceId = invoiceId;
        this.medicineId = medicineId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public InvoiceMedicineDetail(String invoiceId, String medicineId, int quantity, BigDecimal unitPrice) {
        this.invoiceId = invoiceId;
        this.medicineId = medicineId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public InvoiceMedicineDetail() {
    }

    public String getInvoiceMedicineId() {
        return invoiceMedicineId;
    }

    public void setInvoiceMedicineId(String invoiceMedicineId) {
        this.invoiceMedicineId = invoiceMedicineId;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "InvoiceMedicineDetail{" + "invoiceMedicineId=" + invoiceMedicineId + ", invoiceId=" + invoiceId + ", medicineId=" + medicineId + ", quantity=" + quantity + ", unitPrice=" + unitPrice + '}';
    }
    
    
}
