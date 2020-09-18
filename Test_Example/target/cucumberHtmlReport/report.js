$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/my_first.feature");
formatter.feature({
  "line": 2,
  "name": "to check weather comparision",
  "description": "",
  "id": "to-check-weather-comparision",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Weather1"
    }
  ]
});
formatter.scenarioOutline({
  "line": 3,
  "name": "I login with valid credential",
  "description": "",
  "id": "to-check-weather-comparision;i-login-with-valid-credential",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "I navigate to \"\u003cURL\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I click on subMenu options",
  "keyword": "Then "
});
formatter.step({
  "line": 6,
  "name": "I click on weather tab",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "I enter \"\u003ccity\u003e\" into input searchBox field",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "Entered \"\u003ccity\u003e\" should be present",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "I check the checkbox having \"\u003ccity\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "I store the temperature for \"\u003ccity\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "I need to call weatehr API endpoint \"\u003cAPI_URL\u003e\" with city \"\u003ccity\u003e\" and appid \"\u003cappid\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "I need to compare the temperature with variance of \"\u003cvariance\u003e\" degree",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "I take screenshot",
  "keyword": "Then "
});
formatter.examples({
  "line": 15,
  "name": "",
  "description": "",
  "id": "to-check-weather-comparision;i-login-with-valid-credential;",
  "rows": [
    {
      "cells": [
        "URL",
        "city",
        "API_URL",
        "appid",
        "variance"
      ],
      "line": 17,
      "id": "to-check-weather-comparision;i-login-with-valid-credential;;1"
    },
    {
      "cells": [
        "https://www.ndtv.com/.",
        "Bhopal",
        "api.openweathermap.org/data/2.5/weather",
        "7fe67bf08c80ded756e598d6f8fedaea",
        "2"
      ],
      "line": 18,
      "id": "to-check-weather-comparision;i-login-with-valid-credential;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 18,
  "name": "I login with valid credential",
  "description": "",
  "id": "to-check-weather-comparision;i-login-with-valid-credential;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@Weather1"
    }
  ]
});
formatter.step({
  "line": 4,
  "name": "I navigate to \"https://www.ndtv.com/.\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I click on subMenu options",
  "keyword": "Then "
});
formatter.step({
  "line": 6,
  "name": "I click on weather tab",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "I enter \"Bhopal\" into input searchBox field",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "Entered \"Bhopal\" should be present",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "I check the checkbox having \"Bhopal\"",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "I store the temperature for \"Bhopal\"",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "I need to call weatehr API endpoint \"api.openweathermap.org/data/2.5/weather\" with city \"Bhopal\" and appid \"7fe67bf08c80ded756e598d6f8fedaea\"",
  "matchedColumns": [
    1,
    2,
    3
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "I need to compare the temperature with variance of \"2\" degree",
  "matchedColumns": [
    4
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "I take screenshot",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "https://www.ndtv.com/.",
      "offset": 15
    }
  ],
  "location": "PredefinedStepDefinitions.navigate_to(String)"
});
formatter.result({
  "duration": 18488164300,
  "status": "passed"
});
formatter.match({
  "location": "NDTVSteps.i_click_on_subMenu_options()"
});
formatter.result({
  "duration": 250621454,
  "status": "passed"
});
formatter.match({
  "location": "NDTVSteps.i_click_on_weather_tab()"
});
formatter.result({
  "duration": 440737594,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Bhopal",
      "offset": 9
    }
  ],
  "location": "NDTVSteps.i_enter_into_input_searchBox_field(String)"
});
formatter.result({
  "duration": 1818702413,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Bhopal",
      "offset": 9
    }
  ],
  "location": "NDTVSteps.entered_should_be_present(String)"
});
formatter.result({
  "duration": 52215052,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Bhopal",
      "offset": 29
    }
  ],
  "location": "NDTVSteps.i_check_the_checkbox_having(String)"
});
formatter.result({
  "duration": 85461474,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Bhopal",
      "offset": 29
    }
  ],
  "location": "NDTVSteps.i_store_the_temperature(String)"
});
formatter.result({
  "duration": 683030138,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "api.openweathermap.org/data/2.5/weather",
      "offset": 37
    },
    {
      "val": "Bhopal",
      "offset": 89
    },
    {
      "val": "7fe67bf08c80ded756e598d6f8fedaea",
      "offset": 108
    }
  ],
  "location": "NDTVSteps.i_need_to_call_weatehr_API_endpoint_with_city_and_appid(String,String,String)"
});
formatter.result({
  "duration": 2276798009,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 52
    }
  ],
  "location": "NDTVSteps.i_need_to_compare_the_temperature_with_variance_of_degree(String)"
});
formatter.result({
  "duration": 238480,
  "status": "passed"
});
formatter.match({
  "location": "PredefinedStepDefinitions.take_screenshot()"
});
formatter.result({
  "duration": 2803849398,
  "status": "passed"
});
formatter.scenario({
  "line": 20,
  "name": "Close browser",
  "description": "",
  "id": "to-check-weather-comparision;close-browser",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 21,
  "name": "I close browser",
  "keyword": "Then "
});
formatter.match({
  "location": "PredefinedStepDefinitions.close_browser()"
});
formatter.result({
  "duration": 121511126,
  "status": "passed"
});
});