package week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drop {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/drop.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		
		WebElement dragItem = driver.findElement(By.xpath("//p[text()='Drag me to my target']"));
		WebElement dropItem = driver.findElement(By.xpath("//p[text()='Drop here']"));
		Actions builder = new Actions(driver);
		builder.dragAndDrop(dragItem, dropItem).perform();
		
		
	}

}
