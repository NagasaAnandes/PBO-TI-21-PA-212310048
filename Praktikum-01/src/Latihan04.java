import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Latihan04 {
	public static void main(String[] args) {
		
		System.out.println("==========================================================");
		System.out.println("\t\tTOKO SERBAGUNA IBIK");
		System.out.println("==========================================================");
		
		Scanner jumlah = new Scanner(System.in);
		LocalDateTime waktuSekarang = LocalDateTime.now();
		DateTimeFormatter formatWaktu = DateTimeFormatter.ofPattern("dd MMM yyyy (HH:mm)");
		//MM = Bulan dalam bentuk angka, MMM Bulan dalam bentuk 3 huruf, MMMM = bulan dalam bentuk fullname
		String waktu = waktuSekarang.format(formatWaktu);
		
		double jumlahBeli;
		double Harga = 6300;
		double Total;
		double diskon;
		double subTotal;
		
		System.out.print("Masukan jumlah produk yang dibeli : ");
		jumlahBeli = jumlah.nextDouble();
		Total = Harga * jumlahBeli;
		System.out.println(waktu);
		
		jumlah.close();
		
		System.out.println("ITEM \t\t QTY \t\t Harga \t\tTOTAL");
		System.out.println("==========================================================");
		System.out.println("ROTI ENAK \t "+jumlahBeli+" \t\t Rp "+ Harga+"\tRp "+ Total);
		System.out.println("----------------------------------------------------------");
		if(jumlahBeli % 3 == 0) {
			diskon = 0.05*Total;
			subTotal = Total - diskon;
			System.out.println("Diskon 5%");
			System.out.println("Rp "+subTotal);
		} else {
			diskon = 0.1 * Total;
			subTotal = Total - diskon;
			System.out.println("Diskon 10%");
			System.out.println("Rp "+subTotal);
		}
		
		
	}
	
}
