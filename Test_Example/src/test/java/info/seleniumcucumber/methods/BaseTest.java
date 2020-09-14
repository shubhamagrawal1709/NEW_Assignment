package info.seleniumcucumber.methods;

public interface BaseTest {
  public static final MiscMethods miscmethodObj = new MiscMethods();
  
  public static final NavigateMethods navigationObj = new NavigateMethods();
  
  public static final AssertionMethods assertionObj = new AssertionMethods();
  
  public static final ClickElementsMethods clickObj = new ClickElementsMethods();
  
  public static final ConfigurationMethods configObj = new ConfigurationMethods();
  
  public static final InputMethods inputObj = new InputMethods();
  
  public static final ProgressMethods progressObj = new ProgressMethods();
  
  public static final JavascriptHandlingMethods javascriptObj = new JavascriptHandlingMethods();
  
  public static final ScreenShotMethods screenshotObj = new ScreenShotMethods();
}
