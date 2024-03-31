package controllers;

import com.google.gson.Gson;
import org.example.models.Produto;
import respositories.ProdutosRepository;
import spark.Request;
import spark.Response;

public class ProdutosController {

    ProdutosRepository produtosRepository = new ProdutosRepository();
    Gson gson = new Gson();

    public String getAll(Request req, Response res) {
       var produtos = produtosRepository.list();
        return response(gson.toJson(produtos), res);
    }

    public String read(Request req, Response res) {
        var id = Integer.parseInt(req.params("id"));
        Produto produto = produtosRepository.read(id);
        if (produto != null) {
            return response(gson.toJson(produto), res);
        } else {
            res.status(404);
            return "Produto não encontrado";
        }
    }

    public String insert(Request req, Response res) {
        var reqBody = req.body();
        var body = gson.fromJson(reqBody, Produto.class);
        Produto produto = produtosRepository.insert(body);
        return response(gson.toJson(produto), res);
    }

    public String update(Request req, Response res) {
        var id = Integer.parseInt(req.params("id"));

        var reqBody = req.body();
        var body = gson.fromJson(reqBody, Produto.class);
        Produto produto = produtosRepository.update(id, body);

        if(produto != null) {
            return response(gson.toJson(produto), res);
        } else
            res.status(404);
            return "Produto não encontrado";
    }

    public String upgrade(Request req, Response res) {
        var id = Integer.parseInt(req.params("id"));

        var reqBody = req.body();
        var body = gson.fromJson(reqBody, Produto.class);
        Produto produto = produtosRepository.upgrade(id, body);

        if(produto != null) {
            return response(gson.toJson(produto), res);
        } else
            res.status(404);
            return "Produto não encontrado";
    }

    public String delete(Request req, Response res) {
        var id = Integer.parseInt(req.params("id"));

        Produto produto = produtosRepository.delete(id);
        if(produto != null) {
            return response(gson.toJson(produto), res);
        } else {
            res.status(404);
            return "Produto não encontrado";
        }
    }

    private String response(String body, Response res) {
        res.type("application/json");
        return body;
    }
}
