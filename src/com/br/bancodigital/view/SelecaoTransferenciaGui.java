package com.br.bancodigital.view;

import com.br.bancodigital.model.Conta;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelecaoTransferenciaGui extends JFrame {
    private JPanel panel1;
    private JButton popançaButton;
    private JButton correnteButton;
    private Conta c;

    public SelecaoTransferenciaGui(Conta c) {
        setContentPane(panel1);
        setTitle("Seleção de transferência");
        setSize(1900,1000);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        setVisible(true);
        this.c = c;
        acaoButao();
    }

    private void acaoButao() {
        popançaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Runnable t = () -> {
                    new TransferirGui(1,c);
                    dispose();
                };

                t.run();
            }
        });
        correnteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Runnable t = () -> {
                    new TransferirGui(2,c);
                    dispose();
                };

                t.run();
            }
        });
    }

    public static void main(String[] args) {
        new SelecaoTransferenciaGui(null);
    }
}
