package pl.pp;

import java.util.Scanner;

public class mojaSzóstaAplikacja {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj liczbę, dla której chcesz obliczyć silnię: ");
        int n = scanner.nextInt();


        long startIter = System.nanoTime();
        long wynikIter = silniaIteracyjna(n);
        long czasIter = System.nanoTime() - startIter;


        long startRek = System.nanoTime();
        long wynikRek = silniaRekurencyjna(n);
        long czasRek = System.nanoTime() - startRek;

        System.out.println("Silnia (" + n + ") obliczona iteracyjnie: " + wynikIter);
        System.out.println("Czas wykonania (it): " + czasIter + " ns");

        System.out.println("Silnia (" + n + ") obliczona rekurencyjnie: " + wynikRek);
        System.out.println("Czas wykonania (rek) : " + czasRek + " ns");

        scanner.close();
    }


    public static long silniaIteracyjna(int n) {
        long wynik = 1;
        for (int i = 2; i <= n; i++) {
            wynik *= i;
        }
        return wynik;
    }


    public static long silniaRekurencyjna(int n) {
        if (n <= 1)
            return 1;
        return n * silniaRekurencyjna(n - 1);
    }
}
