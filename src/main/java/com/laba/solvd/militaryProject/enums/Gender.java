package com.laba.solvd.militaryProject.enums;

import java.util.Scanner;

public enum Gender {
        MALE('M'),
        FEMALE('F');

        private final char displayName;

        Gender(char displayName) {
            this.displayName = displayName;
        }

        public char getDisplayName() {
            return displayName;
        }

    public static Gender selectGender(Scanner scanner) {
        String userInput = scanner.nextLine().toUpperCase();
        for (Gender gender : Gender.values()) {
            if (gender.name().equals(userInput)) {
                return gender;
            }
        }

        return null;
    }
}
