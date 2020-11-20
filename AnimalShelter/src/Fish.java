public class Fish extends Animal{

        public Fish(String name){
            super(name);
        }
        @Override
        public void heal() {
            setIsHealthy();
            System.out.println(this+" meggyogyult");
        }
    }

