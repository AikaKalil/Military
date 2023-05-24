package com.laba.solvd.militaryProject;

import com.laba.solvd.militaryProject.enums.Branch;
import com.laba.solvd.militaryProject.enums.Gender;
import com.laba.solvd.militaryProject.enums.PilotRank;
import com.laba.solvd.militaryProject.exceptions.DuplicatePersonnelException;
import com.laba.solvd.militaryProject.exceptions.InsufficientFundsException;
import com.laba.solvd.militaryProject.exceptions.InvalidEquipmentException;
import com.laba.solvd.militaryProject.exceptions.InvalidPersonnelException;
import com.laba.solvd.militaryProject.interfaces.CalculateSalary;
import com.laba.solvd.militaryProject.militaryEquipments.Drones;
import com.laba.solvd.militaryProject.militaryEquipments.Helicopter;
import com.laba.solvd.militaryProject.militaryEquipments.MilitaryEquipmentAbstract;
import com.laba.solvd.militaryProject.militaryForces.AirForce;
import com.laba.solvd.militaryProject.militaryForces.Army;
import com.laba.solvd.militaryProject.militaryPersonnel.MilitaryPersonnelAbstract;
import com.laba.solvd.militaryProject.militaryPersonnel.Officer;
import com.laba.solvd.militaryProject.militaryPersonnel.Pilot;
import com.laba.solvd.militaryProject.militaryPersonnel.Soldier;
import org.apache.log4j.Logger;
import java.util.*;
import static com.laba.solvd.militaryProject.enums.OfficerRank.GENERAL;
import static com.laba.solvd.militaryProject.enums.SoldierRank.*;

public class Main {
    public static Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        ArrayList<MilitaryEquipmentAbstract> armyEquipmentList = new ArrayList<>();
        ArrayList<MilitaryPersonnelAbstract> armyPersonnelList = new ArrayList<>();

        ArrayList<MilitaryEquipmentAbstract> airForceEquipmentList = new ArrayList<>();
        ArrayList<MilitaryPersonnelAbstract> airForcePersonnelList = new ArrayList<>();


        Army army = new Army(armyEquipmentList, armyPersonnelList);
        AirForce airForce = new AirForce(airForceEquipmentList, airForcePersonnelList);

        try {
            MilitaryEquipmentAbstract armyEquipment1 = new Drones("Army Drone", 10000.00, 0,Branch.ARMY);
            armyEquipmentList.add(armyEquipment1);
            log.info("Military equipments successfully added to the list");

        } catch (InvalidEquipmentException e) {
            log.error("Invalid entry: " + e.getMessage());
        }

        try {
            MilitaryEquipmentAbstract armyEquipment2 = new Helicopter("Army Helicopter", 200000.00, 5, Branch.ARMY);
            armyEquipmentList.add(armyEquipment2);
            log.info("Military equipments successfully added to the list");
        } catch (InvalidEquipmentException e) {
            log.error("Invalid entry: " + e.getMessage());
        }

        try {
            MilitaryEquipmentAbstract airForceEquipment1 = new Drones("Air Force Drone", 50000.00, 20,Branch.AIR_FORCE);
            airForceEquipmentList.add(airForceEquipment1);
            log.info("Military equipments successfully added to the list");
        } catch (InvalidEquipmentException e) {
            log.error("Invalid entry: " + e.getMessage());
        }

        try {
            MilitaryEquipmentAbstract airForceEquipment2 = new Helicopter("Air Force Helicopter", 500000.00, 5,Branch.AIR_FORCE);
            airForceEquipmentList.add(airForceEquipment2);
            log.info("Military equipments successfully added to the list");
        } catch (InvalidEquipmentException e) {
            log.error("Invalid entry: " + e.getMessage());
        }

        try {
            MilitaryPersonnelAbstract armyPersonnel1 = new Soldier("Lucas Leon", 30000.00, SERGEANT,Gender.MALE);
            armyPersonnelList.add(armyPersonnel1);
            log.info("Added a new soldier to the Army personnel list.");
        } catch (DuplicatePersonnelException e) {
            log.error("Failed to add a new Soldier to the Army personnel list: " + e.getMessage());
        }catch (InvalidPersonnelException e){
            log.error("Failed to add a new soldier to the list");
        }
        try{
            MilitaryPersonnelAbstract armyPersonnel2 = new Officer("Peter Tonn", 100000.00,GENERAL,Gender.MALE);
            armyPersonnelList.add(armyPersonnel2);
            armyPersonnelList.add(armyPersonnel2);
            army.getPersonnelList();// Duplicate entry
            log.info("Added a new soldier to the Army personnel list.");
        } catch (DuplicatePersonnelException e) {
            log.error("Failed to add a new Soldier to the Army personnel list: " + e.getMessage());
        }catch (InvalidPersonnelException e) {
            log.error("Failed to add a new officer to the list");
        }

        try {
            MilitaryPersonnelAbstract airForcePersonnel1 = new Soldier("John Smith", 50000.00, SERGEANT,Gender.MALE);
            airForcePersonnelList.add(airForcePersonnel1);
            airForce.getPersonnelList();
            log.info("Added a new soldier to the Air Force personnel list: \n"+airForcePersonnel1.getInfo());
        } catch (DuplicatePersonnelException e) {
            log.error("Failed to add a new soldier to the Air Force  personnel list: " + e.getMessage());
        }catch (InvalidPersonnelException e) {
            log.error("Failed to add a new soldier to the list");
        }

        try {
            MilitaryPersonnelAbstract airForcePersonnel2 = new Officer("Conn Meyer", 80000.00, GENERAL,Gender.MALE);
            airForcePersonnelList.add(airForcePersonnel2);
            airForcePersonnelList.add(airForcePersonnel2);
            airForce.getPersonnelList();
            log.info("Added a new soldier to the Air Force personnel list: "+airForcePersonnel2.getInfo());
        } catch (DuplicatePersonnelException e) {
            log.error("Failed to add a new soldier to the Air Force personnel list: " + e.getMessage());
        }catch (InvalidPersonnelException e) {
            log.error("Failed to add a new officer to the list");
        }

        try {
            airForce.trackExpenses();
            log.info("You have enough money to spend");
        } catch (InsufficientFundsException e) {
            log.error("Failed to track expenses: " + e.getMessage());
            log.info("No more funds left in your budget!");
        }

        try {
            army.trackExpenses();
            log.info("You have enough money to spend");
        } catch (InsufficientFundsException e) {
            log.error("Failed to track expenses: " + e.getMessage());
            log.info("No more funds left in your budget!");
        }

        try {
            Officer officer = new Officer("John Smith", 50000.00, GENERAL,Gender.MALE);
            CalculateSalary officerSalaryCalculator = () -> officer.getSalary();
            double officerSalary = officerSalaryCalculator.calculateSalary() + GENERAL.getBonus();
            log.info("Officer "+officer.getName()+"'s salary: $" + officerSalary);
        } catch (InvalidPersonnelException e) {
            log.error("Failed to add a new officer to the list");
        }

        try {
            Soldier soldier = new Soldier("Stella Meyer", 30000.00, PRIVATE,Gender.FEMALE);
            CalculateSalary soldierSalaryCalculator = () -> soldier.getSalary();
            double soldierSalary = soldierSalaryCalculator.calculateSalary() + PRIVATE.getBonus();
            log.info("Soldier "+soldier.getName()+"'s salary: $" + soldierSalary);
        }catch(InvalidPersonnelException e){
            log.error("Failed to add a new soldier to the list");
        }

        try {
            Pilot pilot = new Pilot("Michael Jordan", 30000.00, PilotRank.CAPTAIN, Gender.MALE);
            CalculateSalary pilotSalaryCalculator = () -> pilot.getSalary();
            double pilotSalary = pilotSalaryCalculator.calculateSalary() + PilotRank.CAPTAIN.getBonus();
            log.info("Pilot "+pilot.getName()+"'s salary: $" + pilotSalary);
        }catch(InvalidPersonnelException e){
            log.error("Failed to add a new pilot to the list");
            }
    }
}