package com.example.demo;

public class Receipt {
    private String receiptNumber;
    private String businessAddress;
    private String customerName;
    private String customerPhone;
    private String employeeName;
    private String referenceNumber;
    private String merchant;

    public Receipt(String receiptNumber, String businessAddress, String customerName, String customerPhone, String employeeName, String referenceNumber, String merchant) {
        this.receiptNumber = receiptNumber;
        this.businessAddress = businessAddress;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.employeeName = employeeName;
        this.referenceNumber = referenceNumber;
        this.merchant = merchant;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "receiptNumber='" + receiptNumber + '\'' +
                ", businessAddress='" + businessAddress + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", referenceNumber='" + referenceNumber + '\'' +
                ", merchant='" + merchant + '\'' +
                '}';
    }
}
