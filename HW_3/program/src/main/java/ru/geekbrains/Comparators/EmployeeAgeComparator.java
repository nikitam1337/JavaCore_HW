package ru.geekbrains.Comparators;

import ru.geekbrains.Employees.Employee;

import java.util.Comparator;

public class EmployeeAgeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        int res = o1.getAge() - o2.getAge();
        if (res == 0) {
            return 1;
        }
        return res;
    }
}

