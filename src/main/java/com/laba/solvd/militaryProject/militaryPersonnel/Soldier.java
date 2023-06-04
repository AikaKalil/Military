package com.laba.solvd.militaryProject.militaryPersonnel;
import com.laba.solvd.militaryProject.enums.Gender;
import com.laba.solvd.militaryProject.enums.SoldierRank;
import com.laba.solvd.militaryProject.exceptions.InvalidPersonnelException;
import com.laba.solvd.militaryProject.exceptions.InvalidRankException;
import java.util.Arrays;
import java.util.Scanner;

public class Soldier extends MilitaryPersonnelAbstract{
    private SoldierRank soldierRank;
    Scanner scan=new Scanner(System.in);
    public Soldier(String name, double salary, SoldierRank soldierRank, Gender gender) throws InvalidPersonnelException,InvalidRankException {
        super(name, salary,gender);
        this.soldierRank = soldierRank;
        if (name=="" || name==" " || salary<=0 || !isValidRank(soldierRank)){
            Soldier updatedSoldier = handleInvalidInput();
            this.setName(updatedSoldier.getName());
            this.setSalary(updatedSoldier.getSalary());
            this.setRank(updatedSoldier.getRank());
            this.setGender(updatedSoldier.getGender());
        }
    }
    private Soldier handleInvalidInput() throws InvalidPersonnelException, InvalidRankException {
        Scanner scan = new Scanner(System.in);

        log.info("Enter a new name: ");
        String newName = scan.nextLine();

        log.info("Enter a new salary: ");
        double newCost = scan.nextDouble();

        log.info("Enter a new Soldier rank: ");
        SoldierRank newRank =SoldierRank.selectRank(scan);

        scan.nextLine();
        log.info("Enter a new branch: ");
        Gender newGender = Gender.selectGender(scan);
        return new Soldier(newName, newCost, newRank, newGender);
    }
    private boolean isValidRank(SoldierRank soldierRank) {
        return Arrays.stream(SoldierRank.values())
                .anyMatch(rank ->rank==soldierRank);
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
