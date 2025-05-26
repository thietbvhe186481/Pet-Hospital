/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.math.BigDecimal;
import java.security.Timestamp;

/**
 *
 * @author LENOVO
 */
public class Invoice {
    private String invoiceId;
    private String bookingId;
    private BigDecimal totalAmount;
    private String status;
    private Timestamp issueDate;

    public Invoice() {
    }

    public Invoice(String bookingId, BigDecimal totalAmount, String status, Timestamp issueDate) {
        this.bookingId = bookingId;
        this.totalAmount = totalAmount;
        this.status = status;
        this.issueDate = issueDate;
    }

    public Invoice(String invoiceId, String bookingId, BigDecimal totalAmount, String status, Timestamp issueDate) {
        this.invoiceId = invoiceId;
        this.bookingId = bookingId;
        this.totalAmount = totalAmount;
        this.status = status;
        this.issueDate = issueDate;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Timestamp issueDate) {
        this.issueDate = issueDate;
    }

    @Override
    public String toString() {
        return "Invoice{" + "invoiceId=" + invoiceId + ", bookingId=" + bookingId + ", totalAmount=" + totalAmount + ", status=" + status + ", issueDate=" + issueDate + '}';
    }
    
}
