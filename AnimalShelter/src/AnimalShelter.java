
import java.util.*;

public class AnimalShelter {
    public int budget = 50;
    public Set<Animal> sicks = new HashSet<>();
    public ArrayList<Animal> animalsLIst = new ArrayList<>();
    public ArrayList<String> ownerList = new ArrayList<>();

    public int rescue(Animal anim) {
        animalsLIst.add(anim);
        return animalsLIst.size();
    }

    public int getBudget() {
        return budget;
    }

    public void addAdopter(String newOwner) {
        ownerList.add(newOwner);
    }

    public void findNewOwner() {
        Collections.shuffle(animalsLIst);
        Collections.shuffle(ownerList);
        if (budget < 5) {
            System.out.println("a menhely penze kezd elfogyni..");
        }

        for (Animal actualAnim : animalsLIst) {
            if (!actualAnim.isHealthy) { //ha beteg az allat
                sicks.add(actualAnim);
                System.out.println(actualAnim + " beteg");
                if (Math.random() < 0.5 && budget >= actualAnim.healCost) {        // 50% hogy meggyogyul es a budget kerdese
                    actualAnim.heal();
                    budget -= actualAnim.getHealCost();
                }

            }

            if (actualAnim.isAdoptable()) {               //kiveszi az elso adoptalhatot(nem beteg)
                sicks.remove(actualAnim);
                actualAnim.setOwnerName(ownerList.get(0));
                System.out.println(actualAnim + " gazdara talalt. A gazdaja: " + ownerList.get(0));
                animalsLIst.remove(actualAnim);
                ownerList.remove(0);//kiveszi az elso tulajt
                break;
            }
        }
    }

    public int earnDonation(int donation) {
        budget += donation;
        return budget;
    }
}
