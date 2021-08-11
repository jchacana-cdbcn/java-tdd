package com.codurance.java.tdd.tictactoe;

public class AlreadyPlayedException extends Throwable {
    public AlreadyPlayedException(String alreadyPlayed) {
        super(alreadyPlayed);
    }
}
