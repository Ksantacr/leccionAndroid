package com.example.dptoredes.leccion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private Button btnJugar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnJugar =  (Button) findViewById(R.id.btnJugar);

        btnJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent juegoActivity = new Intent(v.getContext(), JuegoActivity.class);

                TextView usuario = (TextView) (findViewById(R.id.editTextUsuario));

                juegoActivity.putExtra("usuario", ""+usuario.getText());
                startActivity(juegoActivity);

            }
        });
    }
}
