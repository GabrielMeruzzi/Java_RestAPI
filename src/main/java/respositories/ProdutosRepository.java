package respositories;

import org.example.models.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutosRepository {

    int listSize = 15;

    private List<Produto> produtos = new ArrayList<>();

    public ProdutosRepository() {
        produtos.add(new Produto(1, "Camisa", "Camisa de algodão", 29.99));
        produtos.add(new Produto(2, "Calça Jeans", "Calça jeans skinny", 49.99));
        produtos.add(new Produto(3, "Tênis", "Tênis esportivo", 79.99));
        produtos.add(new Produto(4, "Boné", "Boné de baseball", 14.99));
        produtos.add(new Produto(5, "Mochila", "Mochila escolar", 39.99));
        produtos.add(new Produto(6, "Bolsa", "Bolsa feminina", 59.99));
        produtos.add(new Produto(7, "Óculos de Sol", "Óculos de sol fashion", 24.99));
        produtos.add(new Produto(8, "Relógio", "Relógio analógico", 99.99));
        produtos.add(new Produto(9, "Shorts", "Shorts de praia", 34.99));
        produtos.add(new Produto(10, "Chinelo", "Chinelo de borracha", 9.99));
        produtos.add(new Produto(11, "Jaqueta", "Jaqueta corta-vento", 69.99));
        produtos.add(new Produto(12, "Saia", "Saia rodada", 29.99));
        produtos.add(new Produto(13, "Blusa", "Blusa de malha", 19.99));
        produtos.add(new Produto(14, "Bermuda", "Bermuda cargo", 39.99));
        produtos.add(new Produto(15, "Sapato", "Sapato social", 89.99));
    }

    public Produto insert(Produto produto) {
        listSize++;
        produto.setId(listSize);
        produtos.add(produto);
        return produto;
    }

    public List<Produto> list() {
        return produtos;
    }

    public Produto read(int id) {
        for (Produto produto : produtos) {
            if (produto.getId() == id)
                return produto;
        }
        return null;
    }

    public Produto update(int id, Produto produto) {
        Produto newProduto = null;
        for (int i = 0; i < produtos.size(); i++) {
            Produto oldProduto = produtos.get(i);
            if (oldProduto.getId() == id) {
                produto.setId(id);
                produtos.remove(i);
                produtos.add(i, produto);
                newProduto = produto;
                break;
            }
        }
        return newProduto;
    }


    public Produto upgrade(int id, Produto produto) {
        Produto newProduto = null;

        for (int i = 0; i < produtos.size(); i++) {
            Produto oldProduto = produtos.get(i);
            if (oldProduto.getId() == id) {
                if (produto.getNome() != null) oldProduto.setNome(produto.getNome());
                if (produto.getDescricao() != null) oldProduto.setDescricao(produto.getDescricao());
                if (produto.getPreco() != 0.0) oldProduto.setPreco(produto.getPreco());
                newProduto = new Produto(oldProduto.getId(), oldProduto.getNome(), oldProduto.getDescricao(), oldProduto.getPreco());
                produtos.set(i, newProduto);
                break;
            }
        }
        return newProduto;
    }

    public Produto delete(int id) {
        Produto delProduto = null;
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                delProduto = produto;
                produtos.remove(produto);
                break;
            }
        }
        return delProduto;
    }
}
