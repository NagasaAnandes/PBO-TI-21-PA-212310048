
public class Latihan01 {
	public static void main(String[] args) {
		int c, r;
		float k;
	
		c = 90;
		
		CelciusToFarenheit();
		r = CelciusToRheamur();
		System.out.println("Menghitung Celcius ke Rheamur");
		System.out.println(c+ " C = "+r+" R");
		
		k = CelciusToKelvin(c);
		System.out.println("Menghitung Celcius ke Kelvin");
		System.out.println(c+ " C = "+r+" K");
	}
	static void CelciusToFarenheit() {
		int c = 90;
		int f = (9/5*c)+32;
		System.out.println("Menghitung Celcius ke Farenheit");
		System.out.println(c+ " C = "+f+" F");
	}
	static int CelciusToRheamur() {
		int c = 90;
		int r = (5/4) *c;
		return r;
	}
	static float CelciusToKelvin(int c) {
		int k = c + 273;
		return k;
	}
}
