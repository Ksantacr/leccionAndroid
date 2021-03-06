package com.example.dptoredes.leccion;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class JuegoActivity extends AppCompatActivity {

    private ArrayList numerosGenerados;
    private Button btnGenerarNumero,btnUno, btnDos, btnTres, btnCuatro, btnCinco;
    private int numeroGenerado;
    private int turno;
    private int aciertos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        turno = 0;
        numeroGenerado = 0;
        numerosGenerados = new ArrayList<Integer>();
        TextView u = (TextView) findViewById(R.id.textViewUsuario);
        u.setText((String)getIntent().getExtras().get("usuario"));

        btnGenerarNumero = (Button) findViewById(R.id.btnGenerarNumero);
        btnUno = (Button) findViewById(R.id.btnUno);
        btnDos = (Button) findViewById(R.id.btnDos);
        btnTres = (Button) findViewById(R.id.btnTres);
        btnCuatro = (Button) findViewById(R.id.btnCuatro);
        btnCinco = (Button) findViewById(R.id.btnCinco);


        btnUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                esCorrecto(1);
            }
        });
        btnDos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                esCorrecto(2);
            }
        });
        btnTres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                esCorrecto(3);
            }
        });
        btnCuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                esCorrecto(4);
            }
        });
        btnCinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                esCorrecto(5);
            }
        });

        btnGenerarNumero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                numeroGenerado = generarNuevoNumero();

                Toast.makeText(JuegoActivity.this, "-> "+numeroGenerado +" <-", Toast.LENGTH_SHORT).show();

            }
        });

    }

    public int generarNuevoNumero(){


        Random generadorAleatorios = new Random();
        //int numero;
        //numero = (int) (Math.random() * 5) + 1;
        int numero = 1+generadorAleatorios.nextInt(5);
        if(numerosGenerados.contains(numero)){
            generarNuevoNumero();
        }

        numerosGenerados.add(numero);

        return numero;


    }
    public void esCorrecto(int numero){
        turno +=1;
        MediaPlayer mp = MediaPlayer.create(this, R.raw.sonido);
        mp.start();
        if(numero == numeroGenerado){
            Toast.makeText(JuegoActivity.this, ":)", Toast.LENGTH_LONG).show();
            aciertos+=1;
        }else{
            Toast.makeText(JuegoActivity.this, ":(", Toast.LENGTH_LONG).show();
        }


        if(turno==2){
            Intent resultadoActivity = new Intent(this, ResultadoActivity.class);
            resultadoActivity.putExtra("usuario",(String)getIntent().getExtras().get("usuario") );
            resultadoActivity.putExtra("aciertos", ""+aciertos);
            startActivity(resultadoActivity);
        }


    }

}
