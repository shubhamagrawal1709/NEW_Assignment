package info.seleniumcucumber.stepdefinitions;

import cucumber.api.java.en.Then;
import env.DriverUtil;
import info.seleniumcucumber.methods.BaseTest;
import info.seleniumcucumber.methods.TestCaseFailed;
import java.io.IOException;
import org.openqa.selenium.WebDriver;

public class PredefinedStepDefinitions implements BaseTest {
  protected WebDriver driver = DriverUtil.getDefaultDriver();
  
  @Then("^I navigate to \"([^\"]*)\"$")
  public void navigate_to(String link) {
    navigationObj.navigateTo(link);
  }
  
  @Then("^I navigate forward")
  public void navigate_forward() {
    navigationObj.navigate("forward");
  }
  
  @Then("^I navigate back")
  public void navigate_back() {
    navigationObj.navigate("back");
  }
  
  @Then("^I refresh page$")
  public void refresh_page() {
    this.driver.navigate().refresh();
  }
  
  @Then("^I switch to new window$")
  public void switch_to_new_window() {
    navigationObj.switchToNewWindow();
  }
  
  @Then("^I switch to previous window$")
  public void switch_to_old_window() {
    navigationObj.switchToOldWindow();
  }
  
  @Then("^I switch to window having title \"(.*?)\"$")
  public void switch_to_window_by_title(String windowTitle) throws Exception {
    navigationObj.switchToWindowByTitle(windowTitle);
  }
  
  @Then("^I close new window$")
  public void close_new_window() {
    navigationObj.closeNewWindow();
  }
  
  @Then("^I switch to frame having (.+) \"(.*?)\"$")
  public void switch_frame_by_element(String method, String value) {
    navigationObj.switchFrame(method, value);
  }
  
  @Then("^I switch to main content$")
  public void switch_to_default_content() {
    navigationObj.switchToDefaultContent();
  }
  
  @Then("^I resize browser window size to width (\\d+) and height (\\d+)$")
  public void resize_browser(int width, int heigth) {
    navigationObj.resizeBrowser(width, heigth);
  }
  
  @Then("^I maximize browser window$")
  public void maximize_browser() {
    navigationObj.maximizeBrowser();
  }
  
  @Then("^I close browser$")
  public void close_browser() {
    navigationObj.closeDriver();
  }
  
  @Then("^I zoom in page$")
  public void zoom_in() {
    navigationObj.zoomInOut("ADD");
  }
  
  @Then("^I zoom out page$")
  public void zoom_out() {
    navigationObj.zoomInOut("SUBTRACT");
  }
  
  @Then("^I zoom out page till I see element having (.+) \"(.*?)\"$")
  public void zoom_till_element_display(String type, String accessName) throws Exception {
    miscmethodObj.validateLocator(type);
    navigationObj.zoomInOutTillElementDisplay(type, "substract", accessName);
  }
  
  @Then("^I reset page view$")
  public void reset_page_zoom() {
    navigationObj.zoomInOut("reset");
  }
  
  @Then("^I scroll to (top|end) of page$")
  public void scroll_page(String to) throws Exception {
    navigationObj.scrollPage(to);
  }
  
  @Then("^I scroll to element having (.+) \"(.*?)\"$")
  public void scroll_to_element(String type, String accessName) throws Exception {
    miscmethodObj.validateLocator(type);
    navigationObj.scrollToElement(type, accessName);
  }
  
  @Then("^I hover over element having (.+) \"(.*?)\"$")
  public void hover_over_element(String type, String accessName) throws Exception {
    miscmethodObj.validateLocator(type);
    navigationObj.hoverOverElement(type, accessName);
  }
  
  @Then("^I should\\s*((?:not)?)\\s+see page title as \"(.+)\"$")
  public void check_title(String present, String title) throws TestCaseFailed {
    assertionObj.checkTitle(title, present.isEmpty());
  }
  
  @Then("^I should\\s*((?:not)?)\\s+see page title having partial text as \"(.*?)\"$")
  public void check_partial_text(String present, String partialTextTitle) throws TestCaseFailed {
    assertionObj.checkPartialTitle(partialTextTitle, present.isEmpty());
  }
  
  @Then("^element having (.+) \"([^\"]*)\" should\\s*((?:not)?)\\s+have text as \"(.*?)\"$")
  public void check_element_text(String type, String accessName, String present, String value) throws Exception {
    miscmethodObj.validateLocator(type);
    assertionObj.checkElementText(type, value, accessName, present.isEmpty());
  }
  
  @Then("^element having (.+) \"([^\"]*)\" should\\s*((?:not)?)\\s+have partial text as \"(.*?)\"$")
  public void check_element_partial_text(String type, String accessName, String present, String value) throws Exception {
    miscmethodObj.validateLocator(type);
    assertionObj.checkElementPartialText(type, value, accessName, present.isEmpty());
  }
  
  @Then("^element having (.+) \"([^\"]*)\" should\\s*((?:not)?)\\s+have attribute \"(.*?)\" with value \"(.*?)\"$")
  public void check_element_attribute(String type, String accessName, String present, String attrb, String value) throws Exception {
    miscmethodObj.validateLocator(type);
    assertionObj.checkElementAttribute(type, attrb, value, accessName, present.isEmpty());
  }
  
  @Then("^element having (.+) \"([^\"]*)\" should\\s*((?:not)?)\\s+be (enabled|disabled)$")
  public void check_element_enable(String type, String accessName, String present, String state) throws Exception {
    miscmethodObj.validateLocator(type);
    boolean flag = state.equals("enabled");
    if (!present.isEmpty())
      flag = !flag; 
    assertionObj.checkElementEnable(type, accessName, flag);
  }
  
  @Then("^element having (.+) \"(.*?)\" should\\s*((?:not)?)\\s+be present$")
  public void check_element_presence(String type, String accessName, String present) throws Exception {
    miscmethodObj.validateLocator(type);
    assertionObj.checkElementPresence(type, accessName, present.isEmpty());
  }
  
  @Then("^checkbox having (.+) \"(.*?)\" should be (checked|unchecked)$")
  public void is_checkbox_checked(String type, String accessName, String state) throws Exception {
    miscmethodObj.validateLocator(type);
    boolean flag = state.equals("checked");
    assertionObj.isCheckboxChecked(type, accessName, flag);
  }
  
  @Then("^radio button having (.+) \"(.*?)\" should be (selected|unselected)$")
  public void is_radio_button_selected(String type, String accessName, String state) throws Exception {
    miscmethodObj.validateLocator(type);
    boolean flag = state.equals("selected");
    assertionObj.isRadioButtonSelected(type, accessName, flag);
  }
  
  @Then("^option \"(.*?)\" by (.+) from radio button group having (.+) \"(.*?)\" should be (selected|unselected)$")
  public void is_option_from_radio_button_group_selected(String option, String attrb, String type, String accessName, String state) throws Exception {
    miscmethodObj.validateLocator(type);
    boolean flag = state.equals("selected");
    assertionObj.isOptionFromRadioButtonGroupSelected(type, attrb, option, accessName, flag);
  }
  
  @Then("^link having text \"(.*?)\" should\\s*((?:not)?)\\s+be present$")
  public void check_element_presence(String accessName, String present) throws TestCaseFailed, Exception {
    assertionObj.checkElementPresence("linkText", accessName, present.isEmpty());
  }
  
  @Then("^link having partial text \"(.*?)\" should\\s*((?:not)?)\\s+be present$")
  public void check_partial_element_presence(String accessName, String present) throws TestCaseFailed, Exception {
    assertionObj.checkElementPresence("partialLinkText", accessName, present.isEmpty());
  }
  
  @Then("^I should see alert text as \"(.*?)\"$")
  public void check_alert_text(String actualValue) throws TestCaseFailed {
    assertionObj.checkAlertText(actualValue);
  }
  
  @Then("^option \"(.*?)\" by (.+) from dropdown having (.+) \"(.*?)\" should be (selected|unselected)$")
  public void is_option_from_dropdown_selected(String option, String by, String type, String accessName, String state) throws Exception {
    miscmethodObj.validateLocator(type);
    boolean flag = state.equals("selected");
    assertionObj.isOptionFromDropdownSelected(type, by, option, accessName, flag);
  }
  
  @Then("^I enter \"([^\"]*)\" into input field having (.+) \"([^\"]*)\"$")
  public void enter_text(String text, String type, String accessName) throws Exception {
    miscmethodObj.validateLocator(type);
    inputObj.enterText(type, text, accessName);
  }
  
  @Then("^I clear input field having (.+) \"([^\"]*)\"$")
  public void clear_text(String type, String accessName) throws Exception {
    miscmethodObj.validateLocator(type);
    inputObj.clearText(type, accessName);
  }
  
  @Then("^I select \"(.*?)\" option by (.+) from dropdown having (.+) \"(.*?)\"$")
  public void select_option_from_dropdown(String option, String optionBy, String type, String accessName) throws Exception {
    miscmethodObj.validateLocator(type);
    miscmethodObj.validateOptionBy(optionBy);
    inputObj.selectOptionFromDropdown(type, optionBy, option, accessName);
  }
  
  @Then("^I select (\\d+) option by index from dropdown having (.+) \"(.*?)\"$")
  public void select_option_from_dropdown_by_index(String option, String type, String accessName) throws Exception {
    miscmethodObj.validateLocator(type);
    inputObj.selectOptionFromDropdown(type, "selectByIndex", option, accessName);
  }
  
  @Then("^I select \"(.*?)\" option by (.+) from multiselect dropdown having (.+) \"(.*?)\"$")
  public void select_option_from_multiselect_dropdown(String option, String optionBy, String type, String accessName) throws Exception {
    miscmethodObj.validateLocator(type);
    miscmethodObj.validateOptionBy(optionBy);
    inputObj.selectOptionFromDropdown(type, optionBy, option, accessName);
  }
  
  @Then("^I select (\\d+) option by index from multiselect dropdown having (.+) \"(.*?)\"$")
  public void select_option_from_multiselect_dropdown_by_index(String option, String type, String accessName) throws Exception {
    miscmethodObj.validateLocator(type);
    inputObj.selectOptionFromDropdown(type, "selectByIndex", option, accessName);
  }
  
  @Then("^I deselect \"(.*?)\" option by (.+) from multiselect dropdown having (.+) \"(.*?)\"$")
  public void deselect_option_from_multiselect_dropdown(String option, String optionBy, String type, String accessName) throws Exception {
    miscmethodObj.validateLocator(type);
    miscmethodObj.validateOptionBy(optionBy);
    inputObj.deselectOptionFromDropdown(type, optionBy, option, accessName);
  }
  
  @Then("^I deselect (\\d+) option by index from multiselect dropdown having (.+) \"(.*?)\"$")
  public void deselect_option_from_multiselect_dropdown_by_index(String option, String type, String accessName) throws Exception {
    miscmethodObj.validateLocator(type);
    inputObj.deselectOptionFromDropdown(type, "selectByIndex", option, accessName);
  }
  
  @Then("^I deselect all options from multiselect dropdown having (.+) \"(.*?)\"$")
  public void unselect_all_option_from_multiselect_dropdown(String type, String accessName) throws Exception {
    miscmethodObj.validateLocator(type);
    inputObj.unselectAllOptionFromMultiselectDropdown(type, accessName);
  }
  
  @Then("^I check the checkbox having (.+) \"(.*?)\"$")
  public void check_checkbox(String type, String accessName) throws Exception {
    miscmethodObj.validateLocator(type);
    inputObj.checkCheckbox(type, accessName);
  }
  
  @Then("^I uncheck the checkbox having (.+) \"(.*?)\"$")
  public void uncheck_checkbox(String type, String accessName) throws Exception {
    miscmethodObj.validateLocator(type);
    inputObj.uncheckCheckbox(type, accessName);
  }
  
  @Then("^I toggle checkbox having (.+) \"(.*?)\"$")
  public void toggle_checkbox(String type, String accessName) throws Exception {
    miscmethodObj.validateLocator(type);
    inputObj.toggleCheckbox(type, accessName);
  }
  
  @Then("^I select radio button having (.+) \"(.*?)\"$")
  public void select_radio_button(String type, String accessName) throws Exception {
    miscmethodObj.validateLocator(type);
    inputObj.selectRadioButton(type, accessName);
  }
  
  @Then("^I select \"(.*?)\" option by (.+) from radio button group having (.+) \"(.*?)\"$")
  public void select_option_from_radio_btn_group(String option, String by, String type, String accessName) throws Exception {
    miscmethodObj.validateLocator(type);
    inputObj.selectOptionFromRadioButtonGroup(type, option, by, accessName);
  }
  
  @Then("^I click on element having (.+) \"(.*?)\"$")
  public void click(String type, String accessName) throws Exception {
    miscmethodObj.validateLocator(type);
    clickObj.click(type, accessName);
  }
  
  @Then("^I forcefully click on element having (.+) \"(.*?)\"$")
  public void click_forcefully(String type, String accessName) throws Exception {
    miscmethodObj.validateLocator(type);
    clickObj.clickForcefully(type, accessName);
  }
  
  @Then("^I double click on element having (.+) \"(.*?)\"$")
  public void double_click(String type, String accessValue) throws Exception {
    miscmethodObj.validateLocator(type);
    clickObj.doubleClick(type, accessValue);
  }
  
  @Then("^I click on link having text \"(.*?)\"$")
  public void click_link(String accessName) {
    clickObj.click("linkText", accessName);
  }
  
  @Then("^I click on link having partial text \"(.*?)\"$")
  public void click_partial_link(String accessName) {
    clickObj.click("partialLinkText", accessName);
  }
  
  @Then("^I wait for (\\d+) sec$")
  public void wait(String time) throws NumberFormatException, InterruptedException {
    progressObj.wait(time);
  }
  
  @Then("^I wait (\\d+) seconds for element having (.+) \"(.*?)\" to display$")
  public void wait_for_ele_to_display(String duration, String type, String accessName) throws Exception {
    miscmethodObj.validateLocator(type);
    progressObj.waitForElementToDisplay(type, accessName, duration);
  }
  
  @Then("^I wait (\\d+) seconds for element having (.+) \"(.*?)\" to be enabled$")
  public void wait_for_ele_to_click(String duration, String type, String accessName) throws Exception {
    miscmethodObj.validateLocator(type);
    progressObj.waitForElementToClick(type, accessName, duration);
  }
  
  @Then("^I accept alert$")
  public void handle_alert() {
    javascriptObj.handleAlert("accept");
  }
  
  @Then("^I dismiss alert$")
  public void dismiss_alert() {
    javascriptObj.handleAlert("dismiss");
  }
  
  @Then("^I take screenshot$")
  public void take_screenshot() throws IOException {
    screenshotObj.takeScreenShot();
  }
  
  @Then("^I print configuration$")
  public void print_config() {
    configObj.printDesktopConfiguration();
  }
}
