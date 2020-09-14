package info.seleniumcucumber.methods;

import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProgressMethods extends SelectElementByType implements BaseTest {
  public void wait(String time) throws NumberFormatException, InterruptedException {
    Thread.sleep((Integer.parseInt(time) * 1000));
  }
  
  public void waitForElementToDisplay(String accessType, String accessName, String duration) {
    By byEle = getelementbytype(accessType, accessName);
    WebDriverWait wait = new WebDriverWait(this.driver, (Integer.parseInt(duration) * 1000));
    wait.until((Function)ExpectedConditions.visibilityOfElementLocated(byEle));
  }
  
  public void waitForElementToClick(String accessType, String accessName, String duration) {
    By byEle = getelementbytype(accessType, accessName);
    WebDriverWait wait = new WebDriverWait(this.driver, (Integer.parseInt(duration) * 1000));
    wait.until((Function)ExpectedConditions.elementToBeClickable(byEle));
  }
}
