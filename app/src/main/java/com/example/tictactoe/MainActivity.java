package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    View x1;
    View x2;
    View x3;
    View x4;
    View x5;
    View x6;
    View x7;
    View x8;
    View x9;
    Button reset;
    Button state;
    TextView player1_score;
    TextView player2_score;
    boolean player1Turn = true;
    public static final int EMPTY = 0;
    public static final int PLAYER_X = 1;
    public static final int PLAYER_O = 2;
    private int[][] gameBoard = new int[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player1_score = findViewById(R.id.player_1_score);
        player2_score = findViewById(R.id.player_2_score);
        reset = findViewById(R.id.reset);
        x1 = findViewById(R.id.x1);
        x2 = findViewById(R.id.x2);
        x3 = findViewById(R.id.x3);
        x4 = findViewById(R.id.x4);
        x5 = findViewById(R.id.x5);
        x6 = findViewById(R.id.x6);
        x7 = findViewById(R.id.x7);
        x8 = findViewById(R.id.x8);
        x9 = findViewById(R.id.x9);
        state = findViewById(R.id.state);

        state.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String state = "";
                for(int i = 0; i < gameBoard.length; i++){
                        for(int j = 0; j < gameBoard.length; j++){
                            state += gameBoard[i][j];
                        }
                }
                Toast.makeText(getApplicationContext(), state, Toast.LENGTH_LONG).show();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });

        x1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player1Turn){
                    x1.setBackgroundResource(R.drawable.x);
                    gameBoard[0][0] = PLAYER_X;
                } else{
                    x1.setBackgroundResource(R.drawable.o);
                    gameBoard[0][0] = PLAYER_O;
                }
                player1Turn = !player1Turn;
                x1.setEnabled(false);
                checkWin();

            }
        });

        x2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player1Turn){
                    x2.setBackgroundResource(R.drawable.x);
                    gameBoard[0][1] = PLAYER_X;
                } else{
                    x2.setBackgroundResource(R.drawable.o);
                    gameBoard[0][1] = PLAYER_O;
                }
                player1Turn = !player1Turn;
                x2.setEnabled(false);
                checkWin();

            }
        });
        x3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player1Turn){
                    x3.setBackgroundResource(R.drawable.x);
                    gameBoard[0][2] = PLAYER_X;
                } else{
                    x3.setBackgroundResource(R.drawable.o);
                    gameBoard[0][2] = PLAYER_O;
                }
                player1Turn = !player1Turn;
                x3.setEnabled(false);
                checkWin();

            }
        });
        x4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player1Turn){
                    x4.setBackgroundResource(R.drawable.x);
                    gameBoard[1][0] = PLAYER_X;
                } else{
                    x4.setBackgroundResource(R.drawable.o);
                    gameBoard[1][0] = PLAYER_O;
                }
                player1Turn = !player1Turn;
                x4.setEnabled(false);
                checkWin();

            }
        });
        x5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player1Turn){
                    x5.setBackgroundResource(R.drawable.x);
                    gameBoard[1][1] = PLAYER_X;
                } else{
                    x5.setBackgroundResource(R.drawable.o);
                    gameBoard[1][1] = PLAYER_O;
                }
                player1Turn = !player1Turn;
                x5.setEnabled(false);
                checkWin();

            }
        });
        x6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player1Turn){
                    x6.setBackgroundResource(R.drawable.x);
                    gameBoard[1][2] = PLAYER_X;
                } else{
                    x6.setBackgroundResource(R.drawable.o);
                    gameBoard[1][2] = PLAYER_O;
                }
                player1Turn = !player1Turn;
                x6.setEnabled(false);
                checkWin();

            }
        });
        x7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player1Turn){
                    x7.setBackgroundResource(R.drawable.x);
                    gameBoard[2][0] = PLAYER_X;
                } else{
                    x7.setBackgroundResource(R.drawable.o);
                    gameBoard[2][0] = PLAYER_O;
                }
                player1Turn = !player1Turn;
                x7.setEnabled(false);
                checkWin();

            }
        });
        x8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player1Turn){
                    x8.setBackgroundResource(R.drawable.x);
                    gameBoard[2][1] = PLAYER_X;
                } else{
                    x8.setBackgroundResource(R.drawable.o);
                    gameBoard[2][1] = PLAYER_O;
                }
                player1Turn = !player1Turn;
                x8.setEnabled(false);
                checkWin();

            }
        });
        x9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player1Turn){
                    x9.setBackgroundResource(R.drawable.x);
                    gameBoard[2][2] = PLAYER_X;
                } else{
                    x9.setBackgroundResource(R.drawable.o);
                    gameBoard[2][2] = PLAYER_O;
                }
                player1Turn = !player1Turn;
                x9.setEnabled(false);
                checkWin();

            }
        });
    }


    private boolean checkWin() {
        // Check rows
        for (int i = 0; i < gameBoard.length; i++) {
            if (gameBoard[i][0] != EMPTY && gameBoard[i][0] == gameBoard[i][1] && gameBoard[i][0] == gameBoard[i][2]) {
                announceWinner();
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < gameBoard.length; i++) {
            if (gameBoard[0][i] != EMPTY && gameBoard[0][i] == gameBoard[1][i] && gameBoard[0][i] == gameBoard[2][i]) {
                announceWinner();
                return true;
            }
        }

        // Check diagonals
        if (gameBoard[0][0] != EMPTY && gameBoard[0][0] == gameBoard[1][1] && gameBoard[0][0] == gameBoard[2][2]) {
            announceWinner();
            return true;
        }
        if (gameBoard[0][2] != EMPTY && gameBoard[0][2] == gameBoard[1][1] && gameBoard[0][2] == gameBoard[2][0]) {
            announceWinner();
            return true;
        }
        boolean tie = true;
        for(int i = 0; i < gameBoard.length; i++){
            for(int j = 0; j < gameBoard.length; j++){
                if(gameBoard[i][j] == EMPTY){
                    tie = false;
                }
            }
        }
        if (tie){
            Toast.makeText(getApplicationContext(), "Tie!", Toast.LENGTH_SHORT).show();
            reset();
        }


        return false;
    }

    void announceWinner(){
        if(!player1Turn) {
            Toast.makeText(getApplicationContext(), "Player 1 is the Winner", Toast.LENGTH_SHORT).show();
            String scoreString = player1_score.getText().toString();
            int score = 0;
            if (scoreString.equals("0"))
                score = 1;
            else
                score = Integer.parseInt(scoreString) + 1;

            player1_score.setText(score + "");

        } else{
            Toast.makeText(getApplicationContext(), "Player 2 is the Winner", Toast.LENGTH_SHORT).show();
            String scoreString = player2_score.getText().toString();
            int score = 0;
            if (scoreString.equals("0"))
                score = 1;
            else
                score = Integer.parseInt(scoreString) + 1;

            player2_score.setText(score + "");
        }
        reset();
    }


    void reset(){
        x1.setBackgroundColor(Color.WHITE);
        x2.setBackgroundColor(Color.WHITE);
        x3.setBackgroundColor(Color.WHITE);
        x4.setBackgroundColor(Color.WHITE);
        x5.setBackgroundColor(Color.WHITE);
        x6.setBackgroundColor(Color.WHITE);
        x7.setBackgroundColor(Color.WHITE);
        x8.setBackgroundColor(Color.WHITE);
        x9.setBackgroundColor(Color.WHITE);
        x1.setEnabled(true);
        x2.setEnabled(true);
        x3.setEnabled(true);
        x4.setEnabled(true);
        x5.setEnabled(true);
        x6.setEnabled(true);
        x7.setEnabled(true);
        x8.setEnabled(true);
        x9.setEnabled(true);

        for(int i = 0; i < gameBoard.length; i++){
            for(int j = 0; j < gameBoard.length; j++){
                gameBoard[i][j] = 0;
            }
        }
        player1Turn = true;

    }
}