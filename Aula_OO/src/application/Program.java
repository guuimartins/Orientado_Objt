package application;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> list = new ArrayList<>();
        System.out.print("Quantos funcionarios seráo registrados? ");
        int N = sc.nextInt();

        for(int i=0; i<N; i++) {
            System.out.println();
            System.out.println("Funcionario #" + (i + 1) +":");
            System.out.print("Id: ");
            Integer id = sc.nextInt();
            System.out.print("Nome: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Salario: ");
            Double salary = sc.nextDouble();

            Employee emp = new Employee(id, name, salary);
            list.add(emp);

        }

        System.out.print("Entre com um numero id para aumento de salario: ");
        int idsalary = sc.nextInt();
        Integer pos = position(list, idsalary);
        if (pos == null){
            System.out.println("Esse ID não existe!");
        }
        else{
            System.out.print("Entre com uma porcentagem: ");
            double percent = sc.nextDouble();
            list.get(pos).increaseSalary(percent);
        }

        System.out.println();
        System.out.println("Lista de funcionário: ");
        for (Employee emp : list) {
            System.out.println(emp);
        }


        sc.close();
    }
    public static Integer position(List<Employee> list, int id) {
        for(int i = 0; i<list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return null;
    }
}
