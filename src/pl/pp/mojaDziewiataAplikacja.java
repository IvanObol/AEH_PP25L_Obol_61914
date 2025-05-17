package pl.pp;
public class mojaDziewiataAplikacja {
    private int numerMagazynu;
    private int dostepnaPrzestrzen;
    private String wlasciciel;
    private String email;
    private String telefon;

    public mojaDziewiataAplikacja(int numerMagazynu, int dostepnaPrzestrzen, String wlasciciel, String email, String telefon) {
        this.numerMagazynu = numerMagazynu;
        this.dostepnaPrzestrzen = dostepnaPrzestrzen;
        this.wlasciciel = wlasciciel;
        this.email = email;
        this.telefon = telefon;
    }

    public int getNumerMagazynu() { return numerMagazynu; }
    public void setNumerMagazynu(int numerMagazynu) { this.numerMagazynu = numerMagazynu; }

    public int getDostepnaPrzestrzen() { return dostepnaPrzestrzen; }
    public void setDostepnaPrzestrzen(int dostepnaPrzestrzen) { this.dostepnaPrzestrzen = dostepnaPrzestrzen; }

    public String getWlasciciel() { return wlasciciel; }
    public void setWlasciciel(String wlasciciel) { this.wlasciciel = wlasciciel; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefon() { return telefon; }
    public void setTelefon(String telefon) { this.telefon = telefon; }

    public void dodajTowar(int ilosc) {
        if (ilosc <= dostepnaPrzestrzen) {
            dostepnaPrzestrzen -= ilosc;
            System.out.println("Dodano " + ilosc + " jednostek towaru. Pozostała przestrzeń magazynowa: " + dostepnaPrzestrzen + " jednostek.");
        } else {
            System.out.println("Za mało miejsca w magazynie. Pozostała przestrzeń magazynowa: " + dostepnaPrzestrzen + " jednostek.");
        }
    }

    public void usunTowar(int ilosc) {
        dostepnaPrzestrzen += ilosc;
        System.out.println("Usunięto " + ilosc + " jednostek towaru. Pozostała przestrzeń magazynowa: " + dostepnaPrzestrzen + " jednostek.");
    }

    public void sprawdzZajetosc() {
        System.out.println("Za mało miejsca w magazynie. Pozostała przestrzeń magazynowa: " + dostepnaPrzestrzen + " jednostek.");
    }

    public void aktualizujKontakt(String nowyEmail, String nowyTelefon) {
        this.email = nowyEmail;
        this.telefon = nowyTelefon;
        System.out.println("Zaktualizowano dane kontaktowe właściciela.");
        System.out.println("Nowy email: " + email);
        System.out.println("Nowy numer telefonu: " + telefon);
    }

    public static void main(String[] args) {
        mojaDziewiataAplikacja m = new mojaDziewiataAplikacja(12345, 5000, "Jan Kowalski", "owner@magazyn.pl", "+48 000 000 000");

        m.dodajTowar(3000);
        m.usunTowar(1000);
        m.dodajTowar(2500);  // tylko 3000 - 1000 = 2000 wolnego miejsca!
        m.usunTowar(500);
        m.dodajTowar(1000);
        m.aktualizujKontakt("owner2@magazyn.pl", "+48 123 456 789");
        m.sprawdzZajetosc();
    }
}