package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos números você vai digitar?");
        int n = sc.nextInt();

        int[] vet = new int[n];

        for(int i = 0; i < n; i++) {
            System.out.print("Digite um número: ");
            vet[i] = sc.nextInt();
        }

        System.out.println("os números negativos digitados são: ");
        for (int i = 0; i<n; i++) {
            if(vet[i] < 0) {
                System.out.println(vet[i]);
            }
        }


        sc.close();
    }
}
