package week4.day2;

import java.util.concurrent.TimeUnit;

import javax.swing.JComboBox.KeySelectionManager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drag {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/drag.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

		WebElement dragItem = driver.findElement(By.xpath("//p[text()='Drag me around']"));
		int x = dragItem.getLocation().getX();
		int y = dragItem.getLocation().getY();
		WebElement dragedPosition = driver.findElement(By.xpath("//img[@alt='logo Testleaf']"));
		Actions builder = new Actions(driver);
		builder.clickAndHold(dragItem).moveToElement(dragedPosition).perform();
		builder.clickAndHold(dragItem).moveToElement(dragedPosition, x + 100, y + 100).perform();

	}

}
