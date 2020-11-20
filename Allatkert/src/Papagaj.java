public class Papagaj extends Madar{

    public Papagaj(String fajta, String elohely, int kor, int fesztavolsag) {
        super(fajta, elohely, kor, fesztavolsag);
    }

    @Override
    void hangotAd() {
        System.out.println("csipog");
    }

}
