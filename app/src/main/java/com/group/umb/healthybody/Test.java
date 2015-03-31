package com.group.umb.healthybody;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.group.umb.healthybody.data.TestDataSource;

/**
 * Created by Legolas on 9. 3. 2015.
 */
public class Test extends ActionBarActivity {
    private TestDataSource datasource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        datasource = new TestDataSource(this);
        datasource.open();
        setContentView(R.layout.test);
        urcenieUrovne();
    }

    public void urcenieUrovne() {
        final EditText pocetKlukov = (EditText) findViewById(R.id.editTextPocetKlukov);
        final EditText statickyKluk = (EditText) findViewById(R.id.editTextStatickyKluk);
        final EditText pocetDrepov = (EditText) findViewById(R.id.editTextPocetDrepov);
        final EditText editTextVyhodnotenie = (EditText) findViewById(R.id.editTextVyhodnotenie);

        Button vyhodnotenie = (Button) findViewById(R.id.buttonVyhodnotenie);

        com.group.umb.healthybody.domain.Test test = datasource.getLatest();
        if (test != null) {
            statickyKluk.setText(test.getPocetBrusakov().toString());
            pocetDrepov.setText(test.getPocetDrepov().toString());
            pocetKlukov.setText(test.getPocetKlikov().toString());

            int sucet = test.getPocetBrusakov() + test.getPocetDrepov() + test.getPocetKlikov();

            if (sucet <= 50) {
                editTextVyhodnotenie.setText("Zaciatocnik");
            } else {
                editTextVyhodnotenie.setText("Pokrocily");
            }
        }

        vyhodnotenie.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                int pocetKlukovHodnota;
                try {
                    pocetKlukovHodnota = Integer.valueOf(pocetKlukov.getText().toString());

                } catch (NumberFormatException e) {
                    pocetKlukovHodnota = 0;
                }

                int statickyKlukHodnota;
                try {
                    statickyKlukHodnota = Integer.valueOf(statickyKluk.getText().toString());

                } catch (NumberFormatException e) {
                    statickyKlukHodnota = 0;
                }

                int pocetDrepovHodnota;
                try {
                    pocetDrepovHodnota = Integer.valueOf(pocetDrepov.getText().toString());

                } catch (NumberFormatException e) {
                    pocetDrepovHodnota = 0;
                }

                int sucet = pocetKlukovHodnota + statickyKlukHodnota + pocetDrepovHodnota;

                datasource.createTest(statickyKlukHodnota, pocetDrepovHodnota, pocetKlukovHodnota);

                if (sucet <= 50) {
                    editTextVyhodnotenie.setText("Zaciatocnik");
                } else {
                    editTextVyhodnotenie.setText("Pokrocily");
                }

            }
        });


    }

}
