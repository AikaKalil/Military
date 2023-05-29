package com.laba.solvd.militaryProject.enums;

import java.util.Scanner;

public enum SoldierRank {
    PRIVATE("Private", 500.0),
    CORPORAL("Corporal", 1000.0),
    SERGEANT("Sergeant", 2000.0),
    STAFF_SERGEANT("Staff Sergeant", 3000.0),
    SERGEANT_FIRST_CLASS("Sergeant First Class", 4000.0),
    MASTER_SERGEANT("Master Sergeant", 5000.0),
    FIRST_SERGEANT("First Sergeant", 6000.0),
    SERGEANT_MAJOR("Sergeant Major", 7000.0),
    COMMAND_SERGEANT_MAJOR("Command Sergeant Major", 8000.0);

    private final String rank;
    private final double bonus;

    SoldierRank(String rank, double baseSalary) {
        this.rank = rank;
        this.bonus = baseSalary;
    }
    public String getRank() {
        return rank;
    }

    public double getBonus() {
        return bonus;
    }

    public static SoldierRank selectRank(Scanner scanner) {
        String userInput = scanner.nextLine().toUpperCase();
        for (SoldierRank rank : SoldierRank.values()) {
            if (rank.name().equals(userInput)) {
                return rank;
            }
        }

        return null;
    }
}
