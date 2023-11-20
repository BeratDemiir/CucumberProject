package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.DataTablesPages;
import utilities.Driver;

import java.io.IOException;


public class DataTablesStepDefinitions {

    DataTablesPages dataTablesPages = new DataTablesPages();
    @Given("kullanici {string} gider")
    public void kullanici_gider(String string) {
        Driver.getDriver().get(string);
    }
    @When("kullanici new butonuna tiklar")
    public void kullanici_new_butonuna_tiklar() {
        dataTablesPages.newButon.click();
    }
    @When("kullanici first name {string} girer")
    public void kullanici_first_name_girer(String string) {
        dataTablesPages.firstName.sendKeys(string);
    }
    @When("kullanici last name {string} girer")
    public void kullanici_last_name_girer(String string) {
        dataTablesPages.lastName.sendKeys(string);
    }
    @When("kullanici positions {string} girer")
    public void kullanici_positions_girer(String string) {
        dataTablesPages.position.sendKeys(string);
    }
    @When("kullanici office {string} girer")
    public void kullanici_office_girer(String string) {
        dataTablesPages.office.sendKeys(string);
    }
    @When("kullanici extension {string} girer")
    public void kullanici_extension_girer(String string) {
        dataTablesPages.extension.sendKeys(string);
    }
    @When("kullanici start_date {string} girer")
    public void kullanici_start_date_girer(String string) {
        dataTablesPages.startDate.sendKeys(string);
    }
    @When("kullanici salary {string} girer")
    public void kullanici_salary_girer(String string) {
        dataTablesPages.salary.sendKeys(string);
    }
    @When("kullanici create buttonuna basar")
    public void kullanici_create_buttonuna_basar() {
        dataTablesPages.create.click();
    }
    @When("kullanici firstname ile {string} arar")
    public void kullanici_firstname_ile_arar(String string) {
        dataTablesPages.search.sendKeys(string);
    }
    @Then("firstname {string} in olustugunu test et")
    public void firstname_in_olustugunu_test_et(String string) {
        Driver.wait(2);
        Assert.assertTrue(Driver.waitAndGetText(dataTablesPages.name,5).contains(string));// Reusable method kullanarak test et
      //   Assert.assertTrue(dataTablesPages.name.getText().contains(string));
    }
    @Then("ekran goruntusu al")
    public void ekran_goruntusu_al() throws IOException {
        Driver.getScreenshot("Data Tables");
    }
}
