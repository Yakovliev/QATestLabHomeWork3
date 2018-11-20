import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.DriverManager;

import java.time.Duration;

public class MainTest {

    public static void main(String[] args) {
        WebDriver driver = DriverManager.getConfiguredDriver("chrome");
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");

        WebElement emailInput = driver.findElement(By.id("email"));
        WebElement passwordInput = driver.findElement(By.id("passwd"));
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login_form\"]/div[3]/button"));

        emailInput.sendKeys("webinar.test@gmail.com");
        passwordInput.sendKeys("Xcg7299bnSmMuRLp9ITw");
        loginButton.click();


        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("subtab-AdminCatalog")));



        WebElement catalog = driver.findElement(By.id("subtab-AdminCatalog"));
        WebElement categories = driver.findElement(By.id("subtab-AdminCategories"));

        Actions actions = new Actions(driver);
        actions.moveToElement(catalog).pause(Duration.ofSeconds(2)).moveToElement(categories)
                .pause(Duration.ofSeconds(2)).click(categories).build().perform();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("page-header-desc-category-new_category")));

        WebElement iconAddCategory = driver.findElement(By.id("page-header-desc-category-new_category"));
        iconAddCategory.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name_1")));

        String categoryName = "innovationCategory";

        WebElement inputName = driver.findElement(By.id("name_1"));
        inputName.sendKeys(categoryName);

        WebElement saveButton = driver.findElement(By.id("category_form_submit_btn"));

        actions.moveToElement(saveButton).pause(Duration.ofSeconds(3)).click(saveButton).build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/div[3]/div")));

        //WebElement backToListButton = driver.findElement(By.id("desc-category-back"));
        //actions.moveToElement(backToListButton).pause(Duration.ofSeconds(3)).click(backToListButton).build().perform();

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='categoryFilter_name']")));

        WebElement seacrhButton = driver.findElement(By.id("submitFilterButtoncategory"));
        WebElement categoryInput = driver.findElement(By.xpath("//input[@name='categoryFilter_name']"));

        categoryInput.sendKeys(categoryName);

        actions.moveToElement(seacrhButton).pause(Duration.ofSeconds(2)).click(seacrhButton).build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"table-category\"]/tbody")));

        WebElement searchedCategoryNameWE = driver.findElements(By.cssSelector("td[class='pointer']")).get(0);

        String searchedCategoryName = searchedCategoryNameWE.getText();
        System.out.println("Searched Category Name: " + searchedCategoryName);

        if (searchedCategoryName.equals(categoryName))
            System.out.println("All right!");
        else
            System.out.println("Something went wrong");

        driver.quit();

    }

}
