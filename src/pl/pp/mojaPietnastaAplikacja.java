package pl.pp;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


abstract class Pojazd {
    protected String nrRejestracyjny;
    protected String numerVin;
    protected String kolor;
    protected double cena;
    protected String spalanie;
    protected int poziomPaliwa;
    protected int przebieg;
    protected boolean dostepny;
    protected String lokalizacja;

    public Pojazd(String nrRejestracyjny, String numerVin, String kolor, double cena,
                  String spalanie, int poziomPaliwa, int przebieg) {
        this.nrRejestracyjny = nrRejestracyjny;
        this.numerVin = numerVin;
        this.kolor = kolor;
        this.cena = cena;
        this.spalanie = spalanie;
        this.poziomPaliwa = poziomPaliwa;
        this.przebieg = przebieg;
        this.dostepny = true;
        this.lokalizacja = "Centrum";
    }

    public void prowadz() {
        System.out.println("Prowadzę pojazd " + nrRejestracyjny);
        this.dostepny = false;
    }

    public void zatankuj() {
        poziomPaliwa = 100;
        System.out.println("Zatankowano pojazd " + nrRejestracyjny);
    }


    public void zakonczJazde() {
        System.out.println("Zakończono jazdę pojazdem " + nrRejestracyjny);
        this.dostepny = true;
    }

    public void ustawLokalizacje(String nowaLokalizacja) {
        this.lokalizacja = nowaLokalizacja;
    }


    public String getNrRejestracyjny() { return nrRejestracyjny; }
    public String getNumerVin() { return numerVin; }
    public String getKolor() { return kolor; }
    public double getCena() { return cena; }
    public String getSpalanie() { return spalanie; }
    public int getPoziomPaliwa() { return poziomPaliwa; }
    public int getPrzebieg() { return przebieg; }
    public boolean isDostepny() { return dostepny; }
    public String getLokalizacja() { return lokalizacja; }
    public void setDostepny(boolean dostepny) { this.dostepny = dostepny; }
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


class Rower extends Pojazd {
    private String typRoweru;
    private boolean koszyk;
    private int liczbaRzutow;

    public Rower(String nrRejestracyjny, String numerVin, String kolor, double cena,
                 String spalanie, int poziomPaliwa, int przebieg, String typRoweru,
                 boolean koszyk, int liczbaRzutow) {
        super(nrRejestracyjny, numerVin, kolor, cena, spalanie, poziomPaliwa, przebieg);
        this.typRoweru = typRoweru;
        this.koszyk = koszyk;
        this.liczbaRzutow = liczbaRzutow;
    }

    @Override
    public void prowadz() {
        System.out.println("Rozpoczynam jazdę rowerem " + nrRejestracyjny + " (" + typRoweru + ")");
        this.dostepny = false;
    }

    public String getTypRoweru() { return typRoweru; }
    public boolean maKoszyk() { return koszyk; }
    public int getLiczbaRzutow() { return liczbaRzutow; }
}

class Hulajnoga extends Pojazd {
    private double maksymalnaPredkosc;
    private boolean skladana;
    private String typSilnika;

    public Hulajnoga(String nrRejestracyjny, String numerVin, String kolor, double cena,
                     String spalanie, int poziomPaliwa, int przebieg, double maksymalnaPredkosc,
                     boolean skladana, String typSilnika) {
        super(nrRejestracyjny, numerVin, kolor, cena, spalanie, poziomPaliwa, przebieg);
        this.maksymalnaPredkosc = maksymalnaPredkosc;
        this.skladana = skladana;
        this.typSilnika = typSilnika;
    }

    @Override
    public void prowadz() {
        System.out.println("Rozpoczynam jazdę hulajnogą " + nrRejestracyjny +
                " (max " + maksymalnaPredkosc + " km/h)");
        this.dostepny = false;
    }

    public double getMaksymalnaPredkosc() { return maksymalnaPredkosc; }
    public boolean isSkladana() { return skladana; }
    public String getTypSilnika() { return typSilnika; }
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


class Uzytkownik {
    private String imie;
    private String email;
    private String numerTelefonu;
    private double saldo;
    private List<Wypozyczenie> historiaWypozyczen;

    public Uzytkownik(String imie, String email, String numerTelefonu, double saldo) {
        this.imie = imie;
        this.email = email;
        this.numerTelefonu = numerTelefonu;
        this.saldo = saldo;
        this.historiaWypozyczen = new ArrayList<>();
    }

    public boolean czyMozeWypozyczac() {
        return saldo >= 5.0;
    }

    public void doladujSaldo(double kwota) {
        saldo += kwota;
        System.out.println("Doładowano konto " + imie + " o " + kwota + " zł. Saldo: " + saldo + " zł");
    }

    public void odliczKoszt(double koszt) {
        saldo -= koszt;
    }

    public String getImie() { return imie; }
    public String getEmail() { return email; }
    public double getSaldo() { return saldo; }
    public List<Wypozyczenie> getHistoriaWypozyczen() { return historiaWypozyczen; }
}

class Wypozyczenie {
    private Uzytkownik uzytkownik;
    private Pojazd pojazd;
    private LocalDateTime czasRozpoczecia;
    private LocalDateTime czasZakonczenia;
    private double koszt;
    private String lokalizacjaStart;
    private String lokalizacjaKoniec;

    public Wypozyczenie(Uzytkownik uzytkownik, Pojazd pojazd, String lokalizacjaStart) {
        this.uzytkownik = uzytkownik;
        this.pojazd = pojazd;
        this.czasRozpoczecia = LocalDateTime.now();
        this.lokalizacjaStart = lokalizacjaStart;
    }

    public void zakonczWypozyczenie(String lokalizacjaKoniec) {
        this.czasZakonczenia = LocalDateTime.now();
        this.lokalizacjaKoniec = lokalizacjaKoniec;

        long minuty = java.time.Duration.between(czasRozpoczecia, czasZakonczenia).toMinutes();
        double godziny = Math.max(1, Math.ceil(minuty / 60.0));
        this.koszt = godziny * pojazd.getCena();

        uzytkownik.odliczKoszt(koszt);
        pojazd.ustawLokalizacje(lokalizacjaKoniec);
        pojazd.zakonczJazde();

        uzytkownik.getHistoriaWypozyczen().add(this);
    }

    public void wyswietlSzczegoly() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        System.out.println("Wypożyczenie:");
        System.out.println("   Pojazd: " + pojazd.getNrRejestracyjny());
        System.out.println("   Start: " + czasRozpoczecia.format(formatter) + " (" + lokalizacjaStart + ")");
        if (czasZakonczenia != null) {
            System.out.println("   Koniec: " + czasZakonczenia.format(formatter) + " (" + lokalizacjaKoniec + ")");
            System.out.println("   Koszt: " + koszt + " zł");
        } else {
            System.out.println("   Status: W trakcie");
        }
    }

    public Pojazd getPojazd() { return pojazd; }
    public double getKoszt() { return koszt; }
    public LocalDateTime getCzasZakonczenia() { return czasZakonczenia; }
}


class TestWypozyczalni {
    private List<Pojazd> pojazdy;
    private List<Uzytkownik> uzytkownicy;
    private List<Wypozyczenie> aktywneWypozyczenia;

    public TestWypozyczalni() {
        pojazdy = new ArrayList<>();
        uzytkownicy = new ArrayList<>();
        aktywneWypozyczenia = new ArrayList<>();
        utworzPrzykladowePojazdy();
        utworzPrzykladowychUzytkownikow();
    }

    private void utworzPrzykladowePojazdy() {
        pojazdy.add(new Osobowe("WA12345", "VIN123456789", "Czerwony", 150.0, "6.5L/100km", 80, 50000, 4));
        pojazdy.add(new Dostawcze("WA67890", "VIN987654321", "Biały", 200.0, "8.0L/100km", 60, 75000, 1500.0));
        pojazdy.add(new Motocykle("WA11111", "VIN111111111", "Czarny", 80.0, "4.0L/100km", 90, 25000, 0.0));
        pojazdy.add(new SprzętBudowlany("WA22222", "VIN222222222", "Żółty", 300.0, "15.0L/100km", 70, 10000, 2500.0));


        pojazdy.add(new Rower("R001", "VINR001", "Niebieski", 8.0, "Mechaniczny", 0, 250, "Miejski", true, 21));
        pojazdy.add(new Rower("R002", "VINR002", "Czerwony", 12.0, "Elektryczny", 85, 120, "Elektryczny", false, 7));
        pojazdy.add(new Rower("R003", "VINR003", "Zielony", 10.0, "Mechaniczny", 0, 180, "Górski", true, 24));
        pojazdy.add(new Hulajnoga("H001", "VINH001", "Czarny", 15.0, "Elektryczny", 90, 50, 25.0, true, "Brushless"));
        pojazdy.add(new Hulajnoga("H002", "VINH002", "Biały", 18.0, "Elektryczny", 60, 80, 30.0, false, "Brushed"));
    }

    private void utworzPrzykladowychUzytkownikow() {
        uzytkownicy.add(new Uzytkownik("Anna Kowalska", "anna@email.com", "123456789", 50.0));
        uzytkownicy.add(new Uzytkownik("Jan Nowak", "jan@email.com", "987654321", 30.0));
        uzytkownicy.add(new Uzytkownik("Maria Wiśniewska", "maria@email.com", "555666777", 75.0));
    }

    public void wywolajMetody() {
        System.out.println("TESTOWANIE SYSTEMU WYPOŻYCZALNI\n");

        for (Pojazd pojazd : pojazdy) {
            System.out.println("Pojazd: " + pojazd.getClass().getSimpleName());
            System.out.println("Nr rejestracyjny: " + pojazd.getNrRejestracyjny());
            System.out.println("VIN: " + pojazd.getNumerVin());
            System.out.println("Kolor: " + pojazd.getKolor());
            System.out.println("Cena: " + pojazd.getCena() + " zł/godzinę");
            System.out.println("Spalanie/Napęd: " + pojazd.getSpalanie());
            System.out.println("Poziom paliwa/baterii: " + pojazd.getPoziomPaliwa() + "%");
            System.out.println("Przebieg: " + pojazd.getPrzebieg() + " km");
            System.out.println("Dostępny: " + (pojazd.isDostepny() ? "Tak" : "Nie"));
            System.out.println("Lokalizacja: " + pojazd.getLokalizacja());

            if (pojazd instanceof Osobowe) {
                System.out.println("Liczba drzwi: " + ((Osobowe) pojazd).getLiczbaDrzwi());
            } else if (pojazd instanceof Dostawcze) {
                System.out.println("Ładowność: " + ((Dostawcze) pojazd).getLadownosc() + " kg");
            } else if (pojazd instanceof Motocykle) {
                System.out.println("Posiada dostawkę: " + (((Motocykle) pojazd).getPosiadaDostawke() > 0 ? "Tak" : "Nie"));
            } else if (pojazd instanceof SprzętBudowlany) {
                System.out.println("Przepracowane godziny: " + ((SprzętBudowlany) pojazd).getPrzepracowaneGodziny() + " h");
            } else if (pojazd instanceof Rower) {
                Rower rower = (Rower) pojazd;
                System.out.println("Typ roweru: " + rower.getTypRoweru());
                System.out.println("Koszyk: " + (rower.maKoszyk() ? "Tak" : "Nie"));
                System.out.println("Liczba rzutów: " + rower.getLiczbaRzutow());
            } else if (pojazd instanceof Hulajnoga) {
                Hulajnoga hulajnoga = (Hulajnoga) pojazd;
                System.out.println("Maksymalna prędkość: " + hulajnoga.getMaksymalnaPredkosc() + " km/h");
                System.out.println("Składana: " + (hulajnoga.isSkladana() ? "Tak" : "Nie"));
                System.out.println("Typ silnika: " + hulajnoga.getTypSilnika());
            }

            pojazd.prowadz();
            if (pojazd.getPoziomPaliwa() < 50) {
                pojazd.zatankuj();
            }

            System.out.println("------------------------");
        }

        System.out.println("\nTESTOWANIE TYPÓW PALIWA");
        typPaliwa[] typy = {new Diesel(), new Benzyna(), new Elektryk()};
        for (typPaliwa typ : typy) {
            System.out.println("Typ paliwa: " + typ.getTypPaliwa());
        }


        System.out.println("\nTESTOWANIE SYSTEMU WYPOŻYCZEŃ");
        testujWypozyczenia();
    }

    private void testujWypozyczenia() {
        System.out.println("\nRozpoczęcie wypożyczeń:");

        Uzytkownik anna = uzytkownicy.get(0);
        Pojazd rower = znajdzPojazd("R001");
        if (rower != null && rower.isDostepny()) {
            Wypozyczenie wyp1 = new Wypozyczenie(anna, rower, rower.getLokalizacja());
            rower.prowadz();
            aktywneWypozyczenia.add(wyp1);
            System.out.println("Anna wypożyczyła rower R001");
        }


        Uzytkownik jan = uzytkownicy.get(1);
        Pojazd hulajnoga = znajdzPojazd("H001");
        if (hulajnoga != null && hulajnoga.isDostepny()) {
            Wypozyczenie wyp2 = new Wypozyczenie(jan, hulajnoga, hulajnoga.getLokalizacja());
            hulajnoga.prowadz();
            aktywneWypozyczenia.add(wyp2);
            System.out.println("Jan wypożyczył hulajnogę H001");
        }

        System.out.println("\nAktywne wypożyczenia: " + aktywneWypozyczenia.size());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}

        System.out.println("\nZakończenie wypożyczeń:");
        for (Wypozyczenie wyp : new ArrayList<>(aktywneWypozyczenia)) {
            wyp.zakonczWypozyczenie("Park");
            wyp.wyswietlSzczegoly();
            aktywneWypozyczenia.remove(wyp);
        }

        System.out.println("\nSalda użytkowników po wypożyczeniach:");
        for (Uzytkownik uzytkownik : uzytkownicy) {
            System.out.println(uzytkownik.getImie() + ": " + uzytkownik.getSaldo() + " zł");
        }
    }

    private Pojazd znajdzPojazd(String nrRejestracyjny) {
        for (Pojazd pojazd : pojazdy) {
            if (pojazd.getNrRejestracyjny().equals(nrRejestracyjny)) {
                return pojazd;
            }
        }
        return null;
    }
}


public class mojaPietnastaAplikacja {
    public static void main(String[] args) {
        System.out.println("SYSTEM WYPOŻYCZALNI POJAZDÓW ");


        TestWypozyczalni test = new TestWypozyczalni();
        test.wywolajMetody();

        System.out.println("\nKONIEC TESTOWANIA");

    }
}