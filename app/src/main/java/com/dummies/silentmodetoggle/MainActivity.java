package com.dummies.silentmodetoggle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.media.AudioManager;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        setContentView(R.layout.activity_main);


        FrameLayout contentView = (FrameLayout) findViewById(R.id.content);

        contentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RingerHelper.performToggle(audioManager);
                updateUi();

            }
        });


    }

    private void updateUi(){

        ImageView imageView = (ImageView) findViewById(R.id.phone_icon);

        int phoneImage = RingerHelper.isPhoneSilent(audioManager)
                ? R.drawable.ringer_off
                : R.drawable.ringer_on;

        imageView.setImageResource(phoneImage);

    }

    @Override
    protected void onResume(){
        super.onResume();
        updateUi();
    }
}
