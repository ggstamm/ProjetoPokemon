package com.example.stamm.projetopokemon.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.stamm.projetopokemon.Controller.ControllerListaTipoPokemon;
import com.example.stamm.projetopokemon.Model.ListaTipoPokemon;
import com.example.stamm.projetopokemon.Model.RecyclerViewAdapterTiposPokemon;
import com.example.stamm.projetopokemon.Model.TipoPokemon;
import com.example.stamm.projetopokemon.R;
import com.facebook.shimmer.ShimmerFrameLayout;

public class MenuPrincipal extends AppCompatActivity{

    private ShimmerFrameLayout mShimmerViewContainer;
    private RecyclerView mRecyclerView;
    private RecyclerViewAdapterTiposPokemon adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        mShimmerViewContainer = findViewById(R.id.shimmer_view_container);
        mRecyclerView = findViewById(R.id.recycler_view);
        mShimmerViewContainer.startShimmerAnimation();

        getTiposPokemon();
    }

    private void getTiposPokemon(){
        new ControllerListaTipoPokemon().retornarTiposPokemon(getApplicationContext(), results -> {
            ListaTipoPokemon listaTipoPokemon = (ListaTipoPokemon) results;
            mShimmerViewContainer.stopShimmerAnimation();
            mShimmerViewContainer.setVisibility(View.GONE);
            setmRecyclerView(listaTipoPokemon);
        });
    }

    public void setmRecyclerView(ListaTipoPokemon listaTipoPokemon){
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewAdapterTiposPokemon(this, listaTipoPokemon.getTiposPokemon());
        adapter.setClickListener((view, position) -> {
            TipoPokemon tipoPokemon = adapter.getItem(position);
            Intent intent = new Intent(MenuPrincipal.this, MenuSecundario.class);
            intent.putExtra("url", tipoPokemon.getUrl());
            intent.putExtra("nome", tipoPokemon.getNome());
            startActivity(intent);
        });
        mRecyclerView.setAdapter(adapter);
    }
}
