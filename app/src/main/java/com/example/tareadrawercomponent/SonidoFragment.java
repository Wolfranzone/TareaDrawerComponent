package com.example.tareadrawercomponent;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SonidoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SonidoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SonidoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SonidoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SonidoFragment newInstance(String param1, String param2) {
        SonidoFragment fragment = new SonidoFragment();
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
    //Declarar variables para el reproductor de musica
    private View view;
    Button play_pause, btn_repetir;
    MediaPlayer mp;
    ImageView iv;
    int repetir = 2, posicion = 0;
    MediaPlayer vectormp [] = new MediaPlayer[5];

    Button btnPlayPause, btnStop, btnRepetir,btnSiguiente, btnAnterior;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_sonido, container, false);

        play_pause = view.findViewById(R.id.btnPlay);
        btn_repetir = view.findViewById(R.id.btnRepetir);
        iv = view.findViewById(R.id.imageView);

        vectormp[0] = MediaPlayer.create(getContext(),R.raw.music01);
        vectormp[1] = MediaPlayer.create(getContext(),R.raw.music02);
        vectormp[2] = MediaPlayer.create(getContext(),R.raw.music03);
        vectormp[3] = MediaPlayer.create(getContext(),R.raw.music04);
        vectormp[4] = MediaPlayer.create(getContext(),R.raw.music05);

        btnPlayPause = view.findViewById(R.id.btnPlay);
        btnStop = view.findViewById(R.id.btnStop);
        btnRepetir = view.findViewById(R.id.btnRepetir);
        btnSiguiente = view.findViewById(R.id.btnSiguiente);
        btnAnterior = view.findViewById(R.id.btnAnterior);

        btnPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(vectormp[posicion].isPlaying())
                {
                    vectormp[posicion].pause();
                    play_pause.setBackgroundResource(R.drawable.reproducir);
                    Toast.makeText(getContext(),"Pausa", Toast.LENGTH_SHORT).show();
                } else
                {
                    vectormp[posicion].start();
                    play_pause.setBackgroundResource(R.drawable.pausa);
                    Toast.makeText(getContext(),"Play", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(vectormp[posicion] != null)
                {
                    vectormp[posicion].stop();

                    vectormp[0] = MediaPlayer.create(getContext(),R.raw.music01);
                    vectormp[1] = MediaPlayer.create(getContext(),R.raw.music02);
                    vectormp[2] = MediaPlayer.create(getContext(),R.raw.music03);
                    vectormp[3] = MediaPlayer.create(getContext(),R.raw.music04);
                    vectormp[4] = MediaPlayer.create(getContext(),R.raw.music05);
                    posicion = 0;
                    play_pause.setBackgroundResource(R.drawable.reproducir);
                    iv.setImageResource(R.drawable.rock01);
                    Toast.makeText(getContext(), "Stop",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRepetir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if (repetir == 1)
                {
                    btn_repetir.setBackgroundResource(R.drawable.no_repetir);
                    Toast.makeText(getContext(), "no repetir", Toast.LENGTH_SHORT).show();
                    vectormp[posicion].setLooping(false);
                    repetir = 2;
                } else
                {
                    btn_repetir.setBackgroundResource(R.drawable.repetir);
                    Toast.makeText(getContext(), "Repetir", Toast.LENGTH_SHORT).show();
                    vectormp[posicion].setLooping(true);
                    repetir = 1;
                }
            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if (posicion < vectormp.length -1)
                {
                    if (vectormp[posicion].isPlaying())
                    {
                        vectormp[posicion].stop();
                        posicion++;
                        vectormp[posicion].start();

                        if (posicion == 0)
                        {
                            iv.setImageResource(R.drawable.rock01);
                        }
                        else if(posicion == 1)
                        {
                            iv.setImageResource(R.drawable.rock02);
                        }
                        else if (posicion == 2)
                        {
                            iv.setImageResource(R.drawable.rock03);
                        }
                        else if (posicion == 3)
                        {
                            iv.setImageResource(R.drawable.rock04);
                        }
                        else if (posicion == 4)
                        {
                            iv.setImageResource(R.drawable.rock05);
                        }

                    } else
                    {
                        posicion++;

                        if (posicion == 0)
                        {
                            iv.setImageResource(R.drawable.rock01);
                        }
                        else if(posicion == 1)
                        {
                            iv.setImageResource(R.drawable.rock02);
                        }
                        else if (posicion == 2)
                        {
                            iv.setImageResource(R.drawable.rock03);
                        }
                        else if (posicion == 3)
                        {
                            iv.setImageResource(R.drawable.rock04);
                        }
                        else if (posicion == 4)
                        {
                            iv.setImageResource(R.drawable.rock05);
                        }
                    }
                } else
                {
                    Toast.makeText(getContext(), "No hay más canciones",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if (posicion >=1 )
                {
                    if(vectormp[posicion].isPlaying())
                    {
                        vectormp[posicion].stop();
                        vectormp[0] = MediaPlayer.create(getContext(),R.raw.music01);
                        vectormp[1] = MediaPlayer.create(getContext(),R.raw.music02);
                        vectormp[2] = MediaPlayer.create(getContext(),R.raw.music03);
                        vectormp[3] = MediaPlayer.create(getContext(),R.raw.music04);
                        vectormp[4] = MediaPlayer.create(getContext(),R.raw.music05);
                        posicion--;

                        if (posicion == 0)
                        {
                            iv.setImageResource(R.drawable.rock01);
                        }
                        else if(posicion == 1)
                        {
                            iv.setImageResource(R.drawable.rock02);
                        }
                        else if (posicion == 2)
                        {
                            iv.setImageResource(R.drawable.rock03);
                        }
                        else if (posicion == 3)
                        {
                            iv.setImageResource(R.drawable.rock04);
                        }
                        else if (posicion == 4)
                        {
                            iv.setImageResource(R.drawable.rock05);
                        }

                        vectormp[posicion].start();

                    }else
                    {
                        posicion--;

                        if (posicion == 0)
                        {
                            iv.setImageResource(R.drawable.rock01);
                        }
                        else if(posicion == 1)
                        {
                            iv.setImageResource(R.drawable.rock02);
                        }
                        else if (posicion == 2)
                        {
                            iv.setImageResource(R.drawable.rock03);
                        }
                        else if (posicion == 3)
                        {
                            iv.setImageResource(R.drawable.rock04);
                        }
                        else if (posicion == 4)
                        {
                            iv.setImageResource(R.drawable.rock05);
                        }
                    }

                } else
                {
                    Toast.makeText(getContext(), "No hay más canciones",Toast.LENGTH_SHORT).show();
                }
            }
        });


        return view;
    }
}