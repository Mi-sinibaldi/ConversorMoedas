package com.example.conversormoedas;

import android.util.Log;

public class Conversor {
    private double valor;
    private Moeda moeda;

    public Conversor(double valor, Moeda moeda) throws Exception {
        if (valor <= 0)
            throw new Exception("Valor deve ser maior que zero!");
        if (moeda == null)
            throw new Exception("Moeda não pode ser nula!");

        this.valor = valor;
        this.moeda = moeda;
    }

    public double Converte() {

        try {
                return valor / moeda.getValor();

        }catch (Exception e){
            Log.e(this.getClass().getName(), e.getMessage());
            return -1;
        }

    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Moeda getMoeda() {
        return this.moeda;
    }

    public void setMoeda(Moeda moeda) {
        this.moeda = moeda;
    }
}
