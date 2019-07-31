package com.example.conversormoedas;

public class Moeda {

    private String nome;
    private Double valor;

    public Moeda(String nome, double valor) throws Exception {
        if (nome == null || nome.isEmpty())
            throw new Exception("O nome não pode ser nulo ou vazio");
        if(valor <= 0)
            throw new Exception("O valor deve ser maior que zero");

        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
