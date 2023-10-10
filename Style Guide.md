## General Styling Guide

- Packages should be all lowercase ASCII letters.
- Classes and Interfaces should follow a mixed case (aka "camel case"), with each subsequent word's first letter
  capitalized
    - e.g. `class TestClass`
- Methods should be verbs, and should follow a mixed case (aka "camel case") pattern, with the first letter of the
  first word in lower case.
    - e.g. `void testMethod()`
    - Braces follow the Kernighan and Ritchie style ("Egyptian brackets") for nonempty blocks and block-like constructs:
    - Dont wrap a line just for the sake of not going past the 100 character marker, especially if wrapping makes it harder to read.
    - Variables should have meaningful names, even in lambdas. There's no shortage of space, so write readable, self-documenting code.
      - Single character variable names or similar are not permitted. 
    - Example:
    ```java
    public String getReturnedResponse(Request request) {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        String returnedResponse = null;
        try (Response response = client.newCall(request).execute()) {
            if (response.body() != null) {
                returnedResponse = response.body().string();
            } else {
                throw new RuntimeException("Body of returned response is null.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return returnedResponse;
    }
    ``` 
    - Variables are similar to methods, in that they should follow a mixed case (aka "camel case") patter, with a
      lowercase first letter.
    - Constants should be all uppercase, with underscores replacing spaces.
        - e.g. `int MAX_RETRY_COUNT = 5;`

## Coding Standards

### Testing

- Methods and Features are to have adequate unit and integration tests written before any pull request can be accepted.
- Methods such as setters and getters are to have atleast one negative and one standard unit test.
- Unit test count is to scale appropriately according to the complexity of the method.
- Features are to have appropriate integration and end to end tests.
- Fixes are to have appropriate unit, integration and end to end tests included with the fix for the sake of regression
  testing.
- Tests should only test one thing
    - e.g. `Set store location with zip code.`
    - e.g. `Fail to set store location using invalid zip code`
    - e.g. `Set store location by city name`
- Selenium code should use the Page Object Model making each page a class
    - Use inheritance to pull in common variables and methods for your product
    - The top of the class should contain web elements
    - Inside the class should contain methods that do one thing with JavaDoc
    - e.g.
  ```java
      /**
       * method triggers click event on New Setting selection to access the Edit Setting Definition
       * pop-up window
       * @return returns new instance of inner class clickNewSetting in order to select OK and
       * cancel buttons in this pop-up window
       */
      def clickNewSetting() {
          newSettingElement.click()
          return new clickNewSetting(driver)
      }

      /**
       * Inner Class provides methods to select OK or Cancel in the Edit Setting Definition pop-up window
       */
      private class clickNewSetting extends CreateConnectorSharedTabs.newSetting<clickNewSetting> {
          private @FindBy(id = 'saveButton')              WebElement editSettingOkButton
          private @FindBy(id = 'cancelButton')            WebElement editSettingCancelButton

          clickNewSetting(WebDriver driver) {
              super(driver)
          }

          /**
           * method triggers click event on OK button
           * @return returns instance of main Desktop tab
           */
          def clickOK() {
              editSettingOkButton.click()
              log.info("Clicked Edit Setting Definition OK button")
              return new openDesktopTab(driver)
          }

          /**
           * method triggers click event on Cancel button
           * @return returns instance of main Desktop tab
           */
          def clickCancel() {
              editSettingCancelButton.click()
              log.info("Clicked Edit Setting Definition Cancel button")
              return new openDesktopTab(driver)
          }
      }
  ```

- Selenium Web Programs
    - Tests should be made up of methods, and logic (such as loops) should be in a utils class
    - Each test class should inherit from either a UI base test or a REST base test
    - A test should never call another test.
    - Helper methods should go in a utils class (when possible the Util should be a java class)
    - e.g. Web Test
  ```java
    @Test
    void changeStoreLocation(){
        new StoreLogin()
          .clickStoreBanner()
          .addNextZipCode()
          .clickSubmit
    }
  ```