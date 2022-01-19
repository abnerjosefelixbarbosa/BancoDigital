package com.br.bancodigital.view;

import com.br.bancodigital.model.Conta;
import com.br.bancodigital.model.ContaModel;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepositoGui extends JFrame {
    private JPanel panel1;
    private JFormattedTextField valor;
    private JLabel titular;
    private JLabel agencia;
    private JLabel conta;
    private JLabel saldo;
    private JButton depositarButton;
    private JButton finalizarButton;
    private Conta c;
    private ContaModel cm = new ContaModel();

    public DepositoGui(Conta c) {
        setContentPane(panel1);
        setTitle("Tela de deposito");
        setSize(1900,1000);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        setVisible(true);
        this.c = c;
        mascara();
        acaoBotao();
        substituir();
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

    private void mascara() {
        try {
            MaskFormatter valor = new MaskFormatter("###");
            valor.install(this.valor);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",0);
        }
    }

    private void acaoBotao() {
        depositarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Runnable t = () -> {
                    try {
                        String resultado = cm.depositarConta(Integer.parseInt(valor.getText()),c);
                        Conta k = cm.procuraConta(c);

                        if (resultado.equals("")) {
                            JOptionPane.showMessageDialog(null,k.imprimir());
                            new OperacoesGui(c);
                            dispose();
                        } else {
                            JOptionPane.showMessageDialog(null,resultado);
                        }
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
                    new SelecaoGui();
                    dispose();
                };

                t.run();
            }
        });
    }

    public static void main(String[] args) {
        new DepositoGui(null);
    }
}
