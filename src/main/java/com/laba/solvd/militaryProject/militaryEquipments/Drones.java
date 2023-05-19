package com.laba.solvd.militaryProject.militaryEquipments;

import com.laba.solvd.militaryProject.exceptions.InvalidQuantityException;

public class Drones extends MilitaryEquipmentAbstract{
    private double droneBudget;

    public Drones(String name, double cost, int quantity) throws InvalidQuantityException  {
        super(name, cost, quantity);
//        if (quantity <= 0) {
//            throw new InvalidQuantityException("Invalid quantity for drones: " + quantity);
//        }

    }
    @Override
    public double calculateCost() {

        return droneBudget += super.calculateCost();
    }

    @Override
    public String getInfo() {
        return super.getInfo()+"\nTotal: $"+droneBudget;
    }

}
