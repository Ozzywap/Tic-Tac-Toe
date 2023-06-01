package com.example.tictactoe;

import android.os.Build;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = Build.VERSION_CODES.P) // Choose the appropriate SDK version


public class GameBoardTest {

    @Test
    public void testEmptyGameBoard(){
        MainActivity mainActivity = new MainActivity();
//        for(int i = 0; i <mainActivity.gameBoard.length; i++){
//            for(int j = 0; j < mainActivity.gameBoard.length; j++){
//                mainActivity.gameBoard[i][j] = MainActivity.EMPTY;
//            }
//        }
//        mainActivity.gameBoard[0][0] = 1;

        mainActivity.gameBoard[0][0] = 1;
        mainActivity.gameBoard[0][1] = 2;
        mainActivity.gameBoard[0][2] = 1;
        mainActivity.gameBoard[1][0] = 2;
        mainActivity.gameBoard[1][1] = 1;
        mainActivity.gameBoard[1][2] = 2;
        mainActivity.gameBoard[2][0] = 2;
        mainActivity.gameBoard[2][1] = 1;
        mainActivity.gameBoard[2][2] = 2;


        assertFalse(mainActivity.checkWin());
    }
}
