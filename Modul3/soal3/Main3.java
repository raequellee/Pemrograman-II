package soal3; 

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main3 {
    
    public static void tampilkanMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Tambah Mahasiswa");
        System.out.println("2. Hapus Mahasiswa berdasarkan NIM");
        System.out.println("3. Cari Mahasiswa berdasarkan NIM");
        System.out.println("4. Tampilkan Daftar Mahasiswa");
        System.out.println("0. Keluar");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();
        int pilihan = -1;
        
        while (pilihan != 0) {
            tampilkanMenu();
            System.out.print("Pilihan: ");
            
            try {
                pilihan = input.nextInt();
                input.nextLine(); 
            } catch (InputMismatchException e) {
                System.out.println("Pilihan tidak valid. Silakan masukkan angka (0-4).");
                input.nextLine(); 
                continue;
            }

            switch (pilihan) {
                case 1: 
                    System.out.print("Masukkan Nama Mahasiswa: ");
                    String nama = input.nextLine();
                    System.out.print("Masukkan NIM Mahasiswa (harus unik): ");
                    String nim = input.nextLine();
                    
                    boolean nimExist = false;
                    for (Mahasiswa m : daftarMahasiswa) {
                        if (m.getNim().equals(nim)) {
                            nimExist = true;
                            break;
                        }
                    }

                    if (!nimExist) {
                        daftarMahasiswa.add(new Mahasiswa(nama, nim));
                        System.out.println("Mahasiswa " + nama + " ditambahkan.");
                    } else {
                        System.out.println("Error: NIM " + nim + " sudah terdaftar. Mahasiswa tidak ditambahkan.");
                    }
                    break;

                case 2: 
                    if (daftarMahasiswa.isEmpty()) {
                        System.out.println("Daftar Mahasiswa kosong. Tidak ada yang bisa dihapus.");
                        break;
                    }
                    
                    System.out.print("Masukkan NIM Mahasiswa yang akan dihapus: ");
                    String nimHapus = input.nextLine();
                    
                    boolean dihapus = false;
                    for (int i = 0; i < daftarMahasiswa.size(); i++) {
                        if (daftarMahasiswa.get(i).getNim().equals(nimHapus)) {
                            daftarMahasiswa.remove(i);
                            dihapus = true;
                            break;
                        }
                    }

                    if (dihapus) {
                        System.out.println("Mahasiswa dengan NIM " + nimHapus + " dihapus.");
                    } else {
                        System.out.println("Error: Mahasiswa dengan NIM " + nimHapus + " tidak ditemukan.");
                    }
                    break;

                case 3: 
                    if (daftarMahasiswa.isEmpty()) {
                        System.out.println("Daftar Mahasiswa kosong. Tidak ada data yang bisa dicari.");
                        break;
                    }
                    
                    System.out.print("Masukkan NIM Mahasiswa yang dicari: ");
                    String nimCari = input.nextLine();
                    
                    boolean ditemukan = false;
                    for (Mahasiswa m : daftarMahasiswa) {
                        if (m.getNim().equals(nimCari)) {
                            System.out.println("Data Ditemukan:");
                            System.out.println("NIM: " + m.getNim() + ", Nama: " + m.getNama());
                            ditemukan = true;
                            break;
                        }
                    }

                    if (!ditemukan) {
                        System.out.println("Error: Mahasiswa dengan NIM " + nimCari + " tidak ditemukan.");
                    }
                    break;

                case 4: 
                    if (daftarMahasiswa.isEmpty()) {
                        System.out.println("Daftar Mahasiswa kosong.");
                    } else {
                        System.out.println("Daftar Mahasiswa:");
                        for (Mahasiswa m : daftarMahasiswa) {
                            System.out.println("NIM: " + m.getNim() + ", Nama: " + m.getNama());
                        }
                    }
                    break;

                case 0: 
                    daftarMahasiswa.clear(); 
                    System.out.println("Terima kasih!");
                    break;
                    
                default:
                    System.out.println("Pilihan tidak ada. Silakan coba lagi.");
            }
        }
        input.close();
    }
}