package pl.pp;
public class mojaOsmaAplikacja {

    private String numerKonta;
    private double saldo;
    private String nazwaWlasciciela;
    private String email;
    private String telefon;

    public mojaOsmaAplikacja(String numerKonta, double saldo, String nazwaWlasciciela, String email, String telefon) {
        this.numerKonta = numerKonta;
        this.saldo = saldo;
        this.nazwaWlasciciela = nazwaWlasciciela;
        this.email = email;
        this.telefon = telefon;
    }

    public String getNumerKonta() {
        return numerKonta;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNazwaWlasciciela() {
        return nazwaWlasciciela;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setNumerKonta(String numerKonta) {
        this.numerKonta = numerKonta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setNazwaWlasciciela(String nazwaWlasciciela) {
        this.nazwaWlasciciela = nazwaWlasciciela;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void wyplac(double kwota) {
        if (kwota <= saldo) {
            saldo -= kwota;
            System.out.printf("Pobrano PLN %.1f z konta, Pozostałe saldo = PLN %.1f%n", kwota, saldo);
        } else {
            System.out.printf("Brak środków. Masz PLN %.1f na koncie.%n", saldo);
        }
    }

    public void wplata(double kwota) {
        saldo += kwota;
        System.out.printf("Wpłata PLN %.1f została wykonana. Nowe saldo PLN %.1f%n", kwota, saldo);
    }

    public static void main(String[] args) {
        mojaOsmaAplikacja mojeKonto = new mojaOsmaAplikacja("1234567890", 1000.0, "Jan Kowalski", "jan@kowalski.pl", "123456789");

        mojeKonto.wyplac(900.0);
        mojeKonto.wplata(250.0);
        mojeKonto.wyplac(50.0);
        mojeKonto.wyplac(500.0);
    }
}