package com.laba.solvd.militaryProject.militaryPersonnel;
import java.util.HashMap;
import java.util.Map;

public class Officer extends MilitaryPersonnelAbstract {

    public static final Map<String, Double> RANK_SALARY_MAP;
    static {
        RANK_SALARY_MAP = new HashMap<>();
        RANK_SALARY_MAP.put("Second Lieutenant", 3000.0);
        RANK_SALARY_MAP.put("First Lieutenant", 4000.0);
        RANK_SALARY_MAP.put("Captain", 5000.0);
        RANK_SALARY_MAP.put("Major", 6000.0);
        RANK_SALARY_MAP.put("Lieutenant Colonel", 7000.0);
        RANK_SALARY_MAP.put("Colonel", 8000.0);
        RANK_SALARY_MAP.put("Brigadier General", 9000.0);
        RANK_SALARY_MAP.put("Major General", 10000.0);
        RANK_SALARY_MAP.put("Lieutenant General", 11000.0);
        RANK_SALARY_MAP.put("General", 12000.0);
    }
    public Officer(String name, double salary, String rank) {
        super(name, salary,rank);
    }
    @Override
    public double calculateSalary() {
        double baseSalary = RANK_SALARY_MAP.getOrDefault(getRank(), 0.0);
        return baseSalary + super.getSalary();
    }
    @Override
    public String getInfo() {
        return getName()+" is a soldier with rank "+getRank()+" and salary "+calculateSalary();
    }

}