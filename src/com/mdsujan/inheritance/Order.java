package com.mdsujan.inheritance;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Order {
    private static int count = 0;
    private final String id;
    private final LocalDate datePlaced;

    public Order(LocalDate datePlaced) {
        this.datePlaced = datePlaced;
        this.id = datePlaced.format(DateTimeFormatter.ofPattern("dd/MM/YYYY"))+(++count);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", datePlaced=" + datePlaced +
                '}';
    }
}
