package org.example;

import org.example.services.ProdutosService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private final Retrofit retrofit;
    private static ApiClient instance = null;

    private ApiClient() {
        String baseurl = "http://localhost:8080/";
        this.retrofit = new Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiClient getInstance() {
        if (instance == null) {
            instance = new ApiClient();
        }
        return instance;
    }

    public static ProdutosService getProdutosService() {
        return getInstance().retrofit.create(ProdutosService.class);
    }



}
