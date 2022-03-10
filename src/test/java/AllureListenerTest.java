import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageobject.HomePage;
import pageobject.RepoPage;
import pageobject.SearchResultPage;

public class AllureListenerTest extends BaseTest {

    @Feature("Проверка построение отчета в Allure")
    @Story("Allure через лямбда степы")
    @DisplayName("Проверка степов в Allure")
    @Test()
    void GithubTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        String repoName = "NikitaDanshin415/QaGuru";
        new HomePage()
                .search(repoName);

        new SearchResultPage()
                .openRepo(repoName);

        String issueName = "QaGuruAllure";
        new RepoPage()
                .openTab("Issues")
                .pageContainsIssues(issueName);
    }

}
