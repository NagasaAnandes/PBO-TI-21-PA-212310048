import javax.swing.JOptionPane;

public class Latihan03 {

	public static void main(String[] args) {
		Biodata bio = new Biodata();
		
		JOptionPane.showMessageDialog(null, "Selamat Datang!");
		final String WARN = "PERINGATAN!";
		
		String nama = JOptionPane.showInputDialog(null, "Masukkan nama lengkap Anda:", "Form Nama", JOptionPane.QUESTION_MESSAGE);
		
		if(nama.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Field Form Nama tidak boleh kosong!", WARN, JOptionPane.WARNING_MESSAGE);
			System.exit(0);
		}
		
		
		String usia = JOptionPane.showInputDialog(null, "Masukkan usia Anda:", "Form Usia", JOptionPane.QUESTION_MESSAGE);
		final String REG_NUMERIK = "[0-9]+";
		
		if(usia.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Field Form Usia tidak boleh kosong!", WARN, JOptionPane.WARNING_MESSAGE);
			System.exit(0);
		} else if(!usia.matches(REG_NUMERIK)) {
			JOptionPane.showMessageDialog(null, "Isian Form Usia harus numerik!", WARN, JOptionPane.WARNING_MESSAGE);
			System.exit(0);
		}
		
		
		String alamat = JOptionPane.showInputDialog(null, "Masukkan alamat Anda:", "Form Alamat", JOptionPane.QUESTION_MESSAGE);
		
		if(alamat.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Field Form Alamat tidak boleh kosong!", WARN, JOptionPane.WARNING_MESSAGE);
			System.exit(0);
		} else if(alamat.length() < 10) {
			JOptionPane.showMessageDialog(null, "Masukkan alamat minimum 10 karakter!", WARN, JOptionPane.WARNING_MESSAGE);
			System.exit(0);
		}
		
		int pUsia = Integer.parseInt(usia);
		
		bio.setData(nama, pUsia, alamat);
		bio.getData();

	}

}
