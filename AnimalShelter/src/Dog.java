public class Dog extends Animal{

    public Dog(String name) {
        super(name);
    }

    @Override
    public void heal() {
        setIsHealthy();

        System.out.println(this+" meggyogyult");
    }
}
