package pl.pp;

import java.util.Scanner;

public class mojaCzwartaAplikacja {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 while (true) {
     System.out.println("Podaj gorny i dolny limit");
     int lower = scanner.nextInt();
     int upper = scanner.nextInt();
     if (lower>=upper) {
         System.out.println("Gorna muszi byc większa od dolnej");
         break;
     }
     int square = lower * lower;
     int square2 = upper * upper;
     int summ = 0;
     for (int i = lower; i <= upper; i++) {
         summ += i*i;

     }
     System.out.println("Summa kwardratow międze dolnej " +square + " i gornej " + square2 + " jest " + summ);
    }
}}
