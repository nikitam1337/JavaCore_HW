package ru.geekbrains.Employees;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Доработать в рамках домашней работы
 */
public class Freelancer extends Employee {


    protected Freelancer(String surName, String name, int age, double salary) {
        super(surName, name, age, salary);
    }

    @Override
    public double calculateSalary() {
        double monthlySalary = 20.8 * 8 * salary;
        return monthlySalary;
    }


    public static Employee getInstance() {
        return new Freelancer(
                surNames[random.nextInt(surNames.length)],
                names[random.nextInt(surNames.length)],
                random.nextInt(18, 50),
                random.nextInt(250, 1500));
    }

    public static List<Employee> getEmployees(int count) {
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < count; i++)
            employees.add(getInstance());
        return employees;
    }

    @Override
    public String toString() {
        return String.format("%s %s Возраст:%s; Фрилансер; Среднемесячная заработная плата: %.2f (руб.)",
                surName, name, age, calculateSalary());
    }
    }
