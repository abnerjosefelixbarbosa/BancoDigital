package com.br.bancodigital.model;

import java.util.List;

public class ContaModel {
    private Repositorio r = new Repositorio();

    public String sacarConta(int valor,Conta c) {
        String resultado = "";

        try {
            int i = r.indeceLista(c);
            Conta k = r.procuraConta(c);

            if (valor > k.getSaldoConta()) {
                resultado = "Valor superior ao saldo da conta logada!";
            } else {
                if (k == null) {
                    resultado = "Conta logada não esta registrada!";
                } else {
                    int valoratual = k.getSaldoConta();
                    valoratual -= valor;
                    k.setSaldoConta(Math.abs(valoratual));
                    r.alterarLista(i,k);
                }
            }
        } catch (Exception ex) {
            resultado = ex.getMessage();
        }

        return resultado;
    }

    public String depositarConta(int valor,Conta c) {
        String resultado = "";

        try {
            int i = r.indeceLista(c);
            Conta k = r.procuraConta(c);

            if (k == null) {
                resultado = "Conta logada não esta registrada!";
            } else {
                int valoratual = k.getSaldoConta();
                valoratual += valor;
                k.setSaldoConta(Math.abs(valoratual));
                r.alterarLista(i,k);
            }
        } catch (Exception ex) {
            resultado = ex.getMessage();
        }

        return  resultado;
    }

    public String transferirConta(int valor,Conta c1,Conta c2) {
        String resultado = "";

        try {
            Conta k1 = r.procuraConta(c1);
            Conta k2 = r.procuraConta(c2);

            if (valor > k1.getSaldoConta()) {
                resultado = "Valor superior ao saldo da conta logada!";
            } else {
                if (c1.getAgenciaConta().equals(c2.getAgenciaConta())) {
                    resultado = "Agência da transferência igual à agência logada!";
                } else if (c1.getNumerroConta().equals(c2.getNumerroConta())) {
                    resultado = "Conta da transferência igual à conta logada!";
                } else if (k1 == null)  {
                    resultado = "Conta logada não esta registrada!";
                } else if (k2 == null)  {
                    resultado = "Conta da transferência não esta resgistrada!";
                } else {
                    sacarConta(valor,c1);
                    depositarConta(valor,c2);
                }
            }
        } catch (Exception ex) {
            resultado = ex.getMessage();
        }

        return  resultado;
    }

    public int indeceLista(Conta c) {
        return r.indeceLista(c);
    }

    public Conta procuraConta(Conta c) {
        return r.procuraConta(c);
    }

    public List<Conta> listarContas() {
        return r.getLista();
    }
}
