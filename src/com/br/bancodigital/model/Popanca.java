package com.br.bancodigital.model;

public class Popanca extends Conta {

    @Override
    public String imprimir() {
        String valor = String.format(
                "informação da trasação \n" +
                        "titular: %s \n" +
                        "agencia: %s \n" +
                        "conta: %s \n" +
                        "saldo: %d \n",
                this.getTitularConta().getNome(),
                this.getAgenciaConta(),
                this.getNumerroConta(),
                this.getSaldoConta()
        );

        return valor;
    }
}
