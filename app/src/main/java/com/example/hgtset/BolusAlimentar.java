package com.example.hgtset;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BolusAlimentar extends AppCompatActivity  {
    private EditText txtCHO;
    private TextView ResultadoCHO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bolus_alimentar);
        txtCHO = findViewById(R.id.txtCHO);
        ResultadoCHO = findViewById(R.id.ResultadoCHO);
    }
    public void calcCHO(View view) {
        // verifica campos obrigatórios antes de realizar o calculo.
        if (txtCHO.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Informe Sua Glicemia!", Toast.LENGTH_SHORT).show();
            txtCHO.requestFocus();
        } else {
            //executa a conversão e calcula o resultado final
            double valor1 = Double.parseDouble(txtCHO.getText().toString());
            double resultadoCalculo = (valor1) * (0.0666666666666667) ;
            String ResultadoFinal = String.format("%.2f", resultadoCalculo);
            ResultadoCHO.setText(ResultadoFinal);
        }
    }
    public void CalculoHGT(View v){
        finish();
    }

    // Código botão Voltar
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //Manuseie o botão Voltar aqui
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }
}