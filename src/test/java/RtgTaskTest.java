import io.restassured.RestAssured;
import pages.*;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojoClasses.UserDetails;

import static io.restassured.RestAssured.given;

public class RtgTaskTest extends TestCase {

   @Test
    public void NavigateToLoginPage(){
    new LoginPage(driver).Navigate()
            .EnterUserName("standard_user")
            .EnterPassword("secret_sauce")
            .ClickLoginButton();
    }
    @Test (dependsOnMethods = {"NavigateToLoginPage"})
    public void addProductsFromProductPage(){
        new ProductPage(driver).AddProduct1()
                .ScrollToProduct2();
    }

    @Test (dependsOnMethods = {"NavigateToLoginPage", "addProductsFromProductPage"})
    public void addProductFromProductDetailsPage(){
        new ProductDetailsPage(driver).AddToCart();
        String ActualAddedProductNumber = new ProductDetailsPage(driver).GetAddedProductNumber();
        String ExpectedAddedProductNumber = "2";
        Assert.assertEquals(ActualAddedProductNumber,ExpectedAddedProductNumber);
        new ProductDetailsPage(driver).MovedToCardPage();
    }

    @Test (dependsOnMethods = {"NavigateToLoginPage", "addProductsFromProductPage", "addProductFromProductDetailsPage"})
        public void VerifyThatProductsAddedToCart(){
        new CartPage(driver).VerifyThatProductDetailsIsDisplayed();
    }

    @Test (dependsOnMethods = {"NavigateToLoginPage", "addProductsFromProductPage", "addProductFromProductDetailsPage"})
    public void VerifyThatProductDetailsIsDisplayed(){
        boolean ActualProductDetails = new CartPage(driver).VerifyThatProductDetailsIsDisplayed();
        Assert.assertTrue(ActualProductDetails);
    }
    @Test (dependsOnMethods = {"NavigateToLoginPage", "addProductsFromProductPage", "addProductFromProductDetailsPage", "VerifyThatProductsAddedToCart"})
    public void MovedToCardPage(){
        String ExpectedUrl = "https://www.saucedemo.com/checkout-step-one.html";
       new CartPage(driver).MovedToCheckOutPage();
        String ActualUrl = driver.getCurrentUrl();
        Assert.assertEquals(ActualUrl,ExpectedUrl);
    }


    @Test(dependsOnMethods = {"NavigateToLoginPage", "addProductsFromProductPage", "addProductFromProductDetailsPage", "VerifyThatProductsAddedToCart",  "MovedToCardPage"})
    public void AddDetailsToCheckOutPage() {

       // this is simple things
        // API call to get mock data
//        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/users/1");
//        String firstName = response.jsonPath().getString("name").split(" ")[0];
//        String lastName = response.jsonPath().getString("name").split(" ")[1];
//        String postalCode = response.jsonPath().getString("address.zipcode");
//
//        // Use fetched data in the test
//        new CheckOutStep1(driver).EnterFirstName(firstName)
//                .EnterLastName(lastName)
//                .EnterPostalCode(postalCode)
//                .ClickContinue();

        // get data with pojo class

        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/users/1");
        UserDetails user = response.as(UserDetails.class);

        String[] nameParts = user.getName().split(" ");
        String firstName = nameParts[0];
        String lastName = nameParts[1];
        String zipcode = user.getAddress().getZipcode();

// Use the extracted data
        new CheckOutStep1(driver).EnterFirstName(firstName)
                .EnterLastName(lastName)
                .EnterPostalCode(zipcode)
                .ClickContinue();
    }

    @Test(dependsOnMethods = {"NavigateToLoginPage", "addProductsFromProductPage", "addProductFromProductDetailsPage", "VerifyThatProductsAddedToCart",  "MovedToCardPage", "AddDetailsToCheckOutPage"})
    public void CheckOrderDetailsIsDisplayed() {
        boolean ActualOrderDetails = new CheckOutStep2(driver).VerifyThatOrderDetailsIsDisplayed();
        Assert.assertTrue(ActualOrderDetails);
        new CheckOutStep2(driver).ClickFinish();
    }

    @Test(dependsOnMethods = {"NavigateToLoginPage", "addProductsFromProductPage", "addProductFromProductDetailsPage", "VerifyThatProductsAddedToCart",  "MovedToCardPage", "AddDetailsToCheckOutPage"})
    public void VerifyThatFinishPageIsDisplayed() {
        boolean ActualFinishPage = new CompletePage(driver).FinishPage();
        Assert.assertTrue(ActualFinishPage);
        String ActualUrl = driver.getCurrentUrl();
        String ExpectedUrl = "https://www.saucedemo.com/checkout-complete.html";
        Assert.assertEquals(ActualUrl,ExpectedUrl);
    }







}
