package lab6;

import java.time.LocalTime;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Witam kalendarzu obsługującym tygodniowy kalendarz spotkań");
        Kalendarz kalendarz = new Kalendarz();
        Scanner in = new Scanner(System.in);
        boolean run = true;
        while (run) {
            displayMenu();
            String option = in.nextLine();
            switch (option) {
                case "1" -> addMeeting(in, kalendarz);
                case "2" -> removeMeeting(in, kalendarz);
                case "3" -> showDayMeetings(in, kalendarz);
                case "4" -> showMetingsWithPriority(in, kalendarz);
                case "5" -> showDayMeetingsAfter(in, kalendarz);
                case "6" -> showMeetingsBetween(in, kalendarz);
                case "7" -> showMeetingsAfterTimeWithPriority(in, kalendarz);
                case "8" -> addTestMeetings(kalendarz);
                case "9" -> {
                    run = false;
                    System.out.println("Zakończono działanie programu.");
                }
                default -> System.out.println("Wprowadzono niepoprawną opcję.");
            }
        }
    }


    private static void addMeeting(Scanner in, Kalendarz kalendarz){
        System.out.println("Podaj dzień spotkania");
        int day = Integer.parseInt(in.nextLine());
        System.out.println("Podaj priorytet:");
        int priority = in.nextInt();
        System.out.println("Podaj czas rozpoczęcia (HH:MM):");
        String startTimeStr = in.next();
        System.out.println("Podaj czas zakończenia (HH:MM):");
        String endTimeStr = in.next();
        in.nextLine();
        System.out.println("Podaj opis:");
        String description = in.nextLine();
        Spotkanie spotkanie = new Spotkanie(LocalTime.parse(startTimeStr),
                LocalTime.parse(endTimeStr), description, priority);
        try {
            kalendarz.addMetting(day, spotkanie);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Pomyślnie utworzono spotkanie");
        }
    }


    private static void removeMeeting (Scanner in, Kalendarz kalendarz) {
        System.out.print("Wprowadź numer dnia: ");
        int day = Integer.parseInt(in.nextLine());
        try {
            System.out.println(kalendarz.showEvents(day, spotkanie -> true));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        int meetingIndex = Integer.parseInt(in.nextLine());
        kalendarz.removeMeeting(day, meetingIndex);
        System.out.println("Usunięto spotkanie.");
    }


    private static void showDayMeetingsAfter(Scanner in, Kalendarz kalendarz) {
        System.out.print("Wprowadź numer dnia: ");
        int day = Integer.parseInt(in.nextLine());
        System.out.println("Wprowadź godzinę rozpoczęcia spotkań (HH:MM):");
        String minStartTime = in.nextLine();
        LocalTime minStartLocalTime = LocalTime.parse(minStartTime);
        System.out.println(kalendarz.showEvents(day, spotkanie -> spotkanie.getStartTime().isAfter(minStartLocalTime)));
    }

    private static void showMeetingsBetween(Scanner in, Kalendarz kalendarz) {
        System.out.print("Wprowadź numer dnia: ");
        int day = Integer.parseInt(in.nextLine());
        System.out.println("Wprowadź godzinę rozpoczęcia spotkań (HH:MM):");
        String minStartTime = in.nextLine();
        LocalTime minStartLocalTime = LocalTime.parse(minStartTime);
        System.out.println("Wprowadź godzinę zakończenia spotkań (HH:MM):");
        String maxEndTime = in.nextLine();
        LocalTime maxEndLocalTime = LocalTime.parse(maxEndTime);

        Predicate<Spotkanie> condition = spotkanie ->
                spotkanie.getStartTime().isAfter(minStartLocalTime) && spotkanie.getEndTime().isBefore(maxEndLocalTime);

        System.out.println(kalendarz.showEvents(day, condition));
    }

    private static void showMeetingsAfterTimeWithPriority(Scanner in, Kalendarz kalendarz) {
        System.out.print("Wprowadź numer dnia: ");
        int day = Integer.parseInt(in.nextLine());
        System.out.println("Wprowadź godzinę rozpoczęcia spotkań (HH:MM):");
        String minStartTime = in.nextLine();
        LocalTime minStartLocalTime = LocalTime.parse(minStartTime);
        System.out.println("Wprowadź priorytet spotkania:");
        int priority = Integer.parseInt(in.nextLine());
        //! ogarnij dobrego printa w tej klasie
        System.out.println(kalendarz.showEvents(day, spotkanie ->
                spotkanie.getStartTime().isAfter(minStartLocalTime) && spotkanie.getPriority() == priority), true);
    }
    private static void showDayMeetings(Scanner in, Kalendarz kalendarz) {
        System.out.print("Wprowadź numer dnia: ");
        int day = Integer.parseInt(in.nextLine());
        try {
            System.out.println(kalendarz.showEvents(day, spotkanie -> true), true);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void displayMenu() {
        System.out.println("""
                Wybierz jedną z następujacych opcji:
                1. Dodanie spotkania na dany dzień.
                2. Usunięcie spotkania z wybranego dnia.
                3. Wyświetlenie wszystkich spotkań w wybranym dniu.
                4. Wyświetlenie wszysztkich spotkań o wybranym priorytecie.
                5. Wyświetlenie wszystkich spotkań zaczynających się nie wcześniej niż od podanego czasu.
                6. Wyświetlenie spotkań w danym dniu odbywających się pomiędzy podanymi czasami włącznie.
                7. Wyświetlenie spotkań w danym dniu zaczynających się nie wcześniej niż podany czas i o podanym priorytecie.
                8. Uzupełnienie dnia 5 przykładowymi danymi.
                9. Opuszczenie programu.
                """);
    }

    private static void addTestMeetings(Kalendarz kalendarz) {
        Spotkanie[] meetings = {
                new Spotkanie(LocalTime.parse("10:34:45"), LocalTime.parse("10:45:34"), "Spotkanie z szefem", 3),
                new Spotkanie(LocalTime.parse("17:34:45"), LocalTime.parse("18:45:34"), "Zakup opon na spotkaniu", 1),
                new Spotkanie(LocalTime.parse("15:34:45"), LocalTime.parse("16:45:34"), "Spotkanie z kolegą", 1),
                new Spotkanie(LocalTime.parse("10:34:45"), LocalTime.parse("10:45:34"), "Spotkanie z klientem", 1),
                new Spotkanie(LocalTime.parse("16:34:45"), LocalTime.parse("18:45:34"), "Programowanie w Javie", 1),
                new Spotkanie(LocalTime.parse("12:34:45"), LocalTime.parse("14:45:34"), "Gra w tenisa", 1),
                new Spotkanie(LocalTime.parse("17:34:45"), LocalTime.parse("19:45:34"), "Kolacja", 1)
        };
        for (Spotkanie meeting : meetings) {
            kalendarz.addMetting(5, meeting);
        }
    }

    private static void showMetingsWithPriority(Scanner in, Kalendarz kalendarz) {
        System.out.print("Wprowadź numer dnia:");
        int day = Integer.parseInt(in.nextLine());
        System.out.println("Wprowadź priorytet spotkania:");
        int priority = Integer.parseInt(in.nextLine());
        System.out.println(kalendarz.showEvents(day, spotkanie -> spotkanie.getPriority() == priority));
    }
}