package cucumber;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class tariff {
	WebDriver driver;

	@Given("The user is in add customer page")
	public void customer_page() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Ashok 555\\eclipse-workspace\\bharath\\cucumber_tariff\\tariff\\lib & driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/telecom/index.html");
		driver.findElement(By.xpath("//h3//a[@href ='addcustomer.php']")).click();

	}

	@When("The user fill in the customer page and submit")
	public void user_fill_page(DataTable datatable) {
		List<String>cusDetails = datatable.asList(String.class);
		//driver.findElement(By.id("done")).click();
		driver.findElement(By.id("fname")).sendKeys(cusDetails.get(0));
		driver.findElement(By.id("lname")).sendKeys(cusDetails.get(1));
		driver.findElement(By.id("email")).sendKeys(cusDetails.get(2));
		driver.findElement(By.id("message")).sendKeys(cusDetails.get(3));
		driver.findElement(By.id("telephoneno")).sendKeys(cusDetails.get(4));
		driver.findElement(By.name("submit")).click();
		
	}

	@When("The user should see  the customer ID generated")
	public void customer_ID() {
		driver.findElement(By.xpath("//li//a[@href='index.html']"));

	}

	@And("click home button")
	public void home() {
		driver.findElement(By.xpath("//li//a[@href='index.html']"));

	}

	@When("The user is in add tariff plan to customer page")
	public void user_tariff_plan() {
		driver.findElement(By.xpath("//h3//a[@href='assigntariffplantocustomer.php']"));

	}

	@When("Do enter customer ID and sumbit in this page")
	public void Enter_ID() {
		driver.findElement(By.id("customer_id"));
		driver.findElement(By.xpath("//input[@type='submit']"));

	}

	@Then("Slect tariff plan then click add tariff plan to customer")
	public void tariff_plan() {
		driver.findElement(By.id("sele")).click();
		driver.findElement(By.name("submit"));
		driver.quit();

	}

}
