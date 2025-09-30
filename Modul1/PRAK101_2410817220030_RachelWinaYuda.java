package Modul1;

import java.util.Scanner;
public class PRAK101_2410817220030_RachelWinaYuda {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
        System.out.print("Masukkan Nama Lengkap: ");
        String nama = input.nextLine();

        System.out.print("Masukkan Tempat Lahir: ");
        String tempatLahir = input.nextLine();

        System.out.print("Masukkan Tanggal Lahir: ");
        int tanggal = input.nextInt();

        System.out.print("Masukkan Bulan Lahir: ");
        int bulan = input.nextInt();

        System.out.print("Masukkan Tahun Lahir: ");
        int tahun = input.nextInt();

        System.out.print("Masukkan Tinggi Badan: ");
        int tinggi = input.nextInt();

        System.out.print("Masukkan Berat Badan: ");
        double berat = input.nextDouble();
        
        String[] namaBulan = {
            "", "Januari", "Februari", "Maret", "April", "Mei", "Juni",
            "Juli", "Agustus", "September", "Oktober", "November", "Desember"
        };

        System.out.println("\nNama Lengkap " + nama + ", Lahir di " + tempatLahir +
                " pada Tanggal " + tanggal + " " + namaBulan[bulan] + " " + tahun + 
                "\nTinggi Badan " + tinggi + " cm dan Berat Badan " + berat + " kilogram");
        input.close();
	}
}