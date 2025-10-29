package soal1; 

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main1 {
    
    public static int getValidatedPositiveInt(Scanner input) {
        int value = 0;
        while (value <= 0) {
            try {
                value = input.nextInt();
                if (value <= 0) {
                    System.out.println("Jumlah dadu harus lebih dari 0. Silakan coba lagi.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Harap masukkan bilangan bulat positif.");
                input.nextLine(); 
                value = 0; 
            }
        }
        return value;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int jumlahDadu = getValidatedPositiveInt(input);
        
        LinkedList<Dadu> daftarDadu = new LinkedList<>();
        long totalNilai = 0; 

        for (int i = 0; i < jumlahDadu; i++) {
            Dadu daduBaru = new Dadu();
            
            daftarDadu.add(daduBaru);

            System.out.println("Dadu ke-" + (i + 1) + " bernilai " + daduBaru.getNilai());

            totalNilai += daduBaru.getNilai();
        }

        System.out.println("Total nilai dadu keseluruhan " + totalNilai);

        input.close();
    }
}