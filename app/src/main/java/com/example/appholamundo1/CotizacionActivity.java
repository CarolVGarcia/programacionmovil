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
    private EditText txtDescripcion, txtValorAuto, txtPorPagoInicial;
    private RadioButton rdb12, rdb24, rdb36, rdb48;
    private Button btnCalcular, btnLimpiar, btnRegresar;
    private TextView lblPagoMensual, lblPagoInicial;
    private cotizacion cot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cotizacion);

        iniciarComponentes();
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //VALIDAR

                if(txtDescripcion.getText().toString().matches("") || txtValorAuto.getText().toString().matches("") || txtPorPagoInicial.getText().toString().matches("")){
                    Toast.makeText(CotizacionActivity.this, "Falto capturar informacion", Toast.LENGTH_SHORT).show();

                }
                else{

                    //ASIGNAR LOS DATOS AL OBJETO DE COTIZACION

                    int plazo=0;
                    float enganche=0.0f;
                    float pagoMensual = 0.0f;

                    if (rdb12.isChecked())plazo=12;
                    if (rdb24.isChecked())plazo=24;
                    if (rdb36.isChecked())plazo=36;
                    if (rdb48.isChecked())plazo=48;

                    cot.setDescripcion(txtDescripcion.getText().toString());
                    cot.setValorAuto(Float.parseFloat(txtValorAuto.getText().toString()));
                    cot.setPorEnganche(Float.parseFloat(txtPorPagoInicial.getText().toString()));
                    cot.setPlazos(plazo);

                    //OBTENER LOS CALCULOS

                    enganche = cot.calcularPagoInicial();
                    pagoMensual = cot.calcularPagoMensual();

                    lblPagoInicial.setText(String.valueOf("Pago inicial: $ " + enganche));
                    lblPagoMensual.setText(String.valueOf("Pago Mensual: $" + pagoMensual));




                }

            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtDescripcion.setText(" ");
                txtValorAuto.setText(" ");
                txtPorPagoInicial.setText("");
                lblPagoMensual.setText("Pago inicial: $");
                lblPagoInicial.setText("Pago Mensual: $");
                rdb12.setSelected(true);

            }
        });

        Bundle datos = getIntent().getExtras();
        if(datos != null){
            String nombre = datos.getString("cliente");
            lblNombre.setText(nombre);
        }


        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    public void iniciarComponentes(){
        lblNombre = (TextView) findViewById(R.id.txtUsuario);
        lblFolio = (TextView)  findViewById(R.id.txtFolio);

        txtDescripcion = (EditText) findViewById(R.id.txtDescribir);
        txtValorAuto = (EditText) findViewById(R.id.txtValor);
        txtPorPagoInicial = (EditText) findViewById(R.id.txtPorPagoInicial);

        rdb12 = (RadioButton) findViewById(R.id.rdb12);
        rdb24 = (RadioButton) findViewById(R.id.rdb24);
        rdb36 = (RadioButton) findViewById(R.id.rdb36);
        rdb48 = (RadioButton) findViewById(R.id.rdb48);

        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
        btnRegresar = (Button) findViewById(R.id.btnRegresar);

        lblPagoMensual = (TextView) findViewById(R.id.txtPagoMensual);
        lblPagoInicial = (TextView) findViewById(R.id.txtPagoInicial);

        cot = new cotizacion();

        //MOSTRAR EL ID
        lblFolio.setText("Folio: " + String.valueOf(cot.generaId()));

        Bundle datos = getIntent().getExtras();
        String nombre = datos.getString("Cliente");
        lblNombre.setText(nombre);

        rdb12.setSelected(true);

    }
}