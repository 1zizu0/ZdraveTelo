package com.group.umb.healthybody;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Legolas on 9. 3. 2015.
 */
public class Test extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        urcenieUrovne();
    }

    public void urcenieUrovne()
    {
        final EditText pocetKlukov = (EditText)findViewById(R.id.editTextPocetKlukov);
        final EditText statickyKluk = (EditText)findViewById(R.id.editTextStatickyKluk);
        final EditText pocetDrepov = (EditText)findViewById(R.id.editTextPocetDrepov);
        final EditText editTextVyhodnotenie = (EditText)findViewById(R.id.editTextVyhodnotenie);

        Button vyhodnotenie = (Button)findViewById(R.id.buttonVyhodnotenie);

        vyhodnotenie.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                int pocetKlukovHodnota;
                try{
                    pocetKlukovHodnota = Integer.valueOf(pocetKlukov.getText().toString());

                }catch(NumberFormatException e){
                    pocetKlukovHodnota = 0;
                }

                int statickyKlukHodnota;
                try{
                    statickyKlukHodnota = Integer.valueOf(statickyKluk.getText().toString());

                }catch(NumberFormatException e){
                    statickyKlukHodnota = 0;
                }

                int pocetDrepovHodnota;
                try{
                    pocetDrepovHodnota = Integer.valueOf(pocetDrepov.getText().toString());

                }catch(NumberFormatException e){
                    pocetDrepovHodnota = 0;
                }

                int sucet = pocetKlukovHodnota + statickyKlukHodnota + pocetDrepovHodnota;

                if(sucet <= 50)
                {
                    editTextVyhodnotenie.setText("Zaciatocnik");
                }
                else
                {
                    editTextVyhodnotenie.setText("Pokrocily");
                }

            }
        });









    }

}
