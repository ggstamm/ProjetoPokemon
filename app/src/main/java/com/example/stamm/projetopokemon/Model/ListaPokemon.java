package com.example.stamm.projetopokemon.Model;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ListaPokemon {

    @SerializedName("pokemon")
    private ArrayList<Pokemons> pokemons;

    public ArrayList<Pokemons> getPokemons(){ return this.pokemons; }
}
