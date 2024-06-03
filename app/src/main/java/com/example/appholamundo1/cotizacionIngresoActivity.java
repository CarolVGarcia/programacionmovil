package com.example.appholamundo1;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class cotizacionIngresoActivity extends AppCompatActivity {

    private EditText txtUsuario;
    private Button btnIngresar, btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cotizacion_ingreso);
        txtUsuario = (EditText) findViewById(R.id.txtUsuario);
        btnIngresar = (Button) findViewById(R.id.btnIngresar);
        btnRegresar = (Button) findViewById(R.id.btnRegresar);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtUsuario.getText().toString().matches("")){
                    Toast.makeText(cotizacionIngresoActivity.this, "Falto Capturar el usuario", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(getApplicationContext(), CotizacionActivity.class);
                    intent.putExtra("Cliente", txtUsuario.getText().toString());
                    startActivity(intent);
                }
            }

        });
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}