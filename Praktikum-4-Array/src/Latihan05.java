import javax.swing.JOptionPane;

public class Latihan05 {
	public static void main(String[] args) {
		String field[]= {"Nama Lengkap","Alamat","No Telp"};
		String Array[]= new String[field.length];
		
		for (int i = 0;i<field.length;i++) {
			Array[i]=JOptionPane.showInputDialog(null,field[i],"Data Array ke-"+i,JOptionPane.QUESTION_MESSAGE);	
		}
		
		String output="";
		for (int j= 0; j<field.length;j++) {
			output += field[j] + " = " + Array[j]+"\n";
		}
		JOptionPane.showInternalMessageDialog(null, output);
	
	}
}