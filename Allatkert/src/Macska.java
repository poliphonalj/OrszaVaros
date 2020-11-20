public class Macska extends Emlos{
    boolean haziasitott;

    public Macska(String fajta, String elohely, int kor, boolean haziasitott) {
        super(fajta, elohely, kor);
        this.haziasitott=haziasitott;
    }

    @Override
    public void hangotAd() {
        System.out.println("meow");
    }

    public boolean isHaziasitott() {
        return haziasitott;
    }
}
