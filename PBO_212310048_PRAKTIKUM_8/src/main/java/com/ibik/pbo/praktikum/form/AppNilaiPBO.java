package com.ibik.pbo.praktikum.form;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class AppNilaiPBO extends JFrame implements ActionListener {

    private JButton btn_save, btn_delete, btn_clear;
    private JTextField txt_nama, txt_npm;
    private ButtonGroup group_nilai;
    private JRadioButton nilai_a, nilai_b, nilai_c, nilai_d, nilai_e, nilai_f;
    private JPanel mainPanel;
    private JTable mhs_table;

    AppNilaiPBO() {
        setTitle("AppNilaiPBO");
        setSize(800, 512);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GenerateUI(this);
    }

    public static void main(String[] args) {
        new AppNilaiPBO();        
    }

    private void GenerateUI(AppNilaiPBO frame) {
        GenerateMenuBar(this);
        GenerateForm(this);
        GenerateTable(this);
    }

    private void GenerateMenuBar(AppNilaiPBO frameMenu) {
        JMenuBar menuBar = new JMenuBar();

        String[] list_menu = {"File", "Edit", "Help"};
        String[] file_menu = {"New", "Save", "Exit"};

        JMenu[] menus = new JMenu[list_menu.length];
        for(int i = 0; i < list_menu.length; i++) {
            menus[i] = new JMenu();
            menus[i].setText(list_menu[i]);
            menuBar.add(menus[i]);
        }

        JMenuItem[] sub_file_menu = new JMenuItem[file_menu.length];
        for(int i = 0; i < file_menu.length; i++) {
            sub_file_menu[i] = new JMenuItem();
            sub_file_menu[i].setText(file_menu[i]);
            menus[0].add(sub_file_menu[i]);
        }

        frameMenu.setJMenuBar(menuBar);
    }

    private void GenerateForm(AppNilaiPBO frameForm) {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        frameForm.setContentPane(mainPanel);

        JPanel titlePanel = new JPanel();
        JLabel title = new JLabel("FORM PENILAIAN MATA KULIAH PBO");
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setSize(300, 30);

        titlePanel.add(title, new FlowLayout(FlowLayout.CENTER));
        mainPanel.add(titlePanel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        mainPanel.add(formPanel, BorderLayout.WEST);

        JLabel title_form = new JLabel("Form Mahasiswa");
        title_form.setFont(new Font("Arial", Font.BOLD, 20));
        title_form.setBounds(40, 40, 300, 20);
        
        formPanel.add(title_form, BorderLayout.WEST);

        JLabel label_npm = new JLabel("NPM");
        label_npm.setBounds(40, 80, 30, 10);
        formPanel.add(label_npm);

        txt_npm = new JTextField();
        txt_npm.setBounds(40, 100, 250, 35);
        formPanel.add(txt_npm);

        JLabel label_nama = new JLabel("NAMA");
        label_nama.setBounds(40, 160, 35, 10);
        formPanel.add(label_nama);

        txt_nama = new JTextField();
        txt_nama.setBounds(40, 180, 250, 35);
        formPanel.add(txt_nama);

        JLabel label_nilai = new JLabel("Nilai");
        label_nilai.setBounds(40, 240, 35, 10);
        formPanel.add(label_nilai);

        group_nilai = new ButtonGroup();
        nilai_a = new JRadioButton("A"); nilai_b = new JRadioButton("B");
        nilai_c = new JRadioButton("C"); nilai_d = new JRadioButton("D");
        nilai_e = new JRadioButton("E"); nilai_f = new JRadioButton("F");
        
        nilai_a.setBounds(40, 260, 35, 20); nilai_b.setBounds(80, 260, 35, 20);
        nilai_c.setBounds(120, 260, 35, 20); nilai_d.setBounds(180, 260, 35, 20);
        nilai_e.setBounds(220, 260, 35, 20); nilai_f.setBounds(260, 260, 35, 20);

        group_nilai.add(nilai_a); group_nilai.add(nilai_b);
        group_nilai.add(nilai_c); group_nilai.add(nilai_d);
        group_nilai.add(nilai_e); group_nilai.add(nilai_f);

        formPanel.add(nilai_a); formPanel.add(nilai_b);
        formPanel.add(nilai_c); formPanel.add(nilai_d);
        formPanel.add(nilai_e); formPanel.add(nilai_f);

        btn_save = new JButton("Save");
        btn_delete = new JButton("Delete");
        btn_clear = new JButton("Clear");

        btn_save.setBounds(40, 300, 85, 35);
        btn_delete.setBounds(130, 300, 85, 35);
        btn_clear.setBounds(220, 300, 85, 35);

        formPanel.add(btn_save);
        formPanel.add(btn_delete);
        formPanel.add(btn_clear);

        btn_clear.addActionListener(this);
        btn_delete.addActionListener(this);
        btn_save.addActionListener(this);

        frameForm.add(formPanel);
    }

    private void GenerateTable(AppNilaiPBO frameTable) {
        String[][] data = {
            {"212310048", "Nagasa Anandes", "A+"},
            {"212310035", "Adrian Adhari", "A-"},
            {"212310034", "Raden Rayyan", "A"}
        };
        String[] table_header = {"NPM", "NAMA", "NILAI"};

        mhs_table = new JTable(data, table_header);
        mhs_table.setBounds(40, 40, 200, 200);

        JScrollPane scroll_table = new JScrollPane(mhs_table);
        frameTable.add(scroll_table, BorderLayout.EAST);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn_clear) {
            txt_nama.setText("");
            txt_npm.setText("");
            group_nilai.clearSelection();
        } else if(e.getSource() == btn_delete) {
            JOptionPane.showMessageDialog(null, "Coming Soon!");
        } else if(e.getSource() == btn_save) {
            if(txt_npm.getText().isEmpty() || txt_nama.getText().isEmpty() || group_nilai.isSelected(null)) {
                JOptionPane.showMessageDialog(null, "Isi data dengan benar!");
            } else {
                JOptionPane.showMessageDialog(null, "Data berhasil disimpan!");
            }
        }
    }
}