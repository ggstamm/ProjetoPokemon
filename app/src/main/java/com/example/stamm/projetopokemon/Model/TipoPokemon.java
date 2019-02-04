package com.example.stamm.projetopokemon.Model;


import com.google.gson.annotations.SerializedName;

public class TipoPokemon {

    @SerializedName("name")
    private String name;

    @SerializedName("url")
    private String url;

    public String getNome(){
        return this.name;
    }

    public String getUrl(){
        return this.url;
    }
}
