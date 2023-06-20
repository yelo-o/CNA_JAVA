import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Menu_Insert3 {
    private static final String FILE_NAME = "menu.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {

            List<String> menuList = new ArrayList<>();

            while (true) {
                System.out.println("1. 메뉴 등록");
                System.out.println("2. 전체 메뉴 조회");
                System.out.println("3. SHOP별 메뉴 조회");
                System.out.println("4. 메뉴 조회");
                System.out.println("5. 메뉴 수정");
                System.out.println("6. 메뉴 삭제");
                System.out.println("7. 종료");
                System.out.println("번호를 선택하세요: ");
                String choice = reader.readLine();

                if (choice.equals("1")) {
                    System.out.println("메뉴 등록을 시작합니다.");

                    System.out.println("SHOP_NO를 입력하세요: ");
                    String shopNo = reader.readLine();

                    System.out.println("MENU_NO를 입력하세요: ");
                    String menuNo = reader.readLine();

                    System.out.println("MENU_NAME을 입력하세요: ");
                    String menuName = reader.readLine();

                    System.out.println("MENU_CONTENT를 입력하세요: ");
                    String menuContent = reader.readLine();

                    boolean validMenuState = false;
                    boolean menuState = false;

                    while (!validMenuState) {
                        System.out.println("MENU_STATE를 입력하세요 (0 또는 1): ");
                        String menuStateInput = reader.readLine();

                        if (menuStateInput.equals("0")) {
                            menuState = false;
                            validMenuState = true;
                        } else if (menuStateInput.equals("1")) {
                            menuState = true;
                            validMenuState = true;
                        } else {
                            System.out.println("유효한 MENU_STATE를 입력하세요. 0 또는 1을 입력하세요.");
                        }
                    }

                    String menuEntry = shopNo + "," + menuNo + "," + menuName + "," + menuContent + "," + menuState;
                    writer.write(menuEntry);
                    writer.newLine();
                    writer.flush();

                    System.out.println("메뉴가 성공적으로 등록되었습니다.");
                } else if (choice.equals("2")) {
                    // 전체 메뉴 조회 기능
                    System.out.println("전체 메뉴 조회를 시작합니다.");

                    menuList.clear(); // Clear the list before reading from file

                    try (BufferedReader fileReader = new BufferedReader(new FileReader(FILE_NAME))) {
                        String line;
                        while ((line = fileReader.readLine()) != null) {
                            menuList.add(line);
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("메뉴 파일이 없습니다.");
                    } catch (IOException e) {
                        System.out.println("파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
                    }

                    if (menuList.isEmpty()) {
                        System.out.println("메뉴가 없습니다.");
                    } else {
                        for (String menuEntry : menuList) {
                            String[] menuDetails = menuEntry.split(",");
                            String shopNo = menuDetails[0];
                            String menuNo = menuDetails[1];
                            String menuName = menuDetails[2];
                            String menuContent = menuDetails[3];
                            String menuState = menuDetails[4];

                            System.out.println("메뉴 정보:");
                            System.out.println("SHOP_NO: " + shopNo);
                            System.out.println("MENU_NO: " + menuNo);
                            System.out.println("MENU_NAME: " + menuName);
                            System.out.println("MENU_CONTENT: " + menuContent);
                            System.out.println("MENU_STATE: " + menuState);
                        }
                    }
                    
                } else if (choice.equals("3")) {
                    // SHOP별 메뉴 조회 기능
                    System.out.println("SHOP별 메뉴 조회를 시작합니다.");

                    System.out.println("SHOP_NO를 입력하세요: ");
                    String searchShopNo = reader.readLine();

                    menuList.clear(); // Clear the list before reading from file

                    try (BufferedReader fileReader = new BufferedReader(new FileReader(FILE_NAME))) {
                        String line;
                        while ((line = fileReader.readLine()) != null) {
                            menuList.add(line);
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("메뉴 파일이 없습니다.");
                    } catch (IOException e) {
                        System.out.println("파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
                    }

                    boolean foundShopMenu = false;

                    for (String menuEntry : menuList) {
                        String[] menuDetails = menuEntry.split(",");
                        String shopNo = menuDetails[0];

                        if (shopNo.equals(searchShopNo)) {
                            System.out.println("메뉴 정보:");
                            System.out.println("SHOP_NO: " + shopNo);
                            System.out.println("MENU_NO: " + menuDetails[1]);
                            System.out.println("MENU_NAME: " + menuDetails[2]);
                            System.out.println("MENU_CONTENT: " + menuDetails[3]);
                            System.out.println("MENU_STATE: " + menuDetails[4]);

                            foundShopMenu = true;
                        }
                    }

                    if (!foundShopMenu) {
                        System.out.println("일치하는 SHOP_NO를 가진 메뉴가 없습니다.");
                    }

                } else if (choice.equals("4")) {
                    // 메뉴 조회 기능
                    System.out.println("메뉴 조회를 시작합니다.");

                    System.out.println("메뉴 이름을 입력해주세요: ");
                    String searchMenuName = reader.readLine();

                    List<String> matchedMenus = new ArrayList<>();

                    for (String menuEntry : menuList) {
                        String[] menuDetails = menuEntry.split(",");
                        String menuName = menuDetails[2];

                        if (menuName.equals(searchMenuName)) {
                            matchedMenus.add(menuEntry);
                        }
                    }

                    if (matchedMenus.isEmpty()) {
                        System.out.println("일치하는 메뉴가 없습니다.");
                    } else {
                        for (String menuEntry : matchedMenus) {
                            String[] menuDetails = menuEntry.split(",");
                            String shopNo = menuDetails[0];
                            String menuNo = menuDetails[1];
                            String menuName = menuDetails[2];
                            String menuContent = menuDetails[3];
                            String menuState = menuDetails[4];

                            System.out.println("메뉴 정보:");
                            System.out.println("SHOP_NO: " + shopNo);
                            System.out.println("MENU_NO: " + menuNo);
                            System.out.println("MENU_NAME: " + menuName);
                            System.out.println("MENU_CONTENT: " + menuContent);
                            System.out.println("MENU_STATE: " + menuState);
                        }
                    }
               
                } else if (choice.equals("5")) {
                    // 메뉴 수정 기능
                    System.out.println("메뉴 수정을 시작합니다.");

                    System.out.println("SHOP_NO를 입력하세요: ");
                    String searchShopNo = reader.readLine();

                    System.out.println("MENU_NO를 입력하세요: ");
                    String searchMenuNo = reader.readLine();

                    boolean foundMenu = false;

                    for (int i = 0; i < menuList.size(); i++) {
                        String menuEntry = menuList.get(i);
                        String[] menuDetails = menuEntry.split(",");
                        String shopNo = menuDetails[0];
                        String menuNo = menuDetails[1];

                        if (shopNo.equals(searchShopNo) && menuNo.equals(searchMenuNo)) {
                            System.out.println("메뉴 정보:");
                            System.out.println("SHOP_NO: " + shopNo);
                            System.out.println("MENU_NO: " + menuNo);
                            System.out.println("MENU_NAME: " + menuDetails[2]);
                            System.out.println("MENU_CONTENT: " + menuDetails[3]);
                            System.out.println("MENU_STATE: " + menuDetails[4]);

                            System.out.println("수정할 내용을 입력하세요.");
                            System.out.println("수정할 MENU_NAME을 입력하세요: ");
                            String updatedMenuName = reader.readLine();

                            menuDetails[2] = updatedMenuName;
                            menuList.set(i, String.join(",", menuDetails));

                            System.out.println("메뉴 이름이 변경되었습니다. 변경된 메뉴 이름: " + updatedMenuName);

                            foundMenu = true;
                            break;
                        }
                    }

                    if (!foundMenu) {
                        System.out.println("일치하는 메뉴가 없습니다.");
                    } else {
                        // 수정된 메뉴 목록을 파일에 다시 쓰기
                        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(FILE_NAME))) {
                            for (String menuEntry : menuList) {
                                fileWriter.write(menuEntry);
                                fileWriter.newLine();
                            }
                        } catch (IOException e) {
                            System.out.println("파일에 쓰는 중 오류가 발생했습니다: " + e.getMessage());
                        }
                    }
                } else if (choice.equals("6")) {
                    // 메뉴 삭제 기능
                    System.out.println("메뉴 삭제를 시작합니다.");

                    System.out.println("SHOP_NO를 입력하세요: ");
                    String searchShopNo = reader.readLine();

                    System.out.println("MENU_NO를 입력하세요: ");
                    String searchMenuNo = reader.readLine();

                    boolean foundMenu = false;
                    Iterator<String> menuIterator = menuList.iterator();

                    while (menuIterator.hasNext()) {
                        String menuEntry = menuIterator.next();
                        String[] menuDetails = menuEntry.split(",");
                        String shopNo = menuDetails[0];
                        String menuNo = menuDetails[1];

                        if (shopNo.equals(searchShopNo) && menuNo.equals(searchMenuNo)) {
                            System.out.println("메뉴 정보:");
                            System.out.println("SHOP_NO: " + shopNo);
                            System.out.println("MENU_NO: " + menuNo);
                            System.out.println("MENU_NAME: " + menuDetails[2]);
                            System.out.println("MENU_CONTENT: " + menuDetails[3]);
                            System.out.println("MENU_STATE: " + menuDetails[4]);

                            System.out.println("위의 메뉴를 삭제하시겠습니까? (Y/N)");
                            String confirm = reader.readLine();

                            if (confirm.equalsIgnoreCase("Y")) {
                                menuIterator.remove();
                                System.out.println("메뉴가 성공적으로 삭제되었습니다.");
                            } else {
                                System.out.println("메뉴 삭제가 취소되었습니다.");
                            }

                            foundMenu = true;
                            break;
                        }
                    }

                    if (!foundMenu) {
                        System.out.println("일치하는 메뉴가 없습니다.");
                    }

                    // 파일에 변경된 메뉴 목록을 다시 쓰기
                    try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(FILE_NAME))) {
                        for (String menuEntry : menuList) {
                            fileWriter.write(menuEntry);
                            fileWriter.newLine();
                        }
                    } catch (IOException e) {
                        System.out.println("파일에 쓰는 중 오류가 발생했습니다: " + e.getMessage());
                    }
                    
                } else if (choice.equals("7")) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } else {
                    System.out.println("유효한 번호를 선택하세요.");
                }
            }

        } catch (IOException e) {
            System.out.println("파일에 쓰는 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
}