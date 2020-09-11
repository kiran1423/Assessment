package com.pom.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pom.actions.Actions;
import com.pom.baseclass.Testbase;

public class AssessmentTest extends Testbase {
  Actions action;

 public AssessmentTest()
 {
	 super();
 }
  
  @BeforeMethod
  public void before() {
	  
	  initialization();
	  action = new Actions();
  }

  @Test
  public void Assesment() throws InterruptedException {
	  
	  action.login();
	  action.userAccount();
	  action.goToCart();
	  action.clearCart();
	  action.addItemsToCart();
	  action.navigateToCart();
	  action.itemDetails();
	  action.checkout();
	  action.selectNewAddress();
	  action.selectShippingAddress();
	  action.selectShippingMethod();
	  action.selectPaymentMethod();
	  action.PaymentInfo();
	  action.confirm();
	  action.successMessage();
	  action.logout();
	  
	}
  

  
  @AfterMethod
  public void after() {	  
	  driver.quit();	  
  }

}
