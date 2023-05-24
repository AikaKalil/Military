package com.laba.solvd.militaryProject.militaryPersonnel;

import com.laba.solvd.militaryProject.enums.Gender;
import com.laba.solvd.militaryProject.enums.PilotRank;
import com.laba.solvd.militaryProject.exceptions.InvalidPersonnelException;

import java.util.Scanner;

public class Pilot extends MilitaryPersonnelAbstract {
    Scanner scan=new Scanner(System.in);
    private PilotRank pilotRank;

    public Pilot(String name, double salary, PilotRank pilotRank, Gender gender) throws InvalidPersonnelException {
        super(name, salary,gender);
        this.pilotRank = pilotRank;
        if (name==null || salary<=0 || pilotRank==null){
            log.info("Enter a name: ");
            String newName = scan.nextLine();

            log.info("Enter a salary: ");
            double newCost = scan.nextDouble();


        }

    }
    @Override
    public double calculateSalary() {
        double salary = pilotRank.getBonus();
        return salary + super.getSalary();
    }

    @Override
    public String getInfo() {
        return getName() + " is a soldier with rank " + pilotRank.getRank() + " and salary " + calculateSalary();
    }
    @Override
    public String getRank() {
        return pilotRank.getRank();
    }
}