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
        for(int i=0; i<izdelki.size(); i++) {
            System.out.println(izdelki.get(i));
        }
    }

}
