package pl.pp;
import java.util.Scanner;

public class mojaTrzeciaAplikacja {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Zadanie 1
            while (true) {
                System.out.print("Podaj liczbę dni (ujemna wartość kończy program): ");
                int days = scanner.nextInt();

                if (days < 0) {
                    break;
                }

                int weeks = days / 7;
                int remainingDays = days % 7;

                System.out.println(days + " dni to " + weeks + " tygodnie i " + remainingDays + " dni");
            }

            // Zadanie 2
            while (true) {
                System.out.print("Podaj temperaturę w Celsjuszach (wpisz -1 aby zakończyć): ");
                double celsius = scanner.nextDouble();

                if (celsius == -1) {
                    break;
                }

                double fahrenheit = 1.8 * celsius + 32.0;
                double kelvin = celsius + 273.16;

                System.out.printf("Celsjusz: %.2f, Fahrenheit: %.2f, Kelvin: %.2f\n", celsius, fahrenheit, kelvin);
            }

            scanner.close();
        }
    }









