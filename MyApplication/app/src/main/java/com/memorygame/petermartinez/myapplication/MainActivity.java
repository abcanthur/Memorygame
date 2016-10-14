package com.memorygame.petermartinez.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public boolean isFirstRun = true;
    public CardDeck cardDeck;
    public int numberUniqueCards = 8;
    public int numberCards = numberUniqueCards * 2;
    public int[] possibleAssets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new CardImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(MainActivity.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });

        if(isFirstRun) {
            cardDeck = new CardDeck(numberUniqueCards);
            int[] possibleAssets = {
                    R.drawable.ic_accessibility_24dp,
                    R.drawable.ic_brightness_auto_24dp,
                    R.drawable.ic_dashboard_24dp,
                    R.drawable.ic_face_24dp,
                    R.drawable.ic_favorite_24dp,
                    R.drawable.ic_snooze_24dp,
                    R.drawable.ic_stars_24dp,
                    R.drawable.ic_whatshot_24dp};
            isFirstRun = false;
        }


    }



}
