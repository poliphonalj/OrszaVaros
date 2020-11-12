import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WorldStatistics {

    final static String countriesFile = "C:\\java\\src\\orszagok.txt";
    final static String citiesFile = "C:\\java\\src\\varosok.txt";
    static  ArrayList<City> cityContainer = new ArrayList<>();
    static ArrayList<Country> countryContainer = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        readFile(countriesFile, citiesFile);


        //System.out.println(countryContainer.get(0).getRuralPopulation()+"gsdgsdgsdgsgsgsgsgsgsdgsgsd");
        //System.out.println(findCountryByISoCode("AGO"));  ++
        //System.out.println(getCountriesOfContinent("Africa"));  ++
        System.out.println(getCitiesOfCountry("AGO"));
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
                //System.out.println(countryContainer);
            }

            while (scCity.hasNextLine()) {
                cityLine = scCity.nextLine();
                cityLineParts = cityLine.split(",", 3);
                cityContainer.add(new City(cityLineParts[0], cityLineParts[1], Long.parseLong(cityLineParts[2])));
            }
int i=0;
            System.out.println(countryContainer.size());

            for (Country actualCountry : countryContainer) {
                       //a country-nak a cityket tartalmazo fieldjet tolti fel
                i++;
                System.out.println(i);
                for (City actualCity : cityContainer) {
                    if (actualCountry.getCountryCode().equals(actualCity.getCountryCode())) {
                        actualCountry.setCities(actualCity);
                        //System.out.println(actualCity.getCityName()+"  "+actualCountry.toString());}
                        System.out.println(actualCountry.getCities()+"ddfdfdfdfdfd");

                    }

                    break;  }
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage() + " " + e.toString());
        }

    }

   /*
   ?rj egy olyan met?dust, ami orsz?gk?d alapj?n visszaadja egy orsz?g ?sszes adat?t!
    A met?dus szignat?r?ja az al?bbi legyen:
    public Country findCountryByISoCode(String isoCode)
    */

    public static Country findCountryByISoCode(String isoCode){
        Country c=null;
        for (Country actualCountry : countryContainer) {
            if(actualCountry.getCountryCode().equals(isoCode)){
                c= actualCountry;
            }
        }
        return c;
    }


   /*
   ?rj egy olyan met?dust, amely visszaadja egy param?ter?l kapott kontinens orsz?gainak az orsz?gk?djait!
    A met?dus szignat?r?ja az al?bbi legyen:
    public ArrayList<String> getCountriesOfContinent(String continentName)
    */

    public static ArrayList<String> getCountriesOfContinent(String continentName){
        ArrayList<String>a=new ArrayList<>();
        for (Country actualcountry : countryContainer) {
            if(actualcountry.getContinent().equals(continentName)){
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

    public static HashSet<String> getCitiesOfCountry(String countryCode){
        HashSet<String>hSet=new HashSet<>();
        for (Country actualCountry : countryContainer) {
            if(actualCountry.getCountryCode().equals(countryCode)){
               // for (int i = 0; i < actualCountry.getCities().size(); i++) {
                 //  hSet.add(actualCountry.getCities().get(i).getCityName());
                }

            }

        return null;
    }



}
