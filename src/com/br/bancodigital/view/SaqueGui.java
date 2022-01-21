package com.br.bancodigital.view;

import com.br.bancodigital.controller.ContaController;
import com.br.bancodigital.controller.Navegacao;
import com.br.bancodigital.model.Conta;
import com.br.bancodigital.model.ContaModel;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SacarGui extends JFrame {
    private JPanel panel1;
    private JLabel conta;
    private JLabel agencia;
    private JButton sacarButton;
    private JLabel saldo;
    private JFormattedTextField valor;
    private JLabel titular;
    private JButton finalizarButton;
    private Conta c;
    private ContaModel cm = new ContaModel();
    private Navegacao n = new Navegacao();
    private ContaController cc = new ContaController();

    public SacarGui(Conta c) {
        setContentPane(panel1);
        setTitle("Tela de saque");
        setSize(1900,1000);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        setVisible(true);
        this.c = c;
        mascara();
        substituir();
        acaoButao();
    }

    private void mascara() {
        try {
            MaskFormatter valor = new MaskFormatter("###");
            valor.install(this.valor);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",0);
        }
    }

    private void substituir() {
        try {
            titular.setText(c.getTitularConta().getNome());
            agencia.setText(c.getAgenciaConta());
            conta.setText(c.getNumerroConta());
            saldo.setText(Integer.toString(c.getSaldoConta()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",0);
        }
    }

    private void acaoButao() {
        sacarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    Runnable t = () -> {
                        try {
                            cc.sacarSacar(Integer.parseInt(valor.getText()),c);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",0);
                        }
                    };

                    t.run();
            }
        });
        finalizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Runnable t = () -> {
                    try {
                        n.finalizarSacar(c);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",0);
                    }
                };

                t.run();
            }
        });
    }

    public static void main(String[] args) {
        new SacarGui(null);
    }
}
