package com.codurance.java.tdd.bank;

import java.util.List;

public class Account implements AccountService {
    private TransactionRepository repository;
    private StatementPrinter statementPrinter;

    public Account(TransactionRepository repository, StatementPrinter statementPrinter) {
        this.repository = repository;
        this.statementPrinter = statementPrinter;
    }

    @Override
    public void deposit(int amount) {
        this.repository.saveDeposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        this.repository.saveWithdrawal(amount);
    }

    @Override
    public void printStatement() {
        statementPrinter.print("DATE | AMOUNT | BALANCE");
        List<Transaction> allTransactions = repository.getAllTransactions();
        statementPrinter.print(allTransactions);
    }
}
