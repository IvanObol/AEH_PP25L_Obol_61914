package pl.pp;

import java.util.List;

public class Student {
    private String index;
    private String firstName;
    private String lastName;
    private List<Integer> grades;

    public Student(String index, String firstName, String lastName, List<Integer> grades) {
        this.index = index;
        this.firstName = firstName;
        this.lastName = lastName;
        this.grades = grades;
    }

    public String getIndex() {
        return index;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public double getAverage() {
        if (grades == null || grades.isEmpty()) return 0.0;
        double sum = 0;
        for (int g : grades) sum += g;
        return Math.round((sum / grades.size()) * 100.0) / 100.0;
    }
}