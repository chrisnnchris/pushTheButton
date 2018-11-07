package com.example.cerean.pushthebutton;

import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mp;
    Spinner spinnerObj;
    String songSelected;
    ImageView imageViewObj;
    /*
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        Log.i("itemSelected", parent.getItemAtPosition(pos).toString());
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
    */

    public void playSound(View view) {
        Log.i("Playing", "as stated");
        if (mp == null) {
            Log.i("notNullMP", "as stated");
            //mp = MediaPlayer.create(this, R.raw.walter_white);
            mp = MediaPlayer.create(this, getResources().getIdentifier(songSelected, "raw", getPackageName()));
            //imageViewObj.setImageResource(R.values."@color/colorAccent");
            imageViewObj.setColorFilter(this.getResources().getColor(R.color.colorPrimary));
            //imageViewObj.setImageResource("#00574B");
            mp.start();
        } else {
            Log.i("NullMP", "as stated");
            imageViewObj.setColorFilter(this.getResources().getColor(R.color.colorAccent));
            mp.stop();
            mp.release();
            mp = null;
        }
        /*
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.stop();
                mp.release();
                mp = null;
            }
        });
        */
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerObj = (Spinner) findViewById(R.id.spinner);
        imageViewObj = (ImageView) findViewById(R.id.imageView);
        String[] songs = new String[2];
        songs[0] = "walter_white";
        songs[1] = "anyway";
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, songs);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerObj.setAdapter(adapter);
        songSelected = songs[0];

        spinnerObj.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here
                Log.i("itemSelected", parentView.getItemAtPosition(position).toString());
                songSelected = parentView.getItemAtPosition(position).toString();
                Log.i("songSelectedNow", songSelected);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
    }
}
