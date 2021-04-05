package com.azis;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Scanner;

class inputPemasukan {
    String ket, tanggal;
    int pemasukan;

}

class inputPengeluaran {
    String ket, tanggal;
    int pengeluaran;

}


public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int totalPemasukan = 0, totalPengeluaran = 0, saldoAkhir = 0;

        ArrayList<inputPemasukan> inPem = new ArrayList<inputPemasukan>();
        ArrayList<inputPengeluaran> inPeng = new ArrayList<inputPengeluaran>();

        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);

        while (true) {

            System.out.print("\n\n");
            System.out.println("Menu Utama");
            System.out.println("=======================================");
            System.out.println("A. Input Pemasukan");
            System.out.println("B. Input Pengeluaran");
            System.out.println("C. Tampil Pemasukan dan Pengeluaran");
            System.out.println("D. Exit");
            System.out.println("=======================================");
            System.out.print("Masukan Pilihan [A,B,C,D] : ");

            String menu = input.next();
            if (menu.equalsIgnoreCase("A")) {
                System.out.print("Masukan Jumlah Data Pemasukan : ");
                int list_pemasukan = input.nextInt();

                for (int i = 0; i < list_pemasukan; i ++) {

                    inputPemasukan peMasuk = new inputPemasukan();

                    System.out.print("\nMasukan Tanggal [dd/mm/yyyy] : ");
                    peMasuk.tanggal = input.next();
                    System.out.print("Masukan Keterangan : ");
                    peMasuk.ket = input.next();
                    System.out.print("Masukan Pemasukan : ");
                    peMasuk.pemasukan = input.nextInt();

                    totalPemasukan = totalPemasukan + peMasuk.pemasukan;

                    inPem.add(i,peMasuk);
                }

                System.out.print("\nTanggal             Keterangan          Pemasukan");
                for (int z = 0; z < inPem.size(); z++) {
                    System.out.print("\n" + inPem.get(z).tanggal);
                    System.out.print("\t\t\t" + inPem.get(z).ket);
                    System.out.print("\t\t\t\t" + kursIndonesia.format(inPem.get(z).pemasukan));
                }

            }
            else if (menu.equalsIgnoreCase("B")) {
                System.out.print("Masukan Jumlah Data Pengeluaran : ");
                int list_pengeluaran = input.nextInt();

                for (int i = 0; i < list_pengeluaran; i++) {
                    inputPengeluaran peNgelur = new inputPengeluaran();

                    System.out.print("\nMasukan Tanggal [dd/mm/yyyy] : ");
                    peNgelur.tanggal = input.next();
                    System.out.print("Masukan Keterangan : ");
                    peNgelur.ket = input.next();
                    System.out.print("Masukan Pengeluaran : ");
                    peNgelur.pengeluaran = input.nextInt();

                    totalPengeluaran = totalPengeluaran + peNgelur.pengeluaran;

                    inPeng.add(i, peNgelur);
                }

                System.out.println("\nTanggal             Keterangan          Pengeluaran");
                for (int y = 0; y < inPeng.size(); y++) {
                    System.out.print("\n" + inPeng.get(y).tanggal);
                    System.out.print("\t\t\t" + inPeng.get(y).ket);
                    System.out.print("\t\t\t\t" + kursIndonesia.format(inPeng.get(y).pengeluaran));
                }

            }
            else if (menu.equalsIgnoreCase("C")) {


                System.out.println("\n|Tanggal|      |Keterangan|          |Pemasukan|           |Pengeluaran|");

                    for (int i = 0; i < inPem.size(); i++) {
                        System.out.print("\n|" + inPem.get(i).tanggal + "|");
                        System.out.print("\t\t|" + inPem.get(i).ket + "|");
                        System.out.print("\t\t\t|" + kursIndonesia.format(inPem.get(i).pemasukan) + "|");
                    }
                    for (int j = 0; j < inPeng.size(); j++) {
                        System.out.print("\n|" + inPeng.get(j).tanggal + "|");
                        System.out.print("\t\t|" + inPeng.get(j).ket + "|");
                        System.out.print("\t\t\t\t\t\t\t|" + kursIndonesia.format(inPeng.get(j).pengeluaran) + "|");
                    }
                System.out.println("\n\n===================================================================================");
                System.out.println("\nTotal         : " + "\t\t\t\t\t|" + kursIndonesia.format(totalPemasukan) + "\t\t\t\t|" + kursIndonesia.format(totalPengeluaran));
                saldoAkhir = totalPemasukan - totalPengeluaran;
                System.out.println("Saldo Akhir : " + "\t\t\t\t\t\t\t\t\t\t |" + kursIndonesia.format(saldoAkhir));

            }
            else if (menu.equalsIgnoreCase("D")) {
                System.exit(0);
            }
        }
    }
}
