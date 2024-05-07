package lab4;

import java.util.Scanner;

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
                case "6" -> addTestMeetings(kalendarz);
                case "7" -> {
                    run = false;
                    System.out.println("Zakończono działanie programu.");
                }
                default -> System.out.println("Wprowadzono niepoprawną opcję.");
            }
        }
    }

    private static void addMeeting(Scanner in, Kalendarz kalendarz){
        System.out.println("Podaj dzień spotkania");
        Integer day = Integer.parseInt(in.nextLine());
        System.out.println("Podaj priorytet:");
        int priority = in.nextInt();
        System.out.println("Podaj czas rozpoczęcia (HH:MM):");
        String startTimeStr = in.next();
        System.out.println("Podaj czas zakończenia (HH:MM):");
        String endTimeStr = in.next();
        in.nextLine();
        System.out.println("Podaj opis:");
        String description = in.nextLine();
        Spotkanie spotkanie = Spotkanie.makeSpotkanie(priority, startTimeStr, endTimeStr, description);
        kalendarz.addMetting(day, spotkanie);
    }



    private static void removeMeeting (Scanner in, Kalendarz kalendarz) {
        System.out.print("Wprowadź numer dnia: ");
        Integer day = Integer.parseInt(in.nextLine());
        try {
            System.out.println(kalendarz.showDayMeetings(day));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        Integer meetingIndex = Integer.parseInt(in.nextLine());
        kalendarz.removeMeeting(day, meetingIndex);
        System.out.println("Usunięto spotkanie.");
    }

    private static void showMetingsWithPriority (Scanner in, Kalendarz kalendarz) {
        System.out.print("Wprowadź numer dnia: ");
        Integer day = Integer.parseInt(in.nextLine());
        Integer priority = Integer.parseInt(in.nextLine());
        System.out.println(kalendarz.showDayMeetingsWithPriority(day, priority));
    }

    private static void showDayMeetingsAfter(Scanner in, Kalendarz kalendarz) {
        System.out.print("Wprowadź numer dnia: ");
        Integer day = Integer.parseInt(in.nextLine());
        String minStartTime = in.nextLine();
        System.out.println(kalendarz.showDayMeetingsAfter(day, minStartTime));
    }

    private static void showDayMeetings(Scanner in, Kalendarz kalendarz) {
        System.out.print("Wprowadź numer dnia: ");
        Integer day = Integer.parseInt(in.nextLine());
        try {
            System.out.println(kalendarz.showDayMeetings(day));
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
                6. Uzupełnienie dnia 5 przykładowymi danymi.
                7. Opuszczenie programu.
                """);
    }
    private static void addTestMeetings(Kalendarz kalendarz) {
        Spotkanie[] meetings = {
                Spotkanie.makeSpotkanie(2, "10:34:45", "10:45:34", "Spotkanie z szefem"),
                Spotkanie.makeSpotkanie(1, "17:34:45", "18:45:34", "Zakup opon na spotkaniu"),
                Spotkanie.makeSpotkanie(2, "15:34:45", "16:45:34", "Spotkanie z kolegą"),
                Spotkanie.makeSpotkanie(3, "10:34:45", "10:45:34", "Spotkanie z klientem"),
                Spotkanie.makeSpotkanie(2, "16:34:45", "18:45:34", "Gra w golfa"),
                Spotkanie.makeSpotkanie(1, "12:34:45", "14:45:34", "Gra w tenisa"),
                Spotkanie.makeSpotkanie(2, "17:34:45", "19:45:34", "Kolacja")
        };
        for (Spotkanie meeting : meetings) {
            kalendarz.addMetting(5, meeting);
        }
    }
}
