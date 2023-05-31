package com.example.tictactoe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView x1;
    TextView x2;
    TextView x3;
    TextView x4;
    TextView x5;
    TextView x6;
    TextView x7;
    TextView x8;
    TextView x9;
    Button reset;
    Button state;
    TextView player1Score;
    TextView player2Score;
    TextView playerTurn;
    boolean player1Turn = true;
    public static final int EMPTY = 0;
    public static final int PLAYER_X = 1;
    public static final int PLAYER_O = 2;
    private int[][] gameBoard = new int[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player1Score = findViewById(R.id.player_1_score);
        player2Score = findViewById(R.id.player_2_score);
        playerTurn = findViewById(R.id.player_turn);
        reset = findViewById(R.id.reset);
        x1 = findViewById(R.id.text_view00);
        x2 = findViewById(R.id.text_view01);
        x3 = findViewById(R.id.text_view02);
        x4 = findViewById(R.id.text_view10);
        x5 = findViewById(R.id.text_view11);
        x6 = findViewById(R.id.text_view12);
        x7 = findViewById(R.id.text_view20);
        x8 = findViewById(R.id.text_view21);
        x9 = findViewById(R.id.text_view22);
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
                resetGame();
            }
        });

        x1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setView(x1);
                if (player1Turn){
                    gameBoard[0][0] = PLAYER_X;
                } else{
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
                setView(x2);
                if (player1Turn){
                    gameBoard[0][1] = PLAYER_X;
                } else{
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
                setView(x3);
                if (player1Turn){
                    gameBoard[0][2] = PLAYER_X;
                } else{
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
                setView(x4);
                if (player1Turn){
                    gameBoard[1][0] = PLAYER_X;
                } else{
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
                setView(x5);
                if (player1Turn){
                    gameBoard[1][1] = PLAYER_X;
                } else{
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
                setView(x6);
                if (player1Turn){
                    gameBoard[1][2] = PLAYER_X;
                } else{
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
                setView(x7);
                if (player1Turn){
                    gameBoard[2][0] = PLAYER_X;
                } else{
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
                setView(x8);
                if (player1Turn){
                    gameBoard[2][1] = PLAYER_X;
                } else{
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
                setView(x9);
                if (player1Turn){
                    gameBoard[2][2] = PLAYER_X;
                } else{
                    gameBoard[2][2] = PLAYER_O;
                }
                player1Turn = !player1Turn;
                x9.setEnabled(false);
                checkWin();

            }
        });

        if (savedInstanceState == null || savedInstanceState.isEmpty()){
            reloadData();
        }
    }

  void setView(TextView v){
      if(player1Turn){
          v.setText("X");
      } else{
          v.setText("O");
      }
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("player1Score", player1Score.getText().toString());
        outState.putString("player2Score", player2Score.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        player1Score.setText(savedInstanceState.getString("player1Score", "-1"));
        player2Score.setText(savedInstanceState.getString("player2Score", "-1"));

    void saveState(){
        SharedPreferences sp = getSharedPreferences("file1", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("player1Score", player1Score.getText().toString());
        editor.putString("player2Score", player2Score.getText().toString());
        editor.apply();
    }

    public void reloadData() {
        SharedPreferences sp = getSharedPreferences("file1", MODE_PRIVATE);
        player1Score.setText(sp.getString("player1Score", "-1"));
        player2Score.setText(sp.getString("player2Score", "-1"));
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

        setPlayerTurn();

        return false;
    }

    public void setPlayerTurn(){
        if(player1Turn){
            playerTurn.setText("Turn: Player X");
        } else{
            playerTurn.setText("Turn: Player O");
        }
    }

    public void announceWinner(){
        if(!player1Turn) {
            Toast.makeText(getApplicationContext(), "Player 1 is the Winner", Toast.LENGTH_SHORT).show();
            String scoreString = player1Score.getText().toString();
            int score = 0;
            if (scoreString.equals("0"))
                score = 1;
            else
                score = Integer.parseInt(scoreString) + 1;

            player1Score.setText(score + "");

        } else{
            Toast.makeText(getApplicationContext(), "Player 2 is the Winner", Toast.LENGTH_SHORT).show();
            String scoreString = player2Score.getText().toString();
            int score = 0;
            if (scoreString.equals("0"))
                score = 1;
            else
                score = Integer.parseInt(scoreString) + 1;

            player2Score.setText(score + "");
        }
        saveState();
        reset();
    }


    public void reset(){
        x1.setText("");
        x2.setText("");
        x3.setText("");
        x4.setText("");
        x5.setText("");
        x6.setText("");
        x7.setText("");
        x8.setText("");
        x9.setText("");
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
        setPlayerTurn();

    }

    public void resetGame(){
        player1Score.setText("0");
        player2Score.setText("0");
        saveState();
        reset();
    }
}