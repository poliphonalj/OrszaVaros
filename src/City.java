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
}
