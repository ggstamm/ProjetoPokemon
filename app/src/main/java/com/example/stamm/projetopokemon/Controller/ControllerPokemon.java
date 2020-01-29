package com.example.stamm.projetopokemon.Controller;

import android.content.Context;

import com.example.stamm.projetopokemon.Model.OnPokeApiCompleted;
import com.example.stamm.projetopokemon.Model.PokeApi;

public class ControllerPokemon {
    public void retornarDetalhesPokemon(Context context, String id, OnPokeApiCompleted onPokeApiCompleted){
        new PokeApi(context, onPokeApiCompleted).consultarPokemon(id);
    }
}
