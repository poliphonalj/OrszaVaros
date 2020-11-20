public class AnimalShelterApp {
    public static void main(String[] args) {

        AnimalShelter as = new AnimalShelter();

// kezdo ertekekkel valo feltoltes:

        for(int i=1;i<5;i++){
            as.addAdopter("gazda "+i);
        }
        as.rescue(new Parrot("parrot1"));
        as.rescue(new Parrot("parrot2"));
        as.rescue(new Dog("dog1"));
        as.rescue(new Dog("dog2"));
        as.rescue(new Cat("cat1"));
        as.rescue(new Cat("cat2"));
        as.rescue(new Fish("fish2"));
        as.rescue(new Fish("fish2"));

        as.findNewOwner();
        as.findNewOwner();
        as.findNewOwner();

        if(Math.random()<0.5){
            as.earnDonation((int)(Math.random()*10));
        }

        System.out.println(" a meg beteg allatok listaja: "+as.sicks);
        System.out.println("a menhely penze jelenleg: "+as.getBudget());






    }
}
