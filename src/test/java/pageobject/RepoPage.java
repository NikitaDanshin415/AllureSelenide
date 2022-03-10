package pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;

public class RepoPage {

    private final ElementsCollection tabPanel = $$("#repository-container-header nav ul.UnderlineNav-body li");
    private final ElementsCollection IssuesList = $$("div[aria-label=Issues] .Box-row");

    public RepoPage openTab(String tabName){
        tabPanel
                .findBy(Condition.text(tabName))
                .click();

        return this;
    }

    public RepoPage pageContainsIssues(String issuesName){
        IssuesList
                .findBy(Condition.text(issuesName))
                .shouldBe(Condition.visible);

        return this;
    }
}
