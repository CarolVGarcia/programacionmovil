package com.example.appholamundo1;

import android.os.Bundle;
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

public class ImcActivity extends AppCompatActivity {

    private TextView lblResultado;
    private EditText txtAlto, txtPeso;
    private Button btnCalcular, btnCerrar, btnLimpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_imc);

        iniciarComponentes();
        configurarEventos();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void iniciarComponentes() {
        lblResultado = findViewById(R.id.lblResultado);
        txtAlto = findViewById(R.id.txtAlto);
        txtPeso = findViewById(R.id.txtPeso);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnCerrar = findViewById(R.id.btnCerrar);
        btnLimpiar = findViewById(R.id.btnLimpiar);
    }

    private void configurarEventos() {
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularIMC();
            }
        });

        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtAlto.setText("");
                txtPeso.setText("");
                lblResultado.setText("");
            }
        });
    }

    private void calcularIMC() {
        String sAlto = txtAlto.getText().toString();
        String sPeso = txtPeso.getText().toString();

        if (!sAlto.isEmpty() && !sPeso.isEmpty()) {
            float alto = Float.parseFloat(sAlto);
            float peso = Float.parseFloat(sPeso);

            if (alto > 0 && peso > 0) {
                float imc = peso / (alto * alto);
                lblResultado.setText("Tu IMC es: " + imc);
            } else {
                Toast.makeText(this, "El alto y el peso deben ser mayores que 0", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "Por favor, ingresa tu alto y tu peso", Toast.LENGTH_LONG).show();
        }
    }
}
