package pl.pp;
import java.util.*;


abstract class Pojazd {
    protected String nrRejestracyjny;
    protected String numerVin;
    protected String kolor;
    protected double cena;
    protected String spalanie;
    protected int poziomPaliwa;
    protected int przebieg;

    public Pojazd(String nrRejestracyjny, String numerVin, String kolor, double cena,
                  String spalanie, int poziomPaliwa, int przebieg) {
        this.nrRejestracyjny = nrRejestracyjny;
        this.numerVin = numerVin;
        this.kolor = kolor;
        this.cena = cena;
        this.spalanie = spalanie;
        this.poziomPaliwa = poziomPaliwa;
        this.przebieg = przebieg;
    }
    public void prowadz() {
        System.out.println("Prowadzę pojazd " + nrRejestracyjny);
    }

    public void zatankuj() {
        poziomPaliwa = 100;
        System.out.println("Zatankowano pojazd " + nrRejestracyjny);
    }
    public String getNrRejestracyjny() { return nrRejestracyjny; }
    public String getNumerVin() { return numerVin; }
    public String getKolor() { return kolor; }
    public double getCena() { return cena; }
    public String getSpalanie() { return spalanie; }
    public int getPoziomPaliwa() { return poziomPaliwa; }
    public int getPrzebieg() { return przebieg; }
}
interface typPaliwa {
    String getTypPaliwa();
}
class Osobowe extends Pojazd {
    private int liczbaDrzwi;

    public Osobowe(String nrRejestracyjny, String numerVin, String kolor, double cena,
                   String spalanie, int poziomPaliwa, int przebieg, int liczbaDrzwi) {
        super(nrRejestracyjny, numerVin, kolor, cena, spalanie, poziomPaliwa, przebieg);
        this.liczbaDrzwi = liczbaDrzwi;
    }

    public int getLiczbaDrzwi() { return liczbaDrzwi; }
}

class Dostawcze extends Pojazd {
    private double ladownosc;

    public Dostawcze(String nrRejestracyjny, String numerVin, String kolor, double cena,
                     String spalanie, int poziomPaliwa, int przebieg, double ladownosc) {
        super(nrRejestracyjny, numerVin, kolor, cena, spalanie, poziomPaliwa, przebieg);
        this.ladownosc = ladownosc;
    }

    public double getLadownosc() { return ladownosc; }
}

class Motocykle extends Pojazd {
    private double posiadaDostawke;

    public Motocykle(String nrRejestracyjny, String numerVin, String kolor, double cena,
                     String spalanie, int poziomPaliwa, int przebieg, double posiadaDostawke) {
        super(nrRejestracyjny, numerVin, kolor, cena, spalanie, poziomPaliwa, przebieg);
        this.posiadaDostawke = posiadaDostawke;
    }

    public double getPosiadaDostawke() { return posiadaDostawke; }
}

class SprzętBudowlany extends Pojazd {
    private double przepracowaneGodziny;

    public SprzętBudowlany(String nrRejestracyjny, String numerVin, String kolor, double cena,
                           String spalanie, int poziomPaliwa, int przebieg, double przepracowaneGodziny) {
        super(nrRejestracyjny, numerVin, kolor, cena, spalanie, poziomPaliwa, przebieg);
        this.przepracowaneGodziny = przepracowaneGodziny;
    }

    public double getPrzepracowaneGodziny() { return przepracowaneGodziny; }
}

class Diesel implements typPaliwa {
    @Override
    public String getTypPaliwa() {
        return "Diesel";
    }
}

class Benzyna implements typPaliwa {
    @Override
    public String getTypPaliwa() {
        return "Benzyna";
    }
}

class Elektryk implements typPaliwa {
    @Override
    public String getTypPaliwa() {
        return "Elektryczny";
    }
}

class TestWypozyczalni {
    private List<Pojazd> pojazdy;

    public TestWypozyczalni() {
        pojazdy = new ArrayList<>();
        utworzPrzykladowePojazdy();
    }

    private void utworzPrzykladowePojazdy() {
        pojazdy.add(new Osobowe("WA12345", "VIN123456789", "Czerwony", 150.0, "6.5L/100km", 80, 50000, 4));
        pojazdy.add(new Dostawcze("WA67890", "VIN987654321", "Biały", 200.0, "8.0L/100km", 60, 75000, 1500.0));
        pojazdy.add(new Motocykle("WA11111", "VIN111111111", "Czarny", 80.0, "4.0L/100km", 90, 25000, 0.0));
        pojazdy.add(new SprzętBudowlany("WA22222", "VIN222222222", "Żółty", 300.0, "15.0L/100km", 70, 10000, 2500.0));
    }

    public void wywolajMetody() {
        System.out.println("TESTOWANIE SYSTEMU WYPOŻYCZALNI\n");

        for (Pojazd pojazd : pojazdy) {
            System.out.println("Pojazd: " + pojazd.getClass().getSimpleName());
            System.out.println("Nr rejestracyjny: " + pojazd.getNrRejestracyjny());
            System.out.println("VIN: " + pojazd.getNumerVin());
            System.out.println("Kolor: " + pojazd.getKolor());
            System.out.println("Cena: " + pojazd.getCena() + " zł/dzień");
            System.out.println("Spalanie: " + pojazd.getSpalanie());
            System.out.println("Poziom paliwa: " + pojazd.getPoziomPaliwa() + "%");
            System.out.println("Przebieg: " + pojazd.getPrzebieg() + " km");

            if (pojazd instanceof Osobowe) {
                System.out.println("Liczba drzwi: " + ((Osobowe) pojazd).getLiczbaDrzwi());
            } else if (pojazd instanceof Dostawcze) {
                System.out.println("Ładowność: " + ((Dostawcze) pojazd).getLadownosc() + " kg");
            } else if (pojazd instanceof Motocykle) {
                System.out.println("Posiada dostawkę: " + (((Motocykle) pojazd).getPosiadaDostawke() > 0 ? "Tak" : "Nie"));
            } else if (pojazd instanceof SprzętBudowlany) {
                System.out.println("Przepracowane godziny: " + ((SprzętBudowlany) pojazd).getPrzepracowaneGodziny() + " h");
            }

            pojazd.prowadz();
            if (pojazd.getPoziomPaliwa() < 50) {
                pojazd.zatankuj();
            }

            System.out.println("------------------------");
        }

        System.out.println("\nTESTOWANIE TYPÓW PALIWA ");

        typPaliwa[] typy = {new Diesel(), new Benzyna(), new Elektryk()};

        for (typPaliwa typ : typy) {
            System.out.println("Typ paliwa: " + typ.getTypPaliwa());
        }
    }
}

public class mojaCzternastaAplikacja {
    public static void main(String[] args) {
        System.out.println("SYSTEM WYPOŻYCZALNI POJAZDÓW ");

        TestWypozyczalni test = new TestWypozyczalni();
        test.wywolajMetody();

        System.out.println("\nKONIEC TESTOWANIA");
        System.out.println("System wypożyczalni działa poprawnie!");
    }}