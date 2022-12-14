/*
 * //**
 *  Created By Dulanji Vithnage (IT19142142), Imalshi Dias (IT19183978), Pawani Weerasinghe (IT19133546).
 * Copyright(c) 2022 . All Rights reserved.
 *  This project was done for the EAD Assignment  1
 * /
 */

package com.example.eadfinalproject;


//Main Dataset To Handle the Customers
public class OurDataSet {
    String fname;
    String sender;
    String message;
    String plateNumber;
    String modelNumber;
    String color;
    String type;


    public OurDataSet() {
    }

    public OurDataSet(String fname, String sender, String message, String plateNumber, String modelNumber, String color, String type) {
        this.fname = fname;
        this.sender = sender;
        this.message = message;
        this.plateNumber = plateNumber;
        this.modelNumber = modelNumber;
        this.color = color;
        this.type = type;
    }

    public String getFname() {
        return fname;
    }

    public String getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setType(String type) {
        this.type = type;
    }
}
