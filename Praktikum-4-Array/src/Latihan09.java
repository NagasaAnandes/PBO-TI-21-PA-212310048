import java.util.ArrayList;
import java.util.*;

import javax.swing.JOptionPane;
public class Latihan09 {

	public static void main(String[] args) {
		ArrayList<Integer> value = new ArrayList<Integer>();
		int jmlh = Integer.parseInt(JOptionPane.showInputDialog(null, "Masukkan jmllh array : "));
		
		for(int i = 0 ; i < jmlh; i++) {
			String input = JOptionPane.showInputDialog("Masukkan data ke- "+(i+1));
			value.add(Integer.parseInt(input));
		}
		
		String keluaran = "";
		for(int i = 0; i<jmlh; i++) {
			
			keluaran += "x[" +i+"] ="+value.get(i)+"\n";
		}
		
		keluaran += "Nilai terbesar = " + Collections.max(value) + "\n";
        keluaran += "Nilai terkecil = " + Collections.min(value);
		
		JOptionPane.showMessageDialog(null, keluaran); 

	}

}