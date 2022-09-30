import java.util.Scanner;

class Resto {
    private long harga;

    public void chooseMenu(int menu) {
        switch (menu) {
            case 1:
                System.out.println("Anda memesan Nasi Goreng dengan harga " + getPrices(menu) + ",-");
                break;

            case 2:
                System.out.println("Anda memesan Bubur Ayam dengan harga " + getPrices(menu) + ",-");
                break;

            case 3:
                System.out.println("Anda memesan Soto Ayam dengan harga " + getPrices(menu) + ",-");
                break;

            default:
                System.out.println("Maaf menu yang anda masukkan salah");
                break;
        }
    }

    private long getPrices(int menu) {
        Resto obj = new Resto();
        if (menu == 1) {
            obj.harga = 22000;
        } else if (menu == 2) {
            obj.harga = 15000;
        } else if (menu == 3) {
            obj.harga = 25000;
        }
        return obj.harga;
    }
}

public class Latihan07 {
    public static void main(String[] args) {
        Resto resto = new Resto();
        boolean back = false;

        Scanner input = new Scanner(System.in);
        do {
	        System.out.println("Menu Sarapan : ");
	        System.out.println("1. Nasi Goreng");
	        System.out.println("2. Bubur Ayam");
	        System.out.println("3. Soto Ayam");

            System.out.print("Pilih menu : ");
            int menu = input.nextInt();

            resto.chooseMenu(menu);

            System.out.print("Apakah anda ingin kembali (y/n)? ");
            String opsi = input.next();

            if (opsi.toLowerCase().equals("y")) {
                back = true;
            } else if (opsi.toLowerCase().equals("n")) {
                back = false;
            }
        } while (back == true);

        input.close();
    }
}