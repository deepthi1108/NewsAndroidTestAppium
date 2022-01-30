package pages;

import Actions.actions;

public interface BasePage {

    actions userActions = new actions();
    loginPage LoginPage = new loginPage(userActions);
    newsPage NewsPage = new newsPage(userActions);
}
