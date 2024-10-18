package Vertebrata;

import Vertebrata.DarahDingin.Amfibi.Katak;
import Vertebrata.DarahDingin.Amfibi.Kodok;
import Vertebrata.DarahDingin.Amfibi.Salamander;
import Vertebrata.DarahDingin.Ikan.Gurame;
import Vertebrata.DarahDingin.Ikan.IkanMas;
import Vertebrata.DarahDingin.Ikan.Salmon;
import Vertebrata.DarahDingin.Reptil.Buaya;
import Vertebrata.DarahDingin.Reptil.Komodo;
import Vertebrata.DarahDingin.Reptil.Ular;
import Vertebrata.DarahPanas.Burung.Elang;
import Vertebrata.DarahPanas.Burung.Merak;
import Vertebrata.DarahPanas.Burung.Merpati;
import Vertebrata.DarahPanas.Mamalia.Beruang;
import Vertebrata.DarahPanas.Mamalia.Paus;
import Vertebrata.DarahPanas.Mamalia.Singa;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    static class C implements Runnable {
        private final hewan x;
        private final String n;

        public C(hewan x, String n) {
            this.x = x;
            this.n = n;}

        @Override
        public void run() {
            System.out.println(n + " creating " + x.getClass().getSimpleName() + "...");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();}
            System.out.println(n + " done creating " + x.getClass().getSimpleName());}}

    static class P implements Runnable {
        private final hewan x;
        private final String n;

        public P(hewan x, String n) {
            this.x = x;
            this.n = n;}

        @Override
        public void run() {
            System.out.println(n + " processing " + x.getClass().getSimpleName() + "...");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();}
            x.print();
            System.out.println(n + " done processing " + x.getClass().getSimpleName());}}

    public static void main(String[]a){
        hewan[] h ={
                new Katak(),
                new Kodok(),
                new Salamander(),

                new Gurame(),
                new IkanMas(),
                new Salmon(),

                new Buaya(),
                new Komodo(),
                new Ular(),

                new Elang(),
                new Merak(),
                new Merpati(),

                new Beruang(),
                new Paus(),
                new Singa()};

        ExecutorService e = Executors.newFixedThreadPool(5);

        System.out.println("==== Start Creation ====");
        for (int i = 0; i < h.length; i++) {
            String t = "T-" + (i + 1);
            e.execute(new C(h[i], t));
        }

        s(e);

        System.out.println("==== Start Processing ====");
        e = Executors.newFixedThreadPool(5);
        for (int i = 0; i < h.length; i++) {
            String t = "T-" + (i + 1);
            e.execute(new P(h[i], t));}

        s(e);
        System.out.println("==== Done ====");}

    private static void s(ExecutorService p) {
        p.shutdown();
        try {
            if (!p.awaitTermination(60, TimeUnit.SECONDS)) {
                p.shutdownNow();
                if (!p.awaitTermination(60, TimeUnit.SECONDS))
                    System.err.println("Failed Shutdown");
            }
        } catch (InterruptedException i) {
            p.shutdownNow();
            Thread.currentThread().interrupt();}}}