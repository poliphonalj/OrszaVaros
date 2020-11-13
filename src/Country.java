import java.util.ArrayList;

public class Country {
    private String countryCode;
    private String countryName;
    private String continent;
    private String region;
    private double area;
    private int independency;
    private long countryPopulation;
    private String president;
    private ArrayList<City> cities=new ArrayList<>();

    public Country(String countryCode, String countryName, String continent, String region, double area, int independency, long countryPopulation, String president) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.continent = continent;
        this.region = region;
        this.area = area;
        this.independency = independency;
        this.countryPopulation = countryPopulation;
        this.president = president;
    }


    public  double getPopulationDensity(){
        if(countryPopulation==0 || area==0){
            return countryPopulation/area;
        }
        return -1;
    }

    public String getContinent() {
        return continent;
    }


    public  double getRuralPopulation(){     //varosokon kivuli lakosok szama
        long sumPopulation=0;
        for (int i = 0; i < cities.size(); i++) {
           sumPopulation=cities.get(i).getCityPopulation();
        }
        return countryPopulation-sumPopulation;
    }


    public void setCities(City city) {
        cities.add(city);
    }

    public ArrayList<City> getCities() {
        return cities;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getPresident() {
        return president;
    }

    public int getIndependency() {
        return independency;
    }

    @Override
    public String toString() {
        return "Country{" +
                // "countryCode='" + countryCode + '\'' +
                ", countryName='" + countryName + '\'' +
                //", continent='" + continent + '\'' +
                //", region='" + region + '\'' +
                //", area=" + area +
                ", independency=" + independency +
                // ", countryPopulation=" + countryPopulation +
                ", president='" + president + '\'' +
                // ", cities=" + cities +
                '}';
    }
}

