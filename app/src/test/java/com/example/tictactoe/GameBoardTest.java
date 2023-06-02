package com.example.tictactoe;

import android.os.Build;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = Build.VERSION_CODES.P) // Choose the appropriate SDK version


public class GameBoardTest {
    private MainActivity mainActivity = new MainActivity();
    public void resetGameBoard(){
        for (int i = 0; i < mainActivity.gameBoard.length; i++) {
            for (int j = 0; j < mainActivity.gameBoard.length; j++) {
                mainActivity.gameBoard[i][j] = 0;
            }
        }
    }

    @Test
    public void testEmptyGameBoard(){
        // all cells are by default 0
        assertFalse(mainActivity.checkWin());
    }

    @Test
    public void testTie(){
        mainActivity.gameBoard[0][0] = MainActivity.PLAYER_X;
        mainActivity.gameBoard[0][1] = MainActivity.PLAYER_O;
        mainActivity.gameBoard[0][2] = MainActivity.PLAYER_X;
        mainActivity.gameBoard[1][0] = MainActivity.PLAYER_O;
        mainActivity.gameBoard[1][1] = MainActivity.PLAYER_X;
        mainActivity.gameBoard[1][2] = MainActivity.PLAYER_O;
        mainActivity.gameBoard[2][0] = MainActivity.PLAYER_O;
        mainActivity.gameBoard[2][1] = MainActivity.PLAYER_X;
        mainActivity.gameBoard[2][2] = MainActivity.PLAYER_O;
        assertFalse(mainActivity.checkWin());
    }

    @Test
    public void testRowWins(){
        // test row 1 win
        mainActivity.gameBoard[0][0] = MainActivity.PLAYER_X;
        mainActivity.gameBoard[0][1] = MainActivity.PLAYER_X;
        mainActivity.gameBoard[0][2] = MainActivity.PLAYER_X;
        assertTrue(mainActivity.checkWin());

        // test row 2 win
        resetGameBoard();
        mainActivity.gameBoard[1][0] = MainActivity.PLAYER_O;
        mainActivity.gameBoard[1][1] = MainActivity.PLAYER_O;
        mainActivity.gameBoard[1][2] = MainActivity.PLAYER_O;
        assertTrue(mainActivity.checkWin());

        // test row 3 win
        resetGameBoard();
        mainActivity.gameBoard[2][0] = MainActivity.PLAYER_X;
        mainActivity.gameBoard[2][1] = MainActivity.PLAYER_X;
        mainActivity.gameBoard[2][2] = MainActivity.PLAYER_X;
        assertTrue(mainActivity.checkWin());
    }

    @Test
    public void testColumnWins(){
        // test column 1 win
        mainActivity.gameBoard[0][0] = MainActivity.PLAYER_X;
        mainActivity.gameBoard[1][0] = MainActivity.PLAYER_X;
        mainActivity.gameBoard[2][0] = MainActivity.PLAYER_X;
        assertTrue(mainActivity.checkWin());

        // test column 2 win
        resetGameBoard();
        mainActivity.gameBoard[0][1] = MainActivity.PLAYER_O;
        mainActivity.gameBoard[1][1] = MainActivity.PLAYER_O;
        mainActivity.gameBoard[2][1] = MainActivity.PLAYER_O;
        assertTrue(mainActivity.checkWin());

        // test column 3 win
        resetGameBoard();
        mainActivity.gameBoard[0][2] = MainActivity.PLAYER_X;
        mainActivity.gameBoard[1][2] = MainActivity.PLAYER_X;
        mainActivity.gameBoard[2][2] = MainActivity.PLAYER_X;
        assertTrue(mainActivity.checkWin());
    }

    @Test
    public void testDiagonalWins(){
        // test column 1 win
        mainActivity.gameBoard[0][0] = MainActivity.PLAYER_X;
        mainActivity.gameBoard[1][1] = MainActivity.PLAYER_X;
        mainActivity.gameBoard[2][2] = MainActivity.PLAYER_X;
        assertTrue(mainActivity.checkWin());

        // test column 2 win
        resetGameBoard();
        mainActivity.gameBoard[0][2] = MainActivity.PLAYER_O;
        mainActivity.gameBoard[1][1] = MainActivity.PLAYER_O;
        mainActivity.gameBoard[2][0] = MainActivity.PLAYER_O;
        assertTrue(mainActivity.checkWin());
    }
}
