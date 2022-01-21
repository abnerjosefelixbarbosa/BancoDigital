package com.br.bancodigital.controller;

import com.br.bancodigital.model.Conta;
import com.br.bancodigital.view.*;

import javax.swing.*;

public class Navegacao extends JFrame {

    public void selecao(int valor) {
        switch (valor) {
            case 1:
                new ContaGui(1);
                break;
            case 2:
                new ContaGui(2);
                break;
        }
    }
    public void sacarOperacao(Conta c) {
        new SaqueGui(c);
    }

    public void depositarOperacao(Conta c) {
        new DepositoGui(c);
    }

    public void transferenciaOperacao(Conta c) {
        new SelecaoTransferenciaGui(c);
    }

    public void fecharOperacao() {
        new SelecaoGui();
    }

    public void finalizarSaque(Conta c) {
        new OperacoesGui(c);
    }

    public void finalizarDeposito(Conta c) {
        new OperacoesGui(c);
    }

    public void finalizarTransferencia(Conta c) {
        new OperacoesGui(c);
    }

    public void selecaoTransferencia(int i,Conta c) {
        new TransfenciaGui(i,c);
    }
}
