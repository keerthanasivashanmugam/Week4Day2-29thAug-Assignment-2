package week4.day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("(//li[@class='navlink lnHeight']//span)[1]")).click();
		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
		String sportShoesCount = driver.findElement(By.xpath("//span[@class='category-count']")).getText();
		System.out.println("Sports Shoes count : "+sportShoesCount);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		driver.findElement(By.xpath("//span[text()='Sort by:']")).click();
		driver.findElement(By.xpath("(//span[@class='arrow hidden'])[1]//parent::li")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//body[@data-pagename='categoryPage']")).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//body[@data-pagename='categoryPage']")).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//body[@data-pagename='categoryPage']")).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//body[@data-pagename='categoryPage']")).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//body[@data-pagename='categoryPage']")).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//body[@data-pagename='categoryPage']")).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//body[@data-pagename='categoryPage']")).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//body[@data-pagename='categoryPage']")).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//body[@data-pagename='categoryPage']")).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(1000);		
		
		List<WebElement> priceListBeforeSort = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		int size = priceListBeforeSort.size();
		List<Integer> priceIntList = new ArrayList<Integer>();//priceIntList
		System.out.println("Total Training shoes count : "+size);
		System.out.println("Price before Sort : ");
		for(int i=0;i<priceListBeforeSort.size();i++)
		{
			String priceAttributeInString = priceListBeforeSort.get(i).getAttribute("display-price");
			System.out.println(priceAttributeInString);
			int priceInInteger = Integer.parseInt(priceAttributeInString);
			priceIntList.add(priceInInteger);
		}
		System.out.println("Price after Sort : ");
		Collections.sort(priceIntList);
		for (Integer setInteger1 : priceIntList) {
			System.out.println(setInteger1);
		}
		
		WebElement priceWebElement = driver.findElement(By.xpath("(//div[@data-name='Price']//div)[1]"));
		String priceMinS = priceWebElement.getAttribute("data-min");
		int priceMinI = Integer.parseInt(priceMinS);
		
		String priceMaxS = priceWebElement.getAttribute("data-max");
		int priceMaxI = Integer.parseInt(priceMaxS);
		if((priceIntList.get(0) == priceMinI))
		{
			
				System.out.println("Max and Min values in the page and Sorted values are same ");
			
		}
			
				
		driver.findElement(By.xpath("//button[@data-filtername='Brand']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()=' Columbus ']")).click();
		driver.findElement(By.xpath("//div[text()='APPLY']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//body[@data-pagename='categoryPage']")).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(1000);	
		driver.findElement(By.xpath("(//button[text()='View More '])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[@for='Color_s-Turquoise']")).click();
		Thread.sleep(1000);
		
		WebElement hoverElement = driver.findElement(By.xpath("//img[@class='product-image wooble']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(hoverElement).perform();
		driver.findElement(By.xpath("//div[contains(text(),'Quick View')]")).click();
		String price = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		System.out.println("Price of the product : "+price);
		String discount = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		System.out.println("Discount of the product : "+discount);
		Thread.sleep(3000);
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./snap/snapdeal_shoe_ss.png");
		FileUtils.copyFile(src, dst);
		//driver.close();
		driver.findElement(By.xpath("//div[@class='close close1 marR10']")).click();
		driver.findElement(By.xpath("//input[@id='inputValEnter']")).sendKeys("Puma sport shoe");
		driver.findElement(By.xpath("//span[@class='searchTextSpan']")).click();
		
	}

}
