package lab2;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        program();
    }

    private static void program () {
        System.out.println("Cześć,\nJestem programem liczącym parametry walców");
        Scanner in = new Scanner(System.in);
        Walec walec = new Walec();

        boolean run = true;
        while (run) {
            System.out.print("Opuść program 'q' lub podaj promień: ");
            String input = in.nextLine();

            if (input.equals("q")) {
                run = false;
                System.out.println("Opuszczono program");
            } else {
                float radius = Float.parseFloat(input);
                walec.setRadius(radius);
                System.out.print("wysokość: ");
                String endInput = in.nextLine();
                float height = Float.parseFloat(endInput);
                walec.setHeight(height);
                System.out.println("Pole powierzchni podstawy = " + walec.calculateBaseArea());
                System.out.println("Pole powierzchni bocznej = " + walec.calculateLateralArea());
                System.out.println("Pole powierzchni całkowitej = " + walec.calculateTotalArea());
                System.out.println("Objętość = " + walec.calculateVolume());

//                String input = in.nextLine();

            }
        }
    }
}