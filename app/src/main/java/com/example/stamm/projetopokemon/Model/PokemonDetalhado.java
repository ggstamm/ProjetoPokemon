package com.example.stamm.projetopokemon.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PokemonDetalhado {

    @SerializedName("name")
    private String name;

    @SerializedName("height")
    private String height;

    @SerializedName("weight")
    private String weight;

    @SerializedName("abilities")
    private ArrayList<Habilidades> abilities;

    @SerializedName("sprites")
    private Imagens sprites;

    public String getName() {
        return name;
    }

    public ArrayList<Habilidades> getAbilities() {
        return abilities;
    }

    public Imagens getSprites() {
        return sprites;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }
}
