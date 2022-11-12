import javax.swing.JOptionPane;

public class Latihan06 {
	public static void main(String[] args) {
		int baris =2;
		int kolom =2;
		
		int matriksA[][]= new int[baris][kolom];
		int matriksB[][]= new int[baris][kolom];
		
		JOptionPane.showMessageDialog(null, "==== Matriks A ====");
		for(int i =0; i<matriksA.length; i++) {
			for(int j=0; j<matriksA.length; j++) {
				matriksA[i][j] = Integer.parseInt(JOptionPane.showInputDialog(null,"Masukkan Nilai Matriks ke-["+i+"]"+"["+j+"]", "Matriks A",JOptionPane.QUESTION_MESSAGE));
			}
		}
		
		JOptionPane.showMessageDialog(null, "==== Matriks B ====");
		for(int i =0; i<matriksB.length; i++) {
			for(int j=0; j<matriksB.length; j++) {
				matriksB[i][j] = Integer.parseInt(JOptionPane.showInputDialog(null,"Masukkan Nilai Matriks ke-["+i+"]"+"["+j+"]","Matriks B",JOptionPane.QUESTION_MESSAGE));
			}
		}
		
		//OUTPUT
		String outputA="Matriks A = \n";
		for(int i=0; i<matriksA.length;i++) {
			for(int j=0;j<matriksA.length; j++) {
				outputA += matriksA[i][j] + " ";
			}
			outputA += "\n";
		}
		
		String outputB="Matriks B = \n";
		for(int i=0; i<matriksB.length;i++) {
			for(int j=0;j<matriksB.length; j++) {
				outputB += matriksB[i][j] + " ";
			}
			outputB += "\n";
		}
		
		JOptionPane.showMessageDialog(null, outputA+outputB);
		
	}

}