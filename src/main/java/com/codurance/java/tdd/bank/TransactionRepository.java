package com.codurance.java.tdd.bank;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {

    private List<Transaction> transactions = new ArrayList<>();
    private Clock clock;

    public TransactionRepository(Clock clock) {
        this.clock = clock;
    }

    public void saveDeposit(int amount) {
        transactions.add(new Transaction(amount, clock.now()));
    }

    public void saveWithdrawal(int amount) {
        transactions.add(new Transaction(amount * -1, clock.now()));
    }

    public List<Transaction> getAllTransactions() {
        return transactions;
    }
}
