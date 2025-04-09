package pl.pp;

import java.util.Scanner;
// nowy kod
public class mojaPiataAplikacja {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj znak, który będzie wyświetlony: ");
        char znak = scanner.next().charAt(0);

        System.out.print("Podaj ile razy znak będzie wyświetlony w wierszu: ");
        int kolumny = scanner.nextInt();

        System.out.print("Podaj ile linii będzie wyświetlone: ");
        int linie = scanner.nextInt();

        drukujZnak(znak, kolumny, linie);

        scanner.close();
    }

    public static void drukujZnak(char znak, int ileZnakow, int ileLinii) {
        for (int i = 0; i < ileLinii; i++) {
            for (int j = 0; j < ileZnakow; j++) {
                System.out.print(znak);
            }
            System.out.println();
        }
    }
}



// Stary Kod
        /*
        System.out.println("Obliczenia i wyświetlenie wyniku dla wartości przypisanych w kodzie aplikacji");
        boolean gameOver = true;
        int score = 800;
        int levelCompleted = 5;
        int bonus = 100;

        int finalScore = score;
        if (gameOver) {
            finalScore += (levelCompleted * bonus);
            finalScore += 1000;
            System.out.println("Twoj wynik #1 to " + finalScore);
        }

        System.out.println("Obliczenia i wyświetlenie wyniku dla wartości przypisanych w kodzie aplikacji (innych niż poprzednio)");
        score = 10000;
        levelCompleted = 8;
        bonus = 200;

        finalScore = score;

        if (gameOver) {
            finalScore += (levelCompleted * bonus);
            finalScore += 1000;
            System.out.println("Twoj wynik #2 to " + finalScore);
        }

        System.out.println("Obliczenia za pomocą metody calculateScore_noArguments(), ale nadal dla wartości przypisanych w kodzie metody");
        calculateScore_noArguments();

        System.out.println("Obliczenia za pomocą metody calculateScore(), ale tym razem dla wartości wpisanych do argumentu wywołania metody");
        calculateScore_arguments_**/
