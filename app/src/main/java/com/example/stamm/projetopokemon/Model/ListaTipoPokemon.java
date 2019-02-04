package com.example.stamm.projetopokemon.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
public class ListaTipoPokemon{

    @SerializedName("results")
    private ArrayList<TipoPokemon> tiposPokemon = null;

    public ArrayList<TipoPokemon> getTiposPokemon(){
        return this.tiposPokemon;
    }

    public ArrayList<String> getNomesTiposPokemon(){
        ArrayList<String> nomesTiposPokemon = new ArrayList<>();
        for(TipoPokemon tipoPokemon : tiposPokemon){
            nomesTiposPokemon.add(tipoPokemon.getNome());
        }
        return nomesTiposPokemon;
    }
}
