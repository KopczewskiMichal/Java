package lab7;

import java.util.ArrayList;
import java.util.function.Predicate;

public class ListaOfert {
    private final ArrayList<Miejsce> offers = new ArrayList<>();

    public void addOffer(Miejsce offer) {
        offers.add(offer);
    }

    public ArrayList<Miejsce> showProperties(Predicate<Miejsce> check) {
        ArrayList<Miejsce> result = new ArrayList<Miejsce>();
        for (Miejsce property : offers) {
            if (check.test(property)) {
                result.add(property);
            }
        }
        return result;
    }
}
