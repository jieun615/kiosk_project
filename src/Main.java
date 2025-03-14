import kioskpackage.Kiosk;
import kioskpackage.Menu;

public class Main {
    public static void main(String[] args) {
        Kiosk kiosk = new Kiosk();

        kiosk.addMenu(new Menu("Hamburger"));
        kiosk.addMenu(new Menu("Drink"));

        kiosk.start();
    }
}