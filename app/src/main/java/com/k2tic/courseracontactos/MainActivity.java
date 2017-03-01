package com.k2tic.courseracontactos;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText textofecha, textoNombre, textoTeléfono, textoEmail, textoDescripcion;
    DatePicker datePicker;
    Button botonFecha;
    Button botonSiguiente;
    private int mYear;
    private int mMonth;
    private int mDay;
    Calendar calendar;
    static final int DATE_DIALOG_ID = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoNombre = (EditText) findViewById(R.id.txtNombreApellidos);
        textofecha = (EditText) findViewById(R.id.txtFecha);
        textoTeléfono = (EditText) findViewById(R.id.txtTelefono);
        textoEmail = (EditText) findViewById(R.id.txtEmail);
        textoDescripcion = (EditText) findViewById(R.id.txtDescripcion);

        botonFecha = (Button) findViewById(R.id.btnFecha);
        botonSiguiente = (Button) findViewById(R.id.btnsiguiente);

        botonFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DATE_DIALOG_ID);
            }
        });

        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        
        actualizarPantalla();


        botonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent siguiente = new Intent(MainActivity.this, ConfirmarDatosActivity.class);
                siguiente.putExtra("Nombre", textoNombre.getText().toString());
                siguiente.putExtra("Fecha", textofecha.getText().toString());
                siguiente.putExtra("Telefono", textoTeléfono.getText().toString());
                siguiente.putExtra("Email", textoEmail.getText().toString());
                siguiente.putExtra("Descripcion", textoDescripcion.getText().toString());
                startActivity(siguiente);

            }
        });

        Bundle contactosEditados = getIntent().getExtras();

        String nombre = getIntent().getStringExtra("Nombre");
        String fecha = getIntent().getStringExtra("Fecha");
        String telefono = getIntent().getStringExtra("Telefono");
        String mail = getIntent().getStringExtra("Email");
        String descripcion = getIntent().getStringExtra("Descripcion");

        textoNombre.setText(nombre);
        textofecha.setText(fecha);
        textoTeléfono.setText(telefono);
        textoEmail.setText(mail);
        textoDescripcion.setText(descripcion);

    }



    private void actualizarPantalla() {

        textofecha.setText(new StringBuilder()
                .append(mDay).append("/")
                .append(mMonth + 1).append("/")
                .append(mYear).append(" "));
    }


    private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

            mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;
            actualizarPantalla();

        }
    };

    @Override
    protected Dialog onCreateDialog(int id) {

        switch (id) {

            case DATE_DIALOG_ID:
                return new DatePickerDialog(this, mDateSetListener, mYear, mMonth, mDay);
        }


        return null;
    }
}
