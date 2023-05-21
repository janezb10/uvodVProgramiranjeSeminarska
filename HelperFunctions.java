import java.io.*;
import java.util.*;

public class HelperFunctions {

    public static ArrayList<Izdelek> readIzdelki() throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("zaloga.txt"));

        ArrayList<Izdelek> izdelki = new ArrayList<Izdelek>();
        String s;
        while((s=br.readLine()) != null) {
            String[] arr = s.split(" ");

            switch(arr[0]) {
                case "Ovitek":
                    izdelki.add(new Ovitek(arr[1], Float.parseFloat(arr[2]), Boolean.parseBoolean(arr[3]), Float.parseFloat(arr[4]), Integer.parseInt(arr[5])));
                break;
            }
        }
        br.close();
        return izdelki;
    }

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

    public static void productEntry(ArrayList<Izdelek> izdelki) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Vnesi ime izdelka: ");
        String imeIzdelka = br.readLine();
        Izdelek izdelek = null;
        for(int i=0; i<izdelki.size(); i++) {
            System.out.println(izdelki.get(i).imeIzdelka);
            if(izdelki.get(i).imeIzdelka.equals(imeIzdelka)) {
                izdelek = izdelki.get(i);
                break;
            }
        }
        if(izdelek instanceof Izdelek) {
            System.out.println("Izdelek je ze v sistemu");
            System.out.println("Koliko izdelkov zelite dodati?");
            int n = Integer.parseInt(br.readLine());
            izdelek.zaloga += n;
            System.out.println("Nova zaloga izdelka " + izdelek.imeIzdelka + ": "+ izdelek.zaloga);
        }
        else {
            System.out.println("Tega izdelka še ni v sistemu");
            System.out.println("Izberi kategorijo: ");
            System.out.println("1 -Mobilna Oprema");
            System.out.println("2 -Računalniki");
            int kategorija = Integer.parseInt(br.readLine());
            switch(kategorija) {
                case 1:
                    System.out.println("Izberi podkategorijo: ");
                    System.out.println("1 -Mobilni Telefon");
                    System.out.println("2 -Ovitek");
                    System.out.println("3 -Slusalke");
                    int podkategorija = Integer.parseInt(br.readLine());
                    switch(podkategorija) {
                        case 1:
                            izdelki = MobilniTelefon.novMobilniTelefon(izdelki, imeIzdelka);
                            HelperFunctions.writeInFile(izdelki);
                            System.out.println("Izdelek vnešen");
                            break;
                        case 2:

                            break;
                    }
                    break;
                case 2:

                    break;
            }
        }
        writeInFile(izdelki);

    }

    // public static void productEntry(ArrayList<Izdelek> izdelki) throws Exception{
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     System.out.println("Vnesite kategorijo: ");
    //     System.out.println("1 -MobilnaOprema");
    //     System.out.println("2 -Racunalnik");

    //     int kategorija = Integer.parseInt(br.readLine());
    //     switch(kategorija) {
    //         case 1:
    //             // MobilnaOprema.newMobilnaOprema(izdelki);
    //             break;
    //         case 2:

    //             break;
    //     }
    // }

}
