package ru.geekbrains.Comparators;

import ru.geekbrains.Employees.Employee;

import java.util.Comparator;

public class EmployeeSalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        double res = o1.getSalary() - o2.getSalary();
        if (res == 0) {
            return 1;
        }
        return (int) res;
    }

}