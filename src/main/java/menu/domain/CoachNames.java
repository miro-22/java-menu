package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoachNames {
    private static final int NAME_MIN = 2;
    private static final int NAME_MAX = 4;
    private static final int AMOUNT_MIN = 2;
    private static final int AMOUNT_MAX = 5;
    private final static String COACH_NAMES_ERROR_MESSAGE = "[ERROR] 유효하지 않은 코치이름입니다. 다시 입력해 주세요.";
    private List<String> coachNames;


    public CoachNames(String input) {
        validate(input);

        coachNames = new ArrayList<>();
        createNames(input);
    }

    private void createNames(String input) {
        String[] names = input.split(",");
        coachNames.addAll(Arrays.asList(names));
    }

    private void validate(String input) {
        List<String> names = Arrays.asList(input.split(","));
        isValidAmount(names);
        for (String name : names) {
            isValidName(name);
        }
    }

    private void isValidAmount(List<String> names) {
        if (names.size() < AMOUNT_MIN || names.size() > AMOUNT_MAX) {
            throw new IllegalArgumentException(COACH_NAMES_ERROR_MESSAGE);
        }
    }

    private void isValidName(String name) {
        if (name.length() < NAME_MIN || name.length() > NAME_MAX) {
            throw new IllegalArgumentException(COACH_NAMES_ERROR_MESSAGE);
        }
    }

    // TODO : 중복된 코치이름을 포함하는 경우도 테스트

    public List<String> coachNames() {
        return coachNames;
    }

    public String toString() {
        return "";
    }
}
