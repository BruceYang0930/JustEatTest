package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {
	WebDriver driver = null;

	@Given("^I want food in \"([^\"]*)\"$")
	public void i_want_food_in(String postcode) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "E:\\WorkSpaces\\EclipseWS\\Libs\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.just-eat.co.uk/");
		WebElement postcodeInput = driver.findElement(By.name("postcode"));
		postcodeInput.sendKeys(postcode);
		System.out.println("Enter postcode");
	}

	@When("^I search for restaurants$")
	public void i_search_for_restaurants() throws Throwable {
		WebElement searchButt = driver.findElement(By.className("Form_c-search-btn_1EEhL"));
		searchButt.click();
		System.out.println("Click search");
	}

	@Then("^I should see some restaurants in \"([^\"]*)\"$")
	public void i_should_see_some_restaurants_in(String postcode) throws Throwable {
		driver.findElement(By.className("c-dishSearch-locationHeader-title")).getText().contains(postcode);
		System.out.println("See restaurants");
		Thread.sleep(5000);
		driver.quit();
	}

	@Then("^I should see error message$")
	public void i_should_see_error_message() throws Throwable {
		driver.findElement(By.id("errorMessage"));
		System.out.println("See error");
		Thread.sleep(5000);
		driver.quit();
	}

	@Given("^I am on the restaurants list page near the area \"([^\"]*)\"$")
	public void i_am_on_the_restaurants_list_page_near_the_area(String postcode) throws Throwable {
		driver = new ChromeDriver();
		driver.get("http://www.just-eat.co.uk/");
		WebElement postcodeInput = driver.findElement(By.name("postcode"));
		postcodeInput.sendKeys(postcode);
		System.out.println("Enter postcode");
		WebElement searchButt = driver.findElement(By.className("Form_c-search-btn_1EEhL"));
		searchButt.click();
		System.out.println("Click search");
		driver.findElement(By.className("c-dishSearch-locationHeader-title")).getText().contains(postcode);
		System.out.println("See restaurants");
	}

	String resName = null;

	@When("^I select the first restaurant on the list$")
	public void i_select_the_first_restaurant_on_the_list() throws Throwable {
		WebElement firstRes = driver.findElement(By.xpath("//*[@class=\"c-listing \"]//h3"));
		resName = firstRes.getText();
		firstRes.click();
		System.out.println("Click the first restaurant: " + resName);
	}

	@Then("^I should see corresponding restaurant details page$")
	public void i_should_see_corresponding_restaurant_details_page() throws Throwable {
		WebElement resDetailName = driver.findElement(By.xpath("//*[@id=\"restaurant\"]//h1"));
		resDetailName.getText().equals(resName);
		System.out.println("Check details");
		Thread.sleep(5000);
		driver.quit();

	}

}
