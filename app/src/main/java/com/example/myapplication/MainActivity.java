package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText txtN1;
    private EditText txtN2;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtN1 = findViewById(R.id.txtN1);
        txtN2 = findViewById(R.id.txtN2);
        textView = findViewById(R.id.tvResultado);
    }

    private boolean validarEntradas() {
        if (txtN1.getText().toString().isEmpty() || txtN2.getText().toString().isEmpty()) {
            Toast.makeText(this, "Por favor ingresa ambos números", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public void Sumar(View view) {
        if (!validarEntradas()) return;

        int valor1 = Integer.parseInt(txtN1.getText().toString());
        int valor2 = Integer.parseInt(txtN2.getText().toString());
        textView.setText("Suma: " + (valor1 + valor2));
    }

    public void Restar(View view) {
        if (!validarEntradas()) return;

        int valor1 = Integer.parseInt(txtN1.getText().toString());
        int valor2 = Integer.parseInt(txtN2.getText().toString());
        textView.setText("Resta: " + (valor1 - valor2));
    }

    public void Multiplicar(View view) {
        if (!validarEntradas()) return;

        int valor1 = Integer.parseInt(txtN1.getText().toString());
        int valor2 = Integer.parseInt(txtN2.getText().toString());
        textView.setText("Multiplicación: " + (valor1 * valor2));
    }

    public void Dividir(View view) {
        if (!validarEntradas()) return;

        int valor1 = Integer.parseInt(txtN1.getText().toString());
        int valor2 = Integer.parseInt(txtN2.getText().toString());

        if (valor2 != 0) {
            double resultado = (double) valor1 / valor2;
            textView.setText("División: " + resultado);
        } else {
            textView.setText("Error: División entre 0");
        }
    }
}
