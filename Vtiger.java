package Assignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Vtiger {
	
	@Test
	public void vTiger()
	{
		ChromeDriver d= new ChromeDriver();
		d.get("https://http://localhost:8888/");
		
	}

}
