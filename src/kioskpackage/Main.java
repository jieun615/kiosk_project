package kioskpackage;

public class Main {
    public static void main(String[] args) {
        Kiosk kiosk = new Kiosk();

        Menu burgerMenu = new Menu("Hamburger");
        burgerMenu.addMenuItem(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgerMenu.addMenuItem(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgerMenu.addMenuItem(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgerMenu.addMenuItem(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        Menu drinkMenu = new Menu("Drink");
        drinkMenu.addMenuItem(new MenuItem("콜라", 2.0, "콜라"));
        drinkMenu.addMenuItem(new MenuItem("사이다", 2.0, "사이다"));
        drinkMenu.addMenuItem(new MenuItem("쉐이크", 4.5, "바닐라 쉐이크"));

        kiosk.addMenu(burgerMenu);
        kiosk.addMenu(drinkMenu);

        kiosk.start();
    }
}