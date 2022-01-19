package com.br.bancodigital.view;

import com.br.bancodigital.model.Conta;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperacoesGui extends JFrame {
    private JPanel panel1;
    private JButton sacarButton;
    private JButton depositarButton;
    private JButton trasnferirButton;
    private JButton fecharButton;
    private Conta c;

    public OperacoesGui(Conta c) {
        setContentPane(panel1);
        setTitle("tela de operacao");
        setSize(1900,1000);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        setVisible(true);
        this.c = c;
        acaoButao();
    }

    private void acaoButao() {
        sacarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Runnable t = () -> {
                    try {
                        new SacarGui(c);
                        dispose();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",0);
                    }
                };

                t.run();

            }
        });
        depositarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Runnable t = () -> {
                    try {
                        new DepositoGui(c);
                        dispose();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",0);
                    }
                };

                t.run();
            }
        });
        trasnferirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Runnable t = () -> {
                    try {
                        new SelecaoTransferenciaGui(c);
                        dispose();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",0);
                    }
                };

                t.run();
            }
        });
        fecharButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Runnable t = () -> {
                    try {
                        new SelecaoGui();
                        dispose();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",0);
                    }
                };

                t.run();
            }
        });
    }

    public static void main(String[] args) {
        new OperacoesGui(null);
    }
}
