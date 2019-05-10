


// Du beh�ver att skapa bara en Folder som heter JavaFiles p� C drive
// f�r att k�ra det program.

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

   static List<Produkt> produkter=new LinkedList<>();
    static Scanner in=new Scanner(System.in);
    static int  val=0;


    public static void main(String[] args) {
        String filInput="C:\\JavaFiles\\produkt.ser";
        produkter= hittaAllaObjekt(filInput);
       meny();
            while (val>=0 && val <7){
                switch (val){
                    case 1:
                        addProdukt();
                        meny();
                        break;
                    case 2:
                        visaProduk();
                        meny();
                        break;

                    case 3:
                        tabortProdukt();
                        meny();
                        break;
                    case 4:
                        f�r�ndraProdukt();
                        meny();
                        break;
                    case 5:
                        hittaProdukt();
                        meny();
                        break;
                    case 6:
                        r�knaTotaltProdukt();
                        meny();
                        break;

                    default:
                        System.out.println("0 f�r exit");
                        skrivaAllaObjekt(produkter,filInput);
                        System.exit(0);
                }
            }

        }

    public static void meny(){
        System.out.println("1 f�r l�gga till nya produkter. ");
        System.out.println("2 f�r lista alla produkt");
        System.out.println("3 f�r ta bort  en produkt med id");
        System.out.println("4 f�r �ndra n�gon produkt");
        System.out.println("5 f�r s�ka efter en specefik produkt med id ");
        System.out.println("6 f�r ber�kna totalt v�rdet av alla produkter");
        System.out.println("0 f�r exit");

        System.out.print("Anga ett nummer fr�n Meny, mellan 0 och 6: ");
        val=Integer.parseInt(in.nextLine());
    }


    private static void r�knaTotaltProdukt() {
        int totalPris=0;
        int totalAntal=0;

        for(Produkt p: produkter){
            totalPris+=p.getPris();
            totalAntal+=p.getAntal();
        }
        System.out.println("\nTotal pris f�r alla produkt �r: "+totalPris);
        System.out.println("Total antal f�r alla produkt �r: "+totalAntal);
    }

    private static void hittaProdukt() {
        System.out.println("Enter a produkt id: ");
        int pid=Integer.parseInt(in.nextLine());
        for (Produkt p: produkter){
            if(p.getProdukt_id()==pid){
                System.out.println(p);
            }
            else{
                System.out.println("Finns inte produkten");
            }
        }
    }

    private static void f�r�ndraProdukt() {
        System.out.println("Ange produkt ide f�r att �ndra produkt uppgifter");
        int pid=Integer.parseInt(in.nextLine());
        try {
            for (Produkt p : produkter) {
                if (p.getProdukt_id() == pid) {

                    System.out.print("Produkts nyt namn: ");

                    String p_namn = in.nextLine();
                    System.out.print("Produkt nyt antal: ");
                    int p_antal = Integer.parseInt(in.nextLine());
                    System.out.print("Produkt nyt pris: ");
                    int p_pris = Integer.parseInt(in.nextLine());

                    Produkt np = new Produkt(pid, p_namn, p_antal, p_pris);
                    produkter.set(produkter.indexOf(p), np);
                    System.out.println();
                }
            }
        }
        catch (Exception e){
            System.out.println("Finns inte produkten"+e);
        }

    }

    private static void tabortProdukt() {
        System.out.println("ange produkt id f�r att ta bort: ");
        int pid=Integer.parseInt(in.nextLine());
        try{
            for (Produkt p: produkter){
                if(p.getProdukt_id()==pid){
                    produkter.remove(p.getProdukt_id());
                    //  System.out.println(produkter.indexOf(p));
                }

            }
        }
        catch (Exception e){
            System.out.println(" Deleted ");
        }

    }


    public static void addProdukt(){
        System.out.print("Produkt ID: ");
        int p_id=Integer.parseInt(in.nextLine());
           for(Produkt pp:produkter){
               if(pp.getProdukt_id()==p_id){
                   System.out.println("Det finns samma produkt id redan ange en annan id: ");
                   //addProdukt();
                   meny();
               }
           }
        System.out.print("Produkt namn: ");
        String p_namn=in.nextLine();
        System.out.print("Produkt antal: ");
        int p_antal=Integer.parseInt(in.nextLine());
        System.out.print("Produkt pris: ");
        int p_pris=Integer.parseInt(in.nextLine());

        Produkt p = new Produkt(p_id,p_namn,p_antal,p_pris);
        produkter.add(p);




    }

        public static void visaProduk(){

            System.out.println("\nProkukt lista: \n");
          
            
            produkter.forEach((p)-> System.out.println(p.toString()));
            System.out.println();
        }


        // Serialization

        public static  void skrivaAllaObjekt(List<Produkt> objekt, String fileName){
        try{
            FileOutputStream filOut=new FileOutputStream(fileName);
            ObjectOutputStream objektOut=new ObjectOutputStream(filOut);
            objektOut.writeObject(objekt);
            System.out.println("Serialization sparad: "+fileName);
            objektOut.close();
            filOut.close();
        }
         catch (IOException i){
            i.printStackTrace();
         }

        }

        public static LinkedList hittaAllaObjekt( String fileName){
        Produkt produkter=null;
        try{
            FileInputStream filIn=new FileInputStream(fileName);
            ObjectInputStream objektIn = new ObjectInputStream(filIn);
                LinkedList prLinkedList = (LinkedList) objektIn.readObject();
            System.out.println("Deserialized data is "+fileName);
                return prLinkedList;

        }
         catch (IOException i){
            i.printStackTrace();
            return null;
         }
        catch (ClassNotFoundException c){
            System.out.println("Finns inte classen");
            c.printStackTrace();
            return null;
        }

        }


    }


