package com.codurance.java.tdd.tictactoe;

public class TicTacToe {

    private final Board board = new Board();
    private final GameStatus gameStatus = new GameStatus();

    public Player play(Coordinate coordinate, Player player) throws NotPlayersTurn, AlreadyPlayedException {
        validateAndPlay(coordinate, player);
        checkWinner();
        return gameStatus.lastPlayed();
    }

    private void checkWinner() {
        boolean isXWinner = board.evaluateWinningByRow(Player.X, 0);
        boolean isOWinner = board.evaluateWinningByRow(Player.O, 0);
        gameStatus.wonBy(isXWinner ? Player.X: (isOWinner? Player.O: Player.EMPTY));
    }

    private void validateAndPlay(Coordinate coordinate, Player player) throws NotPlayersTurn, AlreadyPlayedException {
        isValidPlayer(player);
        board.placePlay(coordinate, player);
        gameStatus.lastPlayedBy(player);
    }

    private void isValidPlayer(Player player) throws NotPlayersTurn {
        if (isFirstPlay(player, gameStatus.lastPlayed()))
            canPlayerPlay(player, gameStatus.lastPlayed());
    }

    private void canPlayerPlay(Player player, Player lastPlayer) throws NotPlayersTurn {
        if (lastPlayer.equals(player))
            throw new NotPlayersTurn("Not Players Turn");
        if (lastPlayer.equals(Player.EMPTY))
            throw new NotPlayersTurn("Not Players Turn");
    }

    private boolean isFirstPlay(Player player, Player lastPlayer) {
        return !lastPlayer.equals(Player.EMPTY) || !player.equals(Player.X);
    }

    public Player getSymbolAt(Coordinate coordinate) {
        return board.markAt(coordinate);
    }

    public Player winner() {
        return gameStatus.winner();
    }
}