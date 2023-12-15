package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisableMenus {
    private static final int AMOUNT_MAX = 2;
    private final static String MENUS_ERROR_MESSAGE = "[ERROR] 유효하지 않은 메뉴입니다. 다시 입력해 주세요.";
    private List<String> disableMenus = new ArrayList<>();

    public DisableMenus(String input) {
        validate(input);
        createDisableMenus(input);
    }

    private void createDisableMenus(String input) {
        String[] names = input.split(",");
        disableMenus.addAll(Arrays.asList(names));
    }

    private void validate(String input) {
        List<String> names = new ArrayList<>(Arrays.asList(input.split(",")));
        isValidAmount(names);
        isValidMenu(names);
    }

    // TODO : 0개에서 2개가 아닌 검증
    private void isValidAmount(List<String> names) {
        if (names.size() > AMOUNT_MAX) {
            throw new IllegalArgumentException(MENUS_ERROR_MESSAGE);
        }
    }

    // TODO : 메뉴에 있는지 검증
    private void isValidMenu(List<String> names) {
        for (String name : names) {
            if (!Menu.contains(name)) {
                throw new IllegalArgumentException(MENUS_ERROR_MESSAGE);
            }
        }
    }

    public boolean contains(String menu) {
        return disableMenus.contains((menu));
    }
}
