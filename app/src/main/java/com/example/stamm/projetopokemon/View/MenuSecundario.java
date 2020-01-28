package com.example.stamm.projetopokemon.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.stamm.projetopokemon.Controller.ControllerListaPokemon;
import com.example.stamm.projetopokemon.Model.ListaPokemon;
import com.example.stamm.projetopokemon.Model.Pokemons;
import com.example.stamm.projetopokemon.Model.RecyclerViewAdapterPokemons;
import com.example.stamm.projetopokemon.R;
import com.facebook.shimmer.ShimmerFrameLayout;

public class MenuSecundario extends AppCompatActivity {
    private ShimmerFrameLayout mShimmerViewContainer;
    private RecyclerView mRecyclerView;
    private RecyclerViewAdapterPokemons adapter;
    private TextView mTextView;
    private TextView mTextViewError;
    private ImageView ivError;
    private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_secundario);

        mShimmerViewContainer = findViewById(R.id.shimmer_view_container);
        mRecyclerView = findViewById(R.id.recycler_view);
        mShimmerViewContainer.startShimmerAnimation();
        mTextView = findViewById(R.id.tituloPrincipal);
        mTextViewError = findViewById(R.id.textView3);
        ivError = findViewById(R.id.imageView2);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        type = intent.getStringExtra("nome");
        type = type.substring(0,1).toUpperCase() + type.substring(1);
        mTextView.setText(type);
        String valor = (url.substring(url.length()-3, url.length()-1)).replaceAll("\\D+", "");;
        getPokemons(valor);
    }

    private void getPokemons(String type){
        new ControllerListaPokemon().retornarPokemons(getApplicationContext(), type, results -> {
            ListaPokemon listaPokemon = (ListaPokemon) results;
            mShimmerViewContainer.stopShimmerAnimation();
            mShimmerViewContainer.setVisibility(View.GONE);
            if(listaPokemon.getPokemons().size()==0){
                ivError.setVisibility(View.VISIBLE);
                mTextViewError.setVisibility(View.VISIBLE);
            } else{
                setmRecyclerView(listaPokemon);
            }

        });
    }

    public void setmRecyclerView(ListaPokemon listaPokemon){

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewAdapterPokemons(this, listaPokemon.getPokemons(), type);
        adapter.setClickListener((view, position) -> {
            Pokemons pokemons = adapter.getItem(position);
            Intent intent = new Intent(MenuSecundario.this, DetalhesPokemon.class);
            intent.putExtra("url", pokemons.getPokemons().getUrl());
            intent.putExtra("nome", pokemons.getPokemons().getName());
            intent.putExtra("type", type);
            startActivity(intent);
        });
        mRecyclerView.setAdapter(adapter);
    }
}
