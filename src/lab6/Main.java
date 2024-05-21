package lab6;

import java.time.LocalTime;
import java.util.ArrayList;
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
                case "2" -> addTask(in, kalendarz);
                case "3" -> removeMeeting(in, kalendarz);
                case "4" -> removeTask(in, kalendarz);
                case "5" -> showDayMeetings(in, kalendarz);
                case "6" -> showDayTasks(in, kalendarz);
                case "7" -> showMeetingsWithPriority(in, kalendarz);
                case "8" -> showTasksWithStaus(in, kalendarz);
                case "9" -> showMeetingsAfterTimeWithPriority(in, kalendarz);
                case "10" -> showTasksAfterTimeWithStatus(in, kalendarz);
                case "11" -> addTestMeetings(kalendarz);
                case "12" -> {
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
        System.out.println("Podaj czas rozpoczęcia (HH:MM): ");
        String startTimeStr = in.next();
        System.out.println("Podaj czas zakończenia (HH:MM): ");
        String endTimeStr = in.next();
        in.nextLine();
        System.out.println("Podaj opis:");
        String description = in.nextLine();
        Spotkanie spotkanie = new Spotkanie(LocalTime.parse(startTimeStr),
                LocalTime.parse(endTimeStr), description, priority);
        try {
            kalendarz.addEvent(day, spotkanie);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Pomyślnie utworzono spotkanie");
        }
    }

    private static void addTask(Scanner in, Kalendarz kalendarz){
        System.out.println("Podaj dzień spotkania");
        int day = Integer.parseInt(in.nextLine());
        System.out.println("Podaj status:");
        int priority = in.nextInt();
        System.out.println("Podaj czas rozpoczęcia (HH:MM): ");
        String startTimeStr = in.next();
        System.out.println("Podaj czas zakończenia (HH:MM): ");
        String endTimeStr = in.next();
        in.nextLine();
        System.out.println("Podaj opis:");
        String description = in.nextLine();
        Spotkanie spotkanie = new Spotkanie(LocalTime.parse(startTimeStr),
                LocalTime.parse(endTimeStr), description, priority);
        try {
            kalendarz.addEvent(day, spotkanie);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Pomyślnie utworzono zadanie");
        }
    }


    private static void removeMeeting (Scanner in, Kalendarz kalendarz) {
        System.out.print("Wprowadź numer dnia: ");
        int day = Integer.parseInt(in.nextLine());
        try {
            System.out.println(kalendarz.showEvents(day, spotkanie -> spotkanie instanceof Spotkanie, true));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        int meetingIndex = Integer.parseInt(in.nextLine());
        kalendarz.removeMeeting(day, meetingIndex);
        System.out.println("Usunięto spotkanie.");
    }

    private static void removeTask (Scanner in, Kalendarz kalendarz) {
        System.out.print("Wprowadź numer dnia: ");
        int day = Integer.parseInt(in.nextLine());
        try {
            System.out.println(eventsToString(kalendarz.showEvents(day, spotkanie -> spotkanie instanceof Zadanie, true)));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        int meetingIndex = Integer.parseInt(in.nextLine());
        kalendarz.removeMeeting(day, meetingIndex);
        System.out.println("Usunięto zadanie.");
    }


    private static void showMeetingsAfterTimeWithPriority(Scanner in, Kalendarz kalendarz) {
        System.out.print("Wprowadź numer dnia: ");
        int day = Integer.parseInt(in.nextLine());
        System.out.println("Wprowadź godzinę rozpoczęcia spotkań (HH:MM):");
        String minStartTime = in.nextLine();
        LocalTime minStartLocalTime = LocalTime.parse(minStartTime);
        System.out.println("Wprowadź priorytet spotkania:");
        int priority = Integer.parseInt(in.nextLine());
        System.out.println(eventsToString(
                kalendarz.showEvents(day, spotkanie ->
                        spotkanie instanceof Spotkanie &&
                                spotkanie.getStartTime().isAfter(minStartLocalTime) &&
                                ((Spotkanie) spotkanie).getPriority() == priority,
                        true))
        );
    }

    private static void showTasksAfterTimeWithStatus(Scanner in, Kalendarz kalendarz) {
        System.out.print("Wprowadź numer dnia: ");
        int day = Integer.parseInt(in.nextLine());
        System.out.println("Wprowadź godzinę rozpoczęcia spotkań (HH:MM):");
        String minStartTime = in.nextLine();
        LocalTime minStartLocalTime = LocalTime.parse(minStartTime);
        System.out.println("Wprowadź status zadania:");
        int status = Integer.parseInt(in.nextLine());
        System.out.println(eventsToString(
                kalendarz.showEvents(day, spotkanie ->
                                spotkanie instanceof Zadanie &&
                                        spotkanie.getStartTime().isAfter(minStartLocalTime) &&
                                        ((Zadanie) spotkanie).getStatus() == status,
                        true))
        );
    }
    private static void showDayMeetings(Scanner in, Kalendarz kalendarz) {
        System.out.print("Wprowadź numer dnia: ");
        int day = Integer.parseInt(in.nextLine());
        try {
            System.out.println(eventsToString(kalendarz.showEvents(day, spotkanie -> spotkanie instanceof Spotkanie, true)));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void showDayTasks(Scanner in, Kalendarz kalendarz) {
        System.out.print("Wprowadź numer dnia: ");
        int day = Integer.parseInt(in.nextLine());
        try {
            System.out.println(kalendarz.showEvents(day, zadanie -> zadanie instanceof Zadanie, true));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void displayMenu() {
        System.out.println("""
                Wybierz jedną z następujacych opcji:
                1. Dodanie spotkania na dany dzień.
                2. Dodanie zadania na dany dzień.
                3. Usunięcie spotkania z wybranego dnia.
                4. Usunięcie zadania z wybranego dnia.
                5. Wyświetlenie wszystkich spotkań w wybranym dniu.
                6. Wyświetlenie wszystkich zadań w wybranym dniu.
                7. Wyświetlenie wszysztkich spotkań w wybranym dniu i priorytecie.
                8. Wyświetlenie zadań w wybranym dniu o wybranym statusie.
                9. Wyświetlenie spotkań w wybranym dniu i priorytecie zaczynających się nie wcześniej niż od podanego czasu.
                10.Wyświetlenie zadań w wybranym dniu i statusie zaczynających się nie wcześniej niż od podanego czasu.
                11. Uzupełnienie dnia 5 przykładowymi danymi.
                12. Opuszczenie programu.
                """);
    }

    private static void addTestMeetings(Kalendarz kalendarz) {
        Zdarzenie[] zdarzenia = {
                new Spotkanie(LocalTime.parse("10:34:45"), LocalTime.parse("10:45:34"), "Spotkanie z szefem", 3),
                new Zadanie(LocalTime.parse("17:34:45"), LocalTime.parse("18:45:34"), "Zakup opon", 3),
                new Spotkanie(LocalTime.parse("15:34:45"), LocalTime.parse("16:45:34"), "Spotkanie z kolegą", 1),
                new Spotkanie(LocalTime.parse("10:34:45"), LocalTime.parse("10:45:34"), "Spotkanie z klientem", 1),
                new Spotkanie(LocalTime.parse("16:34:45"), LocalTime.parse("18:45:34"), "Programowanie w Javie", 1),
                new Spotkanie(LocalTime.parse("12:34:45"), LocalTime.parse("14:45:34"), "Gra w tenisa", 1),
                new Spotkanie(LocalTime.parse("17:34:45"), LocalTime.parse("19:45:34"), "Kolacja", 1),
                new Zadanie(LocalTime.parse("17:50:45"), LocalTime.parse("19:45:34"), "Sprzedać samochód", 4),
                new Zadanie(LocalTime.parse("09:15:00"), LocalTime.parse("09:20"), "Poranne rozciąganie", 2)
        };
        for (Zdarzenie zdarzenie : zdarzenia) {
            kalendarz.addEvent(5, zdarzenie);
        }
    }

    private static void showMeetingsWithPriority(Scanner in, Kalendarz kalendarz) {
        System.out.print("Wprowadź numer dnia: ");
        int day = Integer.parseInt(in.nextLine());
        System.out.println("Wprowadź priorytet spotkania: ");
        int priority = Integer.parseInt(in.nextLine());
        System.out.println(eventsToString(kalendarz.showEvents(day, spotkanie -> spotkanie instanceof Spotkanie &&
                ((Spotkanie) spotkanie).getPriority() == priority, true) ));
    }

    private static void showTasksWithStaus(Scanner in, Kalendarz kalendarz) {
        System.out.print("Wprowadź numer dnia: ");
        int day = Integer.parseInt(in.nextLine());
        System.out.println("Wprowadź status zadania: ");
        int priority = Integer.parseInt(in.nextLine());
        System.out.println(eventsToString(kalendarz.showEvents(day, zdanie -> zdanie instanceof Zadanie &&
                ((Zadanie) zdanie).getStatus() == priority, false) ));
    }

    private static String eventsToString(ArrayList<Zdarzenie> zdarzenia){
        final StringBuilder result = new StringBuilder();
        for (Zdarzenie zdarzenie : zdarzenia) {
            result.append(zdarzenie.toString());
        }
        return result.toString();
    }
}