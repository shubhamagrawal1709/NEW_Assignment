package info.seleniumcucumber.userStepDefintions;

import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import env.DriverUtil;
import info.seleniumcucumber.methods.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

public class UserStepDefinitions implements BaseTest {
	private TestContext testContext;
	protected WebDriver driver = DriverUtil.getDefaultDriver();
	private static String token;
	private static Response response;
	private static String jsonString;

	public UserStepDefinitions(TestContext testContext) {
		this.testContext = testContext;
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

	@Then("^I store the temperature for \"([^\"]*)\"$")
	public void i_store_the_temperature(String arg1) throws Throwable {
		boolean flag = false;
		By selection = By.xpath(
				"//*[@id='map_canvas']/div[1]/div[4]//*[@class='leaflet-marker-icon my-div-icon leaflet-zoom-animated leaflet-interactive']/div");
		(new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(selection));

		List<WebElement> allProduct = driver.findElements(By.xpath(
				"//*[@id='map_canvas']/div[1]/div[4]//*[@class='leaflet-marker-icon my-div-icon leaflet-zoom-animated leaflet-interactive']/div"));
		System.out.println("Size of list ::::" + allProduct.size());
		for (WebElement product : allProduct) {
			String title = product.getAttribute("title");
			System.out.println("Title::::::::" + title);
			if (title.equalsIgnoreCase(arg1)) {
				flag = true;
				WebElement tempreature = product.findElement(By.xpath(
						"//*[@id='map_canvas']/div[1]/div[4]//*[@class='leaflet-marker-icon my-div-icon leaflet-zoom-animated leaflet-interactive']/div/div//*[@class='tempRedText']"));
				System.out.println("Temperature :::::::::" + tempreature.getText());
				String temperature = tempreature.getText();

				testContext.scenarioContext.setContext(Context.NDTV_TEMPERATURE, temperature);

				break;
			}

		}
		Assert.assertTrue(flag);
	}

	@Then("^I need to call weatehr API endpoint \"([^\"]*)\" with q \"([^\"]*)\" and appid \"([^\"]*)\"$")
	public void i_need_to_call_weatehr_API_endpoint_with_q_and_appid(String arg1, String arg2, String arg3)
			throws Throwable {

		String url = "http://" + arg1 + "?appid=" + arg3 + "&q=" + arg2;

		System.out.println(url);
		Response response = doGetRequest(url);
		//System.out.println(response.jsonPath().getString("main.temp"));
		int temp = (int) Math.ceil(Double.parseDouble(response.jsonPath().getString("main.temp"))-273);
		
		System.out.println("API tempretaure ::::"+temp);

		testContext.scenarioContext.setContext(Context.API_TEMPERATURE, String.valueOf(temp));

	}

	@Then("^I need to compare the temperature with variance of \"([^\"]*)\" degree$")
	public void i_need_to_compare_the_temperature_with_variance_of_degree(String arg1) throws Throwable {
		double ntdvTemp = Double.parseDouble((String) testContext.scenarioContext.getContext(Context.NDTV_TEMPERATURE).toString().replaceAll("[^0-9]", ""));
		double apiTemp = Double.parseDouble((String) testContext.scenarioContext.getContext(Context.API_TEMPERATURE).toString().replaceAll("[^0-9]", ""));
		
		System.out.println("ndtv value  :::"+ntdvTemp);
		System.out.println("api value  :::"+apiTemp);
		double varaince = Double.parseDouble(arg1);
		if (ntdvTemp < apiTemp - varaince || ntdvTemp > apiTemp + varaince) {

			Assert.assertTrue(false);
		}
		
		else
		{
		Assert.assertTrue(true);
		}
	}

	public static Response doGetRequest(String endpoint) {
		RestAssured.defaultParser = Parser.JSON;

		return RestAssured.given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).when()
				.get(endpoint).then().contentType(ContentType.JSON).extract().response();
	}

}
