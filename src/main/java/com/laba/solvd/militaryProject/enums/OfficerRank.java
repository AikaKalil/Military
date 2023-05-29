package com.laba.solvd.militaryProject.enums;

import java.util.Scanner;

public enum OfficerRank {
    SECOND_LIEUTENANT("Second Lieutenant", 3000.0),
    FIRST_LIEUTENANT("First Lieutenant", 4000.0),
    CAPTAIN("Captain", 5000.0),
    MAJOR("Major", 6000.0),
    LIEUTENANT_COLONEL("Lieutenant Colonel", 7000.0),
    COLONEL("Colonel", 8000.0),
    BRIGADIER_GENERAL("Brigadier General", 9000.0),
    MAJOR_GENERAL("Major General", 10000.0),
    LIEUTENANT_GENERAL("Lieutenant General", 11000.0),
    GENERAL("General", 12000.0);

    private final String rank;
    private final double bonus;

    OfficerRank(String rank, double bonus) {
        this.rank = rank;
        this.bonus = bonus;
    }

    public String getRank() {
        return rank;
    }

    public double getBonus() {
        return bonus;
    }

    public static OfficerRank selectRank(Scanner scanner) {
        String userInput = scanner.nextLine().toUpperCase();
        for (OfficerRank rank : OfficerRank.values()) {
            if (rank.name().equals(userInput)) {
                return rank;
            }
        }

        return null;
    }
}
