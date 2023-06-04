package com.laba.solvd.militaryProject;

import com.laba.solvd.militaryProject.customLinkedList.CustomLinkedList;
import com.laba.solvd.militaryProject.enums.*;
import com.laba.solvd.militaryProject.exceptions.*;
import com.laba.solvd.militaryProject.interfaces.CalculateSalary;
import com.laba.solvd.militaryProject.militaryEquipments.Drones;
import com.laba.solvd.militaryProject.militaryEquipments.Helicopter;
import com.laba.solvd.militaryProject.militaryEquipments.MilitaryEquipmentAbstract;
import com.laba.solvd.militaryProject.militaryEquipments.Tank;
import com.laba.solvd.militaryProject.militaryForces.AirForce;
import com.laba.solvd.militaryProject.militaryForces.Army;
import com.laba.solvd.militaryProject.militaryPersonnel.MilitaryPersonnelAbstract;
import com.laba.solvd.militaryProject.militaryPersonnel.Officer;
import com.laba.solvd.militaryProject.militaryPersonnel.Pilot;
import com.laba.solvd.militaryProject.militaryPersonnel.Soldier;
import org.apache.log4j.Logger;
import java.util.*;
import java.util.stream.Collectors;
import static com.laba.solvd.militaryProject.enums.Branch.ARMY;
import static com.laba.solvd.militaryProject.enums.Gender.FEMALE;
import static com.laba.solvd.militaryProject.enums.Gender.MALE;
import static com.laba.solvd.militaryProject.enums.OfficerRank.*;
import static com.laba.solvd.militaryProject.enums.PilotRank.CAPTAIN;
import static com.laba.solvd.militaryProject.enums.SoldierRank.*;


public class Main {
    public static Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args)  {

        ArrayList<MilitaryEquipmentAbstract> armyEquipmentList = new ArrayList<>();
        ArrayList<MilitaryEquipmentAbstract> airForceEquipmentList = new ArrayList<>();

        CustomLinkedList<MilitaryPersonnelAbstract> airForcePersonnelList = new CustomLinkedList<>();
        CustomLinkedList<MilitaryPersonnelAbstract> armyPersonnelList = new CustomLinkedList<>();

        Army armyEquipment = new Army(armyEquipmentList);
        Army armyPersonnel = new Army(armyPersonnelList);
        AirForce airForceEquipment = new AirForce(airForceEquipmentList);
        AirForce airForcePersonnel = new AirForce(airForcePersonnelList);
        try {
            MilitaryEquipmentAbstract armyEquipment1 = new Drones("Army Drone", 10000.00, 0, ARMY);
            armyEquipmentList.add(armyEquipment1);
            log.info("Military equipments successfully added to the list" + armyEquipment1.getInfo());
        } catch (InvalidEquipmentException e) {
            log.error("Invalid entry: " + e.getMessage());
        }
        try {
            MilitaryEquipmentAbstract armyEquipment3 = new Drones("Army Drone", 15000.00, 10, ARMY);
            armyEquipmentList.add(armyEquipment3);
            log.info("Military equipments successfully added to the list" + armyEquipment3.getInfo());
        } catch (InvalidEquipmentException e) {
            log.error("Invalid entry: " + e.getMessage());
        }


        try {
            MilitaryEquipmentAbstract airForceEquipment1 = new Drones("AIR FORCE", 15000.00, 10, Branch.AIR_FORCE);
            airForceEquipmentList.add(airForceEquipment1);
            airForceEquipment.addEquipment(airForceEquipment1);
            airForceEquipment.removeEquipment(airForceEquipment1);
            log.info("Military equipments successfully added to the list");
        } catch (InvalidEquipmentException e) {
            log.error("Invalid entry: " + e.getMessage());
        }

        try {
            MilitaryEquipmentAbstract airForceEquipment2 = new Helicopter("Air Force Helicopter", 500000.00, 5, Branch.AIR_FORCE);
            airForceEquipmentList.add(airForceEquipment2);
            log.info("Military equipments successfully added to the list");
        } catch (InvalidEquipmentException e) {
            log.error("Invalid entry: " + e.getMessage());
        }

        try {
            MilitaryEquipmentAbstract armyEquipment2 = new Tank("Air Force Tank", 250000.00, 5, Branch.AIR_FORCE);
            airForceEquipmentList.add(armyEquipment2);
            log.info("Military equipments successfully added to the list");
        } catch (InvalidEquipmentException e) {
            log.error("Invalid entry: " + e.getMessage());
        }

        List<MilitaryEquipmentAbstract> expensiveArmyEquipment = armyEquipmentList.stream()
                .filter(equipment -> equipment.getCost() > 10000.00)
                .sorted(Comparator.comparing(equipment -> equipment.getInfo()))
                .collect(Collectors.toList());
        expensiveArmyEquipment.forEach(equipment -> log.info("Expensive equipment-" + equipment.getInfo()));
//        for (MilitaryEquipmentAbstract equipment : expensiveArmyEquipment) {
//            log.info("Expensive equipment- " + equipment.getInfo());
//        }

        List<MilitaryEquipmentAbstract> expensiveAirForceEquipment = airForceEquipmentList.stream()
                .filter(equipment -> equipment.getCost() > 10000.00)
                .sorted(Comparator.comparing(equipment -> equipment.getInfo()))
                .collect(Collectors.toList());
        expensiveAirForceEquipment.forEach(equipment -> log.info("Expensive equipment-" + equipment.getInfo()));


        List<MilitaryEquipmentAbstract> equipmentsByPrice = airForceEquipmentList.stream()
                .sorted(Comparator.comparing(equipment -> equipment.getCost()))
                .collect(Collectors.toList());
        equipmentsByPrice.forEach(equipment -> log.info("List of equipments sorted by price" + equipment.getInfo()));


        try {
            MilitaryPersonnelAbstract armyPersonnel1 = new Soldier("Lucas Leon", 30000.00, MASTER_SERGEANT, MALE);
            armyPersonnelList.add(armyPersonnel1);
            log.info("Added a new soldier to the Army personnel list.");
        } catch (DuplicatePersonnelException e) {
            log.error("Failed to add a new Soldier to the Army personnel list: " + e.getMessage());
        } catch (InvalidPersonnelException e) {
            log.error("Failed to add a new soldier to the list");
        } catch (InvalidRankException e) {
            log.error("Failed to add a new Soldier to the list " + e.getMessage());
        }

        try {
            MilitaryPersonnelAbstract armyPersonnel2 = new Officer("Peter Tonn", 80000.00, BRIGADIER_GENERAL, MALE);
            armyPersonnelList.add(armyPersonnel2);
            log.info("Added a new soldier to the Army personnel list.");
            armyPersonnelList.add(armyPersonnel2);
            armyPersonnel.getPersonnelList();
        } catch (DuplicatePersonnelException e) {
            log.error("Failed to add a new Soldier to the Army personnel list: " + e.getMessage());
        } catch (InvalidPersonnelException e) {
            log.error("Failed to add a new Soldier to the list" + e.getMessage());
        } catch (InvalidRankException e) {
            log.error("Failed to add a new Soldier to the list " + e.getMessage());
        }

        try {
            MilitaryPersonnelAbstract airForcePersonnel1 = new Soldier("John Smith", 700000.00, COMMAND_SERGEANT_MAJOR, MALE);
            log.info("Air Force personnel is empty: "+airForcePersonnelList.isEmpty()+".The size of Air Force personnel is: "+airForcePersonnelList.size());
            airForcePersonnelList.add(airForcePersonnel1);
            airForcePersonnel.getPersonnelList();
            log.info("Air Force personnel is empty: "+airForcePersonnelList.isEmpty()+".The size of Air Force personnel is: "+airForcePersonnelList.size());
            log.info("Added a new soldier to the Air Force personnel list: \n" + airForcePersonnel1.getInfo());
        } catch (DuplicatePersonnelException e) {
            log.error("Failed to add a new soldier to the Air Force  personnel list: " + e.getMessage());
        } catch (InvalidPersonnelException e) {
            log.error("Failed to add a new soldier to the list");
        } catch (InvalidRankException e) {
            log.error("Failed to add a new Soldier to the list " + e.getMessage());
        }

        try {
            MilitaryPersonnelAbstract airForcePersonnel2 = new Officer("Silja Reuter", 90000.00, GENERAL, FEMALE);
            airForcePersonnelList.add(airForcePersonnel2);
            airForcePersonnelList.add(airForcePersonnel2);
            airForcePersonnel.getPersonnelList();
            log.info("Added a new soldier to the Air Force personnel list: " + airForcePersonnel2.getInfo());
        } catch (DuplicatePersonnelException e) {
            log.error("Failed to add a new soldier to the Air Force personnel list: " + e.getMessage());
        } catch (InvalidPersonnelException e) {
            log.error("Failed to add a new officer to the list");
        } catch (InvalidRankException e) {
            log.error("Failed to add a new Soldier to the list " + e.getMessage());
        }

        try {
            airForceEquipment.trackExpenses.trackExpenses();
            log.info("You have enough money to spend");
        } catch (InsufficientFundsException e) {
            log.error("Failed to track expenses: " + e.getMessage());
            log.info("No more funds left in your budget!");
        }

        try {
            armyEquipment.trackExpenses.trackExpenses();
            log.info("You have enough money to spend");
        } catch (InsufficientFundsException e) {
            log.error("Failed to track expenses: " + e.getMessage());
            log.info("No more funds left in your budget!");
        }

        try {
            Officer officer = new Officer("John Smith", 50000.00, GENERAL, MALE);
            CalculateSalary officerSalaryCalculator = () -> officer.getSalary();
            double officerSalary = officerSalaryCalculator.calculateSalary() + GENERAL.getBonus();
            log.info("Officer " + officer.getName() + "'s salary: $" + officerSalary);

        } catch (InvalidPersonnelException e) {
            log.error("Failed to add a new officer to the list");
        } catch (InvalidRankException e) {
            log.error("Failed to add a new Soldier to the list " + e.getMessage());
        }

        try {
            Soldier soldier = new Soldier("Stella Meyer", 30000.00, PRIVATE, Gender.FEMALE);
            CalculateSalary soldierSalaryCalculator = () -> soldier.getSalary();
            double soldierSalary = soldierSalaryCalculator.calculateSalary() + PRIVATE.getBonus();
            log.info("Soldier " + soldier.getName() + "'s salary: $" + soldierSalary);

        } catch (InvalidPersonnelException e) {
            log.error("Failed to add a new soldier to the list");
        } catch (InvalidRankException e) {
            log.error("Failed to add a new Soldier to the list " + e.getMessage());
        }

        try {
            Pilot pilot = new Pilot("Michael Jordan", 30000.00, CAPTAIN, MALE);
            CalculateSalary pilotSalaryCalculator = () -> pilot.getSalary();
            double pilotSalary = pilotSalaryCalculator.calculateSalary() + CAPTAIN.getBonus();
            log.info("Pilot " + pilot.getName() + "'s salary: $" + pilotSalary);
        } catch (InvalidPersonnelException e) {
            log.error("Failed to add a new pilot to the list");
        } catch (InvalidRankException e) {
            log.error("Failed to add a new Soldier to the list " + e.getMessage());
        }


        //part of lambda exp+stream is located inside Army class
        double armyEquipmentTotalPrice = armyEquipment.calculateEquipmentPrice.calculatePrice();
        log.info("Total Army equipment price: $" + armyEquipmentTotalPrice);
        //part of lambda exp+stream is located inside Air Force class
        double airForceEquipmentTotalPrice = airForceEquipment.calculateEquipmentPrice.calculatePrice();
        log.info("Total Air Force equipment price: $" + airForceEquipmentTotalPrice);

    }
    }