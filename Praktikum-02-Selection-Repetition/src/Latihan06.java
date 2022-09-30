 import java.util.Scanner;

public class Latihan06 {

	public static void main(String[] args) {		
		int input;
		String inputPilihan;
		Scanner inputPesanan = new Scanner(System.in);
		while(true) {
			System.out.println("Pilih Menu Sarapan : ");
			System.out.println("1. Nasi Goreng ");
			System.out.println("2. Bubur Ayam");
			System.out.println("3. Soto Ayam");
			System.out.print("Masukan Menu : ");
			input = inputPesanan.nextInt();
			
			switch(input) {
			case 1:
				System.out.println("Anda memesan Nasi Goreng dengan harga Rp 22.000,-");
				break;
			case 2:
				System.out.println("Anda memesan Bubur Ayam dengan harga Rp15.000,-");
				break;
			case 3:
				System.out.println("“Anda memesan Soto Ayam dengan harga Rp 25.000,-");
				break;
				
			default:
				System.out.println("Anda memasukan menu yang salah");
			}
			
			System.out.print("Apakah anda akan memesan kembali? [Y/N]: ");
			inputPilihan = inputPesanan.next();
			
			if(inputPilihan.equalsIgnoreCase("Y")) {
				continue;
			} else if(inputPilihan.equalsIgnoreCase("N")) {
				break; 
			} else {
				System.out.println("Masukkan salah!");
			}
			
			inputPesanan.close();
		}
		
	}

}