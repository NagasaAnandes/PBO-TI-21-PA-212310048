package com.ibik.pbo.praktikum.games;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class KeyListenerGames extends JFrame implements KeyListener {

    private JLabel lbl_img;
    private ImageIcon icon_rocket_up, icon_rocket_down, icon_rocket_right, icon_rocket_left;

    private String images_path = "com/ibik/pbo/praktikum/images/";
    private URL m_right, m_up, m_down, m_left;
    
    KeyListenerGames() {
        setTitle("Rocket Launcher");
        setSize(512, 256);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        GenerateGamesUI(this);
        setResizable(false);
    }

    public static void main(String[] args) {
        new KeyListenerGames();
    }

    private void GenerateGamesUI(KeyListenerGames frame) {
        // Initialize URL attribute for images folder path
        m_up = KeyListenerGames.class.getClassLoader().getResource(images_path + "rocket_up.png");
        m_down =  KeyListenerGames.class.getClassLoader().getResource(images_path + "rocket_down.png");
        m_left = KeyListenerGames.class.getClassLoader().getResource(images_path + "rocket_left.png");
        m_right = KeyListenerGames.class.getClassLoader().getResource(images_path + "rocket_right.png");

        // Initialize icon
        icon_rocket_up = new ImageIcon(m_up);
        icon_rocket_down = new ImageIcon(m_down);
        icon_rocket_left = new ImageIcon(m_left);
        icon_rocket_right = new ImageIcon(m_right);
        
        lbl_img = new JLabel();
        lbl_img.setBounds(100, 100, 128, 128);
        lbl_img.setIcon(icon_rocket_right);

        frame.add(lbl_img);
        frame.addKeyListener(frame);
        frame.getContentPane().setBackground(Color.CYAN);
    }

    // Method for checking if the X axis of lbl_img is out of bounds
    private void IsIconXAxisOutOfBounds() {
        if(lbl_img.getX() == 440 || lbl_img.getX() == 450) {
            lbl_img.setLocation(-60, lbl_img.getY());
        } else if(lbl_img.getX() == -60 || lbl_img.getX() == -70){
            lbl_img.setLocation(440, lbl_img.getY());
        }
    }
    
    // Method for checking if the Y axis of lbl_img is out of bounds
    private void IsIconYAxisOutOfBounds() {
        if(lbl_img.getY() == 150 || lbl_img.getY() == 160) {
            lbl_img.setLocation(lbl_img.getX(), -60);
        } else if(lbl_img.getY() == -60 || lbl_img.getY() == -70){
            lbl_img.setLocation(lbl_img.getX(), 150);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        switch(e.getKeyChar()) {
            case 'a':
                lbl_img.setLocation(lbl_img.getX()-10, lbl_img.getY());
                lbl_img.setIcon(icon_rocket_left);
                IsIconXAxisOutOfBounds();
            break;
            case 'w':
                lbl_img.setLocation(lbl_img.getX(), lbl_img.getY()-10);
                lbl_img.setIcon(icon_rocket_up);
                IsIconYAxisOutOfBounds();
            break;
            case 's':
                lbl_img.setLocation(lbl_img.getX(), lbl_img.getY()+10);
                lbl_img.setIcon(icon_rocket_down);
                IsIconYAxisOutOfBounds();
            break;
            case 'd':
                lbl_img.setLocation(lbl_img.getX()+10, lbl_img.getY());
                lbl_img.setIcon(icon_rocket_right);
                IsIconXAxisOutOfBounds();
            break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case 37:
                lbl_img.setLocation(lbl_img.getX()-10, lbl_img.getY());
                lbl_img.setIcon(icon_rocket_left);
                IsIconXAxisOutOfBounds();
            break;
            case 38:
                lbl_img.setLocation(lbl_img.getX(), lbl_img.getY()-10);
                lbl_img.setIcon(icon_rocket_up);
                IsIconYAxisOutOfBounds();
            break;
            case 40:
                lbl_img.setLocation(lbl_img.getX(), lbl_img.getY()+10);
                lbl_img.setIcon(icon_rocket_down);
                IsIconYAxisOutOfBounds();
            break;
            case 39:
                lbl_img.setLocation(lbl_img.getX()+10, lbl_img.getY());
                lbl_img.setIcon(icon_rocket_right);
                IsIconXAxisOutOfBounds();
            break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

}