package com.laba.solvd.militaryProject.interfaces;

import com.laba.solvd.militaryProject.militaryEquipments.MilitaryEquipmentAbstract;

public interface ManageInventory {
    void addEquipment(MilitaryEquipmentAbstract equipment);
    void removeEquipment(MilitaryEquipmentAbstract equipment);
    boolean checkAvailability(MilitaryEquipmentAbstract equipment);
}
