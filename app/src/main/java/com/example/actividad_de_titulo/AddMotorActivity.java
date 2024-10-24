package com.example.actividad_de_titulo;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class AddMotorActivity extends AppCompatActivity {

    private TextInputEditText marcaEditText;
    private TextInputEditText potenciaEditText;
    private TextInputEditText vueltasEditText;
    private TextInputEditText hzEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_motor);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        marcaEditText = findViewById(R.id.marcaEditText);
        potenciaEditText = findViewById(R.id.potenciaEditText);
        vueltasEditText = findViewById(R.id.vueltasEditText);
        hzEditText = findViewById(R.id.hzEditText);

        MaterialButton saveButton = findViewById(R.id.button_save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
    }

    private void saveData() {
        String marca = marcaEditText.getText().toString();
        String potencia = potenciaEditText.getText().toString();
        String vueltas = vueltasEditText.getText().toString();
        String hz = hzEditText.getText().toString();

        // Aquí puedes agregar el código para guardar en la base de datos.

        Toast.makeText(this, "Datos guardados", Toast.LENGTH_SHORT).show();
        finish(); // Regresar a la actividad anterior
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}