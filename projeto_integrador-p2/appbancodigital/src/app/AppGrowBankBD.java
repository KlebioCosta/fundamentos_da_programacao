package app;

import Clientes.PessoaFisica;
import contabancaria.Conta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AppGrowBankBD {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    static HashMap<String,PessoaFisica> allPessoasFisicas = new HashMap<String,PessoaFisica>();

    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        operacaoCadastro();
    }

    public static void operacaoCadastro() {

        System.out.println("---------------------------------------------------------");
        System.out.println("----------------Bem vindo ao GrowBank--------------------");
        System.out.println("---------------------------------------------------------");
        System.out.println("---------Selecione uma das operações a seguir------------");
        System.out.println("---------------------------------------------------------");

        System.out.println("|    Opção 1 - Criar conta        |");
        System.out.println("|    Opção 2 - Fazer Login        |");
        System.out.println("|    Opção 3 - Contas no sistema  |");
        System.out.println("|    Opção 4 -       sair         |");


        int operacao = sc.nextInt();

        switch (operacao) {
            case 1:
                criarConta();
                break;
            case 2:
                fazerlogin(allPessoasFisicas);
                break;
            case 3:
                contasNoSistema();
                break;
            case 4:
                System.out.println("-_=-_-GrowBank-_-=_-");
                System.exit(0);

            default:
                System.out.println("Opção invalida!!");
                System.out.println("Por favor digite outra opção!!");
                operacaoCadastro();
                break;
        }

    }

    public static void criarConta() {
        System.out.println("-=-=Preencha todos os daodos=-=-=-");
        System.out.println("\nNome Cliente: ");
        String nome = sc.next();

        System.out.println("\nData de Nascimento: ");
        int dataNascimento = sc.nextInt();

        System.out.println("\nCPF: ");
        int cPF = sc.nextInt();

        System.out.println("\nEmail: ");
        String email = sc.next();

        System.out.println("\nSenha: ");
        String senha = sc.next();


        System.out.println("\nConfirmar Senha: ");
        String confimarSenha = sc.next();


        PessoaFisica pessoa = new PessoaFisica(nome, dataNascimento,cPF, email, senha, confimarSenha);
        Conta pessoaFisica = new Conta(pessoa);

        allPessoasFisicas.put(nome, pessoa);

        Conta conta = new Conta(pessoa);

        contasBancarias.add(conta);
        System.out.println("Bem Vindo ao Grow, cadastro concluido com sucesso.\n" +
                " Crecer é isso!!! \n");

        operacaoCadastro();

    }

    private static void fazerlogin(HashMap<String,PessoaFisica> pessosFisicas) {
        System.out.println("usurio: ");
        String usuario = sc.next();
        Conta contaUsuario = null;

        if(pessosFisicas.containsKey(usuario)){

            System.out.println("senha: ");
            String senha = sc.next();

            PessoaFisica cliente =pessosFisicas.get(usuario);

            if(senha.equals(cliente.getSenha())){
                System.out.println("  -=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                System.out.println("   Bem vindo, \n   "+ cliente.getNome() +" o que iremos fazer hoje: \n");
                System.out.println("  -=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                for(Conta c: contasBancarias){
                    if(cliente.equals(c.getCliente())){
                        contaUsuario = c;
                    }
                }

                operacaoLogin(contaUsuario);
            }else {
                System.out.println("Senha invalida");
                operacaoCadastro();
            }

        }else {
            System.out.println("Não existe esse usuario na base");
            operacaoCadastro();
        }



    }
    public static void contasNoSistema() {
        if(contasBancarias.size() > 0) {
            for(Conta conta: contasBancarias) {
                System.out.println(conta);
            }
        }else {
            System.out.println("********************************************");
            System.out.println("   Infelismente inda não temos clientes\n " +
                    " Seja nosso primeiro cliente e vem crescer.\n" +
                    "                 GROW BANK\n");
            System.out.println("***************************************8****");

                    criarConta();
        }
        operacaoCadastro();

    }

    public static void operacaoLogin(Conta conta) {
        System.out.println("|     Opção 1 - Verificar Saldo       |");
        System.out.println("|     Opção 2 - Depositar             |");
        System.out.println("|     Opção 3 - Fazer transferencia   |");
        System.out.println("|     Opção 4 - Pagar contas          |");
        System.out.println("|     Opção 5 - Sair                  |");

        int acessar = sc.nextInt();
        switch (acessar) {
            case 1:
                verificarSaldo(conta);
                break;
            case 2:
                depositar(conta);
                break;
            case 3:
                transferencia(conta);
                break;
//            case 4:
//                pagamento();
//                break;
            case 5:
                System.out.println("-=-=-=-=-=**-GrowBank-**=-=-=-=-=--=-=-");
                operacaoCadastro();


        }
    }
    private static void verificarSaldo(Conta conta) {

        Double saldo;
        if(conta.getSaldo() > 0) {
            System.out.println("Saldo atual: "+ conta.getSaldo());
        }else {
            System.out.println("--*--*--*--*--*--*--*--*--*--*--*--");
            System.out.println("Estamos zerados...\n" +
                    "Vamos fazer um depoisto hoje? ");
            System.out.println("--*--*--*--*--*--*--*--*--*--*--*--");
        }

    operacaoLogin(conta);
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
        System.out.println("Conta para deposito: ");
        int numeroConta = sc.nextInt();

        Conta conta = contasCadastradas(numeroConta);

        if(conta != null) {
            System.out.println("Valor para deposito R$: ");
            Double valorDeposito = sc.nextDouble();
            conta.deposito(valorDeposito);
            System.out.println("Deposito realizado com sucesso. ");
        }else {
            System.out.println("Conta destino não encontrada ");
            System.out.println("Tente novamente em alguns instantes");

        }operacaoLogin(c);

    }
    public static void transferencia(Conta conta) {
        System.out.println("Digite conta destino transferencia: ");
        int numeroContaDestino = sc.nextInt();

        Conta contaDestino = contasCadastradas(numeroContaDestino);
        if(contaDestino != null) {
            System.out.println("Valor a ser trasferido: ");
            Double valor = sc.nextDouble();
            double saldoEmConta = conta.getSaldo();
            if(( saldoEmConta - valor) > 0){
                conta.setSaldo(saldoEmConta - valor);
                contaDestino.setSaldo(valor);
                System.out.println("(\"Confirmado, sua transferência foi ralizada com sucesso!!\\n\" +\n" +
                        "                    \" Porque aqui todos crecem.\\n\" +\n" +
                        "                    \"GrowBank\"");
            }else{
                System.out.println("Você não possui saldo suficiente");
            }


        }else {
            System.out.println("A conta digitada nao foi encontrada,\n" +
                    " Por favor,\n" +
                    " verifique o numero da conta para a transferencia");
        }

        operacaoLogin(conta);
    }


}

