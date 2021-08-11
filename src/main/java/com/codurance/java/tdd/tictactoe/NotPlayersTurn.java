package com.codurance.java.tdd.tictactoe;

public class NotPlayersTurn extends Throwable {
    public NotPlayersTurn(String message) {
        super(message);
    }
}
