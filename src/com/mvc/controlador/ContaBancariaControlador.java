package com.mvc.controlador;

import com.mvc.modelo.ContaBancaria;

import java.util.ArrayList;

public class ContaBancariaControlador {
    ArrayList<ContaBancaria> cb = new ArrayList<>();

    public boolean creditarValor(double valor, int numeroConta, int agencia){
        for(ContaBancaria conta : cb){
            if(conta.getAgencia() == agencia && conta.getNumeroConta() == numeroConta){
                conta.setSaldoAtual(conta.getSaldoAtual() + valor);
                return true;
            }
        }
        return false;
    }

    public boolean debitarValor(double valor, int numeroConta, int agencia){
        for(ContaBancaria conta : cb){
            if(conta.getAgencia() == agencia && conta.getNumeroConta() == numeroConta){
                if((conta.getSaldoAtual() - valor) > 0){
                    conta.setSaldoAtual(conta.getSaldoAtual() - valor);
                    return true;
                }else{
                    System.out.println("\n\nSaldo insuficiente.");
                    return false;
                }

            }
        }
        return false;
    }

    public ContaBancaria cadastraConta(double saldoAtual, String nomePessoa, String cpf, int numeroConta, int agencia){
        cb.add(new ContaBancaria(saldoAtual, nomePessoa,cpf, numeroConta, agencia));
        return cb.get(cb.size() - 1);
    }

    public ContaBancaria getCb(int numeroConta, int agencia) {
        for(ContaBancaria conta : cb){
            if(conta.getAgencia() == agencia && conta.getNumeroConta() == numeroConta){
                return conta;
            }
        }
        return new ContaBancaria();
    }
}
