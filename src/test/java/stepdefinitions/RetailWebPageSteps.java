package stepdefinitions;

import java.io.IOException;
import java.util.Iterator;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class RetailWebPageSteps

{
	WebDriver driver=null;

	Actions action = null;

	WebDriverWait wait = null;

	Set<String> windowhandle=null;

	List<WebElement> totalrows=null;

	List<WebElement> totalcolumns=null;

	String cuscorrecturl,cusenteredurl,correcturl,enteredurl,parentwindow,childwindow,username,password;

	String url = "http://retailm1.upskills.in/";

	WebElement notifications,home,logout,searchbox,sidebar,dashboard
	,catalog,sales,customers,marketing,reports,catalog_categories,category_name,Meta_tag_title
	,catalog_products,product_name,product_model;

	// using hooks for browser setup

	@Before
	public void browsersetup()
	{
		// here we are initializing  chrome driver and also we are setting the path for chrome driver property

		System.setProperty("webdriver.chrome.driver", "C:\\Training\\Selenium\\chromedriver_win32\\chromedriver.exe");  

		driver= new ChromeDriver();

		action = new Actions(driver);

		wait = new WebDriverWait(driver,60);    // explicit timeout

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.manage().window().maximize();
	}


	@Given("user is in Browser")
	public void searchbox() throws Exception
	{

		//correcturl = "http://retailm1.upskills.in/";

		cusenteredurl = "http://retailm1.upskills.in/";

		driver.get(cusenteredurl);

	}

    @When("^user Enters the URL$")
	public void user_types( )
	{	
		/*if(enteredurl.equals(correcturl))
		{

			driver.get(enteredurl); */

		driver.manage().window().maximize();

		/*	String ActualTitle = driver.getTitle();
		}
		else
		{
			driver.get(enteredurl);
			driver.close();	 
		}*/

	} 

	@Then("website is opened")
	public void website_is_opened() {

		//comparing entered url with current url
		Assert.assertEquals(cusenteredurl,driver.getCurrentUrl());

		System.out.println("URL is opened");

		//comparing Retail page title with actual page title
		Assert.assertEquals("Retail",driver.getTitle());

		System.out.println("Samae title displayed");

	}


	//User Icon page

	@Given("User is in Retail Website")
	public void user_is_in_retail_website() throws IOException {

		driver.get(url);
		driver.manage().window().maximize();

		//Moves over the User Icon 
		WebElement usericon = driver.findElement(By.xpath("//*[@class='fa fa-user-o']")); 
		action = new Actions(driver);
		action.moveToElement(usericon).build().perform();

	}

	@When("^clicks on User Icon button and Login/Register button inside$")
	public void clicks_on_user_icon_button_and_login_register_button_inside() {


		//clicks on Login/Register Button
		driver.findElement(By.xpath("//*[@id=\"Menu_Wmt3OMY3\"]/nav/ul/li[2]/ul/li[1]/a/span")).click();
		driver.findElement(By.xpath("//*[@id='input-email']")).sendKeys("rahulpadma321@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("Reddy@108");

		//clicks on login button
		driver.findElement(By.xpath("//*[@value='Login']")).click();


	}

	@Then("Shows Login\\/Register page and user logins")
	public void shows_login_register_page() {

		System.out.println("User is logined");
	}

	@Then("Clicks on my orders page and comes back")
	public void clicks_on_my_orders_page_and_comes_back() {

		WebElement usericon = driver.findElement(By.xpath("//*[@class='fa fa-user-o']"));
		action = new Actions(driver);
		action.moveToElement(usericon).build().perform();

		//Clicks on My orders button
		driver.findElement(By.xpath("//*[@class='fa fa-shopping-cart']")).click();
		System.out.println("in my orders");
		driver.navigate().back();


	}

	@Then("Clicks on logout")
	public void clicks_on_logout() {

		//wait
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		//WebElement usericon1= driver.findElement(By.xpath("//*[@id=\"Menu_Wmt3OMY3\"]/nav/ul/li[2]/a"));

		//Clicks on Logout Button
		//action.moveToElement(usericon1).build().perform();
		//driver.findElement(By.xpath("//*[@class='fa fa-sign-out']")).click();
		//driver.navigate().back();

	}


	//My Account page

	@Given("User is in my account page")
	public void user_is_in_my_account_page() throws IOException {

		System.out.println("My account page opened");


	}

	@When("Clicks on Edit your information page button")
	public void clicks_on_edit_your_information_page_button() {

		//clicks on edit your information page button
		driver.findElement(By.xpath("//*[@id=\"System_nyHsmShk\"]/align/ul/li[1]/a")).click();

		Assert.assertEquals("My Account Information", driver.getTitle());

		//prints the information page text
		System.out.println("Information page");

	}
	

    @Then("^Enter \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void enter_something_something_something_something(String strArg1, String strArg2, String strArg3, String strArg4) throws Throwable {
         

		//Entering all required fields in Edit information page
		WebElement w1 = driver.findElement(By.xpath("//*[@id='input-firstname']"));
		w1.clear();
		w1.sendKeys(strArg1);
		WebElement w2 = driver.findElement(By.xpath("//*[@id='input-lastname']"));
		w2.clear();
		w2.sendKeys(strArg2);
		WebElement w3 = driver.findElement(By.xpath("//*[@id='input-email']"));
		w3.clear();
		w3.sendKeys(strArg3);
		WebElement w4 = driver.findElement(By.xpath("//*[@id='input-telephone']"));
		w4.clear();
		w4.sendKeys(strArg4);

    	
    	
    }
	
	
	/*

	@Then("Enters the all details in all fields")
	public void enters_the_all_details_in_all_fields() {

		//Entering all required fields in Edit information page
		WebElement w1 = driver.findElement(By.xpath("//*[@id='input-firstname']"));
		w1.clear();
		w1.sendKeys("DRR");
		WebElement w2 = driver.findElement(By.xpath("//*[@id='input-lastname']"));
		w2.clear();
		w2.sendKeys("padma");
		WebElement w3 = driver.findElement(By.xpath("//*[@id='input-email']"));
		w3.clear();
		w3.sendKeys("rahulpadma321@gmail.com");
		WebElement w4 = driver.findElement(By.xpath("//*[@id='input-telephone']"));
		w4.clear();
		w4.sendKeys("905");

	}*/

	@Then("Clicks on Continue button")
	public void clicks_on_continue_button() {

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[@value='Continue']")).click();

		//checking whether details success pop up getting or not
		Assert.assertTrue(driver.findElement(By.xpath("//*[@class='alert alert-success']")).isDisplayed());

		System.out.println("your account has been successfully created");


	}


	//Password reset page

	@Given("User Navigate to the password reset page")
	public void user_navigate_to_the_password_reset_page() {

		driver.findElement(By.xpath("//*[@id=\"System_nyHsmShk\"]/align/ul/li[2]/a")).click();	

	}

	@When("^Enters the (.+) and (.+)$")
	public void enters_the_and(String password, String confirmpassword) throws Throwable {

		driver.findElement(By.xpath("//*[@id='input-password']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@name='confirm']")).sendKeys(confirmpassword);

		//compares the password with confirmpassword
		Assert.assertEquals(password, confirmpassword);

		System.out.println("password matched ");
	}

	@When("Clicks on the Continue button")
	public void clicks_on_the_continue_button() {

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		//clicks on the continue button
		driver.findElement(By.xpath("//*[@value='Continue']")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//*[@class='alert alert-success']")).isDisplayed());

		System.out.println("your password has been successfully updated");

		driver.close();
	}

	@Then("Password will get Reset")
	public void password_will_get_reset() {

		System.out.println("Your password is Reset");

	}


	//Modify your address book entries page

	@Given("Navigates to edit address page by clicking the modify your address book entries button")
	public void navigates_to_edit_address_page_by_clicking_the_new_address_page() {

		//clicks on modify your address book entries button
		driver.findElement(By.xpath("//*[@id='System_nyHsmShk']/align/ul/li[3]/a")).click();
		
		List<WebElement> rah = driver.findElements(By.xpath("//*[@id=\"System_s3bhXNDb\"]//tr/td[1]"));
		int a = rah.size(); String s,s2;
		s = driver.findElement(By.xpath("//*[@id=\"System_s3bhXNDb\"]//tr["+1+"]/td[1]")).getText();
		if(a>1)
		{ 
			for(int i=2;i<=a;i++)
			{
				s2 = driver.findElement(By.xpath("//*[@id=\"System_s3bhXNDb\"]//tr["+i+"]/td[1]")).getText();
				if(s.equals(s2))
				{
					driver.findElement(By.xpath("//*[@id='System_s3bhXNDb']//tr["+i+"]/td["+i+"]/a[2]")).click();
					}
				else
					s=s2;
				}
			}

	Assert.assertEquals("Address Book", driver.getTitle());

	}

	@Given("Clicks on the New Address button")
	public void clicks_on_the_new_address_button() {

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		//clicks on the New address button
		driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
	}


    @When("^Enters the details \"([^\"]*)\"   \"([^\"]*)\"$")
    public void enters_the_details_something_something(String strArg1, String strArg2) throws Throwable {
       

		//Entering  details in required fields	
	
		driver.findElement(By.xpath("//*[@id='input-city']")).sendKeys(strArg2);
		driver.findElement(By.xpath("//*[@id='input-postcode']")).sendKeys(strArg1);

		
		//Radio button1 locator
		WebElement radio1 = driver.findElement(By.xpath("//*[@id=\"edit_address_form\"]/fieldset/div[10]/div/label[1]/input"));
		radio1.click();

		//Radio button2 locator
		//WebElement radio2 = driver.findElement(By.xpath("//*[@value='0']"));

	}

	@Then("clicks on continue button and Address will get updated")
	public void clicks_on_continue_button1() {

		//Clicks on continue button
		driver.findElement(By.xpath("//*[@value='Continue']")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//*//*[@class='alert alert-success']")).isDisplayed());

		//Prints the below text in output console
		System.out.println("Your Address is updated successfully");
	}

	@Then("We can delete the address by clicking on delete button")
	public void new_address_will_update() {

		//wait
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		//Clicking on Delete button
		driver.findElement(By.xpath("//*[@class='btn btn-danger btn-sm btn-default']")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//*[@class='alert alert-success']")).isDisplayed());

		driver.close();
	}


	//Modify your wishlist page

	@Given("Navigates to wishlist page by Clicking the modify your wishlist button")
	public void navigates_to_wishlist_page_by_clicking_the_modify_your_wishlist_button() {

		//Clicks on modify your wishlist button
		driver.findElement(By.xpath("//*[@id='System_nyHsmShk']/align/ul/li[4]/a")).click();

	}

	@When("Clicks on cart button to add product into cart")
	public void clicks_on_cart_button_to_add_product_into_cart() {

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		//Clicks on cart button in wishlist page
		driver.findElement(By.xpath("//*[@title='Add to Cart']")).click();

	}

	@Then("Product will get add into cart")
	public void product_will_get_add_into_cart() {

		//prints the shopping cart is updated text
		System.out.println("Shopping cart is updated");

	}

	@Then("Clicks on remove button to remove item from wish-list")
	public void clicks_on_remove_button_to_remove_item_from_wish_list() {

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		//Clicks on remove button
		driver.findElement(By.xpath("//*[@class=\"btn btn-danger tb_no_text\"]")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//*[@class='alert alert-success']")).isDisplayed());

	}

	@Then("Clicks on continue button and wish-list will get updated")
	public void clicks_on_continue_button_and_wish_list_will_get_updated() {

		//Clicks on continue button
		driver.findElement(By.xpath("//*[@class='pull-right']/a")).click();
		System.out.println("Your wish-list is updated");
		driver.close();

	}


	//site map

	@Given("Navigates to home page by clicking on the home button")
	public void navigates_to_home_page_by_clicking_on_the_home_button() {

		//Clicks on the home button
		driver.findElement(By.xpath("//*[@id='menu_url_F5fG9']/a")).click();

		//Scrolling down
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 1700);");


	}

	@When("Navigates to sitemap page by clicking on sitemap button")
	public void Navigates_to_sitemap_page_by_clicking_on_sitemap_button() {

		//clicks on the sitemap button
		driver.findElement(By.xpath("//*[@class='tb_link tb_menu_system_information_sitemap']")).click();

		Assert.assertEquals("Site map", driver.getTitle());


	}

	@Then("Clicks on sports button to navigate sports product page")
	public void clicks_on_sports_button_to_navigate_sports_product_page() {

		//clicks on the sports button
		driver.findElement(By.xpath("//*[@class='tb_list_1']/li/a")).click();

	}

	@Then("Search for the products")
	public void search_for_the_products() {

		//Enters the product name in search box
		driver.findElement(By.xpath("//*[@id='mfilter-opts-search']")).sendKeys("Ring");

		System.out.println("There are no products to list in this category");

		//wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//clicks on reset all button to reset the page
		driver.findElement(By.xpath("//*[@class='mfilter-button-reset']")).click();

		//navigates back
		driver.navigate().back();

	}

	@Given("Navigates to special offer page by clicking on special offer button")
	public void navigates_to_special_offer_page_by_clicking_on_special_offer_button() {

		//clicks on special offer button 
		driver.findElement(By.xpath("//*[@id=\"System_s3bhXNDb\"]/div/ul[2]/li[1]")).click();

	}

	@Then("It displays the special offer products")
	public void it_displays_the_special_offer_products() {

		System.out.println("Special offer products");

		driver.close();
	}


	//Product page

	@Given("Navigates to home page by clicking on the Home button")
	public void navigates_to_home_page_by_clicking_on_the_home_button1() {

		//Clicks on the home button
		driver.findElement(By.xpath("//*[@id='menu_url_F5fG9']/a")).click();

		//Scrolling down
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 1400);");


	}

	@Then("Clicks on Finger ring product in featured product")
	public void clicks_on_finger_ring_product_in_featured_product() {


		//Storing WebElements of Featured-products WishList Buttons
		List<WebElement> Webele   = driver.findElements(By.xpath("//*[@id='RandomProducts_RoiFQGb2']//div[3]//h4/a"));
		System.out.println(Webele.size());

		//Click on first Product
		Webele.get(1).click();

	}
	
	
	@And("^User Enters the \"([^\"]*)\" and  Delivery \"([^\"]*)\"$")
    public void user_enters_the_something_and_delivery_something(String strArg1, String strArg2) 

	 {

		WebElement r1 = driver.findElement(By.xpath("//*[@name='quantity']"));
		r1.clear();
		r1.sendKeys(strArg1);

		driver.findElement(By.xpath("//*[@name='pincode']")).sendKeys(strArg2);
	}

	@Then("clicks on the wish-list button and Add to cart button")
	public void clicks_on_the_wish_list_button_and_add_to_cart_button() {

		driver.findElement(By.xpath("//*[@class='tb_icon_10 fa-heart']")).click();

		driver.findElement(By.xpath("//*[@id='button-cart']")).click();

	}


	//Review writing page

	@Given("Navigate review writing page by clicking on the write a review button")
	public void navigate_review_writing_page_by_clicking_on_the_write_a_review_button() {

		//clicks on write a review button
		driver.findElement(By.xpath("//*[@class='btn']")).click();

	}

	@Then("Enters name and Review")
	public void enters_name_and_review() {

		//Enters the name and review in the columns
		WebElement a = driver.findElement(By.xpath("//*[@name='name']"));
		a.clear();
		a.sendKeys("Rahul");
		driver.findElement(By.xpath("//*[@id='input-review']")).sendKeys("Good product");

	}

	@Then("gives the rating by clicking radio button")
	public void gives_the_rating_by_clicking_radio_button() {

		//clicks on radio button to give rating
		WebElement radio3 = driver.findElement(By.xpath("//*[@id=\"tbReviewFormWrap\"]//input[5]"));
		radio3.click();

	}

	@Then("clicks on the continue button")
	public void clicks_on_the_continue_button1() {

		//cliks on continue button
		driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
	}


	//verifying the facebook icon 

	@Then("Clicks on facebook icon")
	public void clicks_on_facebook_icon() {

		//using actions clicking on facebook icon
		WebElement fb = driver.findElement(By.xpath("//*[@class='at-icon-wrapper at-share-btn at-svc-facebook']"));

		Actions action = new Actions(driver);
		action.moveToElement(fb).click(fb).pause(3000).build().perform();

		driver.quit();



	}






	///////////////////////////////////////Rahul end/////////////////////////////////




	//@social icon 

	@Given("The user goes to the site")
	public void the_user_goes_to_the_site() 
	{


		//path of the web driver

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Synchronization
		driver.get("http://retailm1.upskills.in/"); //URL of the site
		driver.manage().window().maximize();//maximize the window
	}

	@When("The user scrolls down")
	public void the_user_scrolls_down()
	{
		JavascriptExecutor js= (JavascriptExecutor) driver;//Execution of java script
		js.executeScript("window.scrollBy(0,250)",""); //value to scroll down the page of site

	}


	@When("The user clicks on the social icon")
	public void the_user_clicks_on_the_social_icon() {
		driver.findElement(By.xpath("//*[@target='_blank']")).click(); //driver clicks on the facebook icon

		//window handling of the site

		Set<String>windowhandle=driver.getWindowHandles();
		Iterator<String>it=windowhandle.iterator();
		String parentwindow=it.next();    //parent window is the main site
		String Childwindow=it.next();    // child window is the fb page
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //synchronization
		driver.switchTo().window(parentwindow);   //driver switches to parent window

	}

	@Then("The user should navigate to the respective social media")
	public void the_user_should_navigate_to_the_respective_social_media() {
		System.out.println("Driver navigated to parent window");   //prints the text("Driver navigated to parent window")
		driver.close();

	}

	//@register page 

	@Given("The user navigated to the register page")
	public void the_user_navigated_to_the_register_page() 
	{

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//synchronization
		driver.get("http://retailm1.upskills.in/"); //URL of the site
		driver.manage().window().maximize();//maximize the window

	}

	@When("The user enters the required data")
	public void the_user_enters_the_required_data() {
		WebElement profile;	                //creating web element

		profile=driver.findElement(By.xpath("//*[@class='fa fa-user-o']")); //Xpath to find the profile icon

		Actions action=new Actions(driver);   //Action for the driver to perform

		action.moveToElement(profile).click().build().perform();

	}

	@When("clicks on register button")
	public void clicks_on_register_button() { 

		driver.findElement(By.xpath("//*[@id=\"Menu_Wmt3OMY3\"]/nav/ul/li[2]/a")).click(); //Xpath of the register
		driver.findElement(By.linkText("Register")).click(); //Locator to identify the register

		//procedure to register
		driver.findElement(By.xpath("//*[@name='firstname']")).sendKeys("sreedhar");//first name

		driver.findElement(By.xpath("//*[@name='lastname']")).sendKeys("Reddy");//last name

		driver.findElement(By.xpath("//*[@name='email']")).sendKeys("sreedharreddy2970@gmail.com");//Email

		driver.findElement(By.xpath("//*[@name='telephone']")).sendKeys("871213175");//Phone number

		driver.findElement(By.xpath("//*[@name='address_1']")).sendKeys("1-14");//address-1

		driver.findElement(By.xpath("//*[@name='city']")).sendKeys("gadwal");//city

		//Dropdown list
		WebElement DropdownButton = driver.findElement(By.xpath("//*[@name='country_id']"));//country id
		DropdownButton.click();

		WebElement DropdownOption= driver.findElement(By.xpath("//*[@value='99']"));
		DropdownOption.click();

		WebElement DropdownBox = driver.findElement(By.xpath("//*[@name='zone_id']"));//Zone id
		DropdownBox.click();

		WebElement Dropdownlist= driver.findElement(By.xpath("//*[@value='4231']"));
		Dropdownlist.click();

		//Login credentials
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("sreedhar12");//Password

		driver.findElement(By.xpath("//*[@name='confirm']")).sendKeys("sreedhar12");//Confirm password

		driver.findElement(By.xpath("//*[@id=\"System_nyHsmShk\"]/form/fieldset[4]/div/div/label[1]")).click();

		driver.findElement(By.xpath("//*[@name='agree']")).click(); //Agreement button

		driver.findElement(By.xpath("//*[@type='submit']")).click(); //submit button

		driver.close();

	}

	@Then("It displays registration successful")
	public void it_displays_registration_successful() {

		System.out.println("registration successful"); //Prints the text "registration successful"

		driver.navigate().back(); //driver navigates back to the page 
	}

	//@login page
	
	

    @Given("^The user navigated to \"([^\"]*)\"$")
    public void the_user_navigated_to_something(String strArg1) throws Throwable {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);    //synchronization
		driver.get(strArg1);   //URL of the site
		driver.manage().window().maximize();//maximize the window
    	
    	
    	
    }

    @When("^Enters \"([^\"]*)\" and \"([^\"]*)\"$")
    public void enters_something_and_something(String strArg1, String strArg2) throws Throwable {
    	

		WebElement profile; //creating web element
		profile=driver.findElement(By.xpath("//*[@id='Menu_Wmt3OMY3']/nav/ul/li[2]/a"));//xpath for the profile icon

		Actions action=new Actions(driver);//Action for the driver to perform
		action.moveToElement(profile);

		driver.findElement(By.xpath("//*[@class='fa fa-user-o']")).click();  //path to click on the Login/Register page

		driver.findElement(By.xpath("//*[@id='input-email']")).sendKeys(strArg1);  //sending the key in e-mail box

		driver.findElement(By.xpath("//*[@name='password']")).sendKeys(strArg2); //sending the key in password
		driver.findElement(By.xpath("//*[@value='Login']")).click();//click on login
    
    }
	
	

	/*@Given("The user navigated to Loginpage")
	public void the_user_navigated_to_Loginpage() {
		//Path to initialize the driver

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);    //synchronization
		driver.get("http://retailm1.upskills.in/");    //URL of the site
		driver.manage().window().maximize();//maximize the window

	}

	@When("Enters <email-address> and <password>")
	public void enters_email_address_and_password() {

		WebElement profile; //creating web element
		profile=driver.findElement(By.xpath("//*[@id='Menu_Wmt3OMY3']/nav/ul/li[2]/a"));//xpath for the profile icon

		Actions action=new Actions(driver);//Action for the driver to perform
		action.moveToElement(profile);

		driver.findElement(By.xpath("//*[@class='fa fa-user-o']")).click();  //path to click on the Login/Register page

		driver.findElement(By.xpath("//*[@id='input-email']")).sendKeys("sreedharreddy2970@gmail.com");  //sending the key in e-mail box

		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("Sreedhar@12"); //sending the key in password

	}*/

	@Then("click login")
	public void clik_login() {
		driver.findElement(By.xpath("//*[@value='Login']")).click();  //path to click on login
		System.out.println("user logged in to the site");
		driver.close();  // driver navigates back 

	}



	//@invalid credentials 

	@Given("The user navigated to loginpage")
	public void the_user_navigated_to_loginpage()
	{

		System.setProperty("webdriver.chrome.driver", "C:\\Training\\Selenium\\chromedriver_win32\\chromedriver.exe"); //driver path
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//synchronization
		driver.get("http://retailm1.upskills.in/");  //URL of the site

	}

	@When("Enters <invalid email-address> and <password>")
	public void enters_invalid_email_address_and_password() {
		WebElement profile;	//creating web element profile
		profile=driver.findElement(By.xpath("//*[@id='Menu_Wmt3OMY3']/nav/ul/li[2]/a")); //path of the profile

		Actions action=new Actions(driver); //Action for the driver
		action.moveToElement(profile);

		driver.findElement(By.xpath("//*[@class='fa fa-user-o']")).click(); //path to click on the profile icon
		driver.findElement(By.xpath("//*[@id='input-email']")).sendKeys("sreedharreddy@gmail.com"); //E-mail
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("sreedhar12");//Password



	}

	@Then("click on login")
	public void click_on_login() {
		driver.findElement(By.xpath("//*[@value='Login']")).click();//click on login
		Assert.assertTrue(driver.findElement(By.xpath("//*[@class='alert alert-danger']")).isDisplayed());
		System.out.println("Enter a valid email/password");//Prints "enter a valid email id"
		driver.navigate().back();//navigates back to the site

	}

	//Forgotpassword

	@Given("customer navigate to the login page")
	public void customer_navigate_to_the_login_page() {

		System.setProperty("webdriver.chrome.driver", "C:\\Training\\Selenium\\chromedriver_win32\\chromedriver.exe"); //driver path
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//synchronization
		driver.get("http://retailm1.upskills.in/");  //site URL
		driver.manage().window().maximize();//maximize the window

		WebElement profile;	//Declaring web element
		profile=driver.findElement(By.xpath("//*[@id='Menu_Wmt3OMY3']/nav/ul/li[2]/a"));//path for the profile
		Actions action=new Actions(driver);
		action.moveToElement(profile);
		driver.findElement(By.xpath("//*[@class='fa fa-user-o']")).click();//click on the icon

	}

	@When("customer enters the credentials")
	public void customer_enters_the_credentials() {

		driver.findElement(By.xpath("//*[@id='input-email']")).sendKeys("sreedharreddy2970@gmail.com");//Sending key email
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("Sreedhar");//sending pasword


	}

	@When("it displays the wrong password")
	public void it_displays_the_wrong_password() {
		driver.findElement(By.xpath("//*[@value='Login']")).click();//click on the login button
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Enter a valid email/password");//prints Enter a valid email/password
	}

	@When("the user clicks on the forgot password")
	public void the_user_clicks_on_the_forgot_password() {
		WebElement ForgottenPassword = driver.findElement(By.linkText("Forgotten Password"));
		Actions actions =new Actions(driver);
		actions.moveToElement(ForgottenPassword).click().perform();
		driver.findElement(By.xpath("//*[@id='input-email']")).sendKeys("sreedharreddy2970@gmail.com");//Enters a email id
		driver.findElement(By.xpath("//*[@type='submit']")).click();//click on the continue button

	}

	@Then("The user will receive a link to email to reset password")
	public void The_user_will_receive_a_link_to_email_to_reset_password() {
		Assert.assertTrue(driver.findElement(By.xpath("//*[@class='alert alert-success']")).isDisplayed());
		System.out.println("confirmation link has been sent to email");//prints the text
		System.out.println("Defect:Link has not been sent to Email");
		driver.close();//close the page
	}



	//product page

	/*@Given("The user opens the site")
	public void the_user_opens_the_site() {
		System.setProperty("webdriver.chrome.driver", "C:\\Training\\Selenium\\chromedriver_win32\\chromedriver.exe"); //driver path
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://retailm1.upskills.in/");  //site url
		driver.manage().window().maximize();//maximize the window
	}


	@When("The user login with the credentials")
	public void the_user_login_with_the_credentials() {
		WebElement profile;	//Declaring the web element
		profile=driver.findElement(By.xpath("//*[@id='Menu_Wmt3OMY3']/nav/ul/li[2]/a"));//Path of the profile
		Actions action=new Actions(driver);//Actions to perform
		action.moveToElement(profile);
		driver.findElement(By.xpath("//*[@class='fa fa-user-o']")).click();
		driver.findElement(By.xpath("//*[@id='input-email']")).sendKeys("sreedharreddy2970@gmail.com");//email
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("sreedhar12");//password
		driver.findElement(By.xpath("//*[@value='Login']")).click();//clicking the login button
		driver.navigate().back();//navigate back to the button

	}*/

	@When("The user clicks on the feautred product item")
	public void the_user_clicks_on_the_feautred_product_item() {
		driver.findElement(By.xpath("//*[@id='menu_url_F5fG9']")).click();
		driver.findElement(By.linkText("Engagement Ring")).click();
		driver.findElement(By.xpath("//*[@id=\"ProductReviewsSystem_LP2NU8bj\"]/div[2]/a")).click();
		driver.findElement(By.xpath("//*[@name='name']")).sendKeys("sreedhar");
		driver.findElement(By.xpath("//*[@rows='5']")).sendKeys("Product quality is good");
		driver.findElement(By.xpath("//*[@value='5']")).click();
		driver.findElement(By.xpath("//*[@id='button-review']")).click();
		System.out.println("review is written");
		driver.findElement(By.xpath("#button-cart")).click();
	}

	@When("The item should be added to cart")
	public void the_item_should_be_added_to_cart() {
		System.out.println("Item added to cart successfully");

	}

	@Then("The cart should be displyed")
	public void the_cart_should_be_displyed() {
		driver.navigate().back();

	}



	//@navigatebtn


	@Given("Customer opens the site scrools down")
	public void customer_opens_the_site_scrools_down() {
		System.setProperty("webdriver.chrome.driver", "C:\\Training\\Selenium\\chromedriver_win32\\chromedriver.exe"); //driver path
		driver = new ChromeDriver();
		driver.get("http://retailm1.upskills.in/");  //site URL
		driver.manage().window().maximize();
		JavascriptExecutor js= (JavascriptExecutor) driver;//Execution of java script
		js.executeScript("window.scrollBy(0,300)","");  //value to scroll down the page of site
	}




	@When("Test the functionality of navigate buttons")
	public void test_the_functionality_of_navigate_buttons() {

		//About us
		driver.findElement(By.xpath("//*[@class='tb_link tb_menu_page_4']")).click();//Path to click on the about us
		System.out.println("Driver navigated to About us page");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);//synchronization
		driver.navigate().back();//navigate back to the page

		//Delivery information
		driver.findElement(By.xpath("//*[@class='tb_link tb_menu_page_6']")).click();//Path to click on the delivery information
		System.out.println("Driver navigated to Delivery information page");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);//synchronization
		driver.navigate().back();//navigate back to the page

		//Privacy and policy
		driver.findElement(By.xpath("//*[@class='tb_link tb_menu_page_3']")).click();//Path to click on the privacy and policy
		System.out.println("Driver navigated to Privacy and policy page");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);//synchronization
		driver.navigate().back();//navigate back to the page

		//Terms & conditions
		driver.findElement(By.xpath("//*[@class='tb_link tb_menu_page_5']")).click();//Path to click on the terms and conditions
		System.out.println("Driver navigated to terms and conditions page");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);//synchronization
		driver.navigate().back();//navigate back to the page

		//My Account
		driver.findElement(By.xpath("//*[@class='tb_link tb_menu_system_account_wishlist']")).click();//Path to click on the wishlist
		System.out.println("Driver navigated to wishlist page");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);//synchronization
		driver.navigate().back();//navigate back to the page

		//News letter
		driver.findElement(By.xpath("//*[@class='tb_link tb_menu_system_account_newsletter']")).click();//Path to click on the newsletter
		System.out.println("Driver navigated to newsletter page");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);//synchronization
		driver.navigate().back();//navigate back to the page

		//Services
		driver.findElement(By.xpath("//*[@class='tb_link tb_menu_system_account_return']")).click();//Path to click on the Product return
		System.out.println("Driver.navigated to product return page");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);//synchronization
		driver.navigate().back();//navigate back to the page

		//Site Map
		driver.findElement(By.xpath("//*[@class='tb_link tb_menu_system_information_sitemap']")).click();//Path to click on the Site Map
		System.out.println("driver navigated to Sitemap");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);//synchronization
		driver.navigate().back();//navigate back to the page


	}

	@Then("come back to main page")
	public void  come_back_to_main_page()

	{
		driver.close();//close the driver

	}

    

	//@My orders page
	

	/*@Given("the user login in to the page")
	public void the_user_login_in_to_the_page() {
		System.setProperty("webdriver.chrome.driver", "C:\\Training\\Selenium\\chromedriver_win32\\chromedriver.exe"); //driver path
		driver = new ChromeDriver();
		driver.get("http://retailm1.upskills.in/");  //site URL
		driver.manage().window().maximize();//Maximize the window

		WebElement profile;	//Declaring the web element profile
		profile=driver.findElement(By.xpath("//*[@class='fa fa-user-o']"));//Action on the profile icon
		Actions action=new Actions(driver);
		action.moveToElement(profile).click().build().perform();

		//sign in to the site using below credentials
		driver.findElement(By.xpath("//*[@id='input-email']")).sendKeys("sreedharreddy2970@gmail.com");
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("Sreedhar@12");
		driver.findElement(By.xpath("//*[@value='Login']")).click();
	}*/




	@When("My account and My orders page will be displayed")
	public void my_account_and_my_orders_page_will_be_displayed() {

		System.out.println("My account and my orders page is displyed");
	}

	@When("click on the list of text available and check them")
	public void click_on_the_list_of_text_available_and_check_them() {

		//user clicks on order history
		driver.findElement(By.linkText("View your order history")).click();
		driver.findElement(By.linkText("Continue")).click();//click on continue

		//user clicks on Downloads
		driver.findElement(By.linkText("Downloads")).click();
		driver.findElement(By.linkText("Continue")).click();//click on continue

		//user clicks on Reward points
		driver.findElement(By.linkText("Your Reward Points")).click();
		driver.findElement(By.linkText("Continue")).click();//click on continue

		//user clicks on View your return requests
		driver.findElement(By.linkText("View your return requests")).click();
		driver.findElement(By.linkText("Continue")).click();//click on continue

		//user clicks on Your transactions
		driver.findElement(By.linkText("Your Transactions")).click();
		driver.findElement(By.linkText("Continue")).click();//click on continue

		//Recurring payments
		driver.findElement(By.linkText("Recurring payments")).click();
		driver.findElement(By.linkText("Continue")).click();
		//click on continue

	}

	@Then("Navigate back")
	public void navigate_back() { 

		System.out.println("Lists available under my orders are checked");

		driver.close();//closes the driver


	}


	//@navigatebtn


	@Given("Customer opens the site and scrools down")
	public void customer_opens_the_site_and_scrools_down() {
		System.setProperty("webdriver.chrome.driver", "C:\\Training\\Selenium\\chromedriver_win32\\chromedriver.exe"); //driver path
		driver = new ChromeDriver();
		driver.get("http://retailm1.upskills.in/");  //site URL
		driver.manage().window().maximize();
		JavascriptExecutor js= (JavascriptExecutor) driver;//Execution of java script
		js.executeScript("window.scrollBy(0,300)","");  //value to scroll down the page of site
	}




	@When("Tests the functionality of navigate buttons")
	public void tests_the_functionality_of_navigate_buttons() {

		//About us
		driver.findElement(By.xpath("//*[@class='tb_link tb_menu_page_4']")).click();//Path to click on the about us
		Assert.assertTrue(driver.findElement(By.xpath("//*[@class='tb_link tb_menu_page_4']")).isDisplayed());
		System.out.println("Driver navigated to About us page");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);//synchronization
		driver.navigate().back();//navigate back to the page

		//Delivery information
		driver.findElement(By.xpath("//*[@class='tb_link tb_menu_page_6']")).click();//Path to click on the delivery information
		Assert.assertTrue(driver.findElement(By.xpath("//*[@class='tb_link tb_menu_page_6']")).isDisplayed());
		System.out.println("Driver navigated to Delivery information page");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);//synchronization
		driver.navigate().back();//navigate back to the page

		//Privacy and policy
		driver.findElement(By.xpath("//*[@class='tb_link tb_menu_page_3']")).click();//Path to click on the privacy and policy
		Assert.assertTrue(driver.findElement(By.xpath("//*[@class='tb_link tb_menu_page_3']")).isDisplayed());
		System.out.println("Driver navigated to Privacy and policy page");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);//synchronization
		driver.navigate().back();//navigate back to the page

		//Terms & conditions
		driver.findElement(By.xpath("//*[@class='tb_link tb_menu_page_5']")).click();//Path to click on the terms and conditions
		Assert.assertTrue(driver.findElement(By.xpath("//*[@class='tb_link tb_menu_page_5']")).isDisplayed());
		System.out.println("Driver navigated to terms and conditions page");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);//synchronization
		driver.navigate().back();//navigate back to the page

		//My Account
		driver.findElement(By.xpath("//*[@class='tb_link tb_menu_system_account_wishlist']")).click();//Path to click on the wishlist
		Assert.assertTrue(driver.findElement(By.xpath("//*[@class='tb_link tb_menu_system_account_wishlist']")).isDisplayed());
		System.out.println("Driver navigated to wishlist page");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);//synchronization
		driver.navigate().back();//navigate back to the page

		//News letter
		driver.findElement(By.xpath("//*[@class='tb_link tb_menu_system_account_newsletter']")).click();//Path to click on the news letter
		Assert.assertTrue(driver.findElement(By.xpath("//*[@class='tb_link tb_menu_system_account_newsletter']")).isDisplayed());
		System.out.println("Driver navigated to newsletter page");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);//synchronization
		driver.navigate().back();//navigate back to the page

		//Services
		driver.findElement(By.xpath("//*[@class='tb_link tb_menu_system_account_return']")).click();//Path to click on the Product return
		Assert.assertTrue(driver.findElement(By.xpath("//*[@class='tb_link tb_menu_system_account_return']")).isDisplayed());
		System.out.println("Driver.navigated to product return page");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);//synchronization
		driver.navigate().back();//navigate back to the page

		//Site Map
		driver.findElement(By.xpath("//*[@class='tb_link tb_menu_system_information_sitemap']")).click();//Path to click on the Site Map
		Assert.assertTrue(driver.findElement(By.xpath("//*[@class='tb_link tb_menu_system_information_sitemap']")).isDisplayed());
		System.out.println("driver navigated to Sitemap");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);//synchronization
		driver.navigate().back();//navigate back to the page


	}

	@Then("user come back to main page")
	public void user_come_back_to_main_page()

	{
		driver.close();//close the driver

	}






	/////////////////////////////Sreedhar End///////////////////////////




	//Initiate Base class Object
	//Base b=new Base();
	WebDriver driv;
	List<WebElement> Webele,Tr,Tc;
	int TR,TC,i,j,Ub,Ran;
	String PW,CW;
	Set<String> Wh;
	WebElement Tb,Temp;
	// public Select Sel;
	String url1="http://retailm1.upskills.in/";


	//@functionality
	@Given("Login with user Credentials")
	public void Login() throws Throwable {



		//Initialize the driver
		System.setProperty("webdriver.chrome.driver","C:\\G-Driver\\chromedriver.exe");
		driv=new ChromeDriver();


		driv.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Go to the URL given
		driv.get(url1);

		//maximize the window
		driv.manage().window().maximize();

		//Click on User Icon
		driv.findElement(By.xpath("//*[@class='fa fa-user-o']")).click();

		//Login
		driv.findElement(By.xpath("//*[@name='email']")).sendKeys("rahulpadma999@gmail.com");
		driv.findElement(By.xpath("//*[@name='password']")).sendKeys("Reddy@108");
		driv.findElement(By.xpath("//*[@value='Login']")).click();	

	}


	@When("user adds item to the wish-list")
	public void items_to_wish_list() throws Throwable {

		//Back to Home page
		driv.findElement(By.xpath("//*[@id='menu_url_F5fG9']/a")).click();    

		//JavaScript to Scroll the Web-page by 1600 pixels along Y-axis
		JavascriptExecutor jg=(JavascriptExecutor) driv;
		jg.executeScript("window.scrollBy(0,1600)");

		//Storing WebElements of Featured-products WishList Buttons
		Webele= driv.findElements(By.xpath("//*[@class='tb_button_wishlist tb_pos_b btn-sm tb_no_text']"));
		System.out.println(Webele.size());

		//Click on first Product
		Webele.get(1).click();

	}

	@When("Message when items added")
	public void message_for_wishlist() throws Throwable {

		//Printing Message When Items added
		System.out.println(driv.findElement(By.xpath("/html/body/ul")).getText());

	}

	@Then("User clicks on wishlist icon")
	public void user_clicks_on_wishlist_icon() {

		//Click on wishList button Using Actions 
		driv.navigate().refresh();
		driv.findElement(By.xpath("//*[@class='ico-linea-basic-heart']")).click();
		//ActionInit().moveToElement(el).click().build().perform();

	}

	@Then("Content is displayed")
	public void content_is_displayed() {

		//Print the Item details
		Tr=driv.findElements(By.xpath("//*[@class='table table-hover']/tbody/tr"));
		Tc=driv.findElements(By.xpath("//*[@class='table table-hover']/thead/tr/td"));
		TC=Tc.size()-2;
		TR=Tr.size();
		for(i=0;i<TR;i++)
			for(j=0;j<TC;j++)
			{
				System.out.println(driv.findElement(By.xpath("//*[@class='table table-hover']/tbody/tr["+i+"]/td["+j+"]")));
			}
		System.out.println(TR);

	}

	@Then("Wishlist content when empty")
	public void wishlist_content_when_empty() {

		//Print the Content when WishList is Empty
		System.out.println(driv.findElement(By.xpath("//*[@class=\"tb_empty\"]")).getText());

		//Closing the browser
		driv.close();
	}

	@When("Click on Item-remove button")
	public void click_on_remove_button() {

		//Click on Remove 
		Webele = driv.findElements(By.xpath("//*[@class='btn btn-danger tb_no_text']"));
		System.out.println(Webele.size());
		Webele.get(1).click();
	}

	@Then("Item is Removed")
	public void item_is_removed() {

		//Message When Removed
		System.out.println(driv.findElement(By.xpath("//div[@class='alert alert-success']")).getText()); 

		//Close the Browser
		driv.close();
	}

	@When("user clicks on Cart Icon")
	public void user_clicks_on_cart_icon() {

		//Click on cart icon 
		Webele = driv.findElements(By.xpath("//*[@class=\"btn btn-primary tb_no_text\"]"));
		System.out.println(Webele.size());
		Webele.get(1).click();
	}

	@Then("Items Must be added to cart")
	public void items_must_be_added_to_cart() {

		//Message when Added to cart 
		System.out.println(driv.findElement(By.xpath("//*[@class='noty_text']")).getText());

		//Close the Browser
		driv.close();
	}

	@Given("^Login with user credentials$")      //function for Login
	public void login_with_user_credentials() throws Throwable  {

		//Initialize the driver with ChromeDriver
		//driv=b.initialize();

		//Implicit wait by 10 Seconds
		driv.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);


		//Get URL using Driver
		driv.get(url1);

		//maximize the window  
		driv.manage().window().maximize();

		//Click on user Icon
		driv.findElement(By.xpath("//*[@class='fa fa-user-o']")).click();

		//Login
		driv.findElement(By.xpath("//*[@name='email']")).sendKeys("rahulpadma999@gmail.com");
		driv.findElement(By.xpath("//*[@name='password']")).sendKeys("Reddy@108");
		driv.findElement(By.xpath("//*[@value='Login']")).click();	

	}

	@Then("^Click on Cart Icon$")
	public void click_on_cart_icon()  {

		String carturl = "http://retailm1.upskills.in/checkout/cart";

		//Click on Cart Icon
		driv.findElement(By.xpath("//*[@class='tb_icon ico-linea-ecommerce-bag']")).click();
		Assert.assertEquals(carturl,driv.getCurrentUrl());
	}

	@Given("^Items are in the Cart$")
	public void items_in_the_cart()   {

		//Print the Item Details in the cart

		//No. of Rows
		Tr=driv.findElements(By.xpath("//*[@class='cart-info tb_min_w_500']/table/tbody/tr"));
		TR=Tr.size();

		//No. of Columns
		Tc=driv.findElements(By.xpath("//*[@class='cart-info tb_min_w_500']/table/thead/tr/td"));
		TC=Tc.size();

		for(int j=1;j<TR;j++)
		{
			for(int i=2;i<TC;i++) 
			{   
				if(i!=5)
				{
					System.out.println(driv.findElement(By.xpath("//*[@class='cart-info tb_min_w_500']/table/tbody/tr["+j+"]/td["+i+"]")).getText());
				}
			}
		}      

	}
	@And("^Enter Coupon Code$")
	public void enter_coupon_code()  {

		//Click on Enter Coupon
		driv.findElement(By.xpath("//*[@id='accordion']/div[1]/div[1]//i")).click();

		//Given Coupon Code in the Box & Click on Apply
		driv.findElement(By.xpath("//*[@id='input-coupon']")).sendKeys("RETAIL50");
		driv.findElement(By.xpath("//*[@id='button-coupon']")).click();

		//Print the Message when Coupon Code is Added 
		System.out.println(driv.findElement(By.xpath("//*[@id='System_V2Exp1o9']/div[1]")).getText());

		//Print the Total After Applying Coupon Code
		System.out.println(driv.findElement(By.xpath("//*[@class='cart-total']")).getText()+"\n");
	}

	@And("^Enter Country Pincode State$")
	public void enter_country_pincode_state() {

		//Refresh the Page to load
		driv.navigate().refresh();

		//Given Country,Region,PinCode
		driv.findElement(By.xpath("//*[@id='accordion']/div[2]/div[1]/h4/a/i")).click();
		Temp=driv.findElement(By.xpath("//*[@name='country_id']"));

		//Selecting Country,Region in drop-down using Select
		Select Sel;
		Sel = new Select(Temp);
		Sel.selectByVisibleText("India");
		Temp=driv.findElement(By.xpath("//*[@name='zone_id']"));
		Sel = new Select(Temp);
		Sel.selectByVisibleText("Telangana");
		Tb=driv.findElement(By.xpath("//*[@name='postcode']"));

		//Clear the text box
		Tb.clear();
		Tb.sendKeys("506009");

		//Click on Get-Quotes
		driv.findElement(By.xpath("//*[@id='button-quote']")).click();

		//Click on free-Shipping & apply
		driv.findElement(By.xpath("//*[@id='shipping_quote']/div/label")).click();
		driv.navigate().refresh();
	}

	@And("^Enter GiftCertificate$")
	public void enter_giftcertificate() {

		//Refresh the page
		driv.navigate().refresh();

		//Click on Apply Gift certificate & enter the Code
		driv.findElement(By.xpath("//*[@id=\"accordion\"]/div[3]/div[1]/h4/a/i")).click();
		driv.findElement(By.xpath("//*[@id='input-voucher']")).sendKeys("RETAIL50");
		driv.findElement(By.xpath("//*[@id='button-voucher']")).click();

		//Message after the gift certificate
		System.out.println(driv.findElement(By.xpath("//*[@id='System_V2Exp1o9']/div[1]")).getText());

		//Cart Total After Applying Gift-certificate 
		System.out.println(driv.findElement(By.xpath("//*[@class='cart-total']")).getText());
	}

	@When("^Click on CheckOut$")
	public void click_on_checkout()   {

		//Click on Check-out
		driv.findElement(By.xpath("//*[@id='System_V2Exp1o9']/div[4]/div[2]/a")).click();
	}


	@And("^Enter Billing & Delivery Address$")
	public void enter_billing_delivery_address()  {

		//Click on Apply billing,delivery,Payment Addresses
		driv.findElement(By.xpath("//*[@id='collapse-payment-address']/div/div[1]/label/input")).click();
		driv.findElement(By.xpath("//*[@id='button-payment-address']")).click();
		driv.findElement(By.xpath("//*[@id='button-shipping-address']")).click();
	}

	@And("^Select Delivery Method$")
	public void select_delivery_method()  {

		//Select the Delivery Method & Give Comments
		driv.findElement(By.xpath("//*[@name='comment']")).sendKeys("Please deliver in time period from 9:00A.M - 18:00P.M");
		driv.findElement(By.xpath("//*[@id='button-shipping-method']")).click();
	}

	@And("^Select Payment Method$")
	public void select_payment_method()  {

		//Select Payment method
		driv.findElement(By.xpath("//*[@id='collapse-payment-method']/div/div[1]//label/input")).click();

	}

	@And("^Accept Terms & Conditions$")
	public void accept_terms_conditions()  {

		//Accept Terms & Conditions 
		driv.findElement(By.xpath("//*[@class='checkbox']/input")).click();
		driv.findElement(By.xpath("//*[@id='button-payment-method']")).click();
	}

	@Then("^Display the details$")
	public void display_the_details() throws Throwable {

		//Print the Items Details
		Tr=driv.findElements(By.xpath("//*[@id='collapse-checkout-confirm']//table/tbody/tr"));
		TR=Tr.size();
		Tc=driv.findElements(By.xpath("//*[@id='collapse-checkout-confirm']//table/thead/tr/td"));
		TC=Tc.size();
		for(int i=1;i<TR;i++)
		{
			for(int j=1;j<TC;j++)
			{
				System.out.println(driv.findElement(By.xpath("//*[@id='collapse-checkout-confirm']//table/tbody/tr["+i+"]/td["+j+"]")).getText());
			}
		}
		System.out.println(driv.findElement(By.xpath("//*[@class='table']//tfoot/tr[4]/td[2]")).getText());
		System.out.println(driv.findElement(By.xpath("//*[@class='table']//tfoot/tr[4]/td[3]")).getText());


	} 

	@And("^Click on confirm$")
	public void click_on_confirm() {

		//Click on Confirm
		driv.findElement(By.xpath("//*[@value='Confirm Order']")).click();

		//Message After Confirming the order
		System.out.println(driv.findElement(By.xpath("//*[@id='System_s3bhXNDb']/div[1]")).getText());

		//Click on Continue Shopping
		driv.findElement(By.xpath("//*[@id='System_s3bhXNDb']/div[2]/div/a")).click();

	}

	@Given("^Click on Home page$")
	public void home_page() throws Throwable  {

		//Click on Home Page
		driv.navigate().refresh();	
		driv.findElement(By.xpath("//*[@id='menu_url_F5fG9']/a/span")).click();	

	}

	@And("^Click on a product$")
	public void a_product()  {


		driv.findElement(By.xpath("//*[@id='menu_url_F5fG9']/a")).click();    

		//Scroll down the WebPage By 1600pixels in y-axis
		JavascriptExecutor jg=(JavascriptExecutor) driv;
		jg.executeScript("window.scrollBy(0,1600)");

		//Click on random Item

		//Elements of the Items Present
		Webele= driv.findElements(By.xpath("//*[@id='RandomProducts_RoiFQGb2']//h4/a"));

		//Size of the Elements
		System.out.println(Webele.size());
		Random ran = new Random();
		Ub=Webele.size();

		//Generate a Random Number
		Ran=ran.nextInt(Ub);
		/*b.Webele.get(1).click();
 		System.out.println(driv.findElement(By.xpath("/html/body/ul")).getText());*/
		driv.findElement(By.xpath("//*[@id=\"RandomProducts_RoiFQGb2\"]//div["+Ran+"]//h4/a")).click();	

	}

	@And("^check the Availability$")
	public void check_the_availability()  {

		//Print the Availability   	
		System.out.println(driv.findElement(By.xpath("//*[@id='ProductInfoSystem_IcyE9WlD']//dd[1]")).getText());

	}

	@And("^Increase the quantity$")
	public void increase_the_quantity()  {

		//Increase the Quantity By 1
		driv.findElement(By.xpath("//*[@id='ProductAddToCartSystem_C8WkgNNi']/div[2]//button[1]/i")).click();

	}


	@When("^Click on add to cart$")
	public void click_on_add_to_cart()  {

		//Refresh the Page by & add the Item to the cart
		driv.navigate().refresh();
		driv.findElement(By.xpath("//*[@id='button-cart']")).click();

	}

	@Then("^Items added$")
	public void items_added()  {

		//Message When Item Added
		System.out.println(driv.findElement(By.xpath("//*[@id='noty_alert_1637379459525']/div/div[1]/div/p")).getText());

	}  

	@Given("^Login with credentials$")      //function for Login
	public void login_Return() throws Throwable  {

		//Initialize the driver with ChromeDriver
		//driv=b.initialize();

		driv.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		String mainurl="http://retailm1.upskills.in/";

		driv.get(url1);

		//Assertion of MainURL with CurrentURl
		Assert.assertEquals(mainurl,driv.getCurrentUrl());

		//Maximize the window
		driv.manage().window().maximize();  //Maximize the window

		//Click on User Icon
		driv.findElement(By.xpath("//*[@class='fa fa-user-o']")).click(); //click on User Icon

		//Login with Credentials
		driv.findElement(By.xpath("//*[@name='email']")).sendKeys("rahulpadma999@gmail.com");
		driv.findElement(By.xpath("//*[@name='password']")).sendKeys("Reddy@108");
		driv.findElement(By.xpath("//*[@value='Login']")).click();	

	}


	@Given("^Click on My order history$")
	public void click_on_my_order_history()  {

		//Click on My oreder history
		driv.findElement(By.xpath("//*[@id='System_nyHsmShk']/ul/li[1]/a")).click();

	}

	@And("^Click on Order Information$")
	public void click_on_order_information()  {

		//click on Order info.
		driv.findElement(By.xpath("//*[@id='System_s3bhXNDb']/div[1]/table/tbody/tr/td[7]/a/i")).click();

	}

	@And("^CLick on return button$")
	public void click_on_return_button() {

		//Click on Return 
		driv.findElement(By.xpath("//*[@id='System_s3bhXNDb']//tbody/tr[1]/td[6]/a[2]")).click();

	}

	@And("^Enter the Details for Return$")
	public void enter_the_details_for_return() {

		//option of Fault	    	
		driv.findElement(By.xpath("//*[@id='return_request_form']//div[4]/div/div[2]//input")).click();

		//package is open or not
		driv.findElement(By.xpath("//*[@id='return_request_form']//div[5]/div/label[1]")).click();

		//Give Comments
		driv.findElement(By.xpath("//*[@id='input-comment']")).sendKeys("The Item was broken");	    	

	}

	@Then("^Click on Submit$")
	public void click_on_submit()  {

		//Submit
		driv.findElement(By.xpath("//*[@id='return_request_form']/div//input")).click();

		//Text after Submit 
		System.out.println(driv.findElement(By.xpath("//*[@id='System_s3bhXNDb']/div[1]/p[1]")).getText());
		System.out.println(driv.findElement(By.xpath("//*[@id='System_s3bhXNDb']/div[1]/p[2]")).getText());

		//Close the window
		driv.close();
	}


	@Then("^display the Orders$")
	public void display_the_orders() throws Throwable {

		//Get the order information
		System.out.println(driv.findElement(By.tagName("table")).getText());


	}

	@And("^Click on Continue$")
	public void click_on_continue() throws Throwable {

		//Get Back to My account
		driv.findElement(By.xpath("//*[@id='System_s3bhXNDb']/div/div[2]/div/a")).click();
		driv.findElement(By.xpath("//*[@id='System_s3bhXNDb']/div[3]/div/a")).click();
		driv.close();
	}


	//***************************************************************************************************************************************************\\
	//     ******************************************* Admin page Starts From here **************************************************
	//***************************************************************************************************************************************************\\

	//*****************************************************************************************************************************************************\\
	//     ******************************************* WebPage Functionalities starts orm here ******************************************************
	//*****************************************************************************************************************************************************\\


	// valid and invalid url

	@Given("Valid and Invalid url")
	public void valid_and_invalid_url() throws IOException
	{
		driver.get("http://retailm1.upskills.in/adm8998u");
	}

	@When("comparing correct and incorrect url")
	public void comparing_correct_and_incorrect_url()
	{
		// here we get all the url's openend in window and we'll compare them
		enteredurl = driver.getCurrentUrl();

		correcturl = "http://retailm1.upskills.in/admin/";
	}

	@Then("valid url is detected")
	public void valid_url_is_detected()
	{
		// here we can find the correct url

		//Assert.assertEquals(correcturl,enteredurl);

		if(enteredurl.equals(correcturl))

			System.out.println("Correct url is opened");
		else

			System.out.println("incorrect url is opened");
	}

	//login  also used in background

	@Given("admin page login")
	public void admin_page_login() throws IOException
	{
		driver.get("http://retailm1.upskills.in/admin/");   // admin page url

		driver.findElement(By.id("input-username")).sendKeys("admin");  // username

		driver.findElement(By.id("input-password")).sendKeys("admin@123");  //password

		driver.findElement(By.xpath("//*[@id=\"content\"]//button")).click();  // click on login

		System.out.println("Logged in");
	}

	//credentials
	@Given("user at login page")
	public void user_at_login_page() throws IOException
	{
		//open login page
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://retailm1.upskills.in/admin/");

		System.out.println("login page opened");
	}

	@When("^enters  (.*) and (.*)$")
	public void enters_username_and_password(String username,String password) 
	{
		//enters valid and invalid for username and password 

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("input-username")).sendKeys(this.username=username);

		driver.findElement(By.id("input-password")).sendKeys(this.password=password);

		System.out.println(username); System.out.println(password);

	}

	@Then("click admin login")
	public void click_admin_login()
	{
		driver.findElement(By.xpath("//*[@id=\"content\"]//button")).click();  //login button
	}

	// forgot password

	@When("User clicks forget password")
	public void user_clicks_forget_password()
	{
		driver.findElement(By.xpath("//*[@id=\"content\"]//a ")).click();  // clicked on forgot password button

		System.out.println("clicked on forget password button");
	}

	@And("User enters email-id")
	public void user_enters_email_id() 
	{
		// enter email for recovering password
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement emailbox = driver.findElement(By.id("input-email"));

		action.moveToElement(emailbox).click(emailbox).sendKeys("testing@gmail.com").build().perform();

		System.out.println("enter email for recovering password");
	}

	@Then("clicks on Reset")
	public void clicks_on_reset()
	{
		// after enter email click on reset
		driver.findElement(By.xpath("//*[@id='content']//button")).click();

		System.out.println("reset button clicked");
	}

	//functionality and visibility

	@When("finding the icons")
	public void finding_the_icons()
	{
		// finding the elements for visibility
		notifications = driver.findElement(By.xpath("//*[@id='header']//li[1]/a/i"));  //notifications

		home = driver.findElement(By.xpath("//*[@id='header']//li[2]//i"));   // home

		logout = driver.findElement(By.xpath("//*[@id='header']//li[4]//i")); //logout
	}

	@Then("visibility")
	public void visibility() 
	{
		notifications = driver.findElement(By.xpath("//*[@id='header']//li[1]/a/i"));  //notifications

		home = driver.findElement(By.xpath("//*[@id='header']//li[2]//i"));   // home

		logout = driver.findElement(By.xpath("//*[@id='header']//li[4]//i")); //logout

		System.out.println("notifications is visibile "+notifications.isDisplayed());

		System.out.println("home is visible " +home.isDisplayed());

		System.out.println("logout is visible "+logout.isDisplayed());
	}

	//now we will test Functionality of buttons which are visible

	@And("click on notification and home button")
	public void click_notification_and_home_button()
	{
		//clicks on notification and  home button  

		action.moveToElement(notifications).click(notifications).moveToElement(home).click(home).build().perform();
	}

	@When("under home dropdown select retail")
	public void show() 
	{
		//clicks on retail under home drop down

		driver.findElement(By.xpath("//*[@id='header']//ul//li[2]//ul//li[2]//a")).click();
	}

	@Then("Retail customer webpage is opened")
	public void retail_customer_webpage_is_opened() 
	{
		//retail webpage is opened

		windowhandle = driver.getWindowHandles();
		Iterator<String> it = windowhandle.iterator();

		parentwindow = (String) it.next();

		childwindow = (String) it.next();

		driver.switchTo().window(childwindow);

		searchbox = driver.findElement(By.id("filter_keyword"));

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		action.moveToElement(searchbox).click(searchbox).pause(2000).sendKeys("bag").sendKeys(Keys.ENTER).pause(2000)
		.build().perform();
	}

	@And("switch to parent window")
	public void switch_to_parent_window() 
	{
		//switches back to parent window to click logout
		driver.switchTo().window(parentwindow);
	}

	@Then("click on logout")
	public void click_on_logout()
	{
		//clicks on logout
		logout.click();
	}

	//Visibility and functionality of sidebar

	@When("user clicks on sidebar")
	public void user_clicks_on_sidebar() 
	{
		// checking whether all options in sidebar are visible or not
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		sidebar = driver.findElement(By.id("button-menu")); // sidebar

		dashboard = driver.findElement(By.xpath("//*[@id='menu']/li[1]"));   // dashboard

		catalog = driver.findElement(By.xpath("//*[@id='menu']/li[3]"));    // catalog

		sales =driver.findElement(By.xpath("//*[@id='menu']/li[6]"));          //sales

		customers = driver.findElement(By.xpath("//*[@id='menu']/li[7]"));  // customers

		marketing = driver.findElement(By.xpath("//*[@id='menu']/li[8]")); // marketing

		reports =driver.findElement(By.xpath("//*[@id='menu']/li[10]"));        //reports
	}

	@Then("visibile")
	public void visibile() throws Exception 
	{
		// checks every option in the sidebar is visible or not
		sidebar.click();

		Assert.assertTrue(dashboard.isDisplayed());
		System.out.println("dashboard is visible");

		Assert.assertTrue(catalog.isDisplayed());
		System.out.println("catalog is visible");

		Assert.assertTrue(sales.isDisplayed());
		System.out.println("sales is visible");

		Assert.assertTrue(customers.isDisplayed());
		System.out.println("customers is visible");

		Assert.assertTrue(marketing.isDisplayed());
		System.out.println("marketing is visible");

		Assert.assertTrue(reports.isDisplayed());
		System.out.println("reports is visible");
	}


	//*************************************************************************************************************\\

	//      ****************************** DashBoard Functionalities starts from here *****************************\\

	//***************************************************************************************************************\\

	//                                   Dash Board functionality

	//*************************** Testing total orders in Dashboard ***************************************

	// user at dashboard and this given method is defined in background and prints the title of page currently active

	@Given("^user at Dashboard$")
	public void user_at_dashboard() 
	{
		// checking whether user is at Dashboard or not

		String title = driver.getTitle();

		Assert.assertEquals(title, "Dashboard");

		System.out.println("Dashboard opened");
	}

	@When("^User clicks on total orders$")
	public void user_clicks_on_total_orders()
	{
		//clicking on total orders in Dashboard
		WebElement orders = driver.findElement(By.xpath("//*[@id='content']/div[2]/div[1]/div[1]/div/div[2]/h2"));

		String ordercount = orders.getText();

		System.out.println("Total orders are "+ordercount);

		WebElement total_orders = driver.findElement(By.xpath("//*[@id='content']//div[1]/div/div[3]//a"));

		action.moveToElement(total_orders).click(total_orders).build().perform();
	}

	@Then("^total orders page is opened$")
	public void total_orders_page_is_opened() throws Throwable
	{
		// in total orders we are searching for a order id and then returning back to dashboard
		WebElement filter;

		filter = driver.findElement(By.id("button-filter"));

		if(filter.isDisplayed())
			System.out.println("inside total orders");

		driver.navigate().back();
	}     

	//********************** Testing total sales in Dashboard ******************************

	@When("^User clicks on total sales$")
	public void user_clicks_on_total_sales() 
	{
		//click on total sales in dashboard

		WebElement sales = driver.findElement(By.xpath("//*[@id='content']//div[2]//div[2]//div//div[2]//h2"));

		String salescount = sales.getText();

		System.out.println("Totals sales are "+salescount);

		driver.findElement(By.xpath("//*[@id='content']//div[1]//div[2]//div[3]//a")).click();
	}

	@Then("^total sales page is opened$")
	public void total_sales_page_is_opened() 
	{
		// checks for filter button in total sales page

		WebElement filter = driver.findElement(By.id("button-filter"));

		if(filter.isDisplayed())
		{
			System.out.println("in total sales");
		}

		driver.navigate().back();
	}

	//********************** Testing total Customers in Dashboard ******************************

	@When("^User clicks on total customers$")
	public void user_clicks_on_total_customers() 
	{
		// clicks on customers in dashboard
		WebElement customers = driver.findElement(By.xpath("//*[@id='content']//div[2]//div[3]//div//div[2]//h2"));

		String cuscount = customers.getText();

		System.out.println("Total Customers are "+cuscount);

		driver.findElement(By.xpath("//*[@id='content']//div[2]//div[3]//div[3]//a")).click(); 
	}

	@Then("^total customers page is opened$")
	public void total_customers_page_is_opened() 
	{
		// checking filter button visibility to confirm we have opened total customers page

		WebElement filter = driver.findElement(By.id("button-filter"));
		if(filter.isDisplayed())
		{
			System.out.println("inside total customers");
		}

		System.out.println("results displayed");

		driver.navigate().back();
	}

	//*********************************  Testing total people online in Dashboard ***********************************************

	@When("^User clicks on total People online$")
	public void user_clicks_on_total_people_online() 
	{
		WebElement people = driver.findElement(By.xpath("//*[@id='content']//div[2]//div[1]//div[4]//div//div[2]//h2"));

		String peopleonline = people.getText();

		System.out.println("Number of people online are "+peopleonline);

		driver.findElement(By.xpath("//*[@id='content']//div[2]//div[4]//div//div[3]//a")).click();  // clicks on people online
	}

	@Then("^total people online page is opened$")
	public void total_people_online_page_is_opened() 
	{	
		WebElement filter = driver.findElement(By.id("button-filter"));

		if(filter.isDisplayed())
		{
			System.out.println("Inside people online");
		}

		driver.navigate().back();
	}

	//********************** Testing World map in Dashboard **********************************

	@When("^Worldmap is visible$")
	public void Worldmap_is_visible() 
	{
		WebElement map = driver.findElement(By.xpath("//*[@id='content']//div[2]//div[2]//div[1]//div//div[1]//h3"));

		String maptext = map.getText();

		Assert.assertEquals(maptext,"World Map");

		System.out.println("World Map is visible in dashboard");
	}

	@Then("^Checking zoom in and out$")
	public void Checking_zoom_in_and_out() 
	{
		// checking zoom in and out

		WebElement zoomin,zoomout;

		zoomin = driver.findElement(By.xpath("//*[@class = 'jqvmap-zoomin']"));

		zoomin.click();

		zoomout = driver.findElement(By.xpath("//*[@class = 'jqvmap-zoomout']"));

		zoomout.click();

		System.out.println("Zoom in and Zoom out are working");
	}

	// ************************* Testing Sales Analytics in Dashboard **************


	@When("^Sales Analytics is visible$")
	public void sales_analytics_is_visible() 
	{
		WebElement analytics = driver.findElement(By.xpath("//*[@id='content']//div[2]//div[2]//div[2]//div//div[1]//h3"));

		String text = analytics.getText();

		Assert.assertEquals(text,"Sales Analytics");

		System.out.println("Sales Analytics is visible in dashboard");
	}

	@Then("^Checking calender icon$")
	public void checking_calender_icon() throws Throwable
	{
		driver.findElement(By.xpath("//*[@id='content']/div[2]/div[2]/div[2]/div/div[1]/div/a")).click(); // clicks on clender icon

		driver.findElement(By.xpath("//*[@id='range']/li[2]")).click(); //selects week
	} 

	// ************************** Testing Recent Activity Analytics in Dashboard ******************************

	@When("^Recent Activity is visible$")
	public void recent_activity_is_visible() throws Throwable 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");

		WebElement activity = driver.findElement(By.xpath("//*[@id='content']//div[2]//div[3]//div[1]//div//div//h3"));

		String text = activity.getText();

		Assert.assertEquals(text,"Recent Activity");

		action.moveToElement(activity).perform();

		System.out.println("Recent activity is visible");  
	}

	@Then("^checking user details$")
	public void checking_user_details() throws Throwable 
	{
		// clicks on the first user available in recent activity

		driver.findElement(By.xpath("//*[@id='content']//div[3]//ul/li[1]//a")).click();

		System.out.println("Inside Recent Acitivity");

		driver.navigate().back();
	}

	// ************************ Testing Latest orders in Dashboard *********************************

	@When("^Latest orders is visible$")
	public void latest_orders_is_visible() 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");

		WebElement latest = driver.findElement(By.xpath("//*[@id='content']//div[3]//div[2]//div[1]//h3"));

		action.moveToElement(latest).perform();

		String text = latest.getText();

		Assert.assertEquals(text,"Latest Orders");

		System.out.println("Latest Orders is visible");
	}

	@Then("^checking user Latest orders$")
	public void checking_user_latest_orders()
	{
		totalrows = driver.findElements(By.xpath("//*[@id='content']/div[2]/div[3]/div[2]/div/div[2]/table/tbody/tr"));
		int rowsize = totalrows.size();

		totalcolumns = driver.findElements(By.xpath("//*[@id='content']/div[2]/div[3]/div[2]/div/div[2]/table/tbody/tr[1]/td"));
		int colsize = totalcolumns.size();

		for(int i=1;i<=rowsize;i++)
		{
			for(int j=1;j<=colsize;j++)
			{
				System.out.println(driver.findElement(By.xpath("//*[@id='content']/div[2]/div[3]/div[2]/div/div[2]/table/tbody/tr["+ i +"]/td["+ j +"]"))
						.getText());
			}
		}

		WebElement view = driver.findElement(By.xpath("//*[@id='content']//div[2]//table/tbody/tr[1]//td[6]/a")); // clicks on view button in Latest orders

		action.moveToElement(view).click(view).build().perform();

		driver.navigate().back();
	}



	//*************************************************************************************************************\\

	//                               Catalog Functionalities starts from here

	//**************************************************************************************************************\\


	// Testing categories under catalog

	// @Then this method is defined under background scenario for clicking on catalog

	@Then("^click on catalog$")   
	public void click_on_catalog() 
	{
		sidebar = driver.findElement(By.id("button-menu"));

		System.out.println("side bar opened");

		catalog = driver.findElement(By.xpath("//*[@id='menu-catalog']//a//span"));   

		action.moveToElement(sidebar).click(sidebar).moveToElement(catalog).click(catalog)
		.build().perform();

		System.out.println("Catalog opened");
	}

	// ******************** From here testing categories under catalog starts ****************************

	@Given("^under catalog select categories$")
	public void under_catalog_select_categories()
	{
		//finds categories under catalog and clicks on it

		catalog_categories = driver.findElement(By.xpath("//*[@id='menu-catalog']//ul//li[1]"));  //categories

		catalog_categories.click();

		String title =driver.getTitle();

		Assert.assertEquals(title,"Categories");

		System.out.println("found categories");
	}

	@Then("^under categories select multiple checkboxes$")
	public void under_categories_select_multiple_checkboxes() 
	{
		//selecting check box that select all other checkboxes

		driver.findElement(By.xpath("//*[@id='form-category']//input")).click();   // multiple checkbox selected

		System.out.println("categories is opened");

		System.out.println("multiple checboxes selected");
	}

	@And("^in categories click on add new button$")
	public void in_categories_click_on_add_new_button() 
	{
		//clicks on add new button

		driver.findElement(By.xpath("//*[@id='content']//div/a[1]")).click();  //add new button
	}

	@Then("^click on save to check mandatory fields$")
	public void click_on_save_to_check_mandatory_fields() 
	{
		driver.findElement(By.xpath("//*[@id='content']//div[1]//button")).click(); //save button

		WebElement alert = driver.findElement(By.xpath("//*[text() = 'Category Name must be between 2 and 255 characters!']")); // error message for mandatory fields

		Assert.assertTrue(alert.isDisplayed());

		System.out.println(alert.getText());

		//error message for meta tag title

		WebElement MetaAlert = driver.findElement(By.xpath("//*[text()='Meta Title must be greater than 3 and less than 255 characters!']"));

		Assert.assertTrue(MetaAlert.isDisplayed());

		System.out.println(MetaAlert.getText());
	}


	@And("^enter all the mandatory fields$")
	public void enter_all_the_mandatory_fields() 
	{
		//enter only mandatory fields to create a category
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		category_name  = driver.findElement(By.id("input-name1"));        

		Meta_tag_title = driver.findElement(By.id("input-meta-title1")); 

		// this for loop iterates from General to Design and opens on them

		for(int i=1;i<=3;i++)
		{
			driver.findElement(By.xpath("//*[@id='form-category']//ul//li["+ i +"]//a")).click();
		}

		// clicks on data and opens data page

		driver.findElement(By.xpath("//*[@id='form-category']//ul//li[1]//a")).click(); // clicks on General and opens General page

		action.moveToElement(category_name).click(category_name).sendKeys("Kaushik")
		.moveToElement(Meta_tag_title).click(Meta_tag_title).sendKeys("kaushik automationtest").build().perform();

		System.out.println("new category is added");
	}

	@And("^click on save button in categories$")
	public void click_on_save_button_in_categories()
	{
		// Clicks on Save Button

		driver.findElement(By.xpath("//*[@id='content']//div[1]//button")).click(); //save button

		// checking for success message
		WebElement success = driver.findElement(By.xpath("//div[1][text()=' Success: You have modified categories!      ']")); 

		Assert.assertTrue(success.isDisplayed());

		System.out.println(success.getText());
	}

	@And("Finding created category in table")
	public void finding_created_category_in_table() 
	{
		totalrows = driver.findElements(By.xpath("//*[@id='form-category']//table//tbody//tr"));   // total rows

		int rowsize = totalrows.size();

		totalcolumns = driver.findElements(By.xpath("//*[@id='form-category']//div//table//tbody//tr[1]//td")); // total columns

		int colsize = totalcolumns.size();

		for(int i=1;i<=rowsize;i++)
		{
			for(int j=1;j<=colsize;j++)
			{
				System.out.println(driver.findElement(By.xpath("//*[@id='form-category']//div//table//tbody//tr["+ i +"]/td["+ j +"]"))
						.getText());
			}
		}
	}

	@When("user clicks on edit button in category list")
	public void user_clicks_on_edit_button_in_category_list()
	{
		//checking whether edit button is working in category list
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[@id='form-category']//div//table//tbody//tr[1]//td[4]//a")).click();

		driver.navigate().back();

	}

	@Then("^check delete option both single and multiple in categories list$")
	public void check_delete_option_both_single_and_multiple_in_categories_list() 
	{
		// for single checkbox deletion

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		for(int i=1;i==1;i++)
		{
			for(int j=1;j==1;j++)
			{
				driver.findElement(By.xpath("//*[@id='form-category']/div/table/tbody/tr["+ i +"]/td["+ j +"]")).click();
			}

			driver.findElement(By.xpath("//*[@id='content']/div[1]//button")).click();   //delete button

			driver.switchTo().alert().accept();                // handling alert
		}

		System.out.println("single deleted");

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		// multiple check box deletion example deleting first 3 categories 

		for(int i=1;i<=3;i++)
		{
			for(int j=1;j==1;j++)
			{
				driver.findElement(By.xpath("//*[@id='form-category']/div/table/tbody/tr["+ i +"]/td["+ j +"]")).click();
			}
		}

		driver.findElement(By.xpath("//*[@id='content']/div[1]//button")).click();   //delete button

		driver.switchTo().alert().accept();                 // handling alert

		System.out.println("multiple deleted");

		WebElement success = driver.findElement(By.xpath("//div[1][text()=' Success: You have modified categories!      ']")); 

		Assert.assertTrue(success.isDisplayed());

		System.out.println(success.getText());
	}

	//********************************* Testing Products under catalog *******************************

	// Finding products under catalog by just changing index numbers

	@Given("^under catalog select Products$")
	public void under_catalog_select_products() 
	{
		catalog_products = driver.findElement(By.xpath("//*[@id='menu-catalog']//ul//li[2]"));  //categories

		catalog_products.click();

		String title =driver.getTitle();

		Assert.assertEquals(title,"Products");

		System.out.println("Found Products");
	}

	@When("^under Products select multiple checkboxes$")
	public void under_products_select_multiple_checkboxes() 
	{
		//Multiple check boxes are selected here using single checkbox

		driver.findElement(By.xpath("//*[@id='form-product']//thead//tr//td[1]//input"));

		System.out.println("products is opened");

		System.out.println("multiple checboxes selected");
	}

	@When("^in products click on add new button$")
	public void in_products_click_on_add_new_button() 
	{
		// clicks on add new button

		driver.findElement(By.xpath("//*[@id='content']//div[1]//div//a")).click();
	}

	@Then("^click on save to check mandatory fields in products$")
	public void click_on_save_to_check_mandatory_fields_in_product() 
	{
		// clicks on save to check for mandatory fields

		driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]//div//div//button")).click();   //save button

		// error message for mandatory fields

		WebElement alert = driver.findElement(By.xpath("//*[text() = 'Product Name must be greater than 3 and less than 255 characters!']")); 

		Assert.assertTrue(alert.isDisplayed());

		System.out.println(alert.getText());

		WebElement MetaAlert = driver.findElement(By.xpath("//*[text()='Meta Title must be greater than 3 and less than 255 characters!']"));

		Assert.assertTrue(MetaAlert.isDisplayed());

		System.out.println(MetaAlert.getText());

		driver.findElement(By.xpath("//*[@id='form-product']/ul/li[2]")).click(); // clicks on data

		WebElement modelalert = driver.findElement(By.xpath("//*[text()='Product Model must be greater than 1 and less than 64 characters!']"));

		Assert.assertTrue(modelalert.isDisplayed());

		System.out.println(modelalert.getText());

	}

	@And("^fill mandatory details in add new products page$")
	public void fill_mandatory_details_in_add_new_products_page()
	{

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		product_name  = driver.findElement(By.id("input-name1"));   

		Meta_tag_title = driver.findElement(By.id("input-meta-title1"));

		// this for loop clicks on links attribute,option,recurring,discount,special,image,reward points and design
		for(int i =3;i<=11;i++)
		{
			driver.findElement(By.xpath("//*[@id='form-product']/ul/li["+ i +"]")).click();
		}

		driver.findElement(By.xpath("//*[@id='form-product']/ul/li[1]")).click();   //clicks on general

		action.moveToElement(product_name).click(product_name).sendKeys("KaushikTestAuto")
		.moveToElement(Meta_tag_title).click(Meta_tag_title).sendKeys("automation test").build().perform();

		// Filling mandatory fields (Model) under data 

		driver.findElement(By.xpath("//*[@id='form-product']//ul//li[2]")).click();  // clicks on data

		product_model = driver.findElement(By.id("input-model"));

		action.moveToElement(product_model).click(product_model).sendKeys("AUTO")
		.build().perform();
	}

	@And("^click save in product add page$")
	public void click_save_in_product_add_page() 
	{
		// "//*[@id='content']//div[1]//button" earlier save
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]//div//div//button")).click();   //save button

		WebElement success = driver.findElement(By.xpath("//div[1][text()=' Success: You have modified products!      ']")); 

		Assert.assertTrue(success.isDisplayed());

		System.out.println(success.getText());

	}

	@And("^using filter button finding products$")
	public void using_filter_button_finding_products() 
	{
		// passes data into product name and then clicks on filter button

		driver.findElement(By.id("input-name")).sendKeys("KaushikTestAuto");

		driver.findElement(By.id("button-filter")).click();
	}

	@When("^Finding created Product in table$")
	public void finding_created_product_in_table()
	{
		//after searching using filter button now we will print the table of search results

		totalrows =   driver.findElements(By.xpath("//*[@id='form-product']//div//table//tbody//tr"));
		int rowsize = totalrows.size();

		totalcolumns = driver.findElements(By.xpath("//*[@id='form-product']//div//table//tbody//tr[1]//td"));
		int colsize = totalcolumns.size();

		for(int i=1;i<=rowsize;i++)
		{
			for(int j=1;j<=colsize;j++)
			{
				System.out.println(driver.findElement(By.xpath("//*[@id='form-product']//div//table//tbody//tr["+ i +"]//td["+ j +"]")).getText());
			}
		}
	}

	@When("^user clicks on edit button in product list$")
	public void user_clicks_on_edit_button_in_product_list() throws Exception 
	{
		// checking whether edit button is working in Product list
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[@id='form-product']//div//table//tbody//tr[1]//td[8]//a")).click(); // clicks on edit button

		//earlier Product name was KaushikTestAuto now we have change it to kaushiktestname

		driver.findElement(By.xpath("//*[@id='form-product']/ul/li[1]")).click(); //clicks on general

		product_name  = driver.findElement(By.id("input-name1"));  

		action.moveToElement(product_name).click(product_name).keyDown(Keys.CONTROL).sendKeys("a")
		.keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys("Kaushiktestname").build().perform();

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[@id='form-product']//ul//li[2]")).click();  // clicks on data

		WebElement  seourl = driver.findElement(By.id("input-keyword"));

		action.moveToElement(seourl).click(seourl).keyDown(Keys.CONTROL).sendKeys("a")
		.keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).build().perform();

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[@id='content']/div[1]/div/div/button")).click();   //save button 

		WebElement success = driver.findElement(By.xpath("//*[text() = ' Success: You have modified products!      ']")); 

		Assert.assertTrue(success.isDisplayed());

		System.out.println(success.getText());

	}
	@When("finding edited product using filter")
	public void finding_edited_product_using_filter()
	{
		// deleting the inputs  and finding edited product using product name in filter section

		WebElement product_filter_name = driver.findElement(By.id("input-name"));

		action.moveToElement(product_filter_name).click(product_filter_name).keyDown(Keys.CONTROL)
		.sendKeys("a").keyUp(Keys.CONTROL)
		.sendKeys(Keys.BACK_SPACE).pause(2000).sendKeys("Kaushiktestname").build().perform();

		driver.findElement(By.id("button-filter")).click();  // clicks on filter
	}

	@Then("^check delete option both single and multiple in products list$")
	public void check_delete_option_both_single_and_multiple_in_products_list() 
	{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		// deleting by selecting single checkbox

		// in this for loop we select single rows and single coloumn
		for(int i=1;i==1;i++)
		{
			for(int j=1;j==1;j++)
			{
				driver.findElement(By.xpath("//*[@id='form-product']//div//table//tbody//tr["+ i +"]//td["+ j +"]")).click();
			}
		}
		//clicks on delete button

		driver.findElement(By.xpath("//*[@id='content']//div[1]//div//button[2]")).click();  // delete button

		// when clicked on delete button alert pops up so we are handling that error here

		driver.switchTo().alert().accept();  

		System.out.println("single deleted");

		//multiple check box delete

		// in this for loop we select multiple rows and only one column

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		for(int i=1;i<=3;i++)                 
		{
			for(int j=1;j==1;j++)
			{
				driver.findElement(By.xpath("//*[@id='form-product']//div//table//tbody//tr["+ i +"]//td["+ j +"]")).click();
			}
		}

		//clicks on delete button

		driver.findElement(By.xpath("//*[@id='content']//div[1]//div//button[2]")).click();  //delete button

		// when clicked on delete button alert pops up so we are handling that error here

		driver.switchTo().alert().accept();

		System.out.println("Multiple deleted");

		WebElement success = driver.findElement(By.xpath("//div[1][text()=' Success: You have modified products!      ']")); 

		Assert.assertTrue(success.isDisplayed());

		System.out.println(success.getText());
	}


	//************************* Testing Recurring profiles under catalog ************************************

	@Given("^under catalog select Recurring profiles$")
	public void under_catalog_select_recurring_profiles()
	{
		// finds recurring profile under catalog and opens it

		driver.findElement(By.xpath("//*[@id='menu-catalog']//ul//li[3]")).click();

		String title =driver.getTitle();

		Assert.assertEquals(title,"Recurring Profiles");

		System.out.println(" Recurring profiles is opened ");
	}

	@When("^click on add new button in recurring profiles$")
	public void click_on_add_new_button_in_recurring_profiles()
	{
		// click on add new to add new recurring profile

		driver.findElement(By.xpath("//*[@id='content']/div[1]//div//div//a")).click();
	}

	@Then("^click on save to check mandatory fields in Recurring$")
	public void click_on_save_to_check_mandatory_fields_in_recurring() 
	{
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]//div//div//button")).click();   //save button

		// error message for mandatory fields

		WebElement alert = driver.findElement(By.xpath("//*[text() = 'Profile Name must be greater than 3 and less than 255 characters!']")); 

		Assert.assertTrue(alert.isDisplayed());

		System.out.println(alert.getText());
	}

	@And("^fill details recurring profiles$")
	public void fill_details_recurring_profiles() 
	{
		// Filling details under add new recurring profile

		WebElement Name,price,dropdown;

		Name = driver.findElement(By.xpath("//*[@id='form-recurring']//div[1]//div//div//input"));

		price = driver.findElement(By.id("input-price"));

		dropdown = driver.findElement(By.id("input-frequency")); // dropdown menu for select duration in days or months or years

		action.moveToElement(Name).click(Name).sendKeys("AutoProfile")
		.moveToElement(price).click(price).sendKeys("1000")
		.build().perform();

		// using select keyword we will select the option in dropdown
		Select select  = new Select(dropdown);

		select.selectByVisibleText("Year");
	}

	@And("^check recurring profile list$")
	public void check_recurring_profile_list()
	{
		// to check recurring profile list first we need to click save

		driver.findElement(By.xpath("//*[@id='content']//div[1]//div//div//button")).click(); // clicks on save button

		totalrows = driver.findElements(By.xpath("//*[@id='form-recurring']/div/table/tbody/tr")); 
		int rowsize = totalrows.size();

		totalcolumns = driver.findElements(By.xpath("//*[@id='form-recurring']/div/table/tbody/tr[1]/td"));
		int colsize = totalcolumns.size();

		for(int i=1;i<=rowsize;i++)
		{
			for(int j=1;j<=colsize;j++)
			{
				System.out.println(driver.findElement(By.xpath("//*[@id='form-recurring']/div/table/tbody/tr["+ i + "]/td["+ j +"]"))
						.getText());
			}
		}

		WebElement success = driver.findElement(By.xpath("//div[1][text()=' Success: You have modified recurring profiles!      ']")); 

		Assert.assertTrue(success.isDisplayed());

		System.out.println(success.getText());
	}

	@And("^click on edit button$")
	public void click_on_edit_button()
	{
		WebElement Name;
		//clicks on edit button

		// changes the name of first row recurring profile

		driver.findElement(By.xpath("//*[@id='form-recurring']/div/table/tbody/tr[1]/td[4]/a")).click();   // edit button

		Name = driver.findElement(By.xpath("//*[@id='form-recurring']//div[1]//div//div//input"));

		action.moveToElement(Name).click(Name).keyDown(Keys.CONTROL).sendKeys("a")
		.keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys("Recurring Automation").build().perform();

		driver.findElement(By.xpath("//*[@id='content']//div[1]//div//div//button")).click();  // save button

		WebElement success = driver.findElement(By.xpath("//div[1][text()=' Success: You have modified recurring profiles!      ']")); 

		Assert.assertTrue(success.isDisplayed());

		System.out.println(success.getText());
	}

	@Then("^check delete option both single and multiple in Recurring profile list$")
	public void check_delete_option_both_single_and_multiple_in_recurring_profile_list()
	{
		// deleting by selecting single checkbox

		// in this for loop we select single rows and single coloumn
		for(int i=1;i==1;i++)
		{
			for(int j=1;j==1;j++)
			{

				driver.findElement(By.xpath("//*[@id='form-recurring']//div//table//tbody//tr["+ i +"]//td["+ j +"]")).click();
			}
		}

		// clicks on delete

		driver.findElement(By.xpath("//*[@id='content']//div[1]//div//button[2]")).click();  // delete button

		// when clicked on delete button alert pops up so we are handling that error here

		driver.switchTo().alert().accept();  

		System.out.println("single deleted");

		//multiple check box delete

		// in this for loop we select multiple rows and only one column

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		for(int i=1;i<=2;i++)                 
		{
			for(int j=1;j==1;j++)
			{
				driver.findElement(By.xpath("//*[@id='form-recurring']//div//table//tbody//tr["+ i + "]//td["+ j +"]")).click();
			}
		}

		//clicks on delete button

		driver.findElement(By.xpath("//*[@id='content']//div[1]//div//button[2]")).click();  //delete button

		// when clicked on delete button alert pops up so we are handling that error here

		driver.switchTo().alert().accept();

		System.out.println("multiple deleted");

		WebElement success = driver.findElement(By.xpath("//div[1][text()=' Success: You have modified recurring profiles!      ']"));

		Assert.assertTrue(success.isDisplayed());

		System.out.println(success.getText());
	}

	//************************ Testing filters under catalog ******************************************

	@Given("^under catalog select Filters$")
	public void under_catalog_select_Filters()
	{
		// under catalog select filters

		driver.findElement(By.xpath("//*[@id='menu-catalog']//ul//li[4]")).click();

		String title =driver.getTitle();

		Assert.assertEquals(title,"Filters");

		System.out.println("Found filters and opened");
	}

	@When("^click on add new button in filters$")
	public void click_on_add_new_button_in_filters() 
	{
		// clicks on add new button

		driver.findElement(By.xpath("//*[@id='content']/div[1]//div//div//a")).click();

		System.out.println("add new button clicked");
	}

	@Then("^click on save to check mandatory fields in Filters$")
	public void click_on_save_to_check_mandatory_fields_in_filters() throws Throwable 
	{
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]//div//div//button")).click();   //save button

		// error message for mandatory fields

		WebElement alert = driver.findElement(By.xpath("//*[text() = 'Filter Group Name must be between 1 and 64 characters!']")); 

		Assert.assertTrue(alert.isDisplayed());

		System.out.println(alert.getText());
	}


	@When("^fill details in filter and save$")
	public void fill_details_in_filter_and_save()
	{
		//filling details in filter add form and clicking on save button

		// filter group name 

		WebElement filter_group_name =  driver.findElement(By.xpath("//*[@id='form-filter']//div[1]//div//div//input"));

		//click on add new Filter name

		WebElement Add_filter = driver.findElement(By.xpath("//*[@id='filter']//tfoot//tr//td[2]//a"));

		action.moveToElement(filter_group_name).click(filter_group_name).sendKeys("MyAutomatedFilter")
		.moveToElement(Add_filter).click(Add_filter)
		.build().perform();

		WebElement filter_name = driver.findElement(By.xpath("//*[@id='filter-row0']/td[1]/div/input"));

		filter_name.sendKeys("AutoFilter");

		// click save 
		driver.findElement(By.xpath("//*[@id='content']//div[1]//div//div//button")).click(); //click save

		WebElement success = driver.findElement(By.xpath("//div[1][text() =' Success: You have modified filters!      ']")); 

		Assert.assertTrue(success.isDisplayed());

		System.out.println(success.getText());
	}

	@When("^check Filter list$")
	public void check_filter_list() 
	{
		// printing Filter List table
		totalrows = driver.findElements(By.xpath("//*[@id='form-filter']//div//table//tbody//tr"));
		int rowsize = totalrows.size();

		totalcolumns = driver.findElements(By.xpath("//*[@id='form-filter']//div//table//tbody//tr[1]//td"));
		int colsize = totalcolumns.size();

		for(int i =1;i<=rowsize;i++)
		{
			for(int j=1;j<=colsize;j++)
			{
				System.out.println(driver.findElement(By.xpath("//*[@id='form-filter']//div//table//tbody//tr["+ i +"]//td["+ j +"]")).getText());
			}
		}
	}

	@When("^click on edit button in filter list$")
	public void click_on_edit_button_in_filter_list()
	{
		//clicks on edit button

		driver.findElement(By.xpath("//*[@id='form-filter']//div//table//tbody//tr[1]//td[4]//a")).click(); // click on edit button

		driver.navigate().back();
	}

	@Then("^check delete option both single and multiple in Filter list$")
	public void check_delete_option_both_single_and_multiple_in_filter_list()
	{
		// deleting by selecting single checkbox

		// in this for loop we select single rows and single coloumn
		for(int i=1;i==1;i++)
		{
			for(int j=1;j==1;j++)
			{

				driver.findElement(By.xpath("//*[@id=\"form-filter\"]//div//table//tbody//tr["+ i +"]//td["+ j +"]")).click();
			}
		}

		// clicks on delete

		driver.findElement(By.xpath("//*[@id='content']//div[1]//div//button")).click();  // delete button

		// when clicked on delete button alert pops up so we are handling that error here

		driver.switchTo().alert().accept();  

		System.out.println("single deleted");

		//multiple check box delete

		// in this for loop we select multiple rows and only one column

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		for(int i=1;i<=2;i++)                 
		{
			for(int j=1;j==1;j++)
			{
				driver.findElement(By.xpath("//*[@id=\"form-filter\"]//div//table//tbody//tr["+ i +"]//td["+ j +"]")).click();
			}
		}

		//clicks on delete button

		driver.findElement(By.xpath("//*[@id='content']//div[1]//div//button")).click();  //delete button

		// when clicked on delete button alert pops up so we are handling that error here

		driver.switchTo().alert().accept();

		System.out.println("Multiple deleted");

		// Success message 

		WebElement success = driver.findElement(By.xpath("//div[1][text() =' Success: You have modified filters!      ']")); 

		Assert.assertTrue(success.isDisplayed());

		System.out.println(success.getText());


	}

	// ******************* Testing Attributes under catalog *************************************

	@Given("^under catalog select Attributes$")
	public void under_catalog_select_attributes() 
	{
		// in side bar clicks on attributes
		driver.findElement(By.xpath("//*[@id='menu-catalog']//ul//li[5]")).click();

	}

	@When("^in attributes dropdown select attributes$")
	public void in_attributes_dropdown_select_attributes()
	{
		// clicks on attributes under attributes
		driver.findElement(By.xpath("//*[@id='menu-catalog']//ul//li[5]//ul//li[1]//a")).click(); // clicks on attributes

		String title =driver.getTitle();

		Assert.assertEquals(title,"Attributes");

		System.out.println("found Attributes under Attributes and opened");
	}

	@Then("^click on add new in attributes$")
	public void click_on_add_new_in_attributes() throws Throwable
	{
		//clicks on add new button in attributes

		driver.findElement(By.xpath("//*[@id='content']/div[1]//div//div//a")).click();

		System.out.println("clicked on add new button in Attributes");
	}

	@Then("^click on save to check mandatory fields in attributes$")
	public void click_on_save_to_check_mandatory_fields_in_attributes() throws Throwable
	{
		//clicking on save

		driver.findElement(By.xpath("//*[@id='content']//div[1]//div//div//button")).click();

		WebElement alert = driver.findElement(By.xpath("//*[text() = 'Attribute Name must be between 3 and 64 characters!']")); 

		Assert.assertTrue(alert.isDisplayed());

		System.out.println(alert.getText());
	}

	@Then("^fill the fields in attributes$")
	public void click_on_add_new_in_attributes_and_fill_the_fields() 
	{
		// filling attribute name

		driver.findElement(By.xpath("//*[@id='form-attribute']//div[1]//div//input")).sendKeys("Automated Attribute");

		//clicking on save
		driver.findElement(By.xpath("//*[@id='content']//div[1]//div//div//button")).click();

		if(driver.findElement(By.className("text-danger")).isDisplayed())
		{
			System.out.println("*********** DEFECT WITHOUT FILLING ATTRIBUTE GROUP CANNOT PROCEED FURTHER AND IT IS NOT MARKED AS MANDATORY************");
		}
		else
		{
			System.out.println("No Defect");
		}
	}

	@Then("^fill the required field$")
	public void fill_the_required_field() throws Throwable
	{
		WebElement dropdown = driver.findElement(By.id("input-attribute-group"));

		Select select = new Select(dropdown);

		select.selectByVisibleText("myautogroup");
	}

	@Then("^print Attribute list$")
	public void print_attribute_list() throws Throwable 
	{
		//now click on save

		driver.findElement(By.xpath("//*[@id='content']//div[1]//div//div//button")).click(); // save

		totalrows = driver.findElements(By.xpath("//*[@id='form-attribute']//div//table//tbody//tr")); 
		int rowsize = totalrows.size();

		totalcolumns = driver.findElements(By.xpath("//*[@id='form-attribute']//div//table//tbody//tr[1]//td"));
		int colsize = totalcolumns.size();

		for(int i=1;i<=rowsize;i++)
		{
			for(int j=1;j<=colsize;j++)
			{
				System.out.println(driver.findElement(By.xpath("//*[@id='form-attribute']//div//table//tbody//tr["+ i +"]//td["+ j +"]"))
						.getText());
			}
		}

		WebElement success = driver.findElement(By.xpath("//div[1][text() =' Success: You have modified attributes!      ']")); 

		Assert.assertTrue(success.isDisplayed());

		System.out.println(success.getText());
	}

	@Then("^check edit button Attributes$")
	public void check_edit_button_attributes() 
	{
		// clicks on edit button

		driver.findElement(By.xpath("//*[@id='form-attribute']//div//table//tbody//tr[1]//td[5]/a")).click();

		driver.navigate().back();
	}

	@Then("^check delete option in attributes$")
	public void check_delete_option_in_attributes() 
	{
		for(int i=1;i==1;i++)
		{
			for(int j=1;j==1;j++)
			{
				driver.findElement(By.xpath("//*[@id='form-attribute']//div//table//tbody//tr["+ i +"]//td["+ j +"]")).click();
			}

			//delete option
			driver.findElement(By.xpath("//*[@id='content']//div[1]//button")).click();

			driver.switchTo().alert().accept();

			System.out.println("deleted");
		}

		WebElement success = driver.findElement(By.xpath("//div[1][text() =' Success: You have modified attributes!      ']")); 

		Assert.assertTrue(success.isDisplayed());

		System.out.println(success.getText());
	}

	//***************** Testing Attribute Group under catalog ***********************

	@When("^click on attribute group$")
	public void click_on_attribute_group() 
	{
		// in attribute drop down select attribute group

		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[@id='menu-catalog']//ul//li[5]//ul//li[2]//a")).click(); // clicks on attribute group

		String title =driver.getTitle();

		Assert.assertEquals(title,"Attribute Groups");

		System.out.println("in attribute dropdown selected attribute group");
	}

	@Then("^click on add new button in attribute group$")
	public void click_on_add_new_button_in_attribute_group()
	{
		// clicks on add new to add new attribute group

		driver.findElement(By.xpath("//*[@id='content']/div[1]/div//div//a")).click();  //clicks on add new

		System.out.println("add new button clicked in attribute groups");
	}

	@Then("^click on save to check mandatory fields in attribute group$")
	public void click_on_save_to_check_mandatory_fields_in_attribute_group() 
	{
		driver.findElement(By.xpath("//*[@id='content']//div[1]//div//button")).click(); // clicks on save

		WebElement alert = driver.findElement(By.xpath("//*[text() = 'Attribute Group Name must be between 3 and 64 characters!']")); 

		Assert.assertTrue(alert.isDisplayed());

		System.out.println(alert.getText());	
	}

	@Then("^Fill details under attribute group and save$")
	public void fill_details_under_attribute_group_and_save()
	{
		// fill details and click on save
		driver.findElement(By.xpath("//*[@id='form-attribute-group']//div[1]//div//div//input")).sendKeys("myautogroup");

		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[@id='content']//div[1]//div//button")).click(); // clicks on save

		WebElement success = driver.findElement(By.xpath("//div[1][text()=' Success: You have modified attribute groups!      ']")); 

		Assert.assertTrue(success.isDisplayed());

		System.out.println(success.getText());
	}

	@Then("printing attribute group list")
	public void printing_attribute_group_list() 
	{
		totalrows = driver.findElements(By.xpath("//*[@id='form-attribute-group']/div/table/tbody/tr")); 
		int rowsize = totalrows.size();

		totalcolumns = driver.findElements(By.xpath("//*[@id='form-attribute-group']/div/table/tbody/tr[1]/td")); 
		int colsize = totalcolumns.size();

		for(int i=1;i<=rowsize;i++)
		{
			for(int j=1;j<=colsize;j++)
			{
				System.out.println(driver.findElement(By.xpath("//*[@id='form-attribute-group']/div/table/tbody/tr["+ i +"]/td["+ j +"]"))
						.getText());
			}
		}
	}

	@Then("^check edit button Attributes Group$")
	public void check_edit_button_attributes_group()
	{
		driver.findElement(By.xpath("//*[@id='form-attribute-group']/div/table/tbody/tr[1]/td[4]/a")).click();

		driver.navigate().back();
	}

	@Then("^check delete option in attributes group$")
	public void check_delete_option_in_attributes_group()
	{
		for(int i=4;i==4;i++)
		{
			for(int j=1;j==1;j++)
			{
				driver.findElement(By.xpath("//*[@id='form-attribute-group']/div/table/tbody/tr["+ i +"]/td["+ j +"]")).click();
			}

			// clicks on delete
			driver.findElement(By.xpath("//*[@id='content']//div[1]//button")).click();

			driver.switchTo().alert().accept();

			System.out.println("deleted");
		}

		WebElement success = driver.findElement(By.xpath("//div[1][text()=' Success: You have modified attribute groups!      ']")); 

		Assert.assertTrue(success.isDisplayed());

		System.out.println(success.getText());
	}

	//********************* Testing Options under catalog **************************

	@Given("^under catalog select Options$")
	public void under_catalog_select_options() throws Throwable
	{
		//clicks on Options under catalog

		driver.findElement(By.xpath("//*[@id='menu-catalog']//ul//li[6]")).click();

		String title = driver.getTitle();

		Assert.assertEquals(title,"Options");

		System.out.println("Options is opened");
	}

	@When("^click on add new button in Options$")
	public void click_on_add_new_button_in_options() throws Throwable 
	{
		// click on edit
		driver.findElement(By.xpath("//*[@id='content']/div[1]//div//div//a")).click();

		System.out.println("clicked on add new button in options");
	}

	@Then("^click on save to check mandatory fields in options$")
	public void click_on_save_to_check_mandatory_fields_in_options() 
	{
		// here without filling anything we will click on save to check the mandatory fields

		driver.findElement(By.xpath("//*[@id='content']/div[1]//div//button")).click();  // clicks on save button

		WebElement alert = driver.findElement(By.xpath("//*[text() = 'Option Name must be between 1 and 128 characters!']")); 

		Assert.assertTrue(alert.isDisplayed());

		System.out.println(alert.getText());		
	}

	@And("^fill details in Options and save$")
	public void fill_details_in_options_and_save() throws Throwable 
	{
		//filling details under options

		driver.findElement(By.name("option_description[1][name]")).sendKeys("testautooption");

		// under dropdown selecting select as option

		WebElement dropdown = driver.findElement(By.xpath("//*[@id='input-type']")); 
		Select select = new Select(dropdown);
		select.selectByIndex(0);

		// if under dropdown select is selected need to fill option value name

		//WebElement add_option_value,option_value_name,add_img;

		driver.findElement(By.xpath("//*[@id='option-value']//tfoot//tr//td[2]//button")).click(); // clicks on add option value button

		driver.findElement(By.xpath("//*[@id='option-value-row0']//td[1]//div//input")).sendKeys("AutomationOption"); // adds data into option value name

		driver.findElement(By.xpath("//*[@id='thumb-image0']//img")).click();

		driver.findElement(By.id("button-image")).click();  // Opens image manager

		driver.findElement(By.xpath("//*[@id='filemanager']//div[3]//div[1]//a//img")).click(); // selects an image

		driver.findElement(By.xpath("//*[@id='content']/div[1]//div//button")).click();  // clicks on save button

		WebElement success = driver.findElement(By.xpath("//div[1][text()=' Success: You have modified options!      ']")); 

		Assert.assertTrue(success.isDisplayed());

		System.out.println(success.getText());
	}

	@And("^check Options list$")
	public void check_options_list() throws Throwable
	{
		totalrows = driver.findElements(By.xpath("//*[@id='form-option']/div/table/tbody/tr")); 
		int rowsize = totalrows.size();

		totalcolumns = driver.findElements(By.xpath("//*[@id='form-option']/div/table/tbody/tr[1]/td")); 
		int colsize = totalcolumns.size();

		for(int i=1;i<=rowsize;i++)
		{
			for(int j=1;j<=colsize;j++)
			{
				System.out.println(driver.findElement(By.xpath("//*[@id='form-option']/div/table/tbody/tr["+ i +"]/td["+ j +"]"))
						.getText());
			}
		}	
	}

	@And("^click on edit button in Options list$")
	public void click_on_edit_button_in_options_list() throws Throwable 
	{
		// clicks on edit button

		driver.findElement(By.xpath("//*[@id='form-option']//div//table//tbody//tr[1]//td[4]//a")).click();

		driver.navigate().back();
	}

	@Then("^check delete option in Options$")
	public void check_delete_option_in_options() 
	{
		for(int i=2;i==2;i++)
		{
			for(int j=1;j==1;j++)
			{
				driver.findElement(By.xpath("//*[@id='form-option']/div/table/tbody/tr["+ i +"]/td["+ j +"]")).click();
			}

			// clicking on delete option
			driver.findElement(By.xpath("//*[@id='content']//div[1]//div//button")).click();

			driver.switchTo().alert().accept();

			System.out.println("deleted");
		}	

		WebElement success = driver.findElement(By.xpath("//div[1][text()=' Success: You have modified options!      ']")); 

		Assert.assertTrue(success.isDisplayed());

		System.out.println(success.getText());

	}

	//************************ Testing Manufacturers under catalog ********************************

	@Given("^under catalog select Manufacturers$")
	public void under_catalog_select_manufacturers() 
	{
		//clicks on Manufacturers under catalog

		driver.findElement(By.xpath("//*[@id='menu-catalog']//ul//li[7]")).click();

		String title =driver.getTitle();

		Assert.assertEquals(title,"Manufacturers");

		System.out.println("Manufacturers openend");
	}

	@When("^click on add new button in Manufacturers$")
	public void click_on_add_new_button_in_manufacturers() 
	{
		// clicks on add new button

		driver.findElement(By.xpath("//*[@id='content']/div[1]//div//div//a")).click();

		System.out.println("add new button clicked in Manufacturers");
	}

	@Then("^click on save to check mandatory fields in Manufacturers$")
	public void click_on_save_to_check_mandatory_fields_in_manufacturers() 
	{
		driver.findElement(By.xpath("//*[@id='content']//div[1]//div//button")).click(); // clicks on save

		WebElement alert = driver.findElement(By.xpath("//*[text() = 'Manufacturer Name must be between 2 and 64 characters!']")); 

		Assert.assertTrue(alert.isDisplayed());

		System.out.println(alert.getText());	
	}

	@Then("^fill details under Manufacturers$")
	public void fill_details_under_manufacturers() 
	{
		driver.findElement(By.id("input-name")).sendKeys("AutoManufacturer");;
	}

	@And("^click on save in Manufacturers$")
	public void click_on_save_in_manufacturers() 
	{
		driver.findElement(By.xpath("//*[@id='content']//div[1]//div//button")).click();  // clicks on save

		WebElement success = driver.findElement(By.xpath("//div[1][text()=' Success: You have modified manufacturers!      ']")); 

		Assert.assertTrue(success.isDisplayed());

		System.out.println(success.getText());
	}

	@Then("^printing Manufacturer list$")
	public void printing_manufacturer_list()
	{

		totalrows = driver.findElements(By.xpath("//*[@id='form-manufacturer']/div/table/tbody/tr")); 
		int rowsize = totalrows.size();

		totalcolumns = driver.findElements(By.xpath("//*[@id='form-manufacturer']/div/table/tbody/tr[1]/td")); 
		int colsize = totalcolumns.size();

		for(int i=1;i<=rowsize;i++)
		{
			for(int j=1;j<=colsize;j++)
			{
				System.out.println(driver.findElement(By.xpath("//*[@id='form-manufacturer']/div/table/tbody/tr["+ i +"]/td["+ j +"]"))
						.getText());
			}
		}	
	}

	@Then("checking edit button in manufacturers")
	public void checking_edit_button_in_manufacturers() 
	{
		//clicking edit button

		driver.findElement(By.xpath("//*[@id='form-manufacturer']/div/table/tbody/tr[1]/td[4]/a")).click();

		driver.navigate().back();
	}

	@Then("^check delete option in Manufacturers$")
	public void check_delete_option_in_manufacturers()
	{
		for(int i=1;i==1;i++)
		{
			for(int j=1;j==1;j++)
			{
				driver.findElement(By.xpath("//*[@id='form-manufacturer']/div/table/tbody/tr["+ i +"]/td["+ j +"]")).click();
			}

			// clicking on delete 
			driver.findElement(By.xpath("//*[@id='content']//div[1]//div//button")).click();

			driver.switchTo().alert().accept();

			System.out.println("deleted");
		}	

		WebElement success = driver.findElement(By.xpath("//div[1][text()=' Success: You have modified manufacturers!      ']")); 

		Assert.assertTrue(success.isDisplayed());

		System.out.println(success.getText());

	}


	//******************* Testing Downloads under catalog ***************************\\

	@Given("^under catalog select Downloads$")
	public void under_catalog_select_downloads() 
	{
		//clicks on Manufacturers under catalog

		driver.findElement(By.xpath("//*[@id='menu-catalog']//ul//li[8]")).click();

		String title =driver.getTitle();
		Assert.assertEquals(title,"Downloads");

		System.out.println("Downloads openend");
	}

	@When("^click on add new button in Downloads$")
	public void click_on_add_new_button_in_downloads() 
	{
		// click on add new button

		driver.findElement(By.xpath("//*[@id='content']/div[1]//div//div//a")).click();

		System.out.println("add new button clicked in downloads");
	}

	@Then("^click on save to check mandatory fields in Downloads$")
	public void click_on_save_to_check_mandatory_fields_in_downloads() throws Throwable 
	{
		driver.findElement(By.xpath("//*[@id='content']/div[1]//div//button")).click();   // click on save button

		//Download Name must be between 3 and 64 characters!

		WebElement alert = driver.findElement(By.xpath("//*[text() = 'Download Name must be between 3 and 64 characters!']"));

		WebElement alert1 = driver.findElement(By.xpath("//*[text() = 'File does not exist!']"));

		WebElement alert2 = driver.findElement(By.xpath("//*[text() = 'Mask must be between 3 and 128 characters!']"));

		Assert.assertTrue(alert.isDisplayed());

		Assert.assertTrue(alert1.isDisplayed());

		Assert.assertTrue(alert2.isDisplayed());

		System.out.println(alert.getText());

		System.out.println(alert1.getText());

		System.out.println(alert2.getText());
	}

	@Then("^fill details under Downloads$")
	public void fill_details_under_downloads() throws Exception
	{
		// fill download name, filename and mask

		driver.findElement(By.name("download_description[1][name]")).sendKeys("Automation Download"); //download name

		driver.findElement(By.id("button-upload")).click();   // click on upload File

		wait.until(ExpectedConditions.alertIsPresent()); // this explicit wait waits untill alert is diplayed

		driver.switchTo().alert().accept(); // handling alert are u want to sure
	}

	@And("^click on save in Downloads$")
	public void click_on_save_in_downloads()
	{	
		driver.findElement(By.xpath("//*[@id='content']/div[1]//div//button")).click();   // click on save button

		WebElement success = driver.findElement(By.xpath("//div[1][text()=' Success: You have modified downloads!      ']")); 

		Assert.assertTrue(success.isDisplayed());

		System.out.println(success.getText());
	}

	@Then("^printing Downloads list$")
	public void printing_downloads_list() 
	{
		totalrows = driver.findElements(By.xpath("//*[@id='form-download']/div/table/tbody/tr")); 
		int rowsize = totalrows.size();

		totalcolumns = driver.findElements(By.xpath("//*[@id='form-download']/div/table/tbody/tr[1]/td")); 
		int colsize = totalcolumns.size();

		for(int i=1;i<=rowsize;i++)
		{
			for(int j=1;j<=colsize;j++)
			{
				System.out.println(driver.findElement(By.xpath("//*[@id='form-download']/div/table/tbody/tr["+ i +"]/td["+ j +"]"))
						.getText());
			}
		}	
	}

	@Then("^checking edit button in Downloads$")
	public void checking_edit_button_in_downloads()  
	{
		//clicks on edit button

		driver.findElement(By.xpath("//*[@id='form-download']/div/table/tbody/tr/td[4]/a")).click();

		driver.navigate().back();
	}

	@Then("^check delete option in Downloads$")
	public void check_delete_option_in_downloads() 
	{
		for(int i=1;i==1;i++)
		{
			for(int j=1;j==1;j++)
			{
				driver.findElement(By.xpath("//*[@id='form-download']/div/table/tbody/tr["+ i +"]/td["+ j +"]")).click();
			}

			//clicks on delete

			driver.findElement(By.xpath("//*[@id='content']//div[1]//div//button")).click();

			driver.switchTo().alert().accept();

			System.out.println("deleted");
		}	

		WebElement success = driver.findElement(By.xpath("//div[1][text()=' Success: You have modified downloads!      ']")); 

		Assert.assertTrue(success.isDisplayed());

		System.out.println(success.getText());
	}

	//****************************** Testing Reviews under catalog**************************************\\

	@Given("^under catalog select Reviews$")
	public void under_catalog_select_reviews()
	{
		// under catalog reviews is clicked and we ar usinng assertto check the titl of opened page

		driver.findElement(By.xpath("//*[@id='menu-catalog']//ul//li[9]")).click();

		String title =driver.getTitle();

		Assert.assertEquals(title,"Reviews");

		System.out.println("Reviews openend");
	}

	@When("^click on add new button in Reviews$")
	public void click_on_add_new_button_in_reviews()
	{
		// clicks on add new button in reviews

		driver.findElement(By.xpath("//*[@id='content']/div[1]//div//div//a")).click();

		System.out.println("add new button clicked in reviews");
	}

	@Then("^click on save to check mandatory fields in Reviews$")
	public void click_on_save_to_check_mandatory_fields_in_reviews() 
	{
		driver.findElement(By.xpath("//*[@id='content']/div[1]//div//div//button")).click();  // click on save

		// printing all mandatory fields alerts

		WebElement alert = driver.findElement(By.xpath("//*[text() = 'Author must be between 3 and 64 characters!']"));

		WebElement alert1 = driver.findElement(By.xpath("//*[text() = 'Product required!']"));

		WebElement alert2 = driver.findElement(By.xpath("//*[text() = 'Review Text must be at least 1 character!']"));

		WebElement alert3 = driver.findElement(By.xpath("//*[text() = 'Review rating required!']"));


		Assert.assertTrue(alert.isDisplayed());

		Assert.assertTrue(alert1.isDisplayed());

		Assert.assertTrue(alert2.isDisplayed());

		Assert.assertTrue(alert3.isDisplayed());


		System.out.println(alert.getText());

		System.out.println(alert1.getText());

		System.out.println(alert2.getText());

		System.out.println(alert3.getText());		
	}

	@Then("^fill details under Reviews$")
	public void fill_details_under_reviews() 
	{
		//filling details author,product, text,and rating

		driver.findElement(By.id("input-author")).sendKeys("kaushik");				// author

		driver.findElement(By.id("input-product")).sendKeys("kaushiktestname");		// product name	

		driver.findElement(By.xpath("//*[@id='form-review']/div[2]/div/ul/li[1]")).click(); // selecting prduct name 


		driver.findElement(By.id("input-text")).sendKeys("Nice Product and testing reviews here"); // text

		driver.findElement(By.xpath("//*[@id='form-review']//div[4]//div//label[5]")).click(); // rating here we are selecting 5

	}

	@And("^click on save in Reviews$")
	public void click_on_save_in_reviews() 
	{
		// clicks on save button

		driver.findElement(By.xpath("//*[@id='content']/div[1]//div//div//button")).click();

		WebElement success = driver.findElement(By.xpath("//div[1][text()=' Success: You have modified reviews!      ']")); 

		Assert.assertTrue(success.isDisplayed());

		System.out.println(success.getText());
	}

	@And("^check filter button in reviews and print them$")
	public void check_filter_button_in_reviews_and_print_them() 
	{
		// searching for kaushiktestame review in review list and printing that list
		driver.findElement(By.id("input-product")).sendKeys("kaushiktestname");

		driver.findElement(By.id("button-filter")).click(); // clicks on filter

		totalrows = driver.findElements(By.xpath("//*[@id='form-review']/div/table/tbody/tr")); 
		int rowsize = totalrows.size();

		totalcolumns = driver.findElements(By.xpath("//*[@id='form-review']/div/table/tbody/tr[1]/td")); 
		int colsize = totalcolumns.size();

		for(int i=1;i<=rowsize;i++)
		{
			for(int j=1;j<=colsize;j++)
			{
				System.out.println(driver.findElement(By.xpath("//*[@id='form-review']/div/table/tbody/tr["+ i +"]/td["+ j +"]"))
						.getText());
			}
		}	
	}

	@Then("^Click on Edit button in reviews$")
	public void click_on_edit_button_in_reviews()
	{
		//clicks on edit 

		driver.findElement(By.xpath("//*[@id='form-review']//div//table//tbody//tr[1]//td[7]//a")).click();

		driver.navigate().back();
	}

	@Then("^check delete option in Reviews$")
	public void check_delete_option_in_reviews() 
	{	
		for(int i=1;i==1;i++)
		{
			for(int j=1;j==1;j++)
			{
				driver.findElement(By.xpath("//*[@id='form-review']/div/table/tbody/tr["+ i +"]/td["+ j +"]")).click();
			}

			// clicks on delete option
			driver.findElement(By.xpath("//*[@id='content']/div[1]//button")).click();

			driver.switchTo().alert().accept();

			System.out.println("deleted");
		}	
	}

	//******************** Testing Information under catalog **************************************\\

	@Given("^under catalog select Information$")
	public void under_catalog_select_information()
	{
		// clicks on Information in catalog and opens it

		driver.findElement(By.xpath("//*[@id='menu-catalog']//ul//li[10]")).click();

		String title =driver.getTitle();

		Assert.assertEquals(title,"Information");

		System.out.println("Information openend");
	}

	@When("^click on add new button in Information$")
	public void click_on_add_new_button_in_information() 
	{
		driver.findElement(By.xpath("//*[@id='content']/div[1]//div//div//a")).click();

		System.out.println("add new button clicked in Information");
	}

	@Then("^click on save to check mandatory fields in Information$")
	public void click_on_save_to_check_mandatory_fields_in_information()
	{
		driver.findElement(By.xpath("//*[@id='content']/div[1]//div//div//button")).click(); // click on save

		WebElement alert = driver.findElement(By.xpath("//*[text() = 'Information Title must be between 3 and 64 characters!']"));

		WebElement alert1 = driver.findElement(By.xpath("//*[text() = 'Description must be more than 3 characters!']"));

		WebElement alert2 = driver.findElement(By.xpath("//*[text() = 'Meta Title must be greater than 3 and less than 255 characters!']"));


		Assert.assertTrue(alert.isDisplayed());

		Assert.assertTrue(alert1.isDisplayed());

		Assert.assertTrue(alert2.isDisplayed());


		System.out.println(alert.getText());

		System.out.println(alert1.getText());

		System.out.println(alert2.getText());

	}

	@Then("^fill details under Information$")
	public void fill_details_under_information()
	{
		for(int i=1;i<=3;i++)
		{
			driver.findElement(By.xpath("//*[@id='form-information']//ul//li["+ i +"]")).click();
		}

		driver.findElement(By.xpath("//*[@id='form-information']//ul//li[1]")).click();

		// Information title
		driver.findElement(By.id("input-title1")).sendKeys("Automation Test");

		// adding description
		driver.findElement(By.xpath("//div[2][@id='language1' or @class='note-editable panel-body']"))
		.sendKeys("Here iam testing automation on information by adding description");

		//Meta tag title
		driver.findElement(By.id("input-meta-title1")).sendKeys("Information Automation");
	}

	@And("^click on save in Information$")
	public void click_on_save_in_information() 
	{
		// clicks on save button

		driver.findElement(By.xpath("//*[@id='content']/div[1]//div//div//button")).click();

		WebElement success = driver.findElement(By.xpath("//div[1][text()=' Success: You have modified information!      ']")); 

		Assert.assertTrue(success.isDisplayed());

		System.out.println(success.getText());
	}

	@And("^print Information List$")
	public void Print_information_list() 
	{	
		totalrows = driver.findElements(By.xpath("//*[@id='form-information']/div/table/tbody/tr")); 
		int rowsize = totalrows.size();

		totalcolumns = driver.findElements(By.xpath("//*[@id='form-information']/div/table/tbody/tr[1]/td")); 
		int colsize = totalcolumns.size();

		for(int i=1;i<=rowsize;i++)
		{
			for(int j=1;j<=colsize;j++)
			{
				System.out.println(driver.findElement(By.xpath("//*[@id='form-information']/div/table/tbody/tr["+ i +"]/td["+ j +"]"))
						.getText());
			}
		}	
	}

	@Then("^click on edit in Information$")
	public void click_on_edit_in_information()
	{
		// click on edit 

		driver.findElement(By.xpath("//*[@id='form-information']/div/table/tbody/tr[1]/td[4]/a")).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.navigate().back();
	}

	@Then("^check checkbox delete in information$")
	public void check_checkbox_delete_in_information() 
	{
		for(int i=2;i==2;i++)
		{
			for(int j=1;j==1;j++)
			{
				driver.findElement(By.xpath("//*[@id='form-information']/div/table/tbody/tr["+ i +"]/td["+ j +"]")).click();
			}

			driver.findElement(By.xpath("//*[@id='content']/div[1]//button")).click();

			driver.switchTo().alert().accept();

			System.out.println("deleted");
		}

		WebElement success = driver.findElement(By.xpath("//div[1][text()=' Success: You have modified information!      ']")); 

		Assert.assertTrue(success.isDisplayed());

		System.out.println(success.getText());
	}





	//************************************************************************************************************************************\\
	//             *************************** Sales and Customers ******************************************* \\
	//************************************************************************************************************************************\\


	// Background

	@Given("user login")
	public void user_login() 
	{
		driver.get("http://retailm1.upskills.in/admin/index.php?route=common/login");

		driver.findElement(By.id("input-username")).sendKeys("admin");
		driver.findElement(By.id("input-password")).sendKeys("admin@123");
		driver.findElement(By.xpath("//*[@id='content']//div[2]//form//div[3]//button")).click(); //click on login
	}

	@When("click on sidebar")
	public void click_on_sidebar() 
	{

		WebElement sidebar = driver.findElement(By.id("button-menu")) ;   //click on sidebar
		sidebar.click();
	}


	// Testing Orders under Sales

	@Given("user selects Sales in sidebar")
	public void user_selects_Sales_inside_sidebar() 
	{
		driver.findElement(By.id("menu-sale")).click();   //click on Sales
	}

	@When("user select Orders under Sales")
	public void user_select_orders_under_sales() 
	{
		driver.findElement(By.xpath("//*[@id='menu-sale']/ul/li[1]")).click(); //click on Orders

	} 

	@Then("click on add new")
	public void click_on_add_new()
	{
		driver.findElement(By.xpath("//*[@id='content']/div[1]//div//div//a")).click(); // click on add new button
	}

	@Then("fill details orders")
	public void fill_details_orders()
	{
		action = new Actions(driver);

		//Customer Details
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("input-firstname")).sendKeys("Soundarya");
		driver.findElement(By.id("input-lastname")).sendKeys("V S");
		driver.findElement(By.id("input-email")).sendKeys("soundarya126@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("9481235670");
		driver.findElement(By.xpath("//*[@id='tab-customer']//div[14]//button"));   


		//Product Details
		WebElement add_product, Continue1;
		driver.findElement(By.id("input-product")).sendKeys("Earphone");
		add_product = driver.findElement(By.xpath("//*[@id='tab-product']//div//button")); //adds product
		Continue1 = driver.findElement(By.xpath("//*[@id='tab-cart']//div[3]//div[2]//button"));    //clicks on Continue and moves to payment page

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		action.moveToElement(add_product).click(add_product).pause(4000).
		moveToElement(Continue1).click(Continue1).pause(4000).build().perform();


		//Payment Details
		driver.findElement(By.id("input-payment-firstname")).sendKeys("Soundarya");
		driver.findElement(By.id("input-payment-lastname")).sendKeys("V S");
		driver.findElement(By.id("input-payment-address-1")).sendKeys("Patel Nagar");
		driver.findElement(By.id("input-payment-city")).sendKeys("Ballari");

		WebElement pay1 = driver.findElement(By.id("input-payment-country"));
		Select p1 = new Select(pay1);
		p1.selectByVisibleText("India");

		WebElement pay2 = driver.findElement(By.id("input-payment-zone"));
		Select p2 = new Select(pay2);
		p2.selectByVisibleText("Karnataka");

		driver.findElement(By.xpath("//*[@id='tab-payment']//div[12]//div[2]//button")).click();   //clicks on continue and moves to shipping page


		//Shipping Details
		driver.findElement(By.id("input-shipping-firstname")).sendKeys("Soundarya");
		driver.findElement(By.id("input-shipping-lastname")).sendKeys("V S");
		driver.findElement(By.id("input-shipping-address-1")).sendKeys("Patel Nagar");
		driver.findElement(By.id("input-shipping-city")).sendKeys("Ballari");

		WebElement ship1 = driver.findElement(By.id("input-shipping-country"));
		Select s1 = new Select(ship1);
		s1.selectByIndex(99);

		WebElement ship2 = driver.findElement(By.id("input-shipping-zone"));
		Select s2 = new Select(ship2);
		s2.selectByIndex(1489);

		driver.findElement(By.xpath("//*[@id='tab-shipping']//div[12]//div[2]//button")).click();   //clicks on Continue and moves to totals page

		//Totals Details
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);

		WebElement ship = driver.findElement(By.id("input-shipping-method"));
		Select st = new Select(ship);
		st.selectByVisibleText("Free Shipping");
		driver.findElement(By.id("button-shipping-method")).click();   //click on apply for shipping method

		WebElement pay = driver.findElement(By.xpath("//*[@id='tab-total']//fieldset//div[2]//div//div"));
		Select pt = new Select(pay);
		pt.selectByVisibleText("Free Checkout");
		driver.findElement(By.xpath("//*[@id='tab-total']//div[2]//span//button")).click();     // click on apply for payment method
		driver.findElement(By.id("button-save")).click();  //click on save

	}


	//Orders_2
	//For single checkbox deletion

	@Then("deletion of single order")
	public void deletion_of_single_order() 
	{
		driver.findElement(By.id("menu-sale")).click();                            //click on Sales
		driver.findElement(By.xpath("//*[@id='menu-sale']/ul/li[1]")).click();     //click on Orders
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		for(int i=1;i==1;i++)
		{
			for(int j=1;j==1;j++)
			{
				driver.findElement(By.xpath("//*[@id='form-order']/div/table/tbody/tr["+ i +"]/td["+ j +"]")).click();  //checks single box
			}
		}

		driver.findElement(By.id("button-delete")).click();    //clicks on delete button
		driver.switchTo().alert().accept(); // handling alert

		System.out.println("single deleted");

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); 
	}

	//Multiple check box deletion 

	@Then("deletion of multiple orders")
	public void deletion_of_multiple_orders() 
	{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		for(int i=1;i<=2;i++)
		{
			for(int j=1;j==1;j++)
			{
				driver.findElement(By.xpath("//*[@id='form-order']/div/table/tbody/tr["+ i +"]/td["+ j +"]")).click();  //checks multiple boxes
			}
		}

		driver.findElement(By.id("button-delete")).click();    //clicks on delete button
		driver.switchTo().alert().accept(); // handling alert

		System.out.println("multiple deleted"); 
	}

	//Filtering the Orders

	@Then("filtering the orders")
	public void filtering() 
	{
		driver.findElement(By.id("input-customer")).sendKeys("manzoor mehadi");
		driver.findElement(By.id("button-filter")).click();  //displays all the orders by the name manzoor mehadi
	}


	//Recurring
	//Testing Recurring profiles under Sales

	@Given("user selects Recurring profiles under Sales")
	public void user_selects_recurring_profiles_under_sales() 
	{
		driver.findElement(By.id("menu-sale")).click();                            //click on Sales
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='menu-sale']//ul//li[2]//a")).click();     //click on Recurring Profiles
	}

	@When("filter the profiles if available")
	public void filter_the_profiels_if_available() 
	{
		driver.findElement(By.id("input-customer")).sendKeys("Rahul");
		WebElement status = driver.findElement(By.id("input-status"));
		Select select = new Select(status);
		select.selectByIndex(1);
		driver.findElement(By.id("button-filter")).click();   //displays the profiles
	}


	//Returns
	//Testing Returns under Sales

	@Given("user selects Returns under Sales")
	public void user_selects_returns_under_sales() 
	{
		driver.findElement(By.id("menu-sale")).click();                            //click on Sales
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='menu-sale']//ul//li[3]//a")).click();  //click on Returns
	}

	@When("add return details")
	public void add_return_details() 
	{
		driver.findElement(By.xpath("//*[@id='content']//div[1]//div//div/a")).click();  //clicks on add new return details
		driver.findElement(By.id("input-order-id")).sendKeys("123");
		driver.findElement(By.id("input-firstname")).sendKeys("Soundarya");
		driver.findElement(By.id("input-lastname")).sendKeys("V S");
		driver.findElement(By.id("input-email")).sendKeys("soundarya126@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("9481235670");
		driver.findElement(By.id("input-product")).sendKeys("Bag");
		driver.findElement(By.id("input-model")).sendKeys("SKU-013");
		driver.findElement(By.xpath("//*[@id='content']//div[1]//button")).click();  //save the details
	}

	@Then("deletion of single return")
	public void deletion_of_single_return() 
	{
		for(int i=1;i==1;i++)
		{
			for(int j=1;j==1;j++)
			{
				driver.findElement(By.xpath("//*[@id='form-return']/div/table/tbody/tr["+ i +"]/td["+ j +"]")).click();  //checks single box
			}
		}

		driver.findElement(By.xpath("//*[@id='content']//div[1]//button")).click();    //clicks on delete button
		driver.switchTo().alert().accept(); // handling alert

		System.out.println("single deleted");

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@Then("deletion of multiple returns")
	public void deletion_of_multiple_returns() 
	{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		for(int i=1;i<=2;i++)
		{
			for(int j=1;j==1;j++)
			{
				driver.findElement(By.xpath("//*[@id='form-return']/div/table/tbody/tr["+ i +"]/td["+ j +"]")).click();  //checks multiple boxes
			}
		}

		driver.findElement(By.xpath("//*[@id='content']//div[1]//button")).click();    //clicks on delete button
		driver.switchTo().alert().accept(); // handling alert

		System.out.println("multiple deleted"); 
	}

	@Then("filtering the returns")
	public void filtering_the_returns() 
	{
		driver.findElement(By.id("input-order-id")).sendKeys("123");
		driver.findElement(By.id("input-customer")).sendKeys("Anju");
		driver.findElement(By.id("button-filter")).click();   //displays all the returns by the name anju
	}


	//Gift_vouchers_section
	//Testing Gift Vouchers under Sales
	//Themes
	@Given("user selects voucher themes under Sales")
	public void user_selects_voucher_themes_under_sales() 
	{
		driver.findElement(By.id("menu-sale")).click();                            //click on Sales
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='menu-sale']//ul//li[4]")).click();   //clicks on gift vouchers
	}

	@When("add new theme")
	public void add_new_theme() 
	{
		driver.findElement(By.xpath("//*[@id='menu-sale']//ul//li[4]//ul//li[2]")).click();  //clicks on voucher theme
		driver.findElement(By.xpath("//*[@id='content']//div[1]//div//div//a")).click();  //add new theme
		driver.findElement(By.xpath("//*[@id='form-theme-voucher']//div[1]//div//div//input")).sendKeys("MajorTesting");
		driver.findElement(By.id("thumb-image")).click();      //click on theme image
		driver.findElement(By.id("button-image")).click();     //set image for theme
		driver.findElement(By.xpath("//*[@id='filemanager']//div[5]//div[3]//a")).click();   //image is selected
		driver.findElement(By.xpath("//*[@id='content']//div[1]//button")).click();   //new theme is saved
	}

	@Then("user can delete single or multiple themes")
	public void user_can_delete_single_or_multiple_themes() 
	{
		//single deletion of themes

		for(int i=1;i==1;i++)
		{
			for(int j=1;j==1;j++)
			{
				driver.findElement(By.xpath("//*[@id='form-voucher-theme']/div/table/tbody/tr["+ i +"]/td["+ j +"]")).click();  //checks single box
			}
		}

		driver.findElement(By.xpath("//*[@id='content']//div[1]//button")).click();    //clicks on delete button
		driver.switchTo().alert().accept(); // handling alert

		System.out.println("single deleted");

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); 

		//multiple deletion of themes

		for(int i=2;i<=3;i++)
		{
			for(int j=1;j==1;j++)
			{
				driver.findElement(By.xpath("//*[@id='form-voucher-theme']/div/table/tbody/tr["+ i +"]/td["+ j +"]")).click();  //checks multiple boxes
			}
		}

		driver.findElement(By.xpath("//*[@id='content']//div[1]//button")).click();    //clicks on delete button
		driver.switchTo().alert().accept(); // handling alert

		System.out.println("multiple deleted"); 
	}


	//Gifts

	@Then("fill voucher details")
	public void fill_voucher_details() 
	{
		driver.findElement(By.xpath("//*[@id='menu-sale']//ul//li[4]//ul//li[1]")).click();  //clicks on gift vouchers
		driver.findElement(By.xpath("//*[@id='content']//div[1]/a")).click();        //add new voucher button
		driver.findElement(By.id("input-code")).sendKeys("Major104");
		driver.findElement(By.id("input-from-name")).sendKeys("Soundarya");
		driver.findElement(By.id("input-from-email")).sendKeys("soundarya126@gmail.com");
		driver.findElement(By.id("input-to-name")).sendKeys("Rahul");
		driver.findElement(By.id("input-to-email")).sendKeys("rahul@gmail.com");
		driver.findElement(By.id("input-amount")).sendKeys("500");
		driver.findElement(By.xpath("//*[@id='content']//div[1]//button")).click();   //saves the voucher details
	}

	@Then("mail the voucher details")
	public void mail_the_voucher_details() 
	{
		for(int i=1;i==1;i++)
		{
			for(int j=1;j==1;j++)
			{
				driver.findElement(By.xpath("//*[@id='form-voucher']/div/table/tbody/tr["+ i +"]/td["+ j +"]")).click();  //checks single box
			}
		}

		driver.findElement(By.id("button-send")).click();    //clicks on send button					  
	}

	@Then("delete multiple vouchers")
	public void delete_multiple_vouchers() 
	{
		for(int i=2;i<=3;i++)
		{
			for(int j=1;j==1;j++)
			{
				driver.findElement(By.xpath("//*[@id='form-voucher']/div/table/tbody/tr["+ i +"]/td["+ j +"]")).click();  //checks multiple boxes
			}
		}

		driver.findElement(By.xpath("//*[@id='content']/div[1]//button[2]")).click();    //clicks on delete button
		driver.switchTo().alert().accept(); // handling alert	
	}


	//Customers
	//Testing Customers under Customers

	@Given("user selects Customers in sidebar")
	public void user_selects_customers_in_sidebar()
	{
		driver.findElement(By.id("menu-customer")).click();    //clicks on Customers in sidebar
	}

	@When("user select Customers under Customers")
	public void user_select_customers_under_customers() 
	{
		driver.findElement(By.xpath("//*[@id='menu-customer']//ul//li[1] ")).click();     //clicks on Customers
	}

	@Then("add new customer details")
	public void add_new_customer_details() 
	{
		driver.findElement(By.xpath("//*[@id='content']//div[1]/a")).click();    //add new customer details
		driver.findElement(By.id("input-firstname")).sendKeys("Sai");
		driver.findElement(By.id("input-lastname")).sendKeys("Kaushik");
		driver.findElement(By.id("input-email")).sendKeys("soundarya666@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("9487561230");
		driver.findElement(By.id("input-password")).sendKeys("sai666");
		driver.findElement(By.id("input-confirm")).sendKeys("sai666");
		driver.findElement(By.xpath("//*[@id='content']//div[1]//button")).click();   //saving new details
	}

	@Then("delete single customer detail")
	public void delete_single_customer_detail() 
	{
		for(int i=1;i==1;i++)
		{
			for(int j=1;j==1;j++)
			{
				driver.findElement(By.xpath("//*[@id='form-customer']/div/table/tbody/tr["+ i +"]/td["+ j +"]")).click();  //checks single box
			}
		}

		driver.findElement(By.xpath("//*[@id='content']/div[1]//button")).click();    //clicks on delete button
		driver.switchTo().alert().accept(); // handling alert

		System.out.println("single deleted");

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); 
	}

	@Then("delete multiple customer details")
	public void delete_multiple_customer_details() 
	{
		for(int i=2;i<=3;i++)
		{
			for(int j=1;j==1;j++)
			{
				driver.findElement(By.xpath("//*[@id='form-customer']/div/table/tbody/tr["+ i +"]/td["+ j +"]")).click();  //checks multiple boxes
			}
		}

		driver.findElement(By.xpath("//*[@id='content']/div[1]//button")).click();    //clicks on delete button
		driver.switchTo().alert().accept(); // handling alert	
	}

	@Then("filter the customer list")
	public void filter_the_customer_list() 
	{
		driver.findElement(By.id("input-name")).sendKeys("manzoor mehadi");
		driver.findElement(By.id("button-filter")).click();  //displays all the details of manzoor mehadi
	}


	//Customer_groups
	//Testing Customer Groups under Customers

	@Given("user selects Customer Groups under Customers")
	public void user_selects_customer_groups_under_customers() 
	{
		driver.findElement(By.id("menu-customer")).click();    //clicks on Customers in sidebar
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='menu-customer']//ul//li[2]")).click();    //clicks on customer groups

	}

	@When("create new customer group")
	public void create_new_customer_group() 
	{
		driver.findElement(By.xpath("//*[@id='content']//div[1]//div/a")).click();  //new group creation
		driver.findElement(By.xpath("//*[@id='form-customer-group']/div[1]/div//input")).sendKeys("MajorProject1");
		driver.findElement(By.xpath("//*[@id='content']/div[1]//button")).click();  //save the group 
	}

	@Then("delete single group")
	public void delete_single_group() 
	{
		for(int i=1;i==1;i++)
		{
			for(int j=1;j==1;j++)
			{
				driver.findElement(By.xpath("//*[@id='form-customer-group']/div/table/tbody/tr["+ i +"]/td["+ j +"]")).click();  //checks single box
			}
		}

		driver.findElement(By.xpath("//*[@id='content']/div[1]//button")).click();    //clicks on delete button
		driver.switchTo().alert().accept(); // handling alert

		System.out.println("single deleted");

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@Then("delete multiple groups")
	public void delete_multiple_groups() 
	{
		for(int i=2;i<=3;i++)
		{
			for(int j=1;j==1;j++)
			{
				driver.findElement(By.xpath("//*[@id='form-customer-group']/div/table/tbody/tr["+ i +"]/td["+ j +"]")).click();  //checks multiple boxes
			}
		}

		driver.findElement(By.xpath("//*[@id='content']/div[1]//button")).click();    //clicks on delete button
		driver.switchTo().alert().accept(); // handling alert
	}


	//Custom_fields
	//Testing custom fields under Customers

	@Given("user selects custom fields under Customers")
	public void user_selects_custom_fields_under_customers() 
	{
		driver.findElement(By.id("menu-customer")).click();    //clicks on Customers in sidebar
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='menu-customer']//ul//li[3]")).click();    //opens custom fields
	}

	@When("create new custom field")
	public void create_new_custome_field() 
	{
		driver.findElement(By.xpath("//*[@id='content']//div[1]/a")).click();    //create new field
		driver.findElement(By.xpath("//*[@id='form-custom-field']/div[1]//input")).sendKeys("Major Project Testing");
		driver.findElement(By.xpath("//*[@id='custom-field-value']//tfoot//tr//td[2]//button")).click();    //create new field value
		driver.findElement(By.xpath("//*[@id='custom-field-value-row0']/td[1]/div/input")).sendKeys("smiling");
		driver.findElement(By.xpath("//*[@id='content']/div[1]//button")).click();   //save the custom field
	}

	@Then("delete single field")
	public void delete_single_field() 
	{
		for(int i=1;i==1;i++)
		{
			for(int j=1;j==1;j++)
			{
				driver.findElement(By.xpath("//*[@id='form-custom-field']/div/table/tbody/tr["+ i +"]/td["+ j +"]")).click();  //checks single box
			}
		}

		driver.findElement(By.xpath("//*[@id='content']//div[1]//button")).click();    //clicks on delete button
		driver.switchTo().alert().accept(); // handling alert

		System.out.println("single deleted");

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@Then("delete multiple fields")
	public void delete_multiple_fields() 
	{
		for(int i=2;i<=3;i++)
		{
			for(int j=1;j==1;j++)
			{
				driver.findElement(By.xpath("//*[@id='form-custom-field']/div/table/tbody/tr["+ i +"]/td["+ j +"]")).click();  //checks multiple boxes
			}
		}

		driver.findElement(By.xpath("//*[@id='content']//div[1]//button")).click();    //clicks on delete button
		driver.switchTo().alert().accept(); // handling alert
	}


	//*********************************************************************************************************************************************\\
	//                ****************************  Marketing and reports ***************************************************\\
	//*********************************************************************************************************************************************\\

	//background
	@Given("login admin page")
	public void login_admin_page()
	{
		driver.get("http://retailm1.upskills.in/admin/");
		driver.findElement(By.id("input-username")).sendKeys("admin");
		driver.findElement(By.id("input-password")).sendKeys("admin@123");
		driver.findElement(By.xpath("//*[@id=\"content\"]//button")).click();
	}

	@When("click sidebar")
	public void click_sidebar()
	{
		WebElement sidebar = driver.findElement(By.id("button-menu")) ; //side bar click
		sidebar.click();
	}


	//Scenario marketing starts
	@Given("user selects Marketing inside sidebar")
	public void user_selects_Marketing_inside_sidebar()
	{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"menu-marketing\"]/a/span")).click(); //clicks on marketing

	}



	@When("user select Marketing under Marketing")
	public void user_select_Marketing_under_Marketing()
	{

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='menu-marketing']/ul/li[1]")).click(); //clicks on marketing
	}


	@Then("^click on add new marketing$")
	public void click_on_add_new_marketing()
	{
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div/a")).click(); //click on add new button
	}


	@Then("fill details")
	public void fill_details()
	{
		driver.findElement(By.id("input-name")).sendKeys("Testing");
		driver.findElement(By.id("input-code")).sendKeys("6196200938a5f");
	}


	@Then("^click on save$")
	public void click_on_save()
	{
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]//div//div//button")).click(); ///click on save button
	}




	@Then("click on filter")
	public void click_0n_filter()
	{
		driver.findElement(By.id("input-name")).sendKeys("Testing");
		driver.findElement(By.id("input-code")).sendKeys("6196200938a5f");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.id("button-filter")).click(); //click on filter button
	}





	//Testing Affiliates under Marketing
	@Given("user selects Affiliates under Marketing")
	public void user_selects_Affiliates_Marketing()
	{

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='menu-marketing']//ul//li[2]//a")).click(); //click on Affiliates
	}


	@Then("^click on add new1$")
	public void click_on_add_new1()
	{
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]//div//div//a")).click(); ///add new button
	}


	@And("fill details1")
	public void fill_details1()
	{
		driver.findElement(By.id("input-firstname")).sendKeys("venky");
		driver.findElement(By.id("input-lastname")).sendKeys("Testing");
		driver.findElement(By.id("input-email")).sendKeys("venkateshtesting@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("0987654321");
		driver.findElement(By.id("input-code")).sendKeys("619736477b200");
		driver.findElement(By.id("input-password")).sendKeys("venky@testing");
		driver.findElement(By.id("input-confirm")).sendKeys("venky@testing");
		driver.findElement(By.id("input-address-1")).sendKeys("abcd");
		driver.findElement(By.id("input-city")).sendKeys("fghi");
		WebElement dropdown = driver.findElement(By.id("input-country"));

		Select select = new Select(dropdown);
		select.selectByVisibleText("India");

		WebElement dropdown1 = driver.findElement(By.id("input-zone"));

		Select select1 = new Select(dropdown1);
		select1.selectByVisibleText("Goa");
	}


	@Then("^click on Payment Details$")
	public void click_on_Payment_Details()
	{
		driver.findElement(By.xpath("//*[@id=\"form-affiliate\"]/ul/li[2]/a")).click(); ///click on paymentdetails 
	}


	@And("fill details20")
	public void fill_details20()
	{
		driver.findElement(By.id("input-cheque")).sendKeys("ananya");
	}




	@Then("^click on save1$")
	public void click_on_save1()
	{
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]//div//div//button")).click(); ///click on save button
	}



	@Then("^click on edit1$")
	public void click_on_edit1()
	{
		driver.findElement(By.xpath("//*[@id=\"form-affiliate\"]/div/table/tbody/tr[1]/td[7]/a")).click(); ///click on edit button
	}


	@And("^click on cancel1$")
	public void click_on_cancel1()
	{
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div/a/i")).click(); ///click on cancel
	}



	@Then("single check box deletion1")
	public void click_on_check_boxes1()


	{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);


		for(int i=1;i==1;i++)
		{
			for(int j=1;j==1;j++)
			{
				driver.findElement(By.xpath("//*[@id='form-affiliate']/div/table/tbody/tr["+ i +"]/td["+ j +"]")).click();
			}
		}



		driver.findElement(By.xpath("//*[@id='content']/div[1]//button")).click(); //delete button



		driver.switchTo().alert().accept(); // handling alert



		System.out.println("single deleted");



		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}


	@And("multiple check box deletion1")
	public void click_on_multiple_check_boxes1()

	{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);



		for(int i=1;i<=3;i++)
		{
			for(int j=1;j==1;j++)
			{
				driver.findElement(By.xpath("//*[@id='form-affiliate']/div/table/tbody/tr["+ i +"]/td["+ j +"]")).click();
			}
		}



		driver.findElement(By.xpath("//*[@id='content']/div[1]//button")).click(); //delete button



		driver.switchTo().alert().accept(); // handling alert



		System.out.println("multiple deleted");
	}


	@Then("click on filter1")
	public void click_0n_filter1()
	{
		driver.findElement(By.id("input-name")).sendKeys("venky Testing");
		driver.findElement(By.id("button-filter")).click(); //click on filter button
	}




	//Testing Coupons under Marketing
	@Given("user selects Coupons under Marketing")
	public void user_selects_Coupons_under_marketing()
	{

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='menu-marketing']//ul//li[3]//a")).click(); //click on Coupons
	}


	@Then("^click on add new2$")
	public void click_on_add_new2()
	{
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]//div//div//a")).click(); ///add new button
	}


	@And("fill details2")
	public void fill_details2()
	{
		driver.findElement(By.id("input-name")).sendKeys("dadbkfbv");
		driver.findElement(By.id("input-code")).sendKeys("dhsfdd");
	}


	@Then("^click on save2$")
	public void click_on_save2()
	{
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]//div//div//button")).click(); ///click on save button
	}



	@Then("^click on edit2$")
	public void click_on_edit2()
	{
		driver.findElement(By.xpath("//*[@id=\"form-coupon\"]/div/table/tbody/tr[1]/td[8]/a")).click(); ///click on edit button
	}

	@And("^click on cancel2$")
	public void click_on_cancel2()
	{
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div/a/i")).click(); ///click on cancel
	}


	@Then("single check box deletion2")
	public void click_on_check_boxes2()


	{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);


		for(int i=1;i==1;i++)
		{
			for(int j=1;j==1;j++)
			{
				driver.findElement(By.xpath("//*[@id='form-coupon']/div/table/tbody/tr["+ i +"]/td["+ j +"]")).click();
			}
		}



		driver.findElement(By.xpath("//*[@id='content']/div[1]//button")).click(); //delete button



		driver.switchTo().alert().accept(); // handling alert



		System.out.println("single deleted");



		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}


	@And("multiple check box deletion2")
	public void click_on_multiple_check_boxes2()

	{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);



		for(int i=1;i<=3;i++)
		{
			for(int j=1;j==1;j++)
			{
				driver.findElement(By.xpath("//*[@id='form-coupon']/div/table/tbody/tr["+ i +"]/td["+ j +"]")).click();
			}
		}



		driver.findElement(By.xpath("//*[@id='content']/div[1]//button")).click(); //delete button



		driver.switchTo().alert().accept(); // handling alert



		System.out.println("multiple deleted");
	}





	//Testing Mail under Marketing
	@Given("user selects Mail under Marketing")
	public void user_selects_Mail_under_marketing()
	{

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='menu-marketing']//ul//li[4]//a")).click(); //click on Mail
	}


	@Then("fill details3")
	public void fill_details3()
	{
		driver.findElement(By.id("input-subject-1")).sendKeys("hello");
		driver.findElement(By.xpath("//*[@id=\"language1\"]/div[2]/div/div/div[3]/div[2]/p")).sendKeys("abcdefg");
	}

	@Then("^click on send$")
	public void click_on_send()
	{
		driver.findElement(By.id("button-send")).click(); ///click on send button
	}

	@And("^click on cancel3$")
	public void click_on_cancel3()
	{
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div/a/i")).click(); ///click on cancel
	}






	//Scenario Reports starts
	@Given("user selects Reports inside sidebar")
	public void user_selects_Reports_inside_sidebar()
	{
		driver.findElement(By.xpath("//*[@id=\"menu-report\"]/a")).click();
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

	@When("user select orders under Reports")
	public void user_select_orders_under_Reports()
	{
		driver.findElement(By.xpath("//*[@id='menu-report']/ul/li[1]/a")).click();  //click on sales 
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='menu-report']/ul/li[1]/ul/li[1]/a")).click(); //clicks on orders
	}


	@Then("fill details4")
	public void fill_details4()
	{
		driver.findElement(By.id("input-date-start")).sendKeys("2021-11-01");
		WebElement dropdown = driver.findElement(By.id("input-group"));
		Select select = new Select(dropdown);
		select.selectByIndex(3);

		driver.findElement(By.id("input-date-end")).sendKeys("2021-11-20");

		WebElement dropdown1 = driver.findElement(By.id("input-status"));
		Select select1 = new Select(dropdown1);
		select1.selectByIndex(2);

	}


	@Then("click on filter2")
	public void click_0n_filter2()
	{
		driver.findElement(By.id("button-filter")).click(); //click on filter button
	}





	//Testing Shipping under Reports
	@Given("user selects Shipping under Reports")
	public void user_selects_Shipping_under_Reports()
	{
		driver.findElement(By.xpath("//*[@id='menu-report']/ul/li[1]/a")).click();  //click on sales 
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='menu-report']/ul/li[1]/ul/li[3]")).click(); //clicks on shipping
	}

	@Then("fill details6")
	public void fill_details6()
	{
		driver.findElement(By.id("input-date-start")).sendKeys("2019-01-01");
		WebElement dropdown = driver.findElement(By.id("input-group"));
		Select select = new Select(dropdown);
		select.selectByIndex(3);

		driver.findElement(By.id("input-date-end")).sendKeys("2021-11-20");

		WebElement dropdown1 = driver.findElement(By.id("input-status"));
		Select select1 = new Select(dropdown1);
		select1.selectByIndex(3);
	}


	@Then("click on filter4")
	public void click_0n_filter4()
	{
		driver.findElement(By.id("button-filter")).click(); //click on filter button
	}




	//Testing Returns under Reports
	@Given("user selects Returns under Reports")
	public void user_selects_Returns_under_Reports()
	{
		driver.findElement(By.xpath("//*[@id='menu-report']/ul/li[1]/a")).click();  //click on sales 
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='menu-report']/ul/li[1]/ul/li[4]")).click(); //clicks on returns
	}

	@Then("fill details7")
	public void fill_details7()
	{
		driver.findElement(By.id("input-date-start")).sendKeys("2019-01-01");
		WebElement dropdown = driver.findElement(By.id("input-group"));
		Select select = new Select(dropdown);
		select.selectByIndex(3);

		driver.findElement(By.id("input-date-end")).sendKeys("2021-11-20");

		WebElement dropdown1 = driver.findElement(By.id("input-status"));
		Select select1 = new Select(dropdown1);
		select1.selectByIndex(3);
	}

	@Then("click on filter5")
	public void click_0n_filter5()
	{
		driver.findElement(By.id("button-filter")).click(); //click on filter button
	}





	//Testing Products under Reports
	@Given("user selects Reports inside side bar1")
	public void user_selects_Reports_inside_sidebar1()
	{
		driver.findElement(By.xpath("//*[@id=\"menu-report\"]/a")).click();

	}
	@When("user selects Viewed under Reports")
	public void user_selects_viewed_Reports()
	{
		driver.findElement(By.xpath("//*[@id=\"menu-report\"]/ul/li[2]/a")).click();  //click on products
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='menu-report']/ul/li[2]/ul/li[1]/a")).click(); //click on Viewed
	}


	@Then("^click on Reset$")
	public void click_on_Reset()
	{
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div/a")).click(); ///click on reset button
	}






	//Testing Purchased under Reports
	@Given("user selects Purchased under Reports")
	public void user_selects_Purchased_under_Reports()
	{
		driver.findElement(By.xpath("//*[@id=\"menu-report\"]/a")).click();
		driver.findElement(By.xpath("//*[@id='menu-report']/ul/li[2]/a")).click();  //click on products 
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='menu-report']/ul/li[2]/ul/li[2]/a")).click(); //click on purchased

	}

	@Then("fill details10")
	public void fill_details10()
	{
		driver.findElement(By.id("input-date-start")).sendKeys("2019-01-01");
		WebElement dropdown = driver.findElement(By.id("input-status"));
		Select select = new Select(dropdown);
		select.selectByIndex(3);

		driver.findElement(By.id("input-date-end")).sendKeys("2021-11-20");


	}


	@Then("click on filter8")
	public void click_0n_filter8()
	{
		driver.findElement(By.id("button-filter")).click(); //click on filter button
	}






	//Testing orders under Reports
	@Given("user selects orders under Reports")
	public void user_selects_orders_under_Reports()
	{
		driver.findElement(By.xpath("//*[@id=\"menu-report\"]/a")).click();
		driver.findElement(By.xpath("//*[@id='menu-report']/ul/li[3]/a")).click(); //click on customers 
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='menu-report']/ul/li[3]/ul/li[4]/a")).click(); //clicks on orders
	}

	@Then("fill details14")
	public void fill_details14()
	{
		driver.findElement(By.id("input-customer")).sendKeys("Retail Test004");

	}

	@Then("click on filter12")
	public void click_0n_filter12()
	{
		driver.findElement(By.id("button-filter")).click(); //click on filter button
	}






	//Testing credit under Reports
	@Given("user selects credit under Reports")
	public void user_selects_credit_under_Reports()

	{

		driver.findElement(By.xpath("//*[@id=\"menu-report\"]/a")).click();
		driver.findElement(By.xpath("//*[@id='menu-report']/ul/li[3]/a")).click(); //click on customers 
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='menu-report']/ul/li[3]/ul/li[6]/a")).click(); //clicks on credit
	}

	@Then("fill details16")
	public void fill_details16()
	{
		driver.findElement(By.id("input-customer")).sendKeys("saatvik sharma");

	}

	@Then("click on filter14")
	public void click_0n_filter14()
	{
		driver.findElement(By.id("button-filter")).click(); //click on filter button
	}





	//Testing Marketing under Reports
	@Given("user selects Reports inside side bar3")
	public void user_selects_Reports_inside_sidebar3()
	{
		driver.findElement(By.xpath("//*[@id=\"menu-report\"]/a")).click();
	}
	@When("user selects Marketing_Marketing")
	public void user_selects_Marketing_Marketing()
	{

		driver.findElement(By.xpath("//*[@id=\"menu-report\"]/ul/li[4]")).click(); //click on Marketing

		driver.findElement(By.xpath("//*[@id=\"menu-report\"]/ul/li[4]/ul/li[1]/a")).click(); //clicks on Marketing
	}

	@Then("fill details17")
	public void fill_details17()
	{

		WebElement dropdown = driver.findElement(By.id("input-status"));
		Select select = new Select(dropdown);
		select.selectByIndex(1);
	}			


	@After
	public void After_all()
	{
		driver.quit();
	}
}