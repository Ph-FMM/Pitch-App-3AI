package com.example.teste;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Iterator;

import classesuteis.Equipe;

public class TelaAdicionarEquipeActivity extends Activity {
    private TextView nomeProjeto, nomeLider;
    private Button btnSubmeter;
    private long qEquipes=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_adicionar_equipe);
        getWindow().setNavigationBarColor(ContextCompat.getColor(this,R.color.tranparente));

        nomeProjeto=(TextView)findViewById(R.id.nome_projeto_id);
        nomeLider=(TextView)findViewById(R.id.nome_lider_id);
        btnSubmeter=(Button)findViewById(R.id.botao_submeter_equipe_id);

        btnSubmeter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Equipe equipe = new Equipe(nomeProjeto.getText().toString(),nomeLider.getText().toString(),0,0,"",0,0);

                final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
//                setqEquipes(databaseReference.child("Equipes"));
                databaseReference.child("Equipes").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        setqEquipes(dataSnapshot.getChildrenCount());
                        System.out.println(qEquipes+" 48");
                        System.out.println("entrou data change 49");
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        System.out.println("54");
                    }
                });
                System.out.println(getqEquipes()+" 57");
                databaseReference.child("Equipes").child("Equipe"+(getqEquipes()+1)).setValue(equipe);
                Toast.makeText(getApplicationContext(),"Equipe Registrada",Toast.LENGTH_LONG).show();

            }
        });


    }

    public void setqEquipes(long qEquipes){
        this.qEquipes = qEquipes;
        System.out.println(qEquipes+" Set 69");
    }

    public long getqEquipes(){
        System.out.println(this.qEquipes+" Get 73");
        return this.qEquipes;
    }
}
