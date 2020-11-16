package SeleniumTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InputForm {
    WebDriver driver;
    WebDriverWait wait;

    //test_1
    By inputFormOptionBy = By.xpath("//a[text()='Input Forms']");
    By waitSimpleFormDemoBy = By.xpath("//li[@class='tree-branch']//a[text()='Simple Form Demo']");
    By singleInputFieldBy = By.xpath("//input[@id='user-message']");
    By buttonShowMessageBy = By.xpath("//button[text()='Show Message']");
    By actualResultBy = By.xpath("//span[@id='display']");

    //test_2
    By actualResult1By =By.xpath("//span[@id='displayvalue']");

    //tst_3
    By waitCheckBoxDemoBy = By.xpath("//li[@class='tree-branch']//a[text()='Checkbox Demo']");
    By checkBoxOption1By = By.xpath("//label[text()='Option 1']//input");
    By checkBoxOption3By = By.xpath("//label[text()='Option 3']//input");

    //test_4
    By waitRadiobuttonDemoBy = By.xpath("//li[@class='tree-branch']//a[text()='Radio Buttons Demo']");
    By radioButtonSexMaleBy = By.xpath("//label[text()='Male']");
    By radioButtonAgeGroupBy = By.xpath("//label[text()='15 to 50']");
    By buttonGetValuesBy = By.xpath("//button[text()='Get values']");
    By actualRes5By =  By.xpath("//p[@class='groupradiobutton']");

    //test_5
    By waitSelectDropdownListBy = By.xpath("//li[@class='tree-branch']//a[text()='Select Dropdown List']");
    By selectListDemoOptionFridayBy = By.xpath("//select[@id='select-demo']//option[@value='Friday']");
    By actualRes6By = By.xpath("//p[text()='Day selected :- Friday']");

    //test_6
    By multiSelectListDemoFloridaBy = By.xpath("//select[@id='multi-select']//option[text()='Florida']");
    By multiSelectListDemoNewYorkBy = By.xpath("//select[@id='multi-select']//option[text()='New York']");
    By buttonGetAllSelectedBy = By.xpath("//button[@id='printAll']");

    //test_7
    By waitAjaxFormSubmitBy = By.xpath("//li[@class='tree-branch']//a[text()='Ajax Form Submit']");
    By clickSubmitButtonBy = By.xpath("//input[@id='btn-submit']");
    By actRes8By = By.xpath("//input[@id='title']");

    //test_8
    By datePickersBy = By.xpath("//a[text()='Date pickers']");
    By waitBootstrapDatePickerBy = By.xpath("//li[@class='tree-branch']//a[text()='Bootstrap Date Picker']");
    By chooseDateBy = By.xpath("//div[@id='sandbox-container1']//span[@class='input-group-addon']");

    //test_9
    By optionTableBy = By.xpath("//li[@class='tree-branch']//a[text()='Table']");
    By optionTableDataSearchBy = By.xpath("//li[@class='tree-branch']//a[text()='Table Data Search']");
    By taskTableFilterBy = By.xpath("//input[@id='task-table-filter']");
    By taskTableBy = By.xpath("//table[@id='task-table']");


    //test_10
    By optionTable1By = By.xpath("//li[@class='tree-branch']//a[text()='Table']");
    By optionTableFilterBy = By.xpath("//li[@class='tree-branch']//a[text()='Table Filter ']");
    By buttonOrangeBy = By.xpath("//button[text()='Orange']");



    @Before
    public void beforeEachTest(){
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 5);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='at-cv-lightbox-close']"))).click();
    }


    @Test
    public void test_1() {
        String userMessage = "Hello, my name is";

        WebElement inputFormOption = driver.findElement(inputFormOptionBy);
        inputFormOption.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(waitSimpleFormDemoBy)).click();
        WebElement singleInputField = driver.findElement(singleInputFieldBy);
        singleInputField.sendKeys("Hello, my name is");
        WebElement buttonShowMessage = driver.findElement(buttonShowMessageBy);
        buttonShowMessage.click();

        String actualResult = driver.findElement(actualResultBy).getText();

        Assert.assertEquals(userMessage,actualResult);
    }

    @Test
    public void test_2(){
        String displayValue = "202";

        WebElement inputFormOption = driver.findElement(inputFormOptionBy);
        inputFormOption.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(waitSimpleFormDemoBy)).click();
        WebElement fieldEnterValueA = driver.findElement(By.xpath("//input[@id='sum1']"));
        fieldEnterValueA.sendKeys("200");
        WebElement fieldEnterValueB = driver.findElement(By.xpath("//input[@id='sum2']"));
        fieldEnterValueB.sendKeys("2");
        WebElement buttonGetTotal = driver.findElement(By.xpath("//button[text()='Get Total']"));
        buttonGetTotal.click();

        String actualResult1 = driver.findElement(actualResult1By).getText();

        Assert.assertEquals(displayValue, actualResult1);
    }

    @Test
    public void test_3(){
        boolean checkBoxesAreSelected = true;

        WebElement inputFormOption = driver.findElement(inputFormOptionBy);
        inputFormOption.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(waitCheckBoxDemoBy)).click();
        WebElement checkBoxOption1 = driver.findElement(checkBoxOption1By);
        checkBoxOption1.click();
        WebElement checkBoxOption3 = driver.findElement(checkBoxOption3By);
        checkBoxOption3.click();

        boolean actualRes3 = driver.findElement(checkBoxOption1By).isSelected();
        boolean actualRes4 = driver.findElement(checkBoxOption3By).isSelected();
        Assert.assertEquals(checkBoxesAreSelected, actualRes3==actualRes4);
    }

    @Test
    public void test_4() {

        ////??????????????????????????????????????????????????????????????????????????
        String displaySex = "Sex : Female";
        String displayAgeGroupRadioButton = " Age group: 5 - 15";

        WebElement inputFormOption = driver.findElement(inputFormOptionBy);
        inputFormOption.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(waitRadiobuttonDemoBy)).click();
        WebElement radioButtonSexMale = driver.findElement(radioButtonSexMaleBy);
        radioButtonSexMale.click();
        WebElement radioButtonAgeGroup = driver.findElement(radioButtonAgeGroupBy);
        radioButtonAgeGroup.click();
        WebElement buttonGetValues = driver.findElement(buttonGetValuesBy);
        buttonGetValues.click();

        String actualRes5 = driver.findElement(actualRes5By).getText();     // ????
        Assert.assertNotEquals(displaySex,actualRes5);                      // ????
        Assert.assertNotEquals(displayAgeGroupRadioButton,actualRes5);      // ????
    }

    @Test
    public void test_5(){
        String checkThatSelectedDayIsAppeared = "Day selected :- Friday";
        WebElement inputFormOption = driver.findElement(inputFormOptionBy);
        inputFormOption.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(waitSelectDropdownListBy)).click();
        WebElement selectListDemoOptionFriday = driver.findElement(selectListDemoOptionFridayBy);
        selectListDemoOptionFriday.click();
        String actualRes6 = driver.findElement(actualRes6By).getText();
        Assert.assertEquals(checkThatSelectedDayIsAppeared,actualRes6);
    }

    @Test ////?????????????????????????676????????????????????????????????????????
    public void test_6(){
        String textSelectedIsDisplayed = "Options selected are : Florida";
        WebElement inputFormOption = driver.findElement(inputFormOptionBy);
        inputFormOption.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(waitSelectDropdownListBy)).click();

        Select select = new Select(driver.findElement(By.xpath("//select[@id='multi-select']")));
        select.selectByVisibleText("Florida");
        WebElement buttonGetAllSelected = driver.findElement(buttonGetAllSelectedBy);
        buttonGetAllSelected.click();
        //select.selectByVisibleText("New York");
        String actRes7 = driver.findElement(By.xpath("//p[@class='getall-selected']")).getText();
        Assert.assertEquals(textSelectedIsDisplayed, actRes7);

    }

    @Test
    public void test_7(){
        String isBorderColorRed = "rgb(255, 0, 0)";
        WebElement inputFormOption = driver.findElement(inputFormOptionBy);
        inputFormOption.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(waitAjaxFormSubmitBy)).click();
        WebElement clickSubmitButton = driver.findElement(clickSubmitButtonBy);
        clickSubmitButton.click();
        String actRes8 = driver.findElement(actRes8By).getAttribute("outerHTML"); // нашла в Properties in devtools

        Assertions.assertThat(actRes8).contains(isBorderColorRed);
    }

    //@Test
    //public void test_8() {
        //WebElement datePickers = driver.findElement(datePickersBy);
        //datePickers.click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(waitBootstrapDatePickerBy)).click();
        //WebElement chooseDate = driver.findElement(By.xpath(chooseDateBy));
        //chooseDate.click();
       // WebElement
    //}
        // By datePickersBy = By.xpath("//a[text()='Date pickers']");
        // By waitBootstrapDatePickerBy = By.xpath("//li[@class='tree-branch']//a[text()='Bootstrap Date Picker']");
        // By chooseDateBy = By.xpath("//div[@id='sandbox-container1']//span[@class='input-group-addon']");
    @Test
    public void test_9(){
        String textIsVisible = "4 Bootstrap 3 Emily John in progress";
        WebElement optionTable = driver.findElement(optionTableBy);
        optionTable.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(optionTableDataSearchBy)).click();
        WebElement tabTableFilter = driver.findElement(taskTableFilterBy);
        tabTableFilter.sendKeys("Emily John");

        String actRes9 = driver.findElement(taskTableBy).getText();
        Assertions.assertThat(actRes9).contains(textIsVisible);
    }

    //By optionTable1By = By.xpath("//li[@class='tree-branch']//a[text()='Table']");
    //By optionTableFilterBy = By.xpath("//li[@class='tree-branch']//a[text()='Table Filter ']");
    //By buttonOrangeBy = By.xpath("//button[text()='Orange']");

    @Test
    public void test_10(){
        String isSmileColorOrange = "rgb(265, 165, 0)";
        WebElement optionTable1 = driver.findElement(optionTable1By);
        optionTable1.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(optionTableFilterBy)).click();
        WebElement buttonOrange = driver.findElement(buttonOrangeBy);
        buttonOrange.click();
        String actRes10 = driver.findElement(By.xpath("//div[@class='media']//i[@style='color:orange;']")).getCssValue("color:");
        //String actRes10 = driver.findElement(By.xpath("//div[@class='media']//i[@style='color:orange;']")).getAttribute("outerHTML");//correct option
        Assertions.assertThat(actRes10).isEqualTo(isSmileColorOrange);
    }
    // ("//div[@class='media']//i[@style='color:orange;']")
    // ("//div[@class='media']//a[@class='pull-left']//i[@class='media-photo fa fa-smile-o fa-3x']")
    //#f0ad4e

    //.table-filter .media .title .pendiente {
    //	color: #f0ad4e;
    //}

    //element.style {
    //    color: orange;
    //}

    //outerHTML: "<i class="media-photo fa fa-smile-o fa-3x" style="color:orange;" aria-hidden="true"></i>"
    @After
    public void afterEachTest(){
        driver.quit();
    }

}
