package info.seleniumcucumber.userStepDefintions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObject.NDTVPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import env.DriverUtil;
import info.seleniumcucumber.methods.BaseTest;

public class NDTVSteps implements BaseTest{
	private TestContext testContext;
	protected WebDriver driver = DriverUtil.getDefaultDriver();

	
	NDTVPage objLogin;

	public NDTVSteps(TestContext testContext) {
		this.testContext = testContext;
		objLogin = new NDTVPage(driver);
		
	}
	
	
	@Then("^I click on subMenu options$")
	public void i_click_on_subMenu_options() throws Throwable {
		objLogin.clickOnSubMenu();

	}

	@Then("^I click on weather tab$")
	public void i_click_on_weather_tab() throws Throwable {
		objLogin.clickOnWeather();

	}

	@Then("^I enter \"([^\"]*)\" into input searchBox field$")
	public void i_enter_into_input_searchBox_field(String arg1) throws Throwable {
		objLogin.enterValueInSearchBox(arg1);

	}

	@Then("^Entered \"([^\"]*)\" should be present$")
	public void entered_should_be_present(String arg1) throws Throwable {
		objLogin.enteredCityPresent(arg1);

	}

	@Then("^I check the checkbox having \"([^\"]*)\"$")
	public void i_check_the_checkbox_having(String arg1) throws Throwable {
		
		inputObj.checkCheckbox(By.id(arg1));

	}

	@Then("^I store the temperature for \"([^\"]*)\"$")
	public void i_store_the_temperature(String arg1) throws Throwable {
		objLogin.storeTemperature(testContext,arg1);
	}

	@Then("^I need to compare the temperature with variance of \"([^\"]*)\" degree$")
	public void i_need_to_compare_the_temperature_with_variance_of_degree(String arg1) throws Throwable {
		objLogin.compareTempretaure(testContext,arg1);
	}



	@Then("^I need to call weatehr API endpoint \"([^\"]*)\" with city \"([^\"]*)\" and appid \"([^\"]*)\"$")
	public void i_need_to_call_weatehr_API_endpoint_with_city_and_appid(String arg1, String arg2, String arg3) throws Throwable {

		objLogin.callWeatherAPI(testContext,arg1,arg2,arg3);
	}

	@Given("^I should get logged-in$")
	public void should_logged_in() throws Throwable {

		By selection = By.id("flash");
		(new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(selection));
		String msg = driver.findElement(By.id("flash")).getText();
		if (!msg.isEmpty())
			msg = msg.split("\n")[0].trim();
		Assert.assertEquals("You logged into a secure area!", msg);
	}
	

}
