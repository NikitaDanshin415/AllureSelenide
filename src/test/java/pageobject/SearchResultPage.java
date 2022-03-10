package pageobject;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultPage {
    private final ElementsCollection searchResults = $$(".repo-list-item");

    public SearchResultPage openRepo(String repoName){
        searchResults
                .findBy(text(repoName))
                .$("a")
                .click();

        return this;
    }
}
