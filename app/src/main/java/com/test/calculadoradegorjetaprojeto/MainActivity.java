package com.test.calculadoradegorjetaprojeto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText cashValue;
    private TextView percentValue;
    private TextView totalValue;
    private TextView tipValue;
    private SeekBar seekBarTip;


    private int porcentagem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cashValue = findViewById(R.id.cashValue);
        percentValue = findViewById(R.id.percentValue);
        totalValue = findViewById(R.id.totalValue);
        tipValue = findViewById(R.id.tipValue);
        seekBarTip = findViewById(R.id.seekBarTip);

        //Adicionar Listener da SeekBar
        seekBarTip.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                porcentagem = progress;
                percentValue.setText(porcentagem + "%");
                calcular();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

        //Calculo de porcentagem

    public void calcular(){
        String valorRecuperado = cashValue.getText().toString();
        if (valorRecuperado == null || valorRecuperado.equals("")){
            Toast.makeText(getApplicationContext(), "Digite um valor", Toast.LENGTH_LONG).show();
        }else {

            // Converter String para Double

            double valorDigitado = Double.parseDouble(valorRecuperado);

            // Calcular gorjeta Total

            double gorjeta = valorDigitado * porcentagem/100;
            double total = valorDigitado + gorjeta;
            // exibe gorjeta total

            tipValue.setText(String.format("R$ %.2f", gorjeta));
            totalValue.setText(String.format("R$ %.2f", total));
        }

    }







}