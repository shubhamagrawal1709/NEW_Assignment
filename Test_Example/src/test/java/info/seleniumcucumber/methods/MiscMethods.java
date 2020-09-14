package info.seleniumcucumber.methods;

import java.util.Arrays;

public class MiscMethods {
  public boolean valid_locator_type(String type) {
    return Arrays.<String>asList(new String[] { "id", "class", "css", "name", "xpath" }).contains(type);
  }
  
  public void validateLocator(String type) throws Exception {
    if (!valid_locator_type(type))
      throw new Exception("Invalid locator type - " + type); 
  }
  
  public boolean valid_option_by(String option_by) {
    return Arrays.<String>asList(new String[] { "text", "value", "index" }).contains(option_by);
  }
  
  public void validateOptionBy(String optionBy) throws Exception {
    if (!valid_option_by(optionBy))
      throw new Exception("Invalid option by - " + optionBy); 
  }
}
