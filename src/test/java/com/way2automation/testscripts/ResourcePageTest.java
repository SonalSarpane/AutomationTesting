package com.way2automation.testscripts;

import com.way2automation.base.BaseTest;
import com.way2automation.pages.ResourcePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ResourcePageTest extends BaseTest {

    private ResourcePage resourcepage;

    @BeforeMethod
    public void init() {
        resourcepage = new ResourcePage(driver);
    }

    @Test(priority = 1)
    public void validateCustomer() throws Throwable {
        String firstName = "Shri";
        String lastName = "Alle";
        String postalCode = "413005";
        String name = resourcepage.validateCustomer(firstName, lastName, postalCode);

        //Here, I have added static import for Assert, so we don't need to write Assert.assertEquals ever time, just call the methods
        assertEquals(firstName, name);
    }
}
