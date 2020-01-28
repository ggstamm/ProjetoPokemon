package com.example.stamm.projetopokemon.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.stamm.projetopokemon.Controller.ControllerPokemon;
import com.example.stamm.projetopokemon.Model.Habilidades;
import com.example.stamm.projetopokemon.Model.PokemonDetalhado;
import com.example.stamm.projetopokemon.Model.RecyclerViewAdapterHabilidades;
import com.example.stamm.projetopokemon.R;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DetalhesPokemon extends AppCompatActivity {

    private ShimmerFrameLayout mShimmerViewContainer;
    private RecyclerView mRecyclerView;
    private RecyclerViewAdapterHabilidades adapter;
    private LinearLayout linear1;
    private LinearLayout linear2;
    private TextView mTextView;
    private TextView tvPeso;
    private TextView tvAltura;
    private ImageView ivFoto;
    private String type;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_pokemon);

        mShimmerViewContainer = findViewById(R.id.shimmer_view_container);
        mRecyclerView = findViewById(R.id.recyclerView2);
        mShimmerViewContainer.startShimmerAnimation();
        mTextView = findViewById(R.id.nomePokemon);
        tvAltura = findViewById(R.id.tvAltura);
        tvPeso = findViewById(R.id.tvPeso);
        ivFoto = findViewById(R.id.ivFoto);
        button = findViewById(R.id.button2);
        linear1 = findViewById(R.id.linearLayout);
        linear2 = findViewById(R.id.linearLayout2);

        setInvisible();

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        String nome = intent.getStringExtra("nome");
        type = intent.getStringExtra("type");
        nome = nome.substring(0,1).toUpperCase() + nome.substring(1);

        mTextView.setText(nome);
        String id = (url.substring(url.length()-5, url.length()-1)).replaceAll("\\D+", "");
        getDetalhes(id);
    }

    public void setVisible(){
        button.setVisibility(View.VISIBLE);
        ivFoto.setVisibility(View.VISIBLE);
        mRecyclerView.setVisibility(View.VISIBLE);
        linear1.setVisibility(View.VISIBLE);
        linear2.setVisibility(View.VISIBLE);
        mTextView.setVisibility(View.VISIBLE);
    }

    public void setInvisible(){
        button.setVisibility(View.GONE);
        ivFoto.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.GONE);
        linear1.setVisibility(View.GONE);
        linear2.setVisibility(View.GONE);
        mTextView.setVisibility(View.GONE);
    }

    public void getDetalhes(String id){
        new ControllerPokemon().retornarDetalhesPokemon(getApplicationContext(), id, results -> {
            PokemonDetalhado pokemon = (PokemonDetalhado) results;
            mShimmerViewContainer.stopShimmerAnimation();
            mShimmerViewContainer.setVisibility(View.GONE);
            setVisible();
            Picasso.get().load(pokemon.getSprites().getImagemPadrao()).into(ivFoto);
            Double peso = (Double.parseDouble(pokemon.getWeight()));
            Double altura = (Double.parseDouble(pokemon.getHeight()));
            tvAltura.setText((altura/10) + "m");
            tvPeso.setText((peso/10) + "kg");
            setmRecyclerView(pokemon.getAbilities());
            button.setOnClickListener(v -> {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                String habilidades = "";
                for(Habilidades habil : pokemon.getAbilities()){
                    habilidades += habil.getAbility().getName()+"; ";
                }
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Nome: " + pokemon.getName() + "\nAltura: " + pokemon.getHeight() +"\nPeso: " + pokemon.getWeight() + "\nHabilidades: " + habilidades);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            });
        });
    }

    public void setmRecyclerView(ArrayList<Habilidades> habilidades){
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewAdapterHabilidades(this, habilidades, type);
        mRecyclerView.setAdapter(adapter);
    }

}