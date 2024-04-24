package lab2;

import java.util.Scanner;

public class qMain {
    public static void main(String[] args) {
        System.out.println("Witam w dzienniku ocen studenta.");
        Scanner in = new Scanner(System.in);
        GradeList gradeList = new GradeList();
        boolean run = true;
        while (run) {
            displayMenu();
            String option = in.nextLine();
            switch (option) {
                case "1" -> addGrade(in, gradeList);
                case "2" -> getMean(gradeList);
                case "3" -> highestGrade(gradeList);
                case "4" -> smallestGrade(gradeList);
                case "5" -> {
                    run = false;
                    System.out.println("Zakończono działanie programu.");
                }
                default -> System.out.println("Wprowadzono niepoprawną opcję.");
            }
        }
    }

    private static void getMean(GradeList gradeList)  {
        final float mean = gradeList.getMean();
        if (mean == 0) System.out.println("Student nie ma jeszcze żadych ocen.");
        else System.out.println(mean);
    }

    private static void highestGrade(GradeList gradeList)  {
        final float highestGrade = gradeList.getHighestGrade();
        if (highestGrade == 0) System.out.println("Student nie ma jeszcze żadych ocen.");
        else System.out.println(highestGrade);
    }

    private static void smallestGrade(GradeList gradeList)  {
        final float smallestGrade = gradeList.getSmallestGrade();
        if (smallestGrade == 0) System.out.println("Student nie ma jeszcze żadych ocen.");
        else System.out.println(smallestGrade);
    }

    private static void addGrade(Scanner in, GradeList grades) {
        System.out.print("Wprowadź ocenę:");
        float grade = Float.parseFloat(in.nextLine());
        try {
            grades.addGrade(grade);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void displayMenu() {
        System.out.println("""
                Wybierz jedną z opcji:
                1. Dodaj nową ocenę
                2. Oblicz średnią ocen studenta
                3. Wyszukaj najwyższą ocenę studenta
                4. Wyszukaj najniższą ocenę studenta
                5. Wyjście z programu.""");
    }

}