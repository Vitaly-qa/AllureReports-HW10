import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class Smoke_tests extends TestBase {
    @Test
    @DisplayName("Проверка перехода на страницу о компании")
    @Tag("smoke")
    void conditionsTest() {
        step("Открываем страницу работа ", () -> {
            open("/career");
        });
        step("Нажимаем на контакты", () -> {
            $("a[href*='/contacts']").click();
        });
        step("Проверяем, что на странице содержится заголовок 'Контакты'", () -> {
            $(".heading__title").shouldHave(text("Контакты"));
        });
    }

    @Test
    @DisplayName("Выбор вакансии")
    @Tag("smoke")
    void jobSelectionTest() {
        step("Выбираем вакансию", () -> {
            open("/vacancies");
            $("a[href*='/page/3']").click();
            $(".vacancies__link").click();
            $(".info__subtitle").shouldHave(text("ПРИСОЕДИНЯЙТЕСЬ К НАМ!"));


        });
    }

    @Test
    @DisplayName("Переход на страницу Контакты")
    @Tag("smoke")
    void contactPageTest() {
        step("Переходим на страничку Контактов", () -> {
            open("/contacts");
            $(".locations__subtitle").shouldHave(text("Москва"));
        });
    }

    @Test
    @DisplayName("Переходим по кнопке Хабр на сайт Хабр")
    @Tag("smoke")
    void goingToTheWebsiteTest() {
        step("Наводим мышку на смену языка с RU на EN ", () -> {
            open("/contacts");
            $(".nav-open").click();
            $(".social__link",1).click();
            open("https://career.habr.com/companies/centicore");
            $(".title").shouldHave(text("О компании «Centicore Group»"));

        });

    }

    @Test
    @DisplayName("Переходим на страницу Высокие технологии")
    @Tag("smoke")
    void goToTheHighTechnologyPageTest
            () {
        step("Наводим мышку на смену языка с RU на EN ", () -> {
            open("/expertise");
            $(".categories__subtitle",2).click();
            $(".heading__title").shouldHave(text("ВЫСОКИЕ ТЕХНОЛОГИИ"));

        });
    }
}







