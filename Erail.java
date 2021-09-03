package week4.day2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Erail {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		WebElement fromElement = driver.findElement(By.id("txtStationFrom"));
		fromElement.clear();
		fromElement.sendKeys("ms");
		fromElement.sendKeys(Keys.ENTER);
		WebElement toElement = driver.findElement(By.id("txtStationTo"));
		toElement.clear();
		toElement.sendKeys("mdu");
		toElement.sendKeys(Keys.ENTER);
		driver.findElement(By.id("chkSelectDateOnly")).click();
		Thread.sleep(5000);
			
		WebElement webTable = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']"));
		List<WebElement> trainList = webTable.findElements(By.tagName("tr"));
		System.out.println("\nNo of trains : "+trainList.size());

				List <String> trainName1 = new ArrayList<String>();
		System.out.println("Train names before sorting");
		for(int i=1;i<trainList.size();i++)
		{
			WebElement webElement1 = trainList.get(i);
			List<WebElement> columnList = webElement1.findElements(By.tagName("td"));
			String trainName = columnList.get(1).getText();
			System.out.println(trainName);
			trainName1.add(trainName);
			
		}
		
	Collections.sort(trainName1);
		System.out.println("\nTrain Names after sorting : ");
		for (String string1 : trainName1) {
			System.out.println(string1);
		}

	}

}
