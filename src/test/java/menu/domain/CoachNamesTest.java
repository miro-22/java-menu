package menu.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CoachNamesTest {
    private final static String COACH_NAMES_ERROR_MESSAGE = "[ERROR] 유효하지 않은 코치이름입니다. 다시 입력해 주세요.";

    @DisplayName("코치가 2명에서 5명이 아닌 경우 예외처리")
    @ParameterizedTest
    @CsvSource({"지현", "'   ','  ", "지현,지수,지호,지연,지후,지숙"})
    void createOrderCorrectly(String input) {
        assertThatThrownBy(() -> new CoachNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(COACH_NAMES_ERROR_MESSAGE);
    }
}
