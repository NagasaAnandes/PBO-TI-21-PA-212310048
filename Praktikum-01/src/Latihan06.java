import java.util.Scanner;

public class Latihan06 {

	public static void main(String[] args) {
		String Usia;
		String Firstname;
		String Lastname;
		String NPM;
		Scanner data = new Scanner(System.in);
		
		System.out.print("Masukan Usia Anda : ");
		Usia = data.nextLine();
		System.out.print("Masukan Nama Depan Anda : ");
		Firstname = data.nextLine();
		System.out.print("Masukan Nama Belakang Anda : ");
		Lastname = data.nextLine();
		System.out.print("Masukan NPM Anda : ");
		NPM = data.nextLine();
		
		
		System.out.println("Hasil Concat : "+Usia.concat(Firstname).concat(Lastname).concat(NPM));
		
		data.close();
	}

}
