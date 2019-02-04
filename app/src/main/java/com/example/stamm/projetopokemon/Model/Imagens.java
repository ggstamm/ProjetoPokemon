package com.example.stamm.projetopokemon.Model;

import com.google.gson.annotations.SerializedName;

public class Imagens {

    @SerializedName("front_default")
    private String imagemPadrao;

    public String getImagemPadrao() {
        return imagemPadrao;
    }
}
