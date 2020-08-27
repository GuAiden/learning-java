public class Objects {
    public static void main(String args[]) {
        Bender fireboy = new Bender(); 
        fireboy.setElement("Fire");
        fireboy.setPower(100);
        fireboy.setName("Fireboy");

        fireboy.battlecry();
        HelloWorld.print_line();

        // Testing inheritance with the avatar. 
        Avatar aang = new Avatar(); 
        aang.battlecry();
        HelloWorld.print_line();

        // Testing try catch, 
        // aang.changePower();
        
    }


}