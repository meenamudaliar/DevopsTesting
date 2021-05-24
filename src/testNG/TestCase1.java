package testNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase1 {
	@BeforeTest
public void beforeTest() {
	System.out.println("Inside before test");
}
@BeforeMethod
public void beforeMethod() {
	System.out.println("Inside Before Method");
}
@Test(groups= {"Regression"})
public void CreditTest1() {
	System.out.println("Inside credit test");
}
@Test(groups= {"Regression"})
public void CreditTest2() {
	System.out.println("Inside credit test2");
}
@Test(groups= {"Smoke"})
public void CreditTest3() {
	System.out.println("Inside credit test3");
}
@Test(groups= {"Smoke"})
public void LoanTest() {
	System.out.println("Inside Loantest");
}

@AfterMethod
public void afterMethod() {
System.out.println("Inside after Method");
}
@AfterTest
public void afterTest() {
	System.out.println("Inside after test");
}
}
