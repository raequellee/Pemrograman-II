package soal2;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    
    public static String readString(Scanner input, String prompt) {
        System.out.print(prompt);
        return input.nextLine();
    }
    
    public static String[] readCapabilities(Scanner input, String prompt) {
        System.out.print(prompt);
        String line = input.nextLine();
        return line.split("[,\\s]+"); 
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pilihan = 0;
        
        System.out.println("Pilih jenis hewan yang ingin diinputkan:");
        System.out.println("1 = Kucing");
        System.out.println("2 = Anjing");
        System.out.print("Masukkan pilihan: ");

        try {
            pilihan = input.nextInt();
            input.nextLine(); 
        } catch (InputMismatchException e) {
            System.out.println("Pilihan tidak valid.");
            input.nextLine();
            return;
        }

        if (pilihan == 1) {
            String nama = readString(input, "Nama hewan peliharaan: ");
            String ras = readString(input, "Ras: ");
            String warnaBulu = readString(input, "Warna Bulu: ");
            
            Kucing k = new Kucing(ras, nama, warnaBulu);
            
            k.displayDetailKucing(); 

        } else if (pilihan == 2) {
            String nama = readString(input, "Nama hewan peliharaan: ");
            String ras = readString(input, "Ras: ");
            String warnaBulu = readString(input, "Warna Bulu: ");
            String[] kemampuan = readCapabilities(input, "Kemampuan (dipisahkan koma atau spasi): ");

            Anjing a = new Anjing(ras, nama, warnaBulu, kemampuan);
            
            a.displayDetailAnjing();

        } else {
            System.out.println("Pilihan tidak dikenal.");
        }

        input.close();
    }
}