package org.example;

import org.example.services.TasksService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TDSClient {
    private final Retrofit retrofit;
    private static TDSClient instance = null;

    private TDSClient() {
        String baseurl = "https://jsonplaceholder.typicode.com/";
        this.retrofit = new Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static TDSClient getInstance() {
        if (instance == null) {
            instance = new TDSClient();
        }
        return instance;
    }

    public static TasksService getTasksService() {
        return getInstance().retrofit.create(TasksService.class);
    }



}
