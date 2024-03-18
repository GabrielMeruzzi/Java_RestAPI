package org.example.services;

import java.util.List;

import org.example.models.Task;
import retrofit2.Call;
import retrofit2.http.*;

public interface TasksService {
    @GET("/todos")
    Call<List<Task>> listTasks();

    @GET("/todos/{identifier}")
    Call<Task> showTask(
            @Path("identifier") int identifier
    );

    @POST("/todos")
    Call<Task> addTask(@Body Task task);

    @PATCH("/todos/{taskId}")
    Call<Task> updateTask(@Path("taskId") int taskId, @Body Task task);

    @GET("/todos?completed=false")
    Call<List<Task>> nonCompletedTasks();
}
