package com.codurance.java.tdd.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class StatementPrinterShould {

    @Mock private Console console;
    StatementPrinter statementPrinter;

    @BeforeEach
    void setUp() {
        statementPrinter = new StatementPrinter(console);
    }

    @Test
    void print_a_string_line() {
        statementPrinter.print("a line");

        verify(console).printLine("a line");
    }

    @Test
    void print_nothing_on_an_empty_transaction_list() {
        List<Transaction> emptyList = asList();
        statementPrinter.print(emptyList);

        verify(console, never()).printLine("");
    }

    @Test
    void print_one_line_on_a_one_transaction_list() {
        List<Transaction> someList = asList(new Transaction(100, "02/03/2014"));
        statementPrinter.print(someList);

        verify(console).printLine("02/03/2014 | 100 | 100");
    }
}
