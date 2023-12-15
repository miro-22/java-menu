package menu.controller;

import menu.domain.CoachNames;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuRecomendationController {
    private final InputView inputView;
    private final OutputView outputView;

    private final DisableMenusController disableMenusController;
    private final RecommendationController recommendationController;


    public MenuRecomendationController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.disableMenusController = new DisableMenusController(inputView, outputView);
        this.recommendationController = new RecommendationController(disableMenusController, outputView);
    }


    public void run() {
        outputView.printStart();
        CoachNames coachNames = promptCoachNames();
        disableMenusController.promptDisableMenusForCoaches(coachNames.coachNames());
        recommendationController.recommendDiet(coachNames);
        recommendationController.printResult(coachNames);
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
