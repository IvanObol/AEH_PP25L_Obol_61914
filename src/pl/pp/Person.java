package pl.pp;

public class Person {
    public String forename;
    public String surname;
    public int age;
    public String adres;
    public int rokUrodzenia;

    public Person() {}

    public Person(String forename, String surname, int age) {
        this.forename = forename;
        this.surname = surname;
        this.age = age;
    }

    public void hiToAll() {
        System.out.println("Cześć! Mam na imię " + forename + " " + surname + ". Mam " + age + " lat.");
    }

    public void growOld(int years) {
        this.age += years;
    }

    public void beYounger() {
        if (this.age > 0) {
            this.age -= 1;
        }
    }

    public String getName() {
        return this.forename;
    }

    public void setName(String name) {
        this.forename = name;
    }
}
