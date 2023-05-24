package com.laba.solvd.militaryProject.militaryForces;

import com.laba.solvd.militaryProject.exceptions.DuplicatePersonnelException;
import com.laba.solvd.militaryProject.exceptions.InsufficientFundsException;
import com.laba.solvd.militaryProject.militaryPersonnel.MilitaryPersonnelAbstract;
import com.laba.solvd.militaryProject.militaryEquipments.MilitaryEquipmentAbstract;

import java.util.ArrayList;

public class AirForce extends MilitaryAbstract{
    private long airForceBudget=185000000000L;

    public AirForce(ArrayList<MilitaryEquipmentAbstract> equipmentList, ArrayList<MilitaryPersonnelAbstract> personnelList) {
        super(equipmentList, personnelList);
    }

    public AirForce(ArrayList<MilitaryEquipmentAbstract> equipmentList, ArrayList<MilitaryPersonnelAbstract> personnelList,long airForceBudget) {
        super(equipmentList, personnelList);
        this.airForceBudget=airForceBudget;
    }

    public long getAirForceBudget() {
        return airForceBudget;
    }

    @Override
    public long trackExpenses() throws InsufficientFundsException {
        double totalExpenses = getEquipmentCost() + getPersonnelSalary();
        if (airForceBudget < totalExpenses) {
            logger.error("Insufficient funds for expenses.");
            throw new InsufficientFundsException("Insufficient funds for expenses.");
        }

        airForceBudget -= totalExpenses;
        logger.info("Expenses tracked successfully");
        logger.info("Remaining budget for Air Force: $" + getAirForceBudget());
        totalRemainingBudget -= airForceBudget;
        logger.info("Remaining total budget for 2023: $" + totalRemainingBudget);
        return totalRemainingBudget;
    }

    @Override
    public ArrayList<MilitaryPersonnelAbstract> getPersonnelList() throws DuplicatePersonnelException {
        ArrayList<MilitaryPersonnelAbstract> uniquePersonnelList = new ArrayList<>();
        for (MilitaryPersonnelAbstract personnel : super.getPersonnelList()) {
            if (!uniquePersonnelList.contains(personnel)) {
                uniquePersonnelList.add(personnel);
            } else if(uniquePersonnelList.contains(personnel)){
                logger.error("Personnel already exists.");
                throw new DuplicatePersonnelException("Duplicates not allowed");
            }

        }
        return uniquePersonnelList;
    }


}
