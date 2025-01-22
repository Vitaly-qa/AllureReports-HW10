import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;


public class StepsForAnnotation {

    public final String repo = "Vitaly-qa/AllureReports-HW10";

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com/");
    }

    @Step("Находим репозиторий" + repo)
    public void findRepository() {
        $(".search-input").click();
        $("#query-builder-test").setValue(repo).pressEnter();

    }

    @Step("Нажать на ссылку найденого репозитория" + repo)
    public void clicRepository() {
        $(linkText(repo)).click();
    }

    @Step("Проверка на наличие Issue в элементе")
    public void checkElement() {
        $("#repository-container-header").shouldHave(text("Issue"));
    }
}
