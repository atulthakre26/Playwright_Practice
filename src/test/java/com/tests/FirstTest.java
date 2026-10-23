package com.tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FirstTest {
	
	public static void main(String[] args) {
		
		
	   try (Playwright playwright = Playwright.create()){
		   
		   Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		   
		   Page page = browser.newPage();
		   
		   page.navigate("https://www.saucedemo.com/");

           // Print page title
           System.out.println("Page Title: " + page.title());

           // Enter username
           page.locator("#user-name").fill("standard_user");

           // Enter password
           page.locator("#password").fill("secret_sauce");

           // Click Login
           page.locator("#login-button").click();

           // Print current URL
           System.out.println("Current URL: " + page.url());

           // Close browser
           browser.close();
	   }
	}

}
