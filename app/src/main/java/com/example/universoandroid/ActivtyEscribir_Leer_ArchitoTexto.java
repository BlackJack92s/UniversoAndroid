package com.example.universoandroid;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity; 
import android.widget.*;
import com.example.universoandroid.helpers.ArchivoHelper;

public class ActivtyEscribir_Leer_ArchitoTexto extends AppCompatActivity {
    Button btnRead, btnSave;
    EditText txtInput;
    TextView txtContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activty_escribir_leer_archito_texto);

        txtContent = findViewById(R.id.txtContent);
        txtInput = findViewById(R.id.txtInput);
        btnRead = findViewById(R.id.btnRead);
        btnSave = findViewById(R.id.btnSave);

        btnRead.setOnClickListener(v -> txtContent.setText(ArchivoHelper.ReadFile(ActivtyEscribir_Leer_ArchitoTexto.this)));

        btnSave.setOnClickListener(v -> {
            boolean success = ArchivoHelper.saveToFile(txtInput.getText().toString());
            Toast.makeText(ActivtyEscribir_Leer_ArchitoTexto.this, success ? "Guardado con éxito" : "Error al guardar", Toast.LENGTH_SHORT).show();
        });
    }
}