package beginner_learning;
// Testing Class Creation 

public class Bender {
    private String name;
    private int power; 
    private String element; 

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }
    public void setPower(int power) {
        this.power = power;
    }

    public String getElement() {
        return element;
    }
    public void setElement(String element) {
        this.element = element;
    }

    public void battlecry() {
        System.out.println("I am " + this.getName() + " and a " 
                           + this.getElement() + " bender with power " + this.getPower()); 
    }

}