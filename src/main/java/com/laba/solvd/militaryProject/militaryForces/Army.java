package com.laba.solvd.militaryProject.militaryForces;

import com.laba.solvd.militaryProject.exceptions.DuplicatePersonnelException;
import com.laba.solvd.militaryProject.exceptions.InsufficientFundsException;
import com.laba.solvd.militaryProject.militaryPersonnel.MilitaryPersonnelAbstract;
import com.laba.solvd.militaryProject.militaryEquipments.MilitaryEquipmentAbstract;

import java.util.ArrayList;

public class Army extends MilitaryAbstract {
    private long armyBudget = 175000000000L;

    public Army(ArrayList<MilitaryEquipmentAbstract> equipmentList, ArrayList<MilitaryPersonnelAbstract> personnelList) {
        super(equipmentList, personnelList);
        }

    public long getArmyBudget() {
        return armyBudget;
    }

    public void setArmyBudget(long armyBudget) {
        this.armyBudget = armyBudget;
    }

    @Override
    public long trackExpenses() throws InsufficientFundsException {
        double totalExpenses = getEquipmentCost() + getPersonnelSalary();
        if (armyBudget < totalExpenses) {
            //logger.error("Insufficient funds for expenses.");
            throw new InsufficientFundsException("Insufficient funds for expenses.");

        }
            armyBudget -= totalExpenses;
            logger.info("Expenses tracked successfully");
            logger.info("Remaining budget for Air Force: $" + getArmyBudget());
            totalRemainingBudget -= armyBudget;
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
