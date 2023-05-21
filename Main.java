import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Izdelek> izdelki = Izdelek.readIzdelki();

        while(true) {
            try {
                izdelki = Izdelek.readIzdelki();   // Hej kam to
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
                        Izdelek.productEntry(izdelki);
                        break;
                }


            } catch (Exception e) {
                System.out.println("exception v Mainu");
    
            }
        }
        
    }
    


}