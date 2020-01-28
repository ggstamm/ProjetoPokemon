package com.example.stamm.projetopokemon.Model;


import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class PokeApi {

    private static final String BASE_URL = "https://t7m1oplj7c.execute-api.us-east-1.amazonaws.com/Alfa/";
    AsyncHttpClient asyncHttpClient;
    RequestParams requestParams;
    String jsonResponse;
    Context context;
    OnPokeApiCompleted pokeApiListener;

    public PokeApi(Context context, OnPokeApiCompleted listener){
        asyncHttpClient = new AsyncHttpClient();
        requestParams = new RequestParams();
        this.context = context;
        this.pokeApiListener = listener;
    }

    public void consultarTiposPokemon(){
        asyncHttpClient.get(BASE_URL+"type", requestParams, new JsonHttpResponseHandler(){
        @Override
        public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
            super.onSuccess(statusCode, headers, response);
            jsonResponse = response.toString();
            Gson gson = new Gson();
            ListaTipoPokemon listaTipoPokemon = gson.fromJson(response.toString(), ListaTipoPokemon.class);
            pokeApiListener.tiposPokemonCompleted(listaTipoPokemon);
            Log.i("RESPONSE", "onSuccess: " + jsonResponse);
        }

        @Override
        public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
            super.onFailure(statusCode, headers, throwable, errorResponse);
            Log.e("RESPONSE", "onFailure: " + errorResponse);
        }
    });
    }

    public void consultarPokemons(String type){
        asyncHttpClient.get(BASE_URL + "type/" + type, requestParams, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                jsonResponse = response.toString();
                Gson gson = new Gson();
                ListaPokemon listaPokemon = gson.fromJson(response.toString(), ListaPokemon.class);
                pokeApiListener.tiposPokemonCompleted(listaPokemon);
                Log.i("RESPONSE", "onSuccess: " + jsonResponse);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                Log.e("RESPONSE", "onFailure: " + errorResponse);
            }
        });
    }

    public void consultarPokemon(String id){
        asyncHttpClient.get(BASE_URL + "pokemon/" + id, requestParams, new JsonHttpResponseHandler(){
        @Override
        public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
            super.onSuccess(statusCode, headers, response);
            jsonResponse = response.toString();
            Gson gson = new Gson();
            PokemonDetalhado detalhesPokemon = gson.fromJson(response.toString(), PokemonDetalhado.class);
            pokeApiListener.tiposPokemonCompleted(detalhesPokemon);
            Log.i("RESPONSE", "onSuccess: " + jsonResponse);
        }

        @Override
        public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
            super.onFailure(statusCode, headers, throwable, errorResponse);
            Log.e("RESPONSE", "onFailure: " + errorResponse);
        }
    });
    }

}
