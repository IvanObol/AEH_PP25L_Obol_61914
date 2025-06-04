package pl.pp;
import java.io.*;
import java.util.Scanner;

public class mojaDwonastaAplikacja {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj ścieżkę do pliku wejściowego: ");
        String sciezkaWejsciowa = scanner.nextLine();

        System.out.print("Podaj ścieżkę do pliku wyjściowego: ");
        String sciezkaWyjsciowa = scanner.nextLine();

        File plikWejsciowy = new File(sciezkaWejsciowa);
        File plikWyjsciowy = new File(sciezkaWyjsciowa);

        int liczbaLinii = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(plikWejsciowy))) {
            String linia;

            while ((linia = reader.readLine()) != null) {
                liczbaLinii++;
            }

            System.out.println("Liczba linii w pliku: " + liczbaLinii);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(plikWyjsciowy))) {
                writer.write("Nazwa pliku: " + plikWejsciowy.getName());
                writer.newLine();
                writer.write("Liczba linii: " + liczbaLinii);
                writer.newLine();
                System.out.println("Zapisano dane do pliku: " + sciezkaWyjsciowa);
            } catch (IOException e) {
                System.out.println("Błąd zapisu do pliku wyjściowego.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Plik wejściowy nie istnieje. Podaj prawidłową ścieżkę.");
        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas odczytu pliku.");
        }

        scanner.close();
    }
}