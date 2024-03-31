package org.example.controller;

import org.example.models.Produto;
import org.example.services.ProdutosService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

import static org.example.ApiClient.getProdutosService;

public class ProdutoController {
    private final ProdutosService produtosService;
    public ProdutoController(ProdutosService produtoService) {
        this.produtosService = produtoService;
    }

    public static List<Produto> listProdutos() {
        try {
            Call<List<Produto>> call = getProdutosService().listProdutos();
            Response<List<Produto>> resp = call.execute();
            List<Produto> produtos = resp.body();
            if (produtos != null) {
                for (Produto produto : produtos) {
                    System.out.println("Id: " + produto.getId());
                    System.out.println("Nome do produto: " + produto.getNome());
                    System.out.println("Descrição: " + produto.getDescricao());
                    System.out.println("Preço: " + produto.getPreco());
                    System.out.println("");
                }
                return produtos;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static Produto showProduto(int produtoId) {
        try {
            Call<Produto> call = getProdutosService().showProduto(produtoId);
            Response<Produto> resp = call.execute();
            Produto produto = resp.body();
            System.out.println("Id: " + produto.getId());
            System.out.println("Nome do produto: " + produto.getNome());
            System.out.println("Descrição: " + produto.getDescricao());
            System.out.println("Preço: " + produto.getPreco());
            return produto;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addProduto(Produto produto) {
        Produto newProduto = produto;

        Call<Produto> call = getProdutosService().addProduto(newProduto);

        try {
            Response<Produto> response = call.execute();

            if (response.isSuccessful()) {
                Produto createdProduto = response.body();
                System.out.println("Produto adicionado.");
                System.out.println("");
                System.out.println("Id: " + createdProduto.getId());
                System.out.println("Nome do produto: " + createdProduto.getNome());
                System.out.println("Descrição: " + createdProduto.getDescricao());
                System.out.println("Preço: " + createdProduto.getPreco());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Produto updateProduto(int id, Produto produto) throws IOException {
        Produto newProduto = produto;
        Call<Produto> call = getProdutosService().updateProduto(id, newProduto);
        Response<Produto> resp = call.execute();
        Produto produto1 = resp.body();
        return produto1;
    }

    public static void deleteProduto(int id) {
        Call<Void> call = getProdutosService().deleteProduto(id);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    System.out.println("Produto excluído.");
                } else {
                    System.err.println("Erro: " + response.message());
                }
            }
            @Override
            public void onFailure(Call<Void> call, Throwable t) {
            }
        });
    }
}
