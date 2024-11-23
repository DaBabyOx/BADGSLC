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

public class Main {
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

        for(hewan i:h){
            i.print();}}}