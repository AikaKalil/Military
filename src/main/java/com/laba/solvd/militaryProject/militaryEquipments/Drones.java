package com.laba.solvd.militaryProject.militaryEquipments;

import com.laba.solvd.militaryProject.enums.Branch;
import com.laba.solvd.militaryProject.exceptions.InvalidEquipmentException;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class Drones extends MilitaryEquipmentAbstract{
    public static Logger log = Logger.getLogger(Drones.class);
    private double droneBudget;
    Scanner scan=new Scanner(System.in);

    public Drones(String name, double cost, int quantity, Branch branch) throws InvalidEquipmentException {
        super(name, cost, quantity,branch);
        if (quantity <= 0 || cost<=0 || name==null) {
            log.info("Enter a new name: ");
            String newName = scan.nextLine();

            log.info("Enter a new cost: ");
            double newCost = scan.nextDouble();

            log.info("Enter a new quantity: ");
            int newQuantity = scan.nextInt();


        }

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
