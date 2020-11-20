public abstract class Madar extends Allat {

    public int fesztavolsag;

    public Madar(String fajta, String elohely, int kor, int fesztavolsag) {
        super(fajta, elohely, kor);
        this.fesztavolsag = fesztavolsag;
    }

    @Override
    abstract void hangotAd();

    public void setFesztavolsag(int fesztavolsag) {
        this.fesztavolsag = fesztavolsag;
    }

    public int getFesztavolsag() {
        return fesztavolsag;
    }
}
