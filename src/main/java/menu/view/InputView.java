package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String COACH_PROMPT = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String MENU_PROMPT = "(이)가 못 먹는 메뉴를 입력해 주세요.";

    public String readCoach() {
        System.out.println(COACH_PROMPT);
        return Console.readLine();
    }

    public String readDisableMenus(String name) {
        System.out.println(name + MENU_PROMPT);
        return Console.readLine();
    }
}