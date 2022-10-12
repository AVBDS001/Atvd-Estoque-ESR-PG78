package entities;

import entities_exceptions.ClienteException;

public class Cliente {
    private String nome;
    private String CPF;
    private String email;

    public Cliente() {
    }

    public Cliente(String nome, String CPF, String email) {
        if (validaCPF(CPF, 11) == false) {
            throw new ClienteException("ERRO: NUMERO DE CARACTERES DO CPF INVÁLIDO");
        }
        this.nome = nome;
        this.CPF = CPF;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean validaCPF(String CPF, int max) {
        if (CPF.length() == max) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return    "Nome do Cliente: " + nome
                + "\nCPF: " + CPF
                + "\nEmail: " + email;
    }
}
