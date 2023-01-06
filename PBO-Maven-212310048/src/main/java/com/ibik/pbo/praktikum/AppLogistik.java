package com.ibik.pbo.praktikum;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class AppLogistik {

    public static ArrayList<String> pesanan = new ArrayList<String>();
    public static AppLogistik mainApps = new AppLogistik();
    public static final String regex_angka = "[0-9]+";
    public static boolean is_exit = false;
    
    public static void main(String[] args) {
        String[] menus = {"Input Pesanan", "Lacak Pesanan"};
        String teks_menus = "Pilih menu di bawah ini:\n";

        for(int i = 0; i < menus.length; i++) {
            teks_menus += (i + 1) + ". " + menus[i] + "\n";
        }

        while(!is_exit) {
            String pilihan_menu = JOptionPane.showInputDialog(null, teks_menus, "Aplikasi PT. XYZ", JOptionPane.QUESTION_MESSAGE);
            
            if((pilihan_menu != null) && (pilihan_menu.matches(regex_angka))) {
                switch(Integer.parseInt(pilihan_menu)) {
                    case 1:
                        mainApps.InputPesanan();
                    break;

                    case 2:
                        mainApps.LacakPesanan();
                    break;

                    default:
                        JOptionPane.showMessageDialog(null, "Menu tidak ada!", "PERINGATAN", JOptionPane.ERROR_MESSAGE);
                }
            } else if((pilihan_menu != null) && (!pilihan_menu.matches(regex_angka))) {
                JOptionPane.showMessageDialog(null, "Inputan harus angka!", "PERINGATAN", JOptionPane.ERROR_MESSAGE);
            } else {
                mainApps.ExitApps("");
            }

        }
    }

    private void InputPesanan() {
        final String[] title_pesanan = {"Berat Barang (gr)", "Jarak Barang (km)"};
        boolean is_exit_input_pesanan = false;
        int i = 0;

        while(!is_exit_input_pesanan) {
            while(i < title_pesanan.length) {
                String values = JOptionPane.showInputDialog(null,
                                "Masukkan " + title_pesanan[i] + ":",
                                "Input " + title_pesanan[i],
                                JOptionPane.INFORMATION_MESSAGE);

                if((values != null) && (values.matches(regex_angka))) {
                    pesanan.add(values);
                    i++;
                    if(i == 2) { mainApps.CetakResi(); }
                } else if((values != null) && (!values.matches(regex_angka))) {
                    JOptionPane.showMessageDialog(null, "Inputan harus angka!", "PERINGATAN", JOptionPane.ERROR_MESSAGE);
                    i = 0;
                } else {
                    int pilihan = JOptionPane.showConfirmDialog(null, 
                                  "Apakah Anda ingin keluar ke menu utama?",
                                  "Konfirmasi",
                                  JOptionPane.YES_NO_OPTION,
                                  JOptionPane.WARNING_MESSAGE);

                    if(pilihan == JOptionPane.YES_OPTION) {
                        i = 2;
                        is_exit_input_pesanan = true;
                    } else {
                        is_exit_input_pesanan = false;
                        i = 0;
                    }

                }

            }
            is_exit_input_pesanan = true;
        }
    }

    private void LacakPesanan() {
        boolean is_exit_lacak_pesanan = false;
        int i = 0;

        if(pesanan.size() > i) {
            while(!is_exit_lacak_pesanan) {
                String input_resi = JOptionPane.showInputDialog(null, "Masukkan nomor resi");
                
                if((input_resi != null) && (input_resi.equals(pesanan.get(3)))) {
                    mainApps.CetakResi();
                    is_exit_lacak_pesanan = true;
                } else if((input_resi != null) && (!input_resi.equals(pesanan.get(3)))) {
                    JOptionPane.showMessageDialog(null, "Nomor Resi tidak terdaftar!", "PERINGATAN", JOptionPane.ERROR_MESSAGE);
                    i = 0;
                } else {
                    int pilihan = JOptionPane.showConfirmDialog(null, 
                                  "Apakah Anda ingin keluar ke menu utama?",
                                  "Konfirmasi",
                                  JOptionPane.YES_NO_OPTION,
                                  JOptionPane.WARNING_MESSAGE);

                    if(pilihan == JOptionPane.YES_OPTION) {
                        is_exit_lacak_pesanan = true;
                        i = 4;
                    } else {
                        is_exit_lacak_pesanan = false;
                        i = 0;
                    }

                }

            }
        } else {
            JOptionPane.showMessageDialog(null, "Data masih kosong!", "PERINGATAN", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void CetakResi() {
        int berat_barang = Integer.parseInt(pesanan.get(0));
        int jarak_barang = Integer.parseInt(pesanan.get(1));

        long total_bayar = KalkulasiPembayaran(berat_barang, jarak_barang);
        String nomor_resi = "XYZ001";

        pesanan.add(2, ""+total_bayar);
        pesanan.add(3, nomor_resi);

        String list_data = "Berat Barang = " + berat_barang + "gr\n"
                           + "Jarak Tempuh = " + jarak_barang + "km\n"
                           + "Total Bayar = Rp " + total_bayar + "\n"
                           + "Nomor Resi = " + nomor_resi;
        
        JOptionPane.showMessageDialog(null, list_data);
    }

    private long KalkulasiPembayaran(int berat, int jarak) {
        long harga_barang = 5000;
        long harga_jarak = 8000;

        long total_harga_barang = berat / 100 * harga_barang;
        long total_harga_jarak = jarak / 10 * harga_jarak;
        long total_harga = total_harga_barang + total_harga_jarak;

        return total_harga;
    }

    private void ExitApps(String values) {
        int pilihan = JOptionPane.showConfirmDialog(null,
                      values + "Apakah Anda ingin keluar?",
                      "Konfirmasi",
                      JOptionPane.YES_NO_OPTION,
                      JOptionPane.WARNING_MESSAGE);
        is_exit = (pilihan == JOptionPane.YES_OPTION) ? true : false;
    }

}