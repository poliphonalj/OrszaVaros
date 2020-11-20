public class Cat extends Animal{


    public Cat(String name){
        super(name);
    }


    @Override
    public void heal() {
        setIsHealthy();
        System.out.println(this+" meggyogyult");
    }
}
