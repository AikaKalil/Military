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
        if (quantity <= 0 || cost<=0 || name==null) {
            Helicopter updatedHelicopter = handleInvalidInput();
            this.setName(updatedHelicopter.getName());
            this.setCost(updatedHelicopter.getCost());
            this.setQuantity(updatedHelicopter.getQuantity());
            this.setBranch(updatedHelicopter.getBranch());

        }
    }

    private Helicopter handleInvalidInput() throws InvalidEquipmentException {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a new name: ");
        String newName = scan.nextLine();

        System.out.println("Enter a new cost: ");
        double newCost = scan.nextDouble();

        System.out.println("Enter a new quantity: ");
        int newQuantity = scan.nextInt();

        scan.nextLine();
        System.out.println("Enter a new branch: ");
        Branch newBranch = Branch.selectBranch(scan);
        return new Helicopter(newName, newCost, newQuantity, newBranch);
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
