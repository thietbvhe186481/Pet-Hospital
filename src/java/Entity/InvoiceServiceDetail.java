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
public class InvoiceServiceDetail {
    private String invoiceServiceId;
    private String invoiceId;
    private String serviceId;
    private int quantity;
    private BigDecimal unitPrice;

    public InvoiceServiceDetail(String invoiceServiceId, String invoiceId, String serviceId, int quantity, BigDecimal unitPrice) {
        this.invoiceServiceId = invoiceServiceId;
        this.invoiceId = invoiceId;
        this.serviceId = serviceId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public InvoiceServiceDetail() {
    }

    public InvoiceServiceDetail(String invoiceId, String serviceId, int quantity, BigDecimal unitPrice) {
        this.invoiceId = invoiceId;
        this.serviceId = serviceId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getInvoiceServiceId() {
        return invoiceServiceId;
    }

    public void setInvoiceServiceId(String invoiceServiceId) {
        this.invoiceServiceId = invoiceServiceId;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
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
        return "InvoiceServiceDetail{" + "invoiceServiceId=" + invoiceServiceId + ", invoiceId=" + invoiceId + ", serviceId=" + serviceId + ", quantity=" + quantity + ", unitPrice=" + unitPrice + '}';
    }
    
    
}
