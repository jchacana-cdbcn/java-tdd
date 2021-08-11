package com.codurance.java.tdd.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AccountShould {

    @Mock private TransactionRepository repository;
    @Mock private StatementPrinter statementPrinter;
    AccountService account;

    @BeforeEach
    void setUp() {
        account = new Account(repository, statementPrinter);
    }

    @Test
    void store_a_deposit_transaction() {
        account.deposit(100);
        verify(repository).saveDeposit(100);
    }

    @Test
    void store_a_withdrawal_transaction() {
        account.withdraw(100);
        verify(repository).saveWithdrawal(100);
    }

    @Test
    void print_empty_statement() {
        List<Transaction> emptyList = new ArrayList<>();
        given(repository.getAllTransactions()).willReturn(emptyList);

        account.printStatement();

        verify(statementPrinter).print("DATE | AMOUNT | BALANCE");
        verify(statementPrinter).print(emptyList);
    }

    @Test
    void print_statement_with_one_transaction() {
        List<Transaction> allTransactions = asList(new Transaction(100, "02/04/2014"));
        given(repository.getAllTransactions()).willReturn(allTransactions);

        account.deposit(100);
        account.printStatement();
        verify(statementPrinter).print("DATE | AMOUNT | BALANCE");
        verify(statementPrinter).print(allTransactions);
    }

    @Test
    void print_statement_with_two_deposits() {

        List<Transaction> allTransactions = asList(
                new Transaction(100, "02/04/2014"),
                new Transaction(100, "03/04/2014"));
        given(repository.getAllTransactions()).willReturn(allTransactions);

        account.deposit(100);
        account.deposit(100);

        account.printStatement();

        verify(statementPrinter).print("DATE | AMOUNT | BALANCE");
        verify(statementPrinter).print(allTransactions);
    }

}
