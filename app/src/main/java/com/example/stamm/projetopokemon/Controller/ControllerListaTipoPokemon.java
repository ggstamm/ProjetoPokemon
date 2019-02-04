package com.example.stamm.projetopokemon.Controller;

import android.content.Context;

import com.example.stamm.projetopokemon.Model.OnPokeApiCompleted;
import com.example.stamm.projetopokemon.Model.PokeApi;

public class ControllerListaTipoPokemon {

    public void retornarTiposPokemon(Context context, OnPokeApiCompleted onPokeApiCompleted){
        new PokeApi(context, onPokeApiCompleted).consultarTiposPokemon();
    }
}
