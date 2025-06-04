package pl.pp;
import java.io.*;
import java.util.Scanner;

public class mojaTrzynastaAplikacja {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String sciezkaWejsciowa;
        File plikWejsciowy;

        while (true) {
            System.out.print("Podaj ścieżkę do pliku wejściowego: ");
            sciezkaWejsciowa = scanner.nextLine();

            plikWejsciowy = new File(sciezkaWejsciowa);

            if (plikWejsciowy.exists() && plikWejsciowy.isFile()) {
                break;
            } else {
                System.out.println("Plik wejściowy nie istnieje. Podaj prawidłową ścieżkę.");
            }
        }

        System.out.print("Podaj ścieżkę do pliku wyjściowego: ");
        String sciezkaWyjsciowa = scanner.nextLine();

        File plikWyjsciowy = new File(sciezkaWyjsciowa);

        int liczbaSlów = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(plikWejsciowy))) {
            String linia;

            while ((linia = reader.readLine()) != null) {
                linia = linia.trim();

                if (!linia.isEmpty()) {
                    String[] slowa = linia.split("\\s+");
                    liczbaSlów += slowa.length;
                }
            }

            System.out.println("Nazwa pliku: " + plikWejsciowy.getName());
            System.out.println("Liczba słów w pliku: " + liczbaSlów);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(plikWyjsciowy))) {
                writer.write("Nazwa pliku: " + plikWejsciowy.getName());
                writer.newLine();
                writer.write("Liczba słów: " + liczbaSlów);
                writer.newLine();
                System.out.println("Zapisano dane do pliku: " + sciezkaWyjsciowa);
            } catch (IOException e) {
                System.out.println("Błąd zapisu do pliku wyjściowego: " + e.getMessage());
            }

        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas odczytu pliku: " + e.getMessage());
        }

        scanner.close();
    }}
