
public class LatihanMain {
	public static void main(String[] args) {
		//sysout => ctrl + [space]
		System.out.println("Hello World");
		
		/*Tipe Data*/
		//NUMERIC
		Integer angka1; //low value hanya bisa menyimpan nilai dari -126 sampai 127
		int angka = 5; //big value nilai yang disimpan 32bit
		long angka2; //Milion value contohnya 1E
		
		//DECIMAL
		float angka3; //
		double angka4; //
		
		//STRING
		String nama; //menyimpan banyak huruf "asdasd"
		char huruf; //menyimpan 1 huruf 'a'
		
		//Boolean
		boolean feedback; //nilai balik true dan false
		
		//OPERATOR
		angka =9;
		int jumlah = angka + angka;
		System.out.println("Jumlah = "+ angka+ " + "+ angka +" = "+ jumlah); //hasilnya 18, karena angka yang dideklarasikan yg dibawah yg digunakan 
		System.out.println("Jumlah = "+ (angka + jumlah)); //jika mau memasukan program gunakan ()
	}
}

