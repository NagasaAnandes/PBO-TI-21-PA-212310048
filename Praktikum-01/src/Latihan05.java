import java.util.Scanner; 
public class Latihan05 {
	public static void main(String[] args) {
		String huruf;
		Scanner hurufKecil = new Scanner(System.in);

		
		System.out.println("Program mengubah huruf kecil menjadi huruf Kapital");
		System.out.print("Masukan kalimal yang ingin diubah = ");
		huruf = hurufKecil.nextLine();
		
		System.out.println("Kalimat sebelum diubah : "+huruf);
		System.out.println("Kalimat setelah diubah : "+huruf.toUpperCase());
		
		hurufKecil.close();
	}
}