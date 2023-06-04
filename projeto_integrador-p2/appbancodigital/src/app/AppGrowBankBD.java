package app;

import Clientes.PessoaFisica;
import contabancaria.Conta;
import Ultilitarios.NomeUtils;

import javax.swing.*;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import static javax.swing.JOptionPane.*;


public class AppGrowBankBD {
    static ArrayList<Conta> contasBancarias;
    static HashMap<String,PessoaFisica> allPessoasFisicas = new HashMap<String,PessoaFisica>();

    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();

        operacaoCadastro();
    }

    public static void operacaoCadastro() {
        int operacao =
                Integer.parseInt(showInputDialog(

                "---------Bem vindo ao GrowBank---------\n" +
                "-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=\n" +
                " Selecione uma das operações a seguir  \n" +
                "\n" +
                "|  Opção 1 - Criar conta              \n" +
                "|  Opção 2 - Fazer Login              \n" +
                "|  Opção 3 - Contas no Sistema        \n" +
                "|  Opção 4 -       sair                 "));


        switch (operacao) {
            case 1 -> criarConta();
            case 2 -> fazerlogin(allPessoasFisicas);
            case 3 -> contasNoSistema();
            case 4 -> {
                showMessageDialog(null, "-_-=_-GrowBank-_-=_-");
                System.exit(0);
            }
            default -> {
                showMessageDialog(null,
                        "Opção invalida!!\n" +
                                "Por favor digite outra opção!!");
                operacaoCadastro();
            }
        }

    }

    public static void criarConta() {
        PessoaFisica cliente = new PessoaFisica();

        showMessageDialog(
                null,"-=-=Preencha todos os dados=-=-=-");

        cliente.setNome(showInputDialog("Nome: "));

        cliente.setDataNascimento(new DateTimeException(showInputDialog("Data de Nascimento: ")));

        cliente.setcPF(showInputDialog("CPF: "));

        cliente.setEmail(showInputDialog("Email: "));


        cliente.setSenha(showInputDialog(null,"Senha: "));


        allPessoasFisicas.put(cliente.getNome(), cliente);

        Conta conta = new Conta(cliente);

        contasBancarias.add(conta);
        showMessageDialog(null,
                "    Bem Vindo ao GrowBank, \n" +
                        "Cadastro concluido com sucesso.\n" +
                        "     Crecer é isso!!!");

        operacaoCadastro();

    }

    private static void fazerlogin(HashMap<String,PessoaFisica> allPessoasFisicas) {

        String usuario = showInputDialog("Usuario: ");
        String senha = showInputDialog("senha: ");

        Conta contaUsuario = null;
        if(allPessoasFisicas.containsKey(usuario)){

            PessoaFisica cliente = allPessoasFisicas.get(usuario);

            if(senha.equals(cliente.getSenha())){
                int tentativas = 0;
                String senhaCorreta = cliente.getSenha();

                showMessageDialog(null,
                "-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n" +
                        "   Bem vindo, "+ cliente.getNome()+  "\n" +
                        "\n" +
                        "O que iremos fazer hoje?              \n" +
                        "-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

                for(Conta c: contasBancarias){
                    if(cliente.equals(c.getCliente())){
                        contaUsuario = c;
                    }
                }

                acessoConta(contaUsuario);
            }else {
                int contador = 4;
                for(int tentativas=1; tentativas <=3; tentativas++) {
                    contador = contador -1;

                    senha = showInputDialog(null,"Senha incorreta. Tente novamente. \n" +
                            "Chances possiveis " + contador);
                        if (senha.equals(cliente.getSenha())) {
                            showMessageDialog(null,
                                    "-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n" +
                                            "   Bem vindo, "+ cliente.getNome()+  "\n" +
                                            "\n" +
                                            "O que iremos fazer hoje?              \n" +
                                            "-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                            acessoConta(contaUsuario);
                        }

                }bloquearConta();

            }


        }else {
            showMessageDialog(null,"Não existe esse usuario na base");
            operacaoCadastro();
        }



    }
    private static void bloquearConta() {
        showMessageDialog(null, "Conta bloqueada. Entre em contato com a central. ");
        System.exit(0);
    }
    public static void contasNoSistema() {
        if(contasBancarias.size() > 0) {
            for(Conta conta: contasBancarias) {
                showMessageDialog(null,conta);
                 conta.getCliente();
            }
        }else {
            showMessageDialog(null,
                "********************************************\n" +
                "  Infelismente inda não temos clientes\n " +
                " Seja nosso primeiro cliente e vem crescer.\n" +
                "                  GROW BANK\n" +
                "********************************************");
                    criarConta();
        }
        operacaoCadastro();

    }

    public static void acessoConta(Conta conta) {
        int acessar = Integer.parseInt(showInputDialog(
        "|     Opção 1 - Verificar Saldo       |\n" +
        "|     Opção 2 - Depositar             |\n" +
        "|     Opção 3 - Fazer transferencia   |\n" +
        "|     Opção 4 - Pagar contas          |\n" +
      //"|     Opção 6 - Cliente adicional     |\n" +
        "|     Opção 5 - Sair                  |\n"));

        switch (acessar) {
            case 1 -> verificarSaldo(conta);
            case 2 -> depositar(conta);
            case 3 -> transferencia(conta);
            case 4 -> pagarContas(conta);
//            case 4:
//                pagamento();
//                break;
            case 5 -> {
                showMessageDialog(null, "-=-=-=-=-=**-GrowBank-**=-=-=-=-=--=-=-");
                operacaoCadastro();
            }
        }
    }
    private static void verificarSaldo(Conta conta) {

        Double saldo;
        if(conta.getSaldo() > 0) {
            showMessageDialog(null,"Saldo atual: "+ conta.getSaldo());
        }else {
            showMessageDialog(null,
            "--*--*--*--*--*--*--*--*--*--*--*--" +
                    "Estamos zerados...\n" +
                    "Vamos fazer um depoisto hoje? " +
                    "--*--*--*--*--*--*--*--*--*--*--*--");
        }

    acessoConta(conta);
    }
    private static Conta contasCadastradas(int numeroConta) {
        Conta conta = null;
        if(contasBancarias.size() > 0) {
            for(Conta c: contasBancarias) {
                if(c.getNumeroConta() == numeroConta) {
                conta = c;
                }
            }
        }
        return conta;
    }
    private static void depositar(Conta c) {
        int numeroConta = Integer.parseInt(showInputDialog("Conta para deposito: "));

        Conta conta = contasCadastradas(numeroConta);

        if(conta != null) {

            Double valorDeposito = Double.parseDouble(showInputDialog("Valor para deposito R$: "));
            conta.deposito(valorDeposito);
            showMessageDialog(null,"Deposito realizado com sucesso. ");
        }else {
            showMessageDialog(null,
                    "Conta destino não encontrada " +
                    "Tente novamente em alguns instantes");

        }acessoConta(c);

    }
    public static void transferencia(Conta conta) {
        int numeroContaDestino = Integer.parseInt(showInputDialog("Digite conta destino transferencia: "));

        Conta contaDestino = contasCadastradas(numeroContaDestino);
        if(contaDestino != null) {
            Double valor = Double.parseDouble(showInputDialog("Valor a ser trasferido: "));
            double saldoEmConta = conta.getSaldo();

            if(( saldoEmConta - valor) > 0){
                conta.setSaldo(saldoEmConta - valor);
                contaDestino.setSaldo(valor);
                showMessageDialog(null,"Confirmado, sua transferência foi ralizada com sucesso!!\n" +
                                            " Porque aqui todos crecem. \n" +
                                            "GrowBank");
            }else{
                showMessageDialog(null,"Você não possui saldo suficiente");
            }


        }else {
            showMessageDialog(null,"A conta digitada nao foi encontrada,\n" +
                    " Por favor,\n" +
                    " verifique o numero da conta para a transferencia");
        }

        acessoConta(conta);
    }
    public static void pagarContas(Conta conta) {
        Double valor = Double.parseDouble(showInputDialog("Digite o valor a ser pago: "));
        if (valor > conta.getSaldo()) {
            showMessageDialog(null, "Valor maior que Saldo disponivel. ");

        }else{
            conta.setSaldo(conta.getSaldo() - valor);
            showMessageDialog(null,"Conta paga com sucesso. ");
        }
        acessoConta(conta);
    }


}

