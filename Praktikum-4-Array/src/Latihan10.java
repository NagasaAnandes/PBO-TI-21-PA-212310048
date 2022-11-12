import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Latihan10 {
	public static void main(String[] args) {
		String field[]= {"Nama Lengkap","Alamat","No Telp"};
		ArrayList<String> Array = new ArrayList<String>();
		
		for (int i = 0;i<field.length;i++) {
			String value =JOptionPane.showInputDialog(null,field[i],"Data Array ke-"+i,JOptionPane.QUESTION_MESSAGE);
			Array.add(value);
		}
		
		String output="";
		for (int j= 0; j<field.length;j++) {
			output += field[j] + " = " + Array.get(j)+"\n";
		}
		JOptionPane.showInternalMessageDialog(null, output);
	
	}
}