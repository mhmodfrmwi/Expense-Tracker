package com.example.demo;

public class Trip {
    private String name;
    private String type;
    private String purpose;
    private String departFrom;
    private String destination;
    private String budget;
    private String hotel;
    public Trip(String name, String type,String departFrom,String destination){
        this.name = name;
        this.type = type;
        this.departFrom = departFrom;
        this.destination = destination;
    }
    public Trip(String name, String type, String purpose,
                String departFrom, String destination, String budget,
                String hotel) {
        this.name = name;
        this.type = type;
        this.purpose = purpose;
        this.departFrom = departFrom;
        this.destination = destination;
        this.budget = budget;
        this.hotel = hotel;
    }
    public Trip() {}

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

    @Override
    public String toString() {
        return "Trip{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", purpose='" + purpose + '\'' +
                ", departFrom='" + departFrom + '\'' +
                ", destination='" + destination + '\'' +
                ", budget='" + budget + '\'' +
                ", hotel='" + hotel + '\'' +
                '}';
    }
}
