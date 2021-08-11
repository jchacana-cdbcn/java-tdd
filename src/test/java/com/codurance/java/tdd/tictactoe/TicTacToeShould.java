package com.codurance.java.tdd.tictactoe;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * X always goes first
 * Players alternate placing X’s and O’s on the board
 * Players cannot play on a played position
 * A player with 3 X’s or 3 O’s in a row (vertically, horizontally or diagonally) wins the game.
 * If all 9 squares are filled and neither player achieves 3 in a row, the game is a draw.
 *
 *
 *
 * [00][01][02]
 * [10][11][12]
 * [20][21][22]
 */
public class TicTacToeShould {

    @Test
    void make_sure_X_goes_first() throws NotPlayersTurn, AlreadyPlayed {
        TicTacToe game = new TicTacToe();
        Player player = game.play(new Coordinate(0, 0), Player.X);
        assertThat(player).isEqualTo(Player.X);
    }

    @Test
    void make_sure_O_cant_go_first() {
        TicTacToe game = new TicTacToe();
        assertThrows(NotPlayersTurn.class, () -> game.play(new Coordinate(0, 0), Player.O));
    }

    @Test
    void make_sure_X_can_not_play_twice() throws NotPlayersTurn, AlreadyPlayed {
        TicTacToe game = new TicTacToe();
        game.play(new Coordinate(0, 0), Player.X);
        assertThrows(NotPlayersTurn.class, () -> game.play(new Coordinate(0, 0), Player.X));
    }

    @Test
    void make_sure_O_can_go_second() throws NotPlayersTurn, AlreadyPlayed {
        TicTacToe game = new TicTacToe();
        game.play(new Coordinate(0, 0), Player.X);
        Player player = game.play(new Coordinate(1, 0), Player.O);
        assertThat(player).isEqualTo(Player.O);
    }

    @Test
    void make_sure_X_is_third() throws NotPlayersTurn, AlreadyPlayed {
        TicTacToe game = new TicTacToe();
        game.play(new Coordinate(0, 0), Player.X);
        game.play(new Coordinate(1, 0), Player.O);
        Player player = game.play(new Coordinate(2, 0), Player.X);
        assertThat(player).isEqualTo(Player.X);
    }

    @Test
    void make_sure_O_is_fourth() throws NotPlayersTurn, AlreadyPlayed {
        TicTacToe game = new TicTacToe();
        game.play(new Coordinate(0, 0), Player.X);
        game.play(new Coordinate(0, 1), Player.O);
        game.play(new Coordinate(0, 2), Player.X);
        Player player = game.play(new Coordinate(1, 0), Player.O);
        assertThat(player).isEqualTo(Player.O);
    }

    @Test
    void place_X_play_in_position_0_0() throws NotPlayersTurn, AlreadyPlayed {
        TicTacToe game = new TicTacToe();
        game.play(new Coordinate(0, 0), Player.X);
        assertThat(game.getSymbolAt(new Coordinate(0, 0))).isEqualTo(Player.X);
    }

    @Test
    void place_O_play_in_position_1_0() throws NotPlayersTurn, AlreadyPlayed {
        TicTacToe game = new TicTacToe();
        game.play(new Coordinate(0, 0), Player.X);
        game.play(new Coordinate(1, 0), Player.O);
        assertThat(game.getSymbolAt(new Coordinate(1, 0))).isEqualTo(Player.O);
    }

    @Test
    void place_X_play_in_position_1_1() throws NotPlayersTurn, AlreadyPlayed {
        TicTacToe game = new TicTacToe();
        game.play(new Coordinate(0, 0), Player.X);
        game.play(new Coordinate(1, 0), Player.O);
        game.play(new Coordinate(1, 1), Player.X);
        assertThat(game.getSymbolAt(new Coordinate(1, 1))).isEqualTo(Player.X);
    }

    @Test
    void throw_error_when_trying_to_play_in_a_played_position() throws NotPlayersTurn, AlreadyPlayed {
        TicTacToe game = new TicTacToe();
        game.play(new Coordinate(0, 0), Player.X);
        assertThrows(AlreadyPlayed.class, () -> game.play(new Coordinate(0, 0), Player.O));
    }

    @Test
    void declare_player_X_winner_when_3_horizontal_top() throws NotPlayersTurn, AlreadyPlayed {
        TicTacToe game = new TicTacToe();
        game.play(new Coordinate(0, 0), Player.X);
        game.play(new Coordinate(1, 0), Player.O);
        game.play(new Coordinate(0, 1), Player.X);
        game.play(new Coordinate(1, 1), Player.O);
        game.play(new Coordinate(0, 2), Player.X);
        assertThat(game.winner()).isEqualTo(Player.X);
    }

    @Test
    void declare_player_O_winner_when_3_horizontal_top() throws NotPlayersTurn, AlreadyPlayed {
        TicTacToe game = new TicTacToe();
        game.play(new Coordinate(1, 0), Player.X);
        game.play(new Coordinate(0, 0), Player.O);
        game.play(new Coordinate(1, 1), Player.X);
        game.play(new Coordinate(0, 1), Player.O);
        game.play(new Coordinate(2, 2), Player.X);
        game.play(new Coordinate(0, 2), Player.O);
        assertThat(game.winner()).isEqualTo(Player.O);
    }
}
