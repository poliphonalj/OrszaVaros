public class Kutya extends Emlos{
    public String fajta;

    public Kutya(String fajta, String elohely, int kor) {
        super(fajta,elohely,kor);
    }


    @Override
    public void hangotAd() {
        System.out.println("ugat");
    }

    public void jatszik(){
        System.out.println("play");
    }
}
