package lab5;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Kalendarz {
    private final ArrayList<ArrayList<Spotkanie>> kalendarz = new ArrayList<>();

    public Kalendarz() {
        for (int i = 0; i < 7; i++) {
            ArrayList<Spotkanie> emptySubList = new ArrayList<>();
            this.kalendarz.add(emptySubList);
        }
    }

    public void addMetting(int day, Spotkanie spotkanie) {
        this.kalendarz.get(day - 1).add(spotkanie);
    }

    public void removeMeeting (int dzien, int index) {
        this.kalendarz.get(dzien - 1).remove(index - 1);
    }

    public String showMeetings(int day, Predicate<Spotkanie> check) {
        if (day > 7 || day < 1) {
            throw new IllegalArgumentException("Wprowadzono nieprawidłowy dzień tygodnia");
        }
        StringBuilder res = new StringBuilder("Poniżej przedstawiono spotkania na dzień: ");
        res.append(day);
        res.append("\n");
        for (int i = 0; i < this.kalendarz.get(day - 1).size(); i++) {
            Spotkanie meeting  = kalendarz.get(day - 1).get(i);
            if  (check.test(meeting)) {
                res.append("Spotkanie nr. ").append(i + 1).append("\n");
                res.append(meeting.toString());
                res.append("\n\n");
            }
        }
        return res.toString();
    }
}
