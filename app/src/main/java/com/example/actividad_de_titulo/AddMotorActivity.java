package com.example.actividad_de_titulo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.Map;

public class AddMotorActivity extends AppCompatActivity {

    // Definición de los campos EditText (y TextInputEditText en tu XML)
    EditText editTextKW, editTextMarca, editTextTipo, editTextA220, editTextRPM,
            editTextNR, editTextPaso, editTextVBob, editTextDiametroAlambre,
            editTextConex, editTextD, editTextd, editTextL, editTextPR,
            editTextPCuK, editTextLBob, editTextMuF;

    Button buttonGuardar, buttonBorrar, buttonMenu;
    private FirebaseFirestore mFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_motor);

        // Inicializar Firestore
        mFirestore = FirebaseFirestore.getInstance();

        // Referenciar los campos del layout XML
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

        buttonGuardar = findViewById(R.id.buttonGuardar);
        buttonBorrar = findViewById(R.id.buttonBorrar);
        buttonMenu = findViewById(R.id.buttonMenu);

        // Botón para guardar los datos del motor
        buttonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveMotorData(); // Llamamos a la función que guarda los datos
            }
        });

        // Botón para borrar los campos
        buttonBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFields(); // Llamamos a la función que borra todos los campos
            }
        });

        // Botón para volver al menú principal (aquí deberías definir lo que ocurre)
        buttonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aquí puedes definir lo que hace al presionar este botón (por ejemplo, regresar a la actividad principal)
                finish();
            }
        });
    }

    // Función para guardar los datos en Firestore
    private void saveMotorData() {
        // Recoger los valores de cada campo
        String kw = editTextKW.getText().toString().trim();
        String marca = editTextMarca.getText().toString().trim();
        String tipo = editTextTipo.getText().toString().trim();
        String a220 = editTextA220.getText().toString().trim();
        String rpm = editTextRPM.getText().toString().trim();
        String nr = editTextNR.getText().toString().trim();
        String paso = editTextPaso.getText().toString().trim();
        String vBob = editTextVBob.getText().toString().trim();
        String diametroAlambre = editTextDiametroAlambre.getText().toString().trim();
        String conex = editTextConex.getText().toString().trim();
        String d = editTextD.getText().toString().trim();
        String d2 = editTextd.getText().toString().trim();
        String l = editTextL.getText().toString().trim();
        String pr = editTextPR.getText().toString().trim();
        String pCuK = editTextPCuK.getText().toString().trim();
        String lBob = editTextLBob.getText().toString().trim();
        String muF = editTextMuF.getText().toString().trim();

        // Verificar que todos los campos tienen datos
        if (kw.isEmpty() || marca.isEmpty() || tipo.isEmpty() || a220.isEmpty() || rpm.isEmpty() || nr.isEmpty() || paso.isEmpty()) {
            Toast.makeText(this, "Por favor, complete todos los campos obligatorios", Toast.LENGTH_SHORT).show();
            return; // Si algún campo está vacío, no guardamos los datos
        }

        // Crear un mapa con los datos del motor
        Map<String, Object> motorData = new HashMap<>();
        motorData.put("kw", kw);
        motorData.put("marca", marca);
        motorData.put("tipo", tipo);
        motorData.put("a220", a220);
        motorData.put("rpm", rpm);
        motorData.put("nr", nr);
        motorData.put("paso", paso);
        motorData.put("vBob", vBob);
        motorData.put("diametroAlambre", diametroAlambre);
        motorData.put("conex", conex);
        motorData.put("d", d);
        motorData.put("d2", d2);
        motorData.put("l", l);
        motorData.put("pr", pr);
        motorData.put("pCuK", pCuK);
        motorData.put("lBob", lBob);
        motorData.put("muF", muF);

        // Crear el documento en Firestore
        DocumentReference motorRef = mFirestore.collection("motors").document(); // Genera un nuevo documento
        motorRef.set(motorData)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(AddMotorActivity.this, "Motor guardado exitosamente", Toast.LENGTH_SHORT).show();
                        clearFields(); // Borrar los campos después de guardar
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AddMotorActivity.this, "Error al guardar los datos", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    // Función para borrar los campos
    private void clearFields() {
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
    }
}
