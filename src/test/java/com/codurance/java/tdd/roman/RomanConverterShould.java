package com.codurance.java.tdd.roman;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RomanConverterShould {

    @ParameterizedTest
    @CsvSource({"1, I", "2, II", "3, III"})
    void print_variant_of_I_when_converting_1_to_3(Integer input, String expected) {
        RomanConverter romanConverter = new RomanConverter();
        assertThat(romanConverter.convert(input)).isEqualTo(expected);
    }

    @Test
    void print_IV_when_converting_4() {
        RomanConverter romanConverter = new RomanConverter();
        assertThat(romanConverter.convert(4)).isEqualTo("IV");
    }


    @ParameterizedTest
    @CsvSource({"5, V", "6, VI", "7, VII", "8, VIII"})
    void print_variant_of_V_when_converting_5_to_7(Integer input, String expected) {
        RomanConverter romanConverter = new RomanConverter();
        assertThat(romanConverter.convert(input)).isEqualTo(expected);
    }

    @Test
    void print_IX_when_converting_9() {
        RomanConverter romanConverter = new RomanConverter();
        assertThat(romanConverter.convert(9)).isEqualTo("IX");
    }

    @ParameterizedTest
    @CsvSource({"10, X", "11, XI", "12, XII", "13, XIII", "14, XIV", "15, XV", "17, XVII", "19, XIX", "23, XXIII", "39, XXXIX"})
    void print_variant_of_X_when_converting_10_to_39(Integer input, String expected) {
        RomanConverter romanConverter = new RomanConverter();
        assertThat(romanConverter.convert(input)).isEqualTo(expected);
    }

    @Test
    void print_XL_when_converting_40() {
        RomanConverter romanConverter = new RomanConverter();
        assertThat(romanConverter.convert(40)).isEqualTo("XL");
    }
}
