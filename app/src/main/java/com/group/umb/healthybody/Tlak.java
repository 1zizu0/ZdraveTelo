package com.group.umb.healthybody;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

/**
 * Created by Legolas on 9. 3. 2015.
 */
public class Tlak extends ActionBarActivity {

    TextView casovac, serie, opakovania;
    int pocitadloSerie = 1, opakovanieTemp = 1, zvysokPoDeleni =0, citac = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tlak1);
        logikaTlak();

    }

    public void logikaTlak()
    {

        casovac = (TextView)findViewById(R.id.textViewCasovac);
        serie = (TextView)findViewById(R.id.textViewSerie);
        opakovania = (TextView)findViewById(R.id.textViewOpakovania);

        Button play = (Button)findViewById(R.id.buttonPlay);
        Button stop = (Button)findViewById(R.id.buttonStop);
        Button next = (Button)findViewById(R.id.buttonDalej);
        Button previous = (Button)findViewById(R.id.buttonPredosly);

        casovac.setText("01:00");

        final triedaCsovac pocitadlo = new triedaCsovac(15000, 1000);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pocitadlo.start();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pocitadlo.cancel();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.tlak2);
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.tlak1);
            }
        });

    }

    public class triedaCsovac extends CountDownTimer
    {

        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
        public triedaCsovac(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            long milisekundy = millisUntilFinished;
            String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(milisekundy),
                    TimeUnit.MILLISECONDS.toMinutes(milisekundy) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(milisekundy)),
                    TimeUnit.MILLISECONDS.toSeconds(milisekundy) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milisekundy)));
            casovac.setText(hms);
            zvysokPoDeleni = citac%2;
            //Toast.makeText(getApplicationContext(), zvysokPoDeleni+ "", Toast.LENGTH_LONG).show();
            if ( zvysokPoDeleni == 0)
            {
                opakovania.setText(opakovanieTemp+"/30");
                opakovanieTemp++;

            }

            citac++;



        }

        @Override
        public void onFinish() {
            pocitadloSerie = pocitadloSerie + 1;

            if (pocitadloSerie == 2)
            {
                serie.setText("2/3");
            }
            if (pocitadloSerie == 3)
            {
                serie.setText("3/3");
            }
            casovac.setText("Koniec");
        }
    }
}
