import java.util.ArrayList;

public class Allatkert {
    public static ArrayList<Allat> allatkontener = new ArrayList<>();

    public static void main(String[] args) {
        Kutya rex = new Kutya("tacsko", "europa", 4);
        rex.hangotAd();
        rex.jatszik();

        //System.out.println(rex.getClass());

        Kutya ali = new Kutya("kutya", "afrika", 5);
        Emlos cezar = new Kutya("kutya", "európa", 4);
        Allat ordog = new Kutya("kutya", "afrika", 7);
        System.out.println(ordog.getClass());

        Papagaj pityu = new Papagaj("Papagaj", "amerika", 7, 30);
        Madar gyuri = new Papagaj("Papagaj", "európa", 4, 90);

        Allat cirmi = new Macska("Macska", "Europa", 9, true);
        Macska kormi = new Macska("Macska", "Europa", 11, false);

        allatkontener.add(rex);
        allatkontener.add(ali);
        allatkontener.add(cezar);
        allatkontener.add(ordog);

        allatkontener.add(pityu);
        allatkontener.add(gyuri);

        allatkontener.add(kormi);
        allatkontener.add(cirmi);

        System.out.println(allatkontener.size());


        megszamlal();
        isHaziasitottMacska();
        atlagosFesztav();
        jatszAKutyakkal();
    }

    public static void megszamlal() {

        int kutyacounter = 0;
        int papagajcounter = 0;

        for (Allat actualAllat : allatkontener) {
            if (actualAllat.getClass().toString().contains("class Kutya")) {
                kutyacounter++;
            } else if (actualAllat.getClass().equals("class Papagaj")) {
                papagajcounter++;       //igy nerm mukodik
            }
        }
        System.out.println("kutyak szama: " + kutyacounter + ", papagajok szama: " + papagajcounter);
    }


    public static boolean isHaziasitottMacska() {
        for (Allat actualAllat : allatkontener) {
            if (actualAllat.getClass().toString().contains("class Macska") && ((Macska) (actualAllat)).haziasitott) {
                System.out.println("hazimacska");
                return true;
            }
            if (actualAllat.getClass().toString().contains("class Macska"))
                System.out.println("vadmacska");
        }
        return false;
    }



    public static double atlagosFesztav (){
        double atlagfesztav=0.0;
        int counter=0;
        int fesztav=0;
        for (Allat actualAllat : allatkontener) {
            if(actualAllat.getClass().toString().contains("class Papagaj")){
             fesztav+=((Madar)actualAllat).getFesztavolsag();
             counter++;
            }

        }
        atlagfesztav=fesztav/counter;
        System.out.println(atlagfesztav);
        return atlagfesztav;
    }


    public static void jatszAKutyakkal(){
        for (Allat actualAllat : allatkontener) {
            if(actualAllat.getClass().toString().contains("class Kutya")){
                ((Kutya)(actualAllat)).jatszik();
            }
        }
    }


}
