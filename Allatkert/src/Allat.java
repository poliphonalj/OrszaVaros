public abstract class Allat {

    String fajta;
    String elohely;
    int kor;

    public Allat(){
       fajta="eb";
       elohely="europa";
       kor=3;
    }

    public Allat(String fajta, String elohely, int kor) {
        this.fajta = fajta;
        this.elohely = elohely;
        this.kor = kor;
    }

    abstract void hangotAd();
}
