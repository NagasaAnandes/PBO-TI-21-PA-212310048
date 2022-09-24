import java.util.Scanner;

public class Latihan08 {

	public static void main(String[] args) {
		String NPM, NamaLengkap, NamaKelas, Semester, IPK;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Masukan NPM Anda : ");
		NPM = input.nextLine();
		System.out.print("Masukan Nama Lengkap : ");
		NamaLengkap = input.nextLine();
		System.out.print("Masukan Nama Kelas Anda : ");
		NamaKelas = input.nextLine();
		System.out.print("Masukan Semester Anda : ");
		Semester = input.nextLine();
		System.out.print("Masukan IPK Anda : ");
		IPK = input.nextLine();
		
		System.out.println("NPM Anda : "+NPM);
		System.out.println("Nama Lengkap Anda : "+NamaLengkap);
		System.out.println("Nama Kelas Anda : "+NamaKelas);
		System.out.println("Semester Anda : "+Semester);
		System.out.println("IPK Anda : "+IPK);
		
		input.close();
	}

}
