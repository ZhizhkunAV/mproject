package tests.freetest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class freetests {
    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl ="https://rzd-medicine.ru/";
        Configuration.browserSize = "1366x768";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    @DisplayName("Проверка адреса медицинского учреждения - г. Москва и МО, рабочий посёлок Киевский, 12а")
    void fillFormTest() {

        open("");
        $(".header-menu").$(byText("Цены")).click();
        $(".pricelist").$(".select").click();
        $(".dropdownList").$(".wrap").$("[aria-label=Поиск]").setValue("поликлиника");
        $(".dropdownList").$(".list").$(".item-description")
                .shouldHave(text("г. Москва и МО, рабочий посёлок Киевский, 12а"));
    }
}

-Xmx1971m
-Dconsole.encoding=UTF-8
-Dfile.encoding=UTF-8


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


