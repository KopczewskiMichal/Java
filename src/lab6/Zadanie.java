package lab6;

import java.time.LocalTime;

public final class Zadanie extends Zdarzenie {
    private int status;

    protected Zadanie(LocalTime startTime, LocalTime endTime, String description, int status) {
        super(startTime, endTime, description);
        this.status = status;
    }

    @Override public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Zadanie");
        result.append(super.toString());
        result.append("\n").append("Status: ").append(this.status);
        return result.toString();
    }
}
