package com.example.tareadrawercomponent;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SitioWebFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SitioWebFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SitioWebFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SitioWebFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SitioWebFragment newInstance(String param1, String param2) {
        SitioWebFragment fragment = new SitioWebFragment();
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
    //Declarar variables para el Sitio Web
    EditText et1;
    Button btnWeb;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_sitio_web, container, false);

        et1 = view.findViewById(R.id.txt_Web);
        btnWeb = view.findViewById(R.id.btnWeb);

        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {


                //se establecen cambios de pantallas o Activitys
                Intent i = new Intent(getContext(), nav_Web.class);
                //Enviar parametros intent, metodo put extra
                i.putExtra("SitioWeb", et1.getText().toString());
                startActivity(i);
            }
        });

        return view;
    }
}