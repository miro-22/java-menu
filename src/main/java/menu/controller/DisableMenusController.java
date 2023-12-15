package menu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.domain.DisableMenus;
import menu.view.InputView;
import menu.view.OutputView;

public class DisableMenusController {
    private final InputView inputView;
    private final OutputView outputView;
    private Map<String, DisableMenus> disableMenusMap = new HashMap<>();

    public DisableMenusController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
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

    public Boolean containDisableMenusByName(String name, String menu) {
        return disableMenusMap.get(name).contains(menu);
    }
}
