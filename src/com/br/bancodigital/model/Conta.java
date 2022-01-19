package com.br.bancodigital.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Conta {
    protected String agenciaConta;
    protected String numerroConta;
    protected int digitoConta;
    protected int saldoConta;
    protected Titular titularConta;

    public abstract String imprimir();
}
