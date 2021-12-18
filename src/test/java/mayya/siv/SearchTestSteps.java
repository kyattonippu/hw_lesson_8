package mayya.siv;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class SearchTestSteps {

    @Step("Open main page MyShows")
    public SearchTestSteps openMyShows() {
        open("https://myshows.me/");

        return this;
    }

    @Step("Set value in the search field  {seriesname}, press Enter")
    public SearchTestSteps searchTvSeries(String seriesname) {
        $(".Search-input.light").setValue(seriesname).pressEnter();

        return this;
    }

    @Step("The search output containing {seriesname} is displayed")
    public SearchTestSteps checkTvSeries(String seriesname) {
        $(".DefaultLayout-content").shouldHave(Condition.text(seriesname));

        return this;
    }
}
