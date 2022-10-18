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