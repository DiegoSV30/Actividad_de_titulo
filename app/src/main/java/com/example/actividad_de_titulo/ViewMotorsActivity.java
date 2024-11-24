package com.example.actividad_de_titulo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class ViewMotorsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MotorAdapter motorAdapter;
    private EditText searchField;

    private FirebaseFirestore db;
    private List<Motor> motorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_motors);

        recyclerView = findViewById(R.id.recyclerViewMotors);
        searchField = findViewById(R.id.searchField);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        motorList = new ArrayList<>();
        motorAdapter = new MotorAdapter(motorList);
        recyclerView.setAdapter(motorAdapter);

        db = FirebaseFirestore.getInstance();

        // Cargar datos de Firestore
        loadMotorsFromFirestore();

        // Filtrar datos en tiempo real
        searchField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                filterMotorsByBrand(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
    }

    private void loadMotorsFromFirestore() {
        db.collection("motors")
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    motorList.clear();
                    for (QueryDocumentSnapshot document : queryDocumentSnapshots) {
                        Motor motor = document.toObject(Motor.class);
                        motorList.add(motor);
                    }
                    motorAdapter.notifyDataSetChanged();
                })
                .addOnFailureListener(e -> Toast.makeText(ViewMotorsActivity.this, "Error al cargar datos", Toast.LENGTH_SHORT).show());
    }

    private void filterMotorsByBrand(String brand) {
        List<Motor> filteredList = new ArrayList<>();
        for (Motor motor : motorList) {
            if (motor.getMarca().toLowerCase().contains(brand.toLowerCase())) {
                filteredList.add(motor);
            }
        }
        motorAdapter.updateList(filteredList);
    }
}
