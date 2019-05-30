package step_definitions;

import cucumber.api.java.en.*;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class MyStepdefs {

    private WebDriver driver;

    @Given("there is browser opened with page {string}")
    public void thereIsBrowserWithPage(String url) {
        System.setProperty("webdriver.chrome.driver", "/home/cornholio/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);


    }

    @When("user clicks zaloz konto button")
    public void userClicksRegisterButton() {
        driver.findElement(By.xpath("//input[@value='Załóż konto']")).click();
    }

    @Then("user is on registration page")
    public void userIsOnRegistrationPage() {
        String URL = driver.getCurrentUrl();
        Assert.assertTrue(URL.contains("https://men-men-s-01.codersguru.pl/register/"));
    }

    @When("user fills all mandatory fields with values:")
    public void userFillsAllMandatoryFieldsWithValues(DataTable dataTable) {
        List<List<String>> lists = dataTable.asLists();

        for (List<String> list : lists) {
            driver.findElement(By.id(list.get(0))).sendKeys(list.get(1));
        }

        driver.findElement(By.xpath("//input[@type='checkbox']")).click();

    }
    @And("user clicks Zarejestruj button")
    public void userClicksZarejestrujButton() {
        driver.findElement(By.id("register-submit-btn")).click();
        String URL = driver.getCurrentUrl();
        Assert.assertTrue(URL.contains("https://men-men-s-01.codersguru.pl/register/confirmed"));
    }



    @When("input field mail is filed with (.*)")
    public void inputFieldMailIsFiledWithMailparameter(String parameter) {
        driver.findElement(By.id("fos_user_registration_form_email")).sendKeys(parameter);
    }

    @And("input field name is filed with (.*)")
    public void inputFieldNameIsFiledWithNameparameter(String parameter) {
        driver.findElement(By.id("fos_user_registration_form_name")).sendKeys(parameter);
    }

    @And("input field lastname is filed with (.*)")
    public void inputFieldLastnameIsFiledWithLastnameparameter(String parameter) {
        driver.findElement(By.id("fos_user_registration_form_lastname")).sendKeys(parameter);
    }

    @And("input field password is filed with (.*)")
    public void inputFieldPasswordIsFiledWithPasswordparameter(String parameter) {
        driver.findElement(By.id("fos_user_registration_form_plainPassword_first")).sendKeys(parameter);
    }

    @And("input field secondpassword is filed with (.*)")
    public void inputFieldSecondpasswordIsFiledWithSecondpasswordparameter(String parameter) {
        driver.findElement(By.id("fos_user_registration_form_plainPassword_second")).sendKeys(parameter);
    }

    @And("input field city is filed with (.*)")
    public void inputFieldCityIsFiledWithCityparameter(String parameter) {
        driver.findElement(By.id("form_city")).sendKeys(parameter);
    }

    @And("input field zip is filed with (.*)")
    public void inputFieldZipIsFiledWithZipparameter(String parameter) {
        driver.findElement(By.id("form_postal_code")).sendKeys(parameter);
    }

    @And("input field street is filed with (.*)")
    public void inputFieldStreetIsFiledWithStreetparameter(String parameter) {
        driver.findElement(By.id("form_street")).sendKeys(parameter);
    }

    @And("input field number is filed with (.*)")
    public void inputFieldNumberIsFiledWithNumberarameter(String parameter) {
        driver.findElement(By.id("form_number")).sendKeys(parameter);
    }

    @And("user select cheackbox")
    public void userSelectCheackbox() {
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
    }


}

