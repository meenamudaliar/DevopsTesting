package testNG;


import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestCase2 {
	@Test(groups= {"Regression"})
	public void test3() {
		System.out.println("Inside test3");
	}
	@BeforeSuite
	public void beforeSuitName() {
		System.out.println("Inside before suite");
	}
	@AfterSuite
	public void AfterSuitName() {
		System.out.println("Inside before suite");
	}
}
