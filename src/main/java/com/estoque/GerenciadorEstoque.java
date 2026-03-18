package com.estoque;
import java.util.*;
public class GerenciadorEstoque {
    private List<Produto> lista = new ArrayList<>();
    public void adicionar(Produto p) { lista.add(p); }
    public Produto buscar(String nome) {
        return lista.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
    }
    public void vender(String nome, int qtd) {
        Produto p = buscar(nome);
        if (p == null || p.getQuantidade() < qtd) throw new IllegalArgumentException("Erro no estoque");
        p.setQuantidade(p.getQuantidade() - qtd);
    }
}
