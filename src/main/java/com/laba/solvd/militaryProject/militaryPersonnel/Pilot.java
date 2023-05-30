package com.laba.solvd.militaryProject.militaryPersonnel;

import com.laba.solvd.militaryProject.enums.Gender;
import com.laba.solvd.militaryProject.enums.PilotRank;
import com.laba.solvd.militaryProject.exceptions.InvalidPersonnelException;
import com.laba.solvd.militaryProject.exceptions.InvalidRankException;
import java.util.Arrays;
import java.util.Scanner;

public class Pilot extends MilitaryPersonnelAbstract {
    Scanner scan=new Scanner(System.in);
    private PilotRank pilotRank;

    public Pilot(String name, double salary, PilotRank pilotRank, Gender gender) throws InvalidPersonnelException, InvalidRankException {
        super(name, salary,gender);
        this.pilotRank = pilotRank;
        if (name==null || salary<=0 || !isValidRank(pilotRank)){
            Pilot updatedPilot = handleInvalidInput();
            this.setName(updatedPilot.getName());
            this.setSalary(updatedPilot.getSalary());
            this.setRank(updatedPilot.getRank());
            this.setGender(updatedPilot.getGender());
        }
    }
    private Pilot handleInvalidInput() throws InvalidPersonnelException,InvalidRankException{
        Scanner scan = new Scanner(System.in);

        log.info("Enter a new name: ");
        String newName = scan.nextLine();

        log.info("Enter a new salary: ");
        double newCost = scan.nextDouble();

        log.info("Enter a new Pilot rank: ");
        PilotRank newRank =PilotRank.selectRank(scan);

        scan.nextLine();
        log.info("Enter a new branch: ");
        Gender newGender = Gender.selectGender(scan);
        return new Pilot(newName, newCost, newRank, newGender);
    }
    private boolean isValidRank(PilotRank pilotRank) {
        return Arrays.stream(PilotRank.values())
                .anyMatch(rank ->rank==pilotRank);

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