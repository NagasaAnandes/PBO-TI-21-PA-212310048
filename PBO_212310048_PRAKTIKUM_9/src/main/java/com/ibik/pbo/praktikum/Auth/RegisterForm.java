package com.ibik.pbo.praktikum.Auth;

import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RegisterForm extends JFrame {
    public RegisterForm() {
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
        setSize(500, 500);
        setTitle("Register Form");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GenerateUI(this);
    }

    public static void main(String[] args) {
        new RegisterForm();
    }

    private void GenerateUI(RegisterForm frame) {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        frame.setContentPane(mainPanel);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        mainPanel.add(panel1, BorderLayout.NORTH);

        JLabel lblFullName = new JLabel("Fullname");
        lblFullName.setBounds(22, 23, 80, 16);

        panel1.add(lblFullName);

        final JTextField textFullName = new JTextField();
        textFullName.setBounds(105, 18, 169, 30);
        textFullName.setEditable(true);
        panel1.add(textFullName);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(22, 69, 61, 16);
        panel1.add(lblEmail);

        final JTextField textEmail = new JTextField();
        textEmail.setBounds(105, 64, 169, 30);
        panel1.add(textEmail);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(22, 109, 61, 16);
        panel1.add(lblPassword);

        final JPasswordField textPassword = new JPasswordField();
        textPassword.setBounds(105, 104, 169, 30);
        panel1.add(textPassword);

        JLabel lblRePassword = new JLabel("Conf. Password");
        lblRePassword.setBounds(22, 149, 61, 16);
        panel1.add(lblRePassword);

        final JPasswordField textRePassword = new JPasswordField();
        textRePassword.setBounds(105, 144, 169, 30);
        panel1.add(textRePassword);

        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setBounds(22, 189, 61, 16);
        panel1.add(lblPhone);

        final JTextField txtPhone = new JTextField();
        txtPhone.setBounds(105, 184, 169, 30);
        panel1.add(txtPhone);

        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(22, 240, 61, 16);
        panel1.add(lblGender);

        final JRadioButton radioGender1 = new JRadioButton("Female");
        radioGender1.setBounds(105, 235, 100, 30);
        panel1.add(radioGender1);

        final JRadioButton radioGender2 = new JRadioButton("Male");
        radioGender2.setBounds(200, 235, 100, 30);
        panel1.add(radioGender2);

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioGender1);
        bg.add(radioGender2);

        JLabel lblCityzen = new JLabel("Citizenship");
        lblCityzen.setBounds(22, 280, 100, 16);
        panel1.add(lblCityzen);

        String country[] = {
                "Indonesia",
                "India",
                "Australia",
                "U.S.A",
                "England",
                "New Zealand"
        };

        final JComboBox selectCitizen = new JComboBox<>(country);
        selectCitizen.setBounds(105, 275, 169, 30);
        panel1.add(selectCitizen);

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(105, 345, 169, 40);
        ActionListener actionSubmit = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // ArrayList<String> data = new ArrayList<String>();
                Admin admins = new Admin();

                if (!textFullName.getText().isEmpty()) {
                    // data.add(textFullName.getText());
                    admins.setFullname(textFullName.getText());
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Data tidak boleh kosong (Nama Kosong). Silakan periksa kembali isian anda.",
                            "Alert!", JOptionPane.ERROR_MESSAGE);
                }

                if (!textEmail.getText().isEmpty()) {
                    // data.add(textEmail.getText());
                    admins.setEmail(textEmail.getText());
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Data tidak boleh kosong (Email Kosong). Silakan periksa kembali isian anda.",
                            "Alert!", JOptionPane.ERROR_MESSAGE);
                }

                String passText = new String(textPassword.getPassword());
                String confPass = new String(textRePassword.getPassword());

                if (!passText.isEmpty()) {
                    if (!passText.equals(confPass)) {
                        JOptionPane.showMessageDialog(null,
                                "Password tidak sesuai.\nHarap periksa kembali Password dan Conf. Password", "Alert!",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        admins.setPassword(passText);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Kolom Password harus diisi", "Alert!",
                            JOptionPane.ERROR_MESSAGE);
                }

                if (!txtPhone.getText().isEmpty()) {
                    // data.add(txtPhone.getText());
                    admins.setPhone(txtPhone.getText());
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Data tidak boleh kosong (No. Telepon Kosong). Silakan periksa kembali isian anda.",
                            "Alert!", JOptionPane.ERROR_MESSAGE);
                }

                if (radioGender1.isSelected()) {
                    // data.add(radioGender1.getText());
                    admins.setGender("F");
                } else if (radioGender2.isSelected()) {
                    // data.add(radioGender2.getText());
                    admins.setGender("M");
                }

                // data.add(selectCitizen.getSelectedItem().toString());
                admins.setCitizenship(selectCitizen.getSelectedItem().toString());

                RegisterDAO regDAO = new RegisterDAO();
                try {
                    regDAO.savedRegister(admins);
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    JOptionPane.showMessageDialog(null, "Error : " + e1.getMessage());
                    e1.printStackTrace();
                }


                LoginForm loginPage = new LoginForm();
                loginPage.setVisible(true);
                dispose();
            }
        };
        btnSubmit.addActionListener(actionSubmit);
        panel1.add(btnSubmit);

        frame.add(panel1);
    }
}