package pl.pp;

public class mojaSiodmaAplikacja {
    public static void main(String[] args) {
        Person person1 = new Person("Ivan", "Obol", 18);
        person1.adres = "Warszawa";
        person1.rokUrodzenia = 2006;

        person1.hiToAll();

        person1.growOld(4);
        person1.beYounger();
        person1.hiToAll();
    }
}