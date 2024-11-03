package com.example.actividad_de_titulo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class AddMotorActivity extends AppCompatActivity {

    private TextInputEditText editTextKW, editTextMarca, editTextTipo, editTextA220,
            editTextRPM, editTextNR, editTextPaso, editTextVBob,
            editTextDiametroAlambre, editTextConex, editTextD,
            editTextd, editTextL, editTextPR, editTextPCuK,
            editTextLBob, editTextMuF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_motor);

        // Inicializar los EditText
        editTextKW = findViewById(R.id.editTextKW);
        editTextMarca = findViewById(R.id.editTextMarca);
        editTextTipo = findViewById(R.id.editTextTipo);
        editTextA220 = findViewById(R.id.editTextA220);
        editTextRPM = findViewById(R.id.editTextRPM);
        editTextNR = findViewById(R.id.editTextNR);
        editTextPaso = findViewById(R.id.editTextPaso);
        editTextVBob = findViewById(R.id.editTextVBob);
        editTextDiametroAlambre = findViewById(R.id.editTextDiametroAlambre);
        editTextConex = findViewById(R.id.editTextConex);
        editTextD = findViewById(R.id.editTextD);
        editTextd = findViewById(R.id.editTextd);
        editTextL = findViewById(R.id.editTextL);
        editTextPR = findViewById(R.id.editTextPR);
        editTextPCuK = findViewById(R.id.editTextPCuK);
        editTextLBob = findViewById(R.id.editTextLBob);
        editTextMuF = findViewById(R.id.editTextMuF);

        Button buttonGuardar = findViewById(R.id.buttonGuardar);
        Button buttonBorrar = findViewById(R.id.buttonBorrar);
        Button buttonMenu = findViewById(R.id.buttonMenu);

        buttonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarDatos();
            }
        });

        buttonBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                borrarDatos();
            }
        });

        buttonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volverAlMenu();
            }
        });
    }

    private void guardarDatos() {
        // Aquí puedes implementar la lógica para guardar los datos
        Toast.makeText(this, "Datos guardados", Toast.LENGTH_SHORT).show();
    }

    private void borrarDatos() {
        // Limpiar todos los campos
        editTextKW.setText("");
        editTextMarca.setText("");
        editTextTipo.setText("");
        editTextA220.setText("");
        editTextRPM.setText("");
        editTextNR.setText("");
        editTextPaso.setText("");
        editTextVBob.setText("");
        editTextDiametroAlambre.setText("");
        editTextConex.setText("");
        editTextD.setText("");
        editTextd.setText("");
        editTextL.setText("");
        editTextPR.setText("");
        editTextPCuK.setText("");
        editTextLBob.setText("");
        editTextMuF.setText("");
        Toast.makeText(this, "Datos borrados", Toast.LENGTH_SHORT).show();
    }

    private void volverAlMenu() {
        // Aquí puedes implementar la lógica para volver al menú principal
        Toast.makeText(this, "Volver al menú", Toast.LENGTH_SHORT).show();
        // Puedes usar un Intent para iniciar otra actividad, si es necesario
    }
}
