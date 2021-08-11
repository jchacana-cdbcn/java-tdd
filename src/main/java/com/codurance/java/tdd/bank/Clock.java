package com.codurance.java.tdd.bank;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Clock {
    public String now() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
