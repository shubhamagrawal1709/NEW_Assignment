package info.seleniumcucumber.methods;

import env.DriverUtil;
import org.openqa.selenium.WebDriver;

public class JavascriptHandlingMethods implements BaseTest {
  protected WebDriver driver = DriverUtil.getDefaultDriver();
  
  public void handleAlert(String decision) {
    if (decision.equals("accept")) {
      this.driver.switchTo().alert().accept();
    } else {
      this.driver.switchTo().alert().dismiss();
    } 
  }
}
