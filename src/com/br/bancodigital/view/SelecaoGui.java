package com.br.bancodigital.view;

import com.br.bancodigital.controller.ContaController;
import com.br.bancodigital.controller.Navegacao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelecaoGui extends JFrame {
    private JPanel panel1;
    private JButton popançaButton;
    private JButton correnteButton;
    private Navegacao n = new Navegacao();

    public SelecaoGui() {
        setContentPane(panel1);
        setTitle("tela de seleção");
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
                    n.selecao(1);
                    dispose();
                };

                t.run();
            }
        });
        correnteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Runnable t = () -> {
                    n.selecao(2);
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
