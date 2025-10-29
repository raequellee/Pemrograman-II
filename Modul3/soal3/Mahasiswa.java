package soal3;

public class Mahasiswa {
    private String nama;
    private String nim;

    public Mahasiswa(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }
    
    public void setNama(String namaBaru) {
        this.nama = namaBaru;
    }
    public void setNim(String nimBaru) {
        this.nim = nimBaru;
    }
}