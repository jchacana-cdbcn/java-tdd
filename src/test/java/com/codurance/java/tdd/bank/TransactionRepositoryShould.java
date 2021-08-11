package com.codurance.java.tdd.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class TransactionRepositoryShould {

    @Mock private Clock clock;
    TransactionRepository repository;

    @BeforeEach
    void setUp() {
        repository = new TransactionRepository(clock);
    }

    @Test
    void store_a_deposit_transaction() {
        given(clock.now()).willReturn("02/03/2014");

        repository.saveDeposit(100);

        List<Transaction> someList = asList(new Transaction(100, "02/03/2014"));
        assertThat(repository.getAllTransactions()).containsAll(someList);
    }

    @Test
    void store_a_deposit_transaction_on_a_given_date() {
        given(clock.now()).willReturn("03/03/2014");

        repository.saveDeposit(100);
        List<Transaction> someList = asList(new Transaction(100, "03/03/2014"));
        assertThat(repository.getAllTransactions()).containsAll(someList);
    }

    @Test
    void store_a_withdrawal_transaction() {
        given(clock.now()).willReturn("03/03/2014");

        repository.saveWithdrawal(100);
        List<Transaction> someList = asList(new Transaction(-100, "03/03/2014"));
        assertThat(repository.getAllTransactions()).containsAll(someList);
    }
}
