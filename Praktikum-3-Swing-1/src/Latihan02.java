import javax.swing.JOptionPane;

public class Latihan02 {

	public static void main(String[] args) {
		
		Biodata bio = new Biodata();
		
		JOptionPane.showMessageDialog(null, "Selamat Datang!");
		
		String nama = JOptionPane.showInputDialog(null, "Masukkan nama lengkap Anda:", "Form Nama", JOptionPane.QUESTION_MESSAGE);
		String usia = JOptionPane.showInputDialog(null, "Masukkan usia Anda:", "Form Usia", JOptionPane.QUESTION_MESSAGE);
		String alamat = JOptionPane.showInputDialog(null, "Masukkan alamat Anda:", "Form Alamat", JOptionPane.QUESTION_MESSAGE);
		
		int pUsia = Integer.parseInt(usia);
		
		bio.setData(nama, pUsia, alamat);
		bio.getData();

	}

}
