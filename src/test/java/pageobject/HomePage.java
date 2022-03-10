package pageobject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    private final SelenideElement inputSearch = $("[name=q]");

    public HomePage search(String text){
        inputSearch
                .setValue(text)
                .pressEnter();

        return this;
    }
}
