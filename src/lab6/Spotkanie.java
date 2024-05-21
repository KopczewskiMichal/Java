package lab6;

import java.time.LocalTime;

public final class Spotkanie extends Zdarzenie{
    private int priority;


    public int getPriority() {
        return priority;
    }



    public Spotkanie(LocalTime startTime, LocalTime endTime, String description, int priority) {
        super(startTime, endTime, description);
        this.priority = priority;
    }


    @Override public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Spotkanie");
        result.append(super.toString());
        result.append("\n").append("Priorytet: ").append(this.status);
        return result.toString();
    }
}