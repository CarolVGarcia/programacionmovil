package com.example.appholamundo1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class monedasActivity extends AppCompatActivity {

    private EditText txtCantidad;
    private TextView txtResultado;
    private Spinner spinner;
    private Button btnCalcular, btnLimpiar, btnCerrar;
    private int pos = 0;

    // Tasas de cambio actuales
    private double[] tasasDeCambio = {
            16.69, // MXN a USD[^1^][1]
            12.22, // MXN a CAD[^2^][6]
            18.11, // MXN a EUR[^3^][12]
            21.26  // MXN a GBP[^4^][18]
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_monedas);

        iniciarComponentes();

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtCantidad.getText().toString().matches("")) {
                    Toast.makeText(getApplicationContext(), "Falto capturar", Toast.LENGTH_SHORT).show();
                } else {
                    double cantidad = Double.parseDouble(txtCantidad.getText().toString());
                    double resultado = cantidad / tasasDeCambio[pos];
                    txtResultado.setText(String.format("Resultado: %.2f", resultado));
                }
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pos = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtCantidad.setText("");
                txtResultado.setText("Resultados: ");
                spinner.setSelection(0);
            }
        });

        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void iniciarComponentes() {
        txtCantidad = findViewById(R.id.txtCantidad);
        txtResultado = findViewById(R.id.txtResultado);
        spinner = findViewById(R.id.spnMoneda);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnCerrar = findViewById(R.id.btnCerrar);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.monedas));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}
