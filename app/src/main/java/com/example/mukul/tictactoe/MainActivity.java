package com.example.mukul.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int active = 0;
    int[] game = {2,2,2,2,2,2,2,2,2};
    int[][] wins = {{0,1,2},{3,4,5},{6,7,8},{0,4,8},{2,4,6},{0,3,6},{1,4,7},{2,5,8}};
//    0 = red,1 = white
    public void playagain(View view){
        for (int i=0;i<9;i++){
            game[i] = 2;
        }
        GridLayout grid = (GridLayout) findViewById(R.id.mygrid);
        for (int i=0;i<grid.getChildCount();i++){
            ((ImageView) grid.getChildAt(i)).setImageResource(0);
        }
    }

    public void givecounter(View view){
        ImageView counter = (ImageView) view;
//        counter.setTranslationY(-1000f);
        int tapped = Integer.parseInt(counter.getTag().toString());
        System.out.println(tapped+"this is tapped");
        if (game[tapped] == 2 ) {
            System.out.println("coming here");
            game[tapped] = active;
            if (active == 0) {
                active = 1;
                counter.setImageResource(R.drawable.yellow);
            } else {
                active = 0;
                counter.setImageResource(R.drawable.red);
            }
//            counter.animate().translationYBy(1000f).rotation(180).setDuration(1000);
            for (int[] win:wins){
                if(game[win[0]] == game[win[1]] && game[win[0]] == game[win[2]] && game[win[0]]==1){
                    Toast.makeText(this, "Red has won", Toast.LENGTH_SHORT).show();
                    playagain(counter);
                }
                if(game[win[0]] == game[win[1]] && game[win[0]] == game[win[2]] && game[win[0]]==0){
                    Toast.makeText(this, "Yellow has won", Toast.LENGTH_SHORT).show();
                    playagain(counter);
                }
            }
        }
        int count = 0;
        for (int e:game){
            if (e!=2){
                count++;
            }
            if (count==9){
                Toast.makeText(this, "Draw Game", Toast.LENGTH_SHORT).show();
                playagain(counter);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
