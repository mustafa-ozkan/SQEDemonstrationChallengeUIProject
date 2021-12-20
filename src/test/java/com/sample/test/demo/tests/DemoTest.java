package com.sample.test.demo.tests;

import com.sample.test.demo.constants.PizzaToppings;
import com.sample.test.demo.constants.PizzaTypes;
import com.sample.test.demo.implementations.OrderPizza;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.sample.test.demo.TestBase;

import java.util.HashMap;
import java.util.Map;

public class DemoTest extends TestBase {

    OrderPizza orderPizza =  new OrderPizza();
    TakesScreenshot takesScreenshot = (TakesScreenshot)driver;

    @Test
    public void demoTest() {
        System.out.println("HELLO WORLD");
    }

    @Test
    public void checkTitleTest(){
        Assert.assertEquals(driver.getTitle(),"Pizza Order Form");
    }

//    @Test
//    public void happyPathTestOtherClass(){
//        orderPizza.choosePizza1(""+PizzaTypes.LARGE_THREETOPPINGS);
//        orderPizza.chooseToppings1(""+ PizzaToppings.MUSHROOMS);
//        orderPizza.chooseToppings2(""+ PizzaToppings.ONIONS);
//        orderPizza.inputQuantity(2);
//        Assert.assertEquals(orderPizza.getCost(),27);
//
//        orderPizza.inputName("Username");
//        orderPizza.inputEmail("user@name.com");
//        orderPizza.inputPhone("1231231234");
//
//        orderPizza.choosePaymentInformation("Credit Card");
//        orderPizza.clickButton("Place Order");
//
//        Assert.assertEquals(orderPizza.getPopupMessage(),"Thank you for your order! TOTAL: 27 Large 10 Slices - 2 toppings");
//
//
//    }

//    @Test
//    public void getPizzaList(){
//        Select objSel = new Select(driver.findElement(By.id("pizza1Pizza")));
//        List<WebElement> listPizza = objSel.getOptions();
//        for (WebElement we:listPizza
//             ) {
//            System.out.println(we.getText());
//        }
//    }


    @Test
    public void happyPathTest(){
        choosePizza1(""+PizzaTypes.LARGE_THREETOPPINGS.getDisplayName());
        chooseToppings1(""+ PizzaToppings.MUSHROOMS.getDisplayName());
        chooseToppings2(""+ PizzaToppings.ONIONS.getDisplayName());
        inputQuantity(2);
        Assert.assertEquals(getCost(),27.0);

        inputName("Username");
        inputEmail("user@name.com");
        inputPhone("1231231234");

        choosePaymentInformation("Credit Card");
        clickButton("Place Order");

        Assert.assertEquals(getDialogMessage(),"Thank you for your order! TOTAL: 27 Large 10 Slices - 2 toppings");


    }


    public void choosePizza1(String pizza1Option) {
        WebElement pizza1OptionWE = driver.findElement(By.id("pizza1Pizza"));
        Select selectPizza1Option = new Select(pizza1OptionWE);
        selectPizza1Option.selectByValue(pizza1Option);
    }

    public void chooseToppings1(String toppings1) {
        WebElement toppings1WE = driver.findElement(By.xpath("//div[@id='pizza1']//select[@class='toppings1']"));
        Select selectToppings1 =  new Select(toppings1WE);
        selectToppings1.selectByValue(toppings1);
    }
    public void chooseToppings2(String toppings2) {
        WebElement toppings2WE = driver.findElement(By.xpath("//div[@id='pizza1']//select[@class='toppings2']"));
        Select selectToppings2 =  new Select(toppings2WE);
        selectToppings2.selectByValue(toppings2);
    }

    public void inputQuantity(int inputQuantity) {
        WebElement inputQuantityWE = driver.findElement(By.id("pizza1Qty"));
        inputQuantityWE.sendKeys(""+inputQuantity+Keys.ENTER);
    }

    public double getCost() {
        WebElement costWE = driver.findElement(By.id("pizza1Cost"));

        return Double.parseDouble(costWE.getAttribute("value"));
    }

    public void inputName(String username) {
        WebElement inputNameWE = driver.findElement(By.id("name"));
        inputNameWE.sendKeys(username);
    }
    public void inputEmail(String email) {
        WebElement inputEmailWE = driver.findElement(By.id("email"));
        inputEmailWE.sendKeys(email);
    }
    public void inputPhone(String phone) {
        WebElement inputPhoneWE = driver.findElement(By.id("phone"));
        inputPhoneWE.sendKeys(phone);

    }

    public void choosePaymentInformation(String paymentOption) {
        Map<String,String> mapPaymentOptionsvsID=new HashMap<>();
        mapPaymentOptionsvsID.put("Credit Card","ccpayment");
        mapPaymentOptionsvsID.put("Cash on Pickup","cashpayment");
        WebElement paymentInformationWE = driver.findElement(By.id(mapPaymentOptionsvsID.get(paymentOption)));
        paymentInformationWE.click();
    }

    public void clickButton(String buttonName) {
        Map<String,String> mapButtonsvsID = new HashMap<>();
        mapButtonsvsID.put("Place Order","placeOrder");
        mapButtonsvsID.put("Reset","reset");
        WebElement buttonWE = driver.findElement(By.id(mapButtonsvsID.get(buttonName)));
        buttonWE.click();
    }

    public String getDialogMessage() {

        WebElement dialogTextWE = driver.findElement(By.xpath("//div[@id='dialog']/p"));

    return dialogTextWE.getText();
    }

}
