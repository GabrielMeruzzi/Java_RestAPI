package org.example.models;

public class Produto {
    private int Id;
    private String Nome;
    private String Descricao;
    private double Preco;

    public Produto(int id, String nome, String descricao, double preco) {
        Id = id;
        Nome = nome;
        Descricao = descricao;
        Preco = preco;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public double getPreco() {
        return Preco;
    }

    public void setPreco(double preco) {
        Preco = preco;
    }

}
