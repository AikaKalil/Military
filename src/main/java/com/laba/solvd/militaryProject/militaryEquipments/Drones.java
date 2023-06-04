package com.laba.solvd.militaryProject.militaryEquipments;

import com.laba.solvd.militaryProject.enums.Branch;
import com.laba.solvd.militaryProject.exceptions.InvalidEquipmentException;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class Drones extends MilitaryEquipmentAbstract{
    public static Logger log = Logger.getLogger(Drones.class);
    private double droneBudget;
    public Drones(String name, double cost, int quantity, Branch branch) throws InvalidEquipmentException {
     super(name, cost, quantity, branch);
     }
    @Override
    public double calculatePrice() {

        return droneBudget += super.calculatePrice();
    }

    @Override
    public String getInfo() {
        return super.getInfo();
    }

}
