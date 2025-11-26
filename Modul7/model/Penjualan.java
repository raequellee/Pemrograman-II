package model;

public class Penjualan {
    private int id;
    private int jumlah;
    private int total_harga;
    private String tanggal;
    private int pelanggan_id;
    private int buku_id;

    public Penjualan(int id, int jumlah, int total_harga, String tanggal, int pelanggan_id, int buku_id) {
        this.id = id;
        this.jumlah = jumlah;
        this.total_harga = total_harga;
        this.tanggal = tanggal;
        this.pelanggan_id = pelanggan_id;
        this.buku_id = buku_id;
    }

    public int getId() { return id; }
    public int getJumlah() { return jumlah; }
    public int getTotal_harga() { return total_harga; }
    public String getTanggal() { return tanggal; }
    public int getPelanggan_id() { return pelanggan_id; }
    public int getBuku_id() { return buku_id; }
}