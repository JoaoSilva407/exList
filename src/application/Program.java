package application;

import entities.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Joao
 */
public class Program {

    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        
        System.out.print("How many employees will be registered? ");
        int num = input.nextInt();
        
        List<Employee> list = new ArrayList<>();
        
        for(int i=1; i<=num; i++) {
            System.out.println();
            System.out.println("Employee #" + i + ":");
            
            System.out.print("Id: ");
            int id = input.nextInt();
            while(hasId(list, id)) {
                System.out.println();
                System.out.print("Id already taken. Try again: ");
                id = input.nextInt();
                System.out.println();
            }
            
            System.out.print("Name: ");
            input.nextLine();
            String name = input.nextLine();
            System.out.print("Salary: ");
            double salary = input.nextDouble();
            list.add(new Employee(id, name, salary));
        }
        
        System.out.println();
        System.out.print("Enter the employee id that will have salary increase : ");
        double id = input.nextDouble();
        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        if(emp == null) {
            System.out.println("This id does not exist!");
        }
        else {
            System.out.print("Enter the percentage: ");
            double percentage = input.nextDouble();
            emp.increaseSalary(percentage);
        }
        
        System.out.println();
        System.out.println("List of employees:");
        for(Employee obj : list) {
            System.out.println(obj);
        }
        input.close();
    }
    
    public static boolean hasId(List<Employee> list, int id) {
        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return emp != null;
    }
}
