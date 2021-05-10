import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

//change EXPECTED_DATE in Utils.class before starting tests

public class Sunflower {

    static AndroidDriver<MobileElement> driver;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Motorola");
        caps.setCapability(MobileCapabilityType.UDID, "ZY227GKL8T");
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.samples.apps.sunflower");
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.google.samples.apps.sunflower.GardenActivity");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver<MobileElement>(url, caps);
    }

    @Test
    public void addSomePlants() throws Exception {
        MobileElement addPlant = driver.findElement(By.id("com.google.samples.apps.sunflower:id/add_plant"));
        addPlant.click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        MobileElement plantFromRecyclerView = (MobileElement) driver
                .findElementByAndroidUIAutomator("new UiScrollable("
                        + "new UiSelector().scrollable(true)).scrollIntoView("
                        + "new UiSelector().textContains(\"Avocado\"));");
        plantFromRecyclerView.click();
        MobileElement addButton = driver.findElement(By.id("com.google.samples.apps.sunflower:id/fab"));
        addButton.click();
        driver.navigate().back();
        plantFromRecyclerView = (MobileElement) driver
                .findElementByAndroidUIAutomator("new UiScrollable("
                        + "new UiSelector().scrollable(true)).scrollIntoView("
                        + "new UiSelector().textContains(\"Pear\"));");
        plantFromRecyclerView.click();
        addButton.click();
        driver.navigate().back();
        MobileElement myGardenButton = driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"My garden\"]"));
        myGardenButton.click();
        MobileElement myGardenElementOne = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Avocado\"]"));
        MobileElement myGardenElementSecond = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Pear\"]"));

        Assert.assertTrue(myGardenElementOne.isDisplayed());
        Assert.assertTrue(myGardenElementSecond.isDisplayed());
    }

    @Test
    public void openSomePlant() {
        MobileElement addPlant = driver.findElement(By.id("com.google.samples.apps.sunflower:id/add_plant"));
        addPlant.click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        MobileElement plantFromRecyclerView = (MobileElement) driver
                .findElementByAndroidUIAutomator("new UiScrollable("
                        + "new UiSelector().scrollable(true)).scrollIntoView("
                        + "new UiSelector().textContains(\"Avocado\"));");
        plantFromRecyclerView.click();
        MobileElement plantName = driver.findElement(By.id("com.google.samples.apps.sunflower:id/plant_detail_name"));
        MobileElement plantDescription = driver.findElement(By.id("com.google.samples.apps.sunflower:id/plant_description"));
        String descriptionExpected = Utils.AVOCADO_DESCRIPTION;

        Assert.assertEquals(plantName.getText(), Utils.EXPECTED_PLANT_NAME);
        Assert.assertEquals(plantDescription.getText(), descriptionExpected);
    }

    @Test
    public void openPear() {
        MobileElement addPlant = driver.findElement(By.id("com.google.samples.apps.sunflower:id/add_plant"));
        addPlant.click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        MobileElement plantFromRecyclerView = (MobileElement) driver
                .findElementByAndroidUIAutomator("new UiScrollable("
                        + "new UiSelector().scrollable(true)).scrollIntoView("
                        + "new UiSelector().textContains(\"Pear\"));");
        plantFromRecyclerView.click();
        MobileElement plantWatering = driver.findElement(By.id("com.google.samples.apps.sunflower:id/plant_watering"));

        Assert.assertEquals(plantWatering.getText(), Utils.EXPECTED_PLANT_WATERING_CYCLE);
    }

    @Test
    public void verifyDescriptionAndShare() {
        MobileElement addPlant = driver.findElement(By.id("com.google.samples.apps.sunflower:id/add_plant"));
        addPlant.click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        MobileElement plantFromRecyclerView = (MobileElement) driver
                .findElementByAndroidUIAutomator("new UiScrollable("
                        + "new UiSelector().scrollable(true)).scrollIntoView("
                        + "new UiSelector().textContains(\"Avocado\"));");
        plantFromRecyclerView.click();
        MobileElement plantDescription = driver.findElement(By.id("com.google.samples.apps.sunflower:id/plant_description"));
        MobileElement shareButton = driver.findElement(By.id("com.google.samples.apps.sunflower:id/action_share"));
        String descriptionExpected = Utils.AVOCADO_DESCRIPTION;

        Assert.assertEquals(plantDescription.getText(), descriptionExpected);
        Assert.assertTrue(shareButton.isDisplayed());
    }

    @Test
    public void verifyAddedPlant() throws Exception {
        MobileElement addPlant = driver.findElement(By.id("com.google.samples.apps.sunflower:id/add_plant"));
        addPlant.click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        MobileElement plantFromRecyclerView = (MobileElement) driver
                .findElementByAndroidUIAutomator("new UiScrollable("
                        + "new UiSelector().scrollable(true)).scrollIntoView("
                        + "new UiSelector().textContains(\"Avocado\"));");
        plantFromRecyclerView.click();
        MobileElement addButton = driver.findElement(By.id("com.google.samples.apps.sunflower:id/fab"));
        addButton.click();
        driver.navigate().back();
        MobileElement myGardenButton = driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"My garden\"]"));
        myGardenButton.click();
        MobileElement myGardenElement = driver.findElement(By.xpath("//androidx.cardview.widget.CardView/android.view.ViewGroup"));
        MobileElement plantPicture = myGardenElement.findElement(By.id("com.google.samples.apps.sunflower:id/imageView"));
        MobileElement plantName = myGardenElement.findElement(By.id("com.google.samples.apps.sunflower:id/plant_name"));
        MobileElement plantWhenPlanted = myGardenElement.findElement(By.id("com.google.samples.apps.sunflower:id/plant_date"));
        MobileElement plantWhenWatered = myGardenElement.findElement(By.id("com.google.samples.apps.sunflower:id/water_date"));

        Assert.assertTrue(plantPicture.isDisplayed());
        Assert.assertEquals(plantName.getText(), Utils.EXPECTED_PLANT_NAME);
        Assert.assertEquals(plantWhenPlanted.getText(), Utils.EXPECTED_DATE);
        Assert.assertEquals(plantWhenWatered.getText(), Utils.EXPECTED_DATE);
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }
}
