package com.example.stamm.projetopokemon.Model;

import com.google.gson.annotations.SerializedName;


public class Pokemons {

    @SerializedName("pokemon")
    private Pokemon pokemons;

    public Pokemon getPokemons() {
        return pokemons;
    }
}

