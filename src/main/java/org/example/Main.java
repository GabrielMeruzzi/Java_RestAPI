package org.example;

import controllers.ProdutosController;

import static spark.Spark.*;

public class Main {
    private static int port = 8080;
    private static final ProdutosController produtosController
            = new ProdutosController();

    public static void main(String[] args) {
        port(Main.port);

        path("/produtos", () -> {
            get("", produtosController::getAll);
            get("/:id", produtosController::read);
            post("", produtosController::insert);
            put("/:id", produtosController::update);
            patch("/:id", produtosController::upgrade);
            delete("/:id", produtosController::delete);
        });
    }
}