package lab1;////package lab1;

import java.util.Scanner;

public class Wyswietlanie {

    public static void silnia() {
        System.out.println("Jestem programem służącym do liczenia silni liczby podanej przez użytkownika.\nWpisz 'q' aby wyjść z tego trybu:    ");
        Scanner in = new Scanner(System.in);

        boolean run = true;
        while (run) {
            String input = in.nextLine();
            if (input.equals("q")) {
                run = false;
                System.out.println("Opuszczono tryb liczenia silnii.");
            } else {
                int inputInt = Integer.parseInt(input);
                long result = Obliczenia.countFactorial(inputInt);
                System.out.println(String.format("Silnia liczby %d wynosi %s", inputInt, result));
            }
        }
    }

    public static void zakres() {
//        System.out.println("Jestem programem służącym do liczenia sumy liczb z otwartego przedziału.\nWpisz 'q' aby wyjśc z tego trybu:    ");
//        Scanner in = new Scanner(System.in);
//
//        boolean run = true;
//        while (run) {
//            String input = in.nextLine();
//            if (input.equals("q")) {
//                run = false;
//                System.out.println("Opuszczono tryb liczenia zakresu.");
//            } else {
//                int start = Integer.parseInt(input);
//                String endInput = in.nextLine();
//                int end = Integer.parseInt(endInput);
//                long result = Obliczenia.countRange(start, end);
//                System.out.println(String.format("Suma liczb z przedziału otwartego od %d do %d wynosi %s", start, end, result));
//            }
//        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        boolean run = true;
        while (run) {
        System.out.println("Jestem menu wielofunkcyjnego programu.\n" +
                "Wpisz 's' aby policzyć silnię.\n" +
                "Wpisz 'z' aby policzyć zakres\n" +
                "Wpisz 'q' aby zakończyć działanie:  ");
            String input = in.nextLine();
            if (input.equals("q")) {
                run = false;
                System.out.println("Zakończono działanie programu.");
            } else if (input.equals("z")) {
                Wyswietlanie.zakres();
            } else if (input.equals("s")) {
                Wyswietlanie.silnia();
            }
        }
    }
}
