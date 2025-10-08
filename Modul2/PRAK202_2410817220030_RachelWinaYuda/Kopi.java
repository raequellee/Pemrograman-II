package PRAK202_2410817220030_RachelWinaYuda;

public class Kopi {
    public String namaKopi; 
    public String ukuran; 
    public double harga; 
    private String pembeli; 
 
    void info(){ 
        System.out.println("Nama Kopi: "+ this.namaKopi); 
        System.out.println("Ukuran: "+ this.ukuran); 
        System.out.printf("Harga: Rp. %.1f%n", this.harga); 
    } 
    
    void setPembeli(String pembeli){ 
        this.pembeli = pembeli; 
    } 
    
    String getPembeli(){
    	return this.pembeli; 
    } 
    
    double getPajak(){ 
        double pajak = this.harga * 0.11; 
        return pajak; 
    }
}