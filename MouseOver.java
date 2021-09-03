package week4.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseOver {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/mouseOver.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

		WebElement mouseHoverEle = driver.findElement(By.xpath("//a[text()='TestLeaf Courses']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(mouseHoverEle).perform();
		Thread.sleep(1000);
		List<WebElement> linksEle = driver.findElements(By.className("listener"));
		System.out.println("No of links under TestLeaf Course : " + linksEle.size());
		for (WebElement webElement : linksEle) {
			System.out.println("TestLeaf Course : " + webElement.getText());
		}

		builder.moveToElement(mouseHoverEle).perform();
		driver.findElement(By.xpath("//a[text()='Selenium']")).click();

	}

}
