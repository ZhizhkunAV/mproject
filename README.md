package tests.freetest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

@DisplayName("Тесты на проверку вывода на UI адресов поликлиник")
public class freetests {
    @BeforeEach
    void setUp(){
        open("");
        Selenide.closeWebDriver();
    }

    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl ="https://rzd-medicine.ru/";
        Configuration.browserSize = "1366x768";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @ValueSource(strings = {
            "г. Москва и МО, ул. Новая Басманная, 5", "г. Москва и МО, рабочий посёлок Киевский, 12а"
    })
    @ParameterizedTest(name = "Проверка наличия адреса медицинского учреждения - {0}")
    @Test
    @Tags({
            @Tag("WEB"),
            @Tag("BLOCKER")
    })
    void fillFormTest(String searchQuery) {
        $(".header-menu").$(byText("Цены")).click();
        $(".pricelist").$(".select").click();
        $(".dropdownList").$(".wrap").$("[aria-label=Поиск]").setValue("поликлиника");
        $(".dropdownList").$(".list").$(".item-description")
                .shouldHave(text(searchQuery));
    }

    @Disabled("Jira-1234")
    @Test
    @DisplayName("WEB: Проверка адреса медицинского учреждения - г. Москва и МО, рабочий посёлок Киевский, 12а")
    @Tag("WEB")
    void fillFormTestq() {
        $(".header-menu").$(byText("Цены")).click();
        $(".pricelist").$(".select").click();
        $(".dropdownList").$(".wrap").$("[aria-label=Поиск]").setValue("поликлиника");
        $(".dropdownList").$(".list")
                .shouldHave(text("г. Москва и МО, рабочий посёлок Киевский, 12а"));
    }


    @Test
    void imagesYandex() {
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $(byText("SoftAssertions")).click();
        $("#discussions-tab").click();
        $(".ActionList").$$("<ul>");


    }



}



plugins {
    id 'java'
}

group 'org.example24'
version '1.0-SNAPSHOT'

repositories {
    mavenCentral()
}

compileJava {
    options.encoding = 'UTF-8'
}
compileTestJava {
    options.encoding = 'UTF-8'
}

dependencies {
    testImplementation(
            'org.junit.jupiter:junit-jupiter:5.9.2',
            'com.codeborne:selenide:6.19.1',
            'com.github.javafaker:javafaker:1.0.2',
            'org.slf4j:slf4j-simple:2.0.7'
    )
}

test {
    useJUnitPlatform()
}

compileJava.options.encoding = 'UTF-8'
tasks.withType(JavaCompile){
    options.encoding = 'UTF-8'
}
