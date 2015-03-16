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
        final Editable [] hodnota = new Editable[3];

        final EditText pocetKlukov = (EditText)findViewById(R.id.editTextPocetKlukov);
        final EditText statickyKluk = (EditText)findViewById(R.id.editTextStatickyKluk);
        final EditText pocetDrepov = (EditText)findViewById(R.id.editTextPocetDrepov);
        final EditText hodnotenieKluky = (EditText)findViewById(R.id.editTextHodnotenieKluky);
        final EditText hodnotenieStatickyKluk = (EditText)findViewById(R.id.editTextHodnotenieStatickyKluk);
        final EditText hodnotenieDrepy = (EditText)findViewById(R.id.editTextHodnotenieDrepy);

        Button vyhodnotenie = (Button)findViewById(R.id.buttonVyhodnotenie);

        hodnota[0] = pocetKlukov.getText();
        hodnota[1] = statickyKluk.getText();
        hodnota[2] = pocetDrepov.getText();


        vyhodnotenie.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                hodnotenieKluky.setText(hodnota[0]);
                hodnotenieStatickyKluk.setText(hodnota[1]);
                hodnotenieDrepy.setText(hodnota[2]);
            }
        });







    }

}
