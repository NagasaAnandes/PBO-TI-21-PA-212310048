package com.ibik.pbo.praktikum;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Latihan01 extends JFrame implements ActionListener {

    private JButton btn_1, btn_2, btn_ibik;

    Latihan01() {
        setTitle("Latihan 01");
        setVisible(true);
        pack();
        setSize(300, 120);
        setLocationRelativeTo(null);
        GenerateMenuButton(this);
    }

    public static void main(String[] args) {
        new Latihan01();
    }

    public void GenerateMenuButton(JFrame frame) {
        JPanel upperPanel = new JPanel();
        btn_1 = new JButton("こんにちは");
        btn_2 = new JButton("Sugeng rawuh");

        upperPanel.add(btn_1);
        upperPanel.add(btn_2);

        JPanel bottomPanel = new JPanel();
        btn_ibik = new JButton("IBIK");
        
        bottomPanel.add(btn_ibik);
        
        frame.add(upperPanel, BorderLayout.NORTH);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        btn_1.addActionListener(this);
        btn_2.addActionListener(this);
        btn_ibik.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn_1) {
            JOptionPane.showMessageDialog(null, "こんにちは / Kon'nichiwa is a word that means 'Hello'");
        } else if(e.getSource() == btn_2) {
            JOptionPane.showMessageDialog(null, "Sugeng rawuh is a word that means 'Welcome'");
        } else if(e.getSource() == btn_ibik) {
            JOptionPane.showMessageDialog(null, "IBIK is a university in the city of Bogor");
        }
    }
}