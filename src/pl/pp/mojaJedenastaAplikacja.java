package pl.pp;

import java.util.*;

public class mojaJedenastaAplikacja {

    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student("112315", "Ivan", "Kowalski", Arrays.asList(4, 5, 4, 5)),
                new Student("613110", "Sergej", "Nowak", Arrays.asList(5, 3, 5, 4)),
                new Student("133411", "Paweł", "Wiśniewski", Arrays.asList(2, 2, 2, 2)),
                new Student("0114176", "Aleksij", "Kowalczyk", Arrays.asList(5, 4, 4, 5))
        );

        Student topStudent = null;
        double maxAverage = -1;

        for (Student s : students) {
            if (s.getAverage() > maxAverage) {
                maxAverage = s.getAverage();
                topStudent = s;
            }
        }

        System.out.println("Student z najwyższą średnią: " + topStudent.getFirstName() + " " +
                topStudent.getLastName() + " (" + topStudent.getIndex() + ") - Average: " +
                topStudent.getAverage());

        System.out.println("\nStudenci posortowani według średniej:");
        students.stream()
                .sorted((a, b) -> Double.compare(b.getAverage(), a.getAverage()))
                .forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName() + " (" +
                        s.getIndex() + ") - Average: " + s.getAverage()));
        int[] testArray = {1, 2, 3, 4, 5, -3, -2, -1};
        int[] result = countAndSumElements(testArray);

        if (result.length == 0) {
            System.out.println("Pusta tablica");
        } else {
            System.out.println("Liczba elementów ujemnych: " + result[0]);
            System.out.println("Suma elementów dodatnich: " + result[1]);
        }

    }

    public static int[] countAndSumElements(int[] input) {
        if (input == null || input.length == 0) {
            return new int[0];
        }

        int countNegative = 0;
        int sumPositive = 0;

        for (int num : input) {
            if (num < 0) {
                countNegative++;
            } else if (num > 0) {
                sumPositive += num;
            }
        }

        return new int[]{countNegative, sumPositive};
    }
}