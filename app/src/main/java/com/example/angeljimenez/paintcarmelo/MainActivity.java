package com.example.angeljimenez.paintcarmelo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner spSize, spfondo, spStyle, spColor;
    private String color;
    private int fondo, grosor = 5;
    private int defaultColor;
    private Lienzo lienzo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spSize = (Spinner) findViewById(R.id.spinnerSize);
        spfondo = (Spinner) findViewById(R.id.spinnerBackGround);
        spColor = (Spinner) findViewById(R.id.spinnerBrush);
        spStyle = (Spinner) findViewById(R.id.spinnerStyle);

        //posicion
        final DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);


        spColor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                color = String.valueOf(adapterView.getItemIdAtPosition(i));
                defaultColor = Color.BLACK;
                switch (color) {
                    case "Blanco":
                        fondo = Color.WHITE;
                        lienzo.init(metrics, grosor, defaultColor, fondo);
                        break;

                    case "Negro":
                        fondo = Color.BLACK;
                        lienzo.init(metrics, grosor, defaultColor, fondo);
                        break;

                    case "Rojo":
                        fondo = Color.RED;
                        lienzo.init(metrics, grosor, defaultColor, fondo);
                        break;

                    case "Morado":
                        fondo = Color.rgb(204, 0, 153);
                        lienzo.init(metrics, grosor, defaultColor, fondo);
                        break;

                    case "Azul":
                        fondo = Color.BLUE;
                        lienzo.init(metrics, grosor, defaultColor, fondo);
                        break;

                    case "Amarillo":
                        fondo = Color.YELLOW;
                        lienzo.init(metrics, grosor, defaultColor, fondo);
                        break;

                    case "Naranja":
                        fondo = Color.rgb(255, 102, 0);
                        lienzo.init(metrics, grosor, defaultColor, fondo);
                        break;

                    case "Marron":
                        fondo = Color.rgb(102, 51, 0);
                        lienzo.init(metrics, grosor, defaultColor, fondo);
                        break;

                }
            }
        });


        spStyle.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });


    }
}
