public class City {

    private String cityName;
    private String countryCode;
    private long cityPopulation;

    public City(String cityName, String countryCode, long cityPopulation) {
        this.cityName = cityName;
        this.countryCode = countryCode;
        this.cityPopulation = cityPopulation;
    }

    public long getCityPopulation() {
        return cityPopulation;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCityName() {
        return cityName;
    }


/*
public double getPopulationPercentage()
irj egy metódust, ami visszaadja, hogy az adott város populációja hány százaléka az anyaország populációjának!
Ha akár a város, akár az anyaország populációja nincs megadva, a metódusod -1-gyel térjen vissza!
*/

    public double getPopulationPercentage(){
        double d=0;
        for (Country actualCountry : WorldStatistics.countryContainer) {
            if(actualCountry.getCountryCode().equals(this.getCountryCode())){
                d=((double)cityPopulation/ actualCountry.getCountryPopulation())*100;
            }
            if( actualCountry.getRuralPopulation()==0 && this.cityPopulation==0){
                return -1;
            }
        }
        return  d;
    }
}
