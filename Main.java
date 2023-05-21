import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Izdelek> izdelki = HelperFunctions.readIzdelki();

        // Ovitek cc = new Ovitek("Prelep", 5, false, 0, 3);
        // izdelki.add(new Ovitek("Prelep", 5, false, 0, 3));

        // System.out.println(izdelki.get(0));
        while(true) {
            try {
                System.out.println("Kaj zelite storiti? (vnesite stevilko)");
                System.out.println("0 -Izhod iz programa");
                System.out.println("1 -izpis vseh izdelkov");
                System.out.println("2 -zapiši v datoteko");
                System.out.println("3 -vnos izdelkov");
                System.out.println("4 -brisanje odpisanih/prodanih");


                int i = Integer.parseInt(br.readLine());
                switch(i){
                    case 0:
                        return;
                    case 1:
                        HelperFunctions.writeItOut(izdelki);
                        break;
                    case 2:
                        HelperFunctions.writeInFile(izdelki);
                        break;
                    case 3:
                        HelperFunctions.productEntry(izdelki);
                        // izdelki = HelperFunctions.readIzdelki();
                        break;

                }


            } catch (Exception e) {
                System.out.println("exception v Mainu");
    
            }
        }


        // HelperFunctions.readIzdelki();
        // System.out.println("asdf");
        
    }
    


}