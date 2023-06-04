package Ultilitarios;

public class NomeUtils {
    public static String formatarPrimeiraLetraCaixaAlta(String nome) {
        // Verifica se o nome está vazio ou contém apenas espaços em branco
        if (nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode estar em branco.");
        }

        // Converte a primeira letra para maiúscula
        String primeiraLetra = nome.substring(0, 1).toUpperCase();

        // Obtém o restante do nome em caixa baixa
        String restoDoNome = nome.substring(1).toLowerCase();

        // Concatena a primeira letra em caixa alta com o restante do nome
        String nomeFormatado = primeiraLetra + restoDoNome;

        return nomeFormatado;
    }
}

