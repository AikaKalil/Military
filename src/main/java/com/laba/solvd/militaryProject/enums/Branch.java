package com.laba.solvd.militaryProject.enums;

import java.util.Scanner;

public enum Branch {
        ARMY("Army"),
        NAVY("Navy"),
        AIR_FORCE("Air Force"),
        MARINES("Marines"),
        COAST_GUARD("Coast Guard");

        private final String displayName;

        Branch(String displayName) {
                this.displayName = displayName;
        }

        public String getDisplayName() {
                return displayName;
        }

        public static Branch selectBranch(Scanner scanner) {
                String userInput = scanner.nextLine().toUpperCase();
                for (Branch branch : Branch.values()) {
                        if (branch.name().equals(userInput)) {
                                return branch;
                        }
                }

                return null;
        }
}
