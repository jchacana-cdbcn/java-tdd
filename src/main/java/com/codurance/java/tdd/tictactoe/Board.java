package com.codurance.java.tdd.tictactoe;

import java.util.Arrays;

class Board {

    Player[][] board = {
            {Player.EMPTY, Player.EMPTY, Player.EMPTY},
            {Player.EMPTY, Player.EMPTY, Player.EMPTY},
            {Player.EMPTY, Player.EMPTY, Player.EMPTY}
    };

    public void placePlay(Coordinate coordinate, Player player) throws AlreadyPlayedException {
        validMove(coordinate);
        board[coordinate.x][coordinate.y] = player;
    }

    public Player markAt(Coordinate coordinate) {
        return board[coordinate.x][coordinate.y];
    }

    public void validMove(Coordinate coordinate) throws AlreadyPlayedException {
        if (!board[coordinate.x][coordinate.y].equals(Player.EMPTY))
            throw new AlreadyPlayedException("Already played position");
    }

    public boolean evaluateWinningByRow(Player player, int rowIndex) {
        return Arrays.stream(board[rowIndex]).allMatch(symbol -> symbol.equals(player));
    }
}
