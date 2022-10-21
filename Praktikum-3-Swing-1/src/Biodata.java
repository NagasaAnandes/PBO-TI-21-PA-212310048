import javax.swing.JOptionPane;

public class Biodata {
	
	private String fullName, alamat;
	private int usia;
	
	void setData(String valNama, int valUsia, String valAlamat) {
		fullName = valNama;
		usia = valUsia;
		alamat = valAlamat;
	}
	
	void getData() {
		String output = "Biodata " + fullName + "\n\n"
					  + "Nama : " + fullName + "\n"
					  + "Usia : " + usia + "\n"
					  + "Alamat : " + alamat + "\n";
		
		JOptionPane.showMessageDialog(null, output, "Data Biodata", JOptionPane.INFORMATION_MESSAGE);
	}
	
}