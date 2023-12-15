package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisableMenus {
    public List<String> disableMenus = new ArrayList<>();

    public DisableMenus(String input) {
        validate(input);
        createDisableMenus(input);
    }

    private void createDisableMenus(String input) {
        String[] names = input.split(",");
        disableMenus.addAll(Arrays.asList(names));
    }

    private void validate(String input) {

    }

    // TODO : 0개에서 2개가 아닌 검증
    // TODO : 메뉴에 있는지 검증

    public String toString() {
        return "";
    }
}
