package com.group.umb.healthybody;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kliknutiaMain();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void kliknutiaMain()
    {
        final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);

        Button buttonTest = (Button)findViewById(R.id.buttonTest);

        Button buttonHistoria = (Button)findViewById(R.id.buttonHistoria);
        Button buttonNemamCas = (Button)findViewById(R.id.buttonNemamCas);
        Button buttonCviky = (Button)findViewById(R.id.buttonCviky);

        ImageButton imageButtonAnglictina = (ImageButton)findViewById(R.id.imageButtonAnglictina);
        ImageButton imageButtonSlovencina = (ImageButton)findViewById(R.id.imageButtonSlovencina);

        buttonTest.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animAlpha);
                Intent i = new Intent(v.getContext(), Test.class);
                startActivityForResult(i, 0);
              }
        });

        buttonHistoria.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animAlpha);
                Intent i = new Intent(v.getContext(), Historia.class);
                startActivityForResult(i, 0);
            }
        });
        buttonCviky.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animAlpha);
                Intent i = new Intent(v.getContext(), Cviky.class);
                startActivityForResult(i, 0);
            }
        });
        buttonNemamCas.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animAlpha);
                Intent i = new Intent(v.getContext(), NemamCas.class);
                startActivityForResult(i, 0);
            }
        });
        imageButtonAnglictina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Anglictina kliknuta", Toast.LENGTH_LONG).show();
            }
        });
        imageButtonSlovencina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Slovencina kliknuta", Toast.LENGTH_LONG).show();
            }
        });


    }
}
