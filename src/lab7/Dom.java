package lab7;

import java.time.LocalDate;

public final class Dom extends Miejsce {
    private final int lotSize;

    public Dom(String street, int number, String city, int price, String postCode, LocalDate deadline, int size, int houseNumber, int lotSize) {
        super(street, number, city, price, postCode, deadline, size, houseNumber);
        this.lotSize = lotSize;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Dom na działce o wielkości: ").append(this.lotSize).append("\n");
        result.append(super.toString());
        return result.toString();
    }
}
