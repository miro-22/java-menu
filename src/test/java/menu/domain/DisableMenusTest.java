package menu.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DisableMenusTest {
    private final static String MENUS_ERROR_MESSAGE = "[ERROR] 유효하지 않은 메뉴입니다. 다시 입력해 주세요.";

    @DisplayName("올바르게 입력할 경우 주문 불가능 메뉴가 잘 생성된다.")
    @Test
    void createDisableMenu() {
        DisableMenus disableMenus = new DisableMenus("우동,라자냐");
        assertThat(disableMenus.contains("우동"));
        assertThat(disableMenus.contains("라자냐"));
    }

    @DisplayName("메뉴가 3개 이상일 경우 예외처리")
    @Test
    void testNotInRangeAmountDisableMenu() {
        assertThatThrownBy(() -> new DisableMenus("우동,라자냐,짜장면"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MENUS_ERROR_MESSAGE);
    }

    @DisplayName("메뉴에 없는 메뉴가 입력될 경우 예외처리")
    @Test
    void testNotInMenus() {
        assertThatThrownBy(() -> new DisableMenus("라면"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MENUS_ERROR_MESSAGE);
    }
}
