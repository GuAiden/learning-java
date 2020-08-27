public class Objects {
    public static void main(String args[]) {
        Bender fireboy = new Bender(); 
        fireboy.setElement("Fire");
        fireboy.setPower(100);
        fireboy.setName("Fireboy");

        fireboy.battlecry();

        // Inhertied aang, 
        Avatar aang = new Avatar(); 
        aang.battlecry();
    }
}