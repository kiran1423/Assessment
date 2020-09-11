package com.pom.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.pom.baseclass.Testbase;

public class Locators extends Testbase {
	
	public By loginLink = By.xpath("//a[@class='ico-login']");
	public By header = By.xpath("//h1");
	public By email = By.xpath("//input[@id='Email']");
	public By password = By.xpath("//input[@id='Password']");
	public By login = By.xpath("//input[@class='button-1 login-button']");
	
	public By account = By.xpath("(//a[@class='account'])[1]");
	
	public By cart = By.xpath("//span[contains(text(),'Shopping cart')]");
	public By goToCart = By.xpath("//input[@class='button-1 cart-button']");
	
	public By removeFromCart = By.xpath("//input[@name='removefromcart']");
	public By updateCart = By.xpath("//input[@name='updatecart']");
	
	public By books = By.xpath("//ul[@class='top-menu']//a[contains(text(),'Books')]");	
	public By addToCart = By.xpath("(//input[@value='Add to cart'])[1]");
	public By addToCartMessage = By.xpath("//p[@class='content']");
	public By shoppingCart = By.xpath("//*[@id='bar-notification']/p/a");

	
	public By price = By.xpath("//span[@class='product-unit-price']");
	public By quantity = By.xpath("//input[contains(@name,'itemquantity')]");
	
	public By subTotal = By.xpath("(//span[@class='product-price'])[1]");	
	public By termsOfService = By.xpath("//input[@id='termsofservice']");
	public By checkout = By.xpath("//button[@id='checkout']");
	
	public By selectAddress = By.xpath("//select[@id='billing-address-select']");
	
	public By firstName = By.xpath("//input[@id='BillingNewAddress_FirstName']");
	public By lastName = By.xpath("//input[@id='BillingNewAddress_LastName']");
	public By newAddress_email = By.xpath("//input[@id='BillingNewAddress_Email']");
	public By country = By.xpath("//select[@id='BillingNewAddress_CountryId']");
	public By city = By.xpath("//input[@id='BillingNewAddress_City']");
	public By address1 = By.xpath("//input[@id='BillingNewAddress_Address1']");
	public By zip = By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']");
	public By phone = By.xpath("//input[@id='BillingNewAddress_PhoneNumber']");
	public By continueButton = By.xpath("//div[@id='billing-buttons-container']//input[@class='button-1 new-address-next-step-button']");
	
	public By shippingAddress = By.xpath("//select[@id='shipping-address-select']");
	public By shippingAddressNext = By.xpath("//div[@id='shipping-buttons-container']//input[@class='button-1 new-address-next-step-button']");
	
	public By nextDayAir = By.xpath("//input[@value='Next Day Air___Shipping.FixedRate']");
	public By shippingMethodNext = By.xpath("//input[@class='button-1 shipping-method-next-step-button']");
	
	public By paymentTypeNext = By.xpath("//input[@class='button-1 payment-method-next-step-button']");
	
	public By codText = By.xpath("//p[contains(text(),'You will pay by COD')]");
	public By paymentInfoNext = By.xpath("//input[@class='button-1 payment-info-next-step-button']");
	
	public By confirm = By.xpath("//input[@class='button-1 confirm-order-next-step-button']");
	
	public By successMessage = By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]");
	
	public By orderNumber = By.xpath("//li[contains(text(),'Order number: ')]");
	public By orderCompletedNext = By.xpath("//input[@class='button-2 order-completed-continue-button']");
	public By logout = By.xpath("//a[@class='ico-logout']");






	
	







    

}
