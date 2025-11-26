package model;

public class Buku {
    private int id;
    private String judul;
    private String penulis;
    private int harga;
    private int stok;

    public Buku(int id, String judul, String penulis, int harga, int stok) {
        this.id = id;
        this.judul = judul;
        this.penulis = penulis;
        this.harga = harga;
        this.stok = stok;
    }

    public int getId() { return id; }
    public String getJudul() { return judul; }
    public String getPenulis() { return penulis; }
    public int getHarga() { return harga; }
    public int getStok() { return stok; }
}