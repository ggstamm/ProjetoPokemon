package com.example.stamm.projetopokemon.Model;

import com.google.gson.annotations.SerializedName;

public class Pokemon{

    @SerializedName("name")
    private String name;

    @SerializedName("url")
    private String url;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
