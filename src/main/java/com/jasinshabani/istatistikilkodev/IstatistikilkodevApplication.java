package com.jasinshabani.istatistikilkodev;

import com.jasinshabani.istatistikilkodev.Model.Ornek;
import com.jasinshabani.istatistikilkodev.Model.Trafik;
import com.jasinshabani.istatistikilkodev.Model.Yagis;
import com.poiji.bind.Poiji;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.*;

@SpringBootApplication
public class IstatistikilkodevApplication {

    public static void main(String[] args) {

        SpringApplication.run(IstatistikilkodevApplication.class, args);

        int secim;
        Scanner scanner=new Scanner(System.in);


        while(true) {
            System.out.println("Hangi Tablonun Verilerini Bastirmak istiyorsunuz?");
            System.out.println("1) Trafik Yogunlugu");
            System.out.println("2) Yagis Miktarlari");
            secim=scanner.nextInt();
            if (secim == 1) {
                File file = new File("C:\\Users\\Yasin\\Documents\\Technoperia\\istatistikilkodev\\Trafik.xlsx");
                List<Trafik> trafikList = Poiji.fromExcel(file, Trafik.class);

                System.out.println("Aritmetik Ortalama:");
                trafikAritmetik_Ort(trafikList);
                System.out.println("\nMedyan:");
                trafikMedyan(trafikList);
                System.out.println("\nMod:");
                trafikMod(trafikList);
                System.out.println("\nOrtalama Mutlak Sapma:");
                trafikortalamaMutlakSapma(trafikList);
                System.out.println("\nVaryans:");
                trafikVaryans(trafikList);
                System.out.println("\nStandart Sapma:");
                trafikStandartSapma(trafikList);
                System.out.println("\nDegisim Katsayisi:");
                trafikDegisimKatsayisi(trafikList);
                System.out.println("\nCeyrekler Acikligi:");
                trafikCeyreklerAcikligi(trafikList);
                System.out.println("\nTrafik Degisim Araligi:");
                trafikDegisimAraligi(trafikList);
                return;
            } else if (secim == 2) {
                File file = new File("C:\\Users\\Yasin\\Documents\\Technoperia\\istatistikilkodev\\Yagis.xlsx");
                List<Yagis> yagisList = Poiji.fromExcel(file, Yagis.class);

                System.out.println("Yagis Aritmetik Ortalama:");
                yagisAritmetik_Ort(yagisList);
                System.out.println("\nYagis Medyan:");
                yagisMedyan(yagisList);
                System.out.println("\nYagis Mod:");
                yagisMod(yagisList);
                System.out.println("\nYagis Ortalama Mutlak Sapma:");
                yagisortalamaMutlakSapma(yagisList);
                System.out.println("\nYagis Varyans:");
                yagisVaryans(yagisList);
                System.out.println("\nYagis Standart Sapma:");
                yagisStandartSapma(yagisList);
                System.out.println("\nYagis Degisim Katsayisi:");
                yagisDegisimKatsayisi(yagisList);
                System.out.println("\nYagis Ceyrekler Acikligi:");
                yagisCeyreklerAcikligi(yagisList);
                System.out.println("\nYagis Degisim Araligi:");
                yagisDegisimAraligi(yagisList);
                return;
            } else {
                System.out.println("Hocam Lutfen 1 veya 2 numarayi seciniz, programimiz zaten yeterince yoruldu!!");
            }
        }
    }
    // Trafik icin Fonksiyonlar
    static void trafikAritmetik_Ort(List<Trafik> trafikList){
        List<Integer> kavsak1dizi = new ArrayList<Integer>();
        List<Integer> kavsak2dizi = new ArrayList<Integer>();
        List<Integer> kavsak3dizi = new ArrayList<Integer>();

        for (Trafik trafik: trafikList) {
            kavsak1dizi.add(trafik.getKavsak1());
            kavsak2dizi.add(trafik.getKavsak2());
            kavsak3dizi.add(trafik.getKavsak3());
        }
        double toplamKavsak1dizi = 0.0;
        double toplamKavsak2dizi = 0.0;
        double toplamKavsak3dizi = 0.0;

        for (Integer sayi: kavsak1dizi) {
            toplamKavsak1dizi += sayi;
        }
        for (Integer sayi: kavsak2dizi) {
            toplamKavsak2dizi += sayi;
        }
        for (Integer sayi: kavsak3dizi) {
            toplamKavsak3dizi += sayi;
        }
        double ortalamaKavsak1dizi = toplamKavsak1dizi / kavsak1dizi.size();
        double ortalamaKavsak2dizi = toplamKavsak2dizi / kavsak2dizi.size();
        double ortalamaKavsak3dizi = toplamKavsak3dizi / kavsak3dizi.size();

        System.out.format("Kavsak1 Aritmetik Ortalaması: %.2f\n", ortalamaKavsak1dizi);
        System.out.format("Kavsak2 Aritmetik Ortalaması: %.2f\n", ortalamaKavsak2dizi);
        System.out.format("Kavsak3 Aritmetik Ortalaması: %.2f\n", ortalamaKavsak3dizi);


    }

    static void trafikMedyan(List<Trafik> trafikList){
        List<Integer> kavsak1dizi = new ArrayList<Integer>();
        List<Integer> kavsak2dizi = new ArrayList<Integer>();
        List<Integer> kavsak3dizi = new ArrayList<Integer>();
        for (Trafik trafik: trafikList) {
            kavsak1dizi.add(trafik.getKavsak1());
            kavsak2dizi.add(trafik.getKavsak2());
            kavsak3dizi.add(trafik.getKavsak3());
        }
        Collections.sort(kavsak1dizi);
        Collections.sort(kavsak2dizi);
        Collections.sort(kavsak3dizi);

        double medyankavsak1;
        double medyankavsak2;
        double medyankavsak3;

        if (kavsak1dizi.size()%2==0) {
            medyankavsak1 = ((double) kavsak1dizi.get(kavsak1dizi.size() / 2) + (double) kavsak1dizi.get(kavsak1dizi.size() / 2 - 1)) / 2; //ortancaların ortalaması
        }else {
            medyankavsak1 = (double) kavsak1dizi.get(kavsak1dizi.size() / 2); //tek sayılı eleman sayısına sahip vektörün ortanca elemanı
        }
        if (kavsak2dizi.size()%2== 0) {
            medyankavsak2 = ((double) kavsak2dizi.get(kavsak2dizi.size() / 2) + (double) kavsak2dizi.get(kavsak2dizi.size() / 2 - 1)) / 2; //ortancaların ortalaması
        }else {
            medyankavsak2 = (double) kavsak2dizi.get(kavsak2dizi.size() / 2); //tek sayılı eleman sayısına sahip vektörün ortanca elemanı
        }
        if (kavsak3dizi.size()% 2 ==0) {
            medyankavsak3 = ((double) kavsak3dizi.get(kavsak3dizi.size() / 2) + (double) kavsak3dizi.get(kavsak3dizi.size() / 2 - 1)) / 2; //ortancaların ortalaması
        }else {
            medyankavsak3 = (double) kavsak3dizi.get(kavsak3dizi.size() / 2); //tek sayılı eleman sayısına sahip vektörün ortanca elemanı
        }
        System.out.println("Medyan Kavsak1 ="+medyankavsak1);
        System.out.println("Medyan Kavsak2 ="+medyankavsak2);
        System.out.println("Medyan Kavsak3 ="+medyankavsak3);
    }

    static void trafikMod(List<Trafik> trafikList){
        List<Integer> kavsak1dizi = new ArrayList<Integer>();
        List<Integer> kavsak2dizi = new ArrayList<Integer>();
        List<Integer> kavsak3dizi = new ArrayList<Integer>();
        for (Trafik trafik: trafikList) {
            kavsak1dizi.add(trafik.getKavsak1());
            kavsak2dizi.add(trafik.getKavsak2());
            kavsak3dizi.add(trafik.getKavsak3());
        }
        Collections.sort(kavsak1dizi);
        Collections.sort(kavsak2dizi);
        Collections.sort(kavsak3dizi);

        int mod = 0;
        int modDeger;
        int k, i, counter;

        modDeger = kavsak1dizi.get(0);
        for (i = 0; i < kavsak1dizi.size(); ++i) {
            counter = 0;
            for (k = 0; k < kavsak1dizi.size(); ++k)
                if (kavsak1dizi.get(k) == kavsak1dizi.get(i))
                    counter++;
            if (counter > mod) {
                mod = counter;
                modDeger = kavsak1dizi.get(i);
            }
        }
        System.out.println("Kavsak1 - Mod : "+modDeger + " Frekans :"+mod);

        // Kavsak2
        mod = 0;
        modDeger = kavsak2dizi.get(0);
        for (i = 0; i < kavsak2dizi.size(); ++i) {
            counter = 0;
            for (k = 0; k < kavsak2dizi.size(); ++k)
                if (kavsak2dizi.get(k) == kavsak2dizi.get(i))
                    counter++;
            if (counter > mod) {
                mod = counter;
                modDeger = kavsak2dizi.get(i);
            }
        }
        System.out.println("Kavsak2 - Mod : "+modDeger + " Frekans :"+mod);

        // Kavsak3
        mod = 0;
        modDeger = kavsak3dizi.get(0);
        for (i = 0; i < kavsak3dizi.size(); ++i) {
            counter = 0;
            for (k = 0; k < kavsak3dizi.size(); ++k)
                if (kavsak3dizi.get(k) == kavsak3dizi.get(i))
                    counter++;
            if (counter > mod) {
                mod = counter;
                modDeger = kavsak3dizi.get(i);
            }
        }
        System.out.println("Kavsak3 - Mod : "+modDeger + " Frekans :"+mod);
    }

    static void trafikortalamaMutlakSapma(List<Trafik> trafikList){
        List<Integer> kavsak1dizi = new ArrayList<Integer>();
        List<Integer> kavsak2dizi = new ArrayList<Integer>();
        List<Integer> kavsak3dizi = new ArrayList<Integer>();
        for (Trafik trafik: trafikList) {
            kavsak1dizi.add(trafik.getKavsak1());
            kavsak2dizi.add(trafik.getKavsak2());
            kavsak3dizi.add(trafik.getKavsak3());
        }

        int toplam = 0;
        double ortMutlakSapma,ortalama,uzaklik=0.0;
        int i;

        for (i = 0; i < kavsak1dizi.size(); i++) {
           toplam+=kavsak1dizi.get(i);
        }
        ortalama = (double)toplam/kavsak1dizi.size();

//        System.out.println(" ORtalama "+ortalama);

        for (i = 0; i < kavsak1dizi.size(); i++) {
            if(ortalama>kavsak1dizi.get(i)){
                uzaklik += (ortalama-kavsak1dizi.get(i));

                //Gelen verilerin hangi degerlere sahip oldugunu kontrol etmek icin Loglar olusturdum
                /*System.out.println(" kavsak1dizi.get(i) "+ kavsak1dizi.get(i));
                System.out.println(" ortalama%kavsak1dizi.get(i)  "+ortalama%kavsak1dizi.get(i));
                System.out.println(" Uzaklik "+uzaklik);*/
            }
            else{
                uzaklik += (kavsak1dizi.get(i)-ortalama);

                //Gelen verilerin hangi degerlere sahip oldugunu kontrol etmek icin Loglar olusturdum
                /*System.out.println(" kavsak1dizi.get(i) "+ kavsak1dizi.get(i));
                System.out.println(" ortalama%kavsak1dizi.get(i)  "+ortalama%kavsak1dizi.get(i));
                System.out.println(" Uzaklik "+uzaklik);*/
            }
        }

//      System.out.println(" Uzaklik "+uzaklik);
        ortMutlakSapma = (double) uzaklik/kavsak1dizi.size();
        System.out.format("Kavsak1 - Ortalama Mutlak Sapma = %.2f\n",ortMutlakSapma);

        //KAvsak 2
        toplam = 0;
        uzaklik=0.0;

        for (i = 0; i < kavsak2dizi.size(); i++) {
            toplam+=kavsak2dizi.get(i);
        }
        ortalama = (double)toplam/kavsak2dizi.size();

//        System.out.println(" ORtalama "+ortalama);

        for (i = 0; i < kavsak2dizi.size(); i++) {
            if(ortalama>kavsak2dizi.get(i)){
                uzaklik += (ortalama-kavsak2dizi.get(i));
            }
            else{
                uzaklik += (kavsak2dizi.get(i)-ortalama);
            }
        }

//      System.out.println(" Uzaklik "+uzaklik);
        ortMutlakSapma = (double) uzaklik/kavsak2dizi.size();
        System.out.format("Kavsak2 - Ortalama Mutlak Sapma = %.2f\n",ortMutlakSapma);


        //Kavsak3
        toplam = 0;
        uzaklik=0.0;

        for (i = 0; i < kavsak3dizi.size(); i++) {
            toplam+=kavsak3dizi.get(i);
        }
        ortalama = (double)toplam/kavsak3dizi.size();

//        System.out.println(" ORtalama "+ortalama);

        for (i = 0; i < kavsak3dizi.size(); i++) {
            if(ortalama>kavsak3dizi.get(i)){
                uzaklik += (ortalama-kavsak3dizi.get(i));
            }
            else{
                uzaklik += (kavsak3dizi.get(i)-ortalama);
            }
        }

//      System.out.println(" Uzaklik "+uzaklik);
        ortMutlakSapma = (double) uzaklik/kavsak3dizi.size();
        System.out.format("Kavsak3 - Ortalama Mutlak Sapma = %.2f\n",ortMutlakSapma);
    }

    static void trafikVaryans(List<Trafik> trafikList) {
        List<Integer> kavsak1dizi = new ArrayList<Integer>();
        List<Integer> kavsak2dizi = new ArrayList<Integer>();
        List<Integer> kavsak3dizi = new ArrayList<Integer>();
        for (Trafik trafik: trafikList) {
            kavsak1dizi.add(trafik.getKavsak1());
            kavsak2dizi.add(trafik.getKavsak2());
            kavsak3dizi.add(trafik.getKavsak3());
        }

        int toplam = 0;
        double ortMutlakSapma,ortalama,uzaklik=0.0,karelerininToplami=0.0,varyans=0.0;
        int i;

        for (i = 0; i < kavsak1dizi.size(); i++) {
            toplam+=kavsak1dizi.get(i);
        }
        ortalama = (double)toplam/kavsak1dizi.size();

//        System.out.println(" ORtalama "+ortalama);

        for (i = 0; i < kavsak1dizi.size(); i++) {
            if(ortalama>kavsak1dizi.get(i)){
                uzaklik = ortalama - kavsak1dizi.get(i);
                karelerininToplami += Math.pow(uzaklik,2);
            }
            else{
                uzaklik = kavsak1dizi.get(i) - ortalama ;
                karelerininToplami += Math.pow(uzaklik,2);
            }
        }
//        System.out.println("karelerininToplami "+karelerininToplami);
        varyans = (double) karelerininToplami/(kavsak1dizi.size()-1);
        System.out.format("Kavsak1 - Varyans = %.2f\n",varyans);

        //Kavsak2
        toplam = 0;
        uzaklik=0.0;
        karelerininToplami=0.0;
        varyans=0.0;

        for (i = 0; i < kavsak2dizi.size(); i++) {
            toplam+=kavsak2dizi.get(i);
        }
        ortalama = (double)toplam/kavsak2dizi.size();
        for (i = 0; i < kavsak2dizi.size(); i++) {
            if(ortalama>kavsak2dizi.get(i)){
                uzaklik = ortalama - kavsak2dizi.get(i);
                karelerininToplami += Math.pow(uzaklik,2);
            }
            else{
                uzaklik = kavsak2dizi.get(i) - ortalama ;
                karelerininToplami += Math.pow(uzaklik,2);
            }
        }
//        System.out.println("karelerininToplami "+karelerininToplami);
        varyans = (double) karelerininToplami/(kavsak2dizi.size()-1);
        System.out.format("Kavsak2 - Varyans = %.2f\n",varyans);


        //Kavsak 3
        toplam = 0;
        uzaklik=0.0;
        karelerininToplami=0.0;
        varyans=0.0;

        for (i = 0; i < kavsak3dizi.size(); i++) {
            toplam+=kavsak3dizi.get(i);
        }
        ortalama = (double)toplam/kavsak3dizi.size();
        for (i = 0; i < kavsak3dizi.size(); i++) {
            if(ortalama>kavsak3dizi.get(i)){
                uzaklik = ortalama - kavsak3dizi.get(i);
                karelerininToplami += Math.pow(uzaklik,2);
            }
            else{
                uzaklik = kavsak3dizi.get(i) - ortalama ;
                karelerininToplami += Math.pow(uzaklik,2);
            }
        }
//        System.out.println("karelerininToplami "+karelerininToplami);
        varyans = (double) karelerininToplami/(kavsak3dizi.size()-1);
        System.out.format("Kavsak3 - Varyans = %.2f\n",varyans);
    }

    static void trafikStandartSapma(List<Trafik> trafikList){
        List<Integer> kavsak1dizi = new ArrayList<Integer>();
        List<Integer> kavsak2dizi = new ArrayList<Integer>();
        List<Integer> kavsak3dizi = new ArrayList<Integer>();
        for (Trafik trafik: trafikList) {
            kavsak1dizi.add(trafik.getKavsak1());
            kavsak2dizi.add(trafik.getKavsak2());
            kavsak3dizi.add(trafik.getKavsak3());
        }
        Collections.sort(kavsak1dizi);
        Collections.sort(kavsak2dizi);
        Collections.sort(kavsak3dizi);

        //Kavsak 1
        double toplam = 0.0, standartSapma = 0.0,ortalama;
        for(double sayi : kavsak1dizi) {
            toplam += sayi;
        }

        ortalama= toplam/kavsak1dizi.size();

        for(double sayi: kavsak1dizi) {
            standartSapma += Math.pow(sayi - ortalama, 2);
        }

        System.out.println("Kavsak1 Standart Sapma = "+ Math.sqrt(standartSapma/kavsak1dizi.size()));

        //Kavsak 2
        toplam = 0.0;
        standartSapma = 0.0;
        ortalama=0.0;
        for(double sayi : kavsak2dizi) {
            toplam += sayi;
        }

        ortalama = toplam/kavsak2dizi.size();

        for(double sayi: kavsak2dizi) {
            standartSapma += Math.pow(sayi - ortalama, 2);
        }
        System.out.println("Kavsak2 Standart Sapma = "+ Math.sqrt(standartSapma/kavsak2dizi.size()));

        //Kavsak 3
        toplam = 0.0;
        standartSapma = 0.0;
        ortalama=0.0;
        for(double sayi : kavsak3dizi) {
            toplam += sayi;
        }
        ortalama = toplam/kavsak3dizi.size();

        for(double sayi: kavsak3dizi) {
            standartSapma += Math.pow(sayi - ortalama, 2);
        }
        System.out.println("Kavsak3 Standart Sapma = "+ Math.sqrt(standartSapma/kavsak3dizi.size()));
    }


    static void trafikDegisimKatsayisi(List<Trafik> trafikList){
        List<Integer> kavsak1dizi = new ArrayList<Integer>();
        List<Integer> kavsak2dizi = new ArrayList<Integer>();
        List<Integer> kavsak3dizi = new ArrayList<Integer>();
        for (Trafik trafik: trafikList) {
            kavsak1dizi.add(trafik.getKavsak1());
            kavsak2dizi.add(trafik.getKavsak2());
            kavsak3dizi.add(trafik.getKavsak3());
        }
        Collections.sort(kavsak1dizi);
        Collections.sort(kavsak2dizi);
        Collections.sort(kavsak3dizi);

        //Kavsak 1
        double toplam = 0;
        double degisimKatsayisi;
        for (int i = 0; i < kavsak1dizi.size(); i++) {
            toplam = toplam + (kavsak1dizi.get(i) - ortalamakavsak(kavsak1dizi)) * (kavsak1dizi.get(i) - ortalamakavsak(kavsak1dizi));
        }
        degisimKatsayisi = (Math.sqrt(toplam / (kavsak1dizi.size() - 1)) / ortalamakavsak(kavsak1dizi) );

        System.out.format("Kavsak1 Degisim Katsayisi= %.3f\n",degisimKatsayisi);

        //Kavsak 2
        toplam = 0;
        for (int i = 0; i < kavsak2dizi.size(); i++) {
            toplam = toplam + (kavsak2dizi.get(i) - ortalamakavsak(kavsak2dizi)) * (kavsak2dizi.get(i) - ortalamakavsak(kavsak2dizi));
        }
        degisimKatsayisi = (Math.sqrt(toplam / (kavsak2dizi.size() - 1)) / ortalamakavsak(kavsak2dizi) );

        System.out.format("Kavsak2 Degisim Katsayisi= %.3f\n",degisimKatsayisi);


        //Kavsak 3
        toplam = 0;
        for (int i = 0; i < kavsak3dizi.size(); i++) {
            toplam = toplam + (kavsak3dizi.get(i) - ortalamakavsak(kavsak3dizi)) * (kavsak3dizi.get(i) - ortalamakavsak(kavsak3dizi));
        }
        degisimKatsayisi = (Math.sqrt(toplam / (kavsak3dizi.size() - 1)) / ortalamakavsak(kavsak3dizi) );

        System.out.format("Kavsak3  Degisim Katsayisi = %.3f\n",degisimKatsayisi);
    }
    static double ortalamakavsak(List<Integer> kavsak1dizi) {
        double toplam = 0;

        for (int i = 0; i < kavsak1dizi.size(); i++)
            toplam = toplam + kavsak1dizi.get(i);
        return toplam / kavsak1dizi.size();
    }


    static void trafikCeyreklerAcikligi(List<Trafik> trafikList){
        List<Integer> kavsak1dizi = new ArrayList<Integer>();
        List<Integer> kavsak2dizi = new ArrayList<Integer>();
        List<Integer> kavsak3dizi = new ArrayList<Integer>();
        for (Trafik trafik: trafikList) {
            kavsak1dizi.add(trafik.getKavsak1());
            kavsak2dizi.add(trafik.getKavsak2());
            kavsak3dizi.add(trafik.getKavsak3());
        }
        Collections.sort(kavsak1dizi);
        Collections.sort(kavsak2dizi);
        Collections.sort(kavsak3dizi);

        //Kavsak 1
        double altgrup,ustgrup;
        double ceyrekacikligi;
        List<Integer> kavsak1diziAltceyrek = new ArrayList<Integer>();
        List<Integer> kavsak1diziUstceyrek = new ArrayList<Integer>();
        if(kavsak1dizi.size()%2==1){
            for (int i = 0; i < kavsak1dizi.size()/2; i++) {
                kavsak1diziAltceyrek.add(kavsak1dizi.get(i));
            }
            altgrup=kavsak1diziAltceyrek.get((kavsak1dizi.size()/2)/2);
            for (int i = (kavsak1dizi.size()/2)+1; i < kavsak1dizi.size(); i++) {
                kavsak1diziUstceyrek.add(kavsak1dizi.get(i));
            }
            ustgrup=kavsak1diziUstceyrek.get((kavsak1dizi.size()/2)/2);

            ceyrekacikligi = ustgrup - altgrup;
        }else{
            for (int i = 0; i < kavsak1dizi.size()/2; i++) {
                kavsak1diziAltceyrek.add(kavsak1dizi.get(i));
            }
            altgrup=kavsak1diziAltceyrek.get((kavsak1dizi.size()/2)/2);
            for (int i = (kavsak1dizi.size()/2); i < kavsak1dizi.size(); i++) {
                kavsak1diziUstceyrek.add(kavsak1dizi.get(i));
            }
            ustgrup=kavsak1diziUstceyrek.get((kavsak1dizi.size()/2)/2);

            ceyrekacikligi = ustgrup - altgrup;
        }
        System.out.format("Kavsak1 Ceyrekler Acikligi= %.1f\n",ceyrekacikligi);



        //Kavsak 2
        List<Integer> kavsak2diziAltceyrek = new ArrayList<Integer>();
        List<Integer> kavsak2diziUstceyrek = new ArrayList<Integer>();
        if(kavsak1dizi.size()%2==1){
            for (int i = 0; i < kavsak2dizi.size()/2; i++) {
                kavsak2diziAltceyrek.add(kavsak2dizi.get(i));
            }
            altgrup=kavsak2diziAltceyrek.get((kavsak2dizi.size()/2)/2);
            for (int i = (kavsak2dizi.size()/2)+1; i < kavsak2dizi.size(); i++) {
                kavsak2diziUstceyrek.add(kavsak2dizi.get(i));
            }
            ustgrup=kavsak2diziUstceyrek.get((kavsak2dizi.size()/2)/2);

            ceyrekacikligi = ustgrup - altgrup;
        }else{
            for (int i = 0; i < kavsak2dizi.size()/2; i++) {
                kavsak2diziAltceyrek.add(kavsak2dizi.get(i));
            }
            altgrup=kavsak2diziAltceyrek.get((kavsak2dizi.size()/2)/2);
            for (int i = (kavsak2dizi.size()/2); i < kavsak2dizi.size(); i++) {
                kavsak2diziUstceyrek.add(kavsak2dizi.get(i));
            }
            ustgrup=kavsak2diziUstceyrek.get((kavsak2dizi.size()/2)/2);

            ceyrekacikligi = ustgrup - altgrup;
        }
        System.out.format("Kavsak2 Ceyrekler Acikligi = %.1f\n",ceyrekacikligi);

        //Kavsak 3
        List<Integer> kavsak3diziAltceyrek = new ArrayList<Integer>();
        List<Integer> kavsak3diziUstceyrek = new ArrayList<Integer>();
        if(kavsak1dizi.size()%2==1){
            for (int i = 0; i < kavsak3dizi.size()/2; i++) {
                kavsak3diziAltceyrek.add(kavsak3dizi.get(i));
            }
            altgrup=kavsak3diziAltceyrek.get((kavsak3dizi.size()/2)/2);
            for (int i = (kavsak3dizi.size()/2)+1; i < kavsak3dizi.size(); i++) {
                kavsak3diziUstceyrek.add(kavsak3dizi.get(i));
            }
            ustgrup=kavsak3diziUstceyrek.get((kavsak3dizi.size()/2)/2);

            ceyrekacikligi = ustgrup - altgrup;
        }else{
            for (int i = 0; i < kavsak3dizi.size()/2; i++) {
                kavsak3diziAltceyrek.add(kavsak3dizi.get(i));
            }
            altgrup=kavsak3diziAltceyrek.get((kavsak3dizi.size()/2)/2);
            for (int i = (kavsak3dizi.size()/2); i < kavsak3dizi.size(); i++) {
                kavsak3diziUstceyrek.add(kavsak3dizi.get(i));
            }
            ustgrup=kavsak3diziUstceyrek.get((kavsak3dizi.size()/2)/2);

            ceyrekacikligi = ustgrup - altgrup;
        }
        System.out.format("Kavsak3 Ceyrekler Acikligi = %.1f\n",ceyrekacikligi);
    }

    static void trafikDegisimAraligi(List<Trafik> trafikList){
        List<Integer> kavsak1dizi = new ArrayList<Integer>();
        List<Integer> kavsak2dizi = new ArrayList<Integer>();
        List<Integer> kavsak3dizi = new ArrayList<Integer>();
        for (Trafik trafik: trafikList) {
            kavsak1dizi.add(trafik.getKavsak1());
            kavsak2dizi.add(trafik.getKavsak2());
            kavsak3dizi.add(trafik.getKavsak3());
        }
        System.out.println("Kavsak1 Degisim Araligi = " + (Collections.max(kavsak1dizi) - Collections.min(kavsak1dizi) + 1));
        System.out.println("Kavsak2 Degisim Araligi = " + (Collections.max(kavsak2dizi) - Collections.min(kavsak2dizi) + 1));
        System.out.println("Kavsak3 Degisim Araligi = " + (Collections.max(kavsak3dizi) - Collections.min(kavsak3dizi) + 1));
    }








    // Yagis icin Fonksiyonlar
    static void yagisAritmetik_Ort(List<Yagis> yagisList){
        List<Double> konyadizi = new ArrayList<Double>();
        List<Double> istanbuldizi = new ArrayList<Double>();
        List<Double> ankaradizi = new ArrayList<Double>();
        List<Double> antalyadizi = new ArrayList<Double>();

        for (Yagis yagis: yagisList) {
            konyadizi.add(yagis.getKonya());
            istanbuldizi.add(yagis.getIstanbul());
            ankaradizi.add(yagis.getAnkara());
            antalyadizi.add(yagis.getAntalya());
        }
        double toplamkonyadizi = 0.0;
        double toplamistanbuldizi = 0.0;
        double toplamankaradizi = 0.0;
        double toplamantalyadizi = 0.0;

        for (Double sayi: konyadizi) {
            toplamkonyadizi += sayi;
        }
        for (Double sayi: istanbuldizi) {
            toplamistanbuldizi += sayi;
        }
        for (Double sayi: ankaradizi) {
            toplamankaradizi += sayi;
        }
        for (Double sayi: antalyadizi) {
            toplamantalyadizi += sayi;
        }
        double ortalamakonyadizi = toplamkonyadizi / konyadizi.size();
        double ortalamaistanbuldizi = toplamistanbuldizi / istanbuldizi.size();
        double ortalamaAnkaradizi = toplamankaradizi / ankaradizi.size();
        double ortalamaAntalyadizi = toplamantalyadizi / antalyadizi.size();

        System.out.format("Konya Aritmetik Ortalaması: %.2f\n", ortalamakonyadizi);
        System.out.format("Istanbul Aritmetik Ortalaması: %.2f\n", ortalamaistanbuldizi);
        System.out.format("Ankaraa Aritmetik Ortalaması: %.2f\n", ortalamaAnkaradizi);
        System.out.format("Antalya Aritmetik Ortalaması: %.2f\n", ortalamaAntalyadizi);


    }

    static void yagisMedyan(List<Yagis> yagisList){
        List<Double> konyadizi = new ArrayList<Double>();
        List<Double> istanbuldizi = new ArrayList<Double>();
        List<Double> ankaradizi = new ArrayList<Double>();
        List<Double> antalyadizi = new ArrayList<Double>();

        for (Yagis yagis: yagisList) {
            konyadizi.add(yagis.getKonya());
            istanbuldizi.add(yagis.getIstanbul());
            ankaradizi.add(yagis.getAnkara());
            antalyadizi.add(yagis.getAntalya());
        }
        Collections.sort(konyadizi);
        Collections.sort(istanbuldizi);
        Collections.sort(ankaradizi);
        Collections.sort(antalyadizi);

        double medyankonya;
        double medyanistanbul;
        double medyanankara;
        double medyanantalya;

        if (konyadizi.size()%2==0) {
            medyankonya = ((double) konyadizi.get(konyadizi.size() / 2) + (double) konyadizi.get(konyadizi.size() / 2 - 1)) / 2; //ortancaların ortalaması
        }else {
            medyankonya = (double) konyadizi.get(konyadizi.size() / 2); //tek sayılı eleman sayısına sahip vektörün ortanca elemanı
        }
        if (istanbuldizi.size()%2== 0) {
            medyanistanbul = ((double) istanbuldizi.get(istanbuldizi.size() / 2) + (double) istanbuldizi.get(istanbuldizi.size() / 2 - 1)) / 2; //ortancaların ortalaması
        }else {
            medyanistanbul = (double) istanbuldizi.get(istanbuldizi.size() / 2); //tek sayılı eleman sayısına sahip vektörün ortanca elemanı
        }
        if (ankaradizi.size()% 2 ==0) {
            medyanankara = ((double) ankaradizi.get(ankaradizi.size() / 2) + (double) ankaradizi.get(ankaradizi.size() / 2 - 1)) / 2; //ortancaların ortalaması
        }else {
            medyanankara = (double) ankaradizi.get(ankaradizi.size() / 2); //tek sayılı eleman sayısına sahip vektörün ortanca elemanı
        }
        if (antalyadizi.size()% 2 ==0) {
            medyanantalya = ((double) antalyadizi.get(antalyadizi.size() / 2) + (double) antalyadizi.get(antalyadizi.size() / 2 - 1)) / 2; //ortancaların ortalaması
        }else {
            medyanantalya = (double) antalyadizi.get(antalyadizi.size() / 2); //tek sayılı eleman sayısına sahip vektörün ortanca elemanı
        }
        System.out.println("Medyan konya ="+medyankonya);
        System.out.println("Medyan istanbul ="+medyanistanbul);
        System.out.println("Medyan ankara ="+medyanankara);
        System.out.println("Medyan antalya ="+medyanantalya);
    }

    static void yagisMod(List<Yagis> yagisList){
        List<Double> konyadizi = new ArrayList<Double>();
        List<Double> istanbuldizi = new ArrayList<Double>();
        List<Double> ankaradizi = new ArrayList<Double>();
        List<Double> antalyadizi = new ArrayList<Double>();

        for (Yagis yagis: yagisList) {
            konyadizi.add(yagis.getKonya());
            istanbuldizi.add(yagis.getIstanbul());
            ankaradizi.add(yagis.getAnkara());
            antalyadizi.add(yagis.getAntalya());
        }
        Collections.sort(konyadizi);
        Collections.sort(istanbuldizi);
        Collections.sort(ankaradizi);
        Collections.sort(antalyadizi);

        int mod = 0;
        double modDeger;
        int k, i, sayac;

        modDeger = konyadizi.get(0);
        for (i = 0; i < konyadizi.size(); ++i) {
            sayac = 0;
            for (k = 0; k < konyadizi.size(); ++k)
                if (konyadizi.get(k) == konyadizi.get(i))
                    sayac++;
            if (sayac > mod) {
                mod = sayac;
                modDeger = konyadizi.get(i);
            }
        }
        System.out.println("konya Yagis Miktarinin - Modu = "+modDeger + " Frekans = "+mod);

        // istanbul
        mod = 0;
        modDeger = istanbuldizi.get(0);
        for (i = 0; i < istanbuldizi.size(); ++i) {
            sayac = 0;
            for (k = 0; k < istanbuldizi.size(); ++k)
                if (istanbuldizi.get(k) == istanbuldizi.get(i))
                    sayac++;
            if (sayac > mod) {
                mod = sayac;
                modDeger = istanbuldizi.get(i);
            }
        }
        System.out.println("istanbul Yagis Miktarinin - Mod : "+modDeger + " Frekans :"+mod);

        // ankara
        mod = 0;
        modDeger = ankaradizi.get(0);
        for (i = 0; i < ankaradizi.size(); ++i) {
            sayac = 0;
            for (k = 0; k < ankaradizi.size(); ++k)
                if (ankaradizi.get(k) == ankaradizi.get(i))
                    sayac++;
            if (sayac > mod) {
                mod = sayac;
                modDeger = ankaradizi.get(i);
            }
        }
        System.out.println("ankara Yagis Miktarinin - Mod : "+modDeger + " Frekans :"+mod);

        // antalya
        mod = 0;
        modDeger = antalyadizi.get(0);
        for (i = 0; i < antalyadizi.size(); ++i) {
            sayac = 0;
            for (k = 0; k < antalyadizi.size(); ++k)
                if (antalyadizi.get(k) == antalyadizi.get(i))
                    sayac++;
            if (sayac > mod) {
                mod = sayac;
                modDeger = antalyadizi.get(i);
            }
        }
        System.out.println("antalya Yagis Miktarinin - Mod : "+modDeger + " Frekans :"+mod);
    }

    static void yagisortalamaMutlakSapma(List<Yagis> yagisList){
        List<Double> konyadizi = new ArrayList<Double>();
        List<Double> istanbuldizi = new ArrayList<Double>();
        List<Double> ankaradizi = new ArrayList<Double>();
        List<Double> antalyadizi = new ArrayList<Double>();

        for (Yagis yagis: yagisList) {
            konyadizi.add(yagis.getKonya());
            istanbuldizi.add(yagis.getIstanbul());
            ankaradizi.add(yagis.getAnkara());
            antalyadizi.add(yagis.getAntalya());
        }
        Collections.sort(konyadizi);
        Collections.sort(istanbuldizi);
        Collections.sort(ankaradizi);
        Collections.sort(antalyadizi);

        //Gonyaaa
        int toplam = 0;
        double ortMutlakSapma,ortalama,uzaklik=0.0;
        int i;

        for (i = 0; i < konyadizi.size(); i++) {
            toplam+=konyadizi.get(i);
        }
        ortalama = (double)toplam/konyadizi.size();

//        System.out.println(" ORtalama "+ortalama);

        for (i = 0; i < konyadizi.size(); i++) {
            if(ortalama>konyadizi.get(i)){
                uzaklik += (ortalama-konyadizi.get(i));

                //Gelen verilerin hangi degerlere sahip oldugunu kontrol etmek icin Loglar olusturdum
                /*System.out.println(" kavsak1dizi.get(i) "+ kavsak1dizi.get(i));
                System.out.println(" ortalama%kavsak1dizi.get(i)  "+ortalama%kavsak1dizi.get(i));
                System.out.println(" Uzaklik "+uzaklik);*/
            }
            else{
                uzaklik += (konyadizi.get(i)-ortalama);

                //Gelen verilerin hangi degerlere sahip oldugunu kontrol etmek icin Loglar olusturdum
                /*System.out.println(" kavsak1dizi.get(i) "+ kavsak1dizi.get(i));
                System.out.println(" ortalama%kavsak1dizi.get(i)  "+ortalama%kavsak1dizi.get(i));
                System.out.println(" Uzaklik "+uzaklik);*/
            }
        }

//      System.out.println(" Uzaklik "+uzaklik);
        ortMutlakSapma = (double) uzaklik/konyadizi.size();
        System.out.format("Konya - Ortalama Mutlak Sapma = %.2f\n",ortMutlakSapma);

        //istanbul
        toplam = 0;
        uzaklik=0.0;

        for (i = 0; i < istanbuldizi.size(); i++) {
            toplam+=istanbuldizi.get(i);
        }
        ortalama = (double)toplam/istanbuldizi.size();

//        System.out.println(" ORtalama "+ortalama);

        for (i = 0; i < istanbuldizi.size(); i++) {
            if(ortalama>istanbuldizi.get(i)){
                uzaklik += (ortalama-istanbuldizi.get(i));
            }
            else{
                uzaklik += (istanbuldizi.get(i)-ortalama);
            }
        }

//      System.out.println(" Uzaklik "+uzaklik);
        ortMutlakSapma = (double) uzaklik/istanbuldizi.size();
        System.out.format("Istanbul - Ortalama Mutlak Sapma = %.2f\n",ortMutlakSapma);


        //Ankara
        toplam = 0;
        uzaklik=0.0;

        for (i = 0; i < ankaradizi.size(); i++) {
            toplam+=ankaradizi.get(i);
        }
        ortalama = (double)toplam/ankaradizi.size();

//        System.out.println(" ORtalama "+ortalama);

        for (i = 0; i < ankaradizi.size(); i++) {
            if(ortalama>ankaradizi.get(i)){
                uzaklik += (ortalama-ankaradizi.get(i));
            }
            else{
                uzaklik += (ankaradizi.get(i)-ortalama);
            }
        }

//      System.out.println(" Uzaklik "+uzaklik);
        ortMutlakSapma = (double) uzaklik/ankaradizi.size();
        System.out.format("Ankara - Ortalama Mutlak Sapma = %.2f\n",ortMutlakSapma);

        //Antalya
        toplam = 0;
        uzaklik=0.0;

        for (i = 0; i < antalyadizi.size(); i++) {
            toplam+=antalyadizi.get(i);
        }
        ortalama = (double)toplam/antalyadizi.size();

//        System.out.println(" ORtalama "+ortalama);

        for (i = 0; i < antalyadizi.size(); i++) {
            if(ortalama>antalyadizi.get(i)){
                uzaklik += (ortalama-antalyadizi.get(i));
            }
            else{
                uzaklik += (antalyadizi.get(i)-ortalama);
            }
        }

//      System.out.println(" Uzaklik "+uzaklik);
        ortMutlakSapma = (double) uzaklik/antalyadizi.size();
        System.out.format("Antalya - Ortalama Mutlak Sapma = %.2f\n",ortMutlakSapma);
    }

    static void yagisVaryans(List<Yagis> yagisList) {
        List<Double> konyadizi = new ArrayList<Double>();
        List<Double> istanbuldizi = new ArrayList<Double>();
        List<Double> ankaradizi = new ArrayList<Double>();
        List<Double> antalyadizi = new ArrayList<Double>();

        for (Yagis yagis: yagisList) {
            konyadizi.add(yagis.getKonya());
            istanbuldizi.add(yagis.getIstanbul());
            ankaradizi.add(yagis.getAnkara());
            antalyadizi.add(yagis.getAntalya());
        }
        Collections.sort(konyadizi);
        Collections.sort(istanbuldizi);
        Collections.sort(ankaradizi);
        Collections.sort(antalyadizi);

        int toplam = 0;
        double ortMutlakSapma,ortalama,uzaklik=0.0,karelerininToplami=0.0,varyans=0.0;
        int i;

        for (i = 0; i < konyadizi.size(); i++) {
            toplam+=konyadizi.get(i);
        }
        ortalama = (double)toplam/konyadizi.size();

//        System.out.println(" ORtalama "+ortalama);

        for (i = 0; i < konyadizi.size(); i++) {
            if(ortalama>konyadizi.get(i)){
                uzaklik = ortalama - konyadizi.get(i);
                karelerininToplami += Math.pow(uzaklik,2);
            }
            else{
                uzaklik = konyadizi.get(i) - ortalama ;
                karelerininToplami += Math.pow(uzaklik,2);
            }
        }
//        System.out.println("karelerininToplami "+karelerininToplami);
        varyans = (double) karelerininToplami/(konyadizi.size()-1);
        System.out.format("konya yagis miktarinin - Varyans = %.2f\n",varyans);

        //Istanbul
        toplam = 0;
        uzaklik=0.0;
        karelerininToplami=0.0;
        varyans=0.0;

        for (i = 0; i < istanbuldizi.size(); i++) {
            toplam+=istanbuldizi.get(i);
        }
        ortalama = (double)toplam/istanbuldizi.size();
        for (i = 0; i < istanbuldizi.size(); i++) {
            if(ortalama>istanbuldizi.get(i)){
                uzaklik = ortalama - istanbuldizi.get(i);
                karelerininToplami += Math.pow(uzaklik,2);
            }
            else{
                uzaklik = istanbuldizi.get(i) - ortalama ;
                karelerininToplami += Math.pow(uzaklik,2);
            }
        }
//        System.out.println("karelerininToplami "+karelerininToplami);
        varyans = (double) karelerininToplami/(istanbuldizi.size()-1);
        System.out.format("istanbul yagis miktarinin Varyansi = %.2f\n",varyans);


        //Ankara
        toplam = 0;
        uzaklik=0.0;
        karelerininToplami=0.0;
        varyans=0.0;

        for (i = 0; i < ankaradizi.size(); i++) {
            toplam+=ankaradizi.get(i);
        }
        ortalama = (double)toplam/ankaradizi.size();
        for (i = 0; i < ankaradizi.size(); i++) {
            if(ortalama>ankaradizi.get(i)){
                uzaklik = ortalama - ankaradizi.get(i);
                karelerininToplami += Math.pow(uzaklik,2);
            }
            else{
                uzaklik = ankaradizi.get(i) - ortalama ;
                karelerininToplami += Math.pow(uzaklik,2);
            }
        }
//        System.out.println("karelerininToplami "+karelerininToplami);
        varyans = (double) karelerininToplami/(ankaradizi.size()-1);
        System.out.format("ankara yagis miktarinin Varyans = %.2f\n",varyans);

        //Antalya
        toplam = 0;
        uzaklik=0.0;
        karelerininToplami=0.0;
        varyans=0.0;

        for (i = 0; i < antalyadizi.size(); i++) {
            toplam+=antalyadizi.get(i);
        }
        ortalama = (double)toplam/antalyadizi.size();
        for (i = 0; i < antalyadizi.size(); i++) {
            if(ortalama>antalyadizi.get(i)){
                uzaklik = ortalama - antalyadizi.get(i);
                karelerininToplami += Math.pow(uzaklik,2);
            }
            else{
                uzaklik = antalyadizi.get(i) - ortalama ;
                karelerininToplami += Math.pow(uzaklik,2);
            }
        }
//        System.out.println("karelerininToplami "+karelerininToplami);
        varyans = (double) karelerininToplami/(antalyadizi.size()-1);
        System.out.format("antalya yagis miktarinin - Varyansi = %.2f\n",varyans);
    }

    static void yagisStandartSapma(List<Yagis> yagisList){
        List<Double> konyadizi = new ArrayList<Double>();
        List<Double> istanbuldizi = new ArrayList<Double>();
        List<Double> ankaradizi = new ArrayList<Double>();
        List<Double> antalyadizi = new ArrayList<Double>();

        for (Yagis yagis: yagisList) {
            konyadizi.add(yagis.getKonya());
            istanbuldizi.add(yagis.getIstanbul());
            ankaradizi.add(yagis.getAnkara());
            antalyadizi.add(yagis.getAntalya());
        }
        Collections.sort(konyadizi);
        Collections.sort(istanbuldizi);
        Collections.sort(ankaradizi);
        Collections.sort(antalyadizi);

        //Konya
        double toplam = 0.0, standartSapma = 0.0,ortalama;
        for(double sayi : konyadizi) {
            toplam += sayi;
        }

        ortalama= toplam/konyadizi.size();

        for(double sayi: konyadizi) {
            standartSapma += Math.pow(sayi - ortalama, 2);
        }

        System.out.println("Konya Yagis Miktari Standart Sapmasi = "+ Math.sqrt(standartSapma/konyadizi.size()));

        //istanbul
        toplam = 0.0;
        standartSapma = 0.0;
        ortalama=0.0;
        for(double sayi : istanbuldizi) {
            toplam += sayi;
        }

        ortalama = toplam/istanbuldizi.size();

        for(double sayi: istanbuldizi) {
            standartSapma += Math.pow(sayi - ortalama, 2);
        }
        System.out.println("istanbul Yagis Miktari Standart Sapmasi = "+ Math.sqrt(standartSapma/istanbuldizi.size()));

        //Ankara
        toplam = 0.0;
        standartSapma = 0.0;
        ortalama=0.0;
        for(double sayi : ankaradizi) {
            toplam += sayi;
        }
        ortalama = toplam/ankaradizi.size();

        for(double sayi: ankaradizi) {
            standartSapma += Math.pow(sayi - ortalama, 2);
        }
        System.out.println("Ankara Yagis Miktari Standart Sapmasi = "+ Math.sqrt(standartSapma/ankaradizi.size()));

        //Antalya
        toplam = 0.0;
        standartSapma = 0.0;
        ortalama=0.0;
        for(double sayi : antalyadizi) {
            toplam += sayi;
        }
        ortalama = toplam/antalyadizi.size();

        for(double sayi: antalyadizi) {
            standartSapma += Math.pow(sayi - ortalama, 2);
        }
        System.out.println("Antalya Yagis Miktari Standart Sapmasi = "+ Math.sqrt(standartSapma/ankaradizi.size()));
    }

    static double ortalama(List<Double> kavsak1dizi) {
        double toplam = 0;

        for (int i = 0; i < kavsak1dizi.size(); i++)
            toplam = toplam + kavsak1dizi.get(i);
        return toplam / kavsak1dizi.size();
    }

    static void yagisDegisimKatsayisi(List<Yagis> yagisList){
        List<Double> konyadizi = new ArrayList<Double>();
        List<Double> istanbuldizi = new ArrayList<Double>();
        List<Double> ankaradizi = new ArrayList<Double>();
        List<Double> antalyadizi = new ArrayList<Double>();

        for (Yagis yagis: yagisList) {
            konyadizi.add(yagis.getKonya());
            istanbuldizi.add(yagis.getIstanbul());
            ankaradizi.add(yagis.getAnkara());
            antalyadizi.add(yagis.getAntalya());
        }
        Collections.sort(konyadizi);
        Collections.sort(istanbuldizi);
        Collections.sort(ankaradizi);
        Collections.sort(antalyadizi);

        //Konya
        double toplam = 0;
        double degisimKatsayisi;
        for (int i = 0; i < konyadizi.size(); i++) {
            toplam = toplam + (konyadizi.get(i) - ortalama(konyadizi)) * (konyadizi.get(i) - ortalama(konyadizi));
        }
        degisimKatsayisi = (Math.sqrt(toplam / (konyadizi.size() - 1)) / ortalama(konyadizi) );

        System.out.format("konya Degisim Katsayisi = %.3f\n",degisimKatsayisi);

        //Istanbul
        toplam = 0;
        for (int i = 0; i < istanbuldizi.size(); i++) {
            toplam = toplam + (istanbuldizi.get(i) - ortalama(istanbuldizi)) * (istanbuldizi.get(i) - ortalama(istanbuldizi));
        }
        degisimKatsayisi = (Math.sqrt(toplam / (istanbuldizi.size() - 1)) / ortalama(istanbuldizi) );

        System.out.format("istanbul Degisim Katsayisi = %.3f\n",degisimKatsayisi);


        //Ankara
        toplam = 0;
        for (int i = 0; i < ankaradizi.size(); i++) {
            toplam = toplam + (ankaradizi.get(i) - ortalama(ankaradizi)) * (ankaradizi.get(i) - ortalama(ankaradizi));
        }
        degisimKatsayisi = (Math.sqrt(toplam / (ankaradizi.size() - 1)) / ortalama(ankaradizi) );

        System.out.format("Ankara Degisim Katsayisi = %.3f\n",degisimKatsayisi);

        //Antalya
        toplam = 0;
        for (int i = 0; i < antalyadizi.size(); i++) {
            toplam = toplam + (antalyadizi.get(i) - ortalama(antalyadizi)) * (antalyadizi.get(i) - ortalama(antalyadizi));
        }
        degisimKatsayisi = (Math.sqrt(toplam / (antalyadizi.size() - 1)) / ortalama(antalyadizi) );

        System.out.format("Antalya Degisim Katsayisi = %.3f\n",degisimKatsayisi);
    }


    static void yagisCeyreklerAcikligi(List<Yagis> yagisList){
        List<Double> konyadizi = new ArrayList<Double>();
        List<Double> istanbuldizi = new ArrayList<Double>();
        List<Double> ankaradizi = new ArrayList<Double>();
        List<Double> antalyadizi = new ArrayList<Double>();

        for (Yagis yagis: yagisList) {
            konyadizi.add(yagis.getKonya());
            istanbuldizi.add(yagis.getIstanbul());
            ankaradizi.add(yagis.getAnkara());
            antalyadizi.add(yagis.getAntalya());
        }
        Collections.sort(konyadizi);
        Collections.sort(istanbuldizi);
        Collections.sort(ankaradizi);
        Collections.sort(antalyadizi);

        //Konya
        double altgrup,ustgrup;
        double ceyrekacikligi;
        List<Double> konyadiziAltceyrek = new ArrayList<Double>();
        List<Double> konyadiziUstceyrek = new ArrayList<Double>();
        if(konyadizi.size()%2==1){
            for (int i = 0; i < konyadizi.size()/2; i++) {
                konyadiziAltceyrek.add(konyadizi.get(i));
            }
            altgrup=konyadiziAltceyrek.get((konyadizi.size()/2)/2);
            for (int i = (konyadizi.size()/2)+1; i < konyadizi.size(); i++) {
                konyadiziUstceyrek.add(konyadizi.get(i));
            }
            ustgrup=konyadiziUstceyrek.get((konyadizi.size()/2)/2);

            ceyrekacikligi = ustgrup - altgrup;
        }else{
            for (int i = 0; i < konyadizi.size()/2; i++) {
                konyadiziAltceyrek.add(konyadizi.get(i));
            }
            altgrup=konyadiziAltceyrek.get((konyadizi.size()/2)/2);
            for (int i = (konyadizi.size()/2); i < konyadizi.size(); i++) {
                konyadiziUstceyrek.add(konyadizi.get(i));
            }
            ustgrup=konyadiziUstceyrek.get((konyadizi.size()/2)/2);

            ceyrekacikligi = ustgrup - altgrup;
        }
        System.out.format("Konya Ceyrek Araligi = %.1f\n",ceyrekacikligi);



        //Istanbul
        List<Double> istanbuldiziAltceyrek = new ArrayList<Double>();
        List<Double> istanbuldiziUstceyrek = new ArrayList<Double>();
        if(istanbuldizi.size()%2==1){
            for (int i = 0; i < istanbuldizi.size()/2; i++) {
                istanbuldiziAltceyrek.add(istanbuldizi.get(i));
            }
            altgrup=istanbuldiziAltceyrek.get((istanbuldizi.size()/2)/2);
            for (int i = (istanbuldizi.size()/2)+1; i < istanbuldizi.size(); i++) {
                istanbuldiziUstceyrek.add(istanbuldizi.get(i));
            }
            ustgrup=istanbuldiziUstceyrek.get((istanbuldizi.size()/2)/2);

            ceyrekacikligi = ustgrup - altgrup;
        }else{
            for (int i = 0; i < istanbuldizi.size()/2; i++) {
                istanbuldiziAltceyrek.add(istanbuldizi.get(i));
            }
            altgrup=istanbuldiziAltceyrek.get((istanbuldizi.size()/2)/2);
            for (int i = (istanbuldizi.size()/2); i < istanbuldizi.size(); i++) {
                istanbuldiziUstceyrek.add(istanbuldizi.get(i));
            }
            ustgrup=istanbuldiziUstceyrek.get((istanbuldizi.size()/2)/2);

            ceyrekacikligi = ustgrup - altgrup;
        }
        System.out.format("Istanbul Ceyrek Araligi = %.1f\n",ceyrekacikligi);

        //Ankara
        List<Double> ankaradiziAltceyrek = new ArrayList<Double>();
        List<Double> ankaradiziUstceyrek = new ArrayList<Double>();
        if(ankaradizi.size()%2==1){
            for (int i = 0; i < ankaradizi.size()/2; i++) {
                ankaradiziAltceyrek.add(ankaradizi.get(i));
            }
            altgrup=ankaradiziAltceyrek.get((ankaradizi.size()/2)/2);
            for (int i = (ankaradizi.size()/2)+1; i < ankaradizi.size(); i++) {
                ankaradiziUstceyrek.add(ankaradizi.get(i));
            }
            ustgrup=ankaradiziUstceyrek.get((ankaradizi.size()/2)/2);

            ceyrekacikligi = ustgrup - altgrup;
        }else{
            for (int i = 0; i < ankaradizi.size()/2; i++) {
                ankaradiziAltceyrek.add(ankaradizi.get(i));
            }
            altgrup=ankaradiziAltceyrek.get((ankaradizi.size()/2)/2);
            for (int i = (ankaradizi.size()/2); i < ankaradizi.size(); i++) {
                ankaradiziUstceyrek.add(ankaradizi.get(i));
            }
            ustgrup=ankaradiziUstceyrek.get((ankaradizi.size()/2)/2);

            ceyrekacikligi = ustgrup - altgrup;
        }
        System.out.format("Ankara Ceyrek Araligi = %.1f\n",ceyrekacikligi);



        //Antalya
        List<Double> antalyadiziAltceyrek = new ArrayList<Double>();
        List<Double> antalyadiziUstceyrek = new ArrayList<Double>();
        if(antalyadizi.size()%2==1){
            for (int i = 0; i < antalyadizi.size()/2; i++) {
                antalyadiziAltceyrek.add(antalyadizi.get(i));
            }
            altgrup=antalyadiziAltceyrek.get((antalyadizi.size()/2)/2);
            for (int i = (antalyadizi.size()/2)+1; i < antalyadizi.size(); i++) {
                antalyadiziUstceyrek.add(antalyadizi.get(i));
            }
            ustgrup=antalyadiziUstceyrek.get((antalyadizi.size()/2)/2);

            ceyrekacikligi = ustgrup - altgrup;
        }else{
            for (int i = 0; i < antalyadizi.size()/2; i++) {
                antalyadiziAltceyrek.add(ankaradizi.get(i));
            }
            altgrup=antalyadiziAltceyrek.get((ankaradizi.size()/2)/2);
            for (int i = (ankaradizi.size()/2); i < ankaradizi.size(); i++) {
                antalyadiziUstceyrek.add(ankaradizi.get(i));
            }
            ustgrup=antalyadiziUstceyrek.get((ankaradizi.size()/2)/2);

            ceyrekacikligi = ustgrup - altgrup;
        }
        System.out.format("Antalya Ceyrek Araligi  = %.1f\n",ceyrekacikligi);
    }

    static void yagisDegisimAraligi(List<Yagis> yagisList){
        List<Double> konyadizi = new ArrayList<Double>();
        List<Double> istanbuldizi = new ArrayList<Double>();
        List<Double> ankaradizi = new ArrayList<Double>();
        List<Double> antalyadizi = new ArrayList<Double>();

        for (Yagis yagis: yagisList) {
            konyadizi.add(yagis.getKonya());
            istanbuldizi.add(yagis.getIstanbul());
            ankaradizi.add(yagis.getAnkara());
            antalyadizi.add(yagis.getAntalya());
        }
        System.out.println("Konya = " + (Collections.max(konyadizi) - Collections.min(konyadizi) + 1));
        System.out.println("Istanbul = " + (Collections.max(istanbuldizi) - Collections.min(istanbuldizi) + 1));
        System.out.println("Ankara = " + (Collections.max(ankaradizi) - Collections.min(ankaradizi) + 1));
        System.out.println("Antalya = " + (Collections.max(antalyadizi) - Collections.min(antalyadizi) + 1));
    }
}
