package Clientes;

import java.time.DateTimeException;

public abstract class DadosClientes {
    private static int idUsuario = 0;
    private String nome = null;
    private DateTimeException dataNascimento;
    private String cPF;
    private String email = null;
    private String senha = null;

    public DadosClientes() {

    };

    public DadosClientes(String nome, DateTimeException dataNascimento, String cPF, String email, String senha) {
        idUsuario += 1;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cPF = cPF;
        this.email = email;
        this.senha = senha;


    }

    public static int getIdUsuario() {

        return idUsuario;
    }

    public static void setIdUsuario() {

        DadosClientes.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public DateTimeException getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(DateTimeException dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getcPF() {
        return cPF;
    }

    public void setcPF(String cPF) {
        this.cPF = cPF;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    @Override
    public String toString() {
        return nome ;
    }
}
