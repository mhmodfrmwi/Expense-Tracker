package com.example.demo;

import java.util.Objects;

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

    public boolean isValidReceipt() {
        return receiptNumber != null && !receiptNumber.isEmpty() && referenceNumber != null;
    }

    public String getFormattedCustomerName() {
        return customerName.toUpperCase();
    }

    public boolean isForMerchant(String targetMerchant) {
        return merchant.equalsIgnoreCase(targetMerchant);
    }

    public String getMaskedCustomerPhone() {
        if (customerPhone == null || customerPhone.length() < 4) return "Invalid Phone";
        return "****" + customerPhone.substring(customerPhone.length() - 4);
    }

    public void updateBusinessAddress(String newAddress) {
        this.businessAddress = newAddress;
    }

    public boolean isReferenceNumberNumeric() {
        return referenceNumber.matches("\\d+");
    }

    public boolean isMerchantNameValid() {
        return merchant != null && !merchant.trim().isEmpty();
    }

    public String generateSummary() {
        return String.format("Receipt #%s: %s -> %s (%s)", receiptNumber, businessAddress, customerName, merchant);
    }

    public boolean isLinkedToEmployee(String employee) {
        return employeeName.equalsIgnoreCase(employee);
    }

    public void updateMerchantName(String newMerchant) {
        this.merchant = newMerchant;
    }

    public boolean verifyReceiptNumberFormat(String format) {
        return receiptNumber.startsWith(format);
    }

    public int getReceiptLength() {
        return toString().length();
    }

    public void appendSuffixToReference(String suffix) {
        this.referenceNumber += suffix;
    }

    public boolean doesCustomerNameContain(String keyword) {
        return customerName.toLowerCase().contains(keyword.toLowerCase());
    }

    public int compareReceiptNumbers(Receipt other) {
        return this.receiptNumber.compareTo(other.receiptNumber);
    }

    public String[] splitAddressIntoLines() {
        return businessAddress.split(",");
    }

    public String maskReferenceNumber() {
        if (referenceNumber == null || referenceNumber.length() < 4) return "Invalid Reference";
        return "****" + referenceNumber.substring(referenceNumber.length() - 4);
    }

    public void resetReceipt() {
        this.receiptNumber = null;
        this.businessAddress = null;
        this.customerName = null;
        this.customerPhone = null;
        this.employeeName = null;
        this.referenceNumber = null;
        this.merchant = null;
    }

    public String getCustomerInitials() {
        if (customerName == null || customerName.isEmpty()) return "N/A";
        String[] parts = customerName.split(" ");
        StringBuilder initials = new StringBuilder();
        for (String part : parts) {
            if (!part.isEmpty()) initials.append(part.charAt(0));
        }
        return initials.toString().toUpperCase();
    }

    public boolean isReceiptEmpty() {
        return receiptNumber == null && businessAddress == null && customerName == null;
    }

    public void appendMerchantSuffix(String suffix) {
        this.merchant += suffix;
    }

    public String getAddressUppercase() {
        return businessAddress.toUpperCase();
    }

    public boolean isEmployeeNameValid() {
        return employeeName != null && !employeeName.isEmpty();
    }

    public void replaceCustomerName(String newName) {
        this.customerName = newName;
    }

    public boolean matchesAddress(String targetAddress) {
        return this.businessAddress.equalsIgnoreCase(targetAddress);
    }

    public String getReversedReferenceNumber() {
        return new StringBuilder(referenceNumber).reverse().toString();
    }

    public boolean doesReceiptStartWith(String prefix) {
        return receiptNumber.startsWith(prefix);
    }

    public boolean isPhoneNumberValid() {
        return customerPhone != null && customerPhone.length() == 10;
    }

    public String generateMerchantEmployeePair() {
        return merchant + " - " + employeeName;
    }

    public int compareMerchants(Receipt other) {
        return this.merchant.compareTo(other.merchant);
    }

    public String abbreviateBusinessAddress() {
        return businessAddress.length() > 20 ? businessAddress.substring(0, 20) + "..." : businessAddress;
    }

    public boolean isDataComplete() {
        return receiptNumber != null && businessAddress != null && customerName != null;
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
