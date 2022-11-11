import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class MaxKorzhTest {

    //    TC_1_1  - Тест кейс:
    //    //1. Открыть страницу https://openweathermap.org/
    //    //2. Набрать в строке поиска город Paris
    //    //3. Нажать пункт меню Search
    //    //4. Из выпадающего списка выбрать Paris, FR
    //    //5. Подтвердить, что заголовок изменился на "Paris, FR"

    @Test
    public void testH2TagText_WhenSearchingCityCountry() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/Olga/Desktop/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String cityName = "Paris";
        String expectedResult = "Paris, FR";

        driver.get(url);
        Thread.sleep(5000);

        WebElement searchCityField = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//input[@placeholder = 'Search city']")
        );
        searchCityField.click();
        searchCityField.sendKeys(cityName);

        WebElement searchButton = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//button[@type = 'submit']")
        );
        searchButton.click();
        Thread.sleep(1000);

        WebElement parisFRChoiceInDropdownMenu = driver.findElement(
                By.xpath("//ul[@class = 'search-dropdown-menu']/li/span[text() = 'Paris, FR ']")
        );
        parisFRChoiceInDropdownMenu.click();

        WebElement h2CityCountryHeader = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//h2")
        );
        Thread.sleep(2000);
        String actualResult = h2CityCountryHeader.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }


    @Test
//    TC_11_01
//1.  Открыть базовую ссылку
//2.  Нажать на пункт меню Guide
//3.  Подтвердить, что вы перешли на страницу со ссылкой https://openweathermap.org/guide
// и что title этой страницы OpenWeatherMap API guide - OpenWeatherMap

    public void testGuideUrlAndHeader() {
        System.setProperty("webdriver.chrome.driver", "/Users/Olga/Desktop/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResultTitle = "OpenWeatherMap API guide - OpenWeatherMap";
        String expectedResultUrl = "https://openweathermap.org/guide";

        driver.get(url);

        WebElement guideElementInMenu = driver.findElement(
                By.xpath("//a[@href='/guide']")
        );
        guideElementInMenu.click();
        String actualResultUrl = driver.getCurrentUrl();
        String actualResultTitle = driver.getTitle();

        Assert.assertEquals(actualResultUrl, expectedResultUrl);
        Assert.assertEquals(actualResultTitle, expectedResultTitle);

        driver.quit();
    }

    @Test
//    TC_11_02
//1.  Открыть базовую ссылку
//2.  Нажать на единицы измерения Imperial: °F, mph
//
//3.  Подтвердить, что температура для города показана в Фарингейтах London GB

    public void test2() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/Olga/Desktop/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResultF = "F";

        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        WebElement menuImperial = driver.findElement(
                By.xpath("//div[@class='switch-container']/div[@class=óption]/following-sibling::div"));

        menuImperial.click();

        WebElement tempF = driver.findElement(By.xpath("//div[@class='çurrent-temp']/span"));

        String tempInf = tempF.getText();
        String actualResult = tempInf.substring((tempInf.length()-2));

        Assert.assertEquals(actualResult, expectedResultF);


        driver.quit();
    }

    @Test
//    TC_11_03
//1.  Открыть базовую ссылку
//2. Подтвердить, что внизу страницы есть панель с текстом “We use cookies which are essential for the site to work.
//    We also use non-essential cookies to help us improve our services. Any data collected is anonymised.
//    You can allow all cookies or manage them individually.”
//            3. Подтвердить, что на панели внизу страницы есть 2 кнопки “Allow all” и “Manage cookies”

    public void testApproveTwoButtonsInPanel() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/Olga/Desktop/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResult = "We use cookies which are essential\n" +
                " for the site to work. We also use non-essential cookies to help us improve our services.\n" +
                " Any data collected is anonymised. You can allow all cookies or manage them individually.";

        driver.get(url);
        Thread.sleep(5000);

        WebElement textElement = driver.findElement(
                By.className("stick-footer-panel_description"));
        WebElement buttonAllowAll = driver.findElement(
                By.xpath("//button[text()='Állow all']"));
        WebElement buttonManageCoolies = driver.findElement(
                By.xpath("////a[@href='/cookies-settings']"));

        Assert.assertEquals(buttonAllowAll.getText(), "Allow all");
        Assert.assertEquals(buttonManageCoolies.getText(), "Manage cookies");
        Assert.assertEquals(textElement.getText(),expectedResult);

        driver.quit();
    }

    @Test
//    TC_11_04
//1.  Открыть базовую ссылку
//2.  Подтвердить, что в меню Support есть 3 подменю с названиями “FAQ”, “How to start” и “Ask a question”







}


