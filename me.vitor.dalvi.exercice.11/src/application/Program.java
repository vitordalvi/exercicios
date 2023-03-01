package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Product> list = new ArrayList<>();

        System.out.print("Digite o número de produtos: ");
        int n = sc.nextInt();

        for(int i=1; i<n; i++) {
            System.out.println("Digite os dados do produto #" + i + ":");
            System.out.print("Comum, usado ou importado? (C/U/I): ");
            char type = sc.next().charAt(0);
            System.out.print("Nome: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Preço: ");
            double price = sc.nextDouble();
            if(type == 'C') {
                list.add(new Product(name, price));
            }
            else if (type == 'U') {
                System.out.print("Data de fabricação (DD/MM/YYYY): ");
                LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                list.add(new UsedProduct(name, price, date));
            }
            else {
                System.out.print("Taxa de importação: ");
                double customsFee = sc.nextDouble();
                list.add(new ImportedProduct(name, price, customsFee));
            }
        }
        System.out.println();
        System.out.println("Etiquetas de preço: ");
        for (Product prod : list) {
            System.out.println(prod.priceTag());
        }

        sc.close();
    }

}
