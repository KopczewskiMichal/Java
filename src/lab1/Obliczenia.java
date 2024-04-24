package lab1;//package lab1;
import java.util.Scanner;
public class Obliczenia {

    public static long countRange(int start, int end) {
        int result = 0;
        int actElem = start + 1;
        while (actElem < end) {
            result += actElem;
            actElem += 1;
        }
        return result;
    }

    public static long countFactorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
