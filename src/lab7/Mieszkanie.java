package lab7;

import java.time.LocalDate;

public final class Mieszkanie extends Miejsce {
    private final int flatNumber;
    private final int floor;

    public int getFloor() {
        return floor;
    }

    public Mieszkanie(String street, int number, String city, int price, String postCode, LocalDate deadline, int size, int houseNumber, int flatNumber, int floor) {
        super(street, number, city, price, postCode, deadline, size, houseNumber);
        this.flatNumber = flatNumber;
        this.floor = floor;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Mieszkanie nr. ").append(this.flatNumber).append("\n");
        result.append("Piętro nr: ").append(this.floor).append("\n");
        result.append(super.toString());
        return result.toString();
    }
}
