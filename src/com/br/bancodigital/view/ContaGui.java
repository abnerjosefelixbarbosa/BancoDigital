package com.br.bancodigital.view;

import com.br.bancodigital.model.Conta;
import com.br.bancodigital.model.ContaModel;
import com.br.bancodigital.model.Corrente;
import com.br.bancodigital.model.Popanca;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class ContaGui extends JFrame {
    private JPanel panel1;
    private JFormattedTextField agencia;
    private JFormattedTextField conta;
    private JButton confirmarButton;
    private int contaOpcao;
    private Conta p = new Popanca();
    private Conta c = new Corrente();
    private ContaModel cm = new ContaModel();

    public ContaGui(int contaOpcao) {
        setContentPane(panel1);
        setTitle("ContaTela");
        setSize(1900,1000);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        setVisible(true);
        this.contaOpcao = contaOpcao;
        mascara();
        acaoButao();
    }

    private void acaoButao() {
        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    Runnable t = () -> {
                        try {
                            if (contaOpcao == 1) {
                                p.setAgenciaConta(agencia.getText());
                                p.setNumerroConta(conta.getText());
                                Conta k = cm.procuraConta(p);

                                if (k != null) {
                                    new OperacoesGui(k);
                                    dispose();
                                } else {
                                    JOptionPane.showMessageDialog(null,"Conta inexistente!");
                                }
                            } else {
                                c.setAgenciaConta(agencia.getText());
                                c.setNumerroConta(conta.getText());
                                Conta k = cm.procuraConta(c);

                                if (k != null) {
                                    new OperacoesGui(k);
                                    dispose();
                                } else {
                                    JOptionPane.showMessageDialog(null,"Conta inexistente!");
                                }
                            }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",0);
                        }
                    };

                    t.run();
            }
        });
    }

    private void mascara() {
        if (contaOpcao == 1) {
            try {
                MaskFormatter agencia = new MaskFormatter("####");
                MaskFormatter conta = new MaskFormatter("####-#");
                agencia.install(this.agencia);
                conta.install(this.conta);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",0);
            }
        } else {
            try {
                MaskFormatter agencia = new MaskFormatter("####");
                MaskFormatter conta = new MaskFormatter("######-#");
                agencia.install(this.agencia);
                conta.install(this.conta);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",0);
            }
        }
    }

    public static void main(String[] args) {
        new ContaGui(0);
    }
}
