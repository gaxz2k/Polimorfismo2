import entities.Employee;
import entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of Employees: ");
        int n = sc.nextInt();

        for(int i = 1; i<=n ; i++) {
            System.out.println("Employee #" + i + " data");
            System.out.print("Outsourced (y/n)? ");
            char outsourced = sc.next().charAt(0);
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Hours: ");
            Integer hours = sc.nextInt();
            System.out.print("Value per hour: ");
            Double valuePerHour = sc.nextDouble();

            switch(outsourced){
                case 'y':
                    System.out.print("Additional charge: ");
                    double additionalCharge = sc.nextDouble();
                    employeeList.add(new OutsourcedEmployee(name,hours,valuePerHour,additionalCharge));
                    break;
                case 'n':
                    employeeList.add(new Employee(name, hours, valuePerHour));
                    break;
                default:
                    System.out.println("Invalid !");
            }
        }

        System.out.println();
        System.out.println("Payments: ");
        for (Employee emp : employeeList){
            System.out.println(emp.getName() + " - $ " + String.format("%.2f",emp.payment()));
        }

        sc.close();
    }
}