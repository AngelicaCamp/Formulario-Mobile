package com.example.formulario;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    private EditText edtNome;
    private EditText edtEmail;
    private EditText edtTelefone;

    private RadioGroup rdgSexo;
    private RadioButton rdbFeminino;
    private RadioButton rdbMasculino;

    private CheckBox chkMusica;
    private CheckBox chkCinema;
    private CheckBox chkEsporte;
    private CheckBox chkGastronomia;

    private Switch swtNot;

    private Button btnExibir;
    private Button btnLimpar;

    private LinearLayout lblDados;
    private TextView txtNome;
    private TextView txtSexo;
    private TextView txtEmail;
    private TextView txtTelefone;
    private TextView txtPreferencias;
    private TextView txtNot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNome = findViewById(R.id.edtNome);
        edtEmail = findViewById(R.id.edtEmail);
        edtTelefone = findViewById(R.id.edtTelefone);
        rdgSexo = findViewById(R.id.rdgSexo);
        rdbFeminino = findViewById(R.id.rdbFeminino);
        rdbMasculino = findViewById(R.id.rdbMasculino);
        chkMusica = findViewById(R.id.chkMusica);
        chkCinema = findViewById(R.id.chkCinema);
        chkEsporte = findViewById(R.id.chkEsporte);
        chkGastronomia = findViewById(R.id.chkGastronomia);

        swtNot = findViewById(R.id.swtNot);
        btnExibir = findViewById(R.id.btnExibir);
        btnLimpar = findViewById(R.id.btnLimpar);

        btnExibir.setOnClickListener(this);
        btnLimpar.setOnClickListener(this);

        lblDados = findViewById(R.id.lblDados);
        txtNome = findViewById(R.id.txtNome);
        txtEmail = findViewById(R.id.txtEmail);
        txtTelefone = findViewById(R.id.txtTelefone);
        txtSexo = findViewById(R.id.txtSexo);
        txtPreferencias = findViewById(R.id.txtPreferencias);
        txtNot = findViewById(R.id.txtNot);
    }

    public void onClick(View view){

        // Ao clicar no botão Exibir
        if(view.getId() == R.id.btnExibir){
            lblDados.setVisibility(View.VISIBLE);

            // Nome
            txtNome.setText("Nome:" + edtNome.getText().toString());

            // Sexo
            int selecionado = rdgSexo.getCheckedRadioButtonId();
            if(selecionado > 0){
                RadioButton rdbSelecionado = findViewById(selecionado);
                txtSexo.setText("Sexo:" + rdbSelecionado.getText().toString());
            }

            // Email
            txtEmail.setText("Email:" + edtEmail.getText().toString());

            // Telefone
            txtTelefone.setText("Telefone:" + edtTelefone.getText().toString());

            // Preferências
            String pref=" ";
            if(chkMusica.isChecked())
                pref = chkMusica.getText().toString();
            if(chkCinema.isChecked()){
                pref = pref + " ";        // pref += " "
                pref = pref + chkCinema.getText().toString();
            }
            if(chkEsporte.isChecked()){
                pref+= " ";
                pref += chkEsporte.getText().toString();
            }
            if(chkGastronomia.isChecked()){
                pref+= " ";
                pref+= chkGastronomia.getText().toString();
            }
            txtPreferencias.setText("Preferências: " + pref);

            // Notificação
            if(swtNot.isChecked())
                txtNot.setText("Notificação: " + swtNot.getTextOn());
            else
                txtNot.setText("Notificação: " +  swtNot.getTextOff());


        // Ao clicar no botão Limpar
        } else if(view.getId() == R.id.btnLimpar){

            edtNome.setText(" ");
            rdgSexo.clearCheck();
            edtEmail.setText(" ");
            edtTelefone.setText(" ");
            chkCinema.setChecked(false);
            chkMusica.setChecked(false);
            chkEsporte.setChecked(false);
            chkGastronomia.setChecked(false);
            swtNot.setChecked(false);
            lblDados.setVisibility(View.INVISIBLE);
        }
    }
}

