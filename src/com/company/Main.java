package com.company;

import com.company.Employee.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

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

        System.out.println("Empoyees over 30");
        System.out.println("================");
        employees.forEach(employee -> {
            if (employee.getAge() > 30){
                System.out.println(employee.getName());
            }
        });

        System.out.println("\nEmployess 30 and younger");
        System.out.println("========================");
        employees.forEach(employee -> {
            if (employee.getAge() <= 30){
                System.out.println(employee.getName());
            }
        });


//        for (Employee employee : employees) {
//            if (employee.getAge() > 30) {
//                System.out.println(employee.getAge());
//            }
//        }
    }
}
