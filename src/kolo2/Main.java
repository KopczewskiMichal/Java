package kolo2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

//import kolo2.*.podpaczka; !!!! to nie przejdzie
//import kolo2.*; //  ZAWSZE KROPKA PRZED *


public class Main {
    static public void main(String[] args) {
        LocalTime myTime = LocalTime.of(10, 40);
        LocalDate myDate = LocalDate.ofYearDay(2024, 250);
        LocalDateTime myDateTime = LocalDateTime.of(myDate, myTime);
        LocalDateTime secondDateTime = LocalDateTime.parse("2024-09-06T10:40");
        System.out.println(myDateTime);
        System.out.println(myDateTime.equals(secondDateTime));
        System.out.println(myDateTime == secondDateTime);

    }
}