package lab4;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class Spotkanie {
    private int priority;
    private LocalTime startTime;
    private LocalTime endTime;
    private String description;


    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public static Spotkanie makeSpotkanie (int prority, String startTime, String endTime, String description) throws DateTimeParseException{
        final Spotkanie spotkanie = new Spotkanie();
        spotkanie.setDescription(description);
        spotkanie.setPriority(prority);
        spotkanie.setStartTime(LocalTime.parse(startTime));
        spotkanie.setEndTime(LocalTime.parse(endTime));
        return spotkanie;
    }

    @Override public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(this.description).append("\n");
        result.append(this.startTime);
        result.append(this.endTime);
        result.append("\nPriorytet: ");
        result.append(this.priority);
        return result.toString();
    }


    public void setDescription(String description) {
        this.description = description;
    }
}
