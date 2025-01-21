import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;


public class AllureTests {

    public final String url = "https://github.com/";
    public final String repositoryName = "Vitaly-qa/AllureReports-HW10";

    @Test

    public void checkIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open(url);
        $(".header-search-button").click();
        $("#query-builder-test").setValue(repositoryName).pressEnter();
        $(linkText(repositoryName)).click();
        $("#issues-tab").shouldHave(text("Issues"));

    }

    @Test

    public void testLambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу", () -> {

            open("https://github.com");
        });
        step("Ищем репозиторий" + repositoryName, () -> {

            $(".header-search-button").click();
            $("#query-builder-test").setValue(repositoryName).pressEnter();
        });
        step("Кликаем по ссылке репозитория" + repositoryName, () -> {

            $(linkText(repositoryName)).click();
        });
        step("Проверка Issues", () -> {
            $("#issues-tab").shouldHave(text("Issues"));
        });

    }


    @Test
    public void checkIssueWithSteps() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        StepsForAnnotation steps = new StepsForAnnotation();
        steps.openMainPage();
        steps.findRepository();
        steps.checkElement();
    }
}
