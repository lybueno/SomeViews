package br.edu.ifsp.scl.ads.pmd.someviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // objetos de binding com as Views
    private EditText nomeEt;
    private EditText sobrenomeEt;
    private EditText emailEt;
    private Spinner estadoCivilSp;
    private LinearLayout conjugLl;
    private EditText nomeConjudeEt;
    private EditText sobrenomeConjugeEt;
    private RadioGroup sexoRg;
    private RadioButton masculinoRb;

    private String nomeCompleto;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Binding com as Views (ligação)
        bindViews();

        estadoCivilSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int posicao, long id) {
                TextView viewSelecionada = (TextView) view;
                if(viewSelecionada.getText().equals("Casado")) {
                    conjugLl.setVisibility(View.VISIBLE);
                } else {
                    conjugLl.setVisibility(View.GONE);
                    nomeConjudeEt.setText("");
                    sobrenomeConjugeEt.setText("");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        sobrenomeEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                nomeCompleto = nomeEt.getText().toString() + " " + charSequence;
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    private void bindViews() {
        nomeEt = findViewById(R.id.nomeEt);
        sobrenomeEt = findViewById(R.id.sobrenomeEt);
        emailEt = findViewById(R.id.emailEt);
        estadoCivilSp = findViewById(R.id.estadoCivilSp);
        conjugLl = findViewById(R.id.conjugeLl);
        nomeConjudeEt = findViewById(R.id.nomeConjugeEt);
        sobrenomeConjugeEt = findViewById(R.id.sobrenomeConjugeEt);
        sexoRg = findViewById(R.id.sexoRg);
        masculinoRb = findViewById(R.id.masculinoRb);
    }

    public void salvarDados(View view){
        Toast.makeText(this, "Clicou em salvar", Toast.LENGTH_SHORT).show();
    }

    public void limparDados(View view){
        Toast.makeText(this, "Clicou em limpar", Toast.LENGTH_SHORT).show();
        // implementar limpar campos e deixar no spinner e radio os valores padroes
        nomeEt.setText("");
        sobrenomeEt.setText("");
        emailEt.setText("");
        estadoCivilSp.setSelection(0);
        nomeConjudeEt.setText("");
        sobrenomeConjugeEt.setText("");
        conjugLl.setVisibility(View.GONE);
        sexoRg.check(R.id.masculinoRb);
    }
}