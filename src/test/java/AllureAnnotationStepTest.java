import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageobject.HomePage;
import pageobject.RepoPage;
import pageobject.SearchResultPage;

public class AllureAnnotationStepTest extends BaseTest {
    private final String repoName = "NikitaDanshin415/QaGuru";

    @Feature("Проверка построение отчета в Allure")
    @Story("Allure через функциональные степы")
    @DisplayName("Проверка степов в Allure")
    @Test
    void GithubTest() {
        findRepo();
        openRepo();
        openIssuesTab();
    }

    @Step("Найти репозиторий")
    void findRepo() {
        new HomePage()
                .search(repoName);
    }

    @Step("Открыть репозиторий")
    void openRepo() {
        new SearchResultPage()
                .openRepo(repoName);
    }

    @Step("Проверка вкладки Issues")
    void openIssuesTab() {
        String issueName = "QaGuruAllure";

        new RepoPage()
                .openTab("Issues")
                .pageContainsIssues(issueName);
    }
}
