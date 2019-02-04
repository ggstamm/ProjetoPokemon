package com.example.stamm.projetopokemon.Model;


import com.google.gson.annotations.SerializedName;

public class Habilidades {

    @SerializedName("ability")
    private Habilidade ability;

    public Habilidade getAbility() {
        return ability;
    }
}
