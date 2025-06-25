package com.omrmobilefullapp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.SupportsContextSwitching;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.MouseButton;
import org.openqa.selenium.interactions.PointerInput.Origin;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class MobileFullApp {

    static WebDriver driver;

    public static void appLaunch() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:deviceName", "NF8D8HIJR4V4QWSG");
        capabilities.setCapability("appium:platformName", "Android");
        capabilities.setCapability("appium:platformVersion", "13");
        capabilities.setCapability("appium:appPackage", "com.omr_branch");
        capabilities.setCapability("appium:appActivity", "com.omr_branch.MainActivity");
        capabilities.setCapability("appium:automationName", "UIAutomator2");

        driver = new AndroidDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    public static void login() {
        Set<String> contextNames = ((SupportsContextSwitching) driver).getContextHandles();
        for (String context : contextNames) {
            System.out.println("Context: " + context);
        }

        System.out.println("Current Context: " + ((SupportsContextSwitching) driver).getContext());

        WebElement txtEmail = driver.findElement(By.xpath("//android.widget.EditText[@content-desc='Email Address']"));
        txtEmail.sendKeys("ajithkumar06952@gmail.com");

        WebElement txtPassword = driver.findElement(By.xpath("//android.widget.EditText[@content-desc='Password']"));
        txtPassword.sendKeys("Ajith9843@");

        WebElement btnLogin = driver.findElement(By.xpath("//android.view.ViewGroup[@resource-id='login_button']"));
        btnLogin.click();
    }

    public static void searchHotels() throws InterruptedException {
        WebElement txtGetName = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='header_welcome']"));
        System.out.println(txtGetName.getText());

        // Select State (Vertical swipe)
        WebElement ddnStateName = driver.findElement(By.xpath("//android.widget.TextView[@text='Select State']"));
        ddnStateName.click();

        WebElement selectStateFlatList = driver.findElement(By.xpath("//android.widget.ScrollView[@content-desc='search_select_state flatlist']"));
        Rectangle rect = selectStateFlatList.getRect();
        int width = rect.getWidth();
        int height = rect.getHeight();
        int x = rect.getX();
        int y = rect.getY();

        int startY = (int) ((height * 0.80) + y);
        int endY = (int) ((height * 0.20) + y);
        int centerX = width / 2 + x;

        swipeVertical(centerX, startY, endY);

        driver.findElement(By.xpath("//android.widget.TextView[@text='Tamil Nadu']")).click();

        // Select City (Vertical swipe)
        driver.findElement(By.xpath("//android.widget.TextView[@text='Select City']")).click();
        WebElement selectCity1 = driver.findElement(By.xpath("//android.widget.ScrollView[@content-desc='search_select_city flatlist']"));
        Rectangle rect1 = selectCity1.getRect();
        int width1 = rect1.getWidth();
        int height1 = rect1.getHeight();
        int x1 = rect1.getX();
        int y1 = rect1.getY();

        int startY1 = (int) ((height1 * 0.80) + y1);
        int endY1 = (int) ((height1 * 0.20) + y1);
        int centerX1 = width1 / 2 + x1;

        swipeVertical(centerX1, startY1, endY1);

        driver.findElement(By.xpath("//android.widget.TextView[@text='Puducherry']")).click();

        // Select Room Type (Vertical swipe)
        driver.findElement(By.xpath("//android.widget.TextView[@text='Select Room Type']")).click();

        WebElement selectRoomFlatList = driver.findElement(By.xpath("//android.widget.ScrollView[@content-desc='search_room_type flatlist']"));
        Rectangle rect3 = selectRoomFlatList.getRect();
        int width3 = rect3.getWidth();
        int height3 = rect3.getHeight();
        int x3 = rect3.getX();
        int y3 = rect3.getY();

        int startY3 = (int) ((height3 * 0.80) + y3);
        int endY3 = (int) ((height3 * 0.20) + y3);
        int centerX3 = width3 / 2 + x3;

        swipeVertical(centerX3, startY3, endY3);

        driver.findElement(By.xpath("//android.widget.TextView[@text='Studio']")).click();

        // Select Check-in date (Horizontal swipe)
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='search_select_checkin']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By checkinCalendarLocator = By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkinCalendarLocator));

        WebElement selectIndateFlatList = driver.findElement(checkinCalendarLocator);
        Rectangle rect4 = selectIndateFlatList.getRect();


        int width4 = rect4.getWidth();
        int height4 = rect4.getHeight();
        int x4 = rect4.getX();
        int y4 = rect4.getY();

        int startX4 = (int) ((width4 * 0.90) + x4);
        int endX4 = (int) ((width4 * 0.10) + x4);
        int centerY4 = height4 / 2 + y4;

        swipeHorizontal(startX4, endX4, centerY4);
        driver.findElement(By.xpath("//android.view.View[@content-desc='10 July 2025']")).click();

        driver.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();

        // Select Check-out date (Horizontal swipe)
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='search_select_checkout']")).click();


        driver.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();

        // Number of Rooms
        driver.findElement(By.xpath("//android.widget.TextView[@text='No. Of Room']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='1-One']")).click();

        // Number of Adults
        driver.findElement(By.xpath("//android.widget.TextView[@text='No. Of Adults']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='1-One']")).click();

        // Number of Children
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='search_no_of_children']")).sendKeys("1");

        // Click Search Button
        driver.findElement(By.xpath("//android.view.ViewGroup[@resource-id='search_button']")).click();
    }

   
    public static void swipeVertical(int x, int startY, int endY) {
        PointerInput finger = new PointerInput(Kind.TOUCH, "finger1");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, startY));
        swipe.addAction(finger.createPointerDown(MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), x, endY));
        swipe.addAction(finger.createPointerUp(MouseButton.LEFT.asArg()));
        ((RemoteWebDriver) driver).perform(Arrays.asList(swipe));
    }


    public static void swipeHorizontal(int startX, int endX, int y) {
        PointerInput finger = new PointerInput(Kind.TOUCH, "finger1");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, y));
        swipe.addAction(finger.createPointerDown(MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX, y));
        swipe.addAction(finger.createPointerUp(MouseButton.LEFT.asArg()));
        ((RemoteWebDriver) driver).perform(Arrays.asList(swipe));
    }


    public static void printSelectHotelText() throws InterruptedException {
        WebElement textSelectHotel = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='select_hotel_text']"));
        System.out.println(textSelectHotel.getText());
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //android.widget.HorizontalScrollView[@resource-id="select_hotel_sort_by"]
        By clickDescending = By.xpath("//android.view.ViewGroup[@resource-id='select_hotel_sort_by']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickDescending));
        Thread.sleep(1000);
        WebElement selectIndateFlatList = driver.findElement(clickDescending);
        Rectangle rect4 = selectIndateFlatList.getRect();


        int width4 = rect4.getWidth();
        int height4 = rect4.getHeight();
        int x4 = rect4.getX();
        int y4 = rect4.getY();

        int startX4 = (int) ((width4 * 0.90) + x4);
        int endX4 = (int) ((width4 * 0.10) + x4);
        int centerY4 = height4 / 2 + y4;
        
        System.out.println("Swipe from X: " + startX4 + " to " + endX4 + " at Y: " + centerY4);

        swipeHorizontal(startX4, endX4, centerY4);
        
        WebElement clickNameDescending = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='filter_option_ndesc']"));
        clickNameDescending.click();

        By btnContinueLocator = By.xpath("(//android.view.ViewGroup[@resource-id='hotel_continue_button'])[2]");
        swipeToElement(btnContinueLocator);

        driver.findElement(btnContinueLocator).click();
        driver.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button2']")).click();
    }

    public static void swipe(int x, int startY, int endY) {
        PointerInput finger = new PointerInput(Kind.TOUCH, "finger1");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), Origin.viewport(), x, startY));
        swipe.addAction(finger.createPointerDown(MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), Origin.viewport(), x, endY));
        swipe.addAction(finger.createPointerUp(MouseButton.LEFT.asArg()));
        ((RemoteWebDriver) driver).perform(Arrays.asList(swipe));
    }

    public static void swipeToElement(By by) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        List<WebElement> elements = driver.findElements(by);
        while (elements.size() == 0) {
            Dimension size = driver.manage().window().getSize();
            int width = size.getWidth();
            int height = size.getHeight();
            int x = width / 2;
            int startY = (int) (height * 0.80);
            int endY = (int) (height * 0.20);
            swipe(x, startY, endY);
            elements = driver.findElements(by);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    private static void selectHotelName() {
    	
    	By hotelNameLocator = By.xpath("//android.widget.TextView[@resource-id='hotel_name']");

    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    	
    	WebElement hotelName = wait.until(ExpectedConditions.visibilityOfElementLocated(hotelNameLocator));

    	String name = hotelName.getText(); 
    	System.out.println("Hotel Name: " + name);
        
       
    }

    private static void addGuestDetails() {
        By ddnMySelf = By.xpath("//android.widget.TextView[@text='Myself']");
        swipeToElement(ddnMySelf);
        driver.findElement(ddnMySelf).click();

        driver.findElement(By.xpath("//android.widget.TextView[@text='Select Salutation']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Mr.']")).click();

        driver.findElement(By.xpath("//android.widget.EditText[@content-desc='book_hotel_first_name']")).sendKeys("Ajith");
        driver.findElement(By.xpath("//android.widget.EditText[@content-desc='book_hotel_last_name']")).sendKeys("kumar");

        By txtMobile = By.xpath("//*[@content-desc='book_hotel_mobile_no']");
        swipeToElement(txtMobile);
        driver.findElement(txtMobile).sendKeys("8754564567");

        By txtGmail = By.xpath("//android.widget.EditText[@content-desc='book_hotel_email']");
        swipeToElement(txtGmail);
        driver.findElement(txtGmail).sendKeys("aji@gmail.com");
    }

    private static void addGstDetails() {
        By btnGSTSwip = By.xpath("//android.view.ViewGroup[@resource-id='book_hotel_enter_gst']/android.widget.ImageView");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(btnGSTSwip)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@content-desc='book_hotel_registration']"))).sendKeys("9043592058");
        driver.findElement(By.xpath("//android.widget.EditText[@content-desc='book_hotel_company_name']")).sendKeys("Greens Tech OMR Branch");

        By txtCompanyAddress = By.xpath("//android.widget.EditText[@content-desc='book_hotel_company_address']");
        swipeToElement(txtCompanyAddress);
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtCompanyAddress)).sendKeys("Thoraipakkam");

        driver.findElement(By.xpath("//android.view.ViewGroup[@resource-id='book_hotel_next_button']")).click();
    }

    private static void addSpecilaReq() {
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id='filter_option_smoking']")).click();
        driver.findElement(By.xpath("//android.view.ViewGroup[@resource-id='book_hotel_next_button']")).click();
    }

    private static void addPayment() {
   

            
	    	By gstIconLocator = By.xpath("//android.widget.TextView[@text='Credit/Debit/ATM Card']");
	    	WebElement gstIcon = driver.findElement(gstIconLocator);
	    	gstIcon.click();


        	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        	 
        	 SupportsContextSwitching contextDriver = (SupportsContextSwitching) driver;

        	 String currentContext = contextDriver.getContext();
        	 System.out.println("Current context before switching: " + currentContext);

        	 Set<String> contextHandles = contextDriver.getContextHandles();
        	 for (String contextName : contextHandles) {
        	     System.out.println("Available context: " + contextName);
        	     if (contextName.contains("WEBVIEW")) {
        	         contextDriver.context(contextName);  // Switch to WebView
        	         System.out.println("Switched to context: " + contextName);
        	         break;
        	     }
        	 }

//            By webCard = By.xpath("//div[text()='Credit/Debit/ATM Card']");
            WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(15));
//            wait2.until(ExpectedConditions.elementToBeClickable(webCard)).click();

            driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Debit Card']")).click();

            By btnSelectCardBy = By.xpath("//android.view.View[@resource-id='card_type']");
            swipeToElement(btnSelectCardBy);
            wait2.until(ExpectedConditions.elementToBeClickable(btnSelectCardBy)).click();

            driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Visa']")).click();
            driver.findElement(By.xpath("//android.widget.EditText[@resource-id='card_no']")).sendKeys("5555555555552222");
            driver.findElement(By.xpath("//android.widget.EditText[@resource-id='card_name']")).sendKeys("Ajith");

            wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@resource-id='card_month']"))).click();
            driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='August']")).click();

            driver.findElement(By.xpath("//android.view.View[@resource-id='card_year']")).click();
            driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='2028']")).click();

            driver.findElement(By.xpath("//android.widget.EditText[@resource-id='cvv']")).sendKeys("345");

            By btnSubmit = By.xpath("//android.widget.Button[@resource-id='submitBtn']");
            swipeToElement(btnSubmit);
            driver.findElement(btnSubmit).click();

       
    }

    private static void getOrderId() {
        WebElement textBookinId = driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Booking is Confirmed')]"));
        System.out.println(textBookinId.getText());
    }

    public static void main(String[] args) throws InterruptedException {
        appLaunch();
        login();
        searchHotels();
        printSelectHotelText();
        selectHotelName();
        addGuestDetails();
        addGstDetails();
        addSpecilaReq();
        addPayment();
        getOrderId();
    }
}
