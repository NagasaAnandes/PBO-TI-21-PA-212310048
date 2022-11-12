
import javax.swing.JOptionPane;
public class Latihan04 {

	public static void main(String[] args) {
		int jmlh = Integer.parseInt(JOptionPane.showInputDialog(null,"Masukkan jmllh array : "));
		int array[] = new int[jmlh];
		
		for(int i = 0 ; i < array.length; i++) {
			array[i] = Integer.parseInt(JOptionPane.showInputDialog("Masukkan data ke- "+(i+1)));
		}
		
		String keluaran = "";
		for(int i = 0; i<array.length; i++) {
			
			keluaran += "x[" +i+"] ="+array[i]+"\n";
		}
		
		int max = array[0];
		for(int i = 0; i < array.length; i++) {
			if(array[i] > max) {
				max = array[i];
			}
		}
		int min=array[0];
		for(int i=0;i<array.length; i++) {
			if(array[i] < min) {
				min = array[i];
			}
		}
		JOptionPane.showMessageDialog(null, keluaran + "Angka terbesar adalah "+max+"\n"+"Angka Terkecil adalah "+min);

	}

}