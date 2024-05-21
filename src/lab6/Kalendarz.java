package lab6;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Kalendarz {
    private final ArrayList<ArrayList<Zdarzenie>> kalendarz = new ArrayList<>();

    public Kalendarz() {
        for (int i = 0; i < 7; i++) {
            ArrayList<Zdarzenie> emptySubList = new ArrayList<>();
            this.kalendarz.add(emptySubList);
        }
    }

    public void addEvent(int day, Zdarzenie event) throws IllegalArgumentException{
        if (event.getStartTime().isBefore(Zdarzenie.EARLIEST_MEETING_TIME)) {
            throw new IllegalArgumentException("Zadbaj o sen, rozpocznij dzień po " + Zdarzenie.EARLIEST_MEETING_TIME);
        } else {
            this.kalendarz.get(day - 1).add(event);
        }
    }

    public void removeMeeting (int dzien, int index) {
        this.kalendarz.get(dzien - 1).remove(index - 1);
    }

    public ArrayList<Zdarzenie> showEvents(int day, Predicate<Zdarzenie> check, boolean showMeetings) {
        if (day > 7 || day < 1) {
            throw new IllegalArgumentException("Wprowadzono nieprawidłowy dzień tygodnia");
        }
        ArrayList<Zdarzenie> result = new ArrayList<Zdarzenie>();

        if (showMeetings) {
            for (int i = 0; i < this.kalendarz.get(day - 1).size(); i++) {
                Zdarzenie event = kalendarz.get(day - 1).get(i);
                if (event instanceof Spotkanie) {
                    Spotkanie spotkanie = (Spotkanie) event;
                    if (check.test(spotkanie)) {
                        result.add(spotkanie);
                    }
                }
            }
        } else {
            for (int i = 0; i < this.kalendarz.get(day - 1).size(); i++) {
                Zdarzenie event = kalendarz.get(day - 1).get(i);
                if (event instanceof Zadanie) {
                    Zadanie zadanie = (Zadanie) event;
                    if (check.test(zadanie)) {
                        result.add(zadanie);
                    }
                }
            }
        }
        return result;
    }
}
