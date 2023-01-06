package com.ibik.pbo.praktikum.games;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TicTacToe extends JFrame {
    
    private AbstractButton evtSource;
    private JButton[] buttons;
    private int xScore = 0;
    private int oScore = 0;
    private int clicked = 0;

    TicTacToe() {
        setTitle("Tic Tac Toe");
        setVisible(true);
        setSize(512, 512);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GenerateButtonUI(this);
        setResizable(false);
    }

    public static void main(String[] args) {
        new TicTacToe();
    }

    private void GenerateButtonUI(TicTacToe frame) {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        frame.setContentPane(mainPanel);

        JPanel scorePanel = new JPanel();
        scorePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.add(scorePanel, BorderLayout.NORTH);

        JLabel lbl_score = new JLabel("Score X: " + xScore + " | O: " + oScore);
        lbl_score.setFont(new Font("Arial", Font.BOLD, 16));
        lbl_score.setSize(300, 20);
        scorePanel.add(lbl_score);

        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(3, 3));
        mainPanel.add(gamePanel);

        buttons = new JButton[10];
        for(int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            gamePanel.add(buttons[i]);
        }

        for(int i = 0; i < 9; i++) {
            buttons[i].addMouseListener(new MouseListener() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    evtSource = (AbstractButton) e.getSource();

                    if(clicked % 2 == 0) {
                        evtSource.setText("O");
                    } else {
                        evtSource.setText("X");
                    }

                    clicked++;
                    CheckWinner();
                }

                @Override
                public void mousePressed(MouseEvent e) {}

                @Override
                public void mouseReleased(MouseEvent e) {}

                @Override
                public void mouseEntered(MouseEvent e) {}

                @Override
                public void mouseExited(MouseEvent e) {}
                
            });
        }
    }

    private void CheckWinner() {
        String output = "";

        // Rows
        if(IsButtonFirstRowEquals()) {
            output += buttons[0].getText();
        } else if(IsButtonSecondRowEquals()) {
            output += buttons[3].getText();
        } else if(IsButtonThirdRowEquals()) {
            output += buttons[6].getText();
        }

        // Columns
        if(IsButtonFirstColumnEquals()) {
            output += buttons[0].getText();
        } else if(IsButtonSecondColumnEquals()) {
            output += buttons[1].getText();
        } else if(IsButtonThirdColumnEquals()) {
            output += buttons[2].getText();
        }

        // Zigzag
        if(IsButtonLeftZigzagEquals()) {
            output += buttons[0].getText();
        } else if(IsButtonRightZigzagEquals()) {
            output += buttons[2].getText();
        }

        if(output.length() > 0) {
            JOptionPane.showMessageDialog(null, output + " got point 1");
        }
        
    }

    // Check Rows
    private Boolean IsButtonFirstRowEquals() {
        return (
            (buttons[0].getText().equals(buttons[1].getText()) && buttons[1].getText().equals(buttons[2].getText()))
        );
    }
    private Boolean IsButtonSecondRowEquals() {
        return (
            buttons[3].getText().equals(buttons[4].getText()) && buttons[4].getText().equals(buttons[5].getText())
        );
    }
    private Boolean IsButtonThirdRowEquals() {
        return (
            buttons[6].getText().equals(buttons[7].getText()) && buttons[7].getText().equals(buttons[8].getText())
        );
    }

    // Check Columns
    private Boolean IsButtonFirstColumnEquals() {
        return (
            (buttons[0].getText().equals(buttons[3].getText()) && buttons[3].getText().equals(buttons[6].getText()))
        );
    }
    private Boolean IsButtonSecondColumnEquals() {
        return (
            buttons[1].getText().equals(buttons[4].getText()) && buttons[4].getText().equals(buttons[7].getText())
        );
    }
    private Boolean IsButtonThirdColumnEquals() {
        return (
            buttons[2].getText().equals(buttons[5].getText()) && buttons[5].getText().equals(buttons[8].getText())
        );
    }

    // Check Zigzag
    private Boolean IsButtonLeftZigzagEquals() {
        return (
            buttons[0].getText().equals(buttons[4].getText()) && buttons[4].getText().equals(buttons[8].getText())
        );
    }
    private Boolean IsButtonRightZigzagEquals() {
        return (
            buttons[2].getText().equals(buttons[4].getText()) && buttons[4].getText().equals(buttons[6].getText())
        );
    }

}