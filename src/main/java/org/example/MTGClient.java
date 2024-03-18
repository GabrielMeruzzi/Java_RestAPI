package org.example;

import org.example.services.TasksService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MTGClient {
    private final Retrofit retrofit;
    private static MTGClient instance = null;

    private MTGClient() {
        String baseurl = "https://jsonplaceholder.typicode.com/";
        this.retrofit = new Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static MTGClient getInstance() {
        if (instance == null) {
            instance = new MTGClient();
        }
        return instance;
    }

    public static TasksService getTasksService() {
        return getInstance().retrofit.create(TasksService.class);
    }



}
