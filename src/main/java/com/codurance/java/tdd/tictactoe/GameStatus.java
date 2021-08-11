package com.codurance.java.tdd.tictactoe;

public class GameStatus {
    private Player lastPlayer = Player.EMPTY;
    private Player winner = Player.EMPTY;

    public void lastPlayedBy(Player player) {
        this.lastPlayer = player;
    }

    public Player lastPlayed() {
        return lastPlayer;
    }

    public void wonBy(Player player) {
        this.winner = player;
    }

    public Player winner() {
        return this.winner;
    }
}
