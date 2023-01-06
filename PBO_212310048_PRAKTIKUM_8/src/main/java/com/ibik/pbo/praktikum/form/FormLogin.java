package com.ibik.pbo.praktikum.form;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class FormLogin extends JFrame implements ActionListener {
    
    private JTextField txt_email;
    private JPasswordField pass_password;
    private JButton btn_register, btn_login;

    private final String email = "rayyanpratama30@gmail.com";
    private final String pass = "212310034";

    public FormLogin() {
        setTitle("Login");
        setSize(375, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GenerateFormUI(this);
        setResizable(false);
    }

    public static void main(String[] args) {
        new FormLogin();
    }

    private void GenerateFormUI(FormLogin frame) {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        frame.setContentPane(mainPanel);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        frame.add(formPanel, BorderLayout.CENTER);

        JLabel lbl_email = new JLabel("Email");
        lbl_email.setBounds(40, 30, 100, 20);
        formPanel.add(lbl_email);

        txt_email = new JTextField();
        txt_email.setBounds(135, 30 , 180, 23);
        formPanel.add(txt_email);

        JLabel lbl_password = new JLabel("Password");
        lbl_password.setBounds(40, 80, 100, 20);
        formPanel.add(lbl_password);

        pass_password = new JPasswordField();
        pass_password.setBounds(135, 80 , 180, 23);
        formPanel.add(pass_password);

        JCheckBox remember = new JCheckBox("Remeber Password?");
        remember.setBounds(130, 110, 250, 30);
        formPanel.add(remember);

        btn_register = new JButton("Register");
        btn_register.setBounds(130, 155, 85, 40);
        formPanel.add(btn_register);

        btn_login = new JButton("Login");
        btn_login.setBounds(225, 155, 85, 40);
        formPanel.add(btn_login);

        JPanel copyrightPanel = new JPanel();
        copyrightPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        mainPanel.add(copyrightPanel, BorderLayout.SOUTH);

        JLabel copyright = new JLabel("Copyright IBIK @ 2023");
        copyright.setFont(new Font("Arial", Font.BOLD, 12));
        copyrightPanel.add(copyright);

        btn_register.addActionListener(this); btn_login.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn_register) {
            new FormRegister().setVisible(true);
        } else if(e.getSource() == btn_login) {
            if(IsTextEmpty()) {
                JOptionPane.showMessageDialog(null, "Isi data dengan benar!", "PERINGATAN", JOptionPane.ERROR_MESSAGE);
            } else if(IsDataValid()){
                JOptionPane.showMessageDialog(null, "Selamat Datang Asisten Dosen PBO", "Data Ditemukan", JOptionPane.INFORMATION_MESSAGE);
                new AppNilaiPBO().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Ada kesalahan pada email atau password!", "PERINGATAN", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private Boolean IsTextEmpty() {
        return (
            txt_email.getText().isEmpty() || new String(pass_password.getPassword()).isEmpty()
        );
    }

    private Boolean IsDataValid() {
        return (
            email.equals(txt_email.getText()) && pass.equals(String.valueOf(pass_password.getPassword()))
        );
    }
}