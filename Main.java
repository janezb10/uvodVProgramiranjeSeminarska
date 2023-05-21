import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Izdelek> izdelki;

        while(true) {
            try {
                izdelki = Izdelek.readIzdelki("zaloga.txt");
                System.out.println("Kaj zelite storiti? (vnesite stevilko)");
                System.out.println("0 -Izhod iz programa");
                System.out.println("1 -izpis vseh izdelkov");
                System.out.println("2 -vnos izdelkov");
                System.out.println("3 -brisanje odpisanih izdelkov");
                System.out.println("4 -prodaja izdelkov");
                System.out.println("5 -vracilo izdelkov");
                System.out.println("6 -evidenca blagajne");


                int i = Integer.parseInt(br.readLine());
                switch(i){
                    case 0:
                        return;
                    case 1:
                        HelperFunctions.writeItOut(izdelki);
                        break;
                    case 2:
                        Izdelek.productEntry(izdelki);
                        break;
                    case 3:
                        Izdelek.productRemove(izdelki);
                        break;
                    case 4:
                        Izdelek.prodaja(izdelki);
                        break;
                    case 5:

                        break;
                }


            } catch (Exception e) {
                // System.out.println("exception v Mainu");
    
            }
        }
        
    }
}