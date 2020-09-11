package com.pom.actions;

import static org.testng.Assert.assertEquals;

import java.nio.charset.Charset;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pom.baseclass.Testbase;
import com.pom.locators.Locators;

import junit.framework.Assert;


public class Actions extends Locators{
	    
    public Actions(){

        //This initElements method will create all WebElements
    	// PageFactory.initElements(driver, this);
       // PageFactory.initElements(driver, Locators.class);
    }

    String emailId = properties.getProperty("email");
    String productQuantity = properties.getProperty("quantity");
    double oneItemPrice;
    String lName = properties.getProperty("lastName");
    String addEmailId = properties.getProperty("email");
    String addressCountry = properties.getProperty("country");
    String addressCity = properties.getProperty("city");
    String address_1 = properties.getProperty("address1");
    String addressZip = properties.getProperty("zip");
    String addressPhone = properties.getProperty("phone");
    String randomString;
    JavascriptExecutor js = (JavascriptExecutor) driver;
	WebDriverWait wait=new WebDriverWait(driver, 10);




    //Actions
    //Login with valid credentials
    public void login(){
    	 driver.findElement(loginLink).click();
    	 String Header = driver.findElement(header).getText();
    	 assertEquals(Header, properties.getProperty("expectedHeader"));
    	 driver.findElement(email).sendKeys(emailId);
    	 driver.findElement(password).sendKeys("123456");
//    	 driver.findElement(password).sendKeys(properties.getProperty("password"));
    	 driver.findElement(login).click();
    }
    
    //validating user account
    public void userAccount() throws InterruptedException
    {
    	Thread.sleep(1000);
    	String accountId = driver.findElement(account).getText();
    	assertEquals(accountId, emailId);
    }
    
    //Navigate to shopping cart
    public void goToCart()
    {
    	driver.findElement(cart).click();
    }

    //Remove items from cart
    public void clearCart()
    {
    	driver.findElement(removeFromCart).click();
    	driver.findElement(updateCart).click();

    }
    
    //Add items to cart
    public void addItemsToCart()
    {
    	driver.findElement(books).click();
    	driver.findElement(addToCart).click();
    	String cartMessage = driver.findElement(addToCartMessage).getText();
    	assertEquals(cartMessage, properties.getProperty("addToCartMessage"));

    }
    
    //Navigate to shopping cart
    public void navigateToCart()
    {
        js.executeScript("window.scrollBy(0,0)");
    	driver.findElement(shoppingCart).click();
    	
    }
 
    //Get price details and add quanity
    public void itemDetails()
    {
    	String itemPrice = driver.findElement(price).getText();
    	oneItemPrice = Double.valueOf(itemPrice);
    	System.out.println(oneItemPrice);
    	driver.findElement(quantity).clear();
    	driver.findElement(quantity).sendKeys(productQuantity+Keys.ENTER);
    	
    }
 
    //validate subtotal and checkout
    public void checkout()
    {
    	String subtotal = driver.findElement(subTotal).getText();
    	System.out.println(subtotal);
    	double itemQuantity = Double.valueOf(productQuantity);
    	double total = oneItemPrice*itemQuantity;
    	double expectedTotal = Double.valueOf(subtotal);
    	assertEquals(total, expectedTotal);
    	driver.findElement(termsOfService).click();
    	driver.findElement(checkout).click();

    }
 
    //Enter Billing Address as New
    public void selectNewAddress()
    {
    	Select s = new Select(driver.findElement(selectAddress));
    	s.selectByVisibleText("New Address");
    	
    	 byte[] array = new byte[6]; // length is bounded by 7
    	 new Random().nextBytes(array);
    	 randomString = RandomStringUtils.randomAlphabetic(5);

    	 
     	 driver.findElement(firstName).clear();
     	 driver.findElement(firstName).sendKeys(randomString);
     	 driver.findElement(lastName).clear();
     	 driver.findElement(lastName).sendKeys(lName);
     	 driver.findElement(newAddress_email).clear();
     	 driver.findElement(newAddress_email).sendKeys(emailId);
     	 
     	s = new Select(driver.findElement(country));
    	s.selectByVisibleText(addressCountry);
    	
   	 	driver.findElement(city).clear();
   	 	driver.findElement(city).sendKeys(addressCity);
    	 driver.findElement(address1).clear();
     	 driver.findElement(address1).sendKeys(address_1);
     	 driver.findElement(zip).clear();
     	 driver.findElement(zip).sendKeys(addressZip);
     	 driver.findElement(phone).clear();
     	 driver.findElement(phone).sendKeys(addressPhone);
     	 
     	 driver.findElement(continueButton).click();

    }
    
    //select shipping address
    public void selectShippingAddress()
    {
    	String billingAddress = randomString+" "+lName+", "+address_1+", "+addressCity+" "+addressZip+", "+addressCountry;
    	Select s = new Select(driver.findElement(shippingAddress));
    	s.selectByVisibleText(billingAddress);
    	driver.findElement(shippingAddressNext).click();
    }
    
    //select shipping method
    public void selectShippingMethod()
    {
    	driver.findElement(nextDayAir).click();
    	driver.findElement(shippingMethodNext).click();
    	 	
    }
  
    //select payment method
    public void selectPaymentMethod()
    {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(paymentTypeNext));
 //   	js.executeScript("arguments[0].scrollIntoView();",driver.findElement(paymentTypeNext));	
    	driver.findElement(paymentTypeNext).click();
    	 	
    }
  
    //validate payment info text
    public void PaymentInfo()
    {
    	String actualCODText = driver.findElement(codText).getText();
    	assertEquals(actualCODText, properties.getProperty("expectedCODText"));

    	driver.findElement(paymentInfoNext).click();   	 	
    }
 
    //click on confirm order
    public void confirm()
    {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(confirm));
    	driver.findElement(confirm).click();
    }

    //validate success message and click on continue
    public void successMessage()
    {
    	
    	String actaualSuccessMessage = driver.findElement(successMessage).getText();
    	assertEquals(actaualSuccessMessage, properties.getProperty("expectedSuccessMessage"));
    	
    	String orderNo = driver.findElement(orderNumber).getText();
    	System.out.println(orderNo);
    	
    	driver.findElement(orderCompletedNext).click();
    }
    
    //Logout
    public void logout() {
    	driver.findElement(logout).click();
    }



    



}
