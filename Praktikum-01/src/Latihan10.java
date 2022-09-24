import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Latihan10 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LocalDateTime waktuSekarang = LocalDateTime.now();
        DateTimeFormatter formatWaktu = DateTimeFormatter.ofPattern("dd MMM yyyy (HH:mm)");
        Students myBio = new Students();
        String waktu = waktuSekarang.format(formatWaktu);

        double hargaRoti = 6300;
        double jumlahBeli;
        double totalHarga;
        double diskon;
        double subTotal;

        // variabel untuk data member
        int valNPM, valSemester;
    	String valFullname, valClassname;

    	// variabel untuk meng-input data member oleh user
    	int dataNPM, dataSemester;
    	String dataFullname, dataClassname;

    	System.out.println("=====SELAMAT DATAN DI TOKO SERBAGUNA IBIK=====\n");
    	System.out.println("SILAHKAN ISI DATA DIRI UNTUK MENJADI MEMBER");

    	System.out.print("Masukkan NPM \t\t: ");
    	dataNPM = input.nextInt();
    	valNPM = myBio.getNPM(dataNPM);

    	input.nextLine();

    	System.out.print("Masukkan nama lengkap \t: ");
    	dataFullname = input.nextLine();
    	valFullname = myBio.getFullname(dataFullname);

    	System.out.print("Masukkan kelas \t\t: ");
    	dataClassname = input.nextLine();
    	valClassname = myBio.getClassName(dataClassname);

    	System.out.print("Masukkan semester \t: ");
    	dataSemester = input.nextInt();
    	valSemester = myBio.getSemester(dataSemester);

    	System.out.print("\n");

        System.out.println("===================================");
        System.out.println("\tTOKO SERBAGUNA IBIK");
        System.out.print("===================================\n");
        System.out.print("Masukkan jumlah produk yang dibeli = ");

        jumlahBeli = input.nextInt();
        totalHarga = hargaRoti * jumlahBeli;

        System.out.print("\n");

        System.out.println(waktu);
        System.out.println("ITEM \t\tQTY \t\tHARGA \t\tTOTAL");
        System.out.println("===========================================================");

        System.out.println("ROTI ENAK. \t" + jumlahBeli + "\t\tRp " + hargaRoti + "\tRp " + totalHarga);
        System.out.println("------------------------------------------------------------");

        if(jumlahBeli % 3 == 0) {
            diskon = 0.05 * totalHarga;
            subTotal = totalHarga - diskon;
            System.out.println("Diskon: 5%");
        } else {
            subTotal = totalHarga;
            System.out.println("Diskon: -");
        }

        System.out.println("Sub Total = Rp " + subTotal);      
        System.out.println("=============================================\n");
        System.out.println("MEMBER:");

        OutputDataStudents(valNPM, valFullname, valClassname, valSemester);

        input.close();
    }

    static void OutputDataStudents(int NPM, String namaLengkap, String kelas, int semester) {
    	System.out.println("NPM \t\t: " + NPM);
    	System.out.println("Nama Lengkap \t: " + namaLengkap);
    	System.out.println("Kelas \t\t: " + kelas);
    	System.out.println("Semester \t: " + semester);
    }

}