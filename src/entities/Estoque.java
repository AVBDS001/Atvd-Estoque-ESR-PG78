package entities;

public class Estoque {
    private Integer qtdMin;
    private Integer qtdDisp;

    public Estoque() {
    }

    public Estoque(Integer qtdMin, Integer qtdDisp) {
        this.qtdMin = qtdMin;
        this.qtdDisp = qtdDisp;
    }

    public Integer getQtdMin() {
        return qtdMin;
    }

    public Integer getQtdDisp() {
        return qtdDisp;
    }

    public void setQtdDisp(Integer qtdDisp) {
        this.qtdDisp = qtdDisp;
    }

    public Integer adicionarEstoque(Integer quantidade) {
        return qtdDisp += quantidade;
    }

    public Integer removerEstoque(Integer quantidade) {
        return qtdDisp -= quantidade;
    }

    public boolean precisaAbastecer() {
        //No exercicio ele pede que tenha ao menos 10 itens no estoque para começar
        if (qtdDisp == qtdMin) {
            System.out.println("ESTOQUE MÍNIMO ABASTECIDO");
            return false;
        }
        else if (qtdDisp < qtdMin) {
            System.out.println("PRECISA ABASTECER O ESTOQUE");
            return true;
        }
        else {
            System.out.println("ESTOQUE ABASTECIDO");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Quantidade disponível em estoque: " + qtdDisp;
    }
}
