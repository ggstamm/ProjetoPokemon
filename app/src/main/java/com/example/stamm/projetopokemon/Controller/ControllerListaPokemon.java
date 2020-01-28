package com.example.stamm.projetopokemon.Controller;

import android.content.Context;

import com.example.stamm.projetopokemon.Model.OnPokeApiCompleted;
import com.example.stamm.projetopokemon.Model.PokeApi;

public class ControllerListaPokemon {

    public void retornarPokemons(Context context, String type, OnPokeApiCompleted onPokeApiCompleted){
        new PokeApi(context, onPokeApiCompleted).consultarPokemons(type);
    }

}
