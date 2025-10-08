package PRAK203_2410817220030_RachelWinaYuda;

public class Main3 {
	public static void main(String[] args) {
        // Class Pegawai belum diinisialisasi (kurang tanda kurung).
        // Pegawai p1 = new Pegawai; 
        Pegawai p1 = new Pegawai();
        
        // Atribut 'nama' seharusnya diakses via setter/getter jika ingin menerapkan encapsulation, namun karena output membutuhkan p1.nama = "Roi", atribut 'nama' di class Pegawai harus public.
        p1.nama = "Roi";
        p1.asal = "Kingdom of Orvel";
        p1.setJabatan("Assasin");
        
        System.out.println("Nama Pegawai: " + p1.getNama());
        
        // Method getAsal() dan getNama() dipanggil di baris yang terpisah. 
        // Baris ini tidak ada kesalahan sintaks, tetapi pemanggilan methodnya salah (getName() -> getNama()).
        System.out.println("Asal: " + p1.getAsal());
        
        // Atribut 'jabatan' harus diakses via getter/setter jika dibuat private. Namun, karena dibuat public di Pegawai.java, p1.jabatan berfungsi. 
        // Untuk konsistensi output, kita gunakan p1.jabatan (di soal tidak ada method getJabatan).
        System.out.println("Jabatan: " + p1.jabatan); 
        
        // Atribut 'umur' diakses langsung. Atribut 'umur' di Pegawai harus public.
        System.out.println("Umur: " + p1.umur);
    }
}