package kioskpackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menus;
    private List<MenuItem> cart;
    private Scanner scanner;

    public Kiosk() {
        menus = new ArrayList<>();
        cart = new ArrayList<>();
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

            if (!cart.isEmpty()) { // 장바구니가 비어있지 않으면 ORDER MENU 출력
                System.out.println("\n[ ORDER MENU ]");
                System.out.println("4. Orders       | 장바구니를 확인 후 주문합니다.");
                System.out.println("5. Cancel       | 진행중인 주문을 취소합니다.");
            }

            System.out.println("0. 종료      | 종료");
            System.out.print("카테고리를 선택하세요: ");

            int categoryChoice = scanner.nextInt();

            if (categoryChoice == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (categoryChoice >= 1 && categoryChoice <= menus.size()) {
                selectMenu(menus.get(categoryChoice - 1));
            } else if (categoryChoice == 4) {
                if (cart.isEmpty()) {
                    System.out.println("장바구니가 비어 있습니다. 주문할 수 없습니다.");
                } else {
                    processOrder();
                }
            } else if (categoryChoice == 5) {
                if (cart.isEmpty()) {
                    System.out.println("진행중인 주문이 없습니다.");
                } else {
                    cart.clear();
                    System.out.println("진행중인 주문이 취소되었습니다.");
                }
            } else {
                System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
            }
        }
    }

    private void selectMenu(Menu menu) {
        menu.menuCategory();
        System.out.print("메뉴를 선택하세요: ");
        int itemChoice = scanner.nextInt();

        if (itemChoice == 0) return; // 뒤로 가기

        if (itemChoice < 1 || itemChoice > menu.getMenuItems().size()) {
            System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
            return;
        }

        MenuItem selectedItem = menu.getMenuItems().get(itemChoice - 1);
        System.out.println("\n선택한 메뉴: " + selectedItem);
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인        2. 취소");
        int confirm = scanner.nextInt();

        if (confirm == 1) {
            cart.add(selectedItem);
            System.out.println(selectedItem.getName() + " 이(가) 장바구니에 추가되었습니다.");
        }
    }

    private void processOrder() {
        System.out.println("\n아래와 같이 주문 하시겠습니까?");
        System.out.println("[ Orders ]");
        double total = 0;
        for (MenuItem item : cart) {
            System.out.println(item);
            total += item.getPrice();
        }
        System.out.println("\n[ Total ]");
        System.out.println("W " + total);

        System.out.println("1. 주문      2. 메뉴판");
        int orderChoice = scanner.nextInt();

        if (orderChoice == 1) {
            System.out.println("주문이 완료되었습니다. 금액은 W " + total + " 입니다.");
            cart.clear(); // 주문 완료 후 장바구니 초기화
        }
    }
}