package com.laba.solvd.militaryProject.militaryPersonnel;
import com.laba.solvd.militaryProject.enums.Gender;
import com.laba.solvd.militaryProject.enums.OfficerRank;
import com.laba.solvd.militaryProject.enums.SoldierRank;
import com.laba.solvd.militaryProject.exceptions.InvalidPersonnelException;
import com.laba.solvd.militaryProject.militaryEquipments.Drones;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Officer extends MilitaryPersonnelAbstract {
    public static Logger log = Logger.getLogger(Officer.class);
    Scanner scan=new Scanner(System.in);

    private OfficerRank officerRank;

    public Officer(String name, double salary, OfficerRank officerRank, Gender gender) throws InvalidPersonnelException {
        super(name, salary,gender);
        this.officerRank=officerRank;
        if (name==null || salary<=0 || officerRank==null){
            log.info("Enter a name: ");
            String newName = scan.nextLine();

            log.info("Enter a salary: ");
            double newCost = scan.nextDouble();

        }
    }
    @Override
    public double calculateSalary() {
        double baseSalary = officerRank.getBonus();
        return baseSalary + super.getSalary();
    }
    @Override
    public String getInfo() {
        return getName()+" is a soldier with rank "+getRank()+" and salary "+calculateSalary();
    }

    @Override
    public String getRank() {

        return officerRank.getRank();
    }
}