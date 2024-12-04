package com.example.demo;

import org.bson.types.ObjectId;

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

    public String getSubject() { return subject; }
    public String getMerchant() { return merchant; }
    public double getAmount() { return amount; }
    public String getDate() { return date; }

}


