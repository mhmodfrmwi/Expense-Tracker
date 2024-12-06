package com.example.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Expense {
    private String subject;
    private String merchant;
    private double amount;
    private String date;

    public Expense(String subject, String merchant, double amount, String date) {
        this.subject = subject;
        this.merchant = merchant;
        this.amount = amount;
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }
    public String getMerchant() {
        return merchant;
    }
    public double getAmount() {
        return amount;
    }
    public String getDate() {
        return date;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public void setDate(String date) {
        this.date = date;
    }


    public boolean isValidDate(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setLenient(false);
        try {
            sdf.parse(this.date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public String formatDate(String oldFormat, String newFormat) throws ParseException {
        SimpleDateFormat oldFormatter = new SimpleDateFormat(oldFormat);
        SimpleDateFormat newFormatter = new SimpleDateFormat(newFormat);
        Date parsedDate = oldFormatter.parse(this.date);
        return newFormatter.format(parsedDate);
    }

    public boolean isAmountWithinRange(double min, double max) {
        return this.amount >= min && this.amount <= max;
    }

    public int compareAmount(Expense other) {
        return Double.compare(this.amount, other.amount);
    }

    public String getYear(String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date parsedDate = sdf.parse(this.date);
        SimpleDateFormat yearFormatter = new SimpleDateFormat("yyyy");
        return yearFormatter.format(parsedDate);
    }

    public boolean isMerchant(String merchantName) {
        return this.merchant.equalsIgnoreCase(merchantName);
    }

    public boolean isOnDate(String targetDate) {
        return this.date.equals(targetDate);
    }

    public double calculateTax(double taxRate) {
        return this.amount * taxRate / 100;
    }

    public double convertCurrency(double conversionRate) {
        return this.amount * conversionRate;
    }

    public String generateSummary() {
        return "Expense[Subject: " + subject + ", Merchant: " + merchant + ", Amount: " + amount + ", Date: " + date + "]";
    }

    public boolean isHigherThan(Expense other) {
        return this.amount > other.amount;
    }

    public boolean isEqualTo(Expense other) {
        return Objects.equals(this.subject, other.subject) &&
                Objects.equals(this.merchant, other.merchant) &&
                Double.compare(this.amount, other.amount) == 0 &&
                Objects.equals(this.date, other.date);
    }

    public String getDescription() {
        return "Expense for " + subject + " at " + merchant + " costing $" + amount + " on " + date;
    }

    public void applyDiscount(double discountPercentage) {
        this.amount -= this.amount * discountPercentage / 100;
    }

    public double splitExpense(int numberOfPeople) {
        if (numberOfPeople <= 0) throw new IllegalArgumentException("Number of people must be greater than 0");
        return this.amount / numberOfPeople;
    }

    public boolean isPastDate(String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date today = new Date();
        Date expenseDate = sdf.parse(this.date);
        return expenseDate.before(today);
    }

    public boolean isFromYear(String year, String format) throws ParseException {
        return getYear(format).equals(year);
    }

    public void addSurcharge(double surcharge) {
        this.amount += surcharge;
    }

    public int compareDate(Expense other, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date thisDate = sdf.parse(this.date);
        Date otherDate = sdf.parse(other.date);
        return thisDate.compareTo(otherDate);
    }

    public boolean subjectContains(String keyword) {
        return this.subject.toLowerCase().contains(keyword.toLowerCase());
    }

    public String amountWithCurrency(String currencySymbol) {
        return currencySymbol + String.format("%.2f", this.amount);
    }
}
