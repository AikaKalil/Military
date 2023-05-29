package com.laba.solvd.militaryProject.militaryForces;

import com.laba.solvd.militaryProject.customLinkedList.CustomLinkedList;
import com.laba.solvd.militaryProject.exceptions.DuplicatePersonnelException;
import com.laba.solvd.militaryProject.exceptions.InsufficientFundsException;
import com.laba.solvd.militaryProject.interfaces.CalculatePrice;
import com.laba.solvd.militaryProject.interfaces.TrackExpenses;
import com.laba.solvd.militaryProject.militaryPersonnel.MilitaryPersonnelAbstract;
import com.laba.solvd.militaryProject.militaryEquipments.MilitaryEquipmentAbstract;

import java.util.ArrayList;

public class AirForce extends MilitaryAbstract{
    private long airForceBudget=185000000000L;

    public AirForce(ArrayList<MilitaryEquipmentAbstract>equipmentList) {
        super(equipmentList);
    }

    public AirForce(CustomLinkedList<MilitaryPersonnelAbstract> personnelList) {
        super(personnelList);

    }

    public long getAirForceBudget() {
        return airForceBudget;
    }

    public TrackExpenses trackExpenses = () -> {
        double totalExpenses = getEquipmentCost() + getPersonnelSalary();
        if (airForceBudget < totalExpenses) {
            throw new InsufficientFundsException("Insufficient funds for expenses.");
        }
        airForceBudget -= totalExpenses;
        logger.info("Expenses tracked successfully");
        logger.info("Remaining budget for Air Force: $" + getAirForceBudget());
        totalRemainingBudget -= airForceBudget;
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
        double totalCost =getEquipmentList().stream().mapToDouble(MilitaryEquipmentAbstract::calculatePrice).sum();
//        for (MilitaryEquipmentAbstract equipment : getEquipmentList()) {
//            totalCost += equipment.calculatePrice();
//        }
        return totalCost;
    };



}
