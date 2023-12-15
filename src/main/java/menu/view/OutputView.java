package menu.view;

import java.util.HashMap;
import java.util.List;
import menu.domain.Category;

public class OutputView {
    private static final String START = "점심 메뉴 추천을 시작합니다.";
    private static final String RESULT = "메뉴 추천 결과입니다.\n"
            + "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String CATEGORY = "[ 카테고리";
    private static final String END = "추천을 완료했습니다.";

    public void printStart() {
        System.out.println(START);
    }

    public void printResult() {
        System.out.println(RESULT);
    }

    public void printCategory(List<Category> categories) {
        StringBuilder result = new StringBuilder(CATEGORY);
        for (Category category : categories) {
            result.append(" | ").append(category.getCategoryName());
        }
        System.out.println(result.append(" ]"));
    }

    public void printMenus(List<String> names, HashMap<String, List<String>> menusMap) {
        StringBuilder result = new StringBuilder();
        for (String name : names) {
            result.append("[ ").append(name);
            List<String> menus = menusMap.get(name);
            for (String menu : menus) {
                result.append(" | ").append(menu);
            }
            result.append(" ]\n");
        }
        System.out.println(result);
        System.out.println(END);
    }

    public void printError(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}

