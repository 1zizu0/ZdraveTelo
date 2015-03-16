package com.group.umb.healthybody;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

/**
 * Created by Legolas on 10. 3. 2015.
 */
public class Cviky extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cviky);
        kliknutiaCviky();
    }

    public void kliknutiaCviky()
    {
        Button buttonTlak = (Button)findViewById(R.id.buttonTlak);
        Button buttonTah = (Button)findViewById(R.id.buttonTah);
        Button buttonNohy = (Button)findViewById(R.id.buttonNohy);
        Button buttonJadro = (Button)findViewById(R.id.buttonJadro);

        final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);

        buttonTlak.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animAlpha);
                Intent i = new Intent(v.getContext(), Tlak.class);
                startActivityForResult(i, 0);

            }
        });
        buttonTah.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animAlpha);
                Intent i = new Intent(v.getContext(), Tah.class);
                startActivityForResult(i, 0);
            }
        });
        buttonNohy.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animAlpha);
                Intent i = new Intent(v.getContext(), Nohy.class);
                startActivityForResult(i, 0);
            }
        });
        buttonJadro.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animAlpha);
                Intent i = new Intent(v.getContext(), Jadro.class);
                startActivityForResult(i, 0);
            }
        });
    }
}
