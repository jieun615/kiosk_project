package kioskpackage;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String categoryName;
    private List<MenuItem> menuItems;

    public Menu(String categoryName) {
        this.categoryName = categoryName;
        this.menuItems = new ArrayList<>();
        detaileMenu();
    }

    private void detaileMenu() {
        if (categoryName.equals("Hamburger")) {
            menuItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
            menuItems.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
            menuItems.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
            menuItems.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
        } else if (categoryName.equals("Drink")) {
            menuItems.add(new MenuItem("콜라", 2.0, "콜라"));
            menuItems.add(new MenuItem("사이다", 2.0, "사이다"));
            menuItems.add(new MenuItem("쉐이크", 4.5, "바닐라/딸기/초코 쉐이크"));
            menuItems.add(new MenuItem("오렌지 주스", 5.0, "직접 짠 오렌지 주스"));
            menuItems.add(new MenuItem("레몬에이드", 6.0, "주인장이 직접 만든 레몬청으로 만든 레몬에이드"));
            menuItems.add(new MenuItem("민트초코라떼", 5.0, "2080맛"));
            menuItems.add(new MenuItem("핫초코", 3.0, "시판제품"));
            menuItems.add(new MenuItem("케챱주스", 2.0, "햄버거집에 맞게 케챱으로 만든 주스"));
            menuItems.add(new MenuItem("단호박 식혜", 5.5, "주인장이 직접 간 단호박으로 만든 식혜"));
        }
    }

    public String getCategoryName() {
        return categoryName;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void menuCategory() {
        System.out.println("\n[" + categoryName + " Menu ]");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println((i + 1) + ". " + menuItems.get(i));
        }
        System.out.println("0. 뒤로 가기");
    }
}
