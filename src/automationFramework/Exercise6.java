package automationFramework;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class Exercise6 {
	
	@Test
	public void test_GoogleSearch_m3s() {
		
		System.setProperty(
				"webdriver.gecko.driver", 
				"D:\\selenium-java-3.141.59\\drivers\\geckodriver.exe"
				);
		WebDriver d = new FirefoxDriver();
		
		System.out.println("test_GoogleSearch_m3s");
		WebDriverWait wait = new WebDriverWait(d, 15);		
		
		d.get("https://google.com");
	   	d.findElement(By.name("q")).sendKeys("m3s" + Keys.ENTER);		
		
	   	// selecting web element by CSS selector "div.g:nth-child(1) > div:nth-child(2) > div:nth-child(1)'- and run it
	 	WebElement firstResult = wait.until(
	 			presenceOfElementLocated(
	 					By.cssSelector(
	 							"div.g:nth-child(1) > div:nth-child(2) > div:nth-child(1)"
	 							)));
		
		//You can comment out the above if - else statement and uncomment the below statement to test using assertEquals
		assertTrue(
				"The return result does not contain the search word",
				firstResult.getAttribute("textContent").contains("software engineering"));
	
		//closing the browser 	
		d.close();
	}
		
	@Test
	public void test_OuluUniversity_titleEquals_University_of_Oulu() {
		
		System.out.println("Test https://www.oulu.fi/university/ title");
		
		System.setProperty(
				"webdriver.gecko.driver", 
				"D:\\selenium-java-3.141.59\\drivers\\geckodriver.exe"
				);
		
		WebDriver d = new FirefoxDriver();
		
		d.get("https://www.oulu.fi/university/");
	   	WebElement result = d.findElement(By.cssSelector("head > title:nth-child(30)"));
	   	
		assertEquals(
				"WebElement title does not match 'University of Oulu",
				"University of Oulu",
				result.getAttribute("textContent")
				);	
		
		d.close();
	}
	
	@Test
	public void test_OuluUniversity_PageContains_ThesisDefenseAnnouncements () {
		
		System.out.println("Test https://www.oulu.fi/university/ contains Thesis defense announcements");
		
		System.setProperty(
				"webdriver.gecko.driver", 
				"D:\\selenium-java-3.141.59\\drivers\\geckodriver.exe"
				);
		
		WebDriver d = new FirefoxDriver();
		
		d.get("https://www.oulu.fi/university/");
		//WebDriverWait wait = new WebDriverWait(d, 15);		
		
		WebElement result = d.findElement(By.xpath("//*[text()='Thesis defense announcements']"));
		
		assertTrue(
				"Page does not contain 'Thesis defense announcements'",
				result.getAttribute("textContent").contains("Thesis defense announcements")
				);	
		
		d.close();
	}
	
	@Test
	public void test_test() {
		/*
		String baseUrl = "http://google.com";
		d.navigate().to(baseUrl);
		WebElement searchbox = d.findElementByName("q");
		searchbox.sendKeys("m3s");
		searchbox.submit();
		
		d.findElementByName("btnK").click();
		d.findElementByLinkText("Google-haku").click();		
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		d.findElementByCssSelector("div.g:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > h3:nth-child(2) > span:nth-child(1)")
		d.findElementsByXPath("/html/body/div[7]/div[2]/div[10]/div[1]/div[2]/div/div[2]/div[2]/div/div/div[1]/div/div/div/div[1]/a/h3/span");
		List<WebElement> elements = d.findElementsByCssSelector("div.g:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > h3:nth-child(2) > span:nth-child(1)");
		System.out.println(elements.size());
		for (int i = 0; i < elements.size(); i++){
		      System.out.println("Elements:" + elements.get(i).getAttribute("value"));
		}
		
		//Check if text in the first result contains the string 'software engineering'
		if( firstResult.getAttribute("textContent").contains("software engineering")) {
			
			System.out.println("The Search result contains 'software engineering' ");
		}
		else{
				System.out.println("The search result does not contain keyword 'Software engineering'");
			}
		*/	 	
	}
}
