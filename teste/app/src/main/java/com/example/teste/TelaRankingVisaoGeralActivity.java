package com.example.teste;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

import classesuteis.Equipe;

public class TelaRankingVisaoGeralActivity extends Activity {

    private TextView txtMoney,txtQntVotos,txtRanking,txtInvestidor,txtNome;

    private int idEquipe;

    private ArrayList equipeArray;

    private Equipe equipe;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_ranking_visao_geral);
        getWindow().setNavigationBarColor(ContextCompat.getColor(this,R.color.tranparente));

        txtNome = findViewById(R.id.nome_equipe_geral_id);
        txtMoney = findViewById(R.id.total_investido_id);
        txtQntVotos = findViewById(R.id.media_votos_geral_id);
        txtRanking = findViewById(R.id.posicao_ranking_id);
        txtInvestidor = findViewById(R.id.maior_investidor_id);


        equipeArray = TelaRankingGeralActivity.equipes;
        idEquipe = TelaRankingGeralActivity.positionEquipe;
        equipe = (Equipe) equipeArray.get(idEquipe);

        txtNome.setText(equipe.getNome());
        txtMoney.setText(String.valueOf(equipe.getValorInvestido()));
        txtQntVotos.setText(String.valueOf(equipe.getNumeroVoto()));
        txtRanking.setText("# "+ (idEquipe+1)+"º");
        txtInvestidor.setText(equipe.getRaInvestidor());
    }
}
