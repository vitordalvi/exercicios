package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Insira o nome do departamento: ");
        String departmentName = sc.nextLine();
        System.out.println("Insira as informações desse funcionário:");
        System.out.print("Qual é o nome desse funcionário: ");
        String workerName = sc.nextLine();
        System.out.print("Qual é o cargo destinado para esse funcionário: ");
        String workerLevel = sc.nextLine();
        System.out.print("Qual é o salário base para esse funcionário: ");
        double baseSalary = sc.nextDouble();
        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));

        System.out.print("Quantos contratos para esse funcionário? ");
        int n = sc.nextInt();

        for (int i=1; i<=n; i++) {
            System.out.println("Digite o contrato de número #" + i + ":");
            System.out.print("Data (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(sc.next());
            System.out.print("Valor por hora: ");
            double valuePerHour = sc.nextDouble();
            System.out.print("Duração: ");
            int hours = sc.nextInt();
            HourContract contract = new HourContract(contractDate, valuePerHour, hours);
            worker.addContract(contract);
        }

        System.out.println();
        System.out.print("Digite o mês e o ano para calcular o ganho (MM/YYYY): ");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.println("Nome: " + worker.getName());
        System.out.println("Departamento: " + worker.getDepartment().getName());
        System.out.println("Recebido" +
                ": " + monthAndYear + "\nSalário recebido: " + String.format("%.2f", worker.income(year, month)));

        sc.close();
    }
}