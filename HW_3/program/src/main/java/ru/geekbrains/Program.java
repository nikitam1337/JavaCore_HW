package ru.geekbrains;

import ru.geekbrains.Comparators.EmployeeSalaryComparator;
import ru.geekbrains.Employees.Employee;
import ru.geekbrains.Employees.Freelancer;
import ru.geekbrains.Employees.Worker;

import java.util.Collections;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        List<Employee> employees = Worker.getEmployees(10);
        employees.addAll(Freelancer.getEmployees(10));

        for (Employee employee : employees) {
            System.out.println(employee);
        }

//        Сортировка по Имени и Фамилии:

//        Collections.sort(employees, new EmployeeNameComparator());
//        System.out.println();

//        Сортировка по Возрасту сотрудников:

//        Collections.sort(employees, new EmployeeAgeComparator());
//        System.out.println();

//        Сортировка сотрудников по Зарплате:

        Collections.sort(employees, new EmployeeSalaryComparator());
        System.out.println();

        for (Employee employee : employees) {
            System.out.println(employee);
        }


    }
}

