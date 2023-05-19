package com.laba.solvd.militaryProject.militaryEquipments;

import com.laba.solvd.militaryProject.exceptions.InvalidQuantityException;
import com.laba.solvd.militaryProject.interfaces.CalculatePrice;
import com.laba.solvd.militaryProject.interfaces.GetInfo;

public abstract class MilitaryEquipmentAbstract implements CalculatePrice, GetInfo {

    private String name;
    private double cost;
    private int quantity;

    public MilitaryEquipmentAbstract(String name, double cost, int quantity) throws InvalidQuantityException  {
        this.name = name;
        this.cost = cost;
        this.quantity = quantity;
        if (quantity <= 0) {
            throw new InvalidQuantityException("Invalid quantity for drones: " + quantity);
        }

    }
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public double getCost() {
//        return cost;
//    }
//
//    public void setCost(double cost) {
//        this.cost = cost;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }

    @Override
    public String getInfo() {
        return "Name: " + name + ", Cost: " + cost + ", Quantity: " + quantity;
    }

    @Override
    public double calculateCost() {
        return cost * quantity;
    }
}
