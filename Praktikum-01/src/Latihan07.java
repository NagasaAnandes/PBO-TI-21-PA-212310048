import java.util.Scanner;

public class Latihan07 {

	public static void main(String[] args) {
		String nama;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Masukan Nama Anda : ");
		nama = input.nextLine();
		System.out.println(nama.replaceAll("[aiueo]", "X")); //Pake [] kalo objectnya banyak
		input.close();
	}

}
