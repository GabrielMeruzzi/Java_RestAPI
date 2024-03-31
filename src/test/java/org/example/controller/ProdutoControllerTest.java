package org.example.controller;

import org.example.ApiClient;
import org.example.models.Produto;
import org.example.services.ProdutosService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Teste ProdutoController")
public class ProdutoControllerTest {

    @Test @DisplayName("Teste retornar lista de tarefas")
    public void TestRetornarListaTarefas() {
        ProdutosService produtoService = ApiClient.getProdutosService();
        ProdutoController produtoController = new ProdutoController(produtoService);

        List<Produto> produtos = produtoController.listProdutos();

        Assertions.assertNotNull(produtos);
        Assertions.assertFalse(produtos.isEmpty());
    }

    @Test @DisplayName("Teste retornar UMA lista tarefa")
    public void TestRetornarTarefa() {
        ProdutosService produtoService = ApiClient.getProdutosService();
        ProdutoController produtoController = new ProdutoController(produtoService);

        Produto produto = produtoController.showProduto(1);

        Assertions.assertNotNull(produto);
    }

    @Test @DisplayName("Teste adicionar uma lista tarefa")
    public void TestAdicionarTarefa() {
        ProdutosService produtoService = ApiClient.getProdutosService();
        ProdutoController produtoController = new ProdutoController(produtoService);

        Produto produto1 = new Produto("TestandoAdicionarTarefa", "Teste", 99.99);

        produtoController.addProduto(produto1);

        List<Produto> produtos = produtoController.listProdutos();

        Produto lastProduto = produtoController.showProduto(produtos.size());

        Assertions.assertEquals(produto1.getNome(), lastProduto.getNome());
        Assertions.assertEquals(produto1.getDescricao(), lastProduto.getDescricao());
        Assertions.assertEquals(produto1.getPreco(), lastProduto.getPreco());
    }
  @Test @DisplayName("Teste atualizar uma lista tarefa")
    public void TestAtualizarTarefa() throws IOException {
        ProdutosService produtoService = ApiClient.getProdutosService();
        ProdutoController produtoController = new ProdutoController(produtoService);

        Produto produto1 = new Produto("TestAtualizarTarefa", "TestAtualizarTarefa", 99.9999);
        int id = 4;

        produtoController.updateProduto(id, produto1);

        Produto updatedProduto = produtoController.showProduto(id);


        Assertions.assertEquals(produto1.getNome(), updatedProduto.getNome());
        Assertions.assertEquals(produto1.getDescricao(), updatedProduto.getDescricao());
        Assertions.assertEquals(produto1.getPreco(), updatedProduto.getPreco());
    }

    @Test @DisplayName("Teste deleter uma lista tarefa")
    public void TestDeleterTarefa() {
        ProdutosService produtoService = ApiClient.getProdutosService();
        ProdutoController produtoController = new ProdutoController(produtoService);

        int id = 4;

        produtoController.deleteProduto(id);
        List<Produto> produtos = produtoController.listProdutos();

        boolean produtoExiste = false;

        for (Produto produto : produtos) {
            if(produto.getId() == id) {
                produtoExiste = true;
            }
        }

        assertFalse(produtoExiste);
    }



}
