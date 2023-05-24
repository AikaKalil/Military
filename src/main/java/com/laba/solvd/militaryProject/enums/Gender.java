package com.laba.solvd.militaryProject.enums;

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
}
