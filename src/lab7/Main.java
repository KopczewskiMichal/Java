package lab7;

import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Witam programie wspomagającym handel nieruchomościami.");
        Scanner in = new Scanner(System.in);
        ListaOfert listaOfert = new ListaOfert();
        boolean run = true;
        while (run) {
            displayMenu();
            String option = in.nextLine();
            switch (option) {
                case "1" -> addHouse(in, listaOfert);
                case "2" -> addFlat(in, listaOfert);
                case "3" -> showActFlats(listaOfert);
                case "4" -> showActHouses(listaOfert);
                case "5" -> showActFlatsWithCityAndMinArea(in, listaOfert);
                case "6" -> showActFlatsWithMaxPriceAndCityAndMinFloor(in, listaOfert);
                case "7" -> addSampleData(listaOfert);
                case "8" -> {
                    run = false;
                    System.out.println("Zakończono działanie programu.");
                }
                default -> System.out.println("Wprowadzono niepoprawną opcję.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("""
            Wbierz jedną z opcji:
            1. Dodanie oferty sprzedaży domu.
            2. Dodanie oferty sprzedaży mieszkania.
            3. Wyświetlenie wszystkich aktualnych ofert sprzedaży mieszkań.
            4. Wyświetlenie wszystkich aktualnych ofert sprzedaży domów.
            5. Wyświetlenie wszystkich aktualnych ofert sprzedaży 
                domów w podanej miejscowości o ustalonej powierzchni minimalnej
            6. Wyświetlenie wszystkich aktualnych ofert sprzedaży mieszkań w podanej miejscowości,
            nie droższych niż popdana wartość oraz na piętrze wyższym od podanego.
            7. Uzupełnienie programu przykładowymi danymi.
            8. Zakończenie działania programu.
                """);
    }

    private static void addHouse(Scanner in, ListaOfert listaOfert) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.print("Wprowadź ulicę: ");
        String street = in.nextLine();
        System.out.print("Wprowadź numer: ");
        int number = Integer.parseInt(in.nextLine());
        System.out.print("Wprowadź miasto: ");
        String city = in.nextLine();
        System.out.print("Wprowadź cenę: ");
        int price = Integer.parseInt(in.nextLine());
        System.out.print("Wprowadź kod pocztowy: ");
        String postCode = in.nextLine();
        System.out.print("Wprowadź termin (yyyy-MM-dd): ");
        LocalDate deadline = LocalDate.parse(in.nextLine(), dateFormatter);
        System.out.print("Wprowadź powierzchnię domu: ");
        int size = Integer.parseInt(in.nextLine());
        System.out.print("Wprowadź powierzchnię działki: ");
        int lotSize = Integer.parseInt(in.nextLine());
        System.out.print("Wprowadź numer domu: ");
        int houseNumber = Integer.parseInt(in.nextLine());
        Dom dom = new Dom(street, number, city, price, postCode, deadline, size, houseNumber, lotSize);
        listaOfert.addOffer(dom);
        System.out.println("Stworzono dom: " + dom);
    }

    private static void addFlat(Scanner in, ListaOfert listaOfert) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.print("Wprowadź ulicę: ");
        String street = in.nextLine();
        System.out.print("Wprowadź numer bloku: ");
        int number = Integer.parseInt(in.nextLine());
        System.out.print("Wprowadź miasto: ");
        String city = in.nextLine();
        System.out.print("Wprowadź cenę: ");
        int price = Integer.parseInt(in.nextLine());
        System.out.print("Wprowadź kod pocztowy: ");
        String postCode = in.nextLine();
        System.out.print("Wprowadź termin (yyyy-MM-dd): ");
        LocalDate deadline = LocalDate.parse(in.nextLine(), dateFormatter);
        System.out.print("Wprowadź wielkość mieszkania: ");
        int size = Integer.parseInt(in.nextLine());
        System.out.print("Wprowadź piętro: ");
        int floor = Integer.parseInt(in.nextLine());
        System.out.print("Wprowadź numer mieszkania: ");
        int flatNumber = Integer.parseInt(in.nextLine());
        Dom mieszkanie = new Dom(street, number, city, price, postCode, deadline, size, flatNumber, floor);
        listaOfert.addOffer(mieszkanie);
        System.out.println("Stworzono mieszkanie: " + mieszkanie);
    }

    private static void addSampleData (ListaOfert listaOfert) {
        listaOfert.addOffer(new Mieszkanie("Fiołkowa", 4, "Gdańsk", 900_000, "39-393", LocalDate.of(2025, 3, 27), 50, 3, 1, 5));
        listaOfert.addOffer(new Mieszkanie("Różana", 10, "Warszawa", 850_000, "00-001", LocalDate.of(2024, 5, 15), 45, 2, 2, 5));
        listaOfert.addOffer(new Mieszkanie("Tulipanowa", 7, "Kraków", 1_000_000, "30-002", LocalDate.of(2025, 6, 30), 60, 4, 3, 2));
        listaOfert.addOffer(new Mieszkanie("Liliowa", 5, "Poznań", 750_000, "61-003", LocalDate.of(2024, 8, 20), 55, 3, 4, 5));
        listaOfert.addOffer(new Mieszkanie("Orchideowa", 2, "Wrocław", 1_200_000, "50-004", LocalDate.of(2025, 9, 10), 70, 5, 5, 0));
        listaOfert.addOffer(new Mieszkanie("Magnoliowa", 3, "Łódź", 700_000, "90-005", LocalDate.of(2024, 7, 1), 40, 2, 6, 5));
        listaOfert.addOffer(new Mieszkanie("Jaśminowa", 6, "Szczecin", 950_000, "70-006", LocalDate.of(2025, 11, 5), 65, 4, 7, 7));
        listaOfert.addOffer(new Dom("Słonecznikowa", 47, "Gdańsk", 1_200_000, "39-693", LocalDate.of(2025, 7, 7), 150, 5, 2));
        listaOfert.addOffer(new Dom("Dębowa", 12, "Warszawa", 1_500_000, "00-007", LocalDate.of(2024, 12, 12), 200, 6, 3));
        listaOfert.addOffer(new Dom("Kasztanowa", 15, "Kraków", 1_300_000, "30-008", LocalDate.of(2025, 2, 25), 180, 5, 3));
        listaOfert.addOffer(new Dom("Sosnowa", 8, "Poznań", 1_000_000, "61-009", LocalDate.of(2024, 10, 30), 160, 4, 2));
        listaOfert.addOffer(new Dom("Brzozowa", 20, "Wrocław", 1_400_000, "50-010", LocalDate.of(2025, 4, 15), 220, 6, 4));

    }

    private static void showActHouses(ListaOfert listaOfert) {
        System.out.println(offersToString(listaOfert.showProperties(property  -> property instanceof Dom &&
                !property.getDeadline().isBefore(LocalDate.now()))));
    }

    private static void showActFlats(ListaOfert listaOfert) {
        System.out.println(offersToString(listaOfert.showProperties(property  -> property instanceof Mieszkanie &&
                !property.getDeadline().isBefore(LocalDate.now()))));
    }

    private static void showActFlatsWithMaxPriceAndCityAndMinFloor(Scanner in, ListaOfert listaOfert) {
        System.out.print("Wprowadź minimalne piętro: ");
        int floor = Integer.parseInt(in.nextLine());
        System.out.print("Wprowadź miasto: ");
        String city = in.nextLine();
        System.out.print("Wprowadź maksymalną cenę: ");
        int price = Integer.parseInt(in.nextLine());
        System.out.println(offersToString(listaOfert.showProperties(
                property  -> property instanceof Mieszkanie &&
                !property.getDeadline().isBefore(LocalDate.now()) &&
                property.getPrice() <= price &&
                ((Mieszkanie)property).getFloor() >= floor &&
                property.getCity().equals(city)
        )));
    }

    private static void showActFlatsWithCityAndMinArea(Scanner in, ListaOfert listaOfert) {
        System.out.print("Wprowadź miasto: ");
        String city = in.nextLine();
        System.out.print("Wprowadź minimalną powierzchnię: ");
        int area = Integer.parseInt(in.nextLine());
        System.out.println(offersToString(listaOfert.showProperties(
                property  -> property instanceof Mieszkanie &&
                        !property.getDeadline().isBefore(LocalDate.now()) &&
                        property.getArea() <= area &&
                        property.getCity().equals(city)
        )));
    }

    private static String offersToString(ArrayList<Miejsce> offers) {
        final StringBuilder result = new StringBuilder();
        for (Miejsce miejsce: offers) {
            result.append(miejsce.toString()).append("\n");
        }
        if (result.length() == 0)
            result.append("Nie znaleziono pasujących ofert.");
        return result.toString();
    }
}

