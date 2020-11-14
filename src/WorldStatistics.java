import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WorldStatistics {

    final static String countriesFile = "C:\\java\\src\\orszagok.txt";
    final static String citiesFile = "C:\\java\\src\\varosok.txt";
    static ArrayList<City> cityContainer = new ArrayList<>();
    static ArrayList<Country> countryContainer = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        readFile(countriesFile, citiesFile);

        //System.out.println(countryContainer.get(6).getRuralPopulation());
        //System.out.println(countryContainer.get(1).getPopulationDensity());
        //System.out.println(findCountryByISoCode("AGO"));
        //System.out.println(getCountriesOfContinent("Africa"));
        //System.out.println(getCitiesOfCountry("AFG"));
        //System.out.println(getAhmedCount());
        //System.out.println(getPopularFirstLetter());
        //System.out.println(lastIndependentCountry());
        //System.out.println(cityContainer.get(0).getPopulationPercentage());
    }

    public static void readFile(String countriesFile, String citiesFile) throws FileNotFoundException {
        try {
            String countryLine;
            String cityLine;
            String[] cityLineParts;
            String[] countryLineParts;

            Scanner scCountry = new Scanner(new File(countriesFile));
            Scanner scCity = new Scanner(new File(citiesFile));

            while (scCountry.hasNextLine()) {
                countryLine = scCountry.nextLine();
                countryLineParts = countryLine.split(",", 8);

                if (countryLineParts[5].equals("NULL")) {
                    countryLineParts[5] = "0";
                }
                if (countryLineParts[7].equals("")) {
                    countryLineParts[7] = "";
                }
                Country country = new Country(countryLineParts[0], countryLineParts[1], countryLineParts[2], countryLineParts[3], Double.parseDouble(countryLineParts[4]), Integer.parseInt(countryLineParts[5]), Long.parseLong(countryLineParts[6]), countryLineParts[7]);
                countryContainer.add(country);
            }

            while (scCity.hasNextLine()) {
                cityLine = scCity.nextLine();
                cityLineParts = cityLine.split(",", 3);
                City city = new City(cityLineParts[0], cityLineParts[1], Long.parseLong(cityLineParts[2]));
                cityContainer.add(city);
                for (int i = 0; i < countryContainer.size(); i++) {         //feltolti a countryk ArrayList<City> fieldeket
                    if (countryContainer.get(i).getCountryCode().equals(cityLineParts[1])) {
                        countryContainer.get(i).setCities(city);
                    }
                }
            }
            //System.out.println(countryContainer.get(1).getCities().get(2).getCityName());

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage() + " " + e.toString());
        }
    }

   /*
   ?rj egy olyan met?dust, ami orsz?gk?d alapj?n visszaadja egy orsz?g ?sszes adat?t!
    A met?dus szignat?r?ja az al?bbi legyen:
    public Country findCountryByISoCode(String isoCode)
    */

    public static Country findCountryByISoCode(String isoCode) {
        Country c = null;
        for (Country actualCountry : countryContainer) {
            if (actualCountry.getCountryCode().equals(isoCode)) {
                c = actualCountry;
            }
        }
        return c;
    }


   /*
   ?rj egy olyan met?dust, amely visszaadja egy param?ter?l kapott kontinens orsz?gainak az orsz?gk?djait!
    A met?dus szignat?r?ja az al?bbi legyen:
    public ArrayList<String> getCountriesOfContinent(String continentName)
    */

    public static ArrayList<String> getCountriesOfContinent(String continentName) {
        ArrayList<String> a = new ArrayList<>();
        for (Country actualcountry : countryContainer) {
            if (actualcountry.getContinent().equals(continentName)) {
                a.add(actualcountry.getCountryCode());
            }
        }
        return a;
    }

    /*
    ?rj egy olyan met?dust, amely visszaadja egy param?ter?l kapott orsz?g v?rosainak a neveit
    (az orsz?got orsz?gk?ddal adjuk meg)! A met?dus szignat?r?ja az al?bbi legyen:
    public HashSet<String> getCitiesOfCountry(String countryCode)
     */

    public static HashSet<String> getCitiesOfCountry(String countryCode) {
        HashSet<String> hSet = new HashSet<>();
        for (Country actualCountry : countryContainer) {
            if (actualCountry.getCountryCode().equals(countryCode)) {
                for (int i = 0; i < actualCountry.getCities().size(); i++) {
                    hSet.add(actualCountry.getCities().get(i).getCityName());
                }
            }

        }
        return hSet;
    }

/*
    Hány országnak az államfőjének nevében szerepel “Hamad” vagy “Ahmad” vagy “Ahmed”?
    A metódus szignatúrája az alábbi legyen:
    public int getAhmedCount()
    Egy String objektumban a .indexOf() metódussal tudod megvizsgálni, hogy tartalmaz-e egy adott karaktersorozatot.
 */

    public static int getAhmedCount() {
        int counter = 0;
        for (Country actualCountry : countryContainer) {
            if (actualCountry.getPresident().contains("Hamad") || actualCountry.getPresident().contains("Ahmad") || actualCountry.getPresident().contains("Ahmed")) {
                counter++;
            }
        }
        return counter;
    }


    public static String getPopularFirstLetter() {

        TreeMap<Character, Integer> tMap = new TreeMap<>();
        for (Country actualCountry : countryContainer) {
            Integer i = 0;
            tMap.putIfAbsent(actualCountry.getCountryCode().charAt(0), i);            //a TreeMapbe teszek egy kezdobetut es a 0t, ha meg nincs az adott kezdobetu
            i = tMap.get(actualCountry.getCountryCode().charAt(0));                    //  ha mar van a kezdobetu, akkor novelem a hozzarendelt valuet.
            i++;
            tMap.put(actualCountry.getCountryCode().charAt(0), i);                  //Character-Integer paros
        }

        ArrayList<Integer> a = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {                //kiveszi a leggyakoribb elofordulast
            a.add(entry.getValue());
        }
        Collections.sort(a);
        //System.out.println(tMap);                                                 //kiirja az egyes elofordulasokat betunkent
        int max = a.get(a.size() - 1);
        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            if (entry.getValue() == max) {
                return entry.getKey()+"";
            }
        }
    return null;
    }


 /*
Melyik ország nyerte el legkésőbb (a nyilvántartás szerint) a függetlenségét?
Add vissza a megfelelő országkódot, a metódus szignatúrája az alábbi legyen:
public String lastIndependentCountry()
     */

    public static String lastIndependentCountry(){
        TreeMap<Integer, ArrayList<String>>tMap=new TreeMap<>();
        for (Country actualCountry : countryContainer) {
            tMap.putIfAbsent(actualCountry.getIndependency(),new ArrayList<>());
            tMap.get(actualCountry.getIndependency()).add(actualCountry.getCountryCode());
        }
        return tMap.pollLastEntry()+"";
    }



}
