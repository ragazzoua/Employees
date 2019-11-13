package com.company;

import com.company.Employee.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;

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

        Function<Employee, String> getLastName = (Employee employee) -> {
            return employee.getName().substring(employee.getName().indexOf(' ') + 1);
        };
        String lastName = getLastName.apply(employees.get(1));
        System.out.println(lastName);

        Function<Employee, String> getFirstName = (Employee employee) -> {
            return employee.getName().substring(0, employee.getName().indexOf(' '));
        };
        String firstName = getFirstName.apply(employees.get(1));
        System.out.println(firstName);


        /*printEmployesByAge(employees, "Employes > 30", employee -> employee.getAge() > 30);
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

        Random random = new Random();
        Supplier<Integer> randomSuplire = () -> random.nextInt(100);
        for (int i =0; i<10; i++ ){
            System.out.println(randomSuplire.get());
        }
        System.out.println("-------------------------------");
        for (int i =0; i<10; i++ ){
            System.out.println(random.nextInt(100));
        }

        employees.forEach(employee -> {
            String lastName = employee.getName().substring(employee.getName().indexOf(' ') + 1);
            System.out.println("Last name is " + lastName);
        });*/
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

        Random random1 = new Random();
        for (Employee employee : employees) {
            if (random1.nextBoolean()) {
                System.out.println(getName(getFirstName, employee));
            } else {
                System.out.println(getName(getLastName, employee));
            }
        }

        Function<Employee, String> upperCase = employee -> employee.getName().toUpperCase();
        Function<String, String> firstNameNew = name -> name.substring(0, name.indexOf(' '));
        Function chainedFunction = upperCase.andThen(firstNameNew);
        System.out.println(chainedFunction.apply(employees.get(0)));

        BiFunction<String, Employee, String> concatAge = (String name, Employee employee) -> {
            return name.concat(" " + employee.getAge());
        };

        String uppername = upperCase.apply(employees.get(0));
        System.out.println(concatAge.apply(uppername, employees.get(0)));

        IntUnaryOperator incBy5 = i -> i + 5;
        System.out.println(incBy5.applyAsInt(10));
    }


    private static String getName(Function<Employee, String> getName, Employee employee) {
        return getName.apply(employee);
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
