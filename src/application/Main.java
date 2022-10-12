package application;

import entities.Cliente;
import entities.Estoque;
import entities.Produto;
import entities_exceptions.ClienteException;
import entities_exceptions.ProdutoException;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int qtdMin = 10;
        int[] qtdEstoque = new int[qtdMin];

        //Colocando uma certa quantidade de produtos no estoque
        for (int i = 1; i < qtdEstoque.length; i++) {
            qtdEstoque[i] = i;
        }
        int qtdDisp = qtdEstoque.length;
        Estoque estoque = new Estoque(qtdMin, qtdDisp);


        //VERIFICANDO A QUANTIDADE DE ITENS NO ESTOQUE, GERALMENTE O PROGRAMA IRÁ INICIAR COM A QTDMIN
        System.out.print("Deseja verificar a quantidade total de itens no estoque: (Aperte S --> SIM / Aperte N --> NAO): ");
        char resposta = sc.next().charAt(0);

        if (resposta == 'S') {
            estoque.precisaAbastecer();
            System.out.println();
        }


        sc.nextLine();
        System.out.println("DADOS DO PEDIDO DO CLIENTE");
        char saida = 'N';
        //Menu de inserção de dados do produto
        char condicaoMenuCompra = 'N';
        while(condicaoMenuCompra != 'S') {
            try {
                while (saida != 'S') {

                    System.out.print("Insira o nome do produto a ser comprado: ");
                    String nomeProduto = sc.nextLine();

                    //Gerando o código do produto
                    int max = 8000;
                    int min = 1000;
                    int range = max - min + 1;
                    int codigo = (int) (Math.random() * range) + min;
                    System.out.print("Codigo do produto a ser comprado: " + codigo);


                    System.out.println();
                    System.out.print("Insira o preço do produto a ser comprado: ");
                    double preco = sc.nextDouble();

                    System.out.print("Insira a quantidade de produtos a serem comprados: ");
                    int quantidade = sc.nextInt();
                    estoque.removerEstoque(quantidade);

                    Produto produto = new Produto(nomeProduto, preco, codigo, quantidade);

                    System.out.println("Valor total dos produtos comprados: $ " + produto.valorTotal());

                    System.out.println();
                    System.out.print("O cliente tem direito a desconto: (Aperte S --> SIM / N --> NAO): ");
                    resposta = sc.next().charAt(0);

                    if (resposta == 'S') {
                        System.out.print("Valor da compra com 15% desconto: $ " + produto.descontoValorTotal(15));
                        System.out.println();
                    }
                    else {
                        System.out.println();
                        System.out.println("Cliente sem direito a desconto");
                        System.out.println("Valor total dos produtos comprados: $ " + produto.valorTotal());
                    }
                    System.out.print("O cliente confirma a compra: (Aperte S --> SIM / N --> NAO): ");
                    saida = sc.next().charAt(0);

                    if (saida == 'N') {
                        estoque.adicionarEstoque(quantidade);
                    }
                    sc.nextLine();
                }
            }
            catch (ProdutoException e) {
                System.out.println(e.getMessage());
            }
            System.out.print("Deseja sair do menu de compra (Aperte S --> SIM/Aperte N --> NAO): ");
            condicaoMenuCompra = sc.next().charAt(0);
            if (condicaoMenuCompra == 'S') {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
            sc.nextLine();
        }

        //Menu de inserção de dados do cliente
        char condicaoMenuCliente = 'N';
        while(condicaoMenuCliente != 'S') {
            try {
                char condicaoCliente = 'N';
                while (condicaoCliente != 'S') {
                    System.out.print("Insira o nome do cliente: ");
                    String nome = sc.nextLine();

                    System.out.print("Insira o CPF do cliente: ");
                    String CPF = sc.next();

                    System.out.print("Insira o e-mail do cliente: ");
                    String email = sc.next();

                    Cliente cliente = new Cliente(nome, CPF, email);

                    //validando o tamanho do CPF
                    cliente.validaCPF(CPF, 11);

                    System.out.print("Deseja sair do menu de dados do cliente: (Aperte S --> SIM/N --> NAO): ");
                    condicaoCliente = sc.next().charAt(0);
                }
                sc.nextLine();
            }
            catch (ClienteException e) {
                System.out.println(e.getMessage());
            }

            System.out.print("Deseja sair do menu do cliente: (Aperte S --> SIM/N --> NAO): ");
            condicaoMenuCliente = sc.next().charAt(0);
            sc.nextLine();
        }


        //final do programa
    }
}
