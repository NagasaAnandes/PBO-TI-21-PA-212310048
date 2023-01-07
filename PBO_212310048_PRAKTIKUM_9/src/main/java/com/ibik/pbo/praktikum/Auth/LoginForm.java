package com.ibik.pbo.praktikum.Auth;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import com.ibik.pbo.praktikum.FormPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    public LoginForm() {
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
        setSize(400, 400);
        setTitle("Login Page");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GenerateUI(this);
    }

    public static void main(String[] args) {
        new LoginForm();
    }

    private void GenerateUI(LoginForm frame) {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        frame.setContentPane(mainPanel);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        mainPanel.add(panel1, BorderLayout.NORTH);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(22, 23, 80, 16);
        panel1.add((lblEmail));

        final JTextField textEmail = new JTextField();
        textEmail.setBounds(105, 18, 169, 30);
        panel1.add(textEmail);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(22, 69, 61, 16);
        panel1.add(lblPassword);

        final JPasswordField textPassword = new JPasswordField();
        textPassword.setBounds(105, 64, 169, 30);
        panel1.add(textPassword);

        JCheckBox chkRemember = new JCheckBox("Remember Account ?");
        chkRemember.setBounds(105, 100, 169, 40);
        panel1.add(chkRemember);

        JButton btnRegister = new JButton("Register");
        btnRegister.setBounds(105, 150, 83, 40);
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterForm regPage = new RegisterForm();
                regPage.setVisible(true);
                dispose();
            }
        });
        panel1.add(btnRegister);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(205, 150, 83, 40);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mail = textEmail.getText();
                String password = new String(textPassword.getPassword());

                LoginDAO login = new LoginDAO();
                Admin adm = new Admin();
                try {
                    if (login.authLogin(mail, password)) {
                        JOptionPane.showMessageDialog(null, "Selamat Datang!", "Sukses!",
                                JOptionPane.INFORMATION_MESSAGE);

                        // Go To Form
                        FormPage form = new FormPage();
                        form.setVisible(true);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Login Gagal!", "Alert!", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    JOptionPane.showConfirmDialog(null, "Login Gagal. Error: " + e1.getMessage());
                    e1.printStackTrace();
                }
            }
        });
        panel1.add(btnLogin);

        JLabel lblCopyright = new JLabel("copyright IBIK @ 2022", SwingConstants.CENTER);
        lblCopyright.setBackground(Color.BLUE);
        lblCopyright.setSize(300, 50);
        mainPanel.add(lblCopyright, BorderLayout.SOUTH);

        frame.add(panel1);
    }
}