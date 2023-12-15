package menu.controller;

import menu.domain.CoachNames;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuRecomendationController {
    private final OutputView outputView;
    private final CoachNameController coachNameController;
    private final DisableMenusController disableMenusController;
    private final RecommendationController recommendationController;


    public MenuRecomendationController(InputView inputView, OutputView outputView) {
        this.outputView = outputView;
        this.coachNameController = new CoachNameController(inputView, outputView);
        this.disableMenusController = new DisableMenusController(inputView, outputView);
        this.recommendationController = new RecommendationController(disableMenusController, outputView);
    }


    public void run() {
        outputView.printStart();
        CoachNames coachNames = coachNameController.promptCoachNames();
        disableMenusController.promptDisableMenusForCoaches(coachNames.coachNames());
        recommendationController.recommendDiet(coachNames);
        recommendationController.printResult(coachNames);
    }


}
