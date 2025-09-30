package Modul1;

import java.util.Scanner;
public class PRAK105_2410817220030_RachelWinaYuda {
	
	public static final double PHI = 3.14;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

        System.out.print("Masukkan jari-jari: ");
        double r = input.nextDouble();

        System.out.print("Masukkan tinggi: ");
        double t = input.nextDouble();

        double volume = PHI * r * r * t;

        System.out.printf("Volume tabung dengan jari-jari %.1f cm dan \n", r);
        System.out.printf("tinggi %.1f cm adalah %.3f m3\n", t, volume);

        input.close();
	}
}