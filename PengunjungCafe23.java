package Jobsheet12;

public class PengunjungCafe23 {
    static void daftarPengunjung(int nomorMeja, String... namaPengunjung) {
        System.out.println("Meja " + nomorMeja);
        System.out.println("Daftar Nama Pengunjung:");
        for (String nama : namaPengunjung) {
            System.out.println("- " + nama);
        }
    }

    static int hitungTotalBelanja(int... harga) {
        int total = 0;
        for (int h : harga) {
            total += h;
        }
        return total;
    }

    public static void main(String[] args) {
        daftarPengunjung(1, "Ali", "Budi", "Citra");
        daftarPengunjung(2, "Andi");
        daftarPengunjung(3, "Doni", "Eti", "Fahmi", "Galih");

        System.out.println("Total belanja (1 harga): " + hitungTotalBelanja(15000));
        System.out.println("Total belanja (3 harga): " + hitungTotalBelanja(15000, 20000, 22000));
        System.out.println("Total belanja (5 harga): " + hitungTotalBelanja(15000, 20000, 22000, 12000, 10000));
    }
}
