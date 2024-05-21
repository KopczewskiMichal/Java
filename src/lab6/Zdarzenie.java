package lab6;

import java.time.LocalTime;

sealed abstract class Zdarzenie permits Spotkanie, Zadanie {
    public final static LocalTime EARLIEST_MEETING_TIME = LocalTime.of(9,0);

    protected LocalTime startTime;
    protected LocalTime endTime;
    protected String description;

    protected LocalTime getStartTime() {
        return this.startTime;
    }

    protected LocalTime getEndTime() {
        return this.endTime;
    }

    protected Zdarzenie (LocalTime startTime, LocalTime endTime, String description) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
    }

    @Override public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(this.description);
        result.append("\nCzas trwania: ").append(this.startTime);
        result.append(" - ");
        result.append(this.endTime);
        return result.toString();
    }

}
