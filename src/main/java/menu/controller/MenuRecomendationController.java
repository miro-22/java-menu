package menu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.domain.CoachNames;
import menu.domain.DisableMenus;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuRecomendationController {
    InputView inputView;
    OutputView outputView;

    Map<String, DisableMenus> disableMenusMap;

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

        // 카테고리 추첨
        // 한 주에 같은 카테고리를 3회 이상 먹지 못 한다.
        // 추천할 수 없는 카테고리의 경우 재추첨한다.

        // 메뉴 추첨
        // 각 코치에게 한 주에 중복되지 않는 메뉴를 추천해야 한다.
        // 각 코치가 고른 못 먹는 메뉴를 고려해야 한다.
        // 추천할 수 없는 메뉴의 경우 재추첨한다.

        // 출력
    }

    public void promptDisableMenusForCoaches(List<String> coachNames) {
        for (String name : coachNames) {
            DisableMenus disableMenus = promptDisableMenusForCoach(name);
            disableMenusMap.put(name, disableMenus);
        }

        System.out.println(disableMenusMap.get(coachNames.get(0)).disableMenus);
        System.out.println(disableMenusMap.get(coachNames.get(1)).disableMenus);
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
