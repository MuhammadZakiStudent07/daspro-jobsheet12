package Jobsheet12;

import java.util.Locale;
import java.util.Scanner;

public class RekapLaundry23 {
    static Scanner sc = new Scanner(System.in);

    static String rupiah(int nominal) {
        return String.format(Locale.forLanguageTag("id-ID"), "Rp %,d", nominal);
    }

    static void inputData(int[][] data, String[] layanan, String[] hari) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print("Berat " + layanan[i] + " hari " + hari[j] + " (kg): ");
                data[i][j] = sc.nextInt();
            }
        }
    }

    static void tampilTabel(int[][] data, String[] layanan, String[] hari) {
        System.out.printf("%-14s", "Layanan");
        for (String h : hari) {
            System.out.printf("%8s", h);
        }
        System.out.println();

        for (int i = 0; i < data.length; i++) {
            System.out.printf("%-14s", layanan[i]);
            for (int j = 0; j < data[i].length; j++) {
                System.out.printf("%8d", data[i][j]);
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
        String[] layanan = {"Cuci Kering", "Cuci Setrika", "Setrika Saja", "Express"};
        int[] harga = {6000, 8000, 5000, 12000};
        String[] hari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu"};
        int[][] data = new int[layanan.length][hari.length];

        inputData(data, layanan, hari);

        System.out.println("\nRekap berat cucian (kg):");
        tampilTabel(data, layanan, hari);

        System.out.println();
        for (int i = 0; i < layanan.length; i++) {
            System.out.println("Total " + layanan[i] + ": " + totalPerLayanan(data, i) + " kg");
        }

        System.out.println();
        tampilLayananTertinggi(data, layanan);
        System.out.println("Hari tersibuk: " + hari[hariTersibuk(data)]);

        System.out.println("\nPendapatan:");
        tampilPendapatan(data, layanan, harga);
    }
}
