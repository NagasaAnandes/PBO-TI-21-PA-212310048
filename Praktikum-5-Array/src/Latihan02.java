import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Latihan02 {
    
    public static void main(String[] args) {
        Latihan02 mainApps = new Latihan02();

        ArrayList<ArrayList<Integer>> matriks_a = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> matriks_b = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> total = new ArrayList<ArrayList<Integer>>();

        for(int i = 0; i < 2; i++) {
            matriks_a.add(new ArrayList<Integer>());
            for(int j = 0; j < 2; j++) {
                String values_matriks_a = JOptionPane.showInputDialog(null,
                                          "Masukkan angka:",
                                          "Matriks A[" + i + "][" + j + "]",
                                          JOptionPane.QUESTION_MESSAGE);
                matriks_a.get(i).add(j, Integer.parseInt(values_matriks_a));
            }
        }

        for(int k = 0; k < 2; k++) {
            matriks_b.add(new ArrayList<Integer>());
            for(int l = 0; l < 2; l++) {
                String values_matriks_b = JOptionPane.showInputDialog(null,
                                "Masukkan angka:",
                                        "Matriks B[" + k + "][" + l + "]",
                                        JOptionPane.QUESTION_MESSAGE);
                matriks_b.get(k).add(l, Integer.parseInt(values_matriks_b));
            }
        }

        int jumlahArr = 0;

        for(int i = 0; i < 2; i++) {
            total.add(new ArrayList<Integer>());
            for(int j = 0; j < 2; j++) {
                for(int k = 0; k < 2; k++) {
                    jumlahArr = jumlahArr + matriks_a.get(i).get(k) * matriks_b.get(k).get(j);
                }
                total.get(i).add(j, jumlahArr);
                jumlahArr = 0;
            }
        }

        String print_matriks = "Matriks A:\n" + mainApps.PrintArr(matriks_a)
                               + "\nMatriks B:\n" + mainApps.PrintArr(matriks_b)
                               + "\nHasil Perkalian:\n" + mainApps.PrintArr(total);

        JOptionPane.showMessageDialog(null, print_matriks);

    }

    private String PrintArr(ArrayList<ArrayList<Integer>> val) {
        String output = "";

        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                output += val.get(i).get(j) + " ";
            }
            output += "\n";
        }

        return output;
    }

}