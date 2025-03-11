package kioskpackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menus;
    private Scanner scanner;

    public Kiosk() {
        menus = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    public void start() {

        while (true) {
            System.out.println("\n[ SHAKESHACK Kiosk ]");

            for (int i = 0; i < menus.size(); i++) {
                System.out.println((i + 1) + ". " + menus.get(i).getCategoryName());
            }
            System.out.println("0. 종료      | 종료");
            System.out.print("카테고리를 선택하세요: ");

            int categoryChoice = scanner.nextInt();
            if (categoryChoice == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            if (categoryChoice < 1 || categoryChoice > menus.size()) {
                System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                continue;
            }

            Menu selectedMenu = menus.get(categoryChoice - 1);
            selectedMenu.menuCategory();

            System.out.print("메뉴를 선택하세요: ");
            int itemChoice = scanner.nextInt();

            if (itemChoice == 0) {
                continue; // 뒤로 가기
            }
            if (itemChoice < 1 || itemChoice > selectedMenu.getMenuItems().size()) {
                System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                continue;
            }

            System.out.println("\n선택한 메뉴: " + selectedMenu.getMenuItems().get(itemChoice - 1));
        }
    }
}
