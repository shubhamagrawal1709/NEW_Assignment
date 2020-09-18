package info.seleniumcucumber.methods;

import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class AssertionMethods extends SelectElementByType implements BaseTest {
  private WebElement element = null;
  
  public String getPageTitle() {
    return this.driver.getTitle();
  }
  
  public void checkTitle(String title, boolean testCase) throws TestCaseFailed {
    String pageTitle = getPageTitle();
    if (testCase) {
      if (!pageTitle.equals(title))
        throw new TestCaseFailed("Page Title Not Matched, Actual Page Title : " + pageTitle); 
    } else if (pageTitle.equals(title)) {
      throw new TestCaseFailed("Page Title Matched, Actual Page Title : " + pageTitle);
    } 
  }
  
  public void checkPartialTitle(String partialTitle, boolean testCase) throws TestCaseFailed {
    String pageTitle = getPageTitle();
    if (testCase) {
      if (!pageTitle.contains(partialTitle))
        throw new TestCaseFailed("Partial Page Title Not Present, Actual Page Title : " + pageTitle); 
    } else if (pageTitle.contains(partialTitle)) {
      throw new TestCaseFailed("Partial Page Title Present, Actual Page Title : " + pageTitle);
    } 
  }
  
  public String getElementText(String accessType, String accessName) {
    this.element = (WebElement)this.wait.until((Function)ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
    return this.element.getText();
  }
  
  public void checkElementText(String accessType, String actualValue, String accessName, boolean testCase) throws TestCaseFailed {
    String elementText = getElementText(accessType, accessName);
    if (testCase) {
      if (!elementText.equals(actualValue))
        throw new TestCaseFailed("Text Not Matched"); 
    } else if (elementText.equals(actualValue)) {
      throw new TestCaseFailed("Text Matched");
    } 
  }
  
  public void checkElementPartialText(String accessType, String actualValue, String accessName, boolean testCase) throws TestCaseFailed {
    String elementText = getElementText(accessType, accessName);
    if (testCase) {
      if (!elementText.contains(actualValue))
        throw new TestCaseFailed("Text Not Matched"); 
    } else if (elementText.contains(actualValue)) {
      throw new TestCaseFailed("Text Matched");
    } 
  }
  
  public boolean isElementEnabled(String accessType, String accessName) {
    this.element = (WebElement)this.wait.until((Function)ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
    return this.element.isEnabled();
  }
  
  public void checkElementEnable(String accessType, String accessName, boolean testCase) throws TestCaseFailed {
    boolean result = isElementEnabled(accessType, accessName);
    if (testCase) {
      if (!result)
        throw new TestCaseFailed("Element Not Enabled"); 
    } else if (result) {
      throw new TestCaseFailed("Element Enabled");
    } 
  }
  
  public String getElementAttribute(String accessType, String accessName, String attributeName) {
    this.element = (WebElement)this.wait.until((Function)ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
    return this.element.getAttribute(attributeName);
  }
  
  public void checkElementAttribute(String accessType, String attributeName, String attributeValue, String accessName, boolean testCase) throws TestCaseFailed {
    String attrVal = getElementAttribute(accessType, accessName, attributeName);
    if (testCase) {
      if (!attrVal.equals(attributeValue))
        throw new TestCaseFailed("Attribute Value Not Matched"); 
    } else if (attrVal.equals(attributeValue)) {
      throw new TestCaseFailed("Attribute Value Matched");
    } 
  }
  
  public boolean isElementDisplayed(String accessType, String accessName) {
    this.element = (WebElement)this.wait.until((Function)ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
    return this.element.isDisplayed();
  }
  
  public boolean isElementDisplayed(By accessName) {
	    this.element = (WebElement)this.wait.until((Function)ExpectedConditions.presenceOfElementLocated(accessName));
	    return this.element.isDisplayed();
	  }
  
  public void checkElementPresence(String accessType, String accessName, boolean testCase) throws TestCaseFailed {
    if (testCase) {
      if (!isElementDisplayed(accessType, accessName))
        throw new TestCaseFailed("Element Not Present"); 
    } else {
      try {
        if (isElementDisplayed(accessType, accessName))
          throw new Exception("Present"); 
      } catch (Exception e) {
        if (e.getMessage().equals("Present"))
          throw new TestCaseFailed("Element Present"); 
      } 
    } 
  }
  
  public void isCheckboxChecked(String accessType, String accessName, boolean shouldBeChecked) throws TestCaseFailed {
    WebElement checkbox = (WebElement)this.wait.until((Function)ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
    if (!checkbox.isSelected() && shouldBeChecked)
      throw new TestCaseFailed("Checkbox is not checked"); 
    if (checkbox.isSelected() && !shouldBeChecked)
      throw new TestCaseFailed("Checkbox is checked"); 
  }
  
  public void isRadioButtonSelected(String accessType, String accessName, boolean shouldBeSelected) throws TestCaseFailed {
    WebElement radioButton = (WebElement)this.wait.until((Function)ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
    if (!radioButton.isSelected() && shouldBeSelected)
      throw new TestCaseFailed("Radio Button not selected"); 
    if (radioButton.isSelected() && !shouldBeSelected)
      throw new TestCaseFailed("Radio Button is selected"); 
  }
  
  public void isOptionFromRadioButtonGroupSelected(String accessType, String by, String option, String accessName, boolean shouldBeSelected) throws TestCaseFailed {
    List<WebElement> radioButtonGroup = (List<WebElement>)this.wait.until((Function)ExpectedConditions.presenceOfAllElementsLocatedBy(getelementbytype(accessType, accessName)));
    for (WebElement rb : radioButtonGroup) {
      if (by.equals("value")) {
        if (rb.getAttribute("value").equals(option)) {
          if (!rb.isSelected() && shouldBeSelected)
            throw new TestCaseFailed("Radio Button not selected"); 
          if (rb.isSelected() && !shouldBeSelected)
            throw new TestCaseFailed("Radio Button is selected"); 
        } 
        continue;
      } 
      if (rb.getText().equals(option)) {
        if (!rb.isSelected() && shouldBeSelected)
          throw new TestCaseFailed("Radio Button not selected"); 
        if (rb.isSelected() && !shouldBeSelected)
          throw new TestCaseFailed("Radio Button is selected"); 
      } 
    } 
  }
  
  public String getAlertText() {
    return this.driver.switchTo().alert().getText();
  }
  
  public void checkAlertText(String text) throws TestCaseFailed {
    if (!getAlertText().equals(text))
      throw new TestCaseFailed("Text on alert pop up not matched"); 
  }
  
  public void isOptionFromDropdownSelected(String accessType, String by, String option, String accessName, boolean shouldBeSelected) throws TestCaseFailed {
    Select selectList = null;
    WebElement dropdown = (WebElement)this.wait.until((Function)ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
    selectList = new Select(dropdown);
    String actualValue = "";
    if (by.equals("text")) {
      actualValue = selectList.getFirstSelectedOption().getText();
    } else {
      actualValue = selectList.getFirstSelectedOption().getAttribute("value");
    } 
    if (!actualValue.equals(option) && shouldBeSelected)
      throw new TestCaseFailed("Option Not Selected From Dropwdown"); 
    if (actualValue.equals(option) && !shouldBeSelected)
      throw new TestCaseFailed("Option Selected From Dropwdown"); 
  }
}
