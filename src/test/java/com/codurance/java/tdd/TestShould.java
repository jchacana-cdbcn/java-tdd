package com.codurance.java.tdd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestShould {

    @Test
    void test_my_production_class() {
        MyClass myClass = new MyClass();
        assertThat(myClass.getStuff()).isNotNull();
    }
}
