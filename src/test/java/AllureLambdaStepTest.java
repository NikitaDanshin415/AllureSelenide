import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pageobject.HomePage;
import pageobject.RepoPage;
import pageobject.SearchResultPage;

import java.io.ByteArrayInputStream;

import static io.qameta.allure.Allure.step;

public class AllureLambdaStepTest extends BaseTest{

    @Feature("Проверка построение отчета в Allure")
    @Story("Allure через лямбда степы")
    @DisplayName("Проверка степов в Allure")
    @Test()
    void GithubTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        String repoName = "NikitaDanshin415/QaGuru";

        step("Найти репозиторий {0}", () -> {
            new HomePage()
                    .search(repoName);

            Allure.addAttachment("PageSource", "text/html", WebDriverRunner.source(), "html");
            Allure.addAttachment("Screenshot 1", "image/png", new ByteArrayInputStream(((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES)), "png");
            takeScreenshot();
        });

        step("Открыть репозиторий", () -> {
            new SearchResultPage()
                    .openRepo(repoName);
        });

        step("Проверка вкладки Issues", () -> {
            String issueName = "QaGuruAllure";
            new RepoPage()
                    .openTab("Issues")
                    .pageContainsIssues(issueName);
        });

    }

    @Attachment(value = "Screenshot 2", type = "image/png", fileExtension = "png")
    byte[] takeScreenshot(){
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
