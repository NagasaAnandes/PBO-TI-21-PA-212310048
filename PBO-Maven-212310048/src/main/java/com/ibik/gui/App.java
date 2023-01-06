package com.ibik.gui;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.WindowConstants;

public class App extends JFrame{
	App(){
		//Initialisasi object frame
		JFrame frame = new JFrame();
		
		//Menampilkan jendela pada layar
		frame.setVisible(true);
		
		//berfungsi dengan method setSize hanya saja method pack secara default akan menyesuaikan dengan komponen komponen
		frame.pack();
		
		//Menentukan posisi jendela pada layar tengah
		frame.setLocationRelativeTo(null);
		
		//Mnentukan ukuran width dan height pada jendela
		frame.setSize(300, 300);
		
		//Memberikan Judul
		frame.setTitle("Window Frame");
		
		//Menutup jendela secara penuh
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		GenerateUI2(frame);
	}

	public static void main(String[] args) {
		new App();
	}
	
	private void GenerateUI(JFrame frame) {
		//initialisasi tombol
		JButton button1 = new JButton("1");
		JButton button2 = new JButton("2");
		JButton button3 = new JButton("3");
		JButton button4 = new JButton("4");
		
		//Menambahkan Komponen tombol
		frame.add(button1);
		frame.add(button2);
		frame.add(button3);
		frame.add(button4);
		
		//Mengatur Letak Align pada Flow Layout 
		
		//Tengah Atas Layar
		//frame.setLayout(new FlowLayout());
		//frame.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		//Kanan Layar
		//frame.setLayout(new FlowLayout(FlowLayout.RIGHT));
		//frame.setLayout(new FlowLayout(FlowLayout.TRAILING));
		
		//Kiri Layar
		//frame.setLayout(new FlowLayout(FlowLayout.LEFT));
		//frame.setLayout(new FlowLayout(FlowLayout.LEADING));
	}
	
	private void GenerateUI2(JFrame frame) {
		//Atas Layar
		JButton button5 = new JButton("North");
		//Bawah Layar
		JButton button6 = new JButton("South");
		//Kanan Layar
		JButton button7 = new JButton("East");
		//Kiri Layar
		JButton button8 = new JButton("West");
		//Tengah Layar
		JButton button9 = new JButton();
		button9.setIcon(new ImageIcon("C:\\Users\\Nagasa Anandes\\Downloads\\Bukan Sampah\\valo.png"));
		button9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Anda Baru Saja Mengklik tombol");
			}
		});
		
		//Menambahkan komponen tombol ke frame
		BorderLayout bl = new BorderLayout();
		frame.add(button5, bl.NORTH);
		frame.add(button6, bl.SOUTH);
		frame.add(button7, bl.EAST);
		frame.add(button8, bl.WEST);
		frame.add(button9, bl.CENTER);
	}
	
	private void GenerateUI3(JFrame frame) {
		JPanel panelBtnNum = new JPanel();
		panelBtnNum.setLayout(new GridLayout(2, 2));
		JButton buttons[] = new JButton[4];
		for (int i=0; i<buttons.length; i++) {
			buttons[i] = new JButton(String.valueOf(i));
			panelBtnNum.add(buttons[i]);
		}
	}
}
