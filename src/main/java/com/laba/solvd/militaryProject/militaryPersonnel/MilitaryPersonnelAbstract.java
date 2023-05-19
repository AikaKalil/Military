package com.laba.solvd.militaryProject.militaryPersonnel;

import com.laba.solvd.militaryProject.Main;
import com.laba.solvd.militaryProject.interfaces.CalculateSalary;
import com.laba.solvd.militaryProject.interfaces.GetInfo;
import org.apache.log4j.Logger;

import java.util.Objects;


public abstract class MilitaryPersonnelAbstract implements CalculateSalary, GetInfo {
 public static Logger log = Logger.getLogger(Main.class);
    private String name;
    private double salary;
    private String rank;


    public MilitaryPersonnelAbstract(String name, double salary,String rank) {
        this.name = name;
        this.salary = salary;
        this.rank = rank;


    }
    public MilitaryPersonnelAbstract(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

   @Override
    public double calculateSalary() {
        return salary;
    }

    @Override
    public abstract String getInfo();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MilitaryPersonnelAbstract)) return false;
        MilitaryPersonnelAbstract that = (MilitaryPersonnelAbstract) o;
        return Double.compare(that.salary, salary) == 0 &&
                Objects.equals(name, that.name) &&
                Objects.equals(rank, that.rank);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, salary, rank);
    }






}
