package com.k2tic.courseracontactos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarDatosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        Bundle contactosPasados = getIntent().getExtras();

        String nombre = getIntent().getStringExtra("Nombre");
        String fecha = getIntent().getStringExtra("Fecha");
        String telefono = getIntent().getStringExtra("Telefono");
        String mail = getIntent().getStringExtra("Email");
        String descripcion = getIntent().getStringExtra("Descripcion");

        Button botonVolver = (Button) findViewById(R.id.btnEditar);


        final TextView cnombre = (TextView) findViewById(R.id.contactoNombre);
        final TextView cfecha = (TextView) findViewById(R.id.contactoFecha);
        final TextView ctelefono = (TextView) findViewById(R.id.contactoTelefono);
        final TextView cmail = (TextView) findViewById(R.id.contactoEmail);
        final TextView cdescripcion = (TextView) findViewById(R.id.contactoDescripcion);

        cnombre.setText(nombre);
        cfecha.setText(fecha);
        ctelefono.setText(telefono);
        cmail.setText(mail);
        cdescripcion.setText(descripcion);

        botonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volverMain = new Intent(ConfirmarDatosActivity.this, MainActivity.class);
                volverMain.putExtra("Nombre", cnombre.getText().toString());
                volverMain.putExtra("Fecha", cfecha.getText().toString());
                volverMain.putExtra("Telefono", ctelefono.getText().toString());
                volverMain.putExtra("Email", cmail.getText().toString());
                volverMain.putExtra("Descripcion", cdescripcion.getText().toString());


                startActivity(volverMain);
            }
        });

    }
}
