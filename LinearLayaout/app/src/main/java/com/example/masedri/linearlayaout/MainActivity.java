package com.example.masedri.linearlayaout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView display;
    private Integer res= null;
    private Integer operando;
    private String operador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configurarBotonesOperacion();

        display = (TextView) findViewById(R.id.textView); // findViewId devuelve un view por eso casteamos a TextView

        Button[] numericButtons  = {
                (Button)findViewById(R.id.Btn0),
                (Button)findViewById(R.id.Btn1),
                (Button)findViewById(R.id.Btn2),
                (Button)findViewById(R.id.Btn3),
                (Button)findViewById(R.id.Btn4),
                (Button)findViewById(R.id.Btn5),
                (Button)findViewById(R.id.Btn6),
                (Button)findViewById(R.id.Btn7),
                (Button)findViewById(R.id.Btn8),
                (Button)findViewById(R.id.Btn9),
        };

        for(Button btn: numericButtons){
            btn.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    String value =  display.getText().toString() + ((Button) v).getText().toString();
                   // display.append(((Button)v).getText());
                    display.setText(value.replaceAll("^0",""));
                }
            });
        }




    }

    private void configurarBotonesOperacion() {
        Button[] operacionButtons  = {
                (Button)findViewById(R.id.btnDivision),
                (Button)findViewById(R.id.BtnMultiplicar),
                (Button)findViewById(R.id.BtnMenos),
                (Button)findViewById(R.id.BtnMas),
                (Button)findViewById(R.id.BtnIgual),
        };


        for(Button btn: operacionButtons) {
            btn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    switch (v.getId()){
                        case R.id.BtnMas:
                            operador="+";

                            break;
                        case R.id.BtnMenos:
                            operador=".";

                            break;
                        case R.id.BtnMultiplicar:
                            operador="*";

                            break;
                        case R.id.btnDivision:
                            operador="/";
                            break;
                    }
                    operando = Integer.parseInt( display.getText().toString());
                    if(res!=null) display.setText(res);

                }
            });
        }

    }
}
