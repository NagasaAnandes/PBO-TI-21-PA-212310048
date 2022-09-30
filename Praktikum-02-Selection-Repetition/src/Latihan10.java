
import java.util.Scanner;

public class Latihan10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int pin = 212310048; //pin atm//
        boolean is_valid = false; 
        boolean opsi = false; 
        int saldo = 0, setor, tarik; 

        System.out.println("SELAMAT DATANG DI ATM");
        System.out.println("=====================");
        System.out.println("");
        do {
            System.out.print("Masukkan PIN : ");
            int validation = input.nextInt();

            if (validation == pin) {
                is_valid = true;
            } else {
                is_valid = false;
                System.out.println("Maaf, PIN Salah");
            }
        } while (is_valid == false);

        System.out.println("PIN Benar");
        System.out.println("");

        do {
            System.out.println("Menu : ");
            System.out.println("1. Lihat Saldo");
            System.out.println("2. Setor Tunai");
            System.out.println("3. Tarik Tunai");
            System.out.println("4. Keluar");

            System.out.print("Pilih Menu : ");
            int menu = input.nextInt();

            switch (menu) {
                case 1:
                    System.out.println("Saldo anda : " + saldo);
                    break;

                case 2:
                    System.out.print("Jumlah Setor Tunai : ");
                    setor = input.nextInt();
                    saldo = saldo + setor;
                    System.out.println("Saldo akhir : " + saldo);
                    break;

                case 3:
                    System.out.print("Jumlah Tarik Tunai : ");
                    tarik = input.nextInt();

                    if (tarik > saldo) {
                        System.out.println("Maaf saldo tidak mencukupi");
                    } else {
                        saldo = saldo - tarik;
                        System.out.println("Silahkan ambil uang anda");
                        System.out.println("Saldo akhir : " + saldo);
                    }

                case 4:
                    System.out.print("Ingin keluar? ");
                    String choice = input.next();

                    if (choice.toLowerCase().equals("y")) {
                        opsi = true;
                    } else if (choice.toLowerCase().equals("n")) {
                        opsi = false;
                    } else {
                        System.out.println("Maaf command salah");
                    }
                    break;

                default:
                    break;
            }

        } while (opsi == false);

        input.close();
    }
}