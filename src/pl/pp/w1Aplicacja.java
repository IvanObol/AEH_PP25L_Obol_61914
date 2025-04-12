package pl.pp;
import java.util.*;

public class w1Aplicacja {
    public static void main(String[] args) {
        int[] losoweLiczby = new int[6];
        int[] liczbyUzytkownika = new int[6];
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        Set<Integer> zbior = new HashSet<>();


        while (zbior.size() < 6) {
            zbior.add(rand.nextInt(49) + 1);
        }

        int i = 0;
        for (int liczba : zbior) {
            losoweLiczby[i++] = liczba;
        }


        Set<Integer> zbiorUzytkownika = new HashSet<>();
        System.out.println("Podaj 6 różnych liczb z przedziału 1-49:");
        while (zbiorUzytkownika.size() < 6) {
            int liczba = scanner.nextInt();
            if (liczba < 1 || liczba > 49) {
                System.out.println("Liczba musi być z przedziału 1-49!");
            } else if (zbiorUzytkownika.contains(liczba)) {
                System.out.println("Ta liczba już jest podana!");
            } else {
                zbiorUzytkownika.add(liczba);
            }
        }

        i = 0;
        for (int liczba : zbiorUzytkownika) {
            liczbyUzytkownika[i++] = liczba;
        }


        int licznik = 0;
        for (int x : losoweLiczby) {
            for (int y : liczbyUzytkownika) {
                if (x == y) {
                    licznik++;
                }
            }
        }


        System.out.println("Wylosowane liczby: " + Arrays.toString(losoweLiczby));
        System.out.println("Twoje liczby:      " + Arrays.toString(liczbyUzytkownika));
        System.out.println("Identyczne liczby: " + licznik);
    }
}