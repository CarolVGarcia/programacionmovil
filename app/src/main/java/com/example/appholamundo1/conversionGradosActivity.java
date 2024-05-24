package com.example.appholamundo1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class conversionGradosActivity extends AppCompatActivity {

    private EditText txtCantidad;
    private RadioGroup radioGroup;
    private RadioButton rdbCel, rdbFa;
    private TextView txtResultado;
    private Button btnCalcular, btnLimpiar, btnCerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion_grados);

        txtCantidad = findViewById(R.id.txtCantidad);
        rdbCel = findViewById(R.id.rdbCel);
        rdbFa = findViewById(R.id.rdbFa);
        txtResultado = findViewById(R.id.txtResultado);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnCerrar = findViewById(R.id.btnCerrar);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertirGrados();
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtCantidad.setText("");
                txtResultado.setText("");
                rdbCel.setChecked(true);
            }
        });

        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void convertirGrados() {
        String cantidadStr = txtCantidad.getText().toString();
        if (!cantidadStr.isEmpty()) {
            double cantidad = Double.parseDouble(cantidadStr);
            double resultado;
            if (rdbCel.isChecked()) {
                resultado = (cantidad * 9/5) + 32;
                txtResultado.setText("Resultado: " + resultado + " Fahrenheit");
            } else if (rdbFa.isChecked()) {
                resultado = (cantidad - 32) * 5/9;
                txtResultado.setText("Resultado: " + resultado + " Celsius");
            }
        } else {
            txtResultado.setText("Por favor, ingresa una cantidad de grados.");
        }
    }
}
