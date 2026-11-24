package Jobsheet12;

import java.util.Locale;
import java.util.Scanner;

public class BankSampah23 {
    static Scanner sc = new Scanner(System.in);

    static String rupiah(double nominal) {
        return String.format(Locale.forLanguageTag("id-ID"), "Rp %,.0f", nominal);
    }

    static double[] inputSetoran(int n) {
        double[] setoran = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Berat setoran nasabah ke-" + (i + 1) + " (kg): ");
            setoran[i] = sc.nextDouble();
        }
        return setoran;
    }

    static void tampilSetoran(double[] setoran) {
        for (int i = 0; i < setoran.length; i++) {
            System.out.println("Nasabah ke-" + (i + 1) + ": " + setoran[i] + " kg");
        }
    }

    static double totalSetoran(double[] setoran) {
        double total = 0;
        for (double berat : setoran) {
            total += berat;
        }
        return total;
    }

    static double hitungSaldo(double berat, double hargaPerKg) {
        return berat * hargaPerKg;
    }

    static int nasabahTerbanyak(double[] setoran) {
        int indeks = 0;
        for (int i = 1; i < setoran.length; i++) {
            if (setoran[i] > setoran[indeks]) {
                indeks = i;
            }
        }
        return indeks;
    }

    public static void main(String[] args) {
        sc.useLocale(Locale.US);

        System.out.print("Masukkan jumlah nasabah: ");
        int n = sc.nextInt();

        double[] setoran = inputSetoran(n);

        System.out.println("\nData setoran:");
        tampilSetoran(setoran);

        System.out.println("\nSaldo setiap nasabah (Rp3.000 per kg):");
        for (int i = 0; i < setoran.length; i++) {
            System.out.println("Nasabah ke-" + (i + 1) + ": " + rupiah(hitungSaldo(setoran[i], 3000)));
        }

        System.out.println("\nTotal setoran: " + totalSetoran(setoran) + " kg");

        int terbanyak = nasabahTerbanyak(setoran);
        System.out.println("Setoran terbanyak: nasabah ke-" + (terbanyak + 1)
                + " (" + setoran[terbanyak] + " kg)");
    }
}
