package PRAK203_2410817220030_RachelWinaYuda;

//Nama class di Main3 adalah 'Pegawai', bukan 'Employee'. Class yang dipanggil dari main harus sama.
//public class Employee {
public class Pegawai { 
 
 // Semua atribut di Main3 diakses langsung. 
 // Untuk menghindari error "cannot find symbol", atribut harus public.
 // Atribut 'asal' dan 'umur' diakses langsung di Main3.
 // public String nama; // Nama diakses via getName(), sehingga harus private atau public
 public String nama; 
 
 // Tipe data 'asal' adalah String, bukan char. 
 // Main3 memberikan String ("Kingdom of Orvel").
 // public char asal; 
 public String asal; 
 
 public String jabatan; 
 
 public int umur;
 
 public Pegawai() {
     // Atribut 'umur' harus diinisialisasi agar sesuai output (17 tahun). Jika tidak diinisialisasi, nilainya 0 (default int), yang tidak sesuai output.
     this.umur = 17;
 }
 
 public String getNama() {
     return nama;
 }

 public String getAsal() {
     return asal;
 }

 // Method setJabatan() di Main3 dipanggil dengan parameter String (p1.setJabatan("Assasin")).
 // Method setJabatan() di Pegawai.java tidak memiliki parameter.
 // public void setJabatan() {
 //     this.jabatan = j; // Variabel 'j' tidak dideklarasikan.
 // }
 public void setJabatan(String jabatan) {
     this.jabatan = jabatan;
 }
}