package Modul1;

import java.util.Scanner;
public class PRAK102_2410817220030_RachelWinaYuda {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        System.out.print("Input: ");
        int angka = input.nextInt();

        int i = 0;

        while (i <= 10) {
            if (angka % 5 == 0) {
                int hasil = (angka / 5) - 1;
                System.out.print(hasil);
            } else {
                System.out.print(angka);
            }
            if (i <= 9) {
                System.out.print(", ");
            }
            angka++;
            i++;
        }
        input.close();
	}
}