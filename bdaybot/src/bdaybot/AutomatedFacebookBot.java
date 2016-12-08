package bdaybot;

import java.io.*;
import java.nio.*;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AutomatedFacebookBot
{
	public static void main(String args[])
	{
		//System property set to the location of the geckodriver executable file
		//System property might change at different systems for a different location of geckodriver.exe
		System.setProperty("webdriver.gecko.driver", "E:\\Selenium Webdriver Files\\geckodriver.exe");
		
		//we will be using firefoc browser for now.
		WebDriver myDriver = new FirefoxDriver();
		
		//go to offcial login page of facebook site.
		String facebookURL = "https://www.facebook.com";
		myDriver.get(facebookURL);
		
		//add your login details
		String dummyInstruction = null;
		String Username = null;
		String Password = null;
		String urlForTextFile = "E:/FacebookBirthdayBot/EnterDetails.txt";
		try
		{
			
			File fileObject = new File(urlForTextFile);
			Scanner input = new Scanner(fileObject);
			dummyInstruction = input.nextLine();
			Username = input.nextLine();
			Password = input.nextLine();
			input.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		//now we will send the deatils to the login page
		//First the UserName
		By FacebookUserNameInputLocator = By.id("email");
		WebElement UserNameElement = myDriver.findElement(FacebookUserNameInputLocator);
		UserNameElement.sendKeys(Username);
		
		//Now the Password
		By FacebookPassWordInputLocator = By.id("pass");
		WebElement PassWordElement = myDriver.findElement(FacebookPassWordInputLocator);
		PassWordElement.sendKeys(Password);
		
		//Click the Login Button
		By LogInLocator = By.id("loginbutton");
		WebElement logInElement = myDriver.findElement(LogInLocator);
		logInElement.click();
		
		myDriver.close();
	}
}