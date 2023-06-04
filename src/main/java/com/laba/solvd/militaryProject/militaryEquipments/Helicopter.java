package com.laba.solvd.militaryProject.militaryEquipments;

import com.laba.solvd.militaryProject.enums.Branch;
import com.laba.solvd.militaryProject.exceptions.InvalidEquipmentException;
import org.apache.log4j.Logger;
import java.util.Scanner;

public class Helicopter extends MilitaryEquipmentAbstract{
    private double helicopterBudget;
    public static Logger log = Logger.getLogger(Drones.class);
    Scanner scan=new Scanner(System.in);
    public Helicopter(String name, double cost, int quantity, Branch branch) throws InvalidEquipmentException {
        super(name, cost, quantity,branch);

        }

    @Override
    public double calculatePrice() {
        return helicopterBudget+=super.calculatePrice();
    }

    @Override
    public String getInfo() {
        return super.getInfo();
    }


}
