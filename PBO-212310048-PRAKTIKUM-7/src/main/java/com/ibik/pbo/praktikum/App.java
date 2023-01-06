package com.ibik.pbo.praktikum;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class App extends JFrame implements ActionListener {

    private JButton btn_lat1, btn_lat2, btn_lat3, btn_lat4;

    App() {
        setTitle("Main Menu Latihan");
        setVisible(true);
        setSize(300, 120);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GenerateMenuButton(this);
    }

    public static void main(String[] args) {
        new App();
    }

    public void GenerateMenuButton(JFrame frame) {
        JPanel upperPanel = new JPanel();
        btn_lat1 = new JButton("Latihan 01");
        btn_lat2 = new JButton("Latihan 02");

        upperPanel.add(btn_lat1);
        upperPanel.add(btn_lat2);

        JPanel bottomPanel = new JPanel();
        btn_lat3 = new JButton("Latihan 03");
        btn_lat4 = new JButton("Latihan 04");

        bottomPanel.add(btn_lat3);
        bottomPanel.add(btn_lat4);

        frame.add(upperPanel, BorderLayout.NORTH);
        frame.add(bottomPanel, BorderLayout.SOUTH);
        
        btn_lat1.addActionListener(this);
        btn_lat2.addActionListener(this);
        btn_lat3.addActionListener(this);
        btn_lat4.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn_lat1) {
            Latihan01.main(null);
        } else if(e.getSource() == btn_lat2) {
            Latihan02.main(null);
        } else if(e.getSource() == btn_lat3) {
            Latihan03.main(null);
        } else if(e.getSource() == btn_lat4) {
            Latihan04.main(null);
        }
    }
}