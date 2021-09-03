package week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DraggableJqueryUI {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/draggable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		
		WebElement frameElement = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frameElement);
		WebElement dragElement = driver.findElement(By.xpath("//div[@id='draggable']"));
		Point dragLocation = dragElement.getLocation();
		int x = dragLocation.getX();
		int y = dragLocation.getY();
		System.out.println(x+" "+y);
		Actions builder = new Actions(driver);
		//builder.dragAndDropBy(dragElement, (x+150), (y+150)).perform();		or
		builder.clickAndHold(dragElement).moveToElement(dragElement, x+150, y+150).perform();

	}

}
