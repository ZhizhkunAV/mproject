package test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class MainClass {
    public static void main(String[] args) throws InterruptedException {

        //InterruptedException - Прерывание-это указание потоку, что он должен остановить то, что он делает, и сделать что-то еще.
        // Завязан с методом java Thread.sleep(3000) в данном кейсе. В Java есть несколько методов, которые генерируют исключение InterruptedException.
        // К ним относятся Thread.sleep(), Thread.join(), метод wait() класса Object и методы put() и take() BlockingQueue.

        System.setProperty("webdriver.chrome.driver", "C:\\soft\\driver\\chromedriver.exe");
//      System.setProperty("webdriver.gecko.driver", "C:\\soft\\driver\\geckodriver.exe");


        WebDriver driver = new ChromeDriver();
//      WebDriver driver = new FirefoxDriver();


        //       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); При необходимости ставим неявное ожидание.
        driver.manage().window().maximize();

        driver.get("https://google.com");

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());


        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("Википедия главная страница");
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).click();
        Thread.sleep(3000);
        // Гуглим название.

        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        // Жмем на поиск и ищем википедию в гугле.

        driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div[1]/a/h3"));
        driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div[1]/a/h3")).click();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(3000);


        driver.findElement(By.xpath("//*[@id=\"searchInput\"]")).click();
        System.out.println(driver.findElement(By.xpath("//*[@id=\"searchInput\"]")).isSelected()); //используется при чек боксах и радиобаттонах.
        driver.findElement(By.xpath("//*[@id=\"searchInput\"]")).sendKeys("Генрих VIII");
        // ищем слово
        Thread.sleep(3000);


        if (driver.findElements(By.xpath("//*[@id=\"searchButton\"]")).size() > 0)
            System.out.println("Элемент найден.");
        else System.out.println("Элемента нет");


        driver.findElement(By.xpath("//*[@id=\"searchButton\"]")).click();
        Thread.sleep(3000);

        JavascriptExecutor jse1 = (JavascriptExecutor) driver;
        jse1.executeScript("window.scrollBy(0, 4500)", "");
        Thread.sleep(3000);

        WebElement link = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[1]/ul[5]/li[1]/a[1]"));
        System.out.println(link.getText()); //Вывели "Уильям Шекспир".
        link.click();
        // Нажимаем как на ссылку а не как на кнопку. Можно также как на кнопку. Пример ниже.
        // driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[1]/ul[5]/li[1]/a[1]")).click();
        // Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[3]/td/span/a/img")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/a[1]")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("/html/body/div[6]/div/div[2]/div/div[3]/div[3]/div[1]/a[1]/span[2]")).click();
        Thread.sleep(3000);


// Код ниже это кейс на проверку drag and drop.
        try {
            driver.get("https://crossbrowsertesting.github.io/drag-and-drop");
            Thread.sleep(2000);
            System.out.println(driver.getTitle());
            System.out.println(driver.getCurrentUrl());

            WebElement element = driver.findElement(By.id("draggable"));
            WebElement element2 = driver.findElement(By.id("droppable"));

            Actions actions = new Actions(driver);
            // actions.dragAndDrop("draggable", "droppable").build().perform();

            actions.moveToElement(element).clickAndHold().moveToElement(element2).release().build().perform();
        } catch (InterruptedException e) //ловим исключение
        {
            e.printStackTrace();
        } finally {
            Thread.sleep(3000);
        }


        /*
        driver.get("https://market.yandex.ru/catalog--stiralnye-mashiny/18031204/list?cpa=1&hid=90566&rs=eJwzYgpgBAABcwCG&suggest_text=%D1%81%D1%82%D0%B8%D1%80%D0%B0%D0%BB%D1%8C%D0%BD%D1%8B%D0%B5%20%D0%BC%D0%B0%D1%88%D0%B8%D0%BD%D1%8B&was_redir=1&rt=10&onstock=0&local-offers-first=0");

        List<WebElement> checkboxes = driver.findElements(By.xpath("/html/body/div[2]/div[5]/div/div[1]/div/div[4]/div/div/div/div/div/div[2]/div/div[3]/div/div/div/div/div[3]/div/fieldset/div/div/div/div/div/div"));
        Thread.sleep(3000);
        if (checkboxes.size() == 12) System.out.println("It's okay!");
        else System.out.println("FAIL!");
        for (WebElement checkbox : checkboxes){
            checkbox.click();
        }
        */

        driver.get("https://google.com");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("alert('Нажму на кнопку в алерте через 5 секунд')");
        Thread.sleep(5000);
        driver.switchTo().alert().accept();


        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("alert('Сценарий завершен')");
        Thread.sleep(3000);


        //       for (String windowHandle : driver.getWindowHandles()){ // переключаемся на новую вкладку.
        //           driver.switchTo().window(windowHandle);
        //       }

        System.out.print("Спасибо за внимание!");
        Thread.sleep(3000);

        driver.quit();
    }
}





CalendarComponent
  package pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public void setDate(String day, String month, String year){

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month").$(byText(day)).click();
    }
}

RegistrationPage
package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }
    CalendarComponent calendarComponent = new CalendarComponent();
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            currentAddress = $("#currentAddress"),
            userGender = $("#genterWrapper"),
            userHobbies = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            subjectsInput = $("#subjectsInput"),
            stateInput = $("#state"),
            stateCityWrapper = $("#stateCity-wrapper"),
            cityInput =  $("#city"),
            calendarInput = $("#dateOfBirthInput"),
            submitClick = $("#submit"),
            submitClickE = $(byText("Close"));


    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastNameInput(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserEmailInput(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserNumberInput(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddress.setValue(value);

        return this;
    }

    public RegistrationPage checkUserGender(String value) {
        userGender.$(byText(value)).click();

        return this;
    }

    public RegistrationPage checkUserHobbies(String value) {
        userHobbies.$(byText(value)).click();

        return this;
    }

    public RegistrationPage addUploadPictures(String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setSubjectsInput(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setState(String value) {
        stateInput.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        cityInput.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage submitClickButton () {
        submitClick.click();

        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }

    public RegistrationPage submitClickExit () {
        submitClickE.click();

        return this;
    }

    public RegistrationPage submitClickButtonisDisplayed () {
        submitClick.isDisplayed();

        return this;
    }
}

TextBoxPage
    package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {
    public TextBoxPage openPage() {
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    private SelenideElement userName = $("#userName"),
            userEmail = $("#userEmail"),
            currentAddress = $("#currentAddress"),
            permanentAddress = $("#permanentAddress"),
            submitClick = $("#submit");

    public TextBoxPage inputUserName(String value) {
        userName.setValue(value);

        return this;
    }

    public TextBoxPage inputUserEmail(String value) {
        userEmail.setValue(value);

        return this;
    }

    public TextBoxPage inputCurrentAddress(String value) {
        currentAddress.setValue(value);

        return this;
    }

    public TextBoxPage inputPermanentAddress(String value) {
        permanentAddress.setValue(value);

        return this;
    }

    public TextBoxPage inputSubmitClick() {
        submitClick.click();

        return this;
    }
    public TextBoxPage checkResult(String key, String value) {
        $(".text-field-container").$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }
}

ActionsInTests
    package tests.Registration;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class ActionsInTests {

    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl ="https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @AfterEach
    void afterEach(){
        Selenide.closeWebDriver();
    }
}

RegistrationsTest
    package tests.Registration;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import tests.Registration.ActionsInTests;


public class RegistrationsTest extends ActionsInTests {


    RegistrationPage registrationPage = new RegistrationPage();
    @Test
    void successFormTest() {

        registrationPage.openPage()
                .setFirstName("Ivan")
                .setLastNameInput("Ivanov")
                .setUserEmailInput("Ivanov2904.I@list.ru")
                .setUserNumberInput("8937799914")
                .setCurrentAddress("Country, City, Street, House 1")
                .checkUserGender("Male")
                .checkUserHobbies("Sports")
                .checkUserHobbies("Music")
                .addUploadPictures("images/png.jpg")
                .setSubjectsInput("History")
                .setState("Haryana")
                .setCity("Karnal")
                .setBirthDate("22", "August", "1991")
                .submitClickButton();

        //ассерты
        registrationPage.checkResult("Student Name", "Ivan Ivanov")
        .checkResult("Student Email", "Ivanov2904.I@list.ru")
        .checkResult("Gender", "Male")
        .checkResult("Mobile", "8937799914")
        .checkResult("Date of Birth", "22 August,1991")
        .checkResult("Subjects", "History")
        .checkResult("Hobbies", "Sports, Music")
        .checkResult("Picture", "png.jpg")
        .checkResult("Address", "Country, City, Street, House 1")
        .checkResult("State and City", "Haryana Karnal")
        .submitClickExit();
    }

    @Test
    void successFormTestMinimumField() {

        registrationPage.openPage()
                .setFirstName("Ivan")
                .setLastNameInput("Ivanov")
                .setUserNumberInput("8937799914")
                .checkUserGender("Male")
                .submitClickButton();

        //ассерты
        registrationPage.checkResult("Student Name", "Ivan Ivanov")
                .checkResult("Gender", "Male")
                .setUserNumberInput("8937799914")
                .submitClickExit();
    }

    @Test
    void emptyFormTest() {

        registrationPage.openPage()
                .setFirstName("Ivan")
                .setLastNameInput("Ivanov")
                .checkUserGender("Male");
        //ассерты
        registrationPage.submitClickButtonisDisplayed();
    }
}

TestLegacy
    package tests.Registration;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestLegacy {

    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl ="https://demoqa.com";
        Configuration.browserSize = "1366x768";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {

        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("Ivanov2904.I@list.ru");
        $("#userNumber").setValue("8937799914");
        $("#currentAddress").setValue("Country, City, Street, House № 1");

        $("#uploadPicture").uploadFromClasspath("images/png.jpg");

        $("[for=gender-radio-1]").click();
        $("[for=hobbies-checkbox-1]").click();
        $("[for=hobbies-checkbox-3]").click();

        $("#subjectsInput").setValue("History").pressEnter();

        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();


        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $("[value='1990']").click();
        $(".react-datepicker__month").$(byText("15")).click();

        $("#submit").click();

        //ассерты
        $(".table-responsive").shouldHave(text("Ivan Ivanov"));
        $(".table-responsive").shouldHave(text("Ivanov2904.I@list.ru"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("8937799914"));
        $(".table-responsive").shouldHave(text("15 March,1990"));
        $(".table-responsive").shouldHave(text("History"));
        $(".table-responsive").shouldHave(text("Sports, Music"));
        $(".table-responsive").shouldHave(text("images/png.jpg"));
        $(".table-responsive").shouldHave(text("Country, City, Street, House 1"));
        $(".table-responsive").shouldHave(text("Haryana Karnal"));

        $(byText("Close")).click();
    }

}

testBox

    package tests.TextBox;


import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
import tests.Registration.ActionsInTests;


public class TestBox extends ActionsInTests {
    TextBoxPage textboxpage = new TextBoxPage();

    @Test
    void testBox(){
        textboxpage.openPage()
                .inputUserName("Ivanov Ivan Ivanovich")
                .inputUserEmail("sdf@list.ru")
                .inputCurrentAddress("Current Best Address")
                .inputPermanentAddress("Permanent Address")
                .inputSubmitClick();

        textboxpage.checkResult("Name:", "Ivanov Ivan Ivanovich")
                .checkResult("Email:", "sdf@list.ru")
                .checkResult("Current Address :", "Current Best Address")
                .checkResult("Permananet Address :", "Permanent Address");
    }
}

    















