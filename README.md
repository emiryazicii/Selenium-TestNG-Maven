# UI Test Automation🔍🦠🔎

- **Selenium and TestNG**
    - **HTML Fundamentals**
        - **What is Front-end also known as UI (User Interface) composed of?**
            
            H T M L: Hyper Text Markup Language
            
            - CSS: Cascading style sheets
                
                It is used for EXISTING HTML code
                
                CSS can not be used without HTML
                
                CSS is just adding more styling to existing HTML code
                
            - JavaScript
                
                JS gives actual dynamism and functionality to HTML and CSS.
                
        - **What is a web element?**
            1. Everything we see on a web page such as links, buttons, input boxes, images, etc. is a web element.
            2. <h1 style="color:blue"> My header </h1>
                1. **What is a TAG?**     - Tags act like containers in HTML.     - Depending on which tag you choose, HTML will display the content accordingly.
                - How many different types of tags do we have?
                    
                    2 types: Paired (h1, li, ol, ul) and unpaired tags (img)
                    
                - What is an attribute?
                    
                    - Attribute is providing additional information about a web element.     
                    
                    - Attributes go into the OPENING TAG ONLY.     
                    
                    - There can be more than 1 attribute for 1 web element.
                    
    - **What is automation? and How does automating tests help us?**
        
        If there is a repeating process, and we reduce or remove human interruption/interaction, we automate that process.
        
        - Precision,
        
        - Reduce mistakes,
        
        - More accurate, 
        
        - Faster/Save time,
        
        - Save cost,
        
        - Auto-generated reports
        
    - **What is Selenium?**
        
        It is actually just a library (classes and methods)
        
        Selenium can only automate Web-based applications.
        
        - **P.I.Q:** **Why are we using Selenium? What are the Advantages of Selenium?**
            - Open source --> Free which makes it cost-effective for organizations.
            - Supports multiple programming languages Java, Python, C#, Ruby, and JavaScript, offering flexibility for testers.
            - Supports multiple OS (Windows, Mac, Linux)
            - Supports multiple browsers (Chrome, Safari, Firefox, etc..)
            - It has major community support behind it
        - **P.I.Q:** **What are the Disadvantages of Selenium?**
            - Selenium automates Web browsers only, it doesn’t support Computer Desktop Applications.
            - Requires technical knowledge to use like programming skills.
            - No tech support as it is an open-source. For any issues, one has to rely only on community forums to get your technical issues resolved.
            - There is no built-in report coming from the Selenium library, requiring third-party tools or plugins for reporting.
            - Selenium independently does not support image and captcha testing.
    - **What is Maven?**
        
        Maven is a built automation tool.
        
        - **Built?**
            
            repeated steps when creating a project.
            
            - such as creating folders, compiling, deploying, adding libraries(dependencies)
            
            - - Maven projects come with a certain type of folder structure.
                
                -src                     
                
                -main                     
                
                -test                 
                
                -pom.xml
                
            
        - **P.I.Q: Why do you use Maven?**
            - **Dependency Management:** Maven automatically downloads and manages the dependencies in pom.xml file, ensuring that all required libraries are available for your project.
            - **Build Automation:** Maven integrates with Continuous Integration (CI) systems like Jenkins, allowing you to easily set up automated build pipelines.
            - **Test Execution:** Maven integrates seamlessly with testing frameworks like JUnit and TestNG. It can execute your test suites and generate reports on test results, code coverage, and other metrics.
            - **Easy Collaboration:** When working on a team project, Maven enables seamless collaboration. By sharing the project's pom.xml file, team members can quickly set up the necessary dependencies and build the project consistently across different development environments.
            - **Plug-in Ecosystem:** Maven has a vast ecosystem of plugins that extend its functionality. There are numerous plugins available for Selenium that can simplify tasks such as browser management, parallel test execution, and generating test reports.
        - **What is a pom.xml file?**
            
            Maven uses the pom.xml file to manage the project's lifecycle and perform various tasks such as compiling the code, running tests, packaging the project, and resolving dependencies.
            
            ```xml
            <dependencies>
                    <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
                    <dependency>
                        <groupId>org.seleniumhq.selenium</groupId>
                        <artifactId>selenium-java</artifactId>
                        <version>3.141.59</version>
                    </dependency>
            
            //We use it to get all the drivers to our project, find the driver that we need for the webpage, and set up it 
                    <!-- https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager -->
                    <dependency>
                        <groupId>io.github.bonigarcia</groupId>
                        <artifactId>webdrivermanager</artifactId>
                        <version>4.1.0</version>
                    </dependency>
            ```
            
        - **Some more information about Maven Lifecycle**
            
            ```
            maven is a build tool. This the most popular build tool.
            
            Build -> when we create a project and write application code.
            In order to make it available for others to use this application, it needs to be deployed and running in server.
            EX: when we open google.com, it will go to google page.
            It means google application was deployed to server and we as users can access it.
            
            So to reach the deployment level, the maven project needs to go through number of steps.
            Those steps are done using maven, and they are called Maven lifecycle.
            
            validate -> it validates the project that has no errors.
            compile -> compiles java classes.
            test -> runs all the tests in test package
            package -> will run all the tests and also create a jar file for your project. And using that jar file, your maven project can be deployed and can also be shared in mvnrepository
            
            install -> it makes sure all dependencies are downloaded and added and also creates a jar file for your project.
            
            clean -> delete the target folder in the project
            
            At work, when you first get your project, i always run:
            
            mvn clean install -U
            
            -U -> forcefully check each dependency
            
            the above commmand will first delete the target folder.
            checks each dependency
            compiles each java class
            runs all tests
            creates a jar file for your project.
            jar file is like a Zip file. it contains all your classes and packages in same jar file.
            java archive file.
            
            Like a zip lock that has all your jave classes and packages, basically your whole project.
            
            mvn clean install -U Is mainly used for app development projects.
            But we can also use same for automation maven projects.
            
            mvn clean install -U
               and click ENTER
               if mvn is not recognized error appears.
                  MAC -> Command + ENTER
                  Windows -> Control + ENTER
            
            To stop the tests:
               MAC: Command + Q
               Windows: Control + Q
            ```
            
    - **Selenium WebDriver vs. Browser Driver**
        - Selenium WebDriver: - Is actually the name of the tool - Collection of libraries that allows us to automate browsers.
        - Browser Driver (is the translator) - The browser driver does not come in the Selenium library - we need to set it up separately. - If we are using WebDriverManager (BoniGarcia) easily sets up our driver - If we are NOT using WebDriverManager, we have to download our browser drivers separately.
        
        - **P.I.Q:** **If the browser version is changed and your test is failing, how would you fix it?**
            
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            WebDriver driver = new ChromeDriver(options);
            
        - What is the difference between http and https?
            - HTTP is Hypertext Transfer Protocol.
            - HTTPS stands for Hyper Text Transfer Protocol Secure
            - HTTP is less secure as the data can be vulnerable to hackers.
            - HTTPS is designed to prevent hackers from accessing critical information. It is secure against such attacks.
            - HTTP website doesn’t use encryption.
            - HTTPS websites use data encryption.
    - **Basic Navigations**
        
        ```java
        driver.get(url)--> navigates to website
        driver.navigate().to(url)-->navigates to website
        //There is no difference
        
        driver.navigate().back()--> goes back previuos website
        driver.navigate().forward()--> goes forward after goes back
        driver.navigate().refresh()--> refresh the page
        
        ```
        
    - **Selenium Methods:**
        
        ```java
        **click():** It helps to click on web elements on the web page.
        **findElement(Locators):** It helps to locate web elements **** 
        **sendKeys("text"):** I will send text into input fields, text areas, and other elements on a web page
        **getText():** It will return the text of the provided WebElement as a String
        **getAttribute("attributeName"):** It will find the matching "attributeName" and return its value as a String.
        **getTitle():** It returns the title of the current page.
        **getCurrentUrl():** It returns the URL of the current page.
        **close():** It is used to close the current browser window having focus.
        **quit():** If we have more than one opened window/page it will close all of them
        ```
        
    - **Which method do we use to locate one single WebElement in Selenium?**
        
        ```java
        driver.findElement();
        ```
        
        * Single element (findElement"s" for multiple elements)
        - accepts as parameter "Locators"
        - return type of this method: WebElement
        - coming from Selenium Library
        
    - **What are Locators?**
        - Locators are methods coming from the Selenium library that help us locate WebElements.
        - There are 8 locators
        - id, name, linkText, partialLinkText, cssSelector, xpath, tagname, className
        - **id**
            
            it will be always unique and the first locator we are looking for. 
            
            If there is an id attribute available for WebElement we will check if is it **dynamic or not.**
            
            **If it is NOT changing --static-- we will use it.**
            
            ```html
            <button class="btn btn-primary" onclick="button6()" name="button6" id="disappearing_button">Don't click!</button>
            
            WebElement dontClickButton = driver.findElement(By.id("disappearing_button"));
            ```
            
            <aside>
            💡 How to understand ID value is changing(dynamic)?
            
            while we inspect the element and refresh the webpage, if the id values are changing we CANNOT use it. refresh a couple of times always to make sure.
            
            </aside>
            
        - ***name***
            
            if we cannot use id, or it is dynamic we look for the name.
            
            name locator is not dynamic %99.99 time.
            
            `name can be duplicated (radio buttons) so be careful.`
            
            ```java
            WebElement full_nameInput = driver.findElement(By.name("full_name"));
            full_nameInput.sendKeys("Mike Smith");
            
            WebElement emailInput = driver.findElement(By.name("email"));
            emailInput.sendKeys("havva@cybertek.com");
            ```
            
        - ***tagName***
            
            ```java
            <input type="text" name="full_name">
            
            **driver.findElement(By.tagName("input")).sendKeys("Mike Smith");**
            
            input--> tag here
            
            rest is attribute and value
            ```
            
            1. tag should be used only one time
            2. there are multiple of the same tags but you want to point to the first tag.
            
            <aside>
            💡 we cannot use the index when we use the tagName locator.
            
            </aside>
            
            If there are multiple of the same tags, we cannot point to the second one.
            
            - **P.I.Q: How would you get all LINKS on the web page using Selenium?**
                
                ```java
                // 1. Locate all the links on the page. 
                List<WebElement> listOfLinks = driver.findElements(By.tagName("a"));
                
                // 2. Print out the texts of the links.
                for (WebElement each : listOfLinks) {
                System.out.println("Text of links: " + each.getText());
                System.out.println("HREF attributes' values: " + each.getAttribute("href"));
                }
                ```
                
        - ***className***
            
            we use it **to locate multiple elements in one shot.**
            
            <aside>
            💡 when we shouldn't use the className locator? 
            
            if there is a space in the class attribute value, we CANNOT USE it.
            
            </aside>
            
            ```java
            <a class="nav-link" href="/">Home</a>
            
            **WebElement homeLink = driver.findElement(By.className("nav-link"));
                    homeLink.click();**
            ```
            
        - ***linkText & PartialLinkText***
            
            1. Using the full text of the link to locate link WebElement on the webpage
            
            1. Using part of the text of the link to locate the link WebElement
            
            ```java
            1.  WebElement link1 = driver.findElement(By.linkText("Example 4: Element on the page that is rendered after 5 seconds"));
                   link1.click();
            
            2.   WebElement link2 = driver.findElement(By.partialLinkText("Example 1"));
                  link2.click();
            ```
            
        - **XPath**
            
            Xpath allows us to create custom locators using any given attribute and value.
            
            We can also use the text of the web element to create a locator using XPATH.
            
            - There are 2 types of XPATH
                - ABSOLUTE XPATH
                    - Starts with "/" single slash
                    - "/" means start from the root element "html" and go 1 by 1 to the desired web element.
                    - This locator is not stable and will break very easily if there is any minimal change in the html page.
                    - Therefore, it is not recommended to use.
                    
                    /html/body/div[5]/div/div[1]/div/a[2]
                    
                - RELATIVE XPATH
                    - Starts with "//" DOUBLE slash
                    - "//" means jump to the web element provided
                    - Relative xpath is more reliable because we are being very specific compared to "absolute xpath"
                    - -> MAIN SYNTAX
                    
                    //tagName[@attribute='value']
                    
                    - COMMONLY USED XPATH SYNTAXES:
                        - #1. //tagName[@attribute='value']
                            
                            We are saying, get me the web element with the given tagName, where the attribute value is as provided.
                            
                        - #2. //tagName[contains(@attribute, 'value')]
                            
                            Look for the tagName that has a matching or containing attribute value
                            
                        - #3. //*[@attribute='value']
                            
                            - * --> is used when we do not want to search by a tagName.
                            
                            - If we want to be less specific, we pass *, and it will only match and return whatever attribute and value is provided.
                            
                        - #4. //tagName[.='text']    //tagName[text()=’text’]   //*[.=’text’]
                            - This locator will return the web element with the given text.
                            - Works in a similar way to the linkText locator. But linkText only works with links.
                            - Xpath will work with any WebElement.
                            - .  --> stands for text in xpath
                - **P.I.Q: How to locate elements using their sibling in xpath?**
                    - There are two methods for going from sibling to sibling
                    - "/preceding-sibling::" will go to the sibling that comes before
                    - "/following-sibling::" will go to the sibling that comes after
                    - The web element we locate will become the starting point (point 0).
                    - We decide whether we want to go preceding or following sibling.
                    - We count and we pass the index number.
                - **P.I.Q: How can we locate elements using their parent/child in xpath?**
                    - "/" will take us to direct child
                    - //tagName[@attribute='value']/directChildTag
                    - "//" will take us to any child/grandchild
                    - "/..” will take us from child to parent.
                    
                    We do not have to provide a tag name here. It will just take to the parent.
                    
                - **P.I.Q: How can you locate elements using their text in xpath?**
                    - //tagName[text()='text of element’]
                    - //tagName[.='text of element’]
                    - //tagName[contains(text(), ‘text of element’ ) ]
                    - //tagName[normalize-space(text())=‘text of element’] (If there is white spaces in text)
                    
        - CSS: With cssSelector, we can create CUSTOM locators like xpath.
            - There are 2 different syntaxes in cssSelector:
                - SYNTAX #1:
                    
                    tagName[attribute='value']
                    
                    ex: <a href="https://www.tesla.com" id="uh7" name="bb95"> TESLA </a>
                    
                    - locate the above link with cssSelector using id:
                        
                                        a[id='uh7']
                        
                    - NOTE
                        
                        If you want to be less specific, you don't have to pass tagName with this locator.
                        
                        [attribute='value']
                        
                        [id='uh7']
                        
                - SYNTAX #2
                    
                    The second syntax is limited to use with "id" and "class" only.
                    
                    tagName#idValue    tagName.classValue
                    
                    # ---> stands for id attribute    
                    
                    . ---> stands for class attribute
                    
                    ex: <a href="https://www.tesla.com" id="uh7" name="bb95" class="kk99"> TESLA </a>
                    
                    - locate the above link with cssSelector syntax #2 using id and class
                        
                        id —> a#uh7      class —> a.kk99
                        
            - Dynamic Locators
                
                ### The starting part is static
                
                ```java
                <button id="button_three">Button 3</button>
                
                xpath --> //button[starts-with(@id,'button_')]
                css.  --> button[id^='button_']
                ```
                
                ### The ending part is static
                
                ```java
                <button id="quick_button">Button 4</button>
                
                xpath: //button[ends-with(@id,'_button')]
                css:     button[id$='_button']
                ```
                
                ### contains
                
                ```java
                <button id="disappearing_button">Don't click!</button>
                
                xpath --> //button[contains(@id,'ring')] 
                css   --> button[id*='ring']
                ```
                
                <aside>
                💡 ^ --> beginning part is static(starts-with)
                $ --> ending part is static(ends-with)
                * --> contains, looks for any part of the value (contains
                
                </aside>
                
            - **P.I.Q:** How do you handle Dynamic WebElements?
                - 1. I can locate a parent/child that is not dynamic and move from there.
                - 2. I will use the methods provided by;
                
                - xpath: contains(), starts-with(), ends-with()
                
                - cssSelector : contains --> * ,  starts-with --> ^ ,  ends-with --> $
                
        - DIFFERENCE XPATH AND CSS
            
            ***Xpath covers everything that you can do in CSS***
           
    - **Which method do we use for locating the List of WebElements?**
        
        ```java
        driver.findElements();
        ```
        
        To locate multiple elements and interact with them.
        
        1. Find common locators for the elements that you want to locate
        2. pass your locator to findElements() method
        3. List<WebElement> buttons = driver.findElements(Locator)
        
        after this point, buttons keep a list of WebElement, we have to reach them to apply selenium methods either with loop or .get() list method
        
        findElements() method **does not throw** `NoSuchElementException`, if your locator is wrong it will return to an empty list.
        
    - **Radio Buttons**
        
        Radio buttons are a type of element in which only one option can be selected among a group of options (Example: Gender - Male, Female, Other)
        
        Based on the requirements you might or might not have the default option selected.
        
        <aside>
        💡 When we try to interact with disabled elements 2 things can happen:
        
        1. no action will happen and the code will not fail, not complain
        
        2. no action will happen but we can get ElementNotInteractableException: element not interactable
        
  
        
    - **Checkboxes**
        
        Checkboxes are types of input elements that can be selected or unselected.
        
        ```java
        WebElement checkbox1 = driver.findElement(By.xpath("//input[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[2]"));
        
        System.out.println("checkbox1.isSelected() = "+ checkbox1.isSelected();
        System.out.println("checkbox2.isSelected() = "+ checkbox2.isSelected());
        
        ```
            
        - **P.I.Q: How do you handle checkboxes and radio buttons?**
            - First, we locate then we can click.
            - We can check if they are selected or not. --> - isSelected();
            - We can check if they are enabled or not. --> isEnabled();
            - isSelected(); --> If WebElement is selected, it will return true, if not false.
            - isEnabled(); --> If WebElement is enabled, it will return true, if not false.
    - **Dropdown**
        
        The dropdown menu is a menu that offers a list of options. Most of the time we are only allowed to choose one option.
        
        `SELECT`class only works with the WebElement which has a select tag.
        
        - **How to use the SELECT class**
            
            1. make sure the dropdown has the select tag.
            
            2. locate the dropdown just like any other element
            
            3. create an object using the Select class by passing the element that we locate in step 2 in a constructor
            
            ```java
            Select select = new Select(selectWebElement);
            ```
            
            <aside>
            💡 Select class is from Selenium **select tag** is from HTML.
            
            </aside>
            
        - **SELECT methods**
            
            **getOptions()** --> returns all the available options from the dropdown list.
            
            **getFirstSelectedOption()**--> return WebElement, default/current selected option
            
            **selectByVisibleText("text")** --> Selecting based on the visible text of options
            
            **selectByIndex(index number)** --> Select based on index of options(starts from 0)
            
            **selectByValue(option value)** --> Select based on the value of the value attribute
            
        - **NO SELECT DROPDOWN**
            - When we try to use the Select class with the dropdown which does NOT have the select tag, we get `UnexpectedTagNameException`
            - If we don’t have a select tag, we locate the dropdown just like any other WebElements and see options by clicking or hovering over it.
            - To get all options from the dropdown, we can use a common locator between them(exp:classname, tagname, etc)then we can use List methods to get the size and expected options from the list.
            - we use the click() method to click different options, we can either locate the option separately or use the index of the option from the list.
            
        - **P.I.Q: How do you handle Dropdown?**
            
            #1- I would create Select class object
            
            #2- I would locate the <select> dropdown and pass it into the constructor.
            
            #3- Now I can use the Select object with the methods that come from the Select class.
            
            - Syntax: Select select = new Select( finding <select> dropdown web element)
            - There are 3 ways of methods we can select from the Select dropdown;
            
            - selectByIndex --> select based on index of options(starts from 0)
            
            - selectByValue --> Select based on the value of the value attribute
            
            - selectByVisibleText --> Selecting based on the visible text of options
            
            - getOptions() :
            
            - Returns all the available options from the dropdown list.
            
            - Return type: List<WebElement>
            
            - getFirstSelectedOption() :
            
            - Returns WebElement, default/current selected option
            
            - Return type: WebElement
            
    - **TestNG**
        
        TestNG allows us to run, and organize tests, it can do assertions and verification, and generate reports.
        
        - Install TestNG
            
            1.Go to Maven repository
            
            2.get TestNG dependency
            
            3.Reload your maven project
            
        - **@Test**
            
            this is an annotation, it means the method after this @Test is TestNG test method.
            
            we can RUN testng test methods.
            
            we can have multiple @Tests in one class.
            
            if we want to run specific test, right click to test name and run or click run button next to it.
            
            To run all the tests inside the one class, right click run button next to class name or click empty space inside the class and run.
            
        - **@BeforeMethod**
            
            runs once before each method with @Test annotations
            
        - **@AfterMethod**
            
            runs once after each of with @Test annotations
            take screenshot
            
        - **P.I.Q:** **How to ignore some @Test to run?**
            
            **@Ignore** --> we can put on top of the @Test that we want to ignore
            
            OR
            
            we can comment out the **@Test** annotation
            
        - **@BeforeClass**
            
            runs only once before everything in the class
            
        - **@AfterClass**
            
             runs only once after everything in the class
            
        
        <BeforeClass>
        
        <BeforeMethod>test1<afterMethod>
        
        <BeforeMethod>test2<afterMethod>
        
        <BeforeMethod>test3<afterMethod>
        
        <AfterClass>
        
        - **Assertions**
            - Assert --> This is the class in TestNG, it has methods used to do assertions like when we compare values.
            - in TestNG, if the assertion fails, the rest of the method will NOT execute, it will be ignored/skipped.
            - If your code fails in one @Test annotation, it will not affect other @Test s, each working independently.
            - whether your test case fails or not, your before and after method will executed ALWAYS. so even if your code fails, you can quit from the driver, and close the browser.
            - **4 types of assertion**
                1. Assert.assertEquals(actual, expected)--> it checks two value same or not
                2. Assert.assertTrue(condition) --> It checks whether the condition returns true or not then PASS
                3. Assert.assertFalse(condition) --> It verifies condition return is false or not
                4. Assert.assertNotEquals(actual, expected) --> verifies that two values are NOT equal to each other
            - we can add a message to all of our assertions to see what we are checking
            - Assert.assertTrue(condition, message);
            - Assert.assertEquals(actual, expected, message);
        - **P.I.Q: What is the difference between Assert and Verify in automation?**
            - **Assert -**> When an assertion fails, the test fails and stops execution at that point. We can use TestNG default assertions for that. Hard Assertion
            - **Verify** -> When verification fails, the test keeps running till the end, and errors are reported at the end. We can use TestNG **soft assertions** to achieve that.
            
            ```java
            SoftAssert softAssert = new SoftAssert();
            
            softAssert.assertEquals(5, 4);
            ```
            
            - the above verification fails, but the test does not stop.
            - It stops at the end with the following command;
            
            ```java
            softAssert.assertAll();
            ```
            
        - **DataProvider from TestNG**
            
            connection is important
            
            parameter order is important 
            
            - Data Provider DDT
                
                When we have millions of data, the shortcut is using test data
                
                - Test data types
                    - excel file
                    - json,
                    - xml,
                    - csv,
                    - database,
                    - api
                
                Test code/script ----------------test datatest data-->excel file,json,xml,csv,database,api
                
                - **DDT(Data Driven Testing):**
                    
                    we separate test data and test code. 
                    
                    we design our test code in a way that it can read the test data and execute tests base on it. Our test code will have the test steps. Test input data will be in external sources. Our test data will decide how many times a test case runs.
                    
                    same step and same steps for different data
                    
                    it might be not an excel file to be a DDT, we might have static data 
                    
                
                Workbook is the file itself consisting worksheets. We need to mention which worksheets we are gonna work
                
                we use apache-poi dependencies to work with office(excel) files.
                two different version of excel files
                
                - Apache dependency in maven
                    1. <!-- https://mvnrepository.com/artifact/org.apache.poi/poi -->
                    <dependency>
                    <groupId>org.apache.poi</groupId>
                    <artifactId>poi</artifactId>
                    <version>5.0.0</version>
                    </dependency>
                    2. <!-- https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml -->
                    <dependency>
                    <groupId>org.apache.poi</groupId>
                    <artifactId>poi-ooxml</artifactId>
                    <version>5.0.0</version>
                    </dependency>
                    
                - ExcelUtil
                    
                    we need to provide the path of the excel file and the sheet name to read the data 
                    
                    each row is represented by one map, 
                    
        - **XML runner**
            
            what is xml file?
            
            file type used to store and transfer data. It uses html like format, unlike to html it does not have predefined tags.
            
            - Create testng xml runner file
                
                1.Right click on the name of the project
                
                2.New->File
                
                3.Enter name: testng_runner.xml
                
                4.OK
                
            
            ```java
            <!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
            this shows what kind of xml file is this, makes it xml runner for testng
            
            ```
            
            - How to run all test cases, classes inside the in package ?
                
                ```xml
                <!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
                <suite name="Vytrack Automation" verbose="1">
                <test name="Vytrack Smoke Test">
                <packages>
                <package name="com.cybertek.tests.day14_extent_reports"></package>
                </packages>
                </test>
                </suite>
                ```
                
            - How to run multiple package ?
                
                ```xml
                <!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
                <suite name="Vytrack Automation" verbose="1">
                <test name="Vytrack Smoke Test">
                <packages>
                <package name="com.cybertek.tests.day14_extent_reports"></package>
                <package name="com.cybertek.tests.day11_webtables"></package>
                </packages>
                </test>
                </suite>
                ```
                
                <aside>
                💡 Note: xml runner looks for @Test annotationn, if your test case under main method, it will NOT run.
                
                </aside>
                
            - How to run everything(all packages) --BATCH RUN—
                
                ```xml
                <!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
                <suite name="Vytrack Automation" verbose="1">
                <test name="Vytrack Smoke Test">
                <packages>
                <package name=".*"></package>
                </packages>
                </test>
                </suite>
                ```
                
            - How to run specific class?
                
                ```xml
                <!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
                <suite name="Vytrack Automation" verbose="1">
                <test name="Vytrack Smoke Test">
                <classes>
                <class name="com.cybertek.tests.day14_extent_reports.NegativeLoginTestWithReport"></class>
                </classes>
                </test>
                </suite>
                ```
                
                <aside>
                💡 NOTE: verbose is controlling log repors starting from 1, the more you add number it will give more details.
                
                </aside>
                
            - How to run more than one classes (multiple classes)?
                
                ```xml
                <!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
                <suite name="Vytrack Automation" verbose="1">
                <test name="Vytrack Smoke Test">
                <classes>
                <class name="com.cybertek.tests.day14_extent_reports.NegativeLoginTestWithReport"></class>
                <class name="com.cybertek.tests.day13_pom.PageSubtitleTest"></class>
                </classes>
                </test>
                </suite>
                ```
                
            - How to run specific test case from the class ?
                
                ```html
                we use include tags.
                Include method is useful when you have multiple test cases in a class and you only want to run one or a few of them.
                <!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
                <suite name="Vytrack Automation" verbose="1">
                <test name="Vytrack Smoke Test">
                <classes>
                <class name="com.cybertek.tests.day11_webtables.WebTablesExample">
                <methods>
                <include name="printTableSize"></include>
                </methods>
                </class>
                </classes>
                </test>
                </suite>
                ```
                
            - Exclude method
                
                Exclude methods is useful when you want to omit one testcase from class and run rest of the test cases.
                
                ```html
                <!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
                <suite name="Vytrack Automation" verbose="1">
                <test name="Vytrack Smoke Test">
                <classes>
                <class name="com.cybertek.tests.day11_webtables.WebTablesExample">
                <methods>
                <exclude name="getAllCellInOneRow"></exclude>
                </methods>
                </class>
                </classes>
                </test>
                </suite>
                ```
                
    - **Pop-ups**
        
        Popups, alerts, modal, dialog, overlay --> anything pop-ups on the webpage.                      
        
        - **P.I.Q: How to handle pop-ups?**
            
            we have 2 types of pop-ups, based on their structure
            
            - 1. HTML POP-UPS
                
                you can inspect so easy
                
                if the pop-up is from HTML, we deal with it as if it is another web element.
                
                ```java
                @Test
                    public void test1() {
                        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
                
                        //click the Destroy the World button
                        driver.findElement(By.xpath("//button[.='Destroy the World']")).click();
                
                        driver.findElement(By.xpath("//button[.='No']")).click();
                    }
                ```
                
            - 2. JAVASCRIPT ALERTS
                
                blocking the screen
                
                we CAN NOT right-click on those alerts to see HTML(inspect)
                
                - We Handle JS Alerts using the Alert interface from Selenium.
                    
                    Alert alert = driver.switchTo().alert();
                    
                    alert.accept();
                    
                    alert.dismiss();
                    
                    alert.sendKeys("I can send keys here");
                    
                    alert.getText();
                    
            - If there is no alert on the webpage, and we try to switch, **NoAlertPresentException**: no such alert
    - **Frames**
        - Iframe is HTML inside of another HTML.
        - Since selenium can focus on one thing at a time. By default, it will be looking in the main <html> code. If there is any inner <html>/iframe, we have to handle it by locating the iframe and we must explicitly switch to it to be able to do any action in it. Otherwise, Selenium will not be able to see any web element from the inner HTML <iframe>
        - **P.I.Q: How many ways do we have to switch to an iframe?**
            
            ```java
            // 1. index: indexes start from 0.
            driver.switchTo().frame(int index);
            
            // 2. id, name: if there is id or name attribute we can use to locate and switch to iframe.  
            driver.switchTo().frame(String id/name);
            
            // 3. WebElement: we can locate the iframe as a web element and switch to it.
            driver.switchTo().frame(WebElement);
            // or
            driver.switchTo().frame(driver.findElement(By.locator);
            ```
            
        - How to switch back to the parent iframe and main HTML?
            
            ```java
             /* if you have nested frame and if you want to switch 1 frame to
             direct parent of this frame we are using parentFrame() method */
            driver.switchTo().parentFrame();
            
            // defaultContent() method will switch to main HTML (Parent of all HTML)
            driver.switchTo().defaultContent(); 
            
            ```
            
        - NoSuchElementException
            - 1. locator might be wrong(dynamic or not correct)
            - 2. not enough implicitly wait time
            - 3. frame or iframe
    - **Multiple Windows Handle**
        - We use window handles to handle windows.
        
        ```java
        // To get the current windows handle:
        String currentWindow = driver.getWindowHandle();
        
        // To get all of the currently open windows’ handles:
        Set<String> allWindowHandles = driver.getWindowHandles();
        
        for(String each : allWindowHandles) {
        driver.switchTo().window(each);
        }
        ```
        
        ```java
        @Test
            public void moreThan2Window(){
                driver.get("http://practice.cybertekschool.com/windows");
        
                driver.findElement(By.linkText("Click Here")).click();
        
                System.out.println("Before Switch:"+driver.getTitle());
        
                Set<String> windowHandles = driver.getWindowHandles();
        
                //loop through each window
                for (String handle : windowHandles) {
                    //one by one change it
                    driver.switchTo().window(handle);
        
                    //whenever your title equals to your expected window title
        //we need something to verify that we chaned the window, in this example it is title
                    if(driver.getTitle().equals("New Window")){
                        //stop on that window
                        break;
                    }
        				}
                System.out.println("After Switch: "+driver.getTitle());
        		}
        ```
        
    - **Web Table**
        - We write custom locators using xpath or cssSelector to find data in a web table.
        - We start locating from <table> element and we go one by one tr, th, or td to reach the data we want to find.
        - **tr: table row** -> used to create rows inside of the table
        - **th: table header**-> used to create cells, but it will make content bolded and centered
        - **td: table data** -> used to create cells inside of a table
        
        For example;
        
        - //table[@id='table1']//tr -> That returns all of the rows inside of table 1
        - //table[@id='table1']/tbody//tr -> That returns all of the rows inside of body
        - //table[@id='table1']/tbody//tr//td -> returns all of the cells in all of the rows of the body
        - **P.I.Q: How do you handle Dynamic Tables?**
            - We write custom locators using xpath or cssSelector to find data in a web table.
            - We start locating from <table> element and we go one by one tr, th, or td to reach data we want to find.
            - We should stay away from indexing
            - We must find the static/unique part of the data to locate the dynamic part
            - Static data can be an email address, website, phone number, etc…
            - If we need to locate the name of the person in the table, we should start locating the email and we should continue locating the name
            - //table[@id='table1']//td[.='jsmith@gmail.com']/preceding-sibling::td[1]
    - **Is TestBase a utility class?**
        - No, the TestBase class is not a utility class.
        - TestBase is a class where we store and reuse some repeating logic and common variables.
        - We make TestBase abstract because we want to avoid object creation from this class.
        - TestBase is the parent of all other tests we create in a project.
        - If we decide to use TestBase, we would have to extend to TestBase from all the classes we have tests in.
        - If we have a logic that applies all of the tests in our testing suite, we can use TestBase.
    - **File Upload**
        - How to upload file in automation ?
            
            1. Locate the button(choose file) and sendKeys(”path of file”)
            
            2. Click another button(upload) which completes the uploading
            
        - How to get the Path of file ?
            - MAC
                
                1.Right click on the file
                
                2.Hold option key
                
                3.Select option Copy "file.txt" as Pathname
                
            - WINDOWS
                
                1.Hold Shift button
                
                2.Right click on file
                
                3.Copy as Path
                
        - FILE DOWNLOAD
            
            Using selenium we cannot verify the content of the downloaded files. 
            
            we can go to some websites, click on the links to download files using selenium. 
            
            But we cannot verify the content. Using java+other libraries/dependencies we can verify if the file exists and verify the content.
            
    - **Actions**
        
        Actions class is used to do advanced user interactions like 
        
        mouse hover, 
        
        double click, 
        
        drag and drop etc.
        
        Actions class comes from Selenium and is created by passing the WebDriver object as a constructor.
        
        ```css
        //perform() --> perform the action, complete the action
        //moveToElement --> move mouse to WebElement(hover over)
        
        Actions actions = new Actions(Driver.getDriver());
        ```
            
    - **JAVASCRIPT EXECUTOR**
        - What is JavaScriptExecutor?
            - It is a simple interface in Selenium Library.
            
            - The JavaScriptExecutor interface has 2 methods in it.
            
            - These two methods allow us to execute (inject) JavaScript code in our JAVA+SELENIUM code.
            
        - Why do we use JavaScriptExecutor?
            
            - Because JavaScript is a strong web development language.
            
            - Therefore it has many useful functions(methods) in it that we can inject in our JAVA+Selenium code.
            
            - We can enter text using javascript
            
            - we can open empty tabs
            
            - we can scroll the page in multiple different ways
            
        - How do we use JavaScriptExecutor?
            
            1- We downcast our driver type to JavaScriptExecutor type.
            
            2- We can create object of JavaScriptExecutor
            
            3- Call the methods from there.
            
        - **PIQ: How many ways do you know to scroll using Selenium?**
            
            #1- moveToElement using Actions object
            
            #2- PageDown, PageUp keys for scrolling
            
            #3- scroll using JavaScriptExecutor: js.executeScript("window.scrollBy(0, 750)");
            
            #4- OPTION 2 FOR JSEXECUTOR:
            
            js.executeScript("arguments[1].scrollIntoView(true)", cydeoSchoolLink, homeLink);
            
            // it will scrool down until homelink element from arguments[1]
            
    - **Page Object Model Design Pattern**
        - What is Page Object Model Design Pattern?
            
            - Creating java class for each page of the web application we are working on  
            
            - We store relevant webElement, methods into its own java class.
            
        - How do we implement POM Design Pattern?
            
            #1- Every time we create a new java class for each page of the application we need to initialize the browser driver instance and the object of that specific class.
            
            - We need to pass: PageFactory.initElements(driver, this);
            
            #2- Instead of using findElement/s we use @FindBy annotation
            
        - What are the advantages of using Page Object Model Design Pattern?
            
            #1- **Re-usability**        
            
            - We are creating ONE LOCATOR, ONE TIME, in ONE CLASS (in its own page class.)
            
            - We keep re-using the same web Element
            
            #2- **Easy to maintain:**        
            
            - Since we locate each web element only once, when we have issue, we will only go to ONE CLASS to fix it.
            
            #3- **Easy to understand from scratch**         
            
            - It will be very easy to understand/explain everyone in the team       
            
            - We basically create java classes with the functionality or page name
            
    - **Synchronization**
        - Thread.sleep()
            - this method is from java, not selenium. It pauses the program based on given milisecond.
            - It waits for the duration given. be careful not to use too long or to less. It is recommended to minimize the use of thread.sleep using too much slows the execution of tests.
        - Implicitly Wait
            
            ```java
            driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
            ```
            
            - HOW FIND ELEMENT METHODS WORK ?
                - we provide locator and try to find element to do same actions using findElement method
                    - IF element FOUND, it will return WebElement
                    - IF element does NOT FOUND
                        - **a.** it will check do we have implicitly wait set ?
                            - -it will keep trying to find element up to time we set.
                                - 1.if it finds within the time, it will return the element.
                                - 2.if it cannot find up to time we set, it will throw NoSuchElementException
                        - **b.** if there is no implicitly wait set, it will throw `NoSuchElementException`
                    - This waits for elements to be found in HTML, It only works when we call findElement/S method.
                    - As long as findElement method finds the webelement on the html, it does NOT care is it interactible,visible,clickible or not. it will return the element. So implicilty wait will not solve our elementNotInteractible problems.
        - Explicitly wait
            
            Sometimes we might locate the element but we cannot interact with it within certain time. We have to wait until it is visible, clickable, enabled, has certain text or disappear.
            
            when we have to wait for these cases, we will use explicit wait.
            
            ```java
            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.elementToBeClickable(inputBox));
            ```
            
            <aside>
            💡 ExpectedConditions-->contains conditions for wait that we can wait using WebDriverWait
            
            </aside>
            
            <aside>
            💡 Explicit wait waits for the condition to complete, once the condition is met, it will stop waiting(dynamic) . if the condition is not met and the time runs out we got TimeoutException
            
            </aside>
            
        - FluentWait
            - Similar to WebDriverWait
            - It waits UP TO given duration and continues if condition happens earlier.
            - We have the ability to change POLLING TIME.
            - By default, POLLING TIME is 2 times a sec (every 500 millisecond)
            - But we can change this to once a second, once every 5 second ETC.
            - Waiting 30 seconds for an element to be present on the page, checking for its presence once every 5 seconds.
            
            ```java
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .withTimeout(Duration.ofSeconds(30))
            .pollingEvery(Duration.ofSeconds(5))
            .ignoring(NoSuchElementException.class);
            
            WebElement foo = wait.until(new Function<WebDriver, WebElement>(){
            public WebElement apply(WebDriver driver){
            return driver.findElement([By.id](http://by.id/)("foo"));
            }});
            ```
            
        - **P.I.Q:** `What is the difference between Implicit wait and explicit wait?`
            
            -> Implicit wait time is set once globally and applies to all steps.
            -> Explicit wait is applied to a specific element on the page
            
            -> Implicit wait works with findElement method and waits until element is present in html/dom (document object model)
            -> Explicit wait can be applied with different conditions that are available in ExpectedConditions class
            
            -> Implicit wait stops waiting as soon as element is found in the html/dom
            -> Explicit wait stops waiting when certain condition is met like visibility of elem. or enable of elem etc
            
            -> Implicit wait throws **NoSuchElementException** if element does't appear in html/dom during the timeout
            -> Explicit wait throws **TimeOutException** if condition is not met within the specified seconds
            
        
        [WAITS ](https://www.notion.so/cb6a05aa6776438c81699c81222fa536?pvs=21)
