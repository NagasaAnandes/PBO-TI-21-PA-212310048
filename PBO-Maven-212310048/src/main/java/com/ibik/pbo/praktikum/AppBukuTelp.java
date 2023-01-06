package com.ibik.pbo.praktikum;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class AppBukuTelp {
    
    public static ArrayList<String> table_header;

    public static void main(String[] args) {
        AppBukuTelp mainApps = new AppBukuTelp();

        table_header = new ArrayList<String>();
        table_header.add("Nama Lengkap");
        table_header.add("Alamat");
        table_header.add("No. Telp");
        
        ArrayList<ArrayList<String>> data_table = new ArrayList<ArrayList<String>>();

        for(int i = 0; i < table_header.size(); i++) {
            data_table.add(new ArrayList<String>());
            for(int j = 0; j < table_header.size(); j++) {
                String values = JOptionPane.showInputDialog(null,
                                "Masukkan " + table_header.get(j) + ":",
                                "Data ke - " + i,
                                JOptionPane.QUESTION_MESSAGE);
                data_table.get(i).add(j, values);
            }
        }

        String output_data_table = mainApps.PrintValues(data_table);

        JOptionPane.showMessageDialog(null, output_data_table, "Output Data", JOptionPane.INFORMATION_MESSAGE);
    }

    private String PrintValues(ArrayList<ArrayList<String>> val) {
        String output = "";
        for(int i = 0; i < val.size(); i++) {
            for(int j = 0; j < val.size(); j++) {
                output += table_header.get(j) + ": " + val.get(i).get(j) + "\n";
            }
            output += "\n";
        }
        return output;
    }

}