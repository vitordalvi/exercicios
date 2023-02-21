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

        System.out.print("Quantos funcionários serão registrados?");
        int N = sc.nextInt();

        for(int i=0; i<N; i++) {

            System.out.println();
            System.out.println("Funcionário #" + (i + 1)  + ":");
            System.out.print("ID: ");
            Integer id = sc.nextInt();
            while(hasId(list, id)) {
                System.out.println("Esse ID já foi usado, tente novamente.");
                id = sc.nextInt();
            }
            System.out.print("Nome: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Salário: ");
            Double salary = sc.nextDouble();

            Employee emp = new Employee(id, name, salary);

            list.add(emp);
        }

        System.out.println();
        System.out.print("Digite o ID do funcionário que terá um aumento no salário: ");
        int idSalary = sc.nextInt();
        Employee emp = list.stream().filter(x -> x.getId() == idSalary).findFirst().orElse(null);
        if (emp == null) {
            System.out.println("Esse ID não existe!");
        }
        else {
            System.out.print("Digite a porcentagem que você quer aumentar: ");
            double percent = sc.nextDouble();
            emp.increaseSalary(percent);
        }

        System.out.println();
        System.out.println("Lista de funcionários:");
        for (Employee e : list) {
            System.out.println(e);
        }

        sc.close();
    }

    public static Integer position(List<Employee> list, int id) {
        for (int i =0; i< list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return null;
    }
    public static boolean hasId(List<Employee> list, int id) {
        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return emp != null;
    }
}

