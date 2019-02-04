package com.example.stamm.projetopokemon.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.stamm.projetopokemon.Controller.ControllerListaTipoPokemon;
import com.example.stamm.projetopokemon.Model.ListaTipoPokemon;
import com.example.stamm.projetopokemon.Model.OnPokeApiCompleted;
import com.example.stamm.projetopokemon.Model.RecyclerViewAdapter;
import com.example.stamm.projetopokemon.R;
import com.facebook.shimmer.ShimmerFrameLayout;

public class MenuPrincipal extends AppCompatActivity{

    private ShimmerFrameLayout mShimmerViewContainer;
    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter adapter;
    private ListaTipoPokemon listaTipoPokemon;

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
        new ControllerListaTipoPokemon().retornarTiposPokemon(getApplicationContext(), new OnPokeApiCompleted() {
            @Override
            public void tiposPokemonCompleted(ListaTipoPokemon results) {
                listaTipoPokemon = results;
                mShimmerViewContainer.stopShimmerAnimation();
                mShimmerViewContainer.setVisibility(View.GONE);
                setmRecyclerView();
            }
        });
    }

    public void setmRecyclerView(){
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewAdapter(this, listaTipoPokemon.getNomesTiposPokemon());
        mRecyclerView.setAdapter(adapter);

    }


}
