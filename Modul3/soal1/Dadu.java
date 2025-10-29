package soal1;

import java.util.Random;

public class Dadu {
	private int nilai;

    public Dadu() {
        acakNilai(); 
    }

    public void acakNilai() {
        Random random = new Random();
        this.nilai = random.nextInt(6) + 1; 
    }

    public int getNilai() {
        return nilai;
    }
    
    public void setNilai(int nilaiBaru) {
        if (nilaiBaru >= 1 && nilaiBaru <= 6) {
            this.nilai = nilaiBaru;
        } else {
            System.out.println("Nilai dadu harus antara 1-6.");
        }
    }
}