package com.laba.solvd.militaryProject.militaryPersonnel;

import com.laba.solvd.militaryProject.enums.Gender;
import com.laba.solvd.militaryProject.interfaces.CalculateSalary;
import com.laba.solvd.militaryProject.interfaces.GetInfo;
import org.apache.log4j.Logger;
import java.util.Objects;


public abstract class MilitaryPersonnelAbstract implements CalculateSalary, GetInfo {
 public static Logger log = Logger.getLogger(MilitaryPersonnelAbstract.class);
    private String name;
    private double salary;
    private String rank;
    private Gender gender;

    public MilitaryPersonnelAbstract(String name, double salary,Gender gender) {
        this.name = name;
        this.salary = salary;
        this.gender=gender;
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
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

   @Override
    public double calculateSalary() {
        return salary;
    }

    @Override
    public abstract String getInfo();
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MilitaryPersonnelAbstract other = (MilitaryPersonnelAbstract) obj;
        return Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }






}
