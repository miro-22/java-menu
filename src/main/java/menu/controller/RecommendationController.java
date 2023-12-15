package menu.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import menu.domain.Category;
import menu.domain.CoachNames;
import menu.domain.Menu;
import menu.domain.Weekday;
import menu.view.OutputView;

public class RecommendationController {
    private final DisableMenusController disableMenusController;
    private final OutputView outputView;

    private List<Category> categories = new ArrayList<>();

    private HashMap<String, List<String>> recommendedMenus = new HashMap<>();

    public RecommendationController(DisableMenusController disableMenusController, OutputView outputView) {
        this.disableMenusController = disableMenusController;
        this.outputView = outputView;
    }

    public void recommendDiet(CoachNames coachNames) {
        for (int i = 0; i < Weekday.values().length; i++) {
            recommendCategory();
            for (String name : coachNames.coachNames()) {
                recommendMenu(name, categories.get(i));
            }

        }
    }

    private void recommendMenu(String name, Category category) {
        while (true) {
            String menu = Randoms.shuffle(Menu.getMenusByCategory(category)).get(0);
            recommendedMenus.computeIfAbsent(name, k -> new ArrayList<>());

            if (!recommendedMenus.get(name).contains(menu)
                    && !disableMenusController.containDisableMenusByName(name, menu)) {
                recommendedMenus.get(name).add(menu);
                break;
            }
        }
    }

    private void recommendCategory() {
        while (true) {
            Category newCategory = Category.getCategoryByIndex(Randoms.pickNumberInRange(1, 5));
            if (countRecommendedCategories(newCategory) < 2) {
                categories.add(newCategory);
                break;
            }
        }
    }

    private int countRecommendedCategories(Category newCategory) {
        int count = 0;
        for (Category category : categories) {
            if (Objects.equals(newCategory.getCategoryName(), category.getCategoryName())) {
                count += 1;
            }
        }
        return count;
    }

    public void printResult(CoachNames coachNames) {
        outputView.printResult();
        outputView.printCategory(categories);
        outputView.printMenus(coachNames.coachNames(), recommendedMenus);
    }
}
