package entities;

import entities_exceptions.ProdutoException;

public class Produto {
    private String nome;
    private Double preco;
    private Integer codigo;
    private Integer quantidade;

    public Produto() {
    }

    public Produto(String nome, Double preco, Integer codigo, Integer quantidade) {
        if (preco <= 0) {
            throw new ProdutoException("ERRO: O VALOR DOS PREÇOS NÃO PODE SER MENOR OU IGUAL A ZERO");
        }
        this.nome = nome;
        this.preco = preco;
        this.codigo = codigo;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double valorTotal() {
        return quantidade * preco;
    }

    public Double descontoValorTotal(double descPorcentagem) {
        return (quantidade * preco) - (quantidade * preco) * descPorcentagem / 100;
    }

    @Override
    public String toString() {
        return  "Nome do Produto: " + nome
                + "\nPreço: " + preco
                + "\nCódigo: " + codigo
                + "\nQuantidade: " + quantidade;
    }
}
