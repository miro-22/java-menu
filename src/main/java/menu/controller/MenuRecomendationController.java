package menu.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import menu.domain.Category;
import menu.domain.CoachNames;
import menu.domain.DisableMenus;
import menu.domain.Menu;
import menu.domain.Weekday;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuRecomendationController {
    InputView inputView;
    OutputView outputView;

    Map<String, DisableMenus> disableMenusMap;
    List<Category> categories = new ArrayList<>();
    HashMap<String, List<String>> recommendedMenus = new HashMap<>();

    public MenuRecomendationController(InputView inputView, OutputView outputView) {
        disableMenusMap = new HashMap<>();
        this.inputView = inputView;
        this.outputView = outputView;
    }


    public void run() {
        // 이름 입력받기 => List<String> 이름
        CoachNames coachNames = promptCoachNames();
        // 반복 : 입력받은 이름마다 프롬프트 생성
        // 이름을 인자로 받아 못먹는 메뉴를 받는 프롬프트
        // 이름 : List<메뉴> 으로 hash map 추가
        promptDisableMenusForCoaches(coachNames.coachNames());

        for (int i = 0; i < Weekday.values().length - 1; i++) {
            // 카테고리 추첨
            // 한 주에 같은 카테고리를 3회 이상 먹지 못 한다.
            // 추천할 수 없는 카테고리의 경우 재추첨한다.
            recommendCategory();

            // 메뉴 추첨
            // 각 코치에게 한 주에 중복되지 않는 메뉴를 추천해야 한다.
            // 각 코치가 고른 못 먹는 메뉴를 고려해야 한다.
            // 추천할 수 없는 메뉴의 경우 재추첨한다.
            for (String name : coachNames.coachNames()) {
                recommendMenu(name, categories.get(i));
            }

        }

        // 출력
        for (String name : coachNames.coachNames()) {
            System.out.println(recommendedMenus.get(name));
        }
    }

    private void recommendMenu(String name, Category category) {
        while (true) {
            String menu = Randoms.shuffle(Menu.getMenusByCategory(category)).get(0);
            if (recommendedMenus.get(name) == null) {
                recommendedMenus.put(name, new ArrayList<>());
            }
            
            if ((recommendedMenus.get(name) == null || !recommendedMenus.get(name).contains(menu))
                    && !disableMenusMap.get(name).disableMenus.contains(menu)) {
                recommendedMenus.get(name).add(menu);
                break;
            }
        }
    }

    public void recommendCategory() {
        while (true) {
            Category newCategory = Category.getCategoryByIndex(Randoms.pickNumberInRange(0, 4));
            if (countRecommendedCategories(newCategory) < 2) {
                categories.add(newCategory);
                break;
            }
        }
    }

    public int countRecommendedCategories(Category newCategory) {
        int count = 0;
        for (Category category : categories) {
            if (Objects.equals(newCategory.getCategoryName(), category.getCategoryName())) {
                count += 1;
            }
        }
        return count;
    }

    public void promptDisableMenusForCoaches(List<String> coachNames) {
        for (String name : coachNames) {
            DisableMenus disableMenus = promptDisableMenusForCoach(name);
            disableMenusMap.put(name, disableMenus);
        }
    }

    private DisableMenus promptDisableMenusForCoach(String name) {
        while (true) {
            try {
                String input = inputView.readDisableMenus(name);
                return new DisableMenus(input);
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
            }
        }
    }

    public CoachNames promptCoachNames() {
        while (true) {
            try {
                String input = inputView.readCoach();
                return new CoachNames(input);
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
            }
        }
    }
}
