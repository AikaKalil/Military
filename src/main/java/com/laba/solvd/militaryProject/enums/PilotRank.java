package com.laba.solvd.militaryProject.enums;

import java.util.Scanner;

public enum PilotRank {
    SECOND_LIEUTENANT("Second Lieutenant", 1000),
    FIRST_LIEUTENANT("First Lieutenant", 2000),
    CAPTAIN("Captain", 3000),
    MAJOR("Major", 4000),
    LIEUTENANT_COLONEL("Lieutenant Colonel", 5000),
    COLONEL("Colonel", 6000);

    private final String rank;
    private final double bonus;

    PilotRank(String rankName, int bonus) {
        this.rank = rankName;
        this.bonus = bonus;
    }

    public String getRank() {
        return rank;
    }

    public double getBonus() {
        return bonus;
    }

    public static PilotRank selectRank(Scanner scanner) {
        String userInput = scanner.nextLine().toUpperCase();
        for (PilotRank rank : PilotRank.values()) {
            if (rank.name().equals(userInput)) {
                return rank;
            }
        }

        return null;
    }
}
