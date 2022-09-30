import java.util.Scanner;

public class Latihan02 {
	public static void main(String[] args) {
		int NPM, cek = 0;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Program menentukan apakah NPM anda termasuk bilangan prima");
		System.out.print("Masukan NPM anda : ");
		NPM = input.nextInt();
		
		for (int i = 2; i<=NPM; i++) {
			if (NPM %i==0) {
				cek++;
			}
		}
		if (cek==1){
            System.out.println(NPM+" NPM anda adalah bilangan prima");
        }else {
            System.out.println(NPM+" NPM anda bukan bilangan prima");
        }
		input.close();
	}
}
