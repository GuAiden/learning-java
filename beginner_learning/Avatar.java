package beginner_learning;
import java.io.*;
public class Avatar extends Bender {

    // Initialise the avatar
    Avatar() {
        this.setName("Avatar Aang"); 
        this.setPower(1000);
        this.setElement("Multi-elemental");
    }

    // Working with inheritance 
    public void battlecry() {
        super.battlecry();
        System.out.println("I'm the avatar, fight me!"); 
    }

    // Testing out try and catch statements. 
    public void changePower() {
        try {
            System.out.println("You wounded the avatar, whats my power level now: ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int newPower = Integer.parseInt(br.readLine());
            if (newPower < this.getPower()) {
                this.setPower(newPower); 
                System.out.println("Rip, my new power is only: " + this.getPower()); 
            } else {
                this.setPower(newPower);
                System.out.println("What! My power has increased");
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
}