package application;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class EmployeeProgram {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("How many employees will be registered: ");
        int N = sc.nextInt();

        // lista do tipo funcionário
        List<Employee> list = new ArrayList<>();

        for (int i=0; i<N; i++) {

            System.out.println();
            System.out.println("Employee #" + (i + 1) + ":");

            System.out.print("Id: ");
            Integer id = sc.nextInt();

            System.out.print("Name: ");
            // tem que dar antes de dar nextline por conta do netint de cima
            sc.nextLine();
            String name = sc.nextLine();

            System.out.print("Salary: ");
            Double salary = sc.nextDouble();

            Employee emp = new Employee(id, name, salary);

            list.add(emp);
        }

        System.out.println("Enter the employee id that will have salary increase: ");
        int idsalary = sc.nextInt();


        Integer pos = position(list, idsalary);
        if (pos == null) {
            System.out.println("This id does not exist!");
        }
        else {
            System.out.print("Enter the porcentage: ");
            double percentage = sc.nextDouble();

            list.get(pos).increaseSalary(percentage);
        }

        System.out.println("List of employees: ");
        for (Employee emp : list) {
            System.out.println(emp);
        }

        sc.close();
    }

    public static Integer position(List<Employee> list, int id) {
        for (int i=0; i<list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return null;
    }
}
