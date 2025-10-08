package PRAK201_2410817220030_RachelWinaYuda;

public class Buah {
	String nama; 
    double berat; 
    double harga; 
    double jumlahBeli; 
    double sebelumDiskon; 
    double totalDiskon; 
    double setelahDiskon; 
 
    public Buah (String namaBuah, double beratBuah, double hargaBuah, double jumlahBeliBuah){ 
        this.nama = namaBuah; 
        this.berat = beratBuah; 
        this.harga = hargaBuah; 
        this.jumlahBeli = jumlahBeliBuah;
        this.sebelumDiskon = hargaBuah * (jumlahBeliBuah / beratBuah); 
        this.totalDiskon = (int)(jumlahBeliBuah / 4) * (4 * hargaBuah) * 0.02; 
        this.setelahDiskon = sebelumDiskon - totalDiskon; 
    } 
    public void display(){ 
        System.out.println("Nama Buah: "+ nama); 
        System.out.println("Berat: "+ berat); 
        System.out.println("Harga: "+ harga); 
        System.out.println("Jumlah Beli: "+ jumlahBeli+"kg"); 
        System.out.printf("Harga Sebelum Diskon: Rp%.2f\n", sebelumDiskon); 
        System.out.printf("Total Diskon: Rp%.2f\n", totalDiskon); 
        System.out.printf("Harga Setelah Diskon: Rp%.2f\n\n", setelahDiskon); 
    }
}