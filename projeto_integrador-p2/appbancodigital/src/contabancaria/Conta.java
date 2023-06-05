package contabancaria;

import Clientes.DadosClientes;
import Clientes.PessoaFisica;
import Ultilitarios.Utils;

import static javax.swing.JOptionPane.*;
import static javax.swing.JOptionPane.showInputDialog;

public class Conta {

    private static int contarContas = 1;
    private int numeroConta = 0;
    private DadosClientes cliente;
    private Double saldo = 0.0;

    public Conta(DadosClientes cliente) {
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

    public DadosClientes getCliente() {
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
        return "Contas no Sistema \n" +
                "Numero da Conta: " + numeroConta +
                "\n Cliente: " + cliente +
                "\n Saldo R$: " + Utils.doubleToString(this.getSaldo());
    }

    public void deposito(Double valor) {
        if(valor > 0) {
            setSaldo(getSaldo() + valor);
            showMessageDialog(null,"Deposito realizado com sucesso!\n " +
                    "Aqui crescemos juntos!!\n GrowBank. \n" +
                    "Seu novo saldo é R$: " + Utils.doubleToString(getSaldo()));
        }else {
            showMessageDialog(null,"Desculpe aconteceu um erro!\n" +
                    " Verifique o valor para depósito e tente novamente. ");
        }
    }

}