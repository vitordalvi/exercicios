package application;

import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<TaxPayer> list = new ArrayList<>();

        System.out.print("Digite a quantidade de pessoas que irão pagar taxa: ");
        int n = sc.nextInt();

        for (int i=1; i<=n; i++) {
            System.out.println("Usuário #" + i);
            System.out.print("Individual ou empresa? (i/e): ");
            char ie = sc.next().charAt(0);
            if (ie == 'i') {
                System.out.print("Nome: ");
                String n1 = sc.nextLine();
                sc.nextLine();
                System.out.print("Ganho anual: ");
                double ganhoanual = sc.nextDouble();
                System.out.print("Gastos com saúde: ");
                double gastoscsaude = sc.nextDouble();
            }
            else {
                System.out.print("Nome: ");
                String n2 = sc.nextLine();
                sc.nextLine();
                System.out.print("Ganho anual: ");
                double ganhoanual1 = sc.nextDouble();
                System.out.print("Número de funcionários: ");
                int numfunc = sc.nextInt();
            }
        }

        double sum = 0.0;
        System.out.println();
        System.out.println("Taxas pagas:");
        for (TaxPayer tp : list) {
            double tax = tp.tax();
            System.out.println(tp.getName() + ": $ " + String.format("%.2f", tax));
            sum += tax;
        }

        System.out.println();
        System.out.println("Total de taxas pagas: $ " + String.format("%.2f", sum));

        sc.close();
    }
}