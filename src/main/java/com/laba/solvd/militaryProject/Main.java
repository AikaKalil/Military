package com.laba.solvd.militaryProject;

import com.laba.solvd.militaryProject.exceptions.DuplicateEntryException;
import com.laba.solvd.militaryProject.exceptions.InsufficientFundsException;
import com.laba.solvd.militaryProject.exceptions.InvalidQuantityException;
import com.laba.solvd.militaryProject.interfaces.CalculateSalary;
import com.laba.solvd.militaryProject.militaryEquipments.Drones;
import com.laba.solvd.militaryProject.militaryEquipments.Helicopter;
import com.laba.solvd.militaryProject.militaryEquipments.MilitaryEquipmentAbstract;
import com.laba.solvd.militaryProject.militaryForces.AirForce;
import com.laba.solvd.militaryProject.militaryForces.Army;
import com.laba.solvd.militaryProject.militaryPersonnel.MilitaryPersonnelAbstract;
import com.laba.solvd.militaryProject.militaryPersonnel.Officer;
import com.laba.solvd.militaryProject.militaryPersonnel.Soldier;
import org.apache.log4j.Logger;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import static com.laba.solvd.militaryProject.enums.SoldierRank.PRIVATE;
import static com.laba.solvd.militaryProject.enums.SoldierRank.SERGEANT;

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
            MilitaryEquipmentAbstract armyEquipment1 = new Drones("Army Drone", 10000.00, 0);
            MilitaryEquipmentAbstract armyEquipment2 = new Helicopter("Army Helicopter", 200000.00, 5);
            armyEquipmentList.add(armyEquipment1);
            armyEquipmentList.add(armyEquipment2);
            MilitaryEquipmentAbstract airForceEquipment1 = new Drones("Air Force Drone", 50000.00, 20);
            MilitaryEquipmentAbstract airForceEquipment2 = new Helicopter("Air Force Helicopter", 500000.00, 5);
            airForceEquipmentList.add(airForceEquipment1);
            airForceEquipmentList.add(airForceEquipment2);
            log.info("Military equipments successfully added to the list");
        } catch (InvalidQuantityException e) {
            log.error("Invalid quantity: " + e.getMessage());
        }
        try{
            //MilitaryPersonnelAbstract armyPersonnel1 = new Soldier("Lucas Leon", 30000.00, SERGEANT);
            MilitaryPersonnelAbstract armyPersonnel2 = new Officer("Peter Tonn", 100000.00, "General");
            //armyPersonnelList.add(armyPersonnel1);
            armyPersonnelList.add(armyPersonnel2);
            armyPersonnelList.add(armyPersonnel2);
            army.getPersonnelList();// Duplicate entry
            log.info("Added a new soldier to the Army personnel list.");
        } catch (DuplicateEntryException e) {
            log.error("Failed to add a new Soldier to the Army personnel list: " + e.getMessage());
        }
        try {
            MilitaryPersonnelAbstract airForcePersonnel1 = new Soldier("John Smith", 50000.00, SERGEANT);
            airForcePersonnelList.add(airForcePersonnel1);
            airForce.getPersonnelList();
            log.info("Added a new soldier to the Air Force personnel list.");
        } catch (DuplicateEntryException e) {
            log.error("Failed to add a new soldier to the Air Force  personnel list: " + e.getMessage());
        }

        try {
            MilitaryPersonnelAbstract airForcePersonnel2 = new Officer("Conn Meyer", 80000.00, "General");
            airForcePersonnelList.add(airForcePersonnel2);
            airForcePersonnelList.add(airForcePersonnel2);
            airForce.getPersonnelList();
            log.info("Added a new soldier to the Air Force personnel list. ");
        } catch (DuplicateEntryException e) {
            log.error("Failed to add a new soldier to the Air Force personnel list: " + e.getMessage());
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

        Officer officer = new Officer("John Smith", 50000.00, "General");
        CalculateSalary officerSalaryCalculator = () -> {
            double baseSalary = Officer.RANK_SALARY_MAP.getOrDefault("General", 0.0);
            return baseSalary+officer.getSalary();
        };
        double officerSalary = officerSalaryCalculator.calculateSalary();
        log.info("Officer Salary: $" + officerSalary);

        Soldier soldier = new Soldier("Mike Tyson", 30000.00, PRIVATE);
        CalculateSalary soldierSalaryCalculator = () -> soldier.getSalary();
            double salary = soldierSalaryCalculator.calculateSalary()+ PRIVATE.getBaseSalary();
        log.info("Soldier Salary: $" + salary);

        try {
            File file = new File("/Users/aizhamalmamatkalilkyzy/Downloads/newOne.txt");
            Scanner scanner = new Scanner(file);
            log.info("Write your text here: ");
            String text = scanner.nextLine();
            String[] words = text.split(" ");
            Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
            int count = uniqueWords.size();

            FileWriter writer = new FileWriter("newOne.txt");
            writer.write(Integer.toString(count));
            writer.close();
            log.info("Unique word count written to file successfully.");
        } catch(IOException e) {
            e.printStackTrace();
            log.error("An error occurred!", e);
        }

    }
}