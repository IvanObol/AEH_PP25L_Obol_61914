package pl.pp;

import java.util.Scanner;

public class mojaCzwartaAplikacja {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Kalkulator");
            System.out.print("Podaj pierwszą liczbę: ");
            double num1 = scanner.nextDouble();

            System.out.print("Podaj operator (+, -, *, /): ");
            char operator = scanner.next().charAt(0);

            System.out.print("Podaj drugą liczbę: ");
            double num2 = scanner.nextDouble();

            double result;

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        System.out.println("Dzielenie przez zero niemozliwe");
                        continue;
                    }
                    break;
                default:
                    System.out.println("Nieprawidłowy operator!");
                    continue;
            }

            System.out.println("Wynik: " + result);

            System.out.print("Czy chcesz kontynuować? (tak czy nie): ");
            String kontynuuj = scanner.next();
            if (!kontynuuj.equalsIgnoreCase("tak")) {
                break;
            }
        }

        scanner.close();
    }
}
