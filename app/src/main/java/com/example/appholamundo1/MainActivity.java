package com.example.appholamundo1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView lblSaludo;
    private EditText txtSaludo;
    private Button btnSaludo, btnCerrar, btnLimpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblSaludo = findViewById(R.id.lblSaludo);
        txtSaludo = findViewById(R.id.txtNombre);
        btnCerrar =  (Button)findViewById(R.id.btnCerrar);
        btnLimpiar = (Button)findViewById(R.id.btnLimpiar);
        btnSaludo =  (Button)findViewById(R.id.btnPulsame);
        //boton limpiar
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSaludo.setText("");
                lblSaludo.setText("");
            }
        });

        //boton cerra
        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnSaludo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = txtSaludo.getText().toString();

                if (!nombre.isEmpty()) {
                    Toast.makeText(MainActivity.this, "¡Hola, que tal, " + nombre + "!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Por favor, ingresa tu nombre.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}