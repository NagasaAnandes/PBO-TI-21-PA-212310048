
import javax.swing.JOptionPane;
public class Latihan03 {

	public static void main(String[] args) {
		int jmlh = Integer.parseInt(JOptionPane.showInputDialog(null,"Masukkan jmllh array : "));
		int array[] = new int[jmlh];
		
		for(int i = 0 ; i < array.length; i++) {
			array[i] = Integer.parseInt(JOptionPane.showInputDialog("Masukkan data ke- "+(i+1)));
		}
		
		String keluaran = "";
		for(int i=0; i<array.length; i++) {
			
			keluaran += "x[" +i+"] ="+array[i]+"\n";
		}
		JOptionPane.showMessageDialog(null,keluaran);

	}

}