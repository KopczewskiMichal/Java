package lab7;

import java.time.LocalDate;

sealed abstract class Miejsce permits Dom, Mieszkanie {
    protected final String street;
    protected final int number;
    protected final String city;
    protected final int price;
    protected final String postCode;
    protected final LocalDate deadline;
    protected final int area;
    protected final int houseNumber;

    public LocalDate getDeadline () {
        return deadline;
    }

    public String getCity() {
        return city;
    }

    public int getArea() {
        return area;
    }

    public int getPrice() {
        return price;
    }


    public Miejsce(String street, int number, String city, int price, String postCode, LocalDate deadline, int area, int houseNumber) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.price = price;
        this.postCode = postCode;
        this.deadline = deadline;
        this.area = area;
        this.houseNumber = houseNumber;
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Ulica: ").append(street).append("\n");
        result.append("Numer domu: ").append(number).append("\n");
        result.append("City: ").append(city).append("\n");
        result.append("Price: ").append(price).append("\n");
        result.append("PostCode: ").append(postCode).append("\n");
        result.append("Oferta aktualna do: ").append(deadline).append("\n");
        result.append("Size: ").append(area).append("\n");
        result.append("HouseNumber: ").append(houseNumber).append("\n");
        return result.toString();
    }
}
