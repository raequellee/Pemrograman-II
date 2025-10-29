package soal2; 

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main2 {
    
    public static HashMap<Integer, String> buatDaftarBulan() {
        HashMap<Integer, String> bulan = new HashMap<>();
        bulan.put(1, "Januari");
        bulan.put(2, "Februari");
        bulan.put(3, "Maret");
        bulan.put(4, "April");
        bulan.put(5, "Mei");
        bulan.put(6, "Juni");
        bulan.put(7, "Juli");
        bulan.put(8, "Agustus");
        bulan.put(9, "September");
        bulan.put(10, "Oktober");
        bulan.put(11, "November");
        bulan.put(12, "Desember");
        return bulan;
    }
    
    public static int getValidatedInt(Scanner input, int min, int max, String errorMsg) {
        int value = -1;
        while (true) {
            try {
                if (!input.hasNextInt()) {
                    input.nextLine(); 
                    throw new InputMismatchException();
                }
                value = input.nextInt();
                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.println("Error: " + errorMsg);
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Input tidak valid. Harap masukkan bilangan bulat.");
                input.nextLine(); 
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HashMap<Integer, String> daftarBulan = buatDaftarBulan();
        LinkedList<Negara> daftarNegara = new LinkedList<>();
        
        int jumlahNegara = getValidatedInt(input, 1, Integer.MAX_VALUE, "Jumlah negara harus lebih dari 0.");
        input.nextLine(); 
        
        for (int i = 0; i < jumlahNegara; i++) {
            String nama = input.nextLine();
            String jenisKepemimpinan = input.nextLine().toLowerCase();
            String namaPemimpin = input.nextLine();
            
            Negara negaraBaru;
            
            if (jenisKepemimpinan.equals("monarki")) {
                negaraBaru = new Negara(nama, jenisKepemimpinan, namaPemimpin);
            } else {
                int tanggal = getValidatedInt(input, 1, 31, "Tanggal harus antara 1 dan 31.");
                int bulan = getValidatedInt(input, 1, 12, "Bulan harus antara 1 dan 12.");
                int tahun = getValidatedInt(input, 0, 2025, "Tahun tidak boleh lebih dari 2025.");
                input.nextLine(); 
                
                negaraBaru = new Negara(nama, jenisKepemimpinan, namaPemimpin, tanggal, bulan, tahun);
            }
            daftarNegara.add(negaraBaru);
        }
        
        System.out.println("\nOutput");
        
        for (Negara negara : daftarNegara) {
            String jenis = negara.getJenisKepemimpinan();
            String gelar = "";
            
            if (jenis.equals("monarki")) {
                gelar = "Raja";
            } else if (jenis.equals("presiden")) {
                gelar = "Presiden";
            } else if (jenis.equals("perdana menteri")) {
                gelar = "Perdana Menteri";
            }

            System.out.println("Negara " + negara.getNama() + " mempunyai " + gelar + " bernama " + negara.getNamaPemimpin());

            if (!jenis.equals("monarki")) {
                int bulanAngka = negara.getBulanKemerdekaan();
                String namaBulan = daftarBulan.get(bulanAngka);
                
                System.out.println("Deklarasi Kemerdekaan pada Tanggal " + negara.getTanggalKemerdekaan() + 
                          " " + namaBulan + " " + negara.getTahunKemerdekaan());
            }
        }
        
        input.close();
    }
}