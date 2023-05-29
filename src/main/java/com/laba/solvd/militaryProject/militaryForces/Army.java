package com.laba.solvd.militaryProject.militaryForces;

import com.laba.solvd.militaryProject.customLinkedList.CustomLinkedList;
import com.laba.solvd.militaryProject.exceptions.DuplicatePersonnelException;
import com.laba.solvd.militaryProject.exceptions.InsufficientFundsException;
import com.laba.solvd.militaryProject.interfaces.CalculatePrice;
import com.laba.solvd.militaryProject.interfaces.TrackExpenses;
import com.laba.solvd.militaryProject.militaryEquipments.MilitaryEquipmentAbstract;
import com.laba.solvd.militaryProject.militaryPersonnel.MilitaryPersonnelAbstract;

import java.util.ArrayList;

public class Army extends MilitaryAbstract {
    private long armyBudget = 175000000000L;

    public Army(ArrayList<MilitaryEquipmentAbstract> equipmentList) {

        super(equipmentList);
       }

    public Army(CustomLinkedList<MilitaryPersonnelAbstract> personnelList) {
        super(personnelList);

    }
    public long getArmyBudget() {
        return armyBudget;
    }
    public void setArmyBudget(long armyBudget) {
        this.armyBudget = armyBudget;
    }
public TrackExpenses trackExpenses = () -> {
        double totalExpenses = getEquipmentCost() + getPersonnelSalary();
        if (armyBudget < totalExpenses) {
            throw new InsufficientFundsException("Insufficient funds for expenses.");
        }
        armyBudget -= totalExpenses;
        logger.info("Expenses tracked successfully");
        logger.info("Remaining budget for Air Force: $" + getArmyBudget());
        totalRemainingBudget -= armyBudget;
        logger.info("Remaining total budget for 2023: $" + totalRemainingBudget);
        return totalRemainingBudget;
    };

    @Override
    public CustomLinkedList<MilitaryPersonnelAbstract> getPersonnelList() throws DuplicatePersonnelException {
        CustomLinkedList<MilitaryPersonnelAbstract> uniquePersonnelList = new CustomLinkedList<>();
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

    public CalculatePrice calculateEquipmentPrice = () -> {
        double totalCost = getEquipmentList().stream()
                .mapToDouble(MilitaryEquipmentAbstract::calculatePrice).sum();
        return totalCost;
    };


}
