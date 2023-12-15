package menu.controller;

import menu.domain.CoachNames;
import menu.view.InputView;
import menu.view.OutputView;

public class CoachNameController {
    private final InputView inputView;
    private final OutputView outputView;

    public CoachNameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
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
