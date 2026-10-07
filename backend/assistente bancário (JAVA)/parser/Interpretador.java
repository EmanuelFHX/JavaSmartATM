package parser;

import enums.Intencao;

public class Interpretador {

    public Intencao identificarIntencao(String texto) {
        texto = texto.toLowerCase();

        if (texto.contains("saldo")) {
            return Intencao.CONSULTAR_SALDO;
        } else if (texto.contains("extrato")) {
            return Intencao.CONSULTAR_EXTRATO;
        } else if (texto.contains("conta")) {
            return Intencao.CONSULTAR_CONTA;
        } else {
            return Intencao.DESCONHECIDA;
        }
    }

    public int extrairNumeroConta(String texto) {

        String[] palavras = texto.split(" ");

        for (String palavra : palavras) {
            try {
                return Integer.parseInt(palavra);
            } catch (NumberFormatException e) {
            }
        }

        return -1;
    }
}