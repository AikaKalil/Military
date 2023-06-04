package com.laba.solvd.militaryProject.militaryEquipments;

import com.laba.solvd.militaryProject.enums.Branch;
import com.laba.solvd.militaryProject.exceptions.InvalidEquipmentException;
import com.laba.solvd.militaryProject.interfaces.CalculatePrice;
import com.laba.solvd.militaryProject.interfaces.GetInfo;
import org.apache.log4j.Logger;

import java.util.Scanner;

public abstract class MilitaryEquipmentAbstract implements CalculatePrice, GetInfo {
    private String name;
    private double cost;
    private int quantity;
    private Branch branch;
    public static Logger log = Logger.getLogger(MilitaryEquipmentAbstract.class);

    public MilitaryEquipmentAbstract(String name, double cost, int quantity, Branch branch) throws InvalidEquipmentException {
        this.name = name;
        this.cost = cost;
        this.quantity = quantity;
        this.branch = branch;
       if (quantity <= 0 || cost <= 0 || name=="" || name==" ") {
           log.info("Name: "+name+" Cost: "+cost+" Quantity+ "+quantity+" Branch: "+branch+" is not correct!");
        MilitaryEquipmentAbstract updatedEquipment = handleInvalidInput();
        this.setName(updatedEquipment.getName());
        this.setCost(updatedEquipment.getCost());
        this.setQuantity(updatedEquipment.getQuantity());
        this.setBranch(updatedEquipment.getBranch());
    }
}
    private Drones handleInvalidInput() throws InvalidEquipmentException {
        Scanner scan = new Scanner(System.in);

        log.info("Enter a new name: ");
        String newName = scan.nextLine().toUpperCase();

        double newCost = 0.0;
        boolean validInput = false;
        while (!validInput) {
            log.info("Enter a new cost: ");
            if (scan.hasNextDouble() || scan.hasNextInt()) {
                newCost = scan.nextDouble();
                validInput = true;
            } else {
                log.info("Invalid input. Please enter a valid number.");
                scan.next();
            }
        }

        int newQuantity =0;
        boolean validEnter = false;
        while (!validEnter) {
            log.info("Enter a new quantity: ");

            if (scan.hasNextInt()) {
                newQuantity = scan.nextInt();
                validEnter = true;
            } else {
                log.info("Invalid input. Please enter a valid number.");
                scan.next();
            }
        }
        scan.nextLine();
        log.info("Enter a new branch: ");
        Branch newBranch = Branch.selectBranch(scan);
        return new Drones(newName, newCost, newQuantity, newBranch);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    @Override
    public String getInfo() {
        return "Name: " + name + ", Cost: " + cost + ", Quantity: " + quantity+", Branch: "+branch;
    }

    @Override
    public double calculatePrice() {

        return cost * quantity;
    }


}
