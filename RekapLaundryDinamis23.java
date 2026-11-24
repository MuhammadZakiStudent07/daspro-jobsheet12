package Jobsheet12;

import java.util.Locale;
import java.util.Scanner;

public class RekapLaundryDinamis23 {
    static Scanner sc = new Scanner(System.in);

    static String rupiah(int nominal) {
        return String.format(Locale.forLanguageTag("id-ID"), "Rp %,d", nominal);
    }

    static void inputData(int[][] data, String[] layanan) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print("Berat " + layanan[i] + " hari ke-" + (j + 1) + " (kg): ");
                data[i][j] = sc.nextInt();
            }
        }
    }

    static void tampilTabel(int[][] data, String[] layanan) {
        System.out.printf("%-14s", "Layanan");
        for (int j = 0; j < data[0].length; j++) {
            System.out.printf("%10s", "Hari ke-" + (j + 1));
        }
        System.out.println();

        for (int i = 0; i < data.length; i++) {
            System.out.printf("%-14s", layanan[i]);
            for (int j = 0; j < data[i].length; j++) {
                System.out.printf("%10d", data[i][j]);
            }
            System.out.println();
        }
    }

    static int totalPerLayanan(int[][] data, int idxLayanan) {
        int total = 0;
        for (int j = 0; j < data[idxLayanan].length; j++) {
            total += data[idxLayanan][j];
        }
        return total;
    }

    static void tampilLayananTertinggi(int[][] data, String[] layanan) {
        int idx = 0;
        for (int i = 1; i < data.length; i++) {
            if (totalPerLayanan(data, i) > totalPerLayanan(data, idx)) {
                idx = i;
            }
        }
        System.out.println("Layanan dengan cucian terbanyak: " + layanan[idx]
                + " (" + totalPerLayanan(data, idx) + " kg)");
    }

    static int hariTersibuk(int[][] data) {
        int idxTerbesar = 0;
        int totalTerbesar = 0;
        for (int j = 0; j < data[0].length; j++) {
            int totalHari = 0;
            for (int i = 0; i < data.length; i++) {
                totalHari += data[i][j];
            }
            if (totalHari > totalTerbesar) {
                totalTerbesar = totalHari;
                idxTerbesar = j;
            }
        }
        return idxTerbesar;
    }

    static void tampilPendapatan(int[][] data, String[] layanan, int[] harga) {
        int totalPendapatan = 0;
        for (int i = 0; i < data.length; i++) {
            int pendapatan = totalPerLayanan(data, i) * harga[i];
            totalPendapatan += pendapatan;
            System.out.println(layanan[i] + ": " + rupiah(pendapatan));
        }
        System.out.println("Total pendapatan: " + rupiah(totalPendapatan));
    }

    public static void main(String[] args) {
        System.out.print("Masukkan jumlah layanan: ");
        int jumlahLayanan = sc.nextInt();
        System.out.print("Masukkan jumlah hari: ");
        int jumlahHari = sc.nextInt();
        sc.nextLine();

        String[] layanan = new String[jumlahLayanan];
        int[] harga = new int[jumlahLayanan];
        for (int i = 0; i < jumlahLayanan; i++) {
            System.out.print("Nama layanan ke-" + (i + 1) + ": ");
            layanan[i] = sc.nextLine();
            System.out.print("Harga per kg layanan ke-" + (i + 1) + ": ");
            harga[i] = sc.nextInt();
            sc.nextLine();
        }

        int[][] data = new int[jumlahLayanan][jumlahHari];

        inputData(data, layanan);

        System.out.println("\nRekap berat cucian (kg):");
        tampilTabel(data, layanan);

        System.out.println();
        for (int i = 0; i < layanan.length; i++) {
            System.out.println("Total " + layanan[i] + ": " + totalPerLayanan(data, i) + " kg");
        }

        System.out.println();
        tampilLayananTertinggi(data, layanan);
        System.out.println("Hari tersibuk: Hari ke-" + (hariTersibuk(data) + 1));

        System.out.println("\nPendapatan:");
        tampilPendapatan(data, layanan, harga);
    }
}
