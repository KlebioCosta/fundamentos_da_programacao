package contabancaria;

import Clientes.PessoaFisica;
import Ultilitarios.Ultils;

public class Conta {

    private static int contarContas = 0;
    private int numeroConta;
    private PessoaFisica cliente;
    private Double saldo = 0.0;

    public Conta(PessoaFisica cliente) {
        this.numeroConta = contarContas;
        this.cliente = cliente;
        contarContas += 1;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public PessoaFisica getCliente() {
        return cliente;
    }

    public void setCliente(PessoaFisica cliente) {
        this.cliente = cliente;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numeroConta=" + numeroConta +
                ", cliente=" + cliente +
                ", saldo=" + Ultils.doubleToString(this.getSaldo()) +
                '}';
    }

    public void deposito(Double valor) {
        if(valor > 0) {
            setSaldo(getSaldo() + valor);
            System.out.println("Deposito realizado com sucesso!\n " +
                               "Aqui crescemos juntos!!\n GrowBank. ");
            System.out.println("Seu novo saldo é : " + getSaldo());
        }else {
            System.out.println("Desculpe aconteceu um erro!\n" +
                    " Verifique o valor para depósito e tente novamente. ");
        }
    }
    public void pagarContas(Double valor) {
        if(valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            System.out.println("Conta paga com sucesso!!!\n" +
                               " pagar suas conta é aqui.\n" +
                                "GrowBank");

        }


    }

}