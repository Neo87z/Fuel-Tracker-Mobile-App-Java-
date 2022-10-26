/*
 * //**
 *  Created By Dulanji Vithnage (IT19142142), Imalshi Dias (IT19183978), Pawani Weerasinghe (IT19133546).
 * Copyright(c) 2022 . All Rights reserved.
 *  This project was done for the EAD Assignment  1
 * /
 */

package com.example.eadfinalproject;

//Main Model To Handle Station Data
public class Station {
    String ownerName;
    String ownerContactNo;
    String petrolShedNAme;
    String location;
    String status;
    String fuel;
    String lastRefill;
    String nextRefill;
    String twoWheel;
    String threeWheel;
    String fourWheel;
    String other;
    String waitTime;
    Boolean incmonningTwowheel;
    Boolean incmonningThreewheel;
    Boolean incmonningFourwheel;
    Boolean incmonningOther;
    Boolean fulPumping;
    Boolean addFuel;
    Boolean incommingRefilDate;






    public Station() {
    }

    public Station(String ownerName, String ownerContactNo, String petrolShedNAme, String location, String status, String fuel, String lastRefill, String nextRefill, String twoWheel, String threeWheel, String fourWheel, String other, String waitTime, Boolean incmonningTwowheel, Boolean incmonningThreewheel, Boolean incmonningFourwheel, Boolean incmonningOther, Boolean fulPumping, Boolean addFuel, Boolean incommingRefilDate) {
        this.ownerName = ownerName;
        this.ownerContactNo = ownerContactNo;
        this.petrolShedNAme = petrolShedNAme;
        this.location = location;
        this.status = status;
        this.fuel = fuel;
        this.lastRefill = lastRefill;
        this.nextRefill = nextRefill;
        this.twoWheel = twoWheel;
        this.threeWheel = threeWheel;
        this.fourWheel = fourWheel;
        this.other = other;
        this.waitTime = waitTime;
        this.incmonningTwowheel = incmonningTwowheel;
        this.incmonningThreewheel = incmonningThreewheel;
        this.incmonningFourwheel = incmonningFourwheel;
        this.incmonningOther = incmonningOther;
        this.fulPumping = fulPumping;
        this.addFuel = addFuel;
        this.incommingRefilDate = incommingRefilDate;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setOwnerContactNo(String ownerContactNo) {
        this.ownerContactNo = ownerContactNo;
    }

    public void setPetrolShedNAme(String petrolShedNAme) {
        this.petrolShedNAme = petrolShedNAme;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public void setLastRefill(String lastRefill) {
        this.lastRefill = lastRefill;
    }

    public void setNextRefill(String nextRefill) {
        this.nextRefill = nextRefill;
    }

    public void setTwoWheel(String twoWheel) {
        this.twoWheel = twoWheel;
    }

    public void setThreeWheel(String threeWheel) {
        this.threeWheel = threeWheel;
    }

    public void setFourWheel(String fourWheel) {
        this.fourWheel = fourWheel;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public void setWaitTime(String waitTime) {
        this.waitTime = waitTime;
    }

    public void setIncmonningTwowheel(Boolean incmonningTwowheel) {
        this.incmonningTwowheel = incmonningTwowheel;
    }

    public void setIncmonningThreewheel(Boolean incmonningThreewheel) {
        this.incmonningThreewheel = incmonningThreewheel;
    }

    public void setIncmonningFourwheel(Boolean incmonningFourwheel) {
        this.incmonningFourwheel = incmonningFourwheel;
    }

    public void setIncmonningOther(Boolean incmonningOther) {
        this.incmonningOther = incmonningOther;
    }

    public void setFulPumping(Boolean fulPumping) {
        this.fulPumping = fulPumping;
    }

    public void setAddFuel(Boolean addFuel) {
        this.addFuel = addFuel;
    }

    public void setIncommingRefilDate(Boolean incommingRefilDate) {
        this.incommingRefilDate = incommingRefilDate;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getOwnerContactNo() {
        return ownerContactNo;
    }

    public String getPetrolShedNAme() {
        return petrolShedNAme;
    }

    public String getLocation() {
        return location;
    }

    public String getStatus() {
        return status;
    }

    public String getFuel() {
        return fuel;
    }

    public String getLastRefill() {
        return lastRefill;
    }

    public String getNextRefill() {
        return nextRefill;
    }

    public String getTwoWheel() {
        return twoWheel;
    }

    public String getThreeWheel() {
        return threeWheel;
    }

    public String getFourWheel() {
        return fourWheel;
    }

    public String getOther() {
        return other;
    }

    public String getWaitTime() {
        return waitTime;
    }

    public Boolean getIncmonningTwowheel() {
        return incmonningTwowheel;
    }

    public Boolean getIncmonningThreewheel() {
        return incmonningThreewheel;
    }

    public Boolean getIncmonningFourwheel() {
        return incmonningFourwheel;
    }

    public Boolean getIncmonningOther() {
        return incmonningOther;
    }

    public Boolean getFulPumping() {
        return fulPumping;
    }

    public Boolean getAddFuel() {
        return addFuel;
    }

    public Boolean getIncommingRefilDate() {
        return incommingRefilDate;
    }
}
