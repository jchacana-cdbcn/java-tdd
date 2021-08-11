package com.codurance.java.tdd.bank;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ClockShould {

    @Test
    void return_todays_date_as_a_string() {
        Clock clock = new Clock();
        assertThat(clock.now()).isEqualTo(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }
}
