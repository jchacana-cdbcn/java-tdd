package com.codurance.java.tdd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class TestShould {

    @Test
    void test_my_production_class() {
        MyClass myClass = new MyClass();
        assertThat(myClass.getStuff()).isNotNull();
    }

    @ParameterizedTest
    @CsvSource({"test, TEST", "tEST, TEST" })
    void test_my_class_with_parameters(String input, String expected) {
        MyClass myClass = new MyClass();
        assertThat(myClass.doStuff(input)).isEqualTo(expected);
    }
}
