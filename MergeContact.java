package week4.day1assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//div[@class='frameSectionBody']/ul/li[4]/a")).click();
		driver.findElement(By.xpath("//table[@id='widget_ComboBox_partyIdFrom']//following-sibling::a")).click();
		Set<String> wHandlesSet = driver.getWindowHandles();
		List<String> wHandlesList = new ArrayList<String>(wHandlesSet);
		driver.switchTo().window(wHandlesList.get(1));
		driver.findElement(By.xpath("//div[@class='x-grid3-body']/div[1]/table/tbody/tr[1]/td[1]/div/a[1]")).click();
		driver.switchTo().window(wHandlesList.get(0));
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='x-grid3-body']/div[2]/table/tbody/tr[1]/td[1]/div/a[1]")).click();
		driver.switchTo().window(wHandlesList.get(0));
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();	
		String expectedTitle = "View Contact | opentaps CRM";
		String actualTitle = driver.getTitle();
		System.out.println("Actual Title of Page: "+actualTitle);
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("Expected Title is same as actual Title");
		}
		else
		{
			System.out.println("Title of resulting page is not matching");
	}
	}

}
