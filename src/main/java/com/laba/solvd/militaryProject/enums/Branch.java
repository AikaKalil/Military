package com.laba.solvd.militaryProject.enums;

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
}
