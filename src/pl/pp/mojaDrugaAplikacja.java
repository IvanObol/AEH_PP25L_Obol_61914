package pl.pp;

import java.util.Scanner;

public class mojaDrugaAplikacja { public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);

    // Zadanie 1

    int x = 10;
    int doubleX = 2 * x;
    int squareX = x * x;
    System.out.println("x = " + x);
    System.out.println("2 * x = " + doubleX);
    System.out.println("x² = " + squareX);

    // Zadanie 2

    System.out.print("Podaj swój wiek w latach: ");
    int ageInYears = scanner.nextInt();
    int ageInSeconds = ageInYears * 365 * 24 * 60 * 60; // Przeliczenie wieku na sekundy
    System.out.println("Twój wiek w sekundach: " + ageInSeconds);
    scanner.close();
}
}













