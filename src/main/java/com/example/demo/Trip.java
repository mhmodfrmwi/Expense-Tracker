package com.example.demo;

import java.util.Objects;

public class Trip {
    private String name;
    private String type;
    private String purpose;
    private String departFrom;
    private String destination;
    private String budget;
    private String hotel;

    public Trip(String name, String type, String departFrom, String destination) {
        this.name = name;
        this.type = type;
        this.departFrom = departFrom;
        this.destination = destination;
    }

    public Trip(String name, String type, String purpose, String departFrom, String destination, String budget, String hotel) {
        this.name = name;
        this.type = type;
        this.purpose = purpose;
        this.departFrom = departFrom;
        this.destination = destination;
        this.budget = budget;
        this.hotel = hotel;
    }

    public Trip() {}

    // Getters and Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getPurpose() {
        return purpose;
    }
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getDepartFrom() {
        return departFrom;
    }
    public void setDepartFrom(String departFrom) {
        this.departFrom = departFrom;
    }

    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getBudget() {
        return budget;
    }
    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getHotel() {
        return hotel;
    }
    public void setHotel(String hotel) {
        this.hotel = hotel;
    }


    public boolean isDomestic(String country) {
        return Objects.equals(departFrom, country) && Objects.equals(destination, country);
    }

    public double calculateRemainingBudget(double expenses) {
        return Double.parseDouble(budget) - expenses;
    }

    public boolean isWithinBudget(double expenses) {
        return calculateRemainingBudget(expenses) >= 0;
    }

    public String getSummary() {
        return String.format("Trip: %s (%s) from %s to %s", name, type, departFrom, destination);
    }

    public void updateDestination(String newDestination) {
        this.destination = newDestination;
    }

    public boolean isPurpose(String targetPurpose) {
        return Objects.equals(purpose, targetPurpose);
    }

    public double calculateCostPerDay(int days) {
        return Double.parseDouble(budget) / days;
    }

    public boolean hasHotel() {
        return hotel != null && !hotel.isEmpty();
    }

    public void addExtraBudget(double extraAmount) {
        this.budget = String.valueOf(Double.parseDouble(budget) + extraAmount);
    }

    public boolean isFlightRequired() {
        return !departFrom.equals(destination);
    }

    public int compareBudget(Trip other) {
        return Double.compare(Double.parseDouble(this.budget), Double.parseDouble(other.budget));
    }

    public boolean isLeisureTrip() {
        return Objects.equals(type, "Leisure");
    }

    public String formatDetails() {
        return String.format("Trip[name=%s, type=%s, purpose=%s, from=%s, to=%s, budget=%s, hotel=%s]",
                name, type, purpose, departFrom, destination, budget, hotel);
    }

    public boolean isBudgetAbove(double threshold) {
        return Double.parseDouble(budget) > threshold;
    }

    public void applyDiscount(double percentage) {
        double discount = Double.parseDouble(budget) * percentage / 100;
        this.budget = String.valueOf(Double.parseDouble(budget) - discount);
    }

    public boolean nameContains(String keyword) {
        return name.toLowerCase().contains(keyword.toLowerCase());
    }

    public boolean destinationsMatch(Trip other) {
        return this.destination.equalsIgnoreCase(other.destination);
    }

    public int compareNames(Trip other) {
        return this.name.compareToIgnoreCase(other.name);
    }

    public double splitBudget(int travelers) {
        if (travelers <= 0) throw new IllegalArgumentException("Number of travelers must be greater than zero");
        return Double.parseDouble(budget) / travelers;
    }

    public boolean isOneWayTrip() {
        return !departFrom.equals(destination);
    }

    public void changeHotel(String newHotel) {
        this.hotel = newHotel;
    }

    public double calculateOverage(double expenses) {
        return expenses - Double.parseDouble(budget);
    }

    public boolean isInternational() {
        return !departFrom.equals(destination);
    }

    public String getTypeUppercase() {
        return type.toUpperCase();
    }

    public int nameLength() {
        return name.length();
    }

    public boolean isType(String targetType) {
        return this.type.equalsIgnoreCase(targetType);
    }

    public void appendSuffixToName(String suffix) {
        this.name = this.name + suffix;
    }

    public double getBudgetAsDouble() {
        return Double.parseDouble(budget);
    }

    public void resetHotel() {
        this.hotel = "No Hotel";
    }

    public boolean isBusinessTrip() {
        return Objects.equals(type, "Business");
    }

    @Override
    public String toString() {
        return formatDetails();
    }
}
