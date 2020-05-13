package com.mvc.modelo;

public class ContaBancaria {
    private double saldoAtual;
    private String nomePessoa;
    private String cpf;
    private int numeroConta;
    private int agencia;

    public ContaBancaria() {}

    public ContaBancaria(double saldoAtual, String nomePessoa, String cpf, int numeroConta, int agencia) {
        this.saldoAtual = saldoAtual;
        this.nomePessoa = nomePessoa;
        this.cpf = cpf;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
    }

    public double getSaldoAtual() {
        return saldoAtual;
    }

    public void setSaldoAtual(double saldoAtual) {
        this.saldoAtual = saldoAtual;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }
}
