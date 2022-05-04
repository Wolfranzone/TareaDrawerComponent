package com.example.tareadrawercomponent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DireccioneAppFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DireccioneAppFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DireccioneAppFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DireccioneAppFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DireccioneAppFragment newInstance(String param1, String param2) {
        DireccioneAppFragment fragment = new DireccioneAppFragment();
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
    //Declarar variables para el direccionamiento a otras aplicaciones
    ImageButton facebook,playStore, navegador, descargas, galeria;
    private final  static String Facebook_url="https://facebook.com/store/apps/details?id=my packagename ";
    private final  static String Play_url="https://play.google.com/store/apps/details?id=<play store>";
    private final  static String Navegador_url="https://www.google.com/";
    private final  static String Descargas_url="https://play.google.com/store/apps/details?id=my packagename ";
    private final  static String Galeria_url="https://play.google.com/store/apps/details?id=my packagename ";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_direccione_app, container, false);

        facebook = view.findViewById(R.id.btnFacebook);
        playStore = view.findViewById(R.id.btnPlayStore);
        navegador = view.findViewById(R.id.btnNavegador);
        descargas = view.findViewById(R.id.btnDescargas);
        galeria = view.findViewById(R.id.btnGaleria);

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(
                        "https://play.google.com/store/search?q=<Facebook>"));
                intent.setPackage("com.android.vending");
                startActivity(intent);
            }
        });

        playStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                switch (view.getId())
                {

                    case  R.id.btnPlayStore:
                        intent.setData(Uri.parse(Play_url));
                        startActivity(intent);
                        break;
                }
            }
        });

        navegador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                switch (view.getId())
                {

                    case  R.id.btnNavegador:
                        intent.setData(Uri.parse(Navegador_url));
                        startActivity(intent);
                        break;
                }
            }
        });

        descargas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                switch (view.getId())
                {

                    case  R.id.btnDescargas:
                        intent.setData(Uri.parse(Descargas_url));
                        startActivity(intent);
                        break;
                }
            }
        });

        galeria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                switch (view.getId())
                {

                    case  R.id.btnGaleria:
                        intent.setData(Uri.parse(Galeria_url));
                        startActivity(intent);
                        break;
                }
            }
        });

        return view;
    }
}