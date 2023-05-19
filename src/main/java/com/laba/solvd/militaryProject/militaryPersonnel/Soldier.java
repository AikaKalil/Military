package com.laba.solvd.militaryProject.militaryPersonnel;


import com.laba.solvd.militaryProject.enums.SoldierRank;

public class Soldier extends MilitaryPersonnelAbstract{
    private SoldierRank soldierRank;
    public Soldier(String name, double salary, SoldierRank soldierRank) {
        super(name, salary);
        this.soldierRank = soldierRank;
    }
    @Override
    public double calculateSalary() {
        double baseSalary = soldierRank.getBaseSalary();
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
