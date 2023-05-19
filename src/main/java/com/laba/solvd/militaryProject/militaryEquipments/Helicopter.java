package com.laba.solvd.militaryProject.militaryEquipments;

import com.laba.solvd.militaryProject.exceptions.InvalidQuantityException;

public class Helicopter extends MilitaryEquipmentAbstract{
    private double helicopterBudget;

    public Helicopter(String name, double cost, int quantity) throws InvalidQuantityException {
        super(name, cost, quantity);
    }
    @Override
    public double calculateCost() {
        return helicopterBudget+=super.calculateCost();
    }

    @Override
    public String getInfo() {
        return super.getInfo()+"\nTotal: $"+helicopterBudget;
    }
}
