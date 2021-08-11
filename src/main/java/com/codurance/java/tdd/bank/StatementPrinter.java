package com.codurance.java.tdd.bank;

import java.util.List;

public class StatementPrinter {
    private Console console;

    public StatementPrinter(Console console) {
        this.console = console;
    }

    public void print(String line) {
        console.printLine(line);
    }

    public void print(List<Transaction> allTransactions) {
        Integer balance = 0;
        for (Transaction transaction : allTransactions) {
            balance += transaction.getAmount();
            console.printLine(transaction.toString() + "| " + balance);
        }
    }
}
