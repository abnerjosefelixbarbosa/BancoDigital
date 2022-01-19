package com.br.bancodigital.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelecaoGui extends JFrame {
    private JPanel panel1;
    private JButton popançaButton;
    private JButton correnteButton;

    public SelecaoGui() {
        setContentPane(panel1);
        setTitle("selecaoTela");
        setSize(1900,1000);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        setVisible(true);
        acoaButao();
    }

    private void acoaButao() {
        popançaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Runnable t = () -> {
                    new ContaGui(1);
                    dispose();
                };

                t.run();
            }
        });
        correnteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Runnable t = () -> {
                    new ContaGui(2);
                    dispose();
                };

                t.run();
            }
        });
    }

    public static void main(String[] args) {
        new SelecaoGui();
    }
}
