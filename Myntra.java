package week4.day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {
	public static void main(String[] args) throws IOException, InterruptedException {
		
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://www.myntra.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	WebElement hoverElement = driver.findElement(By.xpath("//a[text()='Men']"));
	Actions bulider = new Actions(driver);
	bulider.moveToElement(hoverElement).perform();
	driver.findElement(By.xpath("//a[text()='Jackets']")).click();
	String itemsFound = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
	System.out.println("Total count of itmes : "+itemsFound);
	String jacketCount = driver.findElement(By.xpath("//span[@class='categories-num']")).getText();
	String rainJacketCount = driver.findElement(By.xpath("(//span[@class='categories-num'])[2]")).getText();
	System.out.println("Jacket count : "+jacketCount);
	System.out.println("Rain Jacket count : "+rainJacketCount);
	
	String count1 = jacketCount.replaceAll("[^0-9]", "");
	String count2 = rainJacketCount.replaceAll("[^0-9]", "");
	int count3 = Integer.parseInt(count1);
	int count4 = Integer.parseInt(count2);
	int totalCount = count3 + count4;
	System.out.println("Total count: " + totalCount);
	
	if(itemsFound.equals(totalCount))
	{
	System.out.println("Jacket count match");
	} else
	System.out.println("Jacket count doesn't match");
	
	driver.findElement(By.xpath("//label[text()='Jackets']/div")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@class='brand-more']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@class='FilterDirectory-searchInput']")).sendKeys("Duke");
	driver.findElement(By.xpath("//label[text()='Duke']//div")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();
	Thread.sleep(1500);
	List<WebElement> brand = driver.findElements(By.className("product-brand"));
	
	List<String> brandName = new ArrayList<String>();
		for (int i=0; i< brand.size();i++) {
		WebElement webElement1 = brand.get(i);
		String textbrandName = webElement1.getText();
		brandName.add(textbrandName);	
		}
	
	for (String webElement2 : brandName) {
		if(brandName.contains("Duke")) { 
			System.out.println("This is a Duke product");
		}
		else 
		{
			System.out.println("This is not a Duke Product");
	}
	}
		
		WebElement hoverElement2 = driver.findElement(By.xpath("//div[@class='sort-sortBy']"));
		bulider.moveToElement(hoverElement2).perform();
		driver.findElement(By.xpath("//label[text()='Better Discount']")).click();
		Thread.sleep(1000);
		String priceOfFirst = driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]")).getText();
		System.out.println("Price of the First Item : "+priceOfFirst);
		
		driver.findElement(By.xpath("(//div[@class='product-imageSliderContainer'])[1]")).click();
	
		
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> windowHandleslist1 = new ArrayList <String>(windowHandles1);
		driver.switchTo().window(windowHandleslist1.get(1));
		File src1 = driver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./snap/Myntra.png");
		FileUtils.copyFile(src1, dst);
		driver.findElement(By.xpath("(//span[@class='desktop-userTitle'])[2]")).click();
		driver.close();
		
		
	}


}
