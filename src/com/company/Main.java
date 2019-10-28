package com.company;

import com.company.Employee.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);
        Employee red = new Employee("Red RidingHood", 35);
        Employee charming = new Employee("Prince Charming", 31);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);
        employees.add(red);
        employees.add(charming);

        printEmployesByAge(employees, "Employes > 30", employee -> employee.getAge() > 30);
        printEmployesByAge(employees, "\nEmployes < 30", employee -> employee.getAge() > 30);
        printEmployesByAge(employees, "\nEmployes < 25", new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() < 25;
            }
        });

        IntPredicate greaterThan15 = i -> i > 15;
        IntPredicate lessThan15 = i -> i < 100;
        int a = 20;
        System.out.println(greaterThan15.test(10));

        System.out.println(greaterThan15.and(lessThan15).test(a));


//        System.out.println("\nEmployess 30 and younger");
//        System.out.println("========================");
//        employees.forEach(employee -> {
//            if (employee.getAge() <= 30){
//                System.out.println(employee.getName());
//            }
//        });

//        for (Employee employee : employees) {
//            if (employee.getAge() > 30) {
//                System.out.println(employee.getAge());
//            }
//        }
    }

    private static void printEmployesByAge(List<Employee> employees, String ageText, Predicate<Employee> ageCondition) {
        System.out.println(ageText);
        System.out.println("================");
        for (Employee employee : employees) {
            if (ageCondition.test(employee)) {
                System.out.println(employee.getName());
            }
        }
    }
}
