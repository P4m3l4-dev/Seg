package br.com.pamela.moblie.seg.ui.credencial;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.pamela.moblie.seg.R;
import br.com.pamela.moblie.seg.model.Usuario;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CadCredencialFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CadCredencialFragment extends Fragment implements View.OnClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View view;
    //objetos de tela
    private EditText etNome;
    private EditText editTelefone;
    private EditText editEmail;
    private EditText editsenha;
    private Button botão;

    public CadCredencialFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CadCredencialFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CadCredencialFragment newInstance(String param1, String param2) {
        CadCredencialFragment fragment = new CadCredencialFragment();
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
        this.view =  inflater.inflate(R.layout.fragment_cad_credencial, container, false);
       //binding
        this.botão = view.findViewById(R.id.botao);
        this.editEmail=view.findViewById(R.id.editEmail);
        this.etNome=view.findViewById(R.id.etNome);
        this.editsenha=view.findViewById(R.id.editsenha);
        this.editTelefone=view.findViewById(R.id.editTelefone);
//listener do botao
        this.botão.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.botao) {
            //instanciar meu objeto de negocio
            try {
                Usuario usuario = new Usuario();
                //pegar dados da tela  e por na tela
                usuario.setNome(this.etNome.getText().toString());
                usuario.setEmail(this.editEmail.getText().toString());
                usuario.setSenha(this.editsenha.getText().toString());
                usuario.setTelefone(this.editTelefone.getText().toString());

                Context context = view.getContext();CharSequence text = "salvo com sucesso!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}