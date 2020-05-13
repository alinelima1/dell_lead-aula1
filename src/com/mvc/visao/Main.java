package com.mvc.visao;
import com.mvc.controlador.ContaBancariaControlador;
import com.mvc.modelo.ContaBancaria;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ContaBancariaControlador cbc = new ContaBancariaControlador();
        ContaBancaria cb = new ContaBancaria();
        Scanner x = new Scanner(System.in);
        Random r = new Random();
        double valor = 0.00;
        int conta = 0;
        int agencia = 0;
        String nome;
        String cpf;
        int option = 0;

        while(option != 5){
            System.out.println("Selecione uma opção:\n" +
                    "1) Depósito\n" +
                    "2) Saque\n" +
                    "3) Consultar saldo\n" +
                    "4) Cadastrar nova conta\n" +
                    "5) Sair\n");
            System.out.print("Digite uma opção: ");

            option = x.nextInt();

            switch (option){
                case 1:
                    System.out.print("Informe o valor a ser depositado: ");
                    valor = x.nextDouble();
                    System.out.print("Informe o número da conta: ");
                    conta = x.nextInt();
                    System.out.print("Informe a agência: ");
                    agencia = x.nextInt();
                    if(cbc.creditarValor(valor, conta ,agencia) == true){
                        System.out.println("\n\nCrédito realizado com sucesso. Novo saldo " + cbc.getCb(conta, agencia).getSaldoAtual() + "\n\n");
                    }else{
                        System.out.println("\n\nNão foi possível realizar o depósito, verifique os dados da conta.\n\n");
                    }
                    break;
                case 2:
                    System.out.print("Informe o valor do saque: ");
                    valor = x.nextDouble();
                    System.out.print("Informe o número da conta: ");
                    conta = x.nextInt();
                    System.out.print("Informe a agência: ");
                    agencia = x.nextInt();
                    if(cbc.debitarValor(valor, conta ,agencia) == true){
                        System.out.println("\n\nSaque realizado com sucesso. Novo saldo " + cbc.getCb(conta, agencia).getSaldoAtual() + "\n\n");
                    }else{
                        System.out.println("\n\nNão foi possível realizar o saque, verifique os dados informados.\n\n");
                    }
                    break;
                case 3:
                    System.out.print("Informe o número da conta: ");
                    conta = x.nextInt();
                    System.out.print("Informe a agência: ");
                    agencia = x.nextInt();
                    cb = cbc.getCb(conta ,agencia);
                    if(cb.getNomePessoa() == null){
                        System.out.println("\n\nConta não localizada, favor verificar os dados informados.\n\n");
                    }else{
                        System.out.println("\n\nO saldo disponível é " + cb.getSaldoAtual() + "\n\n");
                    }
                    break;
                case 4:
                    System.out.print("Informe o nome do titular da nova conta: ");
                    x.nextLine();
                    nome = x.nextLine();
                    System.out.print("Informe o cpf do titular da nova conta: ");
                    cpf = x.nextLine();
                    System.out.print("Informe valor inicial a ser depositado na conta: ");
                    valor = x.nextDouble();
                    conta = r.nextInt(1000);
                    agencia = r.nextInt(100);
                    cb = cbc.cadastraConta(valor, nome, cpf, conta, agencia);
                    System.out.println("\n\nConta cadastrada na Agência " + cb.getAgencia() + " e conta " + cb.getNumeroConta() + "\n\n");
                    break;
                case 5:
                    System.out.println("\n\nObrigada por utilizar nossos serviços.\n\n");
                    break;
                default:
                    System.out.println("\n\nOpção inválida, tente novamente!\n\n");
            }
        }

    }
}
