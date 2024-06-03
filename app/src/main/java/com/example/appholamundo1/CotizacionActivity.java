package com.example.appholamundo1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CotizacionActivity extends AppCompatActivity {

    private TextView lblNombre, lblFolio;
    private EditText txtDescripcion, txtValorAuto, txtPorcentaje;

    private RadioButton rdb12, rdb24, rdb36, rdb48;

    private Button btnCalcular, btnLimpiar, btnCerrar;

    private TextView lblPagoInicial, lblPagoMensual;
    private Cotizacion cot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cotizacion);
        iniciarComponentes();

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtDescripcion.getText().toString().matches("")||txtValorAuto.getText().toString().matches("")|| txtPorcentaje.getText().toString().matches("")){
                    Toast.makeText(CotizacionActivity.this,"Falto Capturar Informacion", Toast.LENGTH_SHORT).show();
                    return;
                }

                int plazo = 0;
                float enganche =0.0f;
                float pagoMensual = 0.0f;
                if(rdb12.isChecked())plazo=12;
                if(rdb24.isChecked())plazo=24;
                if(rdb36.isChecked())plazo=36;
                if(rdb48.isChecked())plazo=48;
                cot.setDescripcion(txtDescripcion.getText().toString());
                cot.setValorAuto(Float.parseFloat(txtValorAuto.getText().toString()));
                cot.setPorEnganche(Float.parseFloat(txtPorcentaje.getText().toString()));
                cot.setPlazos(plazo);

                enganche = cot.calcularPagoInicial();
                pagoMensual = cot.calcularPagoMensual();

                lblPagoInicial.setText(String.valueOf("Pago Inicial: $"+enganche));
                lblPagoMensual.setText(String.valueOf("Pago Mensual: $"+pagoMensual));
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblPagoInicial.setText("Pago Inicial: $");
                lblPagoMensual.setText("Pago Mensual: $");
                txtDescripcion.setText("");
                txtPorcentaje.setText("");
                txtValorAuto.setText("");
                rdb12.setChecked(true);
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

    public void iniciarComponentes(){
        lblNombre = (TextView) findViewById(R.id.txtUsuario);
        lblFolio = (TextView) findViewById(R.id.txtFolio);

        txtDescripcion = (EditText) findViewById(R.id.txtDescripcion);
        txtPorcentaje = (EditText) findViewById(R.id.txtPorPagoInicial);
        txtValorAuto = (EditText) findViewById(R.id.txtValor);

        rdb12 = (RadioButton) findViewById(R.id.rdb12);
        rdb24 = (RadioButton) findViewById(R.id.rdb24);
        rdb36 = (RadioButton) findViewById(R.id.rdb36);
        rdb48 = (RadioButton) findViewById(R.id.rdb48);

        btnCalcular = (Button) findViewById(R.id.BtnCalcular);
        btnLimpiar = (Button) findViewById(R.id.BtnLimpiar);
        btnCerrar = (Button) findViewById(R.id.BtnCerrar);

        lblPagoInicial = (TextView) findViewById(R.id.txtPagoInicial);
        lblPagoMensual = (TextView)  findViewById(R.id.txtPagoMensual);

        cot = new Cotizacion();

        //Mostrar id

        lblFolio.setText("Folio: "+String.valueOf(cot.generaId()));
        Bundle datos = getIntent().getExtras();
        String nombre = datos.getString("Cliente");
        lblNombre.setText("Usuario: "+ nombre);
        rdb12.setSelected(true);
    }
}