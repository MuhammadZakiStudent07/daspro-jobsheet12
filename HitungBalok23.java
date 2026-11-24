package Jobsheet12;

import java.util.Scanner;

public class HitungBalok23 {
    static int hitungLuas(int pjg, int lb) {
        int Luas = pjg * lb;
        return Luas;
    }

    static int hitungVolume(int tinggi, int a, int b) {
        int volume = hitungLuas(a, b) * tinggi;
        return volume;
    }

    static int hitungLuasPermukaanBalok(int p, int l, int t) {
        int luasPermukaan = 2 * (hitungLuas(p, l) + hitungLuas(p, t) + hitungLuas(l, t));
        return luasPermukaan;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int p, l, t, L, vol, lp;

        for (int i = 1; i <= 3; i++) {
            System.out.println("Balok ke-" + i);

            System.out.println("Masukkan panjang");
            p = input.nextInt();

            System.out.println("Masukkan lebar");
            l = input.nextInt();

            System.out.println("Masukkan tinggi");
            t = input.nextInt();

            L = hitungLuas(p, l);
            System.out.println("Luas Persegi Panjang adalah " + L);

            vol = hitungVolume(t, p, l);
            System.out.println("Volume Balok adalah " + vol);

            lp = hitungLuasPermukaanBalok(p, l, t);
            System.out.println("Luas Permukaan Balok adalah " + lp);
        }
        input.close();
    }
}
