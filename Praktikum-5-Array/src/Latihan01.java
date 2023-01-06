import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Latihan01 {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> matrixA = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> matrixB = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++){
				String value = JOptionPane.showInputDialog(null, "Masukan Element Matrix A [" + i + "][" + j + "]");
				matrixA.add(new ArrayList<Integer>());
				matrixA.get(i).add(j, Integer.parseInt(value));
			}
		}
		for(int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++){
				String value = JOptionPane.showInputDialog(null, "Masukan Element Matrix B [" + i + "][" + j + "]");
				matrixB.add(new ArrayList<Integer>());
				matrixB.get(i).add(j, Integer.parseInt(value));
			}
		}
		
		//OUTPUT
		String outputA="Matriks A= \n";
		for(int i=0; i<2;i++) {
			for(int j=0;j<2; j++) {
				outputA += matrixA.get(i).get(j)+" ";
			}
			outputA += "\n";
		}
		
		String outputB="Matriks B= \n";
		for(int i=0; i<2;i++) {
			for(int j=0;j<2; j++) {
				outputB += matrixB.get(i).get(j)+" ";
			}
			outputB += "\n";
		}
		
		String Output = outputA + "\n" + outputB;
		JOptionPane.showMessageDialog(null, Output);
	}
}
