package com.ibik.pbo.praktikum;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Latihan02 extends JFrame {
    
    private JButton btn_submit;
    private JComboBox<String> selectCountry;
    private JRadioButton gender_female, gender_male;
    private JTextField txt_phone, txt_email, txt_fullname;
    private ButtonGroup gender_group;
    private final String[] country = {"Indonesia", "Malaysia", "USA", "England", "German",
                                      "Netherland", "Japan", "Saudi Arabia", "Qatar", "Singapore"};

    Latihan02() {
        setTitle("Latihan 02");
        setVisible(true);
        pack();
        setSize(300, 350);
        setLocationRelativeTo(null);
        setLayout(null);
        GenerateForm(this);
        setResizable(false);
    }

    public static void main(String[] args) {
        new Latihan02();
    }

    private void GenerateForm(Latihan02 frame) {
        JLabel label_fullname = new JLabel("Fullname");
        txt_fullname = new JTextField();
        label_fullname.setBounds(20, 20, 80, 20);
        txt_fullname.setBounds(100, 20, 160, 25);

        frame.add(label_fullname);
        frame.add(txt_fullname);

        JLabel label_email = new JLabel("Email");
        txt_email = new JTextField();
        label_email.setBounds(20, 60, 80, 20);
        txt_email.setBounds(100, 60, 160, 25);
        
        frame.add(label_email);
        frame.add(txt_email);

        JLabel label_phone = new JLabel("Phone");
        txt_phone = new JTextField();
        label_phone.setBounds(20, 100, 80, 20);
        txt_phone.setBounds(100, 100, 160, 25);

        frame.add(label_phone);
        frame.add(txt_phone);

        JLabel label_gender = new JLabel("Gender");
        label_gender.setBounds(20, 140, 80, 20);
        frame.add(label_gender);
        
        gender_male = new JRadioButton("Pria");
        gender_female = new JRadioButton("Wanita");
        gender_male.setBounds(100, 140, 80, 20);
        gender_female.setBounds(180, 140, 80, 20);
        
        gender_group = new ButtonGroup();
        gender_group.add(gender_male); gender_group.add(gender_female);

        frame.add(gender_male); frame.add(gender_female); 

        JLabel label_citizenship = new JLabel("Citizenship");
        label_citizenship.setBounds(20, 180, 80, 20);
        frame.add(label_citizenship);

        selectCountry = new JComboBox<String>(country);
        selectCountry.setBounds(100, 180, 160, 25);
        frame.add(selectCountry);

        btn_submit = new JButton("SUBMIT");
        btn_submit.setBounds(100, 220, 160, 40);
        frame.add(btn_submit);

        Submit(this);
    }

    private void Submit(Latihan02 val) {
        btn_submit.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txt_fullname.getText().isEmpty() || txt_email.getText().isEmpty() || txt_phone.getText().isEmpty() || (!gender_male.isSelected() && !gender_female.isSelected())) {
                    JOptionPane.showMessageDialog(null,"Isi data dengan benar!", "PERINGATAN", JOptionPane.WARNING_MESSAGE);
                } else {
                    if(e.getSource() == btn_submit) {
                        String output = "Biodata: \n\n";
                        String outputKelamin = "";
    
                        if(gender_male.isSelected()) {
                            outputKelamin = gender_male.getText();
                            output += "Nama Lengkap: " + txt_fullname.getText() + "\n"
                                + "Email: " + txt_email.getText() + "\n"
                                + "No. Telp: " + txt_phone.getText() + "\n"
                                + "Jenis Kelamin: " + outputKelamin + "\n"
                                + "Kebangsaan: " + selectCountry.getSelectedItem();
                        } else {
                            outputKelamin = gender_female.getText();
                            output += "Nama Lengkap: " + txt_fullname.getText() + "\n"
                                + "Email: " + txt_email.getText() + "\n"
                                + "No. Telp: " + txt_phone.getText() + "\n"
                                + "Jenis Kelamin: " + outputKelamin + "\n"
                                + "Kebangsaan: " + selectCountry.getSelectedItem();
                        }
    
                        JOptionPane.showMessageDialog(null, output);
                    }
                }
            }
            
        });
    }

}