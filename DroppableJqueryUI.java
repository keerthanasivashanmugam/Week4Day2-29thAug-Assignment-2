package week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DroppableJqueryUI {

	public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://jqueryui.com/droppable");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	
	WebElement frameElement = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
	driver.switchTo().frame(frameElement);
	WebElement dragItem = driver.findElement(By.xpath("//p[text()='Drag me to my target']"));
	WebElement dropElement = driver.findElement(By.xpath("//p[text()='Drop here']"));
	Actions builder = new Actions(driver);
	builder.dragAndDrop(dragItem, dropElement).perform();

	}

}
