package Clientes;

import java.awt.*;

public class PessoaFisica {
    private static int idUsuario = 1;
    private String nome;
    private int dataNascimento;
    private int cPF;
    private String email;
    private String senha;
    private String confirmaSenha;

    public PessoaFisica(String nome, int dataNascimento, int cPF, String email, String senha, String confirmaSenha) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cPF = cPF;
        this.email = email;
        this.senha = senha;
        this.confirmaSenha = confirmaSenha;
        idUsuario += 1;
    }

    public static int getIdUsuario() {

        return idUsuario;
    }

    public static void setIdUsuario() {

        PessoaFisica.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(int dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getcPF() {
        return cPF;
    }

    public void setcPF(int cPF) {
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

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }


    @Override
    public String toString() {
        return "PessoaFisica{" +
                "nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", cPF='" + cPF + '\'' +
                ", email='" + email + '\'' +
                ", senha=" + senha +
                ", confirmaSenha=" + confirmaSenha +
                '}';
    }
}
