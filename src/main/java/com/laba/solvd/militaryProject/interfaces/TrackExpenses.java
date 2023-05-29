package com.laba.solvd.militaryProject.interfaces;

import com.laba.solvd.militaryProject.exceptions.InsufficientFundsException;
@FunctionalInterface
public interface TrackExpenses {
    long trackExpenses() throws InsufficientFundsException;
}
