package com.laba.solvd.militaryProject.militaryPersonnel;
import com.laba.solvd.militaryProject.enums.Gender;
import com.laba.solvd.militaryProject.enums.OfficerRank;
import com.laba.solvd.militaryProject.exceptions.InvalidPersonnelException;
import com.laba.solvd.militaryProject.exceptions.InvalidRankException;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.Scanner;

public class Officer extends MilitaryPersonnelAbstract {
    public static Logger log = Logger.getLogger(Officer.class);
    Scanner scan=new Scanner(System.in);

    private OfficerRank officerRank;


    public Officer(String name, double salary, OfficerRank officerRank, Gender gender) throws InvalidPersonnelException, InvalidRankException {
        super(name, salary,gender);
        this.officerRank=officerRank;
        if (name==null || salary<=0 || !isValidRank(officerRank)) {
            Officer updatedOfficer = handleInvalidInput();
            this.setName(updatedOfficer.getName());
            this.setSalary(updatedOfficer.getSalary());
            this.setRank(updatedOfficer.getRank());
            this.setGender(updatedOfficer.getGender());
        }
    }
    private Officer handleInvalidInput() throws InvalidPersonnelException,InvalidRankException{
        Scanner scan = new Scanner(System.in);

        log.info("Enter a new name: ");
        String newName = scan.nextLine();

        log.info("Enter a new salary: ");
        double newCost = scan.nextDouble();

        log.info("Enter a new Officer rank: ");
        OfficerRank newRank =OfficerRank.selectRank(scan);

        scan.nextLine();
        log.info("Enter a new branch: ");
        Gender newGender = Gender.selectGender(scan);
        return new Officer(newName, newCost, newRank, newGender);
    }
    //using stream and lambda
    private boolean isValidRank(OfficerRank officerRank) {
        return Arrays.stream(OfficerRank.values())
                .anyMatch(rank ->rank==officerRank);

    }
//    private boolean isValidRank(OfficerRank officerRank) {
//        for (OfficerRank rank : OfficerRank.values()) {
//            if (rank == officerRank) {
//                return true;
//            }
//        }
//        return false;
//    }


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