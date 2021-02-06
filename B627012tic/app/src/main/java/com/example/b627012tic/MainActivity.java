package com.example.b627012tic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button[][] buttons = new Button[3][3];
    private boolean player1Turn = true;

    private int roundCount;

    private int player1Points;
    private int player2Points;

    private TextView textViewPlayer1;
    private TextView textViewPlayer2;
    private Button buttonReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewPlayer1 = findViewById(R.id.textViewP1);
        textViewPlayer2 = findViewById(R.id.textViewP2);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonID = "button" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(this);
            }
        }
        buttonReset = findViewById(R.id.buttonReset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        if (!((Button) v).getText().toString().equals("")) {
            return;
        }

        if (player1Turn) {
            ((Button) v).setText("X");
        } else {
            ((Button) v).setText("O");
        }

        roundCount++;

        if(checkForWin()){
            if(player1Turn){
                player1Wins();
            }else{
                player2Wins();
            }
        }else if (roundCount == 9){
            draw();
        }else{
            player1Turn = !player1Turn;
        }
    }

    private boolean checkForWin() {
        String[][] fields = new String[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                fields[i][j] = buttons[i][j].getText().toString();
            }
        }

        for (int i = 0; i < 3; i++) {
            if (fields[i][0].equals(fields[i][1])
                    && fields[i][0].equals(fields[i][2])
                    && !fields[i][0].equals("")) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (fields[0][i].equals(fields[1][i])
                    && fields[0][i].equals(fields[2][i])
                    && !fields[0][i].equals("")) {
                return true;
            }
        }
        if (fields[0][0].equals(fields[1][1])
                && fields[1][1].equals(fields[2][2])
                && !fields[0][0].equals("")) {
            return true;
        }
        if (fields[0][2].equals(fields[1][1])
                && fields[1][1].equals(fields[2][0])
                && !fields[0][2].equals("")) {
            return true;
        }
        return false;
    }

    private void player1Wins(){

    }

    private void player2Wins(){

    }

    private void draw(){
        
    }

}