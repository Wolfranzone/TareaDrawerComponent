package com.example.tareadrawercomponent;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CalculadoraFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalculadoraFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CalculadoraFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CalculadoraFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CalculadoraFragment newInstance(String param1, String param2) {
        CalculadoraFragment fragment = new CalculadoraFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    // **************************************************
    //Declarar variables para la calculadora
    private View view;
    private EditText et1,et2;
    private TextView tv1;
    private Button btnSumar,btnRestar,btnMultiplicar,btnDividir,btnRaiz,btnSeno,btnCoseno,btnTangente,btnFactorial,btnPotencia,btnRnd,btnLimpiar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // --> borrar return inflater.inflate(R.layout.fragment_calculadora, container, false);
        View view = inflater.inflate(R.layout.fragment_calculadora, container, false);

        et1 = view.findViewById(R.id.txtNro1);
        et2 = view.findViewById(R.id.txtNro2);
        tv1 = view.findViewById(R.id.tvRespuesta);
        btnSumar = view.findViewById(R.id.suma);
        btnRestar = view.findViewById(R.id.resta);
        btnMultiplicar = view.findViewById(R.id.multiplicar);
        btnDividir = view.findViewById(R.id.dividir);
        btnRaiz = view.findViewById(R.id.raiz);
        btnSeno = view.findViewById(R.id.seno);
        btnCoseno = view.findViewById(R.id.coceno);
        btnTangente = view.findViewById(R.id.tangente);
        btnFactorial = view.findViewById(R.id.factorial);
        btnPotencia = view.findViewById(R.id.potencia);
        btnRnd = view.findViewById(R.id.rnd);
        btnLimpiar = view.findViewById(R.id.limpiar);


        btnSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String valor1 = et1.getText().toString();
                String valor2 = et2.getText().toString();

                double num1 = Double.parseDouble(valor1);
                double num2 = Double.parseDouble(valor2);

                double suma = num1 + num2;

                String result = String.valueOf(suma);
                tv1.setText(result);
            }
        });

        btnRestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String valor1 = et1.getText().toString();
                String valor2 = et2.getText().toString();

                double num1 = Double.parseDouble(valor1);
                double num2 = Double.parseDouble(valor2);

                double resta = num1 - num2;

                String result = String.valueOf(resta);
                tv1.setText(result);
            }
        });

        btnMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String valor1 = et1.getText().toString();
                String valor2 = et2.getText().toString();

                double num1 = Double.parseDouble(valor1);
                double num2 = Double.parseDouble(valor2);

                double mult = num1 * num2;

                String result = String.valueOf(mult);
                tv1.setText(result);

            }
        });

        btnDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String valor1 = et1.getText().toString();
                String valor2 = et2.getText().toString();

                double num1 = Double.parseDouble(valor1);
                double num2 = Double.parseDouble(valor2);

                if(num1 == 0)
                {
                    tv1.setText("ERROR");
                } else
                {
                    double div = num1 / num2;
                    String result = String.valueOf(div);
                    tv1.setText(result);
                }

            }
        });

        btnRaiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String valor1 = et1.getText().toString();
                String valor2 = et2.getText().toString();

                double num1 = Integer.parseInt(valor1);
                double num2 = Integer.parseInt(valor2);

                double raiz = Math.pow(num1,(1/num2));

                String result = String.valueOf(raiz);
                tv1.setText(result);
            }
        });

        btnSeno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String valor1 = et1.getText().toString();
                String valor2 = et2.getText().toString();

                double num1 = Integer.parseInt(valor1);

                double sen = Math.sin(num1);

                String result = String.valueOf(sen);
                tv1.setText(result);
            }
        });

        btnCoseno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String valor1 = et1.getText().toString();
                String valor2 = et2.getText().toString();

                double num1 = Integer.parseInt(valor1);

                double cos = Math.cos(num1);

                String result = String.valueOf(cos);
                tv1.setText(result);
            }
        });

        btnTangente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String valor1 = et1.getText().toString();
                String valor2 = et2.getText().toString();

                double num1 = Integer.parseInt(valor1);

                double tan = Math.tan(num1);

                String result = String.valueOf(tan);
                tv1.setText(result);
            }
        });

        btnFactorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String valor1 = et1.getText().toString();
                String valor2 = et2.getText().toString();

                double num1 = Integer.parseInt(valor1);
                int x;
                double fac = 1;

                for(x = 1; x <= num1; x++)
                {
                    fac = fac * x;

                    String result = String.valueOf(fac);
                    tv1.setText(result);
                }
            }
        });

        btnPotencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String valor1 = et1.getText().toString();
                String valor2 = et2.getText().toString();

                double num1 = Integer.parseInt(valor1);
                double num2 = Integer.parseInt(valor2);

                double exp = Math.pow(num1,num2);

                String result = String.valueOf(exp);
                tv1.setText(result);
            }
        });

        btnRnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String valor1 = et1.getText().toString();
                String valor2 = et2.getText().toString();

                double num1 = Integer.parseInt(valor1);
                double num2 = Integer.parseInt(valor2);

                double rnd =(double)Math.floor(Math.random()*(num2-num1)+num1);
                String result = String.valueOf(rnd);
                tv1.setText(result);
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                et1.setText("");
                et2.setText("");
                tv1.setText("Respuesta");
            }
        });

        return view;
    }
}