import javax.swing.JOptionPane;

public class Latihan08 {
	public static void main(String[] args) {
		String field[]= {"Nama Lengkap","Alamat","No Telp"};
		String jmlhData = JOptionPane.showInputDialog(null, "Masukkan Jumlah Data : ");
		int data = Integer.parseInt(jmlhData);
		String Array[][] = new String[data][field.length];
		
		for (int i = 0;i<data;i++) {
			for (int j=0; j<field.length; j++) {
				Array[i][j]=JOptionPane.showInputDialog(null,field[j],"Data Array ke-"+(i+1),JOptionPane.QUESTION_MESSAGE);	
			}
		}
		
		String output="";
		for (int i = 0; i<data; i++) {
			output += "Data ke-" + (i+1) + "\n";
			for (int j=0; j<field.length; j++) {
				output += field[j] + " = " + Array[i][j]+"\n";	
			}
			output += "\n";
		}
		JOptionPane.showInternalMessageDialog(null, output);
	
	}
}