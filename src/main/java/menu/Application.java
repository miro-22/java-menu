package menu;

import menu.controller.MenuRecomendationController;
import menu.view.InputView;
import menu.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        MenuRecomendationController menuRecomendation = new MenuRecomendationController(inputView, outputView);
        menuRecomendation.run();
    }
}
