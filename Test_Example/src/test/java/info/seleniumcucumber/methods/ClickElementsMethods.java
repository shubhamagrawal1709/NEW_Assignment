package info.seleniumcucumber.methods;

import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class ClickElementsMethods extends SelectElementByType implements BaseTest {
  private WebElement element = null;
  
  public void click(String accessType, String accessName) {
    this.element = (WebElement)this.wait.until((Function)ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
    this.element.click();
  }
  
  public void clickForcefully(String accessType, String accessName) {
    this.element = (WebElement)this.wait.until((Function)ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
    JavascriptExecutor executor = (JavascriptExecutor)this.driver;
    executor.executeScript("arguments[0].click();", new Object[] { this.element });
  }
  
  public void doubleClick(String accessType, String accessValue) {
    this.element = (WebElement)this.wait.until((Function)ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessValue)));
    Actions action = new Actions(this.driver);
    action.moveToElement(this.element).doubleClick().perform();
  }
  
  public void click(By accessName) {
	    this.element = (WebElement)this.wait.until((Function)ExpectedConditions.presenceOfElementLocated(accessName));
	    this.element.click();
	  }
	  
	  public void clickForcefully(By accessName) {
	    this.element = (WebElement)this.wait.until((Function)ExpectedConditions.presenceOfElementLocated(accessName));
	    JavascriptExecutor executor = (JavascriptExecutor)this.driver;
	    executor.executeScript("arguments[0].click();", new Object[] { this.element });
	  }
	  
	  public void doubleClick(By accessValue) {
	    this.element = (WebElement)this.wait.until((Function)ExpectedConditions.presenceOfElementLocated(accessValue));
	    Actions action = new Actions(this.driver);
	    action.moveToElement(this.element).doubleClick().perform();
	  }
  
  
}
