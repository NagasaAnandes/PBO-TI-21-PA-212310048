
import javax.swing.JOptionPane;
public class Latihan02 {

	public static void main(String[] args) {
		int array[] = new int[5];
		
		//input
		for(int i = 0 ; i < array.length; i++) {
			array[i] = Integer.parseInt(JOptionPane.showInputDialog("Masukkan data ke- "+(i+1)));
		}
		
		//output
		String keluaran = "";
		for(int i=0; i < array.length; i++) {
			
			keluaran += "x[" +i+"] ="+array[i]+"\n";
		}
		JOptionPane.showMessageDialog(null,keluaran);

	}

}