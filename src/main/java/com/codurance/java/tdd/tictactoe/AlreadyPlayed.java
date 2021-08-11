package com.codurance.java.tdd.tictactoe;

public class AlreadyPlayed extends Throwable {
    public AlreadyPlayed(String alreadyPlayed) {
        super(alreadyPlayed);
    }
}
