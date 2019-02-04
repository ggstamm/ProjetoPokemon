package com.example.stamm.projetopokemon.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
public class ListaTipoPokemon{

    @SerializedName("results")
    private ArrayList<TipoPokemon> tiposPokemon = null;

    public ArrayList<TipoPokemon> getTiposPokemon(){
        return this.tiposPokemon;
    }
}
