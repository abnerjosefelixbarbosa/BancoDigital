package com.br.bancodigital.controller;

import com.br.bancodigital.model.Conta;
import com.br.bancodigital.model.ContaModel;
import com.br.bancodigital.view.*;

import javax.swing.*;

public class ContaController extends JFrame {
    private ContaModel cm = new ContaModel();

    public int confirmarConta(Conta c) {
        Conta k = cm.procuraConta(c);
        int i = 0;

        if (k == null) i = 1;

        switch (i) {
            case 1:
                String messagem = "Conta não registrada!";
                JOptionPane.showMessageDialog(null,messagem);
                break;
            default:
                new OperacoesGui(k);
        }

        return i;
    }

    public int sacarSaque(int valor,Conta c) {
        String resultado = cm.sacarConta(valor,c);
        Conta k = cm.procuraConta(c);
        int i = 0;

        switch (resultado) {
            case "":
                JOptionPane.showMessageDialog(null,k.imprimir());
                new OperacoesGui(c);
                i = 1;
                break;
            default:
                JOptionPane.showMessageDialog(null,resultado);
        }

        return i;
    }

    public int depositarDeposito(int valor,Conta c) {
        String resultado = cm.depositarConta(valor,c);
        Conta k = cm.procuraConta(c);
        int i = 0;

        switch (resultado) {
            case "":
                JOptionPane.showMessageDialog(null,k.imprimir());
                new OperacoesGui(c);
                i = 1;
                break;
            default:
                JOptionPane.showMessageDialog(null,resultado);
        }

        return i;
    }

    public  int transferirTransferencia(int valor,Conta c1,Conta c2) {
        String resultado = cm.transferirConta(valor,c1,c2);
        Conta k1 = cm.procuraConta(c1);
        Conta k2 = cm.procuraConta(c2);
        int i = 0;

        switch (resultado) {
            case "":
                JOptionPane.showMessageDialog(null,"Operação realizada com sucesso!");
                JOptionPane.showMessageDialog(null,k1.imprimir() + "\n" + k2.imprimir());
                new OperacoesGui(c1);
                i = 1;
                break;
            default:
                JOptionPane.showMessageDialog(null,resultado);
        }

        return i;
    }
}
