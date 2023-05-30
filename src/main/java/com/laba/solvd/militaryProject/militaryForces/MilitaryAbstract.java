package com.laba.solvd.militaryProject.militaryForces;

import com.laba.solvd.militaryProject.customLinkedList.CustomLinkedList;
import com.laba.solvd.militaryProject.militaryPersonnel.MilitaryPersonnelAbstract;
import com.laba.solvd.militaryProject.militaryEquipments.MilitaryEquipmentAbstract;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public abstract class MilitaryAbstract {
    public static final Logger logger = LogManager.getLogger(Army.class);
    public static final long budgetFor2023 = 816_000_000_000L;
    public static long totalRemainingBudget=816_000_000_000L;

    private ArrayList<MilitaryEquipmentAbstract> equipmentList=new ArrayList<>();
    private CustomLinkedList<MilitaryPersonnelAbstract> personnelList=new CustomLinkedList<>();

    public MilitaryAbstract(ArrayList<MilitaryEquipmentAbstract> equipmentList){
        this.equipmentList =equipmentList;
     }

    public MilitaryAbstract(CustomLinkedList<MilitaryPersonnelAbstract> personnelList){
        this.personnelList =personnelList;
    }
    public MilitaryAbstract(ArrayList<MilitaryEquipmentAbstract> equipmentList,CustomLinkedList<MilitaryPersonnelAbstract> personnelList){
        this.equipmentList =equipmentList;
        this.personnelList =personnelList;
    }

    public ArrayList<MilitaryEquipmentAbstract> getEquipmentList() {
        return equipmentList;
    }

    public CustomLinkedList<MilitaryPersonnelAbstract> getPersonnelList() {
        return personnelList;
    }

    public void setPersonnelList(CustomLinkedList<MilitaryPersonnelAbstract> personnelList) {
        this.personnelList = personnelList;
    }
    public void setEquipmentList(ArrayList<MilitaryEquipmentAbstract> equipmentList) {
        this.equipmentList = equipmentList;
    }

    public double getEquipmentCost() {
        double totalCost = 0;
        for (MilitaryEquipmentAbstract equipment : equipmentList) {
            totalCost += equipment.calculatePrice();
        }
        return totalCost;
    }

    public double getPersonnelSalary() {
        double totalSalary = 0;
        for (MilitaryPersonnelAbstract personnel : personnelList) {
            totalSalary += personnel.calculateSalary();
        }
        return totalSalary;
    }

}

