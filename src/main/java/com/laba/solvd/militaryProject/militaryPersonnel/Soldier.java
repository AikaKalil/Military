package com.laba.solvd.militaryProject.militaryPersonnel;


import com.laba.solvd.militaryProject.enums.Gender;
import com.laba.solvd.militaryProject.enums.SoldierRank;
import com.laba.solvd.militaryProject.exceptions.InvalidPersonnelException;

import java.util.Scanner;

public class Soldier extends MilitaryPersonnelAbstract{
    private SoldierRank soldierRank;
    Scanner scan=new Scanner(System.in);
    public Soldier(String name, double salary, SoldierRank soldierRank, Gender gender) throws InvalidPersonnelException {
        super(name, salary,gender);
        this.soldierRank = soldierRank;
        if (name==null || salary<=0 || soldierRank==null){
            log.info("Enter a name: ");
            String newName = scan.nextLine();

            log.info("Enter a salary: ");
            double newCost = scan.nextDouble();


        }
    }
    @Override
    public double calculateSalary() {
        double baseSalary = soldierRank.getBonus();
        return baseSalary + super.getSalary();
    }

    @Override
    public String getInfo() {
        return getName() + " is a soldier with rank " + soldierRank.getRank() + " and salary " + calculateSalary();
    }
    @Override
    public String getRank() {

        return soldierRank.getRank();
    }
}
