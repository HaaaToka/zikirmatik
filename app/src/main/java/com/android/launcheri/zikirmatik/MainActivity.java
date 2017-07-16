package com.android.launcheri.zikirmatik;

import android.content.Context;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

import static com.android.launcheri.zikirmatik.R.*;
import static com.android.launcheri.zikirmatik.R.raw.salavat;

public class MainActivity extends AppCompatActivity  {

    private int kactane=0;
    private TextView ekran,dene;
    private Button bPlus,bReset,vibration,autoSalavat;
    private boolean vibFlag=true,salav=true,aaa=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        bPlus = (Button) findViewById(id.button1);
        bReset = (Button) findViewById(id.button2);
        ekran = (TextView) findViewById(id.textView1);
        vibration = (Button) findViewById(id.button3);
        autoSalavat = (Button) findViewById(id.button5);

        final AlertDialog alertMessage = new AlertDialog.Builder(this).create();
        alertMessage.setTitle("Bilgilendirme");
        final MediaPlayer ses = MediaPlayer.create(this, R.raw.salavat);

        bPlus.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vibFlag){
                    Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    vib.vibrate(250);
                }
                kactane++; //999999999 sifirla
                ekran.setText(Integer.toString(kactane));
            }
        });

        bReset.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                kactane=0;
                ekran.setText(Integer.toString(kactane));
            }
        });

        vibration.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vibFlag) vibFlag=false;
                else vibFlag=true;
            }
        });

        autoSalavat.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(aaa) {
                    alertMessage.setMessage("Agzın mı yoruldu azda ben okuyum senin yerine :)");
                    alertMessage.show();
                    aaa=false;
                }
                if(salav){
                    alertMessage.setMessage("Birazdan Otomatik Salavat Calmaya Baslıyacak");
                    alertMessage.show();
                    salav=false;
                    ses.start();
                }
                else{
                    alertMessage.setMessage(" Otomatik Salavat Durdurdunuz");
                    alertMessage.show();
                    salav=true;
                    ses.pause();
                }
            }
        });
    }


}
