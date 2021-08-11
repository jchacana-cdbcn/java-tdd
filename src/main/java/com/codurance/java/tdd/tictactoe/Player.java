package com.codurance.java.tdd.tictactoe;

enum Player {
    X("X"),
    O("O"),
    EMPTY("");

    String value;

    Player(String value) {
        this.value = value;
    }
}
