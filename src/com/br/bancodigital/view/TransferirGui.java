package com.br.bancodigital.view;

import com.br.bancodigital.model.Conta;
import com.br.bancodigital.model.ContaModel;
import com.br.bancodigital.model.Corrente;
import com.br.bancodigital.model.Popanca;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransferirGui extends JFrame {
    private JPanel panel1;
    private JFormattedTextField valor;
    private JButton transferirButton;
    private JButton finalizarButton;
    private JFormattedTextField agencia2;
    private JFormattedTextField conta2;
    private JLabel titular1;
    private JLabel agencia1;
    private JLabel conta1;
    private JLabel saldo1;
    private int i;
    private Conta c1;
    private Conta c2;
    private ContaModel cm = new ContaModel();

    public TransferirGui(int i,Conta c) {
        setContentPane(panel1);
        setTitle("Tela de transferência");
        setSize(1900,1000);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        setVisible(true);
        this.c1 = c;
        this.i = i;
        mascara();
        substituir();
        acaoButao();
    }

    private void acaoButao() {
        transferirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Runnable t = () -> {
                    try {
                        if (i == 1) {
                            c2 = new Popanca();
                            c2.setAgenciaConta(agencia2.getText());
                            c2.setNumerroConta(conta2.getText());
                            String resultado = cm.transferirConta(Integer.parseInt(valor.getText()),c1,c2);
                            Conta k1 = cm.procuraConta(c1);
                            Conta k2 = cm.procuraConta(c2);

                            if (resultado.equals("")) {
                                JOptionPane.showMessageDialog(null,"Operação realizada com sucesso!");
                                JOptionPane.showMessageDialog(null,k1.imprimir() + "\n" + k2.imprimir());
                                new OperacoesGui(c1);
                                dispose();
                            } else {
                                JOptionPane.showMessageDialog(null,resultado);
                            }
                        } else {
                            c2 = new Corrente();
                            c2.setAgenciaConta(agencia2.getText());
                            c2.setNumerroConta(conta2.getText());
                            String resultado = cm.transferirConta(Integer.parseInt(valor.getText()),c1,c2);
                            Conta k1 = cm.procuraConta(c1);
                            Conta k2 = cm.procuraConta(c2);

                            if (resultado.equals("")) {
                                JOptionPane.showMessageDialog(null,"Operação realizada com sucesso!");
                                JOptionPane.showMessageDialog(null,k1.imprimir() + "\n" + k2.imprimir());
                                new OperacoesGui(c1);
                                dispose();
                            } else {
                                JOptionPane.showMessageDialog(null,resultado);
                            }
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
                    new OperacoesGui(c1);
                    dispose();
                };

                t.run();
            }
        });
    }

    private void mascara() {
        try {
            if (i == 1) {
                MaskFormatter valor = new MaskFormatter("###");
                MaskFormatter agencia2 = new MaskFormatter("####");
                MaskFormatter conta2 = new MaskFormatter("####-#");
                valor.install(this.valor);
                agencia2.install(this.agencia2);
                conta2.install(this.conta2);
            } else {
                MaskFormatter valor = new MaskFormatter("###");
                MaskFormatter agencia2 = new MaskFormatter("####");
                MaskFormatter conta2 = new MaskFormatter("######-#");
                valor.install(this.valor);
                agencia2.install(this.agencia2);
                conta2.install(this.conta2);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",0);
        }
    }

    private void substituir() {
        try {
            titular1.setText(c1.getTitularConta().getNome());
            agencia1.setText(c1.getAgenciaConta());
            conta1.setText(c1.getNumerroConta());
            saldo1.setText(Integer.toString(c1.getSaldoConta()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",0);
        }
    }

    public static void main(String[] args) {
        new TransferirGui(0,null);
    }
}
