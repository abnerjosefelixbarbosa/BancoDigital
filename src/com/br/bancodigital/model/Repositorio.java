package com.br.bancodigital.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Repositorio {
    @Setter
    @Getter
    private List<Conta> lista = new ArrayList<>();

    public Repositorio() {
        carregarLista();
    }

    public void alterarLista(int i,Conta c) {
        lista.set(i,c);
    }

    public int indeceLista(Conta c) {
        int resultado = -1;

        for (int i = 0;i < lista.size();i++) {
            Conta k = lista.get(i);
            if (k.getAgenciaConta().equals(c.getAgenciaConta()) && k.getNumerroConta().equals(c.getNumerroConta())) {
                resultado = i;
                break;
            }
        }

        return resultado;
    }

    public Conta procuraConta(Conta c) {
        Conta resultado = null;

        for (int i = 0; i < lista.size(); i++) {
            Conta k = lista.get(i);
            if (k.getAgenciaConta().contains(c.getAgenciaConta()) && k.getNumerroConta().contains(c.getNumerroConta())) {
                resultado = k;
                break;
            }
        }

        return resultado;
    }

    private void carregarLista() {
        Titular t1 = new Titular();
        t1.setNome("Carlos");
        Conta p = new Popanca();
        p.setAgenciaConta("6954");
        p.setNumerroConta("2491-1");
        p.setDigitoConta(1);
        p.setSaldoConta(200);
        p.setTitularConta(t1);
        lista.add(p);

        Titular t2 = new Titular();
        t2.setNome("Tania");
        Conta c = new Corrente();
        c.setAgenciaConta("5450");
        c.setNumerroConta("511090-2");
        c.setDigitoConta(2);
        c.setSaldoConta(400);
        c.setTitularConta(t2);
        lista.add(c);
    }

}
