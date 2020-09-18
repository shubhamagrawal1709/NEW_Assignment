package PageObject;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import info.seleniumcucumber.methods.BaseTest;
import info.seleniumcucumber.userStepDefintions.Context;
import info.seleniumcucumber.userStepDefintions.TestContext;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;


public class NDTVPage implements BaseTest {
	
	protected WebDriver driver ;


	    By subMenu = By.xpath("//*[@id='h_sub_menu']");

	    By weather =By.xpath("//a[text()='WEATHER']");

	    By searchBox = By.id("searchBox");

	    public NDTVPage(WebDriver driver){

	        this.driver = driver;

	    }
	    
	    public void clickOnSubMenu(){

	    	 clickObj.click(subMenu);

	    }
	    
	    public void clickOnWeather(){

	    	 clickObj.click(weather);

	    }

		public void enterValueInSearchBox(String arg) {
			inputObj.enterText(arg, searchBox);
		
		}

		public void enteredCityPresent(String agr1) {
			assertionObj.isElementDisplayed(By.id(agr1));
		
		}
		
		public void storeTemperature(TestContext testContext, String city)
		{
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
				if (title.equalsIgnoreCase(city)) {
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
		
		
		public void compareTempretaure(TestContext testContext, String arg1)
		{
			
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
		
		
		public void callWeatherAPI(TestContext testContext, String arg1, String arg2, String arg3)
		{
			
			
			String url = "http://" + arg1 + "?appid=" + arg3 + "&q=" + arg2;

			System.out.println(url);
			Response response = NDTVPage.doGetRequest(url);
			//System.out.println(response.jsonPath().getString("main.temp"));
			int temp = (int) Math.ceil(Double.parseDouble(response.jsonPath().getString("main.temp"))-273);
			
			System.out.println("API tempretaure ::::"+temp);

			testContext.scenarioContext.setContext(Context.API_TEMPERATURE, String.valueOf(temp));
		}
		

		public static Response doGetRequest(String endpoint) {
			RestAssured.defaultParser = Parser.JSON;

			return RestAssured.given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).when()
					.get(endpoint).then().contentType(ContentType.JSON).extract().response();
		}
		
	    

}
