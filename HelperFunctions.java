import java.io.*;
import java.util.*;

public class HelperFunctions {


    public static void writeInFile(ArrayList<Izdelek> izdelki) throws Exception{
        BufferedWriter bw = new BufferedWriter(new FileWriter("zaloga.txt"));
        String str = "podkategorija, imeIzdelka, cena, vAkciji, akcijaProcentov, zaloga, kategorija...\n";
        for(int i=0; i<izdelki.size(); i++) {
            str += (izdelki.get(i) + "\n");
        }
        
        bw.write(str);
        bw.close();
    }

    public static void writeItOut(ArrayList<Izdelek> izdelki) {
        System.out.println();
        for(int i=0; i<izdelki.size(); i++) {
            System.out.println(izdelki.get(i).izpisi());
        }
        System.out.println();
    }

    public static void writeInFileSold(Izdelek izdelekP, int n) throws Exception{
        ArrayList<Izdelek> prodaniIzdelki = Izdelek.readIzdelki("prodaniIzdelki.txt");
        
        String str = "";
        
        Izdelek izdelek = null;
        for(int i=0; i<prodaniIzdelki.size(); i++) {
            if(prodaniIzdelki.get(i).imeIzdelka.equals(izdelekP.imeIzdelka)) {
                izdelek = prodaniIzdelki.get(i);
                break;
            }
        }
        if(izdelek instanceof Izdelek) {
            izdelek.zaloga += n;

        }
        else {
            System.out.println("Ta izdelek je prodan prvic");
            int zaloga = izdelekP.zaloga;
            izdelekP.zaloga = n;
            str += (izdelekP + "\n");
            izdelekP.zaloga = zaloga;
        }
        for(int i=0; i<prodaniIzdelki.size(); i++) {
            str += (prodaniIzdelki.get(i) + "\n");
        }
        
        BufferedWriter bw = new BufferedWriter(new FileWriter("prodaniIzdelki.txt"));
        bw.write(str);
        bw.close();
    }
}
