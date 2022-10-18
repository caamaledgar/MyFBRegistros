package com.example.myfbregistros;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myfbregistros.Models.Usuarios;
import com.example.myfbregistros.databinding.FragmentRegistrosBinding;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegistrosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegistrosFragment extends Fragment {
    FragmentRegistrosBinding binding;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Apps/ItChina/Usuarios");

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RegistrosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegistrosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegistrosFragment newInstance(String param1, String param2) {
        RegistrosFragment fragment = new RegistrosFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_registros, container, false);
        binding = FragmentRegistrosBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
         binding = null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertarRegistro();
            }
        });

    }
    public void insertarRegistro(){
        String nombre = binding.titNombre.getEditText().getText().toString();
        String correo = binding.titCorreo.getEditText().getText().toString();
        String urlImage = binding.titImagen.getEditText().getText().toString();
        String descripcion = binding.titDescripcion.getEditText().getText().toString();
        Usuarios usuario = new Usuarios(myRef.push().getKey(), nombre, correo, urlImage,descripcion);
        myRef.child(usuario.getId()).setValue(usuario);
        limpiarRegistro();
    }

    public void limpiarRegistro(){
        binding.titNombre.getEditText().setText("");
        binding.titCorreo.getEditText().setText("");
        binding.titImagen.getEditText().setText("");
        binding.titDescripcion.getEditText().setText("");
        binding.titNombre.requestFocus();

    }

}