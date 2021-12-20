package com.sample.test.demo.implementations;

import com.sample.test.demo.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderPizza extends TestBase {

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
        inputQuantityWE.sendKeys(""+inputQuantity);
    }

    public double getCost() {
        WebElement costWE = driver.findElement(By.id("pizza1Cost"));
        return Double.parseDouble(costWE.getText());
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

    public String getPopupMessage() {
        return driver.switchTo().alert().getText();
    }
}
