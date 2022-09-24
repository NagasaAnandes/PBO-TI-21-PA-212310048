
public class Latihan03 {
	public static void main(String[] args) {
		System.out.println("__________________________________________________________");
		LayangLayang();
		System.out.println("__________________________________________________________");
		PrismaSegitiga();
		
	}
	static void LayangLayang() {
		int d1 = 24, d2 = 40; //Diagonal
		float luas = (d1*d2)/2;
		System.out.println("Menghitung Luas Bangun Datar Layang Layang");
		System.out.println("("+d1+" x "+d2+")/2 = "+luas);
		System.out.println();
		
		int a = 13, b = 13, c = 37, d = 37;
		float keliling = a+b+c+d; //sisi
		System.out.println("Menghitung Keliling Bangun Datar Layang Layang");
		System.out.println(a+" + "+b+" + "+c+" + "+d+" = "+keliling);
		System.out.println();
	}
	
	static void PrismaSegitiga() {
		int t = 8; //Tinggi Prisma
		int la = 6; //Luas Alas
		int ka = 12; //Keliling Alas
		float luas = (2*la) + (ka*t);
		System.out.println("Menghitung Luas Bangun Ruang Prisma Segitiga");
		System.out.println("(2*"+la+")+("+ka+"*"+t+") = "+luas);
		System.out.println();
		
		float volume = la*t;
		System.out.println("Menghitung Volume Bangun Ruang Prisma Segitiga");
		System.out.println(la+"*"+t+" = "+volume);
		System.out.println();
	}
}
