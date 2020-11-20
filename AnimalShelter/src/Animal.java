import java.util.ArrayList;

public abstract class Animal {

    String name;
    String ownerName;
    boolean isHealthy;
    int healCost;


    public Animal(String name){
        this.name=name;
        ownerName="";
        if(Math.random()<0.5){
            isHealthy=true;
        }
        healCost=3;
    }


    public abstract void heal();

    public void setIsHealthy(){
        if(!isHealthy){
            isHealthy=true;
        }
    }

    public void setOwnerName(String ownerName){
        this.ownerName=ownerName;
    }

    public boolean  isAdoptable(){
        if(isHealthy){
            return true;
        }
        return false;
    }

    public int getHealCost(){
        return healCost;
    }

    @Override
    public String toString() {
        return name;
    }
}
