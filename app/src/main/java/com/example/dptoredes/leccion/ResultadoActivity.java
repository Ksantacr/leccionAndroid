package com.example.dptoredes.leccion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);


        TextView u = (TextView) findViewById(R.id.txtUsuario);
        u.setText((String)getIntent().getExtras().get("usuario"));

        TextView puntaje = (TextView) findViewById(R.id.puntaje);
        puntaje.setText((String)getIntent().getExtras().get("aciertos") + "/2");

    }
}
