package lab6;

import java.time.LocalTime;

public final class Spotkanie extends Zdarzenie{
    private int priority;

    public int getPriority(){
        return this.priority;
    }

    public Spotkanie(LocalTime startTime, LocalTime endTime, String description, int priority) {
        super(startTime, endTime, description);
        this.priority = priority;
    }

    @Override public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Spotkanie\n");
        result.append(super.toString());
        result.append("\n").append("Priorytet: ").append(this.priority).append("\n");
        return result.toString();
    }
}