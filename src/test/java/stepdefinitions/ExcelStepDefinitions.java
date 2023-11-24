package stepdefinitions;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.HomePage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExcelUtils;
import utilities.ReusableMethods;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ExcelStepDefinitions {
    //    Page Objelerini Olustur
    HomePage homePage;
    LoginPage loginPage;
    ExcelUtils excelUtils;
    List<Map<String,String>> excelData;

    @Given("kullanici {string} bilgileri ile giris yapar")
    public void kullanici_bilgileri_ile_giris_yapar(String sayfaAdi) throws IOException {
        String path="./src/test/resources/testdata/mysmoketestdata.xlsx";
//        String sayfa = "customer_info";
        excelUtils = new ExcelUtils(path,sayfaAdi);
        excelData = excelUtils.getDataList();
//        NOTE Loop kodunu tamamla
        for (Map<String,String> data : excelData) {
            Driver.getDriver().get(ConfigReader.getProperty("app_url"));
            homePage = new HomePage();
            loginPage = new LoginPage();
//            ana sayfa login buttonuna tikla
            homePage.firstLogin.click();
            ReusableMethods.waitFor(1);
//            emaili gonder
            loginPage.email.sendKeys(data.get("username"));
            ReusableMethods.waitFor(1);
//            sifre gonder
            loginPage.password.sendKeys(data.get("password"));
//            login button'una tikla
            loginPage.login.click();
            ReusableMethods.waitFor(1);
//            GIRIS YAPILDI. GIRIS YAPILDIGINI VERIFY EDELIM
//            ID GORUNUR ISE GIRIS BASARILIDIR
            Assert.assertTrue(homePage.userID.isDisplayed());
            ReusableMethods.getScreenshot("Login_Goruntusu");
//            LOG OUT YAPALIM
            homePage.userID.click();
            ReusableMethods.waitFor(1);
            homePage.logOutLink.click();
            ReusableMethods.waitFor(1);
            homePage.OK.click();
            ReusableMethods.waitFor(1);
        }
        Driver.closeDriver();
//        lambda ile
//        excelData.forEach(data -> {
//            Driver.getDriver().get(ConfigReader.getProperty("app_url"));
//            homePage = new HomePage();
//            loginPage = new LoginPage();
//            homePage.firstLogin.click();
//            ReusableMethods.waitFor(1);
//            loginPage.email.sendKeys(data.get("username"));
//            loginPage.password.sendKeys(data.get("password"));
//            loginPage.login.click();
//        });
    }
}


