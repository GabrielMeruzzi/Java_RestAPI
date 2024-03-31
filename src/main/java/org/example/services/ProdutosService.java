package org.example.services;

import java.util.List;

import org.example.models.Produto;
import retrofit2.Call;
import retrofit2.http.*;

public interface ProdutosService {
    @GET("/produtos")
    Call<List<Produto>> listProdutos();

    @GET("/produtos/{id}")
    Call<Produto> showProduto(
            @Path("id") int identifier
    );

    @POST("/produtos")
    Call<Produto> addProduto(@Body Produto task);

    @PATCH("/produtos/{id}")
    Call<Produto> updateProduto(@Path("id") int produtoId, @Body Produto task);

    @DELETE("/produtos/{id}")
    Call<Void> deleteProduto(@Path("id") int produtoId);

}
