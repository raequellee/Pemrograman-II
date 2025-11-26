package model;

public class Pelanggan {
    private int id;
    private String nama;
    private String email;
    private String telepon;

    public Pelanggan(int id, String nama, String email, String telepon) {
        this.id = id;
        this.nama = nama;
        this.email = email;
        this.telepon = telepon;
    }

    public int getId() { return id; }
    public String getNama() { return nama; }
    public String getEmail() { return email; }
    public String getTelepon() { return telepon; }
    
    public void setNama(String nama) { this.nama = nama; }
    public void setEmail(String email) { this.email = email; }
    public void setTelepon(String telepon) { this.telepon = telepon; }
}