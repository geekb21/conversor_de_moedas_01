package br.com.alura.conversordemoedas;

import java.util.Scanner;

public class ConversorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorDeMoedas conversor = new ConversorDeMoedas();

        int opcao = 0;

        while (opcao != 7) {
            System.out.println("***********************************");
            System.out.println(" Seja bem-vindo(a) ao Conversor de Moeda =]");
            System.out.println("***********************************");
            System.out.println("1) Dólar => Peso argentino");
            System.out.println("2) Libra esterlina => Dólar");
            System.out.println("3) Dinar => Real brasileiro");
            System.out.println("4) Real brasileiro => Dólar");
            System.out.println("5) Dólar => Peso colombiano");
            System.out.println("6) Ienes japonês => Dólar");
            System.out.println("7) Sair");
            System.out.print("Escolha uma opção válida: ");

            opcao = scanner.nextInt();

            if (opcao >= 1 && opcao <= 6) {
                System.out.print("\nDigite o valor que deseja converter: ");
                double valor = scanner.nextDouble();

                String de = "", para = "";

                switch (opcao) {
                    case 1 -> { de = "USD"; para = "ARS"; }
                    case 2 -> { de = "GBP"; para = "USD"; }
                    case 3 -> { de = "BHD"; para = "BRL"; }
                    case 4 -> { de = "BRL"; para = "USD"; }
                    case 5 -> { de = "USD"; para = "COP"; }
                    case 6 -> { de = "JPY"; para = "USD"; }
                }

                try {
                    double resultado = conversor.converter(de, para, valor);
                    System.out.printf("Resultado: %.2f %s%n", resultado, para);
                } catch (Exception e) {
                    System.out.println("Erro na conversão: " + e.getMessage());
                }

                System.out.println();
            } else if (opcao == 7) {
                System.out.println("Saindo... Obrigado por usar o conversor!");
            } else {
                System.out.println("Opção inválida, tente novamente.\n");
            }
        }

        scanner.close();
    }
}