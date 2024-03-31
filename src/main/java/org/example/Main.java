package org.example;

import org.example.controller.ProdutoController;
import org.example.services.ProdutosService;

public class Main {
    public static void main(String[] args) {
        ProdutosService produtoService = ApiClient.getProdutosService();
        ProdutoController produtoController = new ProdutoController(produtoService);

        produtoController.deleteProduto(4);
        produtoController.listProdutos();
    }
}