package com.example.stamm.projetopokemon.Model;

import com.google.gson.annotations.SerializedName;

public class Habilidade {

    @SerializedName("name")
    public String name;

    public String getName() {
        return name;
    }
}
