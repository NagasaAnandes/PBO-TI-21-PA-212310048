package com.ibik.pbo.praktikum;

import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
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
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class FormPage extends JFrame {
    public FormPage() {
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
        setSize(1000, 480);
        setTitle("Form");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GenerateUI(this);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FormPage();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void GenerateUI(FormPage frame) {
        // Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu helpMenu = new JMenu("Help");

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        JMenuItem item1 = new JMenuItem("Open Student Data");
        JMenuItem item3 = new JMenuItem("Exit");

        fileMenu.add(item1);
        fileMenu.add(item3);

        frame.setJMenuBar(menuBar);

        // Main Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        frame.setContentPane(mainPanel);

        // Header Title
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        JLabel headerTitle = new JLabel("FORM PENILAIAN MATAKULIAH PBO");
        headerTitle.setFont(new Font("Arial", Font.PLAIN, 30));
        headerPanel.add(headerTitle);

        // Start of Form
        Border lftPanelBorder = BorderFactory.createTitledBorder("Input Data Mahasiswa");
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(null);
        leftPanel.setPreferredSize(new Dimension(480, 480));
        mainPanel.add(leftPanel, BorderLayout.WEST);
        // Start of Panel Content

        // // Input NPM
        JLabel npmLabel = new JLabel("NPM");
        npmLabel.setBounds(22, 40, 80, 30);
        leftPanel.add(npmLabel);

        final JTextField inputNPM = new JTextField();
        inputNPM.setBounds(22, 80, 400, 30);
        leftPanel.add(inputNPM);

        // // Input Nama
        JLabel namaLabel = new JLabel("Nama");
        namaLabel.setBounds(22, 120, 80, 30);
        leftPanel.add(namaLabel);

        final JTextField inputNama = new JTextField();
        inputNama.setBounds(22, 160, 400, 30);
        leftPanel.add(inputNama);

        // // Input Nilai
        JLabel gradeLabel = new JLabel("Nilai");
        gradeLabel.setBounds(22, 200, 80, 30);
        leftPanel.add(gradeLabel);

        final JRadioButton gradeA = new JRadioButton("A");
        gradeA.setBounds(25, 240, 50, 30);
        leftPanel.add(gradeA);

        final JRadioButton gradeB = new JRadioButton("B");
        gradeB.setBounds(100, 240, 50, 30);
        leftPanel.add(gradeB);

        final JRadioButton gradeC = new JRadioButton("C");
        gradeC.setBounds(175, 240, 50, 30);
        leftPanel.add(gradeC);

        final JRadioButton gradeD = new JRadioButton("D");
        gradeD.setBounds(250, 240, 50, 30);
        leftPanel.add(gradeD);

        final JRadioButton gradeE = new JRadioButton("E");
        gradeE.setBounds(325, 240, 50, 30);
        leftPanel.add(gradeE);

        final JRadioButton gradeF = new JRadioButton("F");
        gradeF.setBounds(400, 240, 50, 30);
        leftPanel.add(gradeF);

        ButtonGroup bg = new ButtonGroup();
        bg.add(gradeA);
        bg.add(gradeB);
        bg.add(gradeC);
        bg.add(gradeD);
        bg.add(gradeE);
        bg.add(gradeF);

        // // Button CRUD Data
        JButton btnSave = new JButton("Save");
        btnSave.setBounds(25, 280, 100, 30);
        ActionListener actionSave = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Students student = new Students();

                if (!inputNPM.getText().isEmpty()) {
                    student.setNpm(inputNPM.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "Data tidak boleh kosong! (NPM)", "Alert!",
                            JOptionPane.ERROR_MESSAGE);
                }

                if (!inputNama.getText().isEmpty()) {
                    student.setFullname(inputNama.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "Data tidak boleh kosong! (Nama)", "Alert!",
                            JOptionPane.ERROR_MESSAGE);
                }

                if (gradeA.isSelected()) {
                    student.setScore(gradeA.getText());
                } else if (gradeB.isSelected()) {
                    student.setScore(gradeB.getText());
                } else if (gradeC.isSelected()) {
                    student.setScore(gradeC.getText());
                } else if (gradeD.isSelected()) {
                    student.setScore(gradeD.getText());
                } else if (gradeE.isSelected()) {
                    student.setScore(gradeE.getText());
                } else if (gradeF.isSelected()) {
                    student.setScore(gradeF.getText());
                }

                StudentsDAO stdDAO = new StudentsDAO();
                try {
                    stdDAO.saved(student);
                    JOptionPane.showMessageDialog(null, "Successfully Added!", "Score Board",
                            JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    JOptionPane.showMessageDialog(null, "Error: " + e1.getMessage());
                    e1.printStackTrace();
                }
            }
        };
        btnSave.addActionListener(actionSave);
        leftPanel.add(btnSave);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setBounds(175, 280, 100, 30);
        leftPanel.add(btnDelete);

        JButton btnClear = new JButton("Clear");
        btnClear.setBounds(325, 280, 100, 30);
        leftPanel.add(btnClear);
        // End of Panel Content
        leftPanel.setBorder(lftPanelBorder);
        // End of Form

        // Table
        Border rPanelBorder = BorderFactory.createTitledBorder("Data Mahasiswa");
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        mainPanel.add(rightPanel, BorderLayout.EAST);

        DefaultTableModel tableModel = FetchDataSelect();
        final JTable jt = new JTable(tableModel) {
            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };
        jt.setBounds(22, 40, 480, 450);
        jt.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DefaultTableModel jtModel = (DefaultTableModel) jt.getModel();
                int selectedRow = jt.getSelectedRow();
                System.out.println("You just click row " + selectedRow);
                String npm = jtModel.getValueAt(selectedRow,
                        0).toString();
                String name = jtModel.getValueAt(selectedRow,
                        1).toString();
                String score = jtModel.getValueAt(selectedRow, 2).toString();
                System.out.println("Data:");
                System.out.println("NPM: " + npm);
                System.out.println("Fullname: " + name);
                System.out.println("Score: " + score);
            }
        });
        JScrollPane sp = new JScrollPane(jt);

        rightPanel.add(sp);

        rightPanel.setBorder(rPanelBorder);
    }

    public DefaultTableModel FetchDataSelect() {

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("NPM");
        tableModel.addColumn("Nama");
        tableModel.addColumn("Nilai");
        StudentsDAO stdDao = new StudentsDAO();

        try {
            List<Students> students = stdDao.findAll();
            for (int i = 0; i < students.size(); i++) {
                String data[] = {
                        students.get(i).getNpm(),
                        students.get(i).getFullname(),
                        students.get(i).getScore()
                };
                tableModel.addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Alert!", JOptionPane.ERROR_MESSAGE);
        }

        return tableModel;
    }
}