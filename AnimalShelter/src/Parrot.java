public class Parrot extends Animal{

    public Parrot(String name) {
        super(name);
    }

    @Override
    public void heal() {
        setIsHealthy();
        System.out.println(this+" meggyogyult");
    }
}
