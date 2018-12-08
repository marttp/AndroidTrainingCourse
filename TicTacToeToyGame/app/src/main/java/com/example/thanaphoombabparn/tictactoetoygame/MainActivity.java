package com.example.thanaphoombabparn.tictactoetoygame;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int activePlayer = 1;
    private int countClick = 0;
    ArrayList<Integer> player1 = new ArrayList<>();
    ArrayList<Integer> player2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnClick(View view) {
        Button btn = (Button) view;
        btn.setBackgroundColor(Color.RED);
        int cellId = 0;
        switch (btn.getId()) {
            case R.id.btn1:
                cellId = 1;
                break;
            case R.id.btn2:
                cellId = 2;
                break;
            case R.id.btn3:
                cellId = 3;
                break;
            case R.id.btn4:
                cellId = 4;
                break;
            case R.id.btn5:
                cellId = 5;
                break;
            case R.id.btn6:
                cellId = 6;
                break;
            case R.id.btn7:
                cellId = 7;
                break;
            case R.id.btn8:
                cellId = 8;
                break;
            case R.id.btn9:
                cellId = 9;
                break;
        }
        playGame(cellId, btn);
    }

    void playGame(int cellId, Button btn) {
        countClick++;
        Log.d("Player :", String.valueOf(cellId));
        if (activePlayer == 1) {
            btn.setText("X");
            btn.setBackgroundColor(Color.GREEN);
            player1.add(cellId);
            activePlayer = 2;
            autoPlay();
        } else if (activePlayer == 2) {
            btn.setText("O");
            btn.setBackgroundColor(Color.CYAN);
            player2.add(cellId);
            activePlayer = 1;
        }
        btn.setEnabled(false);
        findWinner();
    }

    private void findWinner() {
        int winner = -1;
        if ((player1.contains(1) && player1.contains(2) && player1.contains(3)) ||
                (player1.contains(1) && player1.contains(4) && player1.contains(7)) ||
                (player1.contains(1) && player1.contains(5) && player1.contains(9)) ||
                (player1.contains(4) && player1.contains(5) && player1.contains(6)) ||
                (player1.contains(7) && player1.contains(8) && player1.contains(9)) ||
                (player1.contains(7) && player1.contains(5) && player1.contains(3)) ||
                (player1.contains(2) && player1.contains(5) && player1.contains(8)) ||
                (player1.contains(3) && player1.contains(6) && player1.contains(9))) {
            winner = 1;
        } else if ((player2.contains(1) && player2.contains(2) && player2.contains(3)) ||
                (player2.contains(1) && player2.contains(4) && player2.contains(7)) ||
                (player2.contains(1) && player2.contains(5) && player2.contains(9)) ||
                (player2.contains(4) && player2.contains(5) && player2.contains(6)) ||
                (player2.contains(7) && player2.contains(8) && player2.contains(9)) ||
                (player2.contains(7) && player2.contains(5) && player2.contains(3)) ||
                (player2.contains(2) && player2.contains(5) && player2.contains(8)) ||
                (player2.contains(3) && player2.contains(6) && player2.contains(9))) {
            winner = 2;
        } else if (countClick == 9){
            winner = 3;
        }

        if (winner != -1) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            if(winner == 3){
                builder.setMessage("Draw game!");
            } else {
                builder.setMessage((winner == 1 ? "Player" : "Bot" )+" Win!");
            }
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                }
            });
            builder.show();
        }
    }


    private void autoPlay() {
        ArrayList<Integer> emptyCells = new ArrayList<>();

        // Find remain number can push to arrayList
        for (int cellId = 1; cellId < 10; cellId++) {
            if (!(player1.contains(cellId) || player2.contains(cellId))) {
                emptyCells.add(cellId);
            }
        }

        if(activePlayer == 2){
            Log.i("emptyCells", String.valueOf(emptyCells));
            Random random = new Random();
            if(emptyCells.size() > 0){
                int randIndex = random.nextInt(emptyCells.size());
                int cellId = emptyCells.get(randIndex);
                Button btn;
                switch (cellId) {
                    case 1:
                        btn = findViewById(R.id.btn1);
                        break;
                    case 2:
                        btn = findViewById(R.id.btn2);
                        break;
                    case 3:
                        btn = findViewById(R.id.btn3);
                        break;
                    case 4:
                        btn = findViewById(R.id.btn4);
                        break;
                    case 5:
                        btn = findViewById(R.id.btn5);
                        break;
                    case 6:
                        btn = findViewById(R.id.btn6);
                        break;
                    case 7:
                        btn = findViewById(R.id.btn7);
                        break;
                    case 8:
                        btn = findViewById(R.id.btn8);
                        break;
                    case 9:
                        btn = findViewById(R.id.btn9);
                        break;
                    default:
                        btn = findViewById(R.id.btn1);
                        break;
                }
                playGame(cellId, btn);
            }
        }
    }
}
